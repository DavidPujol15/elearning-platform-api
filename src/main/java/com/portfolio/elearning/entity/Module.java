package com.portfolio.elearning.entity;

import com.portfolio.elearning.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "modules",
        indexes = {
                @Index(name = "idx_module_course", columnList = "course_id"),
                @Index(name = "idx_module_order", columnList = "course_id, order_index")
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = {"course", "lessons"})
@EqualsAndHashCode(callSuper = true, exclude = {"course", "lessons"})
public class Module extends BaseEntity {

    @Column(nullable = false, length = 200)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "order_index", nullable = false)
    private Integer orderIndex = 0;

    @Column(name = "duration_minutes")
    private Integer durationMinutes;

    @Column(name = "is_preview_enabled")
    private Boolean isPreviewEnabled = false;

    // Relationships
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @OneToMany(mappedBy = "module", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, orphanRemoval = true)
    @OrderBy("orderIndex ASC")
    private Set<Lesson> lessons = new HashSet<>();

    // Helper methods
    public int getTotalLessons() {
        return lessons.size();
    }

    public int getTotalDuration() {
        return lessons.stream()
                .mapToInt(Lesson::getDurationMinutes)
                .sum();
    }

    public void addLesson(Lesson lesson) {
        lessons.add(lesson);
        lesson.setModule(this);
    }

    public void removeLesson(Lesson lesson) {
        lessons.remove(lesson);
        lesson.setModule(null);
    }
}
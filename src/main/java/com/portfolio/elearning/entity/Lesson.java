package com.portfolio.elearning.entity;

import com.portfolio.elearning.entity.base.BaseEntity;
import com.portfolio.elearning.entity.enums.LessonType;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "lessons",
        indexes = {
                @Index(name = "idx_lesson_module", columnList = "module_id"),
                @Index(name = "idx_lesson_order", columnList = "module_id, order_index")
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = {"module", "progress"})
@EqualsAndHashCode(callSuper = true, exclude = {"module", "progress"})
public class Lesson extends BaseEntity {

    @Column(nullable = false, length = 200)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "lesson_type", nullable = false, length = 20)
    private LessonType lessonType = LessonType.VIDEO;

    @Column(name = "content_url")
    private String contentUrl;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(name = "order_index", nullable = false)
    private Integer orderIndex = 0;

    @Column(name = "duration_minutes")
    private Integer durationMinutes = 0;

    @Column(name = "is_preview_enabled")
    private Boolean isPreviewEnabled = false;

    @Column(name = "is_mandatory")
    private Boolean isMandatory = true;

    @ElementCollection
    @CollectionTable(name = "lesson_resources",
            joinColumns = @JoinColumn(name = "lesson_id"))
    @Column(name = "resource_url")
    private Set<String> resourceUrls = new HashSet<>();

    // Relationships
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "module_id", nullable = false)
    private Module module;

    @OneToMany(mappedBy = "lesson", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Progress> progress = new HashSet<>();

    // Helper methods
    public boolean isCompleted(User user) {
        return progress.stream()
                .anyMatch(p -> p.getUser().equals(user) && p.getCompleted());
    }
}
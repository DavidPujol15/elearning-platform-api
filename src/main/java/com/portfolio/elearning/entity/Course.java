package com.portfolio.elearning.entity;

import com.portfolio.elearning.entity.base.BaseEntity;
import com.portfolio.elearning.entity.enums.CourseLevel;
import com.portfolio.elearning.entity.enums.CourseStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Formula;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "courses",
        indexes = {
                @Index(name = "idx_course_status", columnList = "status"),
                @Index(name = "idx_course_level", columnList = "level"),
                @Index(name = "idx_course_price", columnList = "price"),
                @Index(name = "idx_course_instructor", columnList = "instructor_id"),
                @Index(name = "idx_course_category", columnList = "category_id")
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = {"modules", "enrollments", "reviews"})
@EqualsAndHashCode(callSuper = true, exclude = {"modules", "enrollments", "reviews"})
public class Course extends BaseEntity {

    @Column(nullable = false, length = 200)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "short_description", length = 500)
    private String shortDescription;

    @Column(name = "thumbnail_url")
    private String thumbnailUrl;

    @Column(name = "preview_video_url")
    private String previewVideoUrl;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price = BigDecimal.ZERO;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private CourseLevel level = CourseLevel.BEGINNER;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private CourseStatus status = CourseStatus.DRAFT;

    @Column(name = "duration_hours")
    private Integer durationHours;

    @ElementCollection
    @CollectionTable(name = "course_requirements",
            joinColumns = @JoinColumn(name = "course_id"))
    @Column(name = "requirement")
    private Set<String> requirements = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "course_objectives",
            joinColumns = @JoinColumn(name = "course_id"))
    @Column(name = "objective")
    private Set<String> objectives = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "course_tags",
            joinColumns = @JoinColumn(name = "course_id"))
    @Column(name = "tag")
    private Set<String> tags = new HashSet<>();

    // Calculated fields
    @Formula("(SELECT COUNT(*) FROM enrollments e WHERE e.course_id = id AND e.status = 'ACTIVE')")
    private Integer enrollmentCount;

    @Formula("(SELECT AVG(r.rating) FROM reviews r WHERE r.course_id = id)")
    private Double averageRating;

    @Formula("(SELECT COUNT(*) FROM reviews r WHERE r.course_id = id)")
    private Integer reviewCount;

    // Relationships
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instructor_id", nullable = false)
    private User instructor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, orphanRemoval = true)
    @OrderBy("orderIndex ASC")
    private Set<Module> modules = new HashSet<>();

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Enrollment> enrollments = new HashSet<>();

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Review> reviews = new HashSet<>();

    // Helper methods
    public boolean isPublished() {
        return status == CourseStatus.PUBLISHED;
    }

    public boolean isFree() {
        return price.compareTo(BigDecimal.ZERO) == 0;
    }

    public int getTotalLessons() {
        return modules.stream()
                .mapToInt(module -> module.getLessons().size())
                .sum();
    }

    public void addModule(Module module) {
        modules.add(module);
        module.setCourse(this);
    }

    public void removeModule(Module module) {
        modules.remove(module);
        module.setCourse(null);
    }
}

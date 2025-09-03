package com.portfolio.elearning.entity;

import com.portfolio.elearning.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "reviews",
        indexes = {
                @Index(name = "idx_review_course", columnList = "course_id"),
                @Index(name = "idx_review_student", columnList = "student_id"),
                @Index(name = "idx_review_rating", columnList = "rating")
        },
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_review_student_course",
                        columnNames = {"student_id", "course_id"})
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = {"student", "course"})
@EqualsAndHashCode(callSuper = true, exclude = {"student", "course"})
public class Review extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    private User student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @Column(nullable = false)
    private Integer rating; // 1-5 stars

    @Column(length = 200)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String comment;

    @Column(name = "helpful_count")
    private Integer helpfulCount = 0;

    @Column(name = "reported")
    private Boolean reported = false;

    @Column(name = "verified_purchase")
    private Boolean verifiedPurchase = true;

    @Column(name = "instructor_response", columnDefinition = "TEXT")
    private String instructorResponse;

    @Column(name = "instructor_response_date")
    private LocalDateTime instructorResponseDate;

    @Column(name = "would_recommend")
    private Boolean wouldRecommend = true;

    // What the student liked
    @ElementCollection
    @CollectionTable(name = "review_pros",
            joinColumns = @JoinColumn(name = "review_id"))
    @Column(name = "pro")
    private Set<String> pros = new HashSet<>();

    // What could be improved
    @ElementCollection
    @CollectionTable(name = "review_cons",
            joinColumns = @JoinColumn(name = "review_id"))
    @Column(name = "con")
    private Set<String> cons = new HashSet<>();

    // Validation
    @PrePersist
    @PreUpdate
    public void validateRating() {
        if (rating < 1 || rating > 5) {
            throw new IllegalArgumentException("Rating must be between 1 and 5");
        }
    }

    // Helper methods
    public boolean isPositive() {
        return rating >= 4;
    }

    public boolean isNegative() {
        return rating <= 2;
    }

    public boolean hasInstructorResponse() {
        return instructorResponse != null && !instructorResponse.isEmpty();
    }
}
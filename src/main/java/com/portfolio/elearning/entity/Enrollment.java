package com.portfolio.elearning.entity;

import com.portfolio.elearning.entity.base.BaseEntity;
import com.portfolio.elearning.entity.enums.EnrollmentStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Formula;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "enrollments",
        indexes = {
                @Index(name = "idx_enrollment_student", columnList = "student_id"),
                @Index(name = "idx_enrollment_course", columnList = "course_id"),
                @Index(name = "idx_enrollment_status", columnList = "status")
        },
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_enrollment_student_course",
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
public class Enrollment extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    private User student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @Column(name = "enrolled_at", nullable = false)
    private LocalDateTime enrolledAt;

    @Column(name = "completed_at")
    private LocalDateTime completedAt;

    @Column(name = "expiry_date")
    private LocalDateTime expiryDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private EnrollmentStatus status = EnrollmentStatus.ACTIVE;

    @Column(name = "progress_percentage")
    private Integer progressPercentage = 0;

    @Column(name = "last_accessed_at")
    private LocalDateTime lastAccessedAt;

    @Column(name = "payment_amount", precision = 10, scale = 2)
    private BigDecimal paymentAmount;

    @Column(name = "payment_method", length = 50)
    private String paymentMethod;

    @Column(name = "transaction_id", length = 100)
    private String transactionId;

    @Column(name = "certificate_issued")
    private Boolean certificateIssued = false;

    @Column(name = "certificate_url")
    private String certificateUrl;

    @Column(name = "certificate_issued_at")
    private LocalDateTime certificateIssuedAt;

    // Calculated field for completed lessons count
    @Formula("(SELECT COUNT(DISTINCT p.lesson_id) FROM progress p " +
            "JOIN lessons l ON p.lesson_id = l.id " +
            "JOIN modules m ON l.module_id = m.id " +
            "WHERE p.user_id = student_id " +
            "AND m.course_id = course_id " +
            "AND p.completed = true)")
    private Integer completedLessonsCount;

    // Helper methods
    @PrePersist
    public void prePersist() {
        if (enrolledAt == null) {
            enrolledAt = LocalDateTime.now();
        }
        if (lastAccessedAt == null) {
            lastAccessedAt = LocalDateTime.now();
        }
    }

    public boolean isActive() {
        return status == EnrollmentStatus.ACTIVE;
    }

    public boolean isCompleted() {
        return status == EnrollmentStatus.COMPLETED;
    }

    public boolean isExpired() {
        if (expiryDate == null) {
            return false;
        }
        return LocalDateTime.now().isAfter(expiryDate);
    }

    public void updateProgress(int completedLessons, int totalLessons) {
        if (totalLessons > 0) {
            this.progressPercentage = (completedLessons * 100) / totalLessons;
            if (this.progressPercentage >= 100) {
                this.status = EnrollmentStatus.COMPLETED;
                this.completedAt = LocalDateTime.now();
            }
        }
    }
}
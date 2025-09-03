package com.portfolio.elearning.entity;

import com.portfolio.elearning.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "progress",
        indexes = {
                @Index(name = "idx_progress_user", columnList = "user_id"),
                @Index(name = "idx_progress_lesson", columnList = "lesson_id"),
                @Index(name = "idx_progress_completed", columnList = "completed")
        },
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_progress_user_lesson",
                        columnNames = {"user_id", "lesson_id"})
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = {"user", "lesson"})
@EqualsAndHashCode(callSuper = true, exclude = {"user", "lesson"})
public class Progress extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lesson_id", nullable = false)
    private Lesson lesson;

    @Column(nullable = false)
    private Boolean completed = false;

    @Column(name = "started_at")
    private LocalDateTime startedAt;

    @Column(name = "completed_at")
    private LocalDateTime completedAt;

    @Column(name = "last_position")
    private Integer lastPosition; // For video lessons - seconds watched

    @Column(name = "watch_time")
    private Integer watchTime; // Total seconds watched

    @Column(name = "completion_percentage")
    private Integer completionPercentage = 0;

    @Column(columnDefinition = "TEXT")
    private String notes; // Student's personal notes for the lesson

    @Column(name = "attempt_count")
    private Integer attemptCount = 1; // For quiz type lessons

    @Column(name = "score")
    private Integer score; // For quiz/assignment type lessons

    @Column(name = "max_score")
    private Integer maxScore; // For quiz/assignment type lessons

    // Helper methods
    @PrePersist
    public void prePersist() {
        if (startedAt == null) {
            startedAt = LocalDateTime.now();
        }
    }

    public void markAsCompleted() {
        this.completed = true;
        this.completedAt = LocalDateTime.now();
        this.completionPercentage = 100;
    }

    public void updateWatchProgress(int currentPosition, int totalDuration) {
        this.lastPosition = currentPosition;
        if (totalDuration > 0) {
            this.completionPercentage = (currentPosition * 100) / totalDuration;
            if (this.completionPercentage >= 90) { // Consider completed at 90%
                markAsCompleted();
            }
        }
    }
}
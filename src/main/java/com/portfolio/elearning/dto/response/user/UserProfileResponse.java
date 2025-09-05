package com.portfolio.elearning.dto.response.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(description = "Detailed user profile response")
public class UserProfileResponse {

    @Schema(description = "User information")
    private UserResponse user;

    @Schema(description = "Recent activities")
    private List<ActivityResponse> recentActivities;

    @Schema(description = "Achievements")
    private List<AchievementResponse> achievements;

    @Schema(description = "Learning statistics")
    private LearningStatsResponse learningStats;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ActivityResponse {
        private String type;
        private String description;
        private LocalDateTime timestamp;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AchievementResponse {
        private String title;
        private String description;
        private String iconUrl;
        private LocalDateTime earnedAt;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class LearningStatsResponse {
        private Integer totalLearningHours;
        private Integer currentStreak;
        private Integer longestStreak;
        private Double completionRate;
        private Integer lessonsCompleted;
    }
}
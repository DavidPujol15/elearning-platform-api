package com.portfolio.elearning.dto.response.progress;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(description = "Progress information response")
public class ProgressResponse {

    @Schema(description = "Progress ID")
    private Long id;

    @Schema(description = "User ID")
    private Long userId;

    @Schema(description = "Lesson ID")
    private Long lessonId;

    @Schema(description = "Lesson title")
    private String lessonTitle;

    @Schema(description = "Module title")
    private String moduleTitle;

    @Schema(description = "Completion status")
    private Boolean completed;

    @Schema(description = "Started at")
    private LocalDateTime startedAt;

    @Schema(description = "Completed at")
    private LocalDateTime completedAt;

    @Schema(description = "Last position in seconds")
    private Integer lastPosition;

    @Schema(description = "Total watch time in seconds")
    private Integer watchTime;

    @Schema(description = "Completion percentage")
    private Integer completionPercentage;

    @Schema(description = "Student notes")
    private String notes;

    @Schema(description = "Number of attempts")
    private Integer attemptCount;

    @Schema(description = "Score achieved")
    private Integer score;

    @Schema(description = "Maximum possible score")
    private Integer maxScore;
}
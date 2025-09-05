package com.portfolio.elearning.dto.request.progress;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Progress update request")
public class ProgressUpdateRequest {

    @Schema(description = "Mark lesson as completed", example = "true")
    private Boolean completed;

    @Min(value = 0, message = "Last position cannot be negative")
    @Schema(description = "Last position in seconds for video lessons", example = "120")
    private Integer lastPosition;

    @Min(value = 0, message = "Watch time cannot be negative")
    @Schema(description = "Total watch time in seconds", example = "300")
    private Integer watchTime;

    @Min(value = 0, message = "Completion percentage cannot be negative")
    @Max(value = 100, message = "Completion percentage cannot exceed 100")
    @Schema(description = "Completion percentage", example = "75")
    private Integer completionPercentage;

    @Schema(description = "Student's notes for the lesson")
    private String notes;

    @Min(value = 0, message = "Score cannot be negative")
    @Schema(description = "Quiz/assignment score", example = "85")
    private Integer score;

    @Min(value = 0, message = "Max score cannot be negative")
    @Schema(description = "Maximum possible score", example = "100")
    private Integer maxScore;
}
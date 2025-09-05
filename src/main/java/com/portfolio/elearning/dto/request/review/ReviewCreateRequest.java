package com.portfolio.elearning.dto.request.review;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Review creation request")
public class ReviewCreateRequest {

    @NotNull(message = "Course ID is required")
    @Schema(description = "Course ID to review", example = "1")
    private Long courseId;

    @NotNull(message = "Rating is required")
    @Min(value = 1, message = "Rating must be at least 1")
    @Max(value = 5, message = "Rating cannot exceed 5")
    @Schema(description = "Rating from 1 to 5", example = "4")
    private Integer rating;

    @Size(max = 200, message = "Title cannot exceed 200 characters")
    @Schema(description = "Review title", example = "Great course for beginners!")
    private String title;

    @NotBlank(message = "Comment is required")
    @Size(min = 10, max = 5000, message = "Comment must be between 10 and 5000 characters")
    @Schema(description = "Review comment")
    private String comment;

    @Schema(description = "Would recommend this course", example = "true")
    private Boolean wouldRecommend = true;

    @Size(max = 5, message = "Maximum 5 pros allowed")
    @Schema(description = "What you liked about the course")
    private Set<String> pros;

    @Size(max = 5, message = "Maximum 5 cons allowed")
    @Schema(description = "What could be improved")
    private Set<String> cons;
}
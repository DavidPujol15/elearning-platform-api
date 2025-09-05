package com.portfolio.elearning.dto.request.review;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Review update request")
public class ReviewUpdateRequest {

    @Min(value = 1, message = "Rating must be at least 1")
    @Max(value = 5, message = "Rating cannot exceed 5")
    @Schema(description = "Rating from 1 to 5")
    private Integer rating;

    @Size(max = 200, message = "Title cannot exceed 200 characters")
    @Schema(description = "Review title")
    private String title;

    @Size(min = 10, max = 5000, message = "Comment must be between 10 and 5000 characters")
    @Schema(description = "Review comment")
    private String comment;

    @Schema(description = "Would recommend this course")
    private Boolean wouldRecommend;

    @Size(max = 5, message = "Maximum 5 pros allowed")
    @Schema(description = "What you liked about the course")
    private Set<String> pros;

    @Size(max = 5, message = "Maximum 5 cons allowed")
    @Schema(description = "What could be improved")
    private Set<String> cons;
}
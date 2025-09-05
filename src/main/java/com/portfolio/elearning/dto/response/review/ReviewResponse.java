package com.portfolio.elearning.dto.response.review;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.portfolio.elearning.dto.response.user.UserResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(description = "Review information response")
public class ReviewResponse {

    @Schema(description = "Review ID")
    private Long id;

    @Schema(description = "Student information")
    private UserResponse student;

    @Schema(description = "Course ID")
    private Long courseId;

    @Schema(description = "Course title")
    private String courseTitle;

    @Schema(description = "Rating (1-5)")
    private Integer rating;

    @Schema(description = "Review title")
    private String title;

    @Schema(description = "Review comment")
    private String comment;

    @Schema(description = "Helpful votes count")
    private Integer helpfulCount;

    @Schema(description = "Verified purchase status")
    private Boolean verifiedPurchase;

    @Schema(description = "Would recommend")
    private Boolean wouldRecommend;

    @Schema(description = "Pros list")
    private Set<String> pros;

    @Schema(description = "Cons list")
    private Set<String> cons;

    @Schema(description = "Instructor response")
    private String instructorResponse;

    @Schema(description = "Instructor response date")
    private LocalDateTime instructorResponseDate;

    @Schema(description = "Review creation date")
    private LocalDateTime createdAt;

    @Schema(description = "Review update date")
    private LocalDateTime updatedAt;

    @Schema(description = "Is this review from current user")
    private Boolean isOwnReview;

    @Schema(description = "Has user marked this as helpful")
    private Boolean markedAsHelpful;
}
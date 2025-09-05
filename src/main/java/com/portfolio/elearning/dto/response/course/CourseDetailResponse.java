package com.portfolio.elearning.dto.response.course;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.portfolio.elearning.dto.response.module.ModuleResponse;
import com.portfolio.elearning.dto.response.review.ReviewResponse;
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
@Schema(description = "Detailed course information with modules and reviews")
public class CourseDetailResponse {

    @Schema(description = "Course information")
    private CourseResponse course;

    @Schema(description = "Course modules")
    private List<ModuleResponse> modules;

    @Schema(description = "Recent reviews")
    private List<ReviewResponse> recentReviews;

    @Schema(description = "Rating distribution")
    private RatingDistribution ratingDistribution;

    @Schema(description = "Related courses")
    private List<CourseResponse> relatedCourses;

    @Schema(description = "User enrollment status")
    private EnrollmentInfo enrollmentInfo;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RatingDistribution {
        private Integer fiveStars;
        private Integer fourStars;
        private Integer threeStars;
        private Integer twoStars;
        private Integer oneStar;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class EnrollmentInfo {
        private Boolean isEnrolled;
        private LocalDateTime enrolledAt;
        private Integer progressPercentage;
        private Boolean hasReviewed;
    }
}
package com.portfolio.elearning.dto.response.course;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.portfolio.elearning.dto.response.category.CategoryResponse;
import com.portfolio.elearning.dto.response.user.UserResponse;
import com.portfolio.elearning.entity.enums.CourseLevel;
import com.portfolio.elearning.entity.enums.CourseStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(description = "Course information response")
public class CourseResponse {

    @Schema(description = "Course ID")
    private Long id;

    @Schema(description = "Course title")
    private String title;

    @Schema(description = "Full description")
    private String description;

    @Schema(description = "Short description")
    private String shortDescription;

    @Schema(description = "Thumbnail URL")
    private String thumbnailUrl;

    @Schema(description = "Preview video URL")
    private String previewVideoUrl;

    @Schema(description = "Course price")
    private BigDecimal price;

    @Schema(description = "Course level")
    private CourseLevel level;

    @Schema(description = "Course status")
    private CourseStatus status;

    @Schema(description = "Duration in hours")
    private Integer durationHours;

    @Schema(description = "Course requirements")
    private Set<String> requirements;

    @Schema(description = "Learning objectives")
    private Set<String> objectives;

    @Schema(description = "Course tags")
    private Set<String> tags;

    @Schema(description = "Total enrolled students")
    private Integer enrollmentCount;

    @Schema(description = "Average rating")
    private Double averageRating;

    @Schema(description = "Total reviews")
    private Integer reviewCount;

    @Schema(description = "Total modules")
    private Integer moduleCount;

    @Schema(description = "Total lessons")
    private Integer lessonCount;

    @Schema(description = "Category information")
    private CategoryResponse category;

    @Schema(description = "Instructor information")
    private UserResponse instructor;

    @Schema(description = "Creation date")
    private LocalDateTime createdAt;

    @Schema(description = "Last update date")
    private LocalDateTime updatedAt;

    @Schema(description = "Is course free")
    private Boolean isFree;

    @Schema(description = "Has certificate")
    private Boolean hasCertificate;
}
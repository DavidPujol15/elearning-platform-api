package com.portfolio.elearning.dto.request.course;

import com.portfolio.elearning.entity.enums.CourseLevel;
import com.portfolio.elearning.entity.enums.CourseStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Course update request")
public class CourseUpdateRequest {

    @Size(min = 10, max = 200, message = "Title must be between 10 and 200 characters")
    @Schema(description = "Course title")
    private String title;

    @Size(min = 50, max = 5000, message = "Description must be between 50 and 5000 characters")
    @Schema(description = "Full course description")
    private String description;

    @Size(min = 20, max = 500, message = "Short description must be between 20 and 500 characters")
    @Schema(description = "Brief course description")
    private String shortDescription;

    @Schema(description = "Category ID")
    private Long categoryId;

    @Schema(description = "Course difficulty level")
    private CourseLevel level;

    @DecimalMin(value = "0.0", message = "Price cannot be negative")
    @DecimalMax(value = "9999.99", message = "Price cannot exceed 9999.99")
    @Schema(description = "Course price")
    private BigDecimal price;

    @Schema(description = "Course status")
    private CourseStatus status;

    @Min(value = 1, message = "Duration must be at least 1 hour")
    @Max(value = 500, message = "Duration cannot exceed 500 hours")
    @Schema(description = "Course duration in hours")
    private Integer durationHours;

    @Schema(description = "Course thumbnail URL")
    private String thumbnailUrl;

    @Schema(description = "Preview video URL")
    private String previewVideoUrl;

    @Size(max = 10, message = "Maximum 10 requirements allowed")
    @Schema(description = "Course requirements")
    private Set<String> requirements;

    @Size(max = 10, message = "Maximum 10 objectives allowed")
    @Schema(description = "Learning objectives")
    private Set<String> objectives;

    @Size(max = 20, message = "Maximum 20 tags allowed")
    @Schema(description = "Course tags")
    private Set<String> tags;
}
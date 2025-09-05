package com.portfolio.elearning.dto.request.course;

import com.portfolio.elearning.entity.enums.CourseLevel;
import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "Course search and filter criteria")
public class CourseFilterRequest {

    @Schema(description = "Search keyword", example = "spring boot")
    private String search;

    @Schema(description = "Category IDs")
    private Set<Long> categoryIds;

    @Schema(description = "Course levels")
    private Set<CourseLevel> levels;

    @Schema(description = "Minimum price", example = "0")
    private BigDecimal minPrice;

    @Schema(description = "Maximum price", example = "100")
    private BigDecimal maxPrice;

    @Schema(description = "Minimum rating", example = "4.0")
    private Double minRating;

    @Schema(description = "Instructor IDs")
    private Set<Long> instructorIds;

    @Schema(description = "Duration range in hours - minimum", example = "10")
    private Integer minDuration;

    @Schema(description = "Duration range in hours - maximum", example = "50")
    private Integer maxDuration;

    @Schema(description = "Include only free courses", example = "false")
    private Boolean freeOnly;

    @Schema(description = "Include only courses with certificate", example = "true")
    private Boolean withCertificate;

    @Schema(description = "Sort field", example = "createdAt")
    private String sortBy = "createdAt";

    @Schema(description = "Sort direction", example = "DESC")
    private String sortDirection = "DESC";
}
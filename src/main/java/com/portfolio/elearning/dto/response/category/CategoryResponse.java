package com.portfolio.elearning.dto.response.category;

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
@Schema(description = "Category information response")
public class CategoryResponse {

    @Schema(description = "Category ID")
    private Long id;

    @Schema(description = "Category name")
    private String name;

    @Schema(description = "URL-friendly slug")
    private String slug;

    @Schema(description = "Category description")
    private String description;

    @Schema(description = "Icon URL")
    private String iconUrl;

    @Schema(description = "Parent category ID")
    private Long parentId;

    @Schema(description = "Display order")
    private Integer displayOrder;

    @Schema(description = "Total courses in category")
    private Integer courseCount;

    @Schema(description = "Subcategories")
    private List<CategoryResponse> subcategories;

    @Schema(description = "Creation date")
    private LocalDateTime createdAt;
}
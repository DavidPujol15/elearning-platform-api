package com.portfolio.elearning.dto.request.category;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Category creation request")
public class CategoryCreateRequest {

    @NotBlank(message = "Category name is required")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    @Schema(description = "Category name", example = "Web Development")
    private String name;

    @Size(max = 500, message = "Description cannot exceed 500 characters")
    @Schema(description = "Category description")
    private String description;

    @Schema(description = "Icon URL for the category")
    private String iconUrl;

    @Schema(description = "Parent category ID for subcategories")
    private Long parentId;

    @Schema(description = "Display order", example = "1")
    private Integer displayOrder;
}
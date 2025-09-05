package com.portfolio.elearning.dto.request.module;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Module creation request")
public class ModuleCreateRequest {

    @NotNull(message = "Course ID is required")
    @Schema(description = "Course ID this module belongs to", example = "1")
    private Long courseId;

    @NotBlank(message = "Module title is required")
    @Size(min = 3, max = 200, message = "Title must be between 3 and 200 characters")
    @Schema(description = "Module title", example = "Introduction to Spring Boot")
    private String title;

    @Size(max = 1000, message = "Description cannot exceed 1000 characters")
    @Schema(description = "Module description")
    private String description;

    @Min(value = 0, message = "Order index cannot be negative")
    @Schema(description = "Module order in the course", example = "1")
    private Integer orderIndex;

    @Schema(description = "Enable preview for non-enrolled users", example = "false")
    private Boolean isPreviewEnabled = false;
}
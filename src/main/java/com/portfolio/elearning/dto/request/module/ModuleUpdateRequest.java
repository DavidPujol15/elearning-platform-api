package com.portfolio.elearning.dto.request.module;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Module update request")
public class ModuleUpdateRequest {

    @Size(min = 3, max = 200, message = "Title must be between 3 and 200 characters")
    @Schema(description = "Module title")
    private String title;

    @Size(max = 1000, message = "Description cannot exceed 1000 characters")
    @Schema(description = "Module description")
    private String description;

    @Min(value = 0, message = "Order index cannot be negative")
    @Schema(description = "Module order in the course")
    private Integer orderIndex;

    @Schema(description = "Enable preview for non-enrolled users")
    private Boolean isPreviewEnabled;
}
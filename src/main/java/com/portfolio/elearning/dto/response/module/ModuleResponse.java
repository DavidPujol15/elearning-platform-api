package com.portfolio.elearning.dto.response.module;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.portfolio.elearning.dto.response.lesson.LessonResponse;
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
@Schema(description = "Module information response")
public class ModuleResponse {

    @Schema(description = "Module ID")
    private Long id;

    @Schema(description = "Module title")
    private String title;

    @Schema(description = "Module description")
    private String description;

    @Schema(description = "Order index in course")
    private Integer orderIndex;

    @Schema(description = "Total duration in minutes")
    private Integer durationMinutes;

    @Schema(description = "Preview enabled status")
    private Boolean isPreviewEnabled;

    @Schema(description = "Total lessons in module")
    private Integer lessonCount;

    @Schema(description = "Completed lessons count")
    private Integer completedLessons;

    @Schema(description = "Module completion percentage")
    private Integer completionPercentage;

    @Schema(description = "Lessons in this module")
    private List<LessonResponse> lessons;

    @Schema(description = "Creation date")
    private LocalDateTime createdAt;

    @Schema(description = "Last update date")
    private LocalDateTime updatedAt;
}
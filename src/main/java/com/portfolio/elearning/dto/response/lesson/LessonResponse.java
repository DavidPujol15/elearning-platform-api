package com.portfolio.elearning.dto.response.lesson;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.portfolio.elearning.entity.enums.LessonType;
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
@Schema(description = "Lesson information response")
public class LessonResponse {

    @Schema(description = "Lesson ID")
    private Long id;

    @Schema(description = "Lesson title")
    private String title;

    @Schema(description = "Lesson description")
    private String description;

    @Schema(description = "Lesson type")
    private LessonType lessonType;

    @Schema(description = "Content URL")
    private String contentUrl;

    @Schema(description = "Text content")
    private String content;

    @Schema(description = "Order index in module")
    private Integer orderIndex;

    @Schema(description = "Duration in minutes")
    private Integer durationMinutes;

    @Schema(description = "Preview enabled status")
    private Boolean isPreviewEnabled;

    @Schema(description = "Mandatory for completion")
    private Boolean isMandatory;

    @Schema(description = "Resource URLs")
    private Set<String> resourceUrls;

    @Schema(description = "User's completion status")
    private Boolean isCompleted;

    @Schema(description = "User's progress percentage")
    private Integer progressPercentage;

    @Schema(description = "Last watched position (for videos)")
    private Integer lastPosition;

    @Schema(description = "Creation date")
    private LocalDateTime createdAt;

    @Schema(description = "Can user access this lesson")
    private Boolean canAccess;
}
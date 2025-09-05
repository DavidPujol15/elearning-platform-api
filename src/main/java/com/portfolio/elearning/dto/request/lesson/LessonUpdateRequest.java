package com.portfolio.elearning.dto.request.lesson;

import com.portfolio.elearning.entity.enums.LessonType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Lesson update request")
public class LessonUpdateRequest {

    @Size(min = 3, max = 200, message = "Title must be between 3 and 200 characters")
    @Schema(description = "Lesson title")
    private String title;

    @Size(max = 2000, message = "Description cannot exceed 2000 characters")
    @Schema(description = "Lesson description")
    private String description;

    @Schema(description = "Type of lesson")
    private LessonType lessonType;

    @Schema(description = "URL for video/resource content")
    private String contentUrl;

    @Schema(description = "Text content for text-based lessons")
    private String content;

    @Min(value = 0, message = "Order index cannot be negative")
    @Schema(description = "Lesson order in the module")
    private Integer orderIndex;

    @Min(value = 1, message = "Duration must be at least 1 minute")
    @Schema(description = "Lesson duration in minutes")
    private Integer durationMinutes;

    @Schema(description = "Enable preview for non-enrolled users")
    private Boolean isPreviewEnabled;

    @Schema(description = "Is this lesson mandatory for completion")
    private Boolean isMandatory;

    @Schema(description = "Additional resource URLs")
    private Set<String> resourceUrls;
}
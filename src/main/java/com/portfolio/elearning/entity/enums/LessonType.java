package com.portfolio.elearning.entity.enums;

public enum LessonType {
    VIDEO("Video"),
    TEXT("Text"),
    QUIZ("Quiz"),
    ASSIGNMENT("Assignment"),
    LIVE_SESSION("Live Session"),
    RESOURCE("Resource");

    private final String displayName;

    LessonType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
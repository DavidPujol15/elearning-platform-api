package com.portfolio.elearning.util;

public class Constants {

    // API Versioning
    public static final String API_VERSION_1 = "/api/v1";

    // Security
    public static final String AUTHORIZATION_HEADER = "Authorization";
    public static final String BEARER_PREFIX = "Bearer ";

    // Roles
    public static final String ROLE_ADMIN = "ROLE_ADMIN";
    public static final String ROLE_INSTRUCTOR = "ROLE_INSTRUCTOR";
    public static final String ROLE_STUDENT = "ROLE_STUDENT";

    // Pagination
    public static final String DEFAULT_PAGE_NUMBER = "0";
    public static final String DEFAULT_PAGE_SIZE = "20";
    public static final String DEFAULT_SORT_BY = "id";
    public static final String DEFAULT_SORT_DIRECTION = "ASC";

    // Validation
    public static final int MIN_PASSWORD_LENGTH = 8;
    public static final int MAX_PASSWORD_LENGTH = 100;
    public static final int MIN_USERNAME_LENGTH = 3;
    public static final int MAX_USERNAME_LENGTH = 50;

    // Business Rules
    public static final int MAX_COURSES_PER_INSTRUCTOR = 50;
    public static final int MAX_ENROLLMENTS_PER_STUDENT = 20;
    public static final double MIN_COURSE_PRICE = 0.0;
    public static final double MAX_COURSE_PRICE = 9999.99;

    private Constants() {
        throw new IllegalStateException("Utility class");
    }
}
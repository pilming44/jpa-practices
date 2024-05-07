package com.practice.jpa.enums;

public enum BookStatus {
    PLANNED_TO_PURCHASE("구매예정"),
    AVAILABLE_FOR_RENT("대여가능"),
    UNAVAILABLE_FOR_RENT("대여불가능");

    private final String description;

    BookStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}

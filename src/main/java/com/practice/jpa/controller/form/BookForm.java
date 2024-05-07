package com.practice.jpa.controller.form;

import com.practice.jpa.enums.BookStatus;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BookForm {
    private String title;
    private Long authorId;
    private Long publisherId;
    private BookStatus status;
}

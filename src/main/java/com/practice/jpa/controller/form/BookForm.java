package com.practice.jpa.controller.form;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BookForm {
    private String title;
    private Long authorId;
    private Long publisherId;
}

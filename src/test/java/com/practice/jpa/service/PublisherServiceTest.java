package com.practice.jpa.service;

import com.practice.jpa.entity.Publisher;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class PublisherServiceTest {
    @Autowired
    private PublisherService publisherService;

    @Test
    @DisplayName("출판사 등록")
    void 출판사등록() {
        // given
        Publisher publisher = new Publisher("위세");
        // when
        publisherService.save(publisher);

        // then
        Assertions.assertThat(publisherService.findOne(publisher.getId())).isEqualTo(publisher);
    }

    @Test
    @DisplayName("출판사 상세조회")
    void 출판사상세조회() {
        // given
        Publisher publisher = new Publisher("위세");
        publisherService.save(publisher);
        // when
        Publisher findPublisher = publisherService.findOne(publisher.getId());
        // then
        Assertions.assertThat(findPublisher).isEqualTo(publisher);
    }
}
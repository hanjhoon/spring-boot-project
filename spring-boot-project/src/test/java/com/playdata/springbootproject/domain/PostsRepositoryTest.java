package com.playdata.springbootproject.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
@SpringBootTest
@Repository
class PostsRepositoryTest {
    @Autowired
    PostsRepository postsRepository;
    @Autowired
    public void cleanup() {
        postsRepository.deleteAll();
    }
    @Test
    public void saveAndLoad() {
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";
        String author = "playdata";

        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build());
        //when
        Posts posts = postsRepository.findAll().get(0);

        //then
        assertEquals(posts.getTitle(), title);
        assertEquals(posts.getContent(), content);
        assertEquals(posts.getAuthor(), author);
    }
}
package com.playdata.springbootproject.service;

import com.playdata.springbootproject.domain.Posts;
import com.playdata.springbootproject.domain.PostsRepository;
import com.playdata.springbootproject.web.PostsResponseDto;
import com.playdata.springbootproject.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    public Long save(PostsSaveRequestDto requestDto) {

        return postsRepository.save(requestDto.toEntity()).getId();
    }
    @Transactional // 두 개의 작업이 동시에 일어나야 한다
    public Long update(Long id, PostsSaveRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 게시글을 찾을 수 없습니다. id=" +id));
        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(@PathVariable Long id) {
        Posts posts =postsRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 게시글을 찾을 수 없습니다. id=" +id));
        return new PostsResponseDto(posts);
    }
}

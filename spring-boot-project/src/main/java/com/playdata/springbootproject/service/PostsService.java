package com.playdata.springbootproject.service;

import com.playdata.springbootproject.domain.posts.Posts;
import com.playdata.springbootproject.domain.posts.PostsRepository;
import com.playdata.springbootproject.web.dto.PostsResponseDto;
import com.playdata.springbootproject.web.dto.PostsListRequestDto;
import com.playdata.springbootproject.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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
        posts.update(requestDto.getTitle(), requestDto.getContent(), requestDto.getClimbing_mountain(), requestDto.getClimbing_date());
        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts posts =postsRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 게시글을 찾을 수 없습니다. id=" +id));
        return new PostsResponseDto(posts);
    }
    
    @Transactional(readOnly = true)
    public List<PostsListRequestDto> findAllDesc() {
        return postsRepository.findAllDesc().stream()
                .map(PostsListRequestDto::new)
                .collect(Collectors.toList());
    }

    public List<PostsResponseDto> findByClimbingMountain(String climbing_mountain) {
        List<Posts> posts = postsRepository.findByClimbingMountain(climbing_mountain);

        return posts.stream()
                .map(PostsResponseDto::new)
                .collect(Collectors.toList());
    }




    @Transactional
    public Long delete(Long id) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("해당 게시글을 찾을 수 없습니다. id= " + id));
        postsRepository.delete(posts);
        return id;
    }

}

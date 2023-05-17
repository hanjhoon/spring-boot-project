package com.playdata.springbootproject.service;
import com.playdata.springbootproject.domain.blogs.Blogs;
import com.playdata.springbootproject.domain.blogs.BlogsRepository;
import com.playdata.springbootproject.domain.posts.Posts;
import com.playdata.springbootproject.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BlogsService {
    private final BlogsRepository blogsRepository;

    public Long save(BlogsSaveRequestDto requestDto) {

        return blogsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional // 두 개의 작업이 동시에 일어나야 한다
    public Long update(Long id, BlogsSaveRequestDto requestDto) {
        Blogs blogs = blogsRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 게시글을 찾을 수 없습니다. id=" +id));
        blogs.update(blogs.getTitle(), blogs.getUserid(), blogs.getContent(), blogs.getPmntnsn());
        return id;
    }

    public BlogsResponseDto findById(Long id) {
        Blogs blogs =blogsRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 게시글을 찾을 수 없습니다. id=" +id));
        return new BlogsResponseDto(blogs);
    }
    @Transactional(readOnly = true)
    public List<BlogsListRequestDto> findAllDesc() {
        return blogsRepository.findAllDesc().stream()
                .map(BlogsListRequestDto::new)
                .collect(Collectors.toList());
    }

    public List<BlogsResponseDto> findByUserid(String userid) {
        List<Blogs> blogs = blogsRepository.findByUserid(userid);

        return blogs.stream()
                .map(BlogsResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public Long delete(Long id) {
        Blogs blogs = blogsRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("해당 게시글을 찾을 수 없습니다. id= " + id));
        blogsRepository.delete(blogs);
        return id;
    }
}

package com.playdata.springbootproject.domain.blogs;
import com.playdata.springbootproject.domain.posts.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public interface BlogsRepository extends JpaRepository<Blogs, Long> {
    @Query("SELECT p FROM Blogs p ORDER BY p.id DESC")
    List<Blogs> findAllDesc();
}

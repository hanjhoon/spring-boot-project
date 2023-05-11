package com.playdata.springbootproject.domain.posts;

import com.playdata.springbootproject.domain.blogs.Blogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostsRepository extends JpaRepository<Posts, Long> {
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();

    @Query("SELECT p FROM Posts as p WHERE p.climbing_mountain LIKE %:climbingMountain% ORDER BY p.id DESC")
    List<Posts> findByClimbingMountain(@Param("climbingMountain") String climbingMountain);
}

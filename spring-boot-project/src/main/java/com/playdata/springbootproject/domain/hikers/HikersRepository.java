package com.playdata.springbootproject.domain.hikers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface HikersRepository extends JpaRepository<Hikers, Long> {
    @Query("SELECT p FROM Hikers p")
    List<Hikers> findAllDesc();
}

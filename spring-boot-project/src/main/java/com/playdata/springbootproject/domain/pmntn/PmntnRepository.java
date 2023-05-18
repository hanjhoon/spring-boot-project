package com.playdata.springbootproject.domain.pmntn;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PmntnRepository extends JpaRepository<Pmntn, Integer>{
//    @Query("SELECT p FROM Pmntn p ORDER BY p.pmntn_sn")
    List<Pmntn> findAll();
    List<Pmntn> findAllBy(Pageable pageable);

    List<Pmntn> findByPmntnTmBetween(int minTime, int maxTime, Pageable pageable);
    List<Pmntn> findByPmntnTmBetween(int minTime, int maxTime);

    @Query("SELECT p FROM Pmntn as p WHERE p.pmntnDffl = :pmntnDffl AND p.pmntnTm BETWEEN :minTime and :maxTime ORDER BY p.pmntnSn DESC")
    List<Pmntn> findByPmntnTmBetweenAndLevel(@Param("minTime") Integer minTime, @Param("maxTime") Integer maxTime, @Param("pmntnDffl") String pmntnDffl, Pageable pageable);

    @Query("SELECT p FROM Pmntn as p WHERE p.pmntnDffl = :pmntnDffl AND p.pmntnTm BETWEEN :minTime and :maxTime ORDER BY p.pmntnSn DESC")
    List<Pmntn> findByPmntnTmBetweenAndLevel(@Param("minTime") Integer minTime, @Param("maxTime") Integer maxTime, @Param("pmntnDffl") String pmntnDffl);

    List<Pmntn> findByPmntnDffl(String pmntnDffl, Pageable pageable);
    List<Pmntn> findByPmntnDffl(String pmntnDffl);
}

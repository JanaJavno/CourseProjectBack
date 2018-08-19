package com.example.req.repository;

import com.example.req.domain.Step;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StepRepository extends JpaRepository<Step, Long> {
    Page<Step> findByManualId(Long manualId, Pageable pageable);
}

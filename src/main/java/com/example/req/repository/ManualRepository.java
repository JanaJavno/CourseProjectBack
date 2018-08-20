package com.example.req.repository;

import com.example.req.domain.Manual;
import com.example.req.domain.ManualCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManualRepository extends JpaRepository<Manual, Long> {
    List<Manual> findAllByCategory (ManualCategory category);
}

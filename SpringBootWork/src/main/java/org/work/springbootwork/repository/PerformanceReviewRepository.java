package org.work.springbootwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.work.springbootwork.model.PerformanceReview;

import java.util.List;
import java.util.Optional;

public interface PerformanceReviewRepository extends JpaRepository<PerformanceReview,Long> {
    Optional<Long> findByEmployeeId(Long employeeId);
}

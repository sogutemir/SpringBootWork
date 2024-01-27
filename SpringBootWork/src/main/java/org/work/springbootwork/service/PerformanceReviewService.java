package org.work.springbootwork.service;

import org.work.springbootwork.model.PerformanceReview;

import java.util.List;
import java.util.Optional;

public interface PerformanceReviewService {

    List<PerformanceReview> getAllReviews();
//    Optional<PerformanceReview> getAllReviewsForEmployee(Long employeeId);
    PerformanceReview getPerformanceReviewById(Long id);
    PerformanceReview savePerformanceReview(PerformanceReview performanceReview);
    void deletePerformanceReviewById(Long id);
    PerformanceReview updatePerformanceReview(PerformanceReview performanceReview);

}

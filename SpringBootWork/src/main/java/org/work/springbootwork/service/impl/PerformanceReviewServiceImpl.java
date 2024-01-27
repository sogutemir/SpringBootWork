package org.work.springbootwork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.work.springbootwork.model.PerformanceReview;
import org.work.springbootwork.repository.PerformanceReviewRepository;
import org.work.springbootwork.service.PerformanceReviewService;

import java.util.List;
import java.util.Optional;

@Service
public class PerformanceReviewServiceImpl implements PerformanceReviewService {
    private final PerformanceReviewRepository performanceReviewRepository;

    @Autowired
    public PerformanceReviewServiceImpl(PerformanceReviewRepository performanceReviewRepository) {
        this.performanceReviewRepository = performanceReviewRepository;
    }

    @Override
    public List<PerformanceReview> getAllReviews() {
        return performanceReviewRepository.findAll();
    }

    @Override
    public PerformanceReview getPerformanceReviewById(Long id) {
        return performanceReviewRepository.findById(id).orElse(null);
    }

    @Override
    public PerformanceReview savePerformanceReview(PerformanceReview performanceReview) {
        return performanceReviewRepository.save(performanceReview);
    }

    @Override
    public void deletePerformanceReviewById(Long id) {
        performanceReviewRepository.deleteById(id);
    }

    @Override
    public PerformanceReview updatePerformanceReview(PerformanceReview performanceReview) {
        return performanceReviewRepository.save(performanceReview);
    }


}

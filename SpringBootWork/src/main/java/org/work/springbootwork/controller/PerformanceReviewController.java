package org.work.springbootwork.controller;

import org.springframework.web.bind.annotation.*;
import org.work.springbootwork.model.PerformanceReview;
import org.work.springbootwork.service.PerformanceReviewService;

import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/api/performanceReviews")
public class PerformanceReviewController {

    private final PerformanceReviewService performanceReviewService;

    public PerformanceReviewController(PerformanceReviewService performanceReviewService){
        this.performanceReviewService = performanceReviewService;
    }

    @GetMapping("/GetAllPerformanceReviews")
    public List<PerformanceReview> getAllPerformanceReviews(){
        return performanceReviewService.getAllReviews();
    }

    @GetMapping("/GetPerformanceReviews/{id}")
    public PerformanceReview getByIdPerformanceReviews(@PathVariable Long performanceReviewID){
        return  performanceReviewService.getPerformanceReviewById(performanceReviewID);
    }

    @PostMapping("/AddNewPerformanceReview")
    public PerformanceReview createReviews(@RequestBody PerformanceReview performanceReview){
        return  performanceReviewService.savePerformanceReview(performanceReview);
    }

    @PutMapping("UpdateRevies/{id}")
    public PerformanceReview updateReviews(@PathVariable Long id, @RequestBody PerformanceReview performanceReview){
        performanceReview.setId(id);
        return performanceReviewService.updatePerformanceReview(performanceReview);
    }
    @DeleteMapping("DeleteReview/{id}")
    public void deleteReviews(@PathVariable Long id){
        performanceReviewService.deletePerformanceReviewById(id);
    }
}

package com.ecomm.service;

import java.util.List;

import com.ecomm.exception.ProductException;
import com.ecomm.modal.Review;
import com.ecomm.modal.User;
import com.ecomm.request.ReviewRequest;

public interface ReviewService {

	public Review createReview(ReviewRequest req,User user) throws ProductException;
	
	public List<Review> getAllReview(Long productId);
	
	
}

package com.github.moviereservationbe.service.service;

import com.github.moviereservationbe.repository.Auth.user.User;
import com.github.moviereservationbe.repository.Auth.userDetails.CustomUserDetails;
import com.github.moviereservationbe.repository.MainPage.movie.Movie;
import com.github.moviereservationbe.repository.ReservationPage.reservation.ReservationJpa;
import com.github.moviereservationbe.repository.review.Review;
import com.github.moviereservationbe.repository.review.ReviewJpa;
import com.github.moviereservationbe.service.exceptions.ReviewAlreadyExistsException;
import com.github.moviereservationbe.web.DTO.MyPage.*;
import com.github.moviereservationbe.web.DTO.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MyPageService {
    private final ReservationJpa reservationJpa;
    private final ReviewJpa reviewJpa;

    public List<MyPageReservationResponse> findAllReservation(CustomUserDetails customUserDetails, Pageable pageable) {
        return null;
    }

    public MyPageUserDetailResponse updateUserDetail(CustomUserDetails customUserDetails, MyPageUserDetailRequest myPageUserDetailRequest) {
        return null;
    }

    public List<ReviewResponse> findAllReviews(CustomUserDetails customUserDetails, Pageable pageable) {
        List<Review> reviews = reviewJpa.findAll();
        return reviews.stream()
                .map(review -> ReviewResponse.builder()
                        .reviewId(review.getReviewId())
                        .score(review.getScore())
                        .content(review.getContent())
                        .build())
                .collect(Collectors.toList());
    }

    public ReviewResponse AddReview(CustomUserDetails customUserDetails, ReviewRequest reviewRequest) throws ReviewAlreadyExistsException {
        Integer userId = customUserDetails.getUserId();

        Integer movieId = reviewRequest.getMovieId(); // 리뷰 대상 영화의 ID
        Integer score = reviewRequest.getScore();
        String content = reviewRequest.getContent();

        Optional<Review> existingReview = reviewJpa.findByUserIdAndMovieId(userId, movieId);
        if (existingReview.isPresent()) {
            //리뷰 작성 했을 시
            throw new ReviewAlreadyExistsException("이미 리뷰를 작성했습니다.");
        }

        Review review = Review.builder()
                .user(User.builder().userId(userId).build())  // 사용자 ID 설정
                .movie(Movie.builder().movieId(movieId).build())  // 영화 ID 설정
                .score(score)
                .content(content)
                .build();

        Review savedReview = reviewJpa.save(review);
        Integer reviewId = savedReview.getReviewId();

        return ReviewResponse.builder()
                .reviewId(reviewId)
                .score(score)
                .content(content)
                .build();
    }

    public ReviewResponse updateReview(CustomUserDetails customUserDetails, ReviewRequest reviewRequest) {
        return null;
    }

    public ResponseDto deleteReview(CustomUserDetails customUserDetails) {
        return null;
    }
}
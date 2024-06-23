package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.ReviewConverter;
import umc.study.domain.Review;
import umc.study.service.ReviewService.ReviewCommandServiceImpl;
import umc.study.web.dto.ReviewRequestDTO;
import umc.study.web.dto.ReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewRestController {
    private final ReviewCommandServiceImpl reviewCommandService;
    @PostMapping("/")
    public ApiResponse<ReviewResponseDTO.ReviewCreateDTO> createReview(@RequestBody  @Valid ReviewRequestDTO.ReviewDTO request){
        Review review = reviewCommandService.writeReview(request);
        return ApiResponse.onSuccess(ReviewConverter.toReviewCreateDTO(review));
    }
}

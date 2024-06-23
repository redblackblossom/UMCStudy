package umc.study.converter;

import lombok.RequiredArgsConstructor;
import umc.study.domain.Member;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.repository.MemberRepository;
import umc.study.repository.StoreRepository;
import umc.study.web.dto.ReviewRequestDTO;
import umc.study.web.dto.ReviewResponseDTO;

import java.time.LocalDateTime;
import java.util.Optional;

public class ReviewConverter {

    public static ReviewResponseDTO.ReviewCreateDTO toReviewCreateDTO(Review review){
        return ReviewResponseDTO.ReviewCreateDTO.builder()
                .reviewId(review.getId())
                .createdDate(LocalDateTime.now())
                .build();
    }

    public static Review toReview(ReviewRequestDTO.ReviewDTO request, Member writeMember, Store store){
        return Review.builder()
                .title(request.getBody())
                .score(request.getScore())
                .member(writeMember)
                .store(store)
                .build();
    }
}

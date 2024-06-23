package umc.study.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.MemberHandler;
import umc.study.apiPayload.exception.handler.StoreHandler;
import umc.study.converter.ReviewConverter;
import umc.study.domain.Member;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.repository.MemberRepository;
import umc.study.repository.ReviewRepository;
import umc.study.repository.StoreRepository;
import umc.study.web.dto.ReviewRequestDTO;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService{
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;
    private final ReviewRepository reviewRepository;
    @Override
    public Review writeReview(ReviewRequestDTO.ReviewDTO request) {
        Optional<Member> optionalMember = memberRepository.findById(request.getMemberId());
        Optional<Store> optionalStore = storeRepository.findById(request.getStoreId());
        Member member = optionalMember.orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
        Store store = optionalStore.orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));
        Review review = ReviewConverter.toReview(request,member,store);
        return reviewRepository.save(review);
    }
}

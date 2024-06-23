package umc.study.web.dto;

import lombok.Getter;

public class ReviewRequestDTO {

    @Getter
    public static class ReviewDTO{
        Long memberId;
        Long StoreId;
        String body;
        Float score;
    }
}

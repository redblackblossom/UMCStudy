package umc.study.web.dto;

import lombok.*;

import java.time.LocalDateTime;

public class ReviewResponseDTO {
    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ReviewCreateDTO{
        Long reviewId;
        LocalDateTime createdDate;
    }
}

package umc.study.web.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class ReviewRequestDTO {

    @Getter
    public static class ReviewDTO{
        @NotNull
        Long memberId;
        @NotNull
        Long StoreId;
        @NotEmpty
        String body;
        @NotNull
        Float score;
    }
}

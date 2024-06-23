package umc.study.web.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.util.List;


public class MemberRequestDTO {
    @Getter
    public static class JoinDto{
        @NotEmpty
        String name;

        @NotNull
        Integer gender;

        @NotNull
        Integer birthYear;

        @NotNull
        Integer birthMonth;

        @NotNull
        Integer birthDay;

        @NotEmpty
        String address;

        @NotEmpty
        String specAddress;

        @NotNull
        @Size(min = 1)
        List<Long> preferCategory;
    }
}

package umc.study.web.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MissionRequestDTO {

    @Getter
    public static class MissionDTO {
        @NotNull
        Long storeId;
        @NotNull
        Integer reward;
        @NotNull
        LocalDate deadline;
        @NotEmpty
        String missionSpec;
    }

    @Getter
    public static class MemberMissionDTO{
        @NotNull
        Long memberId;
        @NotNull
        Long missionId;
    }
}

package umc.study.converter;

import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.Store;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.MemberMission;
import umc.study.web.dto.MissionRequestDTO;
import umc.study.web.dto.MissionResponseDTO;

import java.time.LocalDateTime;

import static umc.study.domain.enums.MissionStatus.CHALLENGING;

public class MissionConverter {

    public static Mission toMission(MissionRequestDTO.MissionDTO requestDTO, Store store){
        return Mission.builder()
                .store(store)
                .reward(requestDTO.getReward())
                .deadline(requestDTO.getDeadline())
                .missionSpec(requestDTO.getMissionSpec())
                .build();
    }

    public static MissionResponseDTO.AddMissionResult toMissionDTO(Mission mission){
        return MissionResponseDTO.AddMissionResult.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static MemberMission toMemberMission(MissionRequestDTO.MemberMissionDTO memberMissionDTO, Member member, Mission mission){
        return MemberMission.builder()
                .member(member)
                .mission(mission)
                .status(MissionStatus.CHALLENGING)
                .build();
    }

    public static MissionResponseDTO.AddMemberMissionResult toMemberMissionDTO(MemberMission mission){
        return MissionResponseDTO.AddMemberMissionResult.builder()
                .memberMissionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}

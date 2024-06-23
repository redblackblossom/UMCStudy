package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.MissionConverter;
import umc.study.domain.Mission;
import umc.study.domain.mapping.MemberMission;
import umc.study.service.MissionService.MissionCommandService;
import umc.study.web.dto.MissionRequestDTO;
import umc.study.web.dto.MissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionRestController {
    private final MissionCommandService missionCommandService;

    @PostMapping("/")
    public ApiResponse<MissionResponseDTO.AddMissionResult> addMission(@RequestBody @Valid MissionRequestDTO.MissionDTO request){
        Mission mission = missionCommandService.addMission(request);
        return ApiResponse.onSuccess(MissionConverter.toMissionDTO(mission));
    }

    @PostMapping("/memberMission")
    public ApiResponse<MissionResponseDTO.AddMemberMissionResult> addMemberMission(@RequestBody @Valid MissionRequestDTO.MemberMissionDTO request){
        MemberMission memberMission = missionCommandService.addMemberMission(request);
        return ApiResponse.onSuccess(MissionConverter.toMemberMissionDTO(memberMission));
    }
}

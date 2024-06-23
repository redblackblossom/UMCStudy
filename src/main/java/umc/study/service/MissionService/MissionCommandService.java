package umc.study.service.MissionService;

import umc.study.domain.Mission;
import umc.study.domain.mapping.MemberMission;
import umc.study.web.dto.MissionRequestDTO;

public interface MissionCommandService {
    public Mission addMission(MissionRequestDTO.MissionDTO missionDTO);
    public MemberMission addMemberMission(MissionRequestDTO.MemberMissionDTO request);
}

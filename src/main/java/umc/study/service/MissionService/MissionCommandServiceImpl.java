package umc.study.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.MemberHandler;
import umc.study.apiPayload.exception.handler.MissionHandler;
import umc.study.apiPayload.exception.handler.StoreHandler;
import umc.study.converter.MissionConverter;
import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.Store;
import umc.study.domain.mapping.MemberMission;
import umc.study.repository.MemberMissionRepository;
import umc.study.repository.MemberRepository;
import umc.study.repository.MissionRepository;
import umc.study.repository.StoreRepository;
import umc.study.web.dto.MissionRequestDTO;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService{
    private final StoreRepository storeRepository;
    private final MissionRepository missionRepository;
    private final MemberRepository memberRepository;
    private final MemberMissionRepository memberMissionRepository;
    @Override
    public Mission addMission(MissionRequestDTO.MissionDTO missionDTO) {
        Optional<Store> optionalStore = storeRepository.findById(missionDTO.getStoreId());
        Store store = optionalStore.orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));
        Mission mission = MissionConverter.toMission(missionDTO,store);

        return missionRepository.save(mission);
    }

    @Override
    public MemberMission addMemberMission(MissionRequestDTO.MemberMissionDTO request) {
        Optional<Member> optionalMember = memberRepository.findById(request.getMemberId());
        Optional<Mission> optionalMission = missionRepository.findById(request.getMissionId());

        Member member = optionalMember.orElseThrow(()->new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
        Mission mission = optionalMission.orElseThrow(()->new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));

        List<MemberMission> memberMissionList = memberMissionRepository.findByMemberIdAndMissionId(member,mission);
        if(!memberMissionList.isEmpty()){
            throw new MissionHandler(ErrorStatus.MEMBER_MISSION_DUPLICATE);
        }
        MemberMission memberMission = MissionConverter.toMemberMission(request,member,mission);
        return memberMissionRepository.save(memberMission);
    }
}

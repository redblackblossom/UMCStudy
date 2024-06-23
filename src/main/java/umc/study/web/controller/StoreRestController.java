package umc.study.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.study.apiPayload.ApiResponse;
import umc.study.web.dto.StoreResponseDTO;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {
    @GetMapping("{storeId}/reviews")
    public ApiResponse<StoreResponseDTO.ReviewPreViewListDTO> getReviewList(@PathVariable(name="storeId") Long StoreId){
        return null;
    }
}

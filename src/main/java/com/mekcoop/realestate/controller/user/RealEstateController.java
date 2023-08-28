package com.mekcoop.realestate.controller.user;

import com.mekcoop.realestate.payload.request.RealEstateRequest;
import com.mekcoop.realestate.payload.response.RealEstateResponse;
import com.mekcoop.realestate.payload.response.ResponseMessage;
import com.mekcoop.realestate.service.user.RealEstateService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/realEstate")
@RequiredArgsConstructor
public class RealEstateController {
    private final RealEstateService realEstateService;

    @PostMapping("/save")
    public ResponseMessage<RealEstateResponse> saveRealEstate(@RequestBody @Valid RealEstateRequest realEstateRequest){
        return realEstateService.saveRealEstate(realEstateRequest);
    }
    @DeleteMapping("/delete/{realEstateId}")
    @PreAuthorize("hasAnyAuthority('REAL_ESTATE')")
    public ResponseMessage deleteRealEstate(@PathVariable Long realEstateId){
        return realEstateService.deleteRealEstate(realEstateId);
    }
    @PutMapping("/updateRealEstate/{realEstateId}")
    @PreAuthorize("hasAnyAuthority('REAL_ESTATE')")
    public ResponseMessage<RealEstateResponse> updateRealEstate(@RequestBody @Valid RealEstateRequest realEstateRequest,@PathVariable Long realEstateId){
        return realEstateService.updateRealEstate(realEstateRequest,realEstateId);
    }
}

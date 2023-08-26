package com.mekcoop.realestate.controller;

import com.mekcoop.realestate.payload.request.RealEstateRequest;
import com.mekcoop.realestate.payload.response.RealEstateResponse;
import com.mekcoop.realestate.payload.response.ResponseMessage;
import com.mekcoop.realestate.service.RealEstateService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/realEstate")
@RequiredArgsConstructor
public class RealEstateController {
    private final RealEstateService realEstateService;

    @PostMapping("/save")
    public ResponseMessage<RealEstateResponse> saveRealEstate(@RequestBody @Valid RealEstateRequest realEstateRequest){
        return realEstateService.saveRealEstate(realEstateRequest);
    }
}

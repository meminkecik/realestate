package com.mekcoop.realestate.controller;

import com.mekcoop.realestate.payload.request.PostResponse;
import com.mekcoop.realestate.payload.response.PostRequest;
import com.mekcoop.realestate.payload.response.ResponseMessage;
import com.mekcoop.realestate.service.PostService;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estate")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping("/saveEstate")
    @PreAuthorize("hasAnyAuthority('REAL_ESTATE')")
    public ResponseMessage<PostResponse> saveEstate(@RequestBody @Valid PostRequest estateRequest, HttpServletRequest request){
            return postService.saveEstate(estateRequest,request);
    }
}

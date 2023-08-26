package com.mekcoop.realestate.controller;

import com.mekcoop.realestate.payload.response.PostResponse;
import com.mekcoop.realestate.payload.request.PostRequest;
import com.mekcoop.realestate.payload.response.ResponseMessage;
import com.mekcoop.realestate.service.PostService;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/getAllPost")
    @PreAuthorize("hasAnyAuthority('REAL_ESTATE','USER')")
    public Page<PostResponse> getAllPostWithPage(
            @RequestParam(value = "page",defaultValue = "0") int page,
            @RequestParam(value = "size",defaultValue = "10") int size,
            @RequestParam(value = "sort",defaultValue = "city") String sort,
            @RequestParam(value = "type",defaultValue = "desc") String type,
            @RequestParam(value = "estateType",required = false) String estateType,
            @RequestParam(value = "minPrice",required = false) Double minPrice,
            @RequestParam(value = "maxPrice",required = false) Double maxPrice,
            @RequestParam(value = "roomNumber",required = false) Integer roomNumber,
            @RequestParam(value = "city",required = false) String city
    ){
        return postService.getAllPostWithPage(page,size,sort,type,estateType,minPrice,maxPrice,roomNumber,city);
    }
    @DeleteMapping("/deletePostById/{postId}")
    @PreAuthorize("hasAnyAuthority('REAL_ESTATE')")
    public ResponseMessage deleteEstateById(@PathVariable Long postId){
        return postService.deleteEstateById(postId);
    }

    @PutMapping("/updatePost/{postId}")
    @PreAuthorize("hasAnyAuthority('REAL_ESTATE')")
    public ResponseMessage<PostResponse> updatePostById(@RequestBody @Valid PostRequest postRequest, @PathVariable Long postId){
        return postService.updatePostById(postRequest,postId);
    }

    @GetMapping("/listPost")
    @PreAuthorize("hasAnyAuthority('REAL_ESTATE','USER')")
    public List<PostResponse> listPostSearch(
            @RequestParam(value = "estateType",required = false) String estateType,
            @RequestParam(value = "minPrice",required = false) Double minPrice,
            @RequestParam(value = "maxPrice",required = false) Double maxPrice,
            @RequestParam(value = "roomNumber",required = false) Integer roomNumber,
            @RequestParam(value = "city",required = false) String city
    ){
        return postService.listPostSearch(estateType,minPrice,maxPrice,roomNumber,city);
    }
}

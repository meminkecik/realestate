package com.mekcoop.realestate.payload.mapper;

import com.mekcoop.realestate.entity.business.Post;
import com.mekcoop.realestate.payload.request.PostResponse;
import com.mekcoop.realestate.payload.response.PostRequest;
import org.springframework.stereotype.Component;

@Component
public class PostMapper {
    public Post mapPostRequestToPost(PostRequest postRequest){
        return Post.builder()
                .floor(postRequest.getTotalFloor())
                .city(postRequest.getCity())
                .address(postRequest.getAddress())
                .estateType(postRequest.getEstateType())
                .roomNumber(postRequest.getRoomNumber())
                .squareMeter(postRequest.getSquareMeter())
                .totalFloor(postRequest.getTotalFloor())
                .typeOfHeating(postRequest.getTypeOfHeating())
                .build();
    }
    public PostResponse mapPostToPostResponse(Post post){
        return PostResponse.builder()
                .id(post.getId())
                .floor(post.getFloor())
                .city(post.getCity())
                .address(post.getAddress())
                .estateType(post.getEstateType())
                .roomNumber(post.getRoomNumber())
                .squareMeter(post.getSquareMeter())
                .totalFloor(post.getTotalFloor())
                .typeOfHeating(post.getTypeOfHeating())
                .user(post.getUser())
                .imageFiles(post.getImageFiles())
                .realEstate(post.getRealEstate())
                .build();
    }
}

package com.mekcoop.realestate.payload.mapper;

import com.mekcoop.realestate.entity.business.Post;
import com.mekcoop.realestate.payload.response.PostResponse;
import com.mekcoop.realestate.payload.request.PostRequest;
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
                .price(postRequest.getPrice())
                .header(postRequest.getHeader())
                .description(postRequest.getDescription())
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
                .userName(post.getUser().getFirstName())
                .userSurname(post.getUser().getLastName())
                .imageFiles(post.getImageFiles())
                .companyName(post.getRealEstate().getCompanyName())
                .price(post.getPrice())
                .header(post.getHeader())
                .description(post.getDescription())
                .build();
    }
    public Post mapPostRequestToUpdatedPost(PostRequest postRequest,Long id){
        return mapPostRequestToPost(postRequest).toBuilder().id(id).build();


    }
}

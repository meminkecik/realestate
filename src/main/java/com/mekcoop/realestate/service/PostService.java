package com.mekcoop.realestate.service;

import com.mekcoop.realestate.entity.business.Post;
import com.mekcoop.realestate.entity.user.RealEstate;
import com.mekcoop.realestate.entity.user.User;
import com.mekcoop.realestate.payload.mapper.PostMapper;
import com.mekcoop.realestate.payload.message.SuccessMessage;
import com.mekcoop.realestate.payload.request.PostResponse;
import com.mekcoop.realestate.payload.response.PostRequest;
import com.mekcoop.realestate.payload.response.ResponseMessage;
import com.mekcoop.realestate.repository.PostRepository;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final UserService userService;
    private final RealEstateService realEstateService;
    private final PostMapper postMapper;

    public ResponseMessage<PostResponse> saveEstate(PostRequest postRequest, HttpServletRequest request) {
        User user = userService.getUserBySsn(postRequest.getOwnerSsn());
        String email = (String) request.getAttribute("email");
        RealEstate realEstate = realEstateService.findRealEstateByEmail(email);
        Post post = postMapper.mapPostRequestToPost(postRequest);
        post.setUser(user);
        post.setRealEstate(realEstate);
        //TODO image file setlenecek
        Post savedPost = postRepository.save(post);
        return ResponseMessage.<PostResponse>builder()
                .httpStatus(HttpStatus.CREATED)
                .object(postMapper.mapPostToPostResponse(savedPost))
                .message(SuccessMessage.POST_SAVE)
                .build();
    }
}

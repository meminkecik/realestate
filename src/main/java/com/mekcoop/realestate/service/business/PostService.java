package com.mekcoop.realestate.service.business;

import com.mekcoop.realestate.entity.business.Post;
import com.mekcoop.realestate.entity.user.concretes.RealEstate;
import com.mekcoop.realestate.entity.user.concretes.User;
import com.mekcoop.realestate.exception.ResourceNotFoundException;
import com.mekcoop.realestate.payload.mapper.PostMapper;
import com.mekcoop.realestate.payload.message.ErrorMessage;
import com.mekcoop.realestate.payload.message.SuccessMessage;
import com.mekcoop.realestate.payload.response.PostResponse;
import com.mekcoop.realestate.payload.request.PostRequest;
import com.mekcoop.realestate.payload.response.ResponseMessage;
import com.mekcoop.realestate.repository.PostRepository;
import javax.servlet.http.HttpServletRequest;

import com.mekcoop.realestate.service.user.RealEstateService;
import com.mekcoop.realestate.service.user.UserService;
import com.mekcoop.realestate.service.helper.PageableHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final UserService userService;
    private final RealEstateService realEstateService;
    private final PostMapper postMapper;
    private final PageableHelper pageableHelper;


    public ResponseMessage<PostResponse> saveEstate(PostRequest postRequest, HttpServletRequest request) {
        User user = userService.getUserBySsn(postRequest.getOwnerSsn());
        String email = (String) request.getAttribute("email");
        RealEstate realEstate = realEstateService.findRealEstateByEmail(email);
        Post post = postMapper.mapPostRequestToPost(postRequest);
        post.setUser(user);
        post.setRealEstate(realEstate);
        Post savedPost = postRepository.save(post);

        return ResponseMessage.<PostResponse>builder()
                .httpStatus(HttpStatus.CREATED)
                .object(postMapper.mapPostToPostResponse(savedPost))
                .message(SuccessMessage.POST_SAVE)
                .build();
    }

    public Page<PostResponse> getAllPostWithPage(int page, int size, String sort, String type,String estateType,Double minPrice,Double maxPrice,Integer roomNumber,String city) {
        Pageable pageable = pageableHelper.getPageableWithProperties(page,size,sort,type);
        return postRepository.findAllWithProperties(pageable,estateType,minPrice,maxPrice,roomNumber,city).map(postMapper::mapPostToPostResponse);
    }

    public ResponseMessage deleteEstateById(Long postId) {
        isPostExistsById(postId);
        postRepository.deleteById(postId);
        return ResponseMessage.builder().message(SuccessMessage.ESTATE_DELETE).httpStatus(HttpStatus.OK).build();
    }
    public Post isPostExistsById(Long postId){
        Post post = postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException(String.format(ErrorMessage.NOT_FOUND_ESTATE,postId)));
        return post;
    }

    public ResponseMessage<PostResponse> updatePostById(PostRequest postRequest, Long postId) {
        isPostExistsById(postId);
        Post updatedPost = postMapper.mapPostRequestToUpdatedPost(postRequest,postId);
        Post savedPost = postRepository.save(updatedPost);
        return ResponseMessage.<PostResponse>builder()
                .httpStatus(HttpStatus.OK)
                .message(SuccessMessage.ESTATE_UPDATE)
                .object(postMapper.mapPostToPostResponse(savedPost))
                .build();
    }

    public List<PostResponse> listPostSearch(String estateType, Double minPrice, Double maxPrice, Integer roomNumber, String city) {
        List<Post> postList = postRepository.findAll();
        List<PostResponse> postResponseList = postList.stream()
                .filter(post -> (estateType==null || post.getEstateType().name().equals(estateType)))
                .filter(post -> (minPrice==null || post.getPrice()>=minPrice))
                .filter(post -> (maxPrice==null || post.getPrice()<=maxPrice))
                .filter(post -> (roomNumber==null || post.getRoomNumber().equals(roomNumber)))
                .filter(post -> (city==null || post.getCity().equalsIgnoreCase(city)))
                .map(postMapper::mapPostToPostResponse)
                .collect(Collectors.toList());
        return postResponseList;
    }
}

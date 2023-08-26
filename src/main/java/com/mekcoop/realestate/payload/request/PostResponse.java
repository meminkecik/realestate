package com.mekcoop.realestate.payload.request;

import com.mekcoop.realestate.entity.business.ImageFile;
import com.mekcoop.realestate.entity.enums.EstateType;
import com.mekcoop.realestate.entity.user.RealEstate;
import com.mekcoop.realestate.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class PostResponse {
    private Long id;
    private EstateType estateType;
    private Integer squareMeter;
    private Integer roomNumber;
    private Integer totalFloor;
    private Integer floor;
    private String typeOfHeating;
    private String city;
    private String address;
    private Set<ImageFile> imageFiles;
    private User user;
    private RealEstate realEstate;
}

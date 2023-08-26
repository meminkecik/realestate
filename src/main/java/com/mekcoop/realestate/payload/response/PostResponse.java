package com.mekcoop.realestate.payload.response;

import com.mekcoop.realestate.entity.business.ImageFile;
import com.mekcoop.realestate.entity.enums.EstateType;
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
    private Double price;
    private String header;
    private String description;
    private Integer squareMeter;
    private Integer roomNumber;
    private Integer totalFloor;
    private Integer floor;
    private String typeOfHeating;
    private String city;
    private String address;
    private Set<ImageFile> imageFiles;
    private String userName;
    private String userSurname;
    private String companyName;
}

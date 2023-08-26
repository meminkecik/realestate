package com.mekcoop.realestate.payload.response;

import com.mekcoop.realestate.entity.business.ImageFile;
import com.mekcoop.realestate.entity.enums.EstateType;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class PostRequest {
    @NotNull(message = "Please select estate type")
    private EstateType estateType;
    @NotNull(message = "Please enter square meter")
    private Integer squareMeter;
    @NotNull(message = "Please enter room number")
    private Integer roomNumber;
    private Integer totalFloor;
    private Integer floor;
    private String typeOfHeating;
    @NotNull(message = "Please enter city")
    private String city;
    @NotNull(message = "Please enter address")
    private String address;
    private Set<ImageFile> imageFiles;
    @NotNull(message = "Please enter owner user ssn")
    private String ownerSsn;
}

package org.pragma.foodcourtusers.application.dto.response;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class RestaurantResponse{
    private String name;
    private String address;
    private Long ownerId;
    private String phoneNumber;
    private String logoUrl;
    private String nit;

}

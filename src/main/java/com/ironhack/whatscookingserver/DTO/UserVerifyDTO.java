package com.ironhack.whatscookingserver.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVerifyDTO {
    private String name;
    //other info can be included as well, but for this app we just are using name
}


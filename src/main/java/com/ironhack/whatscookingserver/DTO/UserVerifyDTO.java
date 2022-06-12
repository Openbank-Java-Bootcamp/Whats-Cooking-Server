package com.ironhack.whatscookingserver.DTO;

import com.ironhack.whatscookingserver.models.Note;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVerifyDTO {
    private Long id; //I added this
    private String name;
    //private List<Note> notes; //this causes user to be logged out and can't log back in again...
    //other info can be included as well, but for this app we just are using name
}


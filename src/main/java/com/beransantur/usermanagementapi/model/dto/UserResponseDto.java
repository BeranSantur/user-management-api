package com.beransantur.usermanagementapi.model.dto;

import com.beransantur.usermanagementapi.utils.enums.Gender;
import com.beransantur.usermanagementapi.utils.enums.Status;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserResponseDto {
    private String id;
    private String name;
    private Status status;
    private String age;
    private String job;
    private Gender gender;
    private String placeOfBirth;
    private String createdUser;
    private Date createdDate;
    private String modifiedUser;
    private Date modifiedDate;
}

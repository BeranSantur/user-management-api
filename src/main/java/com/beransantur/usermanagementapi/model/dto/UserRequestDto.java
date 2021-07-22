package com.beransantur.usermanagementapi.model.dto;

import com.beransantur.usermanagementapi.utils.enums.Gender;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UserRequestDto {
    @Size(max=50)
    @NotNull
    private String name;

    @Size(max=50)
    @NotNull
    private String job;

    @Size(max=50)
    @Max(value=150, message="you must enter only numbers")
    @NotNull
    private String age;

    @NotNull
    private Gender gender;

    @Size(max=100)
    @NotNull
    private String placeOfBirth;
}

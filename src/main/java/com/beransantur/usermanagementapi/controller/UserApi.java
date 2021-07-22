package com.beransantur.usermanagementapi.controller;

import com.beransantur.usermanagementapi.model.dto.UserRequestDto;
import com.beransantur.usermanagementapi.model.dto.UserResponseDto;
import com.beransantur.usermanagementapi.model.entity.UserEntity;
import com.beransantur.usermanagementapi.service.IUserService;
import com.beransantur.usermanagementapi.utils.enums.Status;
import com.beransantur.usermanagementapi.utils.exceptions.EntityNotFoundException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserApi {

    private final IUserService<UserEntity> userService;
    private final ModelMapper modelMapper;

    @GetMapping("/{id}")
    @ApiOperation(value = "Get User By Id")
    public ResponseEntity<UserResponseDto> getUserDetail(@PathVariable String id) throws EntityNotFoundException {
        UserEntity userEntity = userService.getUserDetail(id);
        UserResponseDto userResponseDto = modelMapper.map(userEntity, UserResponseDto.class);
        return ResponseEntity.ok(userResponseDto);
    }

    @GetMapping()
    @ApiOperation(value = "Get All Users")
    public ResponseEntity<List<UserResponseDto>> getAllUsers(@ApiParam(value = "STATUS", defaultValue = "ALL") @RequestParam(required = true, name = "status") Status status) {
        List<UserEntity> allUsers = userService.getAllUsersByStatus(status.toString());
        List<UserResponseDto> userResponseListDto = convertToDtoList(allUsers);
        return ResponseEntity.ok(userResponseListDto);
    }

    @PostMapping()
    @ApiOperation(value = "Save User")
    public ResponseEntity<UserResponseDto> saveUser(@RequestBody UserRequestDto userRequestDto) {
        UserEntity userEntity = modelMapper.map(userRequestDto, UserEntity.class);
        UserResponseDto userResponseDto = modelMapper.map(userService.saveUser(userEntity), UserResponseDto.class);
        return ResponseEntity.ok(userResponseDto);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update User")
    public ResponseEntity<UserResponseDto> updateUser(@ApiParam(value = "ID", required = true) @PathVariable String id, @RequestBody UserRequestDto userRequestDto) throws EntityNotFoundException {
        UserEntity userEntity = modelMapper.map(userRequestDto, UserEntity.class);
        UserResponseDto userResponseDto = modelMapper.map(userService.updateUser(userEntity, id), UserResponseDto.class);
        return ResponseEntity.ok(userResponseDto);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete User")
    public ResponseEntity<UserResponseDto> deleteUser(@ApiParam(value = "ID", required = true) @PathVariable String id) throws EntityNotFoundException {
        UserResponseDto userResponseDto = modelMapper.map(userService.deleteUser(id), UserResponseDto.class);
        return ResponseEntity.ok(userResponseDto);
    }

    public List<UserResponseDto> convertToDtoList(List<UserEntity> userEntityList) {
        final List<UserResponseDto> userResponseDtoArrayList = new ArrayList<>();
        for (UserEntity userEntity : userEntityList) {
            UserResponseDto userResponseDto = modelMapper.map(userEntity, UserResponseDto.class);
            userResponseDtoArrayList.add(userResponseDto);
        }
        return userResponseDtoArrayList;
    }
}

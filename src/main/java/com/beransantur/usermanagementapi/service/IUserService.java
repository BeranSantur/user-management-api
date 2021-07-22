package com.beransantur.usermanagementapi.service;

import com.beransantur.usermanagementapi.utils.exceptions.EntityNotFoundException;

import java.util.List;

public interface IUserService<T> {
    T getUserDetail(String id) throws EntityNotFoundException;

    List<T> getAllUsersByStatus(String status);

    T saveUser(T user);

    T updateUser(T user, String id) throws EntityNotFoundException;

    T deleteUser(String id) throws EntityNotFoundException;

    void throwExceptionIfUserNotExistOrDeletedInDb(String id) throws EntityNotFoundException;
}

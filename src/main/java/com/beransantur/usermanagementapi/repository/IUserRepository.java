package com.beransantur.usermanagementapi.repository;

import java.util.List;

public interface IUserRepository<T> {
    T getUserDetail(String id);

    List<T> getAllUsersByStatus(String status);

    List<T> getAllUsers();

    String saveUser(T user);

    String updateUser(T user, String id);

    void deleteUser(String id);

    String getMaxId();

    String getUserStatusById(String id);
}

package com.beransantur.usermanagementapi.service;

import com.beransantur.usermanagementapi.model.entity.UserEntity;
import com.beransantur.usermanagementapi.repository.IUserRepository;
import com.beransantur.usermanagementapi.utils.enums.Status;
import com.beransantur.usermanagementapi.utils.exceptions.EntityNotFoundException;
import com.beransantur.usermanagementapi.utils.exceptions.ListOfEntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class UserServiceImp implements IUserService<UserEntity> {

    private final IUserRepository<UserEntity> userRepository;

    public UserServiceImp(IUserRepository<UserEntity> userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity getUserDetail(String id) throws EntityNotFoundException {
        throwExceptionIfUserNotExistOrDeletedInDb(id);
        return userRepository.getUserDetail(id);
    }

    @Override
    public List<UserEntity> getAllUsersByStatus(String status) {
        if (status.equals("ALL")) {
            return getAllUsers();
        }
        throwExceptionIfListOfEntityNotFound(status);
        return userRepository.getAllUsersByStatus(status);
    }

    private List<UserEntity> getAllUsers() {
        throwExceptionIfListOfEntityNotFound();
        return userRepository.getAllUsers();
    }

    private void throwExceptionIfListOfEntityNotFound() {
        if (userRepository.getAllUsers().isEmpty())
            throw new ListOfEntityNotFoundException("ALL");
    }

    private void throwExceptionIfListOfEntityNotFound(String status) {
        if (userRepository.getAllUsersByStatus(status).isEmpty())
            throw new ListOfEntityNotFoundException(status);
    }

    @Override
    public UserEntity saveUser(UserEntity user) {
        String savedUserId = userRepository.saveUser(user);
        return userRepository.getUserDetail(savedUserId);
    }

    @Override
    public UserEntity updateUser(UserEntity user, String id) throws EntityNotFoundException {
        throwExceptionIfUserNotExistOrDeletedInDb(id);
        userRepository.updateUser(user, id);
        return userRepository.getUserDetail(id);
    }

    @Override
    public UserEntity deleteUser(String id) throws EntityNotFoundException {
        throwExceptionIfUserNotExistOrDeletedInDb(id);
        userRepository.deleteUser(id);
        return userRepository.getUserDetail(id);
    }

    @Override
    public void throwExceptionIfUserNotExistOrDeletedInDb(String id) throws EntityNotFoundException {
        String statusFromDb = userRepository.getUserStatusById(id);
        if (!StringUtils.hasText(statusFromDb) || statusFromDb.equals(Status.D.toString())) {
            throw new EntityNotFoundException(id);
        }
    }

}

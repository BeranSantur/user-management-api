package com.beransantur.usermanagementapi.utils.log;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Builder
public class ErrorLogMessage {

    public void errorWhenFindingUserById() {
        log.error("Error when finding user by id ");
    }

    public void errorWhenFindingAllUsers() {
        log.error("Error when finding all users");
    }

    public void errorWhenSavingUser() {
        log.error("Error when saving user");
    }

    public void errorWhenUpdatingUser() {
        log.error("Error when updating user");
    }

    public void errorWhenDeletingUser() {
        log.error("Error when deleting user");
    }

    public void errorWhenFindingMaxId(){
        log.error("Error when finding max ID");
    }

    public void errorWhenFindUserStatusById() {log.error("Error when finding status by ID");}
}

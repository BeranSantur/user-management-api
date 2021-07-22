package com.beransantur.usermanagementapi.utils.log;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Builder
public class InfoLogMessage {

    public void userFoundById(){
        log.info("User by ID found");
    }

    public void allUsersFound(){
        log.info("Users found");
    }

    public void userSaved(){
        log.info("User saved");
    }

    public void userUpdated(){
        log.info("User updated");
    }

    public void userDeleted(){
        log.info("User deleted");
    }

    public void maxIdFound(){
        log.info("Max id found");
    }

    public void userStatusFoundById(){log.info("User status found by id");}
}

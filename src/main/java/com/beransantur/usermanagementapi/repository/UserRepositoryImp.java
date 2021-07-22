package com.beransantur.usermanagementapi.repository;

import com.beransantur.usermanagementapi.model.entity.UserEntity;
import com.beransantur.usermanagementapi.utils.exceptions.DataBaseSystemException;
import com.beransantur.usermanagementapi.utils.log.ErrorLogMessage;
import com.beransantur.usermanagementapi.utils.log.InfoLogMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

import java.util.Date;
import java.util.List;

import static com.beransantur.usermanagementapi.utils.constants.UserRepositoryConstants.*;
import static com.beransantur.usermanagementapi.utils.mapping.UserMapping.*;

@RequiredArgsConstructor
@Repository
public class UserRepositoryImp implements IUserRepository<UserEntity> {
    private final Sql2o sql2o;
    private final InfoLogMessage infoLogMessage = InfoLogMessage.builder().build();
    private final ErrorLogMessage errorLogMessage = ErrorLogMessage.builder().build();

    @Override
    public UserEntity getUserDetail(String id) {
        try (Connection con = sql2o.open(); Query query = con.createQuery(GET_USER_DETAIL)) {

            UserEntity userEntity = query
                    .addParameter("id", id)
                    .setColumnMappings(COLUMN_MAPPINGS)
                    .executeAndFetchFirst(UserEntity.class);

            infoLogMessage.userFoundById();
            return userEntity;
        } catch (Exception e) {
            errorLogMessage.errorWhenFindingUserById();
            throw new DataBaseSystemException(e);
        }
    }

    @Override
    public List<UserEntity> getAllUsersByStatus(String status) {
        try (Connection con = sql2o.open(); Query query = con.createQuery(GET_ALL_USERS_BY_STATUS)) {
            List<UserEntity> users =
                    query
                            .addParameter("status", status)
                            .setColumnMappings(COLUMN_MAPPINGS)
                            .executeAndFetch(UserEntity.class);
            infoLogMessage.allUsersFound();
            return users;
        } catch (Exception e) {
            errorLogMessage.errorWhenFindingAllUsers();
            throw new DataBaseSystemException(e);
        }
    }

    @Override
    public List<UserEntity> getAllUsers() {
        try (Connection con = sql2o.open(); Query query = con.createQuery(GET_ALL_USERS)) {
            List<UserEntity> userEntityList =
                    query
                            .addParameter("status", "A")
                            .addParameter("status1", "D")
                            .setColumnMappings(COLUMN_MAPPINGS)
                            .executeAndFetch(UserEntity.class);
            infoLogMessage.allUsersFound();
            return userEntityList;
        } catch (Exception e) {
            errorLogMessage.errorWhenFindingAllUsers();
            throw new DataBaseSystemException(e);
        }

    }

    @Override
    public String saveUser(UserEntity user) {
        try (Connection con = sql2o.open(); Query query = con.createQuery(SAVE_USER)) {
            query
                    .addParameter(NAME.getEntityPropertyValue(), user.getName())
                    .addParameter(STATUS.getEntityPropertyValue(), "A")
                    .addParameter(AGE.getEntityPropertyValue(), user.getAge())
                    .addParameter(JOB.getEntityPropertyValue(), user.getJob())
                    .addParameter(GENDER.getEntityPropertyValue(), user.getGender())
                    .addParameter(PLACEOFBIRTH.getEntityPropertyValue(), user.getPlaceOfBirth())
                    .addParameter(CREATED_USER.getEntityPropertyValue(), "Beran")
                    .addParameter(CREATED_DATE.getEntityPropertyValue(), new Date())
                    .executeUpdate();
            infoLogMessage.userSaved();
            return getMaxId();
        } catch (Exception e) {
            errorLogMessage.errorWhenSavingUser();
            throw new DataBaseSystemException(e);
        }

    }

    @Override
    public String updateUser(UserEntity user, String id) {
        try (Connection con = sql2o.open(); Query query = con.createQuery(UPDATE_USER)) {
            query
                    .addParameter(ID.getEntityPropertyValue(), id)
                    .addParameter(NAME.getEntityPropertyValue(), user.getName())
                    .addParameter(AGE.getEntityPropertyValue(), user.getAge())
                    .addParameter(JOB.getEntityPropertyValue(), user.getJob())
                    .addParameter(GENDER.getEntityPropertyValue(), user.getGender())
                    .addParameter(PLACEOFBIRTH.getEntityPropertyValue(), user.getPlaceOfBirth())
                    .addParameter(MODIFIED_USER.getEntityPropertyValue(), "BeranModified")
                    .addParameter(MODIFIED_DATE.getEntityPropertyValue(), new Date())
                    .executeUpdate();
            infoLogMessage.userUpdated();
            return id;
        } catch (Exception e) {
            errorLogMessage.errorWhenUpdatingUser();
            throw new DataBaseSystemException(e);
        }
    }

    @Override
    public void deleteUser(String id) {
        try (Connection con = sql2o.open(); Query query = con.createQuery(DELETE_USER)) {
            query
                    .addParameter(ID.getEntityPropertyValue(), id)
                    .addParameter(STATUS.getEntityPropertyValue(), "D")
                    .addParameter(MODIFIED_USER.getEntityPropertyValue(), "BeranModifiedDelete")
                    .addParameter(MODIFIED_DATE.getEntityPropertyValue(), new Date())
                    .executeUpdate();
            infoLogMessage.userDeleted();
        } catch (Exception e) {
            errorLogMessage.errorWhenDeletingUser();
            throw new DataBaseSystemException(e);
        }
    }

    @Override
    public String getMaxId() {
        try (Connection con = sql2o.open(); Query query = con.createQuery(GET_MAX_ID)) {

            String maxId = query
                    .executeAndFetchFirst(String.class);
            infoLogMessage.maxIdFound();
            return maxId;
        } catch (Exception e) {
            errorLogMessage.errorWhenFindingMaxId();
            throw new DataBaseSystemException(e);
        }
    }

    @Override
    public String getUserStatusById(String id) {
        try (Connection con = sql2o.open(); Query query = con.createQuery(GET_USER_STATUS_BY_ID)) {
            String statusFromDb =
                    query
                            .addParameter(ID.getEntityPropertyValue(), id)
                            .executeAndFetchFirst(String.class);
            if (!StringUtils.hasText(statusFromDb))
                errorLogMessage.errorWhenFindingUserById();
            return statusFromDb;
        } catch (Exception e) {
            errorLogMessage.errorWhenFindingUserById();
            throw new DataBaseSystemException(e);
        }
    }
}

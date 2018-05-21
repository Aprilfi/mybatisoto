package com.yidu.dao;

import com.yidu.domain.UserData;

import java.util.List;

public interface UserDataDao {

    public boolean addUserData( UserData userData );

    public List<UserData> findUserDataByName( String name );

}

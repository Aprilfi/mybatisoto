package com.yidu.biz;

import com.yidu.domain.UserData;

import java.util.List;

public interface UserDataBiz {

    public boolean addUser(UserData userData);

    public List<UserData> queryUserByName( String name );

}

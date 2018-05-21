package com.yidu.biz.impl;

import com.yidu.biz.UserDataBiz;
import com.yidu.dao.UserDataDao;
import com.yidu.domain.UserData;
import com.yidu.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserDataBizImpl implements UserDataBiz {

    private UserDataDao userDataDao = MyBatisUtil.getSqlSession().getMapper(UserDataDao.class);


    @Override
    public boolean addUser( UserData userData ) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();

        UserDataDao userDataDao = sqlSession.getMapper(UserDataDao.class);
        userDataDao.addUserData( userData );
        sqlSession.commit();
        sqlSession.close();

        return true;
    }

    @Override
    public List<UserData> queryUserByName(String name ) {

        return userDataDao.findUserDataByName( name );
    }
}

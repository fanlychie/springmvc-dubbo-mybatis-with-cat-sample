package org.fanlychie.facade.dao.impl;

import org.fanlychie.entity.User;
import org.fanlychie.facade.dao.UserDao;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by fanlychie on 2018/7/28.
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    public User queryByUsername(String username) {
        return sqlSessionTemplate.selectOne("queryByUsername", username);
    }

}
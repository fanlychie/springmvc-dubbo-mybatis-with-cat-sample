package org.fanlychie.facade.dao;

import org.fanlychie.entity.User;

/**
 * Created by fanlychie on 2018/7/28.
 */
public interface UserDao {

    User queryByUsername(String username);

}
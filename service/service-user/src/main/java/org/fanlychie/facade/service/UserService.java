package org.fanlychie.facade.service;

import org.fanlychie.entity.Article;
import org.fanlychie.entity.User;
import org.fanlychie.facade.ArticleFacade;
import org.fanlychie.facade.UserFacade;
import org.fanlychie.facade.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by fanlychie on 2018/7/28.
 */
@Service
public class UserService implements UserFacade {

    @Autowired
    private UserDao userDao;

    @Autowired
    private ArticleFacade articleFacade;

    @Override
    public User queryByUsername(String username) {
        if (!StringUtils.hasText(username)) {
            throw new IllegalArgumentException();
        }
        return userDao.queryByUsername(username);
    }

    @Override
    public List<Article> queryArticlesByUserId(Long userId) {
        if (userId == null || userId <= 0) {
            throw new IllegalArgumentException();
        }
        return articleFacade.queryByUserId(userId);
    }

}
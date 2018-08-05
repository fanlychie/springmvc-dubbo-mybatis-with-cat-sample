package org.fanlychie.facade.service;

import org.fanlychie.entity.Article;
import org.fanlychie.facade.ArticleFacade;
import org.fanlychie.facade.dao.ArticleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fanlychie on 2018/7/28.
 */
@Service
public class ArticleService implements ArticleFacade {

    @Autowired
    private ArticleDao articleDao;

    @Override
    public List<Article> queryByUserId(Long userId) {
        if (userId == null || userId <= 0) {
            throw new IllegalArgumentException();
        }
        return articleDao.queryByUserId(userId);
    }

}
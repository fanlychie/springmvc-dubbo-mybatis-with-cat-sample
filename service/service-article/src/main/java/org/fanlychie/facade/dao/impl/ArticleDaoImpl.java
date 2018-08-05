package org.fanlychie.facade.dao.impl;

import org.fanlychie.entity.Article;
import org.fanlychie.facade.dao.ArticleDao;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by fanlychie on 2018/7/28.
 */
@Repository
public class ArticleDaoImpl implements ArticleDao {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    public List<Article> queryByUserId(Long userId) {
        return sqlSessionTemplate.selectList("queryByUserId", userId);
    }

}
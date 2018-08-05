package org.fanlychie.facade.dao;

import org.fanlychie.entity.Article;
import java.util.List;

/**
 * Created by fanlychie on 2018/7/28.
 */
public interface ArticleDao {

    List<Article> queryByUserId(Long userId);

}
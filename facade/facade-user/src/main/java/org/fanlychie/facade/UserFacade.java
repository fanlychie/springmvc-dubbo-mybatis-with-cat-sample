package org.fanlychie.facade;

import org.fanlychie.entity.Article;
import org.fanlychie.entity.User;

import java.util.List;

/**
 * Created by fanlychie on 2018/7/28.
 */
public interface UserFacade {

    User queryByUsername(String username);

    List<Article> queryArticlesByUserId(Long userId);

}
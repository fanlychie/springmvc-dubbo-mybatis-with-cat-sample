> `SpringMVC` + `Dubbo` + `MyBatis` 接入大众点评 `CAT` 监控平台样例

集成文档：

[http://fanlychie.github.io/post/springmvc-dubbo-mybatis-with-cat.html](http://fanlychie.github.io/post/springmvc-dubbo-mybatis-with-cat.html)

---

样例项目结构：

![](https://raw.githubusercontent.com/fanlychie/mdimg/master/cat-sample-project.png)

注：`common-core`模块已经拆解为`cat-client-dubbo`项目。项目地址为[「https://github.com/fanlychie/cat-client-dubbo」](https://github.com/fanlychie/cat-client-dubbo)

---

数据库脚本：

springmvc-dubbo-mybatis-with-cat-sample/cat_demo_schema.sql

---

项目运行方式：

![](https://raw.githubusercontent.com/fanlychie/mdimg/master/cat-sample-service-article.png)

![](https://raw.githubusercontent.com/fanlychie/mdimg/master/cat-sample-service-user.png)

![](https://raw.githubusercontent.com/fanlychie/mdimg/master/cat-sample-web-blog.png)

---

访问地址：

http://localhost:8080/blog/user/login?username=admin&password=admin
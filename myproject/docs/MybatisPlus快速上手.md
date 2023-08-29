## Myba t i s P l u s 快速 上手

l 第一节 ORM介绍 

l 第二节 MyBatis-Plus介绍 

l 第三节 MyBatis-Plus CRUD操



### ORM介绍

-  ORM（Object Relational Mapping，对象关系映射）是为了解决面向对象与 关系数据库存在的互不匹配现象的一种技术。 
-  ORM通过使用描述对象和数据库之间映射的元数据将程序中的对象自动持久化 到关系数据库中。 
- ORM框架的本质是简化编程中操作数据库的编码。



### MyBatis-Plus介绍

- MyBatis是一款优秀的数据持久层ORM框架，被广泛地应用于应用系统。
- MyBatis能够非常灵活地实现动态SQL，可以使用XML或注解来配置和映射原 生信息，能够轻松地将Java的POJO（Plain Ordinary Java Object，普通的 Java对象）与数据库中的表和字段进行映射关联。 
- MyBatis-Plus是一个 MyBatis 的增强工具，在 MyBatis 的基础上做了增强， 简化了开发。

添加依赖

```
        <!--代码生成器(新版) -->
        <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatis-plus-boot-starter</artifactId>
            <version>3.5.1</version>
        </dependency>
        <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatis-plus-generator</artifactId>
            <version>3.5.2</version>
        </dependency>
        <!-- Mysql -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
        </dependency>
```

配置文件

```
# Database
spring.datasource.url=jdbc:mysql://localhost:3306/myproject?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8
spring.datasource.username=root
spring.datasource.password=123456
```



数据库连接池Druid

**1、为什么要使用数据库连接池？**

> 创建数据库连接（TCP连接建立时需要三次握手）是一个很耗时的过程，在使用完之后，还需要不断的释放建立的连接（销毁时需要四次握手），对资源的损耗比较大。
>
> 数据库连接池会将已经创建好的连接保存在池中，当有请求来时，直接使用已经创建好的连接访问数据库，这样可以省略创建连接和销毁连接的过程，从而提高性能。这样做的缺点是，可能某些时候完全没有数据库请求，但是也保持了数据库的最小连接数，浪费了资源，不过这种资源浪费相对于完全不采用数据库连接池还是很有优势的。

**2、常用的数据库连接池**

> 目前市场上常用的数据库连接池有：C3P0、Proxool、DBCP、Tomcat JDBC Pool、HiKariCP 和 Druid
>
> 性能方面：HiKariCP > Druid > Tomcat JDBC Pool > DBCP > C3P0 > Proxool

## Druid的使用

详细配置前往 ---> [Spring Boot 整合 Druid 指南](https://developer.aliyun.com/article/1157595)

[官方文档]([Druid介绍 · ApacheDruid中文技术文档 (apache-druid.cn)](http://www.apache-druid.cn/GettingStarted/chapter-1.html))

**1、引入依赖**

```
        <!--引入druid数据源-->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid-spring-boot-starter</artifactId>
            <version>1.1.20</version>
        </dependency>
```

**2、配置application-dev.yml配置文件**

```
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/springboot_test?characterEncoding=utf8&serverTimezone=UTC
    username: root
    password: root
    # druid-spring-boot-starter 依赖自动生效 druid，可以不配置 type 属性，但建议配置
    type: com.alibaba.druid.pool.DruidDataSource
```

**3、实体类和dao层配置**


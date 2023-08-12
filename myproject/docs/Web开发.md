## Web开发基础

[TOC]



### **Web入门：**

1. Spring Boot将传统Web开发的mvc、json、tomcat等框架整合，提供了 spring-boot-starter-web组件，简化了Web应用配置。

2. 创建SpringBoot项目勾选Spring Web选项后，会自动将spring-boot-starter- web组件加入到项目中。

3. spring-boot-starter-web启动器主要包括web、webmvc、json、tomcat等 基础依赖组件，作用是提供Web开发场景所需的所有底层依赖。

4. webmvc为Web开发的基础框架，json为JSON数据解析组件，tomcat为自带 的容器依赖。

   ```java
   <dependency>
       <groupId>org.springframework.boot</groupId>
   	<artifactId>spring-boot-starter-web</artifactId>
   </dependency>
   ```

#### **控制器 ：**

1. Spring Boot提供了@Controller和@RestController两种注解来标识此类负责 接收和处理HTTP请求。

2. 如果请求的是页面和数据，使用@Controller注解即可；如果只是请求数据， 则可以使用@RestController注解。

   ![](E:\1studyfiles\IDEA\MyProject\myproject\docs\img\img1.png)

#### @Controller的用法

1. 示例中返回了hello页面和name的数据，在前端页面中可以通过${name}参数 获取后台返回的数据并显示。
2. @Controller通常与Thymeleaf模板引擎结合使用。
3. 

#### @RestController的用法

1. 默认情况下，@RestController注解会将返回的对象数据转换为JSON格式。



## Web开发进阶

### 静态资源访问

1. 

### 文件上传

> 文件上传原理：
>
>  表单的enctype 属性规定在发送到服务器之前应该如何对表单数据进行编码。  当表单的enctype="application/x-www-form-urlencoded"（默认）时， form表单中的数据格式为：key=value&key=value ，当表单的enctype="multipart/form-data"时，其传输数据形式如下
>
> ![](img\img2.png)

1. Spring Boot工程嵌入的tomcat限制了请求的文件大小，每个文件的配置最大 为1Mb，单次请求的文件的总数不能大于10Mb（更改这个默认值需要在配置文件（如application.properties）中加入两个配置）

   ```
   spring.servlet.multipart.max-file-size=10MB
   spring.servlet.multipart.max-request-size=10MB
   ```

   

- **实现文件上传功能**

> 当表单的enctype="multipart/form-data"时,可以使用MultipartFile 获取上传 的文件数据，再通过transferTo方法将其写入到磁盘中

```

```



### 拦截器













![](img\img3.png)

编译过的文件

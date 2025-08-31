# parameter-validation-with-springboot
using annotation for springboot project request body, request parameter, path parameter validation

## 前置知识

- 创建简单的基于springboot的web项目
- 基于restful风格的接口设计
- 使用flyway来进行数据库脚本的版本管理
- 使用mapstruct进行对象之间的转换
- 使用lombok来自动生成getter、setter等方法
- 使用Apifox插件进行接口管理（接口维护、接口文档生成）

## 目的
对于一个应用来说，对用户请求进行校验是保证应用安全的一个重要方面。

## 内容

这个项目聚焦于使用注解来对用户请求进行校验，包括如下几部分：

- 对request body进行校验
- 对request param进行校验
- 对path variable进行校验

### 初级

校验的字段属性包括：

- 字符串：null校验、空校验、长度校验
- 数字：null校验、取值校验
- 日期：null校验、格式校验、范围校验
- 集合：数量校验

### 高级

- 字符串：正则校验（邮箱、电话、密码等）
- 密码：2个属性一致性校验
- 枚举：取值有效性校验
- 分组校验（同一参数对于不同的接口来说校验规则不同）

## 实现


### jakarta validation

Java开发者在Java API规范 (JSR303) 定义了Bean校验的标准validation-api。

引入依赖：`jakarta.validation:jakarta.validation-api:3.0.2`

提供的注解：
- @AssertFalse, @AssertTrue：对boolean类型字段进行校验
- @DecimalMax, @DecimalMin：对decimal字段类型的范围进行校验
- @Digits：对数值字段类型精细校验
- @Email：对邮箱格式进行校验
- @Future, @FutureOrPresent, @Past, @PastOrPresent：对日期进行校验，比如出生日期必须为过去的日期
- @Max, @Min：对字段范围进行校验，比如年龄必须大于18岁
- @Negative, @NegativeOrZero, @Positive, @PositiveOrZero：对数值进行校验，比如余额、年龄必须为正数
- @NotNull, @Null, @NotEmpty, @NotBlank：可以对必填和可选参数参数进行校验
- @Size：用于校验字符序列、集合、Map、数组中的元素个数，比如可以限制一次请求的用户数量
- @Pattern：正则校验，比如电话号码、邮箱、用户名必须满足一定的正则规则

### Hibernate Validation

hibernate validation是对`jakarta.validation-api`的一些补充，增加了一些校验注解如@Length、@URL、@UUID、@Range等。

引入依赖：`org.hibernate.validator:hibernate-validator`

### Spring Boot Validation

Spring Validation是对hibernate validation的二次封装，用于支持spring mvc参数自动校验。

引入依赖：`org.springframework.boot:spring-boot-starter-validation`

#### 分组校验

用途：区分场景校验，不同场景的校验规则不同，创建用户id必须为null，更新用户id不能为null

示例：对于UserDTO对象的id字段，在创建时必须为null，在更新时不能为null，就可以使用分组校验。

注意：@Valid不支持分组校验，必须使用@Validated

## 自定义参数校验

### 枚举类校验

示例：自定义了`@EnumValid`，用于校验string可以转换为指定的枚举类

### 跨字段校验

示例：自定义了`@PasswordValid`注解和`PasswordValidator`，用于校验两次密码一致。

## 全局异常统一处理

定义GlobalExceptionHandler类， 使用@ControllerAdvice表明这是一个异常处理类。

在方法上使用@ExceptionHandler注解，当对应的异常发生时，Spring会自动调用该方法。

还可以使用@ResponseStatus指定响应的状态码。

自定义的校验注解，也会将异常信息封装到BindingResult的AllErrors中，在全局异常处理的时候，封装到Result中。

## 启动

启动mysql

```bash
docker run --name mysql8.1 \
-p 3306:3306 \
-e MYSQL_ROOT_PASSWORD=p@ssw0rd \
-d mysql:8.1.0 \
--character-set-server=utf8mb4 --collation-server=utf8mb4_unicode_ci
```

创建schema

```mysql
create schema test_db;
```

启动服务

```bash
./gradlew bootRun
```

## 总结

本项目我们一共介绍了以下4种参数校验的实现：

- jakarta validation api：参数校验标准API
- hibernate validation api：提供了一些高级的校验注解
- SpringBoot validation api：提供了分组参数校验等高级功能
- 自定义参数校验

推荐优先使用jakarta validation api，如果不能满足需求，再考虑使用其他的API。
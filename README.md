# parameter-validation-with-springboot
using annotation for springboot project request body, request parameter, path parameter validation

## 前置知识

- 创建简单的基于springboot的web项目
- 了解restful接口设计

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

## 参数校验

Java开发者在Java API规范 (JSR303) 定义了Bean校验的标准validation-api，但没有提供实现。

引入依赖：`jakarta.validation:jakarta.validation-api:3.0.2`

提供的注解：
- AssertFalse, AssertTrue
- DecimalMax, DecimalMin
- Digits
- Email
- Future, FutureOrPresent, Past, PastOrPresent
- Max, Min
- Negative, NegativeOrZero, Positive, PositiveOrZero
- NotNull, Null, NotEmpty, NotBlank
- Size

### hibernate validation

hibernate validation是对这个规范的实现，并增加了校验注解如@Email、@Length等。

引入依赖：`org.hibernate.validator:hibernate-validator`


### Spring的实现

Spring Validation是对hibernate validation的二次封装，用于支持spring mvc参数自动校验。

### 分组校验
区分场景校验，不同场景的校验规则不同，创建用户id必须为null，更新用户id不能为null
@Valid不再适用，只能用@Validated

### 枚举类校验

@ValueOfEnum：校验string可以转换为指定的枚举类

### 跨字段校验

@PasswordValid：校验两次密码一致

### @Valid注解不生效

引入：`org.springframework.boot:spring-boot-starter-validation`

### 自定义的校验无法返回将异常信息封装到BindingResult，从而导致全局异常处理器拿不到校验失败信息

todo

## 启动

启动mysql
```bash
docker run --name mysql8.1 \
-p 3306:3306 \
-e MYSQL_ROOT_PASSWORD=p@ssw0rd \
-d mysql:8.1.0 \
--character-set-server=utf8mb4 --collation-server=utf8mb4_unicode_ci
```
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


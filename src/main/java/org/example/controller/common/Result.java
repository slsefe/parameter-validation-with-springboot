package org.example.controller.common;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Result<T> {
    private Integer code;
    private String message;
    private T data;

    // 禁止直接暴露字段名给前端，攻击者会利用字段名信息
    // 错误信息字典化管理（如何国际化？）
    public static <T> Result<T> fail(String message) {
        return new Result<>(500, message, null);
    }
}

package org.example.controller.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.ToString;
import org.example.enums.Gender;
import org.example.validator.CreateGroup;
import org.example.validator.PasswordValid;
import org.example.validator.UpdateGroup;
import org.example.validator.EnumValid;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


@Data
@ToString
@PasswordValid(groups = {CreateGroup.class})
public class UserDTO {
    @NotNull(groups = UpdateGroup.class, message = "更新用户id不能为null")
    @Null(groups = CreateGroup.class, message = "创建用户id必须为null")
    private Long id;

    @NotBlank(message = "姓名不能为空", groups = {CreateGroup.class, UpdateGroup.class})
    @Pattern(regexp = "[A-Z][a-z]+", groups = {CreateGroup.class, UpdateGroup.class}, message = "姓名只能包含字母，且以大写字母开头")
    @Size(min = 1, max = 10, groups = {CreateGroup.class, UpdateGroup.class}, message = "姓名长度必须在1-10之间")
    private String firstName;

    @NotBlank(message = "姓名不能为空", groups = {CreateGroup.class, UpdateGroup.class})
    @Pattern(regexp = "[A-Z][a-z]+", groups = {CreateGroup.class, UpdateGroup.class}, message = "姓名只能包含字母，且以大写字母开头")
    @Size(min = 1, max = 10, groups = {CreateGroup.class, UpdateGroup.class}, message = "姓名长度必须在1-10之间")
    private String lastName;


    @NotNull(message = "邮箱不能为空", groups = {CreateGroup.class, UpdateGroup.class})
    @Email(message = "邮箱格式不正确", groups = {CreateGroup.class, UpdateGroup.class})
    private String email;

    @NotNull(message = "电话不能为空", groups = {CreateGroup.class, UpdateGroup.class})
    @Pattern(regexp = "^1[3-9]\\d{9}$", groups = {CreateGroup.class, UpdateGroup.class}, message = "电话格式不正确")
    private String phone;

    private String password1;

    private String password2;

    @Min(value = 1, groups = {CreateGroup.class, UpdateGroup.class}, message = "年龄最小为1岁")
    @Max(value = 120, groups = {CreateGroup.class, UpdateGroup.class}, message = "年龄最大为120岁")
    private int age;

    @EnumValid(groups = {CreateGroup.class, UpdateGroup.class}, enumClass = Gender.class)
    private String gender;

    @Past(groups = {CreateGroup.class, UpdateGroup.class}, message = "出生日期只能为过去的日期")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "yyyy-MM-dd")
    private LocalDate birthday;

}

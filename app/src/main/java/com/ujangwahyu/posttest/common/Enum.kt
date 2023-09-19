package com.ujangwahyu.posttest.common

enum class Enum(val message: String){
    USER_INVALID("Incorrect Username or Password"),
    SUCCESS("Successful"),
    USERNAME_EMPTY("Username cannot be empty"),
    USERNAME_INVALID_LENGTH("Username must be at least 3 letters"),
    NAME_EMPTY("Name cannot be empty"),
    NAME_INVALID_LENGTH("Name must be at least 3 letters"),
    NIK_EMPTY("NIK cannot be empty"),
    NIK_INVALID_LENGTH("NIK must 16 digits"),
    EMAIL_EMPTY("Email cannot be empty"),
    EMAIL_INVALID_FORMAT("The email does not match the format"),
    PASSWORD_EMPTY("Password cannot be empty"),
    PASSWORD_INVALID_LENGTH("Password must be at least 6 letters"),
}
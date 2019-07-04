package com.example.dev.databinding;

/**
 * Desc:
 * Author: zhangwenshun
 * Date: 2019/7/2
 * Company: @有门网络科技
 * Update Comments:
 */
public class User {
    private String firstName;
    private String lastName;
    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public String getFirstName() {
        return this.firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
}

package com.yidu.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class UserData implements Serializable {

    private static final long serialVersionUID = 8458010487998419223L;

    /*
     * 用户姓名
     */
    private String name;

    /*
     * 用户密码
     */
    private String password;

    /*
     * 用户性别
     */
    private String sex;

    /*
     * 用户出生日期
     */
    private String birthday;

    /*
     * 用户手机号码
     */
    private String phonw;

    public UserData() {
    }

    public UserData(String name, String password, String sex, String birthday, String phonw) {
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.birthday = birthday;
        this.phonw = phonw;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhonw() {
        return phonw;
    }

    public void setPhonw(String phonw) {
        this.phonw = phonw;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserData userData = (UserData) o;
        return Objects.equals(name, userData.name) &&
                Objects.equals(password, userData.password) &&
                Objects.equals(sex, userData.sex) &&
                Objects.equals(birthday, userData.birthday) &&
                Objects.equals(phonw, userData.phonw);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, password, sex, birthday, phonw);
    }

    @Override
    public String toString() {
        return "UserData{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday='" + birthday + '\'' +
                ", phonw='" + phonw + '\'' +
                '}';
    }
}

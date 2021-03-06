package com.example.framework.demoparent.entity;

import java.math.BigDecimal;

public class TAccount extends TAccountKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_account.user_name
     *
     * @mbg.generated Tue Aug 14 11:27:57 CST 2018
     */
    private String userName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_account.money
     *
     * @mbg.generated Tue Aug 14 11:27:57 CST 2018
     */
    private BigDecimal money;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_account.age
     *
     * @mbg.generated Tue Aug 14 11:27:57 CST 2018
     */
    private Integer age;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_account.remark
     *
     * @mbg.generated Tue Aug 14 11:27:57 CST 2018
     */
    private String remark;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_account.user_name
     *
     * @return the value of t_account.user_name
     * @mbg.generated Tue Aug 14 11:27:57 CST 2018
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_account.user_name
     *
     * @param userName the value for t_account.user_name
     * @mbg.generated Tue Aug 14 11:27:57 CST 2018
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_account.money
     *
     * @return the value of t_account.money
     * @mbg.generated Tue Aug 14 11:27:57 CST 2018
     */
    public BigDecimal getMoney() {
        return money;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_account.money
     *
     * @param money the value for t_account.money
     * @mbg.generated Tue Aug 14 11:27:57 CST 2018
     */
    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_account.age
     *
     * @return the value of t_account.age
     * @mbg.generated Tue Aug 14 11:27:57 CST 2018
     */
    public Integer getAge() {
        return age;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_account.age
     *
     * @param age the value for t_account.age
     * @mbg.generated Tue Aug 14 11:27:57 CST 2018
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_account.remark
     *
     * @return the value of t_account.remark
     * @mbg.generated Tue Aug 14 11:27:57 CST 2018
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_account.remark
     *
     * @param remark the value for t_account.remark
     * @mbg.generated Tue Aug 14 11:27:57 CST 2018
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TAccount{");
        sb.append("userName='").append(userName).append('\'');
        sb.append(", money=").append(money);
        sb.append(", age=").append(age);
        sb.append(", remark='").append(remark).append('\'');
        sb.append('}');
        return super.toString() + ":" + sb.toString();
    }
}
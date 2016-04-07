package yjy.com.accounts.databases;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "ACCOUNT_INFO".
 */
public class AccountInfo {

    private Long id;
    private double cost;
    /** Not-null value. */
    private String paymethod;
    /** Not-null value. */
    private String usage;
    /** Not-null value. */
    private String remark;
    /** Not-null value. */
    private java.util.Date date;

    public AccountInfo() {
    }

    public AccountInfo(Long id) {
        this.id = id;
    }

    public AccountInfo(Long id, double cost, String paymethod, String usage, String remark, java.util.Date date) {
        this.id = id;
        this.cost = cost;
        this.paymethod = paymethod;
        this.usage = usage;
        this.remark = remark;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    /** Not-null value. */
    public String getPaymethod() {
        return paymethod;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setPaymethod(String paymethod) {
        this.paymethod = paymethod;
    }

    /** Not-null value. */
    public String getUsage() {
        return usage;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setUsage(String usage) {
        this.usage = usage;
    }

    /** Not-null value. */
    public String getRemark() {
        return remark;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /** Not-null value. */
    public java.util.Date getDate() {
        return date;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setDate(java.util.Date date) {
        this.date = date;
    }

}

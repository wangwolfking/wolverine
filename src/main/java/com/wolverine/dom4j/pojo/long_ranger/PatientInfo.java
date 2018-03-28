/**
 * Project Name: wolverine
 * Package Name: com.wolverine.dom4j.pojo
 * File    Name: PatientInfo.java
 * Create  Date: 2018-03-28 10:37
 * Copyright (c) 2018, www.yocaly.com All Rights Reserved.
 * 注意：本内容仅限于山东优加利信息科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */

package com.wolverine.dom4j.pojo.long_ranger;

/**
 * 描述：TODO 用一句话描述这个类的作用（必选）. <br>
 * 背景：TODO 描述创建该类的背景原因（可选）. <br>
 * 日期：2018-03-28 10:37 <br>
 * 变更：
 * <pre>
 * Version      Date           ModifiedBy       Content
 * --------     ----------     ------------     -----------------------
 * 1.0          2018-03-28     wangzhigang.           创建
 * </pre>
 * @since   JDK 1.8
 * @version 1.0
 * @author  yocaly team
 */
public class PatientInfo {
    private String OrderID;
    private String Name;
    private String Sex;
    private String Age;
    private String BirthDay;
    private String OwnerMonitorName;
    private String IDreport;
    private String ProomNum;
    private String ProomType;
    private String Department;
    private String MitRefPhysician;
    private String MitAnalyst;
    private String phone;
    public String getOrderID() {
        return OrderID;
    }
    public void setOrderID(String orderID) {
        OrderID = orderID;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getSex() {
        return Sex;
    }
    public void setSex(String sex) {
        Sex = sex;
    }
    public String getAge() {
        return Age;
    }
    public void setAge(String age) {
        Age = age;
    }
    public String getBirthDay() {
        return BirthDay;
    }
    public void setBirthDay(String birthDay) {
        BirthDay = birthDay;
    }
    public String getOwnerMonitorName() {
        return OwnerMonitorName;
    }
    public void setOwnerMonitorName(String ownerMonitorName) {
        OwnerMonitorName = ownerMonitorName;
    }
    public String getIDreport() {
        return IDreport;
    }
    public void setIDreport(String iDreport) {
        IDreport = iDreport;
    }
    public String getProomNum() {
        return ProomNum;
    }
    public void setProomNum(String proomNum) {
        ProomNum = proomNum;
    }
    public String getProomType() {
        return ProomType;
    }
    public void setProomType(String proomType) {
        ProomType = proomType;
    }
    public String getDepartment() {
        return Department;
    }
    public void setDepartment(String department) {
        Department = department;
    }
    public String getMitRefPhysician() {
        return MitRefPhysician;
    }
    public void setMitRefPhysician(String mitRefPhysician) {
        MitRefPhysician = mitRefPhysician;
    }
    public String getMitAnalyst() {
        return MitAnalyst;
    }
    public void setMitAnalyst(String mitAnalyst) {
        MitAnalyst = mitAnalyst;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
}

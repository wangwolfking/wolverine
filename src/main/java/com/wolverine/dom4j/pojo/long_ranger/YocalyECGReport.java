/**
 * Project Name: wolverine
 * Package Name: com.wolverine.dom4j.pojo
 * File    Name: YocalyECGReport.java
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
 * 
 * <pre>
 * Version      Date           ModifiedBy       Content
 * --------     ----------     ------------     -----------------------
 * 1.0          2018-03-28     wangzhigang.           创建
 * </pre>
 * 
 * @since JDK 1.8
 * @version 1.0
 * @author yocaly team
 */
public class YocalyECGReport {
    private PatientInfo patientInfo;
    private HourEventList hourEventList;
    private ReportSummary reportSummary;
    private EcgFragmentList ecgFragmentList;
    private EcgList ecgList;
    private ReportHeader reportHeader;

    public PatientInfo getPatientInfo() {
        return patientInfo;
    }

    public void setPatientInfo(PatientInfo patientInfo) {
        this.patientInfo = patientInfo;
    }

    public HourEventList getHourEventList() {
        return hourEventList;
    }

    public void setHourEventList(HourEventList hourEventList) {
        this.hourEventList = hourEventList;
    }

    public ReportSummary getReportSummary() {
        return reportSummary;
    }

    public void setReportSummary(ReportSummary reportSummary) {
        this.reportSummary = reportSummary;
    }

    public EcgFragmentList getEcgFragmentList() {
        return ecgFragmentList;
    }

    public void setEcgFragmentList(EcgFragmentList ecgFragmentList) {
        this.ecgFragmentList = ecgFragmentList;
    }

    public EcgList getEcgList() {
        return ecgList;
    }

    public void setEcgList(EcgList ecgList) {
        this.ecgList = ecgList;
    }

    public ReportHeader getReportHeader() {
        return reportHeader;
    }

    public void setReportHeader(ReportHeader reportHeader) {
        this.reportHeader = reportHeader;
    }

}

/**
 * Project Name: wolverine
 * Package Name: com.wolverine.dom4j.pojo
 * File    Name: ReportHeader.java
 * Create  Date: 2018-03-28 10:38
 * Copyright (c) 2018, www.yocaly.com All Rights Reserved.
 * 注意：本内容仅限于山东优加利信息科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */

package com.wolverine.dom4j.pojo.long_ranger;

import java.util.List;

/**
 * 描述：TODO 用一句话描述这个类的作用（必选）. <br>
 * 背景：TODO 描述创建该类的背景原因（可选）. <br>
 * 日期：2018-03-28 10:38 <br>
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
public class ReportHeader {
    private String LeadCount;
    private String StartTime;
    private String EndTime;
    private String ReportTime;
    private String TestTime;
    private String LeadMain;
    private String Plus;
    private String ReportType;
    private String SampleRate;
    private String FileHeaderSize;
    private String DataHeaderSize;
    private String DataSize;
    private String MV;
    private String CanUpdateData;
    private String DataVersion;
    private String MonitorName;
    private String DoctorCode;
    private String DoctorName;
    private String SuperName;
    private String DoctorAdvice;
    private String AnalyBaseLead;
    private String SVPBCoefPermature;
    private String IsPrintDataPart;
    private String IsAnalysisST;
    private String EquipNo;
    private String OperatorName;
    private String WarmHint;
    private String UseMedicate;
    private String CardiaCpaceMake;
    private String SaveAction;
    private String OperatorCode;
    private String CardiacType;
    private List<Lead> leads;

    public List<Lead> getLeads() {
        return leads;
    }

    public void setLeads(List<Lead> leads) {
        this.leads = leads;
    }

    public String getLeadCount() {
        return LeadCount;
    }

    public void setLeadCount(String leadCount) {
        LeadCount = leadCount;
    }

    public String getStartTime() {
        return StartTime;
    }

    public void setStartTime(String startTime) {
        StartTime = startTime;
    }

    public String getEndTime() {
        return EndTime;
    }

    public void setEndTime(String endTime) {
        EndTime = endTime;
    }

    public String getReportTime() {
        return ReportTime;
    }

    public void setReportTime(String reportTime) {
        ReportTime = reportTime;
    }

    public String getTestTime() {
        return TestTime;
    }

    public void setTestTime(String testTime) {
        TestTime = testTime;
    }

    public String getLeadMain() {
        return LeadMain;
    }

    public void setLeadMain(String leadMain) {
        LeadMain = leadMain;
    }

    public String getPlus() {
        return Plus;
    }

    public void setPlus(String plus) {
        Plus = plus;
    }

    public String getReportType() {
        return ReportType;
    }

    public void setReportType(String reportType) {
        ReportType = reportType;
    }

    public String getSampleRate() {
        return SampleRate;
    }

    public void setSampleRate(String sampleRate) {
        SampleRate = sampleRate;
    }

    public String getFileHeaderSize() {
        return FileHeaderSize;
    }

    public void setFileHeaderSize(String fileHeaderSize) {
        FileHeaderSize = fileHeaderSize;
    }

    public String getDataHeaderSize() {
        return DataHeaderSize;
    }

    public void setDataHeaderSize(String dataHeaderSize) {
        DataHeaderSize = dataHeaderSize;
    }

    public String getDataSize() {
        return DataSize;
    }

    public void setDataSize(String dataSize) {
        DataSize = dataSize;
    }

    public String getMV() {
        return MV;
    }

    public void setMV(String mV) {
        MV = mV;
    }

    public String getCanUpdateData() {
        return CanUpdateData;
    }

    public void setCanUpdateData(String canUpdateData) {
        CanUpdateData = canUpdateData;
    }

    public String getDataVersion() {
        return DataVersion;
    }

    public void setDataVersion(String dataVersion) {
        DataVersion = dataVersion;
    }

    public String getMonitorName() {
        return MonitorName;
    }

    public void setMonitorName(String monitorName) {
        MonitorName = monitorName;
    }

    public String getDoctorCode() {
        return DoctorCode;
    }

    public void setDoctorCode(String doctorCode) {
        DoctorCode = doctorCode;
    }

    public String getDoctorName() {
        return DoctorName;
    }

    public void setDoctorName(String doctorName) {
        DoctorName = doctorName;
    }

    public String getSuperName() {
        return SuperName;
    }

    public void setSuperName(String superName) {
        SuperName = superName;
    }

    public String getDoctorAdvice() {
        return DoctorAdvice;
    }

    public void setDoctorAdvice(String doctorAdvice) {
        DoctorAdvice = doctorAdvice;
    }

    public String getAnalyBaseLead() {
        return AnalyBaseLead;
    }

    public void setAnalyBaseLead(String analyBaseLead) {
        AnalyBaseLead = analyBaseLead;
    }

    public String getSVPBCoefPermature() {
        return SVPBCoefPermature;
    }

    public void setSVPBCoefPermature(String sVPBCoefPermature) {
        SVPBCoefPermature = sVPBCoefPermature;
    }

    public String getIsPrintDataPart() {
        return IsPrintDataPart;
    }

    public void setIsPrintDataPart(String isPrintDataPart) {
        IsPrintDataPart = isPrintDataPart;
    }

    public String getIsAnalysisST() {
        return IsAnalysisST;
    }

    public void setIsAnalysisST(String isAnalysisST) {
        IsAnalysisST = isAnalysisST;
    }

    public String getEquipNo() {
        return EquipNo;
    }

    public void setEquipNo(String equipNo) {
        EquipNo = equipNo;
    }

    public String getOperatorName() {
        return OperatorName;
    }

    public void setOperatorName(String operatorName) {
        OperatorName = operatorName;
    }

    public String getWarmHint() {
        return WarmHint;
    }

    public void setWarmHint(String warmHint) {
        WarmHint = warmHint;
    }

    public String getUseMedicate() {
        return UseMedicate;
    }

    public void setUseMedicate(String useMedicate) {
        UseMedicate = useMedicate;
    }

    public String getCardiaCpaceMake() {
        return CardiaCpaceMake;
    }

    public void setCardiaCpaceMake(String cardiaCpaceMake) {
        CardiaCpaceMake = cardiaCpaceMake;
    }

    public String getSaveAction() {
        return SaveAction;
    }

    public void setSaveAction(String saveAction) {
        SaveAction = saveAction;
    }

    public String getOperatorCode() {
        return OperatorCode;
    }

    public void setOperatorCode(String operatorCode) {
        OperatorCode = operatorCode;
    }

    public String getCardiacType() {
        return CardiacType;
    }

    public void setCardiacType(String cardiacType) {
        CardiacType = cardiacType;
    }

}

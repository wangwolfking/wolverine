/**
 * Project Name: wolverine
 * Package Name: com.wolverine.dom4j.pojo.long_ranger
 * File    Name: ReportSummary.java
 * Create  Date: 2018-03-28 10:44
 * Copyright (c) 2018, www.yocaly.com All Rights Reserved.
 * 注意：本内容仅限于山东优加利信息科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */

package com.wolverine.dom4j.pojo.long_ranger;

/**
 * 描述：TODO 用一句话描述这个类的作用（必选）. <br>
 * 背景：TODO 描述创建该类的背景原因（可选）. <br>
 * 日期：2018-03-28 10:44 <br>
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
public class ReportSummary {
    private HeartRateSummary heartRateSummary;
    private SVTEvent svtEvent;
    private VTEvent vtEvent;
    private STEvent stEvent;
    private TWAEvent twaEvent;
    private BBBEvent bbbEvent;
    private SpecialEvent specialEvent;
    private HRTList hrtList;
    private QBEvent qbEvent;
    private STSumEvent stSumEvent;
    private QTEvent qtEvent;
    private SelectActionEvent selectActionEvent;
    private AFBeatAreaEvent afBeatAreaEvent;
    private HRVItemEvent hrvItemEvent;

    public HeartRateSummary getHeartRateSummary() {
        return heartRateSummary;
    }

    public void setHeartRateSummary(HeartRateSummary heartRateSummary) {
        this.heartRateSummary = heartRateSummary;
    }

    public SVTEvent getSvtEvent() {
        return svtEvent;
    }

    public void setSvtEvent(SVTEvent svtEvent) {
        this.svtEvent = svtEvent;
    }

    public VTEvent getVtEvent() {
        return vtEvent;
    }

    public void setVtEvent(VTEvent vtEvent) {
        this.vtEvent = vtEvent;
    }

    public STEvent getStEvent() {
        return stEvent;
    }

    public void setStEvent(STEvent stEvent) {
        this.stEvent = stEvent;
    }

    public TWAEvent getTwaEvent() {
        return twaEvent;
    }

    public void setTwaEvent(TWAEvent twaEvent) {
        this.twaEvent = twaEvent;
    }

    public BBBEvent getBbbEvent() {
        return bbbEvent;
    }

    public void setBbbEvent(BBBEvent bbbEvent) {
        this.bbbEvent = bbbEvent;
    }

    public SpecialEvent getSpecialEvent() {
        return specialEvent;
    }

    public void setSpecialEvent(SpecialEvent specialEvent) {
        this.specialEvent = specialEvent;
    }

    public HRTList getHrtList() {
        return hrtList;
    }

    public void setHrtList(HRTList hrtList) {
        this.hrtList = hrtList;
    }

    public QBEvent getQbEvent() {
        return qbEvent;
    }

    public void setQbEvent(QBEvent qbEvent) {
        this.qbEvent = qbEvent;
    }

    public STSumEvent getStSumEvent() {
        return stSumEvent;
    }

    public void setStSumEvent(STSumEvent stSumEvent) {
        this.stSumEvent = stSumEvent;
    }

    public QTEvent getQtEvent() {
        return qtEvent;
    }

    public void setQtEvent(QTEvent qtEvent) {
        this.qtEvent = qtEvent;
    }

    public SelectActionEvent getSelectActionEvent() {
        return selectActionEvent;
    }

    public void setSelectActionEvent(SelectActionEvent selectActionEvent) {
        this.selectActionEvent = selectActionEvent;
    }

    public AFBeatAreaEvent getAfBeatAreaEvent() {
        return afBeatAreaEvent;
    }

    public void setAfBeatAreaEvent(AFBeatAreaEvent afBeatAreaEvent) {
        this.afBeatAreaEvent = afBeatAreaEvent;
    }

    public HRVItemEvent getHrvItemEvent() {
        return hrvItemEvent;
    }

    public void setHrvItemEvent(HRVItemEvent hrvItemEvent) {
        this.hrvItemEvent = hrvItemEvent;
    }

}

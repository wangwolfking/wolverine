/**
 * Project Name: wolverine
 * Package Name: com.wolverine.dom4j.pojo.long_ranger
 * File    Name: SVTEvent.java
 * Create  Date: 2018-03-28 10:44
 * Copyright (c) 2018, www.yocaly.com All Rights Reserved.
 * 注意：本内容仅限于山东优加利信息科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */

package com.wolverine.dom4j.pojo.long_ranger;

import org.apache.catalina.StoreManager;

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
public class SVTEvent {
    private String Beat;
    private String Bigeminy;
    private String Trigeminy;
    private String Couplet;
    private String SVTTachycardia;
    private String LongestSVT;
    private String LongestSVTTime;
    private String ShortestSVT;
    private String ShortestSVTTime;
    private String SVBorderlineBlock;
    private String SVTSE;
    private String SVTASE;
    private String SVTAJE;

    public String getBeat() {
        return Beat;
    }

    public void setBeat(String beat) {
        Beat = beat;
    }

    public String getBigeminy() {
        return Bigeminy;
    }

    public void setBigeminy(String bigeminy) {
        Bigeminy = bigeminy;
    }

    public String getTrigeminy() {
        return Trigeminy;
    }

    public void setTrigeminy(String trigeminy) {
        Trigeminy = trigeminy;
    }

    public String getCouplet() {
        return Couplet;
    }

    public void setCouplet(String couplet) {
        Couplet = couplet;
    }

    public String getSVTTachycardia() {
        return SVTTachycardia;
    }

    public void setSVTTachycardia(String sVTTachycardia) {
        SVTTachycardia = sVTTachycardia;
    }

    public String getLongestSVT() {
        return LongestSVT;
    }

    public void setLongestSVT(String longestSVT) {
        LongestSVT = longestSVT;
    }

    public String getLongestSVTTime() {
        return LongestSVTTime;
    }

    public void setLongestSVTTime(String longestSVTTime) {
        LongestSVTTime = longestSVTTime;
    }

    public String getShortestSVT() {
        return ShortestSVT;
    }

    public void setShortestSVT(String shortestSVT) {
        ShortestSVT = shortestSVT;
    }

    public String getShortestSVTTime() {
        return ShortestSVTTime;
    }

    public void setShortestSVTTime(String shortestSVTTime) {
        ShortestSVTTime = shortestSVTTime;
    }

    public String getSVBorderlineBlock() {
        return SVBorderlineBlock;
    }

    public void setSVBorderlineBlock(String sVBorderlineBlock) {
        SVBorderlineBlock = sVBorderlineBlock;
    }

    public String getSVTSE() {
        return SVTSE;
    }

    public void setSVTSE(String sVTSE) {
        SVTSE = sVTSE;
    }

    public String getSVTASE() {
        return SVTASE;
    }

    public void setSVTASE(String sVTASE) {
        SVTASE = sVTASE;
    }

    public String getSVTAJE() {
        return SVTAJE;
    }

    public void setSVTAJE(String sVTAJE) {
        SVTAJE = sVTAJE;
    }

}

/**
 * Project Name: wolverine
 * Package Name: com.wolverine.dom4j.pojo.long_ranger
 * File    Name: VTEvent.java
 * Create  Date: 2018-03-28 10:45
 * Copyright (c) 2018, www.yocaly.com All Rights Reserved.
 * 注意：本内容仅限于山东优加利信息科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */

package com.wolverine.dom4j.pojo.long_ranger;

/**
 * 描述：TODO 用一句话描述这个类的作用（必选）. <br>
 * 背景：TODO 描述创建该类的背景原因（可选）. <br>
 * 日期：2018-03-28 10:45 <br>
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
public class VTEvent {
    private String Beat;
    private String Bigeminy;
    private String Trigeminy;
    private String Couplet;
    private String VTTachycardia;
    private String LongestVT;
    private String LongestVTTime;
    private String ShortestVT;
    private String ShortestVTTime;
    private String MaxVTRate;
    private String MaxVTRateTime;
    private String MinVTRate;
    private String MinVTRateRateTime;

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

    public String getVTTachycardia() {
        return VTTachycardia;
    }

    public void setVTTachycardia(String vTTachycardia) {
        VTTachycardia = vTTachycardia;
    }

    public String getLongestVT() {
        return LongestVT;
    }

    public void setLongestVT(String longestVT) {
        LongestVT = longestVT;
    }

    public String getLongestVTTime() {
        return LongestVTTime;
    }

    public void setLongestVTTime(String longestVTTime) {
        LongestVTTime = longestVTTime;
    }

    public String getShortestVT() {
        return ShortestVT;
    }

    public void setShortestVT(String shortestVT) {
        ShortestVT = shortestVT;
    }

    public String getShortestVTTime() {
        return ShortestVTTime;
    }

    public void setShortestVTTime(String shortestVTTime) {
        ShortestVTTime = shortestVTTime;
    }

    public String getMaxVTRate() {
        return MaxVTRate;
    }

    public void setMaxVTRate(String maxVTRate) {
        MaxVTRate = maxVTRate;
    }

    public String getMaxVTRateTime() {
        return MaxVTRateTime;
    }

    public void setMaxVTRateTime(String maxVTRateTime) {
        MaxVTRateTime = maxVTRateTime;
    }

    public String getMinVTRate() {
        return MinVTRate;
    }

    public void setMinVTRate(String minVTRate) {
        MinVTRate = minVTRate;
    }

    public String getMinVTRateRateTime() {
        return MinVTRateRateTime;
    }

    public void setMinVTRateRateTime(String minVTRateRateTime) {
        MinVTRateRateTime = minVTRateRateTime;
    }

}

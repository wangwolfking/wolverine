/**
 * Project Name: wolverine
 * Package Name: com.wolverine.dom4j.pojo.long_ranger
 * File    Name: EcgFragment.java
 * Create  Date: 2018-03-28 10:51
 * Copyright (c) 2018, www.yocaly.com All Rights Reserved.
 * 注意：本内容仅限于山东优加利信息科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */

package com.wolverine.dom4j.pojo.long_ranger;

/**
 * 描述：TODO 用一句话描述这个类的作用（必选）. <br>
 * 背景：TODO 描述创建该类的背景原因（可选）. <br>
 * 日期：2018-03-28 10:51 <br>
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
public class EcgFragment {
    private String EventPos;
    private String EventTime;
    private String EventName;
    private String EventLength;
    private String BeatRate;
    private String SetLeadName;
    public String getEventPos() {
        return EventPos;
    }
    public void setEventPos(String eventPos) {
        EventPos = eventPos;
    }
    public String getEventTime() {
        return EventTime;
    }
    public void setEventTime(String eventTime) {
        EventTime = eventTime;
    }
    public String getEventName() {
        return EventName;
    }
    public void setEventName(String eventName) {
        EventName = eventName;
    }
    public String getEventLength() {
        return EventLength;
    }
    public void setEventLength(String eventLength) {
        EventLength = eventLength;
    }
    public String getBeatRate() {
        return BeatRate;
    }
    public void setBeatRate(String beatRate) {
        BeatRate = beatRate;
    }
    public String getSetLeadName() {
        return SetLeadName;
    }
    public void setSetLeadName(String setLeadName) {
        SetLeadName = setLeadName;
    }

}

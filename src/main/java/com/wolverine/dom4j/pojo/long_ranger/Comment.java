/**
 * Project Name: wolverine
 * Package Name: com.wolverine.dom4j.pojo.long_ranger
 * File    Name: Comment.java
 * Create  Date: 2018-03-28 10:51
 * Copyright (c) 2018; private String www.yocaly.com All Rights Reserved.
 * 注意：本内容仅限于山东优加利信息科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */

package com.wolverine.dom4j.pojo.long_ranger;

import java.util.List;

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
public class Comment {
    private String Pos;
    private String QrsStart;
    private String QrsWidth;
    private String RPos;
    private String StStart;
    private String StWidth;
    private String TemplateIndex;
    private String WaveFormName;
    private List<CommentEx> commentExs;

    public String getPos() {
        return Pos;
    }

    public void setPos(String pos) {
        Pos = pos;
    }

    public String getQrsStart() {
        return QrsStart;
    }

    public void setQrsStart(String qrsStart) {
        QrsStart = qrsStart;
    }

    public String getQrsWidth() {
        return QrsWidth;
    }

    public void setQrsWidth(String qrsWidth) {
        QrsWidth = qrsWidth;
    }

    public String getRPos() {
        return RPos;
    }

    public void setRPos(String rPos) {
        RPos = rPos;
    }

    public String getStStart() {
        return StStart;
    }

    public void setStStart(String stStart) {
        StStart = stStart;
    }

    public String getStWidth() {
        return StWidth;
    }

    public void setStWidth(String stWidth) {
        StWidth = stWidth;
    }

    public String getTemplateIndex() {
        return TemplateIndex;
    }

    public void setTemplateIndex(String templateIndex) {
        TemplateIndex = templateIndex;
    }

    public String getWaveFormName() {
        return WaveFormName;
    }

    public void setWaveFormName(String waveFormName) {
        WaveFormName = waveFormName;
    }

    public List<CommentEx> getCommentExs() {
        return commentExs;
    }

    public void setCommentExs(List<CommentEx> commentExs) {
        this.commentExs = commentExs;
    }

}

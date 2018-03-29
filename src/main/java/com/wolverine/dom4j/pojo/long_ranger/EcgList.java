/**
 * Project Name: wolverine
 * Package Name: com.wolverine.dom4j.pojo.long_ranger
 * File    Name: EcgList.java
 * Create  Date: 2018-03-28 10:51
 * Copyright (c) 2018, www.yocaly.com All Rights Reserved.
 * 注意：本内容仅限于山东优加利信息科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */

package com.wolverine.dom4j.pojo.long_ranger;

import java.util.List;

/**
 * 描述：TODO 用一句话描述这个类的作用（必选）. <br>
 * 背景：TODO 描述创建该类的背景原因（可选）. <br>
 * 日期：2018-03-28 10:51 <br>
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
public class EcgList {
    private String LeadType;
    private String Comment;
    private String CommentEx;
    private List<Comment> comments;
    public String getLeadType() {
        return LeadType;
    }
    public void setLeadType(String leadType) {
        LeadType = leadType;
    }
    public String getComment() {
        return Comment;
    }
    public void setComment(String comment) {
        Comment = comment;
    }
    public String getCommentEx() {
        return CommentEx;
    }
    public void setCommentEx(String commentEx) {
        CommentEx = commentEx;
    }
    public List<Comment> getComments() {
        return comments;
    }
    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
    
}

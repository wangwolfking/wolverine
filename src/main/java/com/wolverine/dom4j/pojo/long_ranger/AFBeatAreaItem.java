/**
 * Project Name: wolverine
 * Package Name: com.wolverine.dom4j.pojo.long_ranger
 * File    Name: AFBeatAreaItem.java
 * Create  Date: 2018-03-28 10:47
 * Copyright (c) 2018, www.yocaly.com All Rights Reserved.
 * 注意：本内容仅限于山东优加利信息科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */

package com.wolverine.dom4j.pojo.long_ranger;

/**
 * 描述：TODO 用一句话描述这个类的作用（必选）. <br>
 * 背景：TODO 描述创建该类的背景原因（可选）. <br>
 * 日期：2018-03-28 10:47 <br>
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
public class AFBeatAreaItem {
    private String BeginPos;
    private String EndPos;
    private String AFEType;
    private String AFKind;
    public String getBeginPos() {
        return BeginPos;
    }
    public void setBeginPos(String beginPos) {
        BeginPos = beginPos;
    }
    public String getEndPos() {
        return EndPos;
    }
    public void setEndPos(String endPos) {
        EndPos = endPos;
    }
    public String getAFEType() {
        return AFEType;
    }
    public void setAFEType(String aFEType) {
        AFEType = aFEType;
    }
    public String getAFKind() {
        return AFKind;
    }
    public void setAFKind(String aFKind) {
        AFKind = aFKind;
    }
    
}

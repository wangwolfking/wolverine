/**
 * Project Name: wolverine
 * Package Name: com.wolverine.dom4j
 * File    Name: Long_Dom4j.java
 * Create  Date: 2018-03-28 15:20
 * Copyright (c) 2018, www.yocaly.com All Rights Reserved.
 * 注意：本内容仅限于山东优加利信息科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */

package com.wolverine.dom4j;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.wolverine.dom4j.pojo.long_ranger.AFBeatAreaEvent;
import com.wolverine.dom4j.pojo.long_ranger.BBBEvent;
import com.wolverine.dom4j.pojo.long_ranger.Comment;
import com.wolverine.dom4j.pojo.long_ranger.CommentEx;
import com.wolverine.dom4j.pojo.long_ranger.EcgFragmentList;
import com.wolverine.dom4j.pojo.long_ranger.EcgList;
import com.wolverine.dom4j.pojo.long_ranger.HRTList;
import com.wolverine.dom4j.pojo.long_ranger.HRVItemEvent;
import com.wolverine.dom4j.pojo.long_ranger.HeartRateSummary;
import com.wolverine.dom4j.pojo.long_ranger.HourEventList;
import com.wolverine.dom4j.pojo.long_ranger.PatientInfo;
import com.wolverine.dom4j.pojo.long_ranger.QBEvent;
import com.wolverine.dom4j.pojo.long_ranger.QTEvent;
import com.wolverine.dom4j.pojo.long_ranger.ReportHeader;
import com.wolverine.dom4j.pojo.long_ranger.ReportSummary;
import com.wolverine.dom4j.pojo.long_ranger.STEvent;
import com.wolverine.dom4j.pojo.long_ranger.STSumEvent;
import com.wolverine.dom4j.pojo.long_ranger.SVTEvent;
import com.wolverine.dom4j.pojo.long_ranger.SelectActionEvent;
import com.wolverine.dom4j.pojo.long_ranger.SpecialEvent;
import com.wolverine.dom4j.pojo.long_ranger.TWAEvent;
import com.wolverine.dom4j.pojo.long_ranger.VTEvent;
import com.wolverine.dom4j.pojo.long_ranger.YocalyECGReport;

public class LongRangerXml {
    private String suEncoding="utf-8";//源编码格式
    private String dsEncoding="utf-8";//目标编码格式

    public void setSuEncoding(String suEncoding) {
        this.suEncoding = suEncoding;
    }

    public void setDsEncoding(String dsEncoding) {
        this.dsEncoding = dsEncoding;
    }
/**
 * xmlToObject:将xml文件转换为对象 . <br>
 * @param param_url xml文件的路径
 * @return
 */
    public YocalyECGReport xmlToObject(String param_url) {
        File tempFile = new File(param_url);
        YocalyECGReport yocalyECGReport = new YocalyECGReport();
        if (!tempFile.exists()) {
            return null;
        } else {
            SAXReader reader = new SAXReader();
            try {
                Document document = reader.read(tempFile);
                //获取更节点对象
                Element elementStore = document.getRootElement();
                //查询出根节点的所有的子节点
                Iterator it = elementStore.elementIterator();
                //循环解析子节点
                while (it.hasNext()) {
                    Element element = (Element) it.next();
                    //根据节点的名称来解析节点
                    if (element.getName().equals("PatientInfo")) {
                        Object patientInfo = getclass("PatientInfo");
                        //调用几点属性赋值给对象的方法
                        getNodeAttObject(patientInfo, element);
                        yocalyECGReport.setPatientInfo((PatientInfo) patientInfo);
                    } else if (element.getName().equals("ReportHeader")) {
                        ReportHeader rHeader = new ReportHeader();
                        getNodeAttObject(rHeader, element);
                        rHeader.setLeads(getNodeListObject(element, "Lead"));
                        yocalyECGReport.setReportHeader(rHeader);
                    } else if (element.getName().equals("HourEventList")) {
                        HourEventList hEventList = new HourEventList();
                        getNodeAttObject(hEventList, element);
                        hEventList.setHourEvents(getNodeListObject(element, "HourEvent"));
                        yocalyECGReport.setHourEventList(hEventList);
                    } else if (element.getName().equals("EcgFragmentList")) {
                        //此节点既有属性，又有细节点
                        EcgFragmentList ecgFragmentList = new EcgFragmentList();
                        //将节点属性赋值给对象属性
                        getNodeAttObject(ecgFragmentList, element);
                        //将子节点的属性封装成集合赋值给对象集合
                        ecgFragmentList.setEcgFragments(getNodeListObject(element, "EcgFragment"));
                        yocalyECGReport.setEcgFragmentList(ecgFragmentList);
                    } else if (element.getName().equals("ReportSummary")) {
                        ReportSummary reportSummary = new ReportSummary();
                        reportSummary = getNodeAttObject(element);
                        yocalyECGReport.setReportSummary(reportSummary);
                    } else if (element.getName().equals("EcgList")) {
                        EcgList ecgList = new EcgList();
                        ecgList = getEcgListNodeObject(element);
                        yocalyECGReport.setEcgList(ecgList);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return yocalyECGReport;
    }
/**
 * getNodeAttObject:将xml文件节点的属性值赋值给对象的属性
 * @author wangzhigang
 * @param p_Object 要封装的对象
 * @param p_element xml的节点
 * @return
 * @throws Exception
 */
    public Object getNodeAttObject(Object p_Object, Element p_element) throws Exception {
        //获取属性集合
        List<Attribute> tempAttrsroot = p_element.attributes();
        //循环遍历属性
        for (Attribute attribute : tempAttrsroot) {
            Object ob = p_Object;
            //获取类的所有的属性
            Field[] f = ob.getClass().getDeclaredFields();
            for (int i = 0; i < f.length; i++) {
                if (attribute.getName().equals(f[i].getName())) {
                    String fieldName = f[i].getName();
                    //将属性名称第一个字母大写
                    fieldName = fieldName.replaceFirst(fieldName.substring(0, 1),
                            fieldName.substring(0, 1).toUpperCase());
                    //利用java反射机制获取到pojo的set方法
                    Method setReadOnly = ob.getClass().getMethod("set" + fieldName, String.class);
                    //将获取的属性值进行转码后用set方法对属性进行赋值
                    String s = new String(attribute.getValue().getBytes(this.suEncoding),this.dsEncoding);
                    setReadOnly.invoke(ob, s);
                }
            }
        }
        return p_Object;
    }

    public List getNodeListObject(Element p_element, String name) throws Exception {
        Iterator elementIt = p_element.elementIterator();
        List tempList = new ArrayList();
        while (elementIt.hasNext()) {
            Element element = (Element) elementIt.next();
            Object object = null;
            object = getclass(name);
            getNodeAttObject(object, element);
            tempList.add(object);
        }
        return tempList;
    }
/**
 * getNodeAttObject:对特殊多层节点的处理ReportSummary
 * 
 * @author wangzhigang
 * @param p_element xml的节点对象
 * @return
 * @throws Exception
 */
    public ReportSummary getNodeAttObject(Element p_element) throws Exception {
        ReportSummary reportSummary = new ReportSummary();
        Iterator elementIt = p_element.elementIterator();
        while (elementIt.hasNext()) {
            Element element = (Element) elementIt.next();
            Object object = getclass(element.getName());
            getNodeAttObject(object, element);
            if (element.getName().equals("HeartRateSummary")) {
                reportSummary.setHeartRateSummary((HeartRateSummary) object);
            } else if (element.getName().equals("SVTEvent")) {
                reportSummary.setSvtEvent((SVTEvent) object);
            } else if (element.getName().equals("VTEvent")) {
                reportSummary.setVtEvent((VTEvent) object);
            } else if (element.getName().equals("STEvent")) {
                reportSummary.setStEvent((STEvent) object);
            } else if (element.getName().equals("TWAEvent")) {
                TWAEvent twaEvent = new TWAEvent();
                twaEvent.setTwaEventItems(getNodeListObject(element, "TWAEventItem"));
                reportSummary.setTwaEvent(twaEvent);
            } else if (element.getName().equals("BBBEvent")) {
                reportSummary.setBbbEvent((BBBEvent) object);
            } else if (element.getName().equals("SpecialEvent")) {
                reportSummary.setSpecialEvent((SpecialEvent) object);
            } else if (element.getName().equals("HRTList")) {
                reportSummary.setHrtList((HRTList) object);
            } else if (element.getName().equals("QBEvent")) {
                reportSummary.setQbEvent((QBEvent) object);
            } else if (element.getName().equals("STSumEvent")) {
                reportSummary.setStSumEvent((STSumEvent) object);
            } else if (element.getName().equals("QTEvent")) {
                reportSummary.setQtEvent((QTEvent) object);
            } else if (element.getName().equals("SelectActionEvent")) {
                reportSummary.setSelectActionEvent((SelectActionEvent) object);
            } else if (element.getName().equals("AFBeatAreaEvent")) {
                AFBeatAreaEvent afBeatAreaEvent = new AFBeatAreaEvent();
                getNodeAttObject(afBeatAreaEvent, element);
                afBeatAreaEvent.setAfBeatAreaItems(getNodeListObject(p_element, "AFBeatAreaItem"));
                reportSummary.setAfBeatAreaEvent(afBeatAreaEvent);
            } else if (element.getName().equals("HRVItemEvent")) {
                reportSummary.setHrvItemEvent((HRVItemEvent) object);
            }
        }
        return reportSummary;
    }
/**
 * getEcgListNodeObject:用于xml中EcgList节点的解析此节点有两个属性，分别对应子节点的属性
 * 
 * @author wangzhigang
 * @param p_element dom操作的一个节点
 * @return
 */
    public EcgList getEcgListNodeObject(Element p_element) throws Exception {
        EcgList ecgList = new EcgList();
        getNodeAttObject(ecgList, p_element);
        Iterator elementIt = p_element.elementIterator();
        List<Comment> comments = new ArrayList<Comment>();
        while (elementIt.hasNext()) {
            Element elementB = (Element) elementIt.next();
            Comment comment = new Comment();
            //获取B节点的D属性值并转换为数组
            String[] strings = elementB.attribute("D").getValue().split(",");
            if (strings.length >= 8) {
                comment.setPos(strings[0]);
                comment.setQrsStart(strings[1]);
                comment.setQrsWidth(strings[2]);
                comment.setRPos(strings[3]);
                comment.setStStart(strings[4]);
                comment.setStWidth(strings[5]);
                comment.setTemplateIndex(strings[6]);
                comment.setWaveFormName(strings[7]);
            }
            Iterator temp = elementB.elementIterator();
            List<CommentEx> commentExs = new ArrayList<CommentEx>();
            while (temp.hasNext()) {
                CommentEx commentEx = new CommentEx();
                Element elementE = (Element) temp.next();
                String[] strs = elementE.attribute("D").getValue().split(",");
                if (strs.length >= 4) {
                    commentEx.setBaseLine(strs[0]);
                    commentEx.setJDiff(strs[1]);
                    commentEx.setStDiff(strs[2]);
                    commentEx.setLeadTpe(strs[3]);
                }
                commentExs.add(commentEx);
            }
            comment.setCommentExs(commentExs);
            comments.add(comment);
        }
        ecgList.setComments(comments);
        return ecgList;
    }
/**
 * getclass:根据类的全路径名称实例化一个对象
 * @author wangzhigang
 * @param className 类的名称（此处为xml各个节点的名称（要保持一致，并且真实存在java类））
 * @return
 */
    public Object getclass(String className)
            throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        //此处是类的全路径名称
        String cname = "com.wolverine.dom4j.pojo.long_ranger." + className;
        Class obj = Class.forName(cname);
        Object oo = obj.newInstance();
        return oo;
    }

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {
        LongRangerXml test = new LongRangerXml();
        test.xmlToObject("D:\\测试的文件\\2017-12-08-xml\\long_ranger2.XML");
    }

}

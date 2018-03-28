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
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.ObjectUtils.Null;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.wolverine.dom4j.pojo.EcgAiEvent;
import com.wolverine.dom4j.pojo.EcgAiEventDetail;
import com.wolverine.dom4j.pojo.long_ranger.EcgFragment;
import com.wolverine.dom4j.pojo.long_ranger.EcgFragmentList;
import com.wolverine.dom4j.pojo.long_ranger.HourEvent;
import com.wolverine.dom4j.pojo.long_ranger.HourEventList;
import com.wolverine.dom4j.pojo.long_ranger.Lead;
import com.wolverine.dom4j.pojo.long_ranger.PatientInfo;
import com.wolverine.dom4j.pojo.long_ranger.ReportHeader;
import com.wolverine.dom4j.pojo.long_ranger.ReportSummary;
import com.wolverine.dom4j.pojo.long_ranger.YocalyECGReport;
import com.wolverine.log.LogManager;

public class Long_Dom4j {
    static LogManager log = new LogManager("dom4j_ai_analysis", "dom4j_ai_analysis");

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {
        Long_Dom4j temp = new Long_Dom4j();
        temp.testDom4j("D:\\测试的文件\\2017-12-08-xml\\long_ranger.XML");

    }

    public void testDom4j(String param_url) {
        File tempFile = new File(param_url);
        if (!tempFile.exists()) {
            return;
        } else {
            SAXReader reader = new SAXReader();
            try {
                YocalyECGReport yocalyECGReport = new YocalyECGReport();
                Document document = reader.read(tempFile);
                Element elementStore = document.getRootElement();
                Iterator it = elementStore.elementIterator();
                while (it.hasNext()) {
                    Element element = (Element) it.next();
                    if (element.getName().equals("PatientInfo")) {
                        PatientInfo pp = new PatientInfo();
                        getNodeObject(pp, element);
                        yocalyECGReport.setPatientInfo(pp);
                    } else if (element.getName().equals("ReportHeader")) {
                        ReportHeader rHeader = new ReportHeader();
                        getNodeObject(rHeader, element);
                        rHeader.setLeads(getNodeListObject(rHeader, element, "Lead"));
                        yocalyECGReport.setReportHeader(rHeader);
                    } else if (element.getName().equals("HourEventList")) {
                        HourEventList hEventList = new HourEventList();
                        getNodeObject(hEventList, element);
                        hEventList.setHourEvents(getNodeListObject(hEventList, element, "HourEvent"));
                        yocalyECGReport.setHourEventList(hEventList);
                    } else if (element.getName().equals("EcgFragmentList")) {
                        EcgFragmentList ecgFragmentList = new EcgFragmentList();
                        getNodeObject(ecgFragmentList, element);
                        ecgFragmentList.setEcgFragments(getNodeListObject(ecgFragmentList, element, "EcgFragment"));
                        yocalyECGReport.setEcgFragmentList(ecgFragmentList);
                    }else if (element.getName().equals("ReportSummary")) {
                        ReportSummary reportSummary = new ReportSummary();
                        
                        yocalyECGReport.setReportSummary(reportSummary);
                    }
                }
                System.out.println(yocalyECGReport.getPatientInfo().getAge());
                System.out.println(yocalyECGReport.getReportHeader().getLeads().size());
                System.out.println(yocalyECGReport.getHourEventList().getHourEvents().size());
                System.out.println(yocalyECGReport.getEcgFragmentList().getEcgFragments().get(0).getEventPos());
                System.out.println(yocalyECGReport.getEcgFragmentList().getEcgFragments().get(1).getEventPos());
                System.out.println(yocalyECGReport.getEcgFragmentList().getEcgFragments().get(2).getEventPos());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Object getNodeObject(Object p_Object, Element p_element) throws Exception {
        List<Attribute> tempAttrsroot = p_element.attributes();
        for (Attribute attribute : tempAttrsroot) {
            Object pa = p_Object;
            Field[] f = pa.getClass().getDeclaredFields();
            for (int i = 0; i < f.length; i++) {
                if (attribute.getName().equals(f[i].getName())) {
                    String fieldName = f[i].getName();
                    fieldName = fieldName.replaceFirst(fieldName.substring(0, 1), fieldName.substring(0, 1).toUpperCase());
                    Method setReadOnly = pa.getClass().getMethod("set" + fieldName, String.class);
                    String s = attribute.getValue();
                    setReadOnly.invoke(pa, s);
                }
            }
        }
        return p_Object;
    }

    public List getNodeListObject(Object p_Object, Element p_element, String name) throws Exception {
        Iterator elementIt = p_element.elementIterator();
        List tempList = new ArrayList();
        while (elementIt.hasNext()) {
            Element element = (Element) elementIt.next();
            Object object = null;
            if (name.equals("HourEvent")) {
                object = new HourEvent();
            }
            if (name.equals("Lead")) {
                object = new Lead();
            }
            if (name.equals("EcgFragment")) {
                object = new EcgFragment();
            }
            getNodeObject(object, element);
            tempList.add(object);
        }
        return tempList;
    }

}

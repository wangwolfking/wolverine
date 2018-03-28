package com.wolverine.dom4j;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.wolverine.dom4j.pojo.EcgAiEvent;
import com.wolverine.dom4j.pojo.EcgAiEventDetail;
import com.wolverine.dom4j.pojo.EcgAiRunInfo;
import com.wolverine.log.LogManager;

public class Dom4j {

	private static ArrayList<Book> bookList = new ArrayList<Book>();
	static LogManager log = new LogManager("dom4j_ai_analysis", "dom4j_ai_analysis");
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Dom4j temp = new Dom4j();
		log.info("13245");
		temp.testDom4j("D:\\我的测试文件\\2017-12-08-xml\\7d30db066d20828bc5d21122437628ea.xml");
		log.info("132451234567898765432");

	}

	public void testDom4j(String param_url) {
		long begin_time = System.currentTimeMillis();
		System.out.println("===========方法开始时间=============" + begin_time);
		File tempFile = new File(param_url);
		if (!tempFile.exists()) {
			System.out.println("===========文件不存在=============");
			return;
		} else {
			SAXReader reader = new SAXReader();
			try {
				Document document = reader.read(tempFile);
				Element elementStore = document.getRootElement();
				Iterator it = elementStore.elementIterator();
				List<Attribute> tempAttrsroot = elementStore.attributes();
				System.out.println(
						elementStore.attribute("avg_hr").getName() + "-----" + elementStore.attribute("avg_hr").getValue());
				EcgAiRunInfo eari = new EcgAiRunInfo();

				if (tempAttrsroot != null && tempAttrsroot.size() > 0) {
					eari.setId(111);
					eari.setService_code("待添加serviceCode");
					eari.setBusiness_account("待添加business_account");
					eari.setThread_group("待添加thread_group");
					eari.setThread_idx(2222);
					eari.setResult_code(3333);
					eari.setStart_time(new Date());// 待添加
					eari.setEnd_time(new Date());// 待添加
					eari.setExc_long(10000);
					eari.setAvg_hr(Integer.parseInt(elementStore.attribute("avg_hr").getValue()));
					eari.setMax_hr(Integer.parseInt(elementStore.attribute("max_hr").getValue()));
					eari.setMin_hr(Integer.parseInt(elementStore.attribute("min_hr").getValue()));
					eari.setValid_time(Integer.parseInt(elementStore.attribute("valid_time").getValue()));
					eari.setHeart_beat_count(Integer.parseInt(elementStore.attribute("heart_beat_count").getValue()));
				}
				while (it.hasNext()) {
					Element element = (Element) it.next();
					System.out.println("节点的名字是11：" + element.getName());
					String tempstr = element.getName();
					if (tempstr.equals("warning_class0")) {
						if (element.elements().size() > 0) {
							eari.setAlert_level_0_cnt(element.elements().size());
							this.getNodeList(element);
						} else {
							eari.setAlert_level_0_cnt(0);
						}

					} else if (tempstr.equals("warning_class1")) {
						if (element.elements().size() > 0) {
							eari.setAlert_level_1_cnt(element.elements().size());
							this.getNodeList(element);
						} else {
							eari.setAlert_level_0_cnt(0);
						}
					} else if (tempstr.equals("warning_class2")) {
						if (element.elements().size() > 0) {
							eari.setAlert_level_2_cnt(element.elements().size());
							this.getNodeList(element);
						} else {
							eari.setAlert_level_0_cnt(0);
						}
					}
				}
				System.out.println(eari.getAlert_level_0_cnt() + "++++++++++");
				System.out.println(eari.getAlert_level_1_cnt() + "++++++++++");
				System.out.println(eari.getAlert_level_2_cnt() + "++++++++++");
				long end_time = System.currentTimeMillis();
				System.out.println("===========方法结束时间=============" + end_time);
				System.out.println("===========方法耗时=============" + (end_time - begin_time));
			} catch (Exception e) {
				System.out.println("===========DocumentException=============");
				e.printStackTrace();
			}
		}
	}

	public void getNodeList(Element param_element) {
		EcgAiEvent eae = new EcgAiEvent();
		Iterator it1 = param_element.elementIterator();
		while (it1.hasNext()) {
			Element element1 = (Element) it1.next();
			System.out.println("节点的名字是：" + element1.getName());
			List<Attribute> tempAttrs11 = element1.attributes();
			if (tempAttrs11 != null && tempAttrs11.size() > 0) {
				eae.setAlert_level(1);// 事件列表id
				eae.setRun_id(123);// 事件调用id
				eae.setAlert_event_code(Integer.parseInt(element1.attribute("event_code").getValue()));
				eae.setMax_hr(Integer.parseInt(element1.attribute("event_max_hr").getValue()));
				eae.setMin_hr(Integer.parseInt(element1.attribute("event_min_hr").getValue()));
				eae.setEvent_max_len(Float.parseFloat(element1.attribute("max_len_time").getValue()));
				System.out.println("======2222=======" + eae.getEvent_max_len());
				Iterator it11 = element1.elementIterator();
				while (it11.hasNext()) {
					EcgAiEventDetail eaed = new EcgAiEventDetail();
					Element element11 = (Element) it11.next();
					List<Attribute> tempAttrs111 = element11.attributes();
					if (tempAttrs111 != null && tempAttrs111.size() > 0) {
						Attribute temp = tempAttrs111.get(0);
						eaed.setId(111);// 事件id
						eaed.setEvent_id(12);// 事件列表id
						eaed.setStart_pos(Integer.parseInt(temp.getValue().split(",")[0]));
						eaed.setEnd_pos(Integer.parseInt(temp.getValue().split(",")[1]));
						eaed.setEvent_len(Integer.parseInt(temp.getValue().split(",")[2]));
						System.out.println(eaed.getId() + "==" + eaed.getEvent_id() + "==" + eaed.getStart_pos() + "=="
								+ eaed.getEnd_pos() + "==" + eaed.getEvent_len());
					}
				}
			}
		}

	}
}

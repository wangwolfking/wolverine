package com.wolverine.dom4j.pojo;

import java.util.Date;

public class EcgAiRunInfo {
	private int id;// ID
	private String service_code;// 数据编码
	private String business_account;// 机构编码
	private String thread_group;// 线程组
	private int thread_idx;// 线程序号
	private int result_code;// 返回结果
	private Date start_time;// 开始时间
	private Date end_time;// 结束时间
	private int exc_long;// 执行时长(ms)
	private int avg_hr;// 平均心率（片段有效数据）
	private int max_hr;// 最大心率
	private int min_hr;// 最小心率
	private int valid_time;// 有效时长(ms)
	private int heart_beat_count;// 总心搏数
	private int alert_level_0_cnt;// 紧急事件数
	private int alert_level_1_cnt;// 一般事件数
	private int alert_level_2_cnt;// 普通事件数
	private String remark;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getService_code() {
		return service_code;
	}

	public void setService_code(String service_code) {
		this.service_code = service_code;
	}

	public String getBusiness_account() {
		return business_account;
	}

	public void setBusiness_account(String business_account) {
		this.business_account = business_account;
	}

	public String getThread_group() {
		return thread_group;
	}

	public void setThread_group(String thread_group) {
		this.thread_group = thread_group;
	}

	public int getThread_idx() {
		return thread_idx;
	}

	public void setThread_idx(int thread_idx) {
		this.thread_idx = thread_idx;
	}

	public int getResult_code() {
		return result_code;
	}

	public void setResult_code(int result_code) {
		this.result_code = result_code;
	}

	public Date getStart_time() {
		return start_time;
	}

	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}

	public Date getEnd_time() {
		return end_time;
	}

	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}

	public int getExc_long() {
		return exc_long;
	}

	public void setExc_long(int exc_long) {
		this.exc_long = exc_long;
	}

	public int getAvg_hr() {
		return avg_hr;
	}

	public void setAvg_hr(int avg_hr) {
		this.avg_hr = avg_hr;
	}

	public int getMax_hr() {
		return max_hr;
	}

	public void setMax_hr(int max_hr) {
		this.max_hr = max_hr;
	}

	public int getMin_hr() {
		return min_hr;
	}

	public void setMin_hr(int min_hr) {
		this.min_hr = min_hr;
	}

	public int getValid_time() {
		return valid_time;
	}

	public void setValid_time(int valid_time) {
		this.valid_time = valid_time;
	}

	public int getHeart_beat_count() {
		return heart_beat_count;
	}

	public void setHeart_beat_count(int heart_beat_count) {
		this.heart_beat_count = heart_beat_count;
	}

	public int getAlert_level_0_cnt() {
		return alert_level_0_cnt;
	}

	public void setAlert_level_0_cnt(int alert_level_0_cnt) {
		this.alert_level_0_cnt = alert_level_0_cnt;
	}

	public int getAlert_level_1_cnt() {
		return alert_level_1_cnt;
	}

	public void setAlert_level_1_cnt(int alert_level_1_cnt) {
		this.alert_level_1_cnt = alert_level_1_cnt;
	}

	public int getAlert_level_2_cnt() {
		return alert_level_2_cnt;
	}

	public void setAlert_level_2_cnt(int alert_level_2_cnt) {
		this.alert_level_2_cnt = alert_level_2_cnt;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}

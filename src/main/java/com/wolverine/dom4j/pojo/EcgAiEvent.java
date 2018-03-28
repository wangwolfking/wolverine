package com.wolverine.dom4j.pojo;

import java.util.Date;

public class EcgAiEvent {
	private int id;//ID
	private int run_id;//调用ID
	private int alert_level;//事件级别（0紧急事件 1一般事件 2普通事件）
	private int alert_event_code;//事件编码
	private int max_hr;//最大心率
	private int min_hr;//最小心率
	private int event_count;//事件数量
	private float event_max_len;//最大时长
	private int is_valid;//是否正确（1正确 0 错误）
	private int process_flag;//处理标识(0AI 1人工）
	private int create_user_id;//创建人
	private Date create_time;//创建时间
	private int edit_user_id;//修改人
	private Date edit_time;//修改时间
	private int remark;//备注

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRun_id() {
		return run_id;
	}

	public void setRun_id(int run_id) {
		this.run_id = run_id;
	}

	public int getAlert_level() {
		return alert_level;
	}

	public void setAlert_level(int alert_level) {
		this.alert_level = alert_level;
	}

	public int getAlert_event_code() {
		return alert_event_code;
	}

	public void setAlert_event_code(int alert_event_code) {
		this.alert_event_code = alert_event_code;
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

	public int getEvent_count() {
		return event_count;
	}

	public void setEvent_count(int event_count) {
		this.event_count = event_count;
	}

	public float getEvent_max_len() {
		return event_max_len;
	}

	public void setEvent_max_len(float event_max_len) {
		this.event_max_len = event_max_len;
	}

	public int getIs_valid() {
		return is_valid;
	}

	public void setIs_valid(int is_valid) {
		this.is_valid = is_valid;
	}

	public int getProcess_flag() {
		return process_flag;
	}

	public void setProcess_flag(int process_flag) {
		this.process_flag = process_flag;
	}

	public int getCreate_user_id() {
		return create_user_id;
	}

	public void setCreate_user_id(int create_user_id) {
		this.create_user_id = create_user_id;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public int getEdit_user_id() {
		return edit_user_id;
	}

	public void setEdit_user_id(int edit_user_id) {
		this.edit_user_id = edit_user_id;
	}

	public Date getEdit_time() {
		return edit_time;
	}

	public void setEdit_time(Date edit_time) {
		this.edit_time = edit_time;
	}

	public int getRemark() {
		return remark;
	}

	public void setRemark(int remark) {
		this.remark = remark;
	}

}

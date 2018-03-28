package com.wolverine.dom4j.pojo;

import java.util.Date;

public class EcgAiEventDetail {
	private int id;// ID
	private int event_id;// 事件列表ID
	private int start_pos;// 起始位置
	private int end_pos;// 结束位置
	private int event_len;// 事件长度
	private int is_valid;// 是否正确（1正确 0 错误）
	private int process_flag;// 处理标识(0AI 1人工）
	private int create_user_id;// 创建人
	private Date create_time;// 创建时间
	private int edit_user_id;// 修改人
	private Date edit_time;// 修改时间
	private String remark;// 备注

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEvent_id() {
		return event_id;
	}

	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}

	public int getStart_pos() {
		return start_pos;
	}

	public void setStart_pos(int start_pos) {
		this.start_pos = start_pos;
	}

	public int getEnd_pos() {
		return end_pos;
	}

	public void setEnd_pos(int end_pos) {
		this.end_pos = end_pos;
	}

	public int getEvent_len() {
		return event_len;
	}

	public void setEvent_len(int event_len) {
		this.event_len = event_len;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}

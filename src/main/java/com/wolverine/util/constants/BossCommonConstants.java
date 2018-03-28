package com.wolverine.util.constants;

public final class BossCommonConstants {
	/**
	 * 主体服务 心脏监护:HC , 心血管监护：CC , 实时gprs监护:REALTIME_GPS , 长程分析:LONGTERM_USB
	 */
	public final static String CONST_HC = "HC";
	public final static String CONST_CC = "CC";
	public final static String REALTIME_GPS = "REALTIME_GPRS";
	public final static String LONGTERM_USB = "LONGTERM_USB";
	/** 实时(手动定时) **/
	public final static String CONST_SDDS = "SDDS" ;
	/** 实时(手动) **/
	public final static String SHOUDONG = "SHOUDONG" ;
	/** 实时(定时) **/
	public final static String DINGSHI = "DINGSHI" ;
	/** 专家关注 **/
	public final static String PXPERT = "PXPERT" ;
	/** 医生实时关注 **/
	public final static String YSGZ = "YSGZ" ;
	/** 监护信息告知亲友 **/
	public final static String JHXXGZQY = "JHXXGZQY" ;
	/** 城区位置定位 **/
	public final static String DQWZDW = "DQWZDW" ;
	/** 心电监测数据管理 **/
	public final static String XDJCSJGL = "XDJCSJGL" ;
	/** 专家服务总结报告**/
	public final static String ZJFWZJBG = "ZJFWZJBG" ;
	/** 总结分析服务 **/
	public final static String SER_ZJFXFW = "SER_ZJFXFW" ;
	
	/** 主动关注处理任务 **/
	public final static String FRONT_AUTO_ZDGZFUN = "FRONT_AUTO_ZDGZFUN" ;
	
	/** 系统类型-boss系统**/
	public final static String SYSTEM_BOSS = "BOSS";
	/** 系统类型-实时系统**/
	public final static String SYSTEM_RTOS = "RTOS";
	/** 系统类型-长程分析系统**/
	public final static String SYSTEM_IHTOS = "IHTOS";
	 
	
	/** 前置机坐席查询接口 **/
	public final static String FRONT_OPERATOR = "FRONT_OPERATOR" ;
	/** 前置机执行脚本接口 **/
	public final static String FRONT_EXECUTESQL = "FRONT_EXECUTESQL" ;
	
	
	
	/** 多监护中心标志  */
	public static final String MANY_CARE_CENTER_SIGN  = "MANY_CARE_CENTER_SIGN";
	
	/** 超级管理员编码,虚拟角色编码  */
	public final static String SUPER_ADMIN = "superadmin";
	public final static String SUPER_ADMIN_WUCHAO = "wuchao";
	public final static String SUPER_FRONT_ADMIN = "superyocaly";

	/** yocaly机构编码 */
	public final static String ORG_YOCALY_CODE = "YOCALY";
	
	/**
	 * 默认约定短信待发剩余数量和剩余时间
	*/
	public final static String AGREED_QUANTIRT = "1";
	public final static String AGREED_TIME = "1";
	
	/**
	 * 消息总表短信通知标识
	 */
	public final static String	ERR = "0";
	public final static String	INITIAL_STATE = "1";
	public final static String	PRE_SENT = "2";
	public final static String	SENT = "3";  /**发送成功**/
	public final static String  ACTIVE = "4";
	
	/**
	 * 消息Code标识
	 */
	public final static String NOTICE_TIME = "NOTICE_BY_TIME";
	public final static String NOTICE_NUM = "NOTICE_BY_NUM";
	public final static String NOTICE_TIME_NUM = "NOTICE_BY_TIME_NUM";
	
	/**
	 * 消息级别
	 */
	public final static String JUNIOR = "1";
	public final static String MEDIUM = "2";
	public final static String HIGH = "3";
	
	/**
	 * 消息是否有父类
	 */
	public final static int NOT_HAVE_PARENT = 0;
	
	/**
	 * 消息常量模板中固定的初始类
	 */
	public final static String PARENTS = "1";
	
	/**
	 * 消息发送时间定义
	 */
	public final static String AM = "1";
	public final static String PM = "2";
	public final static String NOW = "3";
	
	/**
	 *  根据会话信息查询机构编码列表时，可以指定到某一具体的URL地址，而不一定只能是请求URL地址，
	 *  并且指定的URL地址具有优先权
	 */
	public final static String ASSIGN_FUNC_URL = "assign_func_url";
	
	/**
	 * 当前活动模块标识
	 */
	public final static String CUR_RESOURCE_ID = "cur_resource_id";
	
	/**#############################机构类别###########################################**/
	/** 机构类别 公司类别 */
	public final static String ORG_GRADE_COMP = "1";
	/** 机构类别 部门类别 */
	public final static String ORG_GRADE_DEP = "2";
	/** 机构类别 医疗机构类别 */
	public final static String ORG_GRADE_HOSP = "3";
	/** 机构类别 监护中心类别 */
	public final static String ORG_GRADE_MC = "4";
	/** 机构类别 渠道  服务运营商*/
	public final static String ORG_GRADE_CH = "5";
	
	
	/** 所有机构编码 */
	public final static String ALL_ORGANIZE_CODE = "all_organize_code";
	/** 所有机构编码 */
	public final static String ALL_ORGANIZE_NAME = "全部机构";
	
	/** 消息提示类型 */
	public final static String MSG_REMIND_SERVICEINFO="0";//服务信息提示
	public final static String SMS_REMIND_SERVICEINFO="1";//短信息提示
	
	/** 消息提示读取状态 */
	public final static String MSG_REMIND_NOREAD="0";//未读
	public final static String MSG_REMIND_READ="1";//已读
	public final static String MSG_REMIND_OVERDUE="2";//过期
	
	/** PushCommand **/
	public final static String PUSHCOMMAND_V1="V1";//版本	
	public final static int COMMAND_REC_EXCEPTION=-1;//推命令异常
	public final static int COMMAND_REC_SUCESS=0;//推命令返回成功
	public final static int COMMAND_REC_ERRORSTATUS=1;//推命令状态错误,请等待
	public final static int COMMAND_REC_SECINFO_CLOSE=2;//安全信息为关机
	public final static int COMMAND_REC_SECINFO_EQMTERROR=3;//设备业务状态异常
	
	public final static int COMMAND_GPRS_SMS_1 = 1;		//在线检测
	public final static int COMMAND_GPRS_SMS_2 = 2;		//专家关注	
	public final static int COMMAND_GPRS_SMS_3 = 3;		//医嘱回复（诊疗建议）
	public final static int COMMAND_GPRS_SMS_4 = 4;		//更新Agent
	
	
	public final static String COMMONSTATUS_INIT="0";//指令初始化
	public final static String COMMONSTATUS_SENDING="1";//指令发送中
	public final static String COMMONSTATUS_SENDSUCCESS="2";//指令发送成功(未确认)
	public final static String COMMONSTATUS_CONFIRMSUCCESS="3";//指令发送成功(已确认)
	public static final String COMMONSTATUS_TIMEOUT = "4";//指令未确认超时
	public final static String COMMONSTATUS_FAILED="5";//指令发送失败
	
	public final static String COMMONSTATUS_DEAL_ING="6";//处理中
	public final static String COMMONSTATUS_DEAL_SUCCEED="7";//处理完成
	public final static String COMMONSTATUS_EXCTION="8";//异常待处理
	public final static String COMMONSTATUS_NOT_EXCTION="9";//无需处理
	public final static String COMMONSTATUS_ALREADY_DISTRIBUTE="A";//已分发
	public final static String COMMONSTATUS_WAIT_DISTRIBUTE="B";//等待分发
	public final static int COMMONSTATUS_EXCEPTION_CODE=1;//标识为MAS系统的问题
	
	public static void main(String[] args) {
		System.out.println(0x30);
	}
	
	/** #############################################指令编码#################################################################### **/
	public static final String SENDCURRENTECG="SENDCURRENTECG";			//发送当前的ECG数据(专家关注)
	public static final String POWEROFF="POWEROFF";						//关机
	public static final String INMONITOR="INMONITOR";					//进入监护
	public static final String EXITMONITOR="EXITMONITOR";				//退出监护
	public static final String SENDGPS="SENDGPS";						//发送GPS坐标数据
	public static final String UPDATEAPP="UPDATEAPP";					//更新应用
	public static final String UPDATEADDRESS="UPDATEADDRESS";			//更新Agent服务器连接地址
	public static final String MEDICALMESSAGE="MEDICALMESSAGE";			//医疗资讯
	public static final String ADDRESSSTATUS="ADDRESSSTATUS";			//Agent服务器状态
	/*###### 2011-06-17 wuchao add  ###########*/
	public static final String UPDATESMSDEV="UPDATESMSDEV";				//更新短信猫
	public static final String UPDATEUSERIFO="UPDATEUSERIFO";			//更新用户信息
	public static final String UPDATEMULDAYREC="UPDATEMULDAYREC";		//多天记录支持
	public static final String UPDATEDEFINEDTIMESEND="UPDATEDEFINEDTIMESEND";		//定时发送
	public static final String UPDATEAVOIDBREAKINONMODE = "UPDATEAVOIDBREAKINONMODE";//免打扰模式
	
	public static final String UPDATEPRINTERSTATUS = "UPDATEPRINTERSTATUS";//是否开启打印功能
	public static final String UPDATEXABCTRPRINTERSTATUS = "UPDATEXABCTRPRINTERSTATUS";//心安宝拥有打印机控制权
	public static final String SMSREMOTEACTIVATE = "SMSREMOTEACTIVATE";//远程激活
	public static final String SMSREMOTENOTIFICATION = "SMSREMOTENOTIFICATION";//服务器下发处理结果通知
	
	/** 指令代码 **/
	public static final short SENDCURRENTECG_CODE=0x0001;				//发送当前的ECG数据
	public static final short POWEROFF_CODE=0x0002;						//关机
	public static final short INMONITOR_CODE=0x0003;					//进入监护
	public static final short EXITMONITOR_CODE=0x0004;					//退出监护
	public static final short SENDGPS_CODE=0x0005;						//发送GPS坐标数据
	public static final short UPDATEAPP_CODE=0x0006;					//更新应用
	public static final short UPDATEADDRESS_CODE=0x0007;				//更新Agent服务器连接地址
	public static final short MEDICALMESSAGE_CODE=0x0008;				//医疗资讯
	public static final short ADDRESSSTATUS_CODE=0x0009;				//Agent服务器状态
	/*###### 2011-06-17 wuchao add  ###########*/
	public static final short UPDATESMSDEV_CODE=  0x000a;				//更新短信猫编码
	public static final short UPDATEUSERIFO_CODE=0x000b;				//更新用户信息编码
	public static final short UPDATEMULDAYREC_CODE=0x000c;				//多天记录支持编码
	public static final short UPDATEDEFINEDTIMESEND_CODE=0x000d;		//定时发送编码
	public static final short UPDATEAVOIDBREAKINONMODE_CODE=0x000e;		//免打扰模式编码
	public static final short UPDATEPRINTERSTATUS_CODE = 0x000f;        //是否开启打印功能编码
	public static final short UPDATEXABCTRPRINTERSTATUS_CODE = 0x0010;  //心安宝拥有打印机控制权编码
	public static final short SMSREMOTEACTIVATE_CODE = 0x0011 ;			//远程激活
	public static final short RESULTNOTIFICATIONS_CODE = 0x0012 ;		//服务器下发处理结果通知
	
	public static final String SMSDATE1 = "yyyy-MM-dd HH:mm:ss";
	public static final String SMSDATE2 = "yy-MM-dd HH:mm:ss";
	public static final String SMSDATE3 = "yy-MM-dd";
	
	/**冒号分隔符**/
	public static final String COMMA_SPLIT_CHAR = ":" ;
	
	/**逗号分隔符**/
	public static final String COLON_SPLIT_CHAR = "," ;
	
	
	/**加密前缀**/
	public static final String PASSPREFIX = "{$$$$}";
	
	/**ZIP方式**/
	public static final String ZIPLIB = "{Z}";
	/**HEX方式**/
	public static final String HEX = "{H}";
	
	/**结束符**/
	public static final String ENDINDEXSIGN = "@END@" ;
	
	
	/** 1保存  2修改 3删除 4查询 标志 **/
	/** 1保存 **/
	public static final int common_save = 1 ;
	/** 2修改 **/
	public static final int common_update = 2 ;
	/** 3删除 **/
	public static final int common_del = 3 ;
	/** 4删除 **/
	public static final int common_find = 4 ;
	
	/** boss系统启动项资源文件 **/
	public static final String BOSS_START_ITEM = "bossCommon.properties" ;
	
	/** 缺省资源文件 **/
	public static final String DEFAULT_RESOURCE_FILE = "system.properties" ;
	
	/** 缺省主机资源键值  **/
	public static final  String  WEBSERVICE_HOST = "webservice.host" ;
	/** 服务器类型 **/
	public static final String COMMONSERVERTYPE = "serverType";
	public static final String MESSAGE_ID = "message.ip" ;
	/**  task index **/
	public static final String LISTENER_RESOURCE_KEY = "task.Listener" ;
	public static final String LISTENER_RESOURCE_METHOD = "task.ListenerMethod" ;
	/**事务执行状态 **/
	public static final  String  TRANSTATUS_INIT = "0" ;
	public static final  String  TRANSTATUS_EXEING = "1" ;
	public static final  String  TRANSTATUS_SUCESS = "2" ;
	public static final  String  TRANSTATUS_TIMEOUT = "3" ;
	public static final  String  TRANSTATUS_DESTROY = "4" ;
	public static final  String  TRANSTATUS_CANCEL = "5" ;
	
	/**事务方式 **/
	public static final  String  TRANSWAY_WS = "0" ;
	public static final  String  TRANSWAY_SQL = "1" ;
	public static final  String  TRANSWAY_STOREPRO = "2" ;
	public static final  String  TRANSWAY_GETOBJECT = "3" ;
	
	
	/** 确认结果 **/
	public static final byte CONFIRM_SUCESS=0x00;				        //成功
	public static final byte CONFIRM_NOTIN=0x01;					    //没有在监护状态
	public static final byte CONFIRM_STARTSERVER=0x02;					//监护状态：启动服务
	public static final byte CONFIRM_HELPDELAYSERVER=0x03;				//监护状态：紧急求助，延时启动服务
	public static final byte CONFIRM_SENDSMSDELAYSERVER=0x04;			//监护状态：发送短信，延时启动服务
	public static final byte CONFIRM_INRECORD=0x05;						//监护状态：正在记录
	public static final byte CONFIRM_INCONNECTING=0x06;					//监护状态：正在连接状态，不响应当前指令，也不给服务器发送回执信息
	public static final byte CONFIRM_INSENDING=0x07;				    //监护状态：正在发送状态，不响应指令，也不给服务器发送回执信息
	public static final byte CONFIRM_OTHERSTATUS=0x08;					//监护状态：其他状态，响应当前指令，延时启动服务
	public static final byte CONFIRM_ERRORPARAM=0x09;				    //参数错误
	public static final byte CONFIRM_FAILED=0x0a;					    //更新失败
	
	/** 序列组 **/
	public static final String SG_EQMT_UPDATE="SG_EQMT_UPDATE"; 		//设备更新组
	/** 序列涉及到的表名 **/
	public static final String ST_EQMTCOREUPDATE="EQMTCOREUPDATE"; 		//EQMTCOREUPDATE
	public static final String ST_PUSHCOMMAND="PUSHCOMMAND"; 			//PUSHCOMMAND	
	public static final String PUSHCOMMAND_GPRS2SMS="PUSHCOMMAND_GPRS2SMS"; 	//PUSHCOMMAND_GPRS2SMS	
	/** 短信提醒 **/
	public static final String SMSTIPS_NO = "0";
	public static final String SMSTIPS_YES = "1";						//需要提醒
	public static final String SMSTIPS_ALREADY = "2";
	/**############## 序列业务类型 ######################**/
	/**激活业务**/
	public static final String ACTIVATE_TYPE = "0";						//激活业务
	/**通知业务**/
	public static final String NOTIFICATION_TYPE = "1";					//通知业务
	/**保存 0**/
	public static final String JS_RESPONSE_SAVE = "0" ;					//保存
	/**修改 1**/
	public static final String JS_RESPONSE_UPDATE = "1" ;				//修改
	/**删除 2**/
	public static final String JS_RESPONSE_DEL = "2" ;					//删除
	/**编辑 3**/
	public static final String JS_RESPONSE_EDIT="3";					//编辑
	
	
	/**异步数据类型**/
	public static final String REGIST_ASNSERVICEINFO = "ASNSERVICEINFO";
	/** 心律宝扩张功能**/
	public static final String EXTENDFUNC_XLB = "EXTENDFUNC_XLB";
	
	/**测试,体验标志(不计费)**/
	public static final String TESTFLAG = "1";
	/** 不发短信  **/
	public static final String NOBACKLAG = "2";
	
	
	//================================渠道机构唯一企业编码===================================//
	/** 网站渠道 **/
	public static final String CODE_YOCALY_WEBSITE = "YOCALY_WEBSITE" ;
	/** CRM渠道 **/
	public static final String CODE_YOCALY_CRM = "YOCALY_CRM" ;
	
	/**上传目录名**/
	public static final String UPLOAD = "upload" ;
	public static final String PICTURE = "picture" ;
	public static final String STPICTURE = "stPicture" ;
	
	/**
	 * 委托类型
	 */
	public static final String WTTYPE_EMAPP = "EMAPP";//应急委托
	public static final String WTTYPE_COMMISSIONED = "EMAPP";//业务委托
	
	/**0:初始化
	 * 1:需要执行
	 * 2:执行成功
	 * 3:执行取消
	 * 4:执行失败
	 * 5:超时
	 * 6:医嘱为空
	 * 7:心电图为空，不进行同步
	 */
	public static final String TASKSTATUS_INIT="0";
	public static final String TASKSTATUS_NEED="1";
	public static final String TASKSTATUS_SUCESS="2";
	public static final String TASKSTATUS_CANCEL="3";
	public static final String TASKSTATUS_FAILED="4";
	public static final String TASKSTATUS_TIMEOUT="5";
	public static final String TASKSTATUS_MSGWRITEBACK_NULL="6";
	public static final String TASKSTATUS_ECG_NULL="7";
	/**
	 * 任务类型
	 */
	public static final String TASKTYPE_SERVICEINFO="0";
	
	/**
	 * 服务商机构上下文
	 */
	
	/** 待开通 **/
	public static final String SPBASEINFO_WAIT="0";
	/** 生效take effect **/
	public static final String SPBASEINFO_TAKE_EFFECT="1";
	/** 停止 **/
	public static final String SPBASEINFO_STOP="2";
	/** 注销 **/
	public static final String SPBASEINFO_LOGOUT="3";
	
	/**
	 * 申请单类型
	 * 	0:医嘱
		1:日常
		2:出差
		3:外勤
		4:借款
		5:其它
	 */
	public static final String APPFORM_BUSSTYPE_WRITEBACK = "0";
	public static final String APPFORM_BUSSTYPE_DAILY = "1";
	public static final String APPFORM_BUSSTYPE_TRAVEL = "2";
	public static final String APPFORM_BUSSTYPE_OUTER = "3";
	public static final String APPFORM_BUSSTYPE_CREDITS = "4";
	public static final String APPFORM_BUSSTYPE_OTHER = "5";
	
	
	/**
	 * 申请单状态
	 * 	0：草稿
		1：待审批
		2：生效
		3：作废
		4: 审批中
	 */
	public static final String APPROVE_STATE_DRAFT = "0";
	public static final String APPROVE_STATE_NOAPPROVE = "1";
	public static final String APPROVE_STATE_EFFECT = "2";
	public static final String APPROVE_STATE_REMOVE = "3";
	public static final String APPROVE_STATE_DOING = "4";
	
	/**
	 * 审批表同步状态
	 * 	0:需要同步
		1:不需要同步
		2:同步完成
		3:同步失败
		4:取消
	 */
	public static final String APPROVE_SYNSTATE_NEED = "0";
	public static final String APPROVE_SYNSTATE_NONEED = "1";
	public static final String APPROVE_SYNSTATE_FINISH = "2";
	public static final String APPROVE_SYNSTATE_FAILED = "3";
	public static final String APPROVE_SYNSTATE_CANCEL = "4";
	
	/**
	 * 审批回调状态
	 * 
	 * 0:需要回调,1:成功,2:失败,3:停止
	 */
	public static final String APPROVE_CALLBACK_NEED = "0";
	public static final String APPROVE_CALLBACK_SUCESS = "1";
	public static final String APPROVE_CALLBACK_FAILED = "2";
	public static final String APPROVE_CALLBACK_STOP = "3";
	
	public static final String USREINFO_MEMO_AFTER="小时";
	/**
	 * 用户信息戴机时长前后补充内容
	 */
	public static final String USREINFO_MEMO_BEFORE="戴机";
	
	/**
	 * 设备型号  M12
	 */
	public static final String EQMT_M12 = "M12";
	/**
	 * 设备型号  M3AG_II
	 */
	public static final String EQMT_M3AG_II = "M3AG-II";
	/**
	 * 设备型号  M3AG
	 */
	public static final String EQMT_M3AG = "M3AG";
	/**
	 * 设备型号  B2AG
	 */
	public static final String EQMT_B2AG = "B2AG";
	/**
	 * 设备型号  A21A
	 */
	public static final String EQMT_A21A = "A21A";
}

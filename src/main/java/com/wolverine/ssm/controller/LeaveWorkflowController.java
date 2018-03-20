package com.wolverine.ssm.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

import org.activiti.bpmn.model.BpmnModel;
import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.activiti.engine.impl.context.Context;
import org.activiti.engine.impl.persistence.entity.GroupEntity;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.persistence.entity.UserEntity;
import org.activiti.engine.impl.pvm.PvmTransition;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.image.ProcessDiagramGenerator;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sun.org.apache.xerces.internal.impl.dv.ValidationContext;

import sun.tools.jar.resources.jar;

@Controller
public class LeaveWorkflowController {
	@Autowired
	private ProcessEngine processEngine;
	@Autowired
	private RepositoryService repositoryService;
	@Autowired
	private RuntimeService runtimeService;
	@Autowired
	private TaskService taskService;
	@Autowired
	private HistoryService historyService;
	@Autowired
	private IdentityService identityService;

	/**
	 * 发布一个流程
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/deployFlow.action")
	public ModelAndView deployFlow() {
		DeploymentBuilder deploymentBuilder = repositoryService.createDeployment();
		deploymentBuilder.addClasspathResource("leaveProcess/leaveProcess.bpmn");
		deploymentBuilder.addClasspathResource("leaveProcess/leaveProcess.png");
		deploymentBuilder.deploy();
		this.addGroup();
		ModelAndView mav = new ModelAndView("forward:/findDeployFlow.action");

		return mav;
	}

	/**
	 * 删除一个流程
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/deleteFlow.action")
	public ModelAndView deleteFlow(HttpServletRequest request) {
		String deploymentId = (String) request.getParameter("deploymentId");
		repositoryService.deleteDeployment(deploymentId, true);
		ModelAndView mav = new ModelAndView("forward:/findDeployFlow.action");
		System.out.println(777);
		return mav;
	}

	@RequestMapping("/findDeployFlow.action")
	public ModelAndView findDeployFlow(HttpServletRequest request) {
		List<ProcessDefinition> pdList = repositoryService.createProcessDefinitionQuery().list();
		for (ProcessDefinition processDefinition : pdList) {
			processDefinition.getKey();
		}
		List<Task> tasklist = getTaskList(request);
		List<ProcessInstance> processInstanceList = getProcessInstanceList(request);
		List<HistoricTaskInstance> historicTaskList = getFinishedHistoryTaskList(request);
		List<HistoricTaskInstance> unhistoricTaskList = getUnFinishedHistoryTaskList(request);
		ModelAndView mav = new ModelAndView();
		for (ProcessInstance processInstance : processInstanceList) {
			processInstance.getProcessDefinitionId();
			processInstance.getProcessDefinitionName();
		}
		mav.addObject("processDefinitionList", pdList);
		mav.addObject("tasklist", tasklist);
		mav.addObject("processInstanceList", processInstanceList);
		mav.addObject("historicTaskList", historicTaskList);
		mav.addObject("unhistoricTaskList", unhistoricTaskList);
		mav.setViewName("leave/jsp/index");
		return mav;
	}

	// 获取用户的任务列表
	public List<Task> getTaskList(HttpServletRequest request) {
		String username = (String) request.getSession().getAttribute("username");
		List<Task> tasklist = taskService.createTaskQuery().taskCandidateOrAssigned(username).list();//.taskCandidateUser(username).list();//.taskAssignee(username).list();
		return tasklist;
	}

	// 获取用户未完成的历史任务列表
	public List<HistoricTaskInstance> getUnFinishedHistoryTaskList(HttpServletRequest request) {
		String username = (String) request.getSession().getAttribute("username");
		List<HistoricTaskInstance> unhistoricTaskList = historyService.createHistoricTaskInstanceQuery()
				.taskAssignee(username).unfinished().list();
		return unhistoricTaskList;
	}
	// 获取用户已经完成的历史任务列表
	public List<HistoricTaskInstance> getFinishedHistoryTaskList(HttpServletRequest request) {
		String username = (String) request.getSession().getAttribute("username");
		List<HistoricTaskInstance>  historicTaskList= historyService.createHistoricTaskInstanceQuery()
				.taskAssignee(username).finished().list();
		return historicTaskList;
	}

	public List<ProcessInstance> getProcessInstanceList(HttpServletRequest request) {
		String username = (String) request.getSession().getAttribute("username");
		List<ProcessInstance> processInstanceList = runtimeService.createProcessInstanceQuery()
				.processDefinitionKey("leaveProcess").list();
		return processInstanceList;
	}

	@RequestMapping("/startFlow.action")
	public ModelAndView startFlow(HttpServletRequest request) {
		String username=(String)request.getSession().getAttribute("username");
		String key = request.getParameter("key");
		Map<String,Object> variables = new HashMap<String,Object>();
        variables.put("user", username);

		runtimeService.startProcessInstanceByKey(key,variables);
		ModelAndView mav = new ModelAndView("forward:/findDeployFlow.action");
		return mav;
	}

	@RequestMapping("/leaveManagerInfo.action")
	public ModelAndView leaveManagerInfo(HttpServletRequest request) {
		String taskid = request.getParameter("taskid");
		String processInstanceId = request.getParameter("processInstanceId");
		Task task = taskService.createTaskQuery().processInstanceId(processInstanceId).singleResult();
		String owner = (String) taskService.getVariable(task.getId(), "owner");
		Integer day = (Integer) taskService.getVariable(task.getId(), "day");
		String reason = (String) taskService.getVariable(task.getId(), "reason");
		ModelAndView mav = new ModelAndView();
		mav.addObject("taskid", taskid);
		mav.addObject("processInstanceId", processInstanceId);
		mav.addObject("owner", owner);
		mav.addObject("day", day);
		mav.addObject("reason", reason);
		mav.setViewName("leave/jsp/manager");
		return mav;
	}

	@RequestMapping("/leaveManager.action")
	public ModelAndView leaveManager(HttpServletRequest request) {
		System.out.println("审批是否通过");
		String taskid = request.getParameter("taskid");
		String reasonManager = request.getParameter("reasonManager");
		String reason = request.getParameter("reason");
		String result = request.getParameter("result");
		int day = Integer.parseInt(request.getParameter("day"));
		String processInstanceId = request.getParameter("processInstanceId");
		Task task = taskService.createTaskQuery().processInstanceId(processInstanceId).singleResult();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("reasonManager", reasonManager);
		paramMap.put("result", result);
		paramMap.put("day", day);
		paramMap.put("reason", reason);
		taskService.complete(taskid, paramMap);
		ModelAndView mav = new ModelAndView("forward:/findDeployFlow.action");
		return mav;
	}

	@RequestMapping("/leaveRequest.action")
	public ModelAndView leaveRequest(HttpServletRequest request) {
		String taskid = request.getParameter("taskid");
		String processInstanceId = request.getParameter("processInstanceId");
		String owner = request.getParameter("owner");
		ModelAndView mav = new ModelAndView();
		mav.addObject("taskid", taskid);
		mav.addObject("processInstanceId", processInstanceId);
		mav.addObject("owner", owner);
		mav.setViewName("leave/jsp/request");
		return mav;
	}

	@RequestMapping("/leaveBossInfo.action")
	public ModelAndView leaveBossInfo(HttpServletRequest request) {
		String taskid = request.getParameter("taskid");
		String processInstanceId = request.getParameter("processInstanceId");
		Task task = taskService.createTaskQuery().processInstanceId(processInstanceId).singleResult();
		String owner = (String) taskService.getVariable(task.getId(), "owner");
		Integer day = (Integer) taskService.getVariable(task.getId(), "day");
		String reason = (String) taskService.getVariable(task.getId(), "reason");
		String reasonManager = (String) taskService.getVariable(task.getId(), "reasonManager");
		ModelAndView mav = new ModelAndView();
		mav.addObject("taskid", taskid);
		mav.addObject("processInstanceId", processInstanceId);
		mav.addObject("owner", owner);
		mav.addObject("day", day);
		mav.addObject("reason", reason);
		mav.addObject("reasonManager", reasonManager);
		mav.setViewName("leave/jsp/boss");
		return mav;
	}

	@RequestMapping("/leaveBoss.action")
	public ModelAndView leaveBoss(HttpServletRequest request) {
		System.out.println("老板审核结束");
		String taskid = request.getParameter("taskid");
		String result = request.getParameter("result");
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("result", result);
		taskService.complete(taskid, paramMap);
		ModelAndView mav = new ModelAndView("forward:/findDeployFlow.action");
		return mav;
	}

	@RequestMapping("/leaveSubmit.action")
	public ModelAndView leaveSubmit(HttpServletRequest request) {

		String taskid = request.getParameter("taskid");
		int day = Integer.parseInt(request.getParameter("day"));
		String reason = request.getParameter("reason");
		String owner = request.getParameter("owner");
		String processInstanceId = request.getParameter("processInstanceId");
		Task task = taskService.createTaskQuery().processInstanceId(processInstanceId).singleResult();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("day", day);
		paramMap.put("reason", reason);
		paramMap.put("owner", owner);
		taskService.complete(taskid, paramMap);
		ModelAndView mav = new ModelAndView("forward:/findDeployFlow.action");
		return mav;
	}

	// /**
	// * 二：查看当前活动，获取当期活动对应的坐标x,y,width,height，将4个值存放到Map<String,Object>中
	// * map集合的key：表示坐标x,y,width,height map集合的value：表示坐标对应的值
	// */
	// public Map<String, Object> findCoordingByTask(String taskId) {
	// // 存放坐标
	// Map<String, Object> map = new HashMap<String, Object>();
	// // 使用任务ID，查询任务对象
	// Task task = taskService.createTaskQuery().taskId(taskId)// 使用任务ID查询
	// .singleResult();
	// // 获取流程定义的ID
	// String processDefinitionId = task.getProcessDefinitionId();
	// // 获取流程定义的实体对象（对应.bpmn文件中的数据）
	// ProcessDefinitionEntity processDefinitionEntity = (ProcessDefinitionEntity)
	// repositoryService
	// .getProcessDefinition(processDefinitionId);
	// // 流程实例ID
	// String processInstanceId = task.getProcessInstanceId();
	// // 使用流程实例ID，查询正在执行的执行对象表，获取当前活动对应的流程实例对象
	// ProcessInstance pi = runtimeService.createProcessInstanceQuery()// 创建流程实例查询
	// .processInstanceId(processInstanceId)// 使用流程实例ID查询
	// .singleResult();
	// // 获取当前活动的ID
	// String activityId = pi.getActivityId();
	// // 获取当前活动对象
	// ActivityImpl activityImpl =
	// processDefinitionEntity.findActivity(activityId);// 活动ID
	// // 获取坐标
	// map.put("x", activityImpl.getX());
	// map.put("y", activityImpl.getY());
	// map.put("width", activityImpl.getWidth());
	// map.put("height", activityImpl.getHeight());
	// return map;
	// }
	@RequestMapping("/viewCurrentImage.action")
	public ModelAndView viewCurrentImage(HttpServletRequest request) {
		String taskid = request.getParameter("taskid");
		ProcessDefinition pd = getProcessDefinitionByTaskId(taskid);
		// 1. 获取流程部署ID
		// putContext("deploymentId", pd.getDeploymentId());
		// 2. 获取流程图片的名称
		// putContext("imageName", pd.getDiagramResourceName());

		// 3.获取当前活动的坐标
		Map<String, Object> currentActivityCoordinates = getCurrentActivityCoordinates(taskid);
		// putContext("acs", currentActivityCoordinates);

		ModelAndView mav = new ModelAndView();
		mav.addObject("deploymentId", pd.getDeploymentId());
		mav.addObject("imageName", pd.getDiagramResourceName());
		mav.addObject("taskid", taskid);
		mav.addObject("acs", currentActivityCoordinates);
		mav.setViewName("leave/jsp/view");
		return mav;
	}

	@RequestMapping("/viewImage.action")
	public String viewImage(HttpServletRequest request, HttpServletResponse response) {
		String deploymentId = request.getParameter("deploymentId");
		String imageName = request.getParameter("imageName");
		InputStream in = repositoryService.getResourceAsStream(deploymentId, imageName);// 此处方法实际项目应该放在service里面
		try {
			OutputStream out = response.getOutputStream();
			// 把图片的输入流程写入resp的输出流中
			byte[] b = new byte[1024];
			for (int len = -1; (len = in.read(b)) != -1;) {
				out.write(b, 0, len);
			}
			// 关闭流
			out.close();
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ProcessDefinition getProcessDefinitionByTaskId(String taskId) {
		// 1. 得到task
		Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
		// task.getProcessDefinitionId()
		// 2. 通过task对象的pdid获取流程定义对象
		ProcessDefinition pd = repositoryService.getProcessDefinition(task.getProcessDefinitionId());
		return pd;
	}

	public Map<String, Object> getCurrentActivityCoordinates(String taskId) {
		Map<String, Object> coordinates = new HashMap<String, Object>();
		// 1. 获取到当前活动的ID
		Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
		ProcessInstance pi = runtimeService.createProcessInstanceQuery().processInstanceId(task.getProcessInstanceId())
				.singleResult();
		String currentActivitiId = pi.getActivityId();
		// 2. 获取到流程定义
		ProcessDefinitionEntity pd = (ProcessDefinitionEntity) repositoryService
				.getProcessDefinition(task.getProcessDefinitionId());
		// 3. 使用流程定义通过currentActivitiId得到活动对象
		ActivityImpl activity = pd.findActivity(currentActivitiId);
		// 4. 获取活动的坐标
		coordinates.put("x", activity.getX());
		coordinates.put("y", activity.getY());
		coordinates.put("width", activity.getWidth());
		coordinates.put("height", activity.getHeight());

		// 如果有多个流程活动节点（并发流程一般有多个活动节点）该方法应该返回一个list，代码应该使用下面的方法
		// 得到流程执行对象
		/*
		 * List<Execution> executions = runtimeService.createExecutionQuery()
		 * .processInstanceId(pi.getId()).list(); // 得到正在执行的Activity的Id List<String>
		 * activityIds = new ArrayList<String>(); for (Execution exe : executions) {
		 * List<String> ids = runtimeService.getActiveActivityIds(exe.getId());
		 * activityIds.addAll(ids); } List<Map<String, Integer>> list = new
		 * ArrayList<Map<String, Integer>>(); for (String id : activityIds) {
		 * ActivityImpl activity1 = pd.findActivity(id); Map<String, Integer> map = new
		 * HashMap<String, Integer>(); map.put("x", activity1.getX()); map.put("y",
		 * activity1.getY()); map.put("width", activity1.getWidth()); map.put("height",
		 * activity1.getHeight()); list.add(map); }
		 */

		return coordinates;
	}
	@RequestMapping("/queryProPlan.action")
	public void queryProPlan(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		String processInstanceId = request.getParameter("ProcessInstanceId");
		System.out.println(processInstanceId+"=================");
		//获取历史流程实例
        HistoricProcessInstance processInstance =  historyService.createHistoricProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
        //获取流程图
        BpmnModel bpmnModel = repositoryService.getBpmnModel(processInstance.getProcessDefinitionId());
        ProcessEngineConfiguration processEngineConfiguration = processEngine.getProcessEngineConfiguration();
        Context.setProcessEngineConfiguration((ProcessEngineConfigurationImpl) processEngineConfiguration);

        ProcessDiagramGenerator diagramGenerator = processEngineConfiguration.getProcessDiagramGenerator();
        ProcessDefinitionEntity definitionEntity = (ProcessDefinitionEntity)repositoryService.getProcessDefinition(processInstance.getProcessDefinitionId());

        List<HistoricActivityInstance> highLightedActivitList =  historyService.createHistoricActivityInstanceQuery().processInstanceId(processInstanceId).list();
        //高亮环节id集合
        List<String> highLightedActivitis = new ArrayList<String>();
        
        //高亮线路id集合
        List<String> highLightedFlows = getHighLightedFlows(definitionEntity,highLightedActivitList);

        for(HistoricActivityInstance tempActivity : highLightedActivitList){
            String activityId = tempActivity.getActivityId();
            highLightedActivitis.add(activityId);
        }

        //中文显示的是口口口，设置字体就好了
        InputStream imageStream = diagramGenerator.generateDiagram(bpmnModel, "png", highLightedActivitis,highLightedFlows,"宋体","宋体",null,null, 1.0);
        //单独返回流程图，不高亮显示
//        InputStream imageStream = diagramGenerator.generatePngDiagram(bpmnModel);
        // 输出资源内容到相应对象
        byte[] b = new byte[1024];
        int len;
        while ((len = imageStream.read(b, 0, 1024)) != -1) {
            response.getOutputStream().write(b, 0, len);
        }
		
	}
	/**
     * 读取带跟踪的图片
     */
    @RequestMapping(value = "/test")
    public void test(HttpServletResponse response) throws Exception {
        // 部署流程，只要是符合BPMN2规范的XML文件，理论上都可以被ACTIVITI部署
        repositoryService.createDeployment().addClasspathResource("com/pzr/demo/diagrams/MyProcess.bpmn").deploy();
        // 开启流程，myprocess是流程的ID
        System.out.println("流程【启动】，环节推动到【一次审批】环节");
        runtimeService.startProcessInstanceByKey("myProcess");
        // 查询历史表中的Task
        List<Task> task = taskService.createTaskQuery().list();
        Task task1 = task.get(task.size()-1);
        //解开注释就推动到下一环节，对应的在流程图上看到
        taskService.complete(task1.getId());
        System.out.println("执行【一次审批】环节，流程推动到【二次审批】环节");
        task1 = taskService.createTaskQuery().executionId(task1.getExecutionId()).singleResult();

        //解开注释就推动到下一环节，对应的在流程图上看到
        taskService.complete(task1.getId());
        System.out.println("执行【二次审批】环节，流程推动到【结束】环节");

        //processInstanceId
        String processInstanceId = task1.getProcessInstanceId();
        //获取历史流程实例
        HistoricProcessInstance processInstance =  historyService.createHistoricProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
        //获取流程图
        BpmnModel bpmnModel = repositoryService.getBpmnModel(processInstance.getProcessDefinitionId());
        ProcessEngineConfiguration processEngineConfiguration = processEngine.getProcessEngineConfiguration();
        Context.setProcessEngineConfiguration((ProcessEngineConfigurationImpl) processEngineConfiguration);

        ProcessDiagramGenerator diagramGenerator = processEngineConfiguration.getProcessDiagramGenerator();
        ProcessDefinitionEntity definitionEntity = (ProcessDefinitionEntity)repositoryService.getProcessDefinition(processInstance.getProcessDefinitionId());

        List<HistoricActivityInstance> highLightedActivitList =  historyService.createHistoricActivityInstanceQuery().processInstanceId(processInstanceId).list();
        //高亮环节id集合
        List<String> highLightedActivitis = new ArrayList<String>();
        //高亮线路id集合
        List<String> highLightedFlows = getHighLightedFlows(definitionEntity,highLightedActivitList);

        for(HistoricActivityInstance tempActivity : highLightedActivitList){
            String activityId = tempActivity.getActivityId();
            highLightedActivitis.add(activityId);
        }

        //中文显示的是口口口，设置字体就好了
        InputStream imageStream = diagramGenerator.generateDiagram(bpmnModel, "png", highLightedActivitis,highLightedFlows,"宋体","宋体",null,null,1.0);
        //单独返回流程图，不高亮显示
//        InputStream imageStream = diagramGenerator.generatePngDiagram(bpmnModel);
        // 输出资源内容到相应对象
        byte[] b = new byte[1024];
        int len;
        while ((len = imageStream.read(b, 0, 1024)) != -1) {
            response.getOutputStream().write(b, 0, len);
        }
    }
	 /**
     * 获取需要高亮的线
     * @param processDefinitionEntity
     * @param historicActivityInstances
     * @return
     */
    private List<String> getHighLightedFlows(
            ProcessDefinitionEntity processDefinitionEntity,
            List<HistoricActivityInstance> historicActivityInstances) {
    	
        List<String> highFlows = new ArrayList<String>();// 用以保存高亮的线flowId
        for (int i = 0; i < historicActivityInstances.size() - 1; i++) {// 对历史流程节点进行遍历
            ActivityImpl activityImpl = processDefinitionEntity
                    .findActivity(historicActivityInstances.get(i)
                            .getActivityId());// 得到节点定义的详细信息
            List<ActivityImpl> sameStartTimeNodes = new ArrayList<ActivityImpl>();// 用以保存后需开始时间相同的节点
            ActivityImpl sameActivityImpl1 = processDefinitionEntity
                    .findActivity(historicActivityInstances.get(i + 1)
                            .getActivityId());
            // 将后面第一个节点放在时间相同节点的集合里
            sameStartTimeNodes.add(sameActivityImpl1);
            for (int j = i + 1; j < historicActivityInstances.size() - 1; j++) {
                HistoricActivityInstance activityImpl1 = historicActivityInstances
                        .get(j);// 后续第一个节点
                HistoricActivityInstance activityImpl2 = historicActivityInstances
                        .get(j + 1);// 后续第二个节点
                if (activityImpl1.getStartTime().equals(
                        activityImpl2.getStartTime())) {
                    // 如果第一个节点和第二个节点开始时间相同保存
                    ActivityImpl sameActivityImpl2 = processDefinitionEntity
                            .findActivity(activityImpl2.getActivityId());
                    sameStartTimeNodes.add(sameActivityImpl2);
                } else {
                    // 有不相同跳出循环
                    break;
                }
            }
            List<PvmTransition> pvmTransitions = activityImpl
                    .getOutgoingTransitions();// 取出节点的所有出去的线
            for (PvmTransition pvmTransition : pvmTransitions) {
                // 对所有的线进行遍历
                ActivityImpl pvmActivityImpl = (ActivityImpl) pvmTransition
                        .getDestination();
                // 如果取出的线的目标节点存在时间相同的节点里，保存该线的id，进行高亮显示
                if (sameStartTimeNodes.contains(pvmActivityImpl)) {
                    highFlows.add(pvmTransition.getId());
                }
            }
        }
        return highFlows;
    }
    public void addGroup() {
    	 /** 添加用户角色组 */
        // 创建角色
        identityService.saveGroup(new GroupEntity("boss"));
        identityService.saveGroup(new GroupEntity("manager"));
        // 创建用户
        identityService.saveUser(new UserEntity("usermanager1"));
        identityService.saveUser(new UserEntity("usermanager2"));
        identityService.saveUser(new UserEntity("userboss1"));
        // 建立用户和角色的关联关系
        identityService.createMembership("usermanager1", "manager");
        identityService.createMembership("usermanager2", "manager");
        identityService.createMembership("userboss1", "boss");

    }
}

package com.wolverine.ssm.service.impl;

import java.io.File;
import java.util.zip.ZipInputStream;

import com.wolverine.ssm.model.LeaveWorkflowModel;
import com.wolverine.ssm.service.LeaveWorkflowService;

public class LeaveWorkflowServiceImpl implements LeaveWorkflowService {

	@Override
	public void saveNewDeploye(File file, String filename) {
		// TODO Auto-generated method stub
		
	}
//	private WorkflowBean workflowBean = new WorkflowBean();
//	/**
//     * 发布流程
//     * @return
//     */
//    public String newdeploy(){
//        //获取页面传递的值
//        //1：获取页面上传递的zip格式的文件，格式是File类型
//        File file = workflowBean.getFile();
//        //文件名称
//        String filename = workflowBean.getFilename();
//        //完成部署
//        saveNewDeploye(file,filename);
//        return "list";
//    }
//
//    /**部署流程定义*/
//    @Override
//    public void saveNewDeploye(File file, String filename) {
//        try {
//            //2：将File类型的文件转化成ZipInputStream流
//            ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(file));
//            repositoryService.createDeployment()//创建部署对象
//                            .name(filename)//添加部署名称
//                            .addZipInputStream(zipInputStream)//
//                            .deploy();//完成部署
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}

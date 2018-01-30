package test;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;

import junit.framework.TestCase;

public class ActivitiTest extends TestCase {
	public void testCreateTableWithXml(){  
		   // 引擎配置  
		   ProcessEngineConfiguration pec=ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti/activiti.cfg.xml");  
	   // 获取流程引擎对象  
		    ProcessEngine processEngine=pec.buildProcessEngine();  
	}  
}

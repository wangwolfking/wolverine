package com.wolverine.db.jdbc.Oracle;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

//Java调用存储过程和函数
public class OracleDao {
  //调用存储过程
  public void callProcedure() throws Exception{
      Connection conn = JdbcUtil.getConnection();
      //第一参数:in  编号 7902
      //第二参数:out 姓名
      //第三参数:out 工作
      //第四参数:out 薪水
      String sql = "call testproc(?,?,?,?)";
      //创建专用于调用过程或函数的对象
      CallableStatement cstmt = conn.prepareCall(sql);
      //为?占位符设置in、out值
      //hibernate从0开始，jdbc从1开始
      cstmt.setInt(1,7902);//in值
      cstmt.registerOutParameter(2,Types.VARCHAR);//out值
      cstmt.registerOutParameter(3,Types.VARCHAR);//out值
      cstmt.registerOutParameter(4,Types.INTEGER);//out值
      cstmt.execute();//抛行调用存储过程
      //依次接收3个返回值
      String ename = cstmt.getString(2);
      String job = cstmt.getString(3);
      Integer sal = cstmt.getInt(4);
      //显示
      System.out.println(ename+"的工作是：" + job + "，它是薪水是" + sal);
      //关闭连接对象
      JdbcUtil.close(cstmt);
      JdbcUtil.close(conn);
  }
  //调用存储函数
  public void callFunction() throws Exception{
      Connection conn = JdbcUtil.getConnection();
      //参数一：in  编号 数值型
      //参数二：out 姓名 字符串型
      //返回值：out 薪水 数值型
      String sql = "{? = call testfunc(?,?,?)}";
      CallableStatement cstmt = conn.prepareCall(sql);
      cstmt.setInt(2,7788);//in
      cstmt.registerOutParameter(3,Types.VARCHAR);//out
      cstmt.registerOutParameter(4,Types.VARCHAR);//out
      cstmt.registerOutParameter(1,Types.INTEGER);//返回值
      cstmt.execute();//执行调用存储函数
      String ename = cstmt.getString(3);
      String ename1 = cstmt.getString(4);
      Integer sal = cstmt.getInt(1);
      System.out.println(ename+"的薪水是"+sal+"=="+ename1);
      //关闭连接对象
      JdbcUtil.close(cstmt);
      JdbcUtil.close(conn);
  }
}

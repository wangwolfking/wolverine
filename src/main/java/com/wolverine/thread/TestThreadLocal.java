/**
 * Project Name: wolverine
 * Package Name: com.wolverine.thread
 * File    Name: TestThreadLocal.java
 * Create  Date: 2018-04-03 17:08
 * Copyright (c) 2018, www.yocaly.com All Rights Reserved.
 * 注意：本内容仅限于山东优加利信息科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */

package com.wolverine.thread;

/**
 * 描述：TODO 用一句话描述这个类的作用（必选）. <br>
 * 背景：TODO 描述创建该类的背景原因（可选）. <br>
 * 日期：2018-04-03 17:08 <br>
 * 变更：
 * 
 * <pre>
 * Version      Date           ModifiedBy       Content
 * --------     ----------     ------------     -----------------------
 * 1.0          2018-04-03     wangzhigang.           创建
 * </pre>
 * 
 * @since JDK 1.8
 * @version 1.0
 * @author yocaly team
 */
public class TestThreadLocal {
    ThreadLocal<Long> longLocal = new ThreadLocal<Long>();
    ThreadLocal<String> stringLocal = new ThreadLocal<String>();
    public void set() {
        longLocal.set(Thread.currentThread().getId());
        stringLocal.set(Thread.currentThread().getName());
    }
    public long getLong() {
        return longLocal.get();
    }
    public String getString() {
        return stringLocal.get();
    }
    public static void main(String[] args) throws InterruptedException {
        final TestThreadLocal test = new TestThreadLocal();
        test.set();
        System.out.println(test.getLong());
        System.out.println(test.getString());
        Thread thread1 = new Thread() {
            public void run() {
                test.set();
                System.out.println(test.getLong());
                System.out.println(test.getString());
            };
        };
        thread1.start();
        thread1.join();
        System.out.println(test.getLong());
        System.out.println(test.getString());
    }
}

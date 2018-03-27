/**
 * Project Name: wolverine
 * Package Name: demo.queue
 * File    Name: ArrayBlockingQueueDemo.java
 * Create  Date: 2018-03-27 10:32
 * Copyright (c) 2018, www.yocaly.com All Rights Reserved.
 * 注意：本内容仅限于山东优加利信息科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */

package demo.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 描述：TODO 用一句话描述这个类的作用（必选）. <br>
 * 背景：TODO 描述创建该类的背景原因（可选）. <br>
 * 日期：2018-03-27 10:32 <br>
 * 变更：
 * <pre>
 * Version      Date           ModifiedBy       Content
 * --------     ----------     ------------     -----------------------
 * 1.0          2018-03-27     wangzhigang.           创建
 * </pre>
 * @since   JDK 1.8
 * @version 1.0
 * @author  yocaly team
 */
public class ArrayBlockingQueueDemo {
    private final static ArrayBlockingQueue<Apple> queue= new ArrayBlockingQueue<>(1);
    public static void main(String[] args){
        new Thread(new Producer(queue)).start();
        new Thread(new Producer(queue)).start();
        new Thread(new Consumer(queue)).start();
        new Thread(new Consumer(queue)).start();
    }

}
class Apple {
    public Apple(){
    }
 }
class Producer implements Runnable{
    private final ArrayBlockingQueue<Apple> mAbq;
    Producer(ArrayBlockingQueue<Apple> arrayBlockingQueue){
        this.mAbq = arrayBlockingQueue;
    }

    @Override
    public void run() {
        while (true) {
            Produce();
        }
    }

    private void Produce(){
        try {
            Apple apple = new Apple();
            mAbq.put(apple);
            System.out.println("生产:"+apple);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/**
 * 消费者线程
 */
class Consumer implements Runnable{

    private ArrayBlockingQueue<Apple> mAbq;

    Consumer(ArrayBlockingQueue<Apple> arrayBlockingQueue){
        this.mAbq = arrayBlockingQueue;
    }

    @Override
    public void run() {
        while (true){
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
                comsume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void comsume() throws InterruptedException {
        Apple apple = mAbq.take();
        System.out.println("消费Apple="+apple);
    }
}

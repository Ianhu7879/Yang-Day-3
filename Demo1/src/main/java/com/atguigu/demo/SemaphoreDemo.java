package com.atguigu.demo;

import com.sun.corba.se.impl.activation.NameServiceStartThread;
import com.sun.org.apache.xalan.internal.xsltc.trax.StAXStream2SAX;
import sun.net.www.protocol.http.ntlm.NTLMAuthentication;
import sun.rmi.runtime.NewThreadAction;

import java.util.IntSummaryStatistics;
import java.util.Random;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author IanHu
 * @dare 2019/10/14 - 22:12
 * SemaphoreDemo 计数信号量(信号灯)
 * 多线程并行(多对多)多个线程抢多把锁,如果permits为1,相当synchronize
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);//模拟3个车位(设置3个信号)
        for (int i = 0; i < 6; i++) { //模拟六辆车(6个线程)
            new Thread(()->{
                boolean flag = false;
                try {
                    semaphore.acquire();//一直等,减掉一个车位(减掉一个信号)
                    flag = true; //确定抢到车位
                    System.out.println(Thread.currentThread()+"\t 抢到车位");
                    try {
                        //抢到车位后睡眠5秒钟
                        TimeUnit.SECONDS.sleep(new Random().nextInt(5));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread()+"\t 离开车位");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    if(flag){ //判断抢到车位
                        semaphore.release();//释放信号
                    }
                }
            },String.valueOf(i)).start();


        }
    }
}

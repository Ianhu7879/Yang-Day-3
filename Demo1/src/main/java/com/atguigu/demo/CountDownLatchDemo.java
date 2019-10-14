package com.atguigu.demo;

import java.util.concurrent.CountDownLatch;

/**
 * @author IanHu
 * @dare 2019/10/14 - 20:25
 * 需求,6个同学1个班长,班长必须走的时候关门
 * CountDownLatchDemo
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        //1.创建一个CountDownLatch对象
        CountDownLatch countDownLatch = new CountDownLatch(6);
        //2.六个同学六个线程,执行完后班长进行关门
        for (int i = 0; i < 6; i++) {
            new Thread(() ->{
                System.out.println(Thread.currentThread().getName() + "\t 离开教室");
                //3.每遍历一遍就会-1
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }
        //4.只要倒计时没有到0,其它线程就会受阻
        countDownLatch.await();
        //5.倒计时结束,执行其它线程
        System.out.println(Thread.currentThread().getName()+"\t 关门离开");
    }

}

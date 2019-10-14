package com.atguigu.demo;

import java.awt.image.PixelInterleavedSampleModel;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author IanHu
 * @dare 2019/10/14 - 21:02
 * CyclicBarrier 循环屏障
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        //1.创建一个CyclicBarrier对象,设置参数1.屏障层数 2.屏障损坏后执行的代码
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()->{
            System.out.println("集齐7颗龙珠,能够释放大招"); });
            for (int i = 0; i < 7; i++) {
                int finall = i;
                new Thread(()->{
                    System.out.println(Thread.currentThread().getName() + "\t收集到第" + finall +"\t");
                    try {
                        //2.损坏屏障
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                },String.valueOf(i)).start();


            }


    }
}

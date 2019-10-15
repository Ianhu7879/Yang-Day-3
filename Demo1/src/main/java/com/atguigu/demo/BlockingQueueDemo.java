package com.atguigu.demo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author IanHu
 * @dare 2019/10/15 - 8:05
 * 队列先进先出
 * put/take 如果阻塞则会进入一直阻塞
 * offer/poll 如果阻塞或报 false
 * add/remove 如果阻塞直接报异常
 * .offer("A",2, TimeUnit.SECONDS))/poll(2,TimeUnit.SECONDS)) 如果超出指定时间线程阻塞就会报错
 */
public class BlockingQueueDemo {
    public static void main(String[] args) throws Exception {
        //1.创建阻塞队列
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue(4);

      /*  blockingQueue.put("a");
        blockingQueue.put("a");
        blockingQueue.put("a");
        blockingQueue.put("a");

        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());*/

       /* System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("a"));

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());*/

       /* System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("a"));

        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
*/
        System.out.println(blockingQueue.offer("A",2, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("A",2, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("A",2, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("A",2, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("A",2, TimeUnit.SECONDS));

        System.out.println(blockingQueue.poll(2,TimeUnit.SECONDS));
        System.out.println(blockingQueue.poll(2,TimeUnit.SECONDS));
        System.out.println(blockingQueue.poll(2,TimeUnit.SECONDS));
        System.out.println(blockingQueue.poll(2,TimeUnit.SECONDS));


    }
}

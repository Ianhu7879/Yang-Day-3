package com.atguigu.demo;

import org.omg.Messaging.SyncScopeHelper;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author IanHu
 * @dare 2019/10/14 - 23:39
 * 多线程中,第3种获取多线程的方式
 *  1    get方法一般请放在最后一行
 */
class MyThread implements Callable<String>
{
    //Callable相当于runable接口,但是可以定义返回值类型,并且可以抛出异常
    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "\t*** come in call");
        return "java0615";
    }
}
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //此对象实现了runable接口,并且可以添加Callable对象,进行执行
        FutureTask<String> futureTask = new FutureTask(new MyThread());

        new Thread(futureTask,"AAA").start();
        //获取方法所返回的类型
        String result = futureTask.get();

        System.out.println(result);

        System.out.println("*****主线程:" + Thread.currentThread().getName());


    }

}

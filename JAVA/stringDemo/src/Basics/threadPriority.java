package Basics;

import org.w3c.dom.ls.LSOutput;


class run12 implements Runnable
{
    @Override
    public void run()
    {
        for (int i=0;i<5;i++)
        {
            System.out.println("Child thread " + i);
        }
    }

}

public class threadPriority {

    public static void main(String[] args) {


        Thread t1 = new Thread(new run12(), "t1");
        Thread t2 = new Thread(new run12(), "t2");
        Thread t3 = new Thread(new run12(), "t3");

        System.out.println("Main thread priority is " + Thread.currentThread());
        System.out.println("Priority of t1 " + t1.getPriority());
        System.out.println("Priority of t2 " + t2.getPriority());

        System.out.println(Thread.MIN_PRIORITY);
        System.out.println(Thread.NORM_PRIORITY);
        System.out.println(Thread.MAX_PRIORITY);

    }

}

package Basics;

class myRunnable implements Runnable
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


public class RunnableDemo {
    public static void main(String[] args) {

        mYRunnable my = new mYRunnable();
        Thread t = new Thread(my);
        t.start();
        for (int i=0;i<5;i++)
        {
            System.out.println("Main thread : " + i);
        }





    }
}

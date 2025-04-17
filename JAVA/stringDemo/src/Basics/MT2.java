package Basics;

class mYRunnable implements Runnable
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

public class MT2 {

    public static void main(String[] args) {

        Thread t1 = new Thread(new mYRunnable());

        String t1name = t1.getName();
        System.out.println("Default name: " + t1name);

        t1.setName("MyThread-t1");
        System.out.println("My name : " + t1.getName());



    }

}

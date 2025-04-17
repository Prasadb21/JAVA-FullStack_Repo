package Basics;

public class ExceptionTesting {

    public static void main(String[] args) {


        try
        {
            System.out.println(div(10,0));
        }
        catch (Exception e)
        {
//            e.printStackTrace();
//            e.getMessage();
            e.toString();
//            System.out.println(e.getMessage());
            System.out.println(e.toString());
//            System.out.println("Invalid input");
        }



    }

    public static int div(int a, int b)
    {
        return a/b;
    }
}

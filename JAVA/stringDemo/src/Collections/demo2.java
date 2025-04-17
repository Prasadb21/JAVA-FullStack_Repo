package Collections;

public class demo2 {
    public static void main(String[] args) {

        int a = 10;

        String str = Integer.toString(a);

        Integer x = 10;
        Integer y = 20; // this is internally  : new Integer(20);
        Integer c = new Integer(12); // this method is deprecated, and is recommended to use as : Integer c = 12;

        System.out.println("Value of C : " + c);

        System.out.println(Integer.compare(x,y));

    }
}

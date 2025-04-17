package Collections;

public class demo1 {
    public static void main(String[] args) {

        String str = "12345";

        System.out.println(str);

        int strToInt = Integer.parseInt(str); // parseInt should only contain numbers in the string.
        // this is called parsing and not type casting
        System.out.println(strToInt);

    }
}

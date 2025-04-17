package Basics;

public class stringBuilder {

    public static void main(String[] args) {

        String s1 = new String("Prasad");

        String s2 = s1.concat(" Bhalkikar");

        System.out.println(s1 == s2);
        System.out.println(s2);

        StringBuffer sb1 = new StringBuffer("Prasad");
        StringBuffer sb2 = sb1.append(" Bhalkikar");

        System.out.println("=============================================================");
        System.out.println(sb1==sb2);
        System.out.println(sb1);
        System.out.println(sb2);




    }

}

package CollectionDemo.ListDemo;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {

    public static void main(String[] args) {

        List list = new ArrayList<>(10);

        list.add(10);
        list.add("Prasad");
        list.add("123344");
        list.add(true);

        System.out.println(list);

        // but when we create generic LIST of a particular type, we can only insert that type of data.

        List<Integer> listInteger = new ArrayList<Integer>(10);

        System.out.println("------------------------------------------------------------------------");

        listInteger.add(10);
        listInteger.add(20);
        listInteger.add(30);
        listInteger.add(40);
        listInteger.add(10);
        listInteger.add(20);

        System.out.println(listInteger.get(2));

        System.out.println(listInteger);



    }

}

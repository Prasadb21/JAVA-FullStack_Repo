import java.util.*;

class arrays {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Elements of the string array : ");

        String[] arr = new String[4];

        for(int i=0;i<arr.length;i++)
        {
            arr[i] = sc.next();
        }

        
        System.out.println(Arrays.toString(arr));

        arr[1] = "Bhalkikar";
        

        System.out.println(Arrays.toString(arr));

        
        sc.close(); // Important to prevent resource leaks

    }
}
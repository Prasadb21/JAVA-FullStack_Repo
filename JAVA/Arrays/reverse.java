import java.util.*;

public class reverse {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number f elements in the array:");

        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter the array elements");
        for (int i = 0; i < n; i++) {
            
            arr[i] = sc.nextInt();
        }

        int temp;

        int startElement = 0;
        int lastElement = arr.length - 1;

        while(startElement < lastElement)
        {
            temp = arr[startElement];
            arr[startElement] = arr[lastElement];
            arr[lastElement] = temp;

            startElement++;
            lastElement--;
        }

        System.out.println("The reversed array is : ");
        System.out.println(Arrays.toString(arr));

        sc.close();

    }
    
}

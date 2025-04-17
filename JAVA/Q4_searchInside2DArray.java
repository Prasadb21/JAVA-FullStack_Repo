import java.util.Arrays;

public class Q4_searchInside2DArray {

    public static void main(String[] args) {
        int arr[][] = {
            {1,2,3,4},
            {5,3,53,25,65},
            {6,8,3,4,0},
            {90,89,88}
        };

        int target = 25;

        maximumElementPosition(arr);

        System.out.println(Integer.MAX_VALUE + " " + Integer.MIN_VALUE);

        System.out.println("Found the target element at : " + Arrays.toString(searchIn2DArray(arr, target)));
        System.out.println("Maximum Element is : " + maxIn2DArray(arr)+ " At position :" + Arrays.toString(maximumElementPosition(arr)));
    }

    static int[] searchIn2DArray(int arr[][] , int tarrget)
    {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {

                if(arr[i][j] == tarrget)
                {
                    return new int[]{i,j};
                }
                
            } 
        }

        return new int[]{-1,-1};
    }

    static int maxIn2DArray(int arr[][])
    {
        int max = -1;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                
                if(arr[i][j] > max)
                {
                    max = arr[i][j];
                }
                
            } 
        }

        return max;
    }

    static int[] maximumElementPosition(int arr[][])
    {
        int maximumElement = maxIn2DArray(arr);

        // System.out.println(maximumElement);

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                
                if(arr[i][j] == maximumElement)
                {
                    return new int[]{i,j};
                }
            } 
        }

        return new int[]{-1,-1};

    }


    
}

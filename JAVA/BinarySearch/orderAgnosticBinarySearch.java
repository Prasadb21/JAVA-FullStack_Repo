package BinarySearch;

public class orderAgnosticBinarySearch {

    public static void main(String[] args) {
        
        // int arr[] = {2,4,6,9,11,12,14,20,36,48};
        int arr[] = {34,9,8,7,6,5,4,3,2,1,0};

        int target = 4;

        System.out.println(orderAgnosticBS(arr, target));
    }

    static int orderAgnosticBS(int arr[] , int target)
    {

        int start = 0;
        int end = arr.length-1;

        // find if the array is sorted in ascending order or descending order.
        boolean isAscending = arr[start] < arr[end];

        while (start <= end) {

            int mid = start + (end-start)/2;

            if (arr[mid] == target) 
            {
                return mid;
            }
            
            if(isAscending)
            {
                if(target < arr[mid])
                {
                    end = mid-1;
                }
                else
                {
                    start = mid+1;
                }   
            }
            else
            {
                if(target > arr[mid])
                {
                    end = mid-1;
                }
                else
                {
                    start = mid+1;
                } 
            }

        }


        return -1;
    }
}

package BinarySearch;

public class binarySearch {

    public static void main(String[] args) {
        
    
    int arr[] = {2,4,6,9,11,12,14,20,36,48};

    int target = 36;

    System.out.println(binarySearchFunc(arr, target));

    }

    //return the index, by binary search
    // return -1 if it dosen't exist

    static int binarySearchFunc(int arr[],int target)
    {

        int start = 0;
        int end = arr.length-1;

        while (start <= end) {

            int mid = start + (end-start)/2;

            if(target < arr[mid])
            {
                end = mid-1;
            }
            else if(target >arr[mid])
            {
                start = mid+1;
            }
            else
            {
                return mid;
            }
        }


        return -1;
    }

}

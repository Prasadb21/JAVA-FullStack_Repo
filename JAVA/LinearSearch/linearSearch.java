public class linearSearch {
    
    public static void main(String[] args) {
        int[] nums = {23,45,1,2,43,-11,28};
        int target_element = 46;

        System.out.println((linearSearchFunction(nums, target_element)));

    }

    //search in the array
    //Return the index if item is found

    static int linearSearchFunction(int[] arr , int target)
    {
        if(arr.length == 0)
        {
            return -1;
        }

        // run a for loop for searching inside the array.
        for (int i = 0; i < arr.length; i++)
        {
            // check for the element at every index, if it is == target.
            if(arr[i] == target)
            {
                return i;
            }                
        }
        return -1; // this line will get executed of none of the return statemnet in the funcetion gets executed

    }

}

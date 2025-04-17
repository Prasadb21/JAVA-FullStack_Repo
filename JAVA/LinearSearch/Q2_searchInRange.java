public class Q2_searchInRange {
    
    public static void main(String[] args) {
        
        int arr[] = {1,42,43,45,654,323,6,7,8,9,10,0,32,23,12};

        int rangeStart = 3;
        int rangeEnd = 8;
        int target = 12;

        System.out.println(searchElementInRange(arr, rangeStart, rangeEnd, target));

    }

    static int searchElementInRange(int arr[] , int rangeStart , int rangeEnd , int target)
    {
        
        if(arr.length == 0)
        {
            return -1;
        }

        for(int i = rangeStart; i <= rangeEnd; i++)
        {
            if(arr[i] == target)
            {
                return i;
            }
        }

        return -1;
    }

}

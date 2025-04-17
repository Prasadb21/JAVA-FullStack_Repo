public class Q3_searchMinimumElement {
    
    public static void main(String[] args) {
        
        int arr[] = {1,42,43,45,654,323,6,7,8,9,10,32,23,12};

        System.out.println(minimumElementInArray(arr));

    }
    // return the minimum value inside the array.
    static int minimumElementInArray(int arr[])
    {

        int min = 99999;

        for (int i : arr) { 
            if(i < min)
            {
                min = i;
            }
        }

        return min;
    }

}

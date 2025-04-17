import java.util.Arrays;
import java.util.Collections;

public class MatrixRotation {

    public static void main(String[] args) {
        
        int mat[] = { 1, 2, 3 };

        int[][] target = {{1,1,1},{0,1,0},{0,0,0}};

        Collections.reverse(Arrays.asList(mat));

        System.out.println(Arrays.toString(mat));

        // boolean r = Arrays.equals(mat, target);

        // System.out.println(r);

        System.out.println(Arrays.toString(mat));
        System.out.println(Arrays.toString(target));

    }
    
}

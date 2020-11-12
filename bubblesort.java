//System.out.println(Arrays.toString(bubbleSort(new int[] {5,2,4,3,10,7,1,9,6,8})));
import java.util.Arrays;
public class bubblesort {
  public static void  main (String args []){
  int score [] = {5,2,4,3,10,7,1,9,6,8};
  System.out.println(Arrays.toString(score));
  System.out.println(Arrays.toString(bubbleSort(score)));
  }
  public static int [] bubbleSort(int arr[]) { 
        int n = arr.length; 
        for (int i = 0; i < n-1; i++) 
            for (int k = 0; k < n-i-1; k++) 
                if (arr[k] > arr[k+1]) {  
                    int j = arr[k]; 
                    arr[k] = arr[k+1]; 
                    arr[k+1] = j; 
                } 
      return arr;  
    } 

}
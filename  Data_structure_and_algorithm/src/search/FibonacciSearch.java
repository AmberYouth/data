package search;

import java.util.Arrays;

public class FibonacciSearch {
    static int MAX = 20;
    public static void main(String[] args) {
        int arr[] = {1,8,89,1000,1234};
        System.out.println(fibSearch(arr,1));

    }

    public static int[] fb(){
       int[] fb = new int[MAX];
       fb[0] = 1;
       fb[1] = 1;
       for (int i = 2;i<MAX-1;i++){
           fb[i] = fb[i-1] +fb[i-2];
       }
       return fb;
    }

    public static int fibSearch(int[] a,int key){
        int low = 0;
        int high = a.length-1;
        int k = 0;//表示斐波那契数列的下标
        int mid = 0;
        int[] fb = fb();
        while (high>fb[k]-1){
            k++;
        }
        int[] temp = Arrays.copyOf(a,fb[k]);
        for (int i = high+1;i<temp.length;i++){
            temp[i] = a[high];
        }
        while(low<=high){
                mid = low + fb[k-1];
            if (low==high){
                return high;
            }
            if (key<temp[mid]){
                high = mid-1;
                k--;
            }else if(key>temp[mid]){
                low = mid+1;
                k=k-2;
            }else {
                if (mid<=high){
                    return mid;
                }else{
                    return high;
                }
            }

        }
        return -1;
    }
}

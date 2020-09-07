package sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {-9,78,0,23,-567,70,1,60};
        QuickSort.quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr , int left , int right){
        int temp = 0;
        int l = left; //左下标
        int r = right;//右下标
        int pivot = arr[(left+right)/2];
        while(l<r){
            //在中轴左边一直找，找到比pivot大的
            while(arr[l]<pivot){
                l+=1;
            }
            //在中轴右边一直找，找到比pivot小的
            while(arr[r]>pivot){
                r-=1;
            }
            if (l>=r){
                break;
            }
            temp = arr[l];
            arr[l] = arr[r] ;
            arr[r] = temp;
            if (arr[l]==pivot){
                l++;
            }
            if (arr[r]==pivot){
                r--;
            }
        }
            if (l==r){
                l+=1;
                r-=1;
            }
            if (left<r){
                quickSort(arr,left,r);
            }
            if (right>l){
                quickSort(arr,l,right);
            }

    }
}

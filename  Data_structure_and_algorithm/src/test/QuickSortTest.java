package test;

import sort.QuickSort;

import java.util.Arrays;

public class QuickSortTest {
    public static void main(String[] args) {
        int[] arr = {-9,30,50,20};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr,int left,int right){
        int temp = 0;
        int l =left;
        int r = right;
        int pivot = (left+right)/2;
        if (l<r){
            while (arr[l]<arr[pivot]){
                l++;
            }
            while (arr[r]>arr[pivot]){
                r--;
            }
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            if (arr[l]==arr[pivot]){
                l++;
            }
            if (arr[r]==arr[pivot]){
                r--;
            }
            if (l==r){
                l++;
                r--;
            }
            if (left<r){
                quickSort(arr,left,r);
            }
            if (right>l){
                quickSort(arr,l,right);
            }
        }

    }

}

package test;

import sort.*;

import java.util.Date;

public class test {
    public static void main(String[] args) {
        int[] arr = new int[800000];
        for (int i = 0; i <800000 ; i++) {
            arr[i] = (int)(Math.random() * 8000000);
        }
        InsetSort insetSort = new InsetSort();
        ShellSort shellSort = new ShellSort();
//        System.out.println("冒泡排序");
//        System.out.println("排序前"+new Date().getTime());
//        BubbleSort bubbleSort = new BubbleSort();
//        bubbleSort.bubble(arr);
//        System.out.println("排序后"+new Date().getTime());
//        System.out.println("选择排序");
//        SelectSort.selectSort(arr);
//        System.out.println("插入排序");
//        System.out.println("排序前"+new Date().getTime());
//        insetSort.insertSort(arr);
//        System.out.println("排序后"+new Date().getTime());
//        System.out.println("插入排序2");
//        System.out.println("排序前"+new Date().getTime());
//        insetSort.insertSort2(arr);
//        System.out.println("排序后"+new Date().getTime());
//        System.out.println("希尔排序");
//        System.out.println("排序前"+new Date().getTime());
//        shellSort.shellSort(arr);
//        System.out.println("排序后"+new Date().getTime());
//        System.out.println("希尔排序2");
//        System.out.println("排序前"+new Date().getTime());
//        shellSort.shellSort2(arr);
//        System.out.println("排序后"+new Date().getTime());
        System.out.println("快速排序");
        System.out.println("排序前"+new Date().getTime());
        QuickSort.quickSort(arr,0,arr.length-1);
        System.out.println("排序后"+new Date().getTime());
        System.out.println("基数排序");
        System.out.println("排序前"+new Date().getTime());
        RadixSort.radixSort(arr);
        System.out.println("排序后"+new Date().getTime());
    }
}

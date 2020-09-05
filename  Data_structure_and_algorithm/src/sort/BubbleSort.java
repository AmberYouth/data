package sort;

import java.util.Date;

public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = {10,7,6,8,2};
        System.out.println(new Date().getTime());
        int[] num = BubbleSort.bubble(nums);
        System.out.println(new Date().getTime());
        for (int i = 0; i <num.length ; i++) {
            System.out.println(num[i]);
        }
    }

    public static int[] bubble(int[] nums){
        boolean flag = false;
        for (int i = 0; i <nums.length-1 ; i++) {
            flag = false;
            for (int j = 0; j <nums.length-1-i ; j++) {
                if (nums[j]>nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                    flag = true;
                }
            }
            if (flag==false){
                return nums;
            }
        }
        return nums;
    }
}

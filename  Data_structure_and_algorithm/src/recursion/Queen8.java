package recursion;

import com.sun.security.jgss.GSSUtil;

public class Queen8 {
    int max = 8;
    int[] array = new int[max];
    int count = 0;

    public static void main(String[] args) {
        Queen8 queen8 = new Queen8();
        queen8.check(0);
        System.out.println(queen8.count);
//        for (int i = 0; i <queen8.array.length ; i++) {
//            System.out.println(queen8.array[i]);
//        }
    }

    //查看我们放置第n个皇后，就去检测和之前的皇后是否冲突
    private boolean judge(int n){
        for (int i = 0; i <n ; i++) {
            if (array[i]==array[n]||Math.abs(n-i)==Math.abs(array[n]-array[i])){
                return false;
            }
        }
        return true;
    }

    private void print(){
        count++;
        for (int i = 0; i <array.length ; i++) {

            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

    private void check(int n){
        if (n==max){
            print();
            return;
        }
        for (int i = 0; i <max ; i++) {
            if (n<max){
                array[n]=i;
            }
            if (judge(n)){
                check(n+1);
            }
        }
    }

}

package test;

import recursion.Queen8;

public class Queen8Test {
    private int max = 8;
    private int[] queen = new int[max];
    private static int count=0;
    public static void main(String[] args) {
        Queen8Test queen8Test = new Queen8Test();
        queen8Test.check(0);
        System.out.println(count);
    }

    public boolean judge(int n){
        for (int i = 0; i <n ; i++) {
            if (Math.abs(n-i)==Math.abs(queen[n]-queen[i])||queen[n]==queen[i]){
                return false;
            }
        }
        return true;
    }

    public void check(int n){
        if (n==max){
                print();
                return;
        }
        for (int i = 0; i <queen.length ; i++) {
            queen[n]=i;
            if (judge(n)){
                check(n+1);
            }
        }
    }
    public void print(){
        for (int i = 0; i <max ; i++) {
            System.out.print(queen[i]+"  ");
        }
        count++;
        System.out.println();
    }
}

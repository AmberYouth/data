package linkedlist;

import java.util.ArrayList;
import java.util.List;

public class josepfu {
    public static void main(String[] args) {
        CircleSingleLinkedList list = new CircleSingleLinkedList();
        list.add(5);
        list.list();
        list.josepfuTest(2);
    }
}

class Boy {
    private int num;
    private Boy next;

    public Boy(int num) {
        this.num = num;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}

class CircleSingleLinkedList {
    private Boy first = new Boy(-1);

    void add(int num) {
        Boy curBoy = first;
        if (num < 1) {
            System.out.println("编号错误，无法加入!");
            return;
        }
        for (int i = 1; i <= num; i++) {
            if (i == 1) {
                Boy newboy = new Boy(i);
                first = newboy;
                first.setNext(newboy);
                curBoy = first;
                continue;
            }
            Boy newBoy = new Boy(i);
            while ((curBoy = curBoy.getNext()) != first) {
                break;
            }
            newBoy.setNext(curBoy.getNext());
            curBoy.setNext(newBoy);
        }
    }

    int list() {
        Boy curBoy = first;
        int num = 0;
        do {
            num++;
            System.out.println("当前学生的编号:" + curBoy.getNum());
            curBoy = curBoy.getNext();
        } while ((curBoy != first));
        return num;
    }

    public void josepfuTest(int num) {
        Boy curBoy = first;
        List<Integer> list = new ArrayList<>();
        while (curBoy.getNext() != curBoy) {
            for (int i = 1; i < num - 1; i++) {
                curBoy = curBoy.getNext();
            }
            if (curBoy.getNext().getNext() == curBoy) {
                list.add(curBoy.getNum());
                curBoy = curBoy.getNext();
                curBoy.setNext(curBoy);
            } else {
                list.add(curBoy.getNext().getNum());
            }
            curBoy.setNext(curBoy.getNext().getNext());

            if (num == 2) {
                curBoy = curBoy.getNext();
            }
            if (curBoy.getNext() == curBoy) {  //仅有一个的时候触发
                list.add(curBoy.getNum());
            }
        }
        System.out.println(list);
    }
}

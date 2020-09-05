package linkedlist;

import java.util.Date;

public class SingleLinkedListMode {
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        HeroNode node1 = new HeroNode(1, "张三", "三哥");
        HeroNode node5 = new HeroNode(3, "李四", "四爹");
        HeroNode node2 = new HeroNode(5, "杨森", "森哥");
        HeroNode node3 = new HeroNode(7, "魏建东", "阿伟");
        list.orderAdd(node1);
        list.orderAdd(node5);
        list.orderAdd(node3);
        list.orderAdd(node2);
//        System.out.println("===============================");
//        System.out.println("有" + list.getLength() + "个节点");
//        list.list();
//        System.out.println("-------------------------------");
//        System.out.println(new Date().getTime());
//        list.fanZhuan();
//        System.out.println(new Date().getTime());
//        System.out.println("有" + list.getLength() + "个节点");
//        list.list();
        SingleLinkedList list2 = new SingleLinkedList();
        HeroNode node10 = new HeroNode(2, "张三", "三哥");
        HeroNode node11= new HeroNode(4, "李四", "四爹");
        HeroNode node12= new HeroNode(6, "杨森", "森哥");
        HeroNode node13= new HeroNode(8, "魏建东", "阿伟");
        list2.orderAdd(node10);
        list2.orderAdd(node11);
        list2.orderAdd(node12);
        list2.orderAdd(node13);
        list.list();
        list = list.lianJie(list,list2);
        list.list();

    }
}

class HeroNode {
    int num;
    String name;
    String nickname;
    HeroNode next;

    public HeroNode(int num, String name, String nickname) {
        this.num = num;
        this.name = name;
        this.nickname = nickname;
    }

    public HeroNode() {
    }
}

class SingleLinkedList {
    private HeroNode head = new HeroNode(0, "", "");

    public void add(HeroNode heroNode) {
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                temp.next = heroNode;
                break;
            }
            temp = temp.next;
        }
    }

    public void orderAdd(HeroNode heroNode) {
        HeroNode temp = head;
        while (true) {
            if (temp.num < heroNode.num && temp.next == null) {
                temp.next = heroNode;
                break;
            } else if (temp.num < heroNode.num && temp.next.num > heroNode.num) {
                heroNode.next = temp.next;
                temp.next = heroNode;
                break;
            }
            temp = temp.next;
        }
    }

    public void list() {
        HeroNode temp = head;
        if ((temp=temp.next) != null) {

            do {
                System.out.println("编号：" + temp.num + ",姓名：" + temp.name + ",称号：" + temp.nickname);
            } while ((temp = temp.next) != null);
        }
    }

    public int getLength() {
        int count = 0;
        HeroNode temp = head;
        while (temp.next != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public void fanZhuan() {
        HeroNode newHead = new HeroNode(0, "", "");
        if (head.next == null) {
            System.out.println("空链表无法反转");
            return;
        }
        HeroNode temphead = head;
        while ((temphead = temphead.next) != null) {
            if (newHead.next == null) {
                newHead.next = temphead;
                temphead = temphead.next;
                newHead.next.next = null;
                head.next = temphead;
                temphead = head;
            } else {
                if (temphead == null) {
                    break;
                }
                head.next = temphead.next;
                temphead.next = newHead.next;
                newHead.next = temphead;
                temphead = head;
            }
        }
        head.next = newHead.next;
    }

    public static SingleLinkedList lianJie(SingleLinkedList list1,SingleLinkedList list2){
        HeroNode temp = list2.head;
        HeroNode node=temp;
        while ((temp=temp.next)!=null){
            node = temp.next;
            list1.orderAdd(temp);
            temp=node;
        }
        return list1;
    }

}

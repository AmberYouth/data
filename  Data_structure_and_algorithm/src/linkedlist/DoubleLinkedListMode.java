package linkedlist;

public class DoubleLinkedListMode {
    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();
        HeroNode2 node1 = new HeroNode2(1, "张三", "三哥");
        HeroNode2 node5 = new HeroNode2(3, "李四", "四爹");
        HeroNode2 node2 = new HeroNode2(5, "杨森", "森哥");
        HeroNode2 node3 = new HeroNode2(7, "魏建东", "阿伟");
        list.orderAdd(node1);
        list.orderAdd(node5);
        list.orderAdd(node3);
        list.orderAdd(node2);
        list.list();
        HeroNode2 node6 = new HeroNode2(7, "王五", "五爷");
        HeroNode2 node7 = new HeroNode2(5, "王五", "五爷");
        System.out.println("=======================================");
        list.delete(node6);
        list.delete(node7);
        list.list();
    }
}
class HeroNode2 {
    int num;
    String name;
    String nickname;
    HeroNode2 pre;
    HeroNode2 next;

    public HeroNode2(int num, String name, String nickname) {
        this.num = num;
        this.name = name;
        this.nickname = nickname;
    }

    public HeroNode2() {
    }
}

class DoubleLinkedList {
    private HeroNode2 head = new HeroNode2(0, "", "");

    public void add(HeroNode2 heroNode) {
        HeroNode2 temp = head;
        while (true) {
            if (temp.next == null) {
                temp.next = heroNode;
                heroNode.pre = temp;
                break;
            }
            temp = temp.next;
        }
    }

    public void orderAdd(HeroNode2 heroNode) {
        HeroNode2 temp = head;
        while (true) {
            if (temp.num < heroNode.num && temp.next == null) {
                temp.next = heroNode;
                heroNode.pre = temp;
                break;
            } else if (temp.num < heroNode.num && temp.next.num > heroNode.num) {
                heroNode.next = temp.next;
                temp.next.pre = heroNode;
                temp.next = heroNode;
                heroNode.pre = temp;
                break;
            }
            temp = temp.next;
        }
    }

    public void list() {
        HeroNode2 temp = head;
        if ((temp = temp.next) != null) {

            do {
                System.out.println("编号：" + temp.num + ",姓名：" + temp.name + ",称号：" + temp.nickname);
            } while ((temp = temp.next) != null);
        }
    }

    public int getLength() {
        int count = 0;
        HeroNode2 temp = head;
        while (temp.next != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public void fanZhuan() {
        HeroNode2 newHead = new HeroNode2(0, "", "");
        if (head.next == null) {
            System.out.println("空链表无法反转");
            return;
        }
        HeroNode2 temphead = head;
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

    public void delete(HeroNode2 node){
        HeroNode2 temp= head;
        while ((temp=temp.next)!=null){
            if (temp.num==node.num){
                temp.pre.next = temp.next;
                if (temp.next!=null){
                    temp.next.pre = temp.pre;
                }
                if (temp.next==null){
                    break;
                }
            }

        }
    }

    public static DoubleLinkedList lianJie(DoubleLinkedList list1, DoubleLinkedList list2){
        HeroNode2 temp = list2.head;
        HeroNode2 node=temp;
        while ((temp=temp.next)!=null){
            node = temp.next;
            list1.orderAdd(temp);
            temp=node;
        }
        return list1;
    }
}

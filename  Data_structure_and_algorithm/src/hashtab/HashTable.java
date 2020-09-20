package hashtab;

import java.util.Scanner;

public class HashTable {
    private EmpLinkedList[] empLinkedArray;
    private int size;

    public HashTable(int size) {
        this.empLinkedArray = new EmpLinkedList[size];
        this.size = size;
        for (int i = 0; i <size ; i++) {
            empLinkedArray[i] = new EmpLinkedList();
        }
    }
    public void add(Emp emp){
        int index = hashEmp(emp.id);
        empLinkedArray[index].add(emp);
    }
    public void list(){
        for (int i=0;i<empLinkedArray.length;i++){
            empLinkedArray[i].list();
        }
    }

    public int hashEmp(int id){
        return id % size;
    }
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(10);
        Scanner s = new Scanner(System.in);
        String key="";
        while(true){
            System.out.println("add:添加雇员");
            System.out.println("list:显示雇员");
            System.out.println("exit:退出系统");
            key = s.next();
            switch(key){
                case "add":
                    System.out.println("输入id");
                    int id = s.nextInt();
                    System.out.println("输入名字");
                    String name = s.next();
                    Emp emp = new Emp(id,name);
                    hashTable.add(emp);
                    break;
                case "list":
                    hashTable.list();
                    break;
                case "exit":
                    s.close();
                    System.exit(0);
            }
        }
    }

}

 class Emp{
    public int id;
    public String name;
    public Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Emp() {
    }

    @Override
    public String toString() {
        return "emp{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

}
class EmpLinkedList{
    public Emp head;

    public EmpLinkedList() {
    }

    public void add(Emp emp){
        if (head==null){
            head=emp;
            return;
        }
        Emp curEmp = head;
        while(true){
            if (curEmp.next==null){
                break;
            }
            curEmp = curEmp.next;
        }
        curEmp.next = emp;

    }
    public void list(){
        if (head==null){
            System.out.println("链表为空");
            return;
        }
        System.out.println("当前链表信息为");
        Emp curEmp = head;
        while(true){
            System.out.println("=>"+curEmp);
            if (curEmp.next==null){//已经是最后节点
                break;
            }
            curEmp = curEmp.next;
        }

    }
}

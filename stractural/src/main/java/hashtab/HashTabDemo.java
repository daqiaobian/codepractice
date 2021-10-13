package hashtab;

import java.util.Scanner;

public class HashTabDemo {
    public static void main(String[] args) {
        HashTab hashTab = new HashTab(7);
        //写一个简单菜单来测试
        String key = "";
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("add: 添加雇员：");
            System.out.println("list: 显示雇员");
            System.out.println("find: 查找雇员");
            System.out.println("exit: 退出系统");

            key = sc.next();
            switch (key){
                case "add":
                    System.out.println("输入id:");
                    int id = sc.nextInt();
                    System.out.println("输入名字:");
                    String name = sc.next();
                    //创建雇员
                    Emp emp = new Emp(id,name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "find":
                    System.out.println("请输入要查找的id：");
                    id = sc.nextInt();
                    hashTab.findEmpById(id);
                    break;
                case "exit":
                    sc.close();
                    System.exit(0);
                default:
                    break;
            }
        }
    }
}

//创建hashtab  管理多条去哦链表
class HashTab{
    private EmpLinkedList[] empLinkedListArray;
    private int size; //表示有多少条链表
    //构造器
    public HashTab(int size){
        //初始化empLinkedListArray
        empLinkedListArray = new EmpLinkedList[size];
        //不要忘了分别初始化每个链表
        for (int i = 0; i < size; i++){
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }

    //添加雇员
    public void add(Emp emp){
        //根据员工的id，得到该员工应该添加到哪条链表
        int empLinkedListNO = hashFun(emp.id);
        //将emp添加到对应的链表中
        empLinkedListArray[empLinkedListNO].add(emp);
    }

    //遍历所有的链表| 遍历hashtab
    public void list(){
        for (int i = 0; i < size; i++){
            empLinkedListArray[i].list(i);
        }
    }

    //根据输入的id查找雇员
    public void findEmpById(int id){
        //使用散列函数
        int empLinkedListNo = hashFun(id);
        Emp emp = empLinkedListArray[empLinkedListNo].findEmpById(id);
        if (emp != null){
            System.out.printf("在第%d条链表中找到 雇员id = %d\n", (empLinkedListNo+1), id);
        }else{
            System.out.println("在该哈希表中没有找到该雇员");
        }
    }

    //编写一个散列函数,使用一个简单的取模法
    public int hashFun(int id){
        return id % size;
    }
}

//表示一个雇员
class Emp{
    public int id;
    public String name;
    public Emp next;  //默认为空

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

//创建一个EmpLinkedList，表示链表
class EmpLinkedList{
    //头指针，指向第一个EMP,因此职业哥链表的head有效，直接指向第一个EMP
    private Emp head;

    //添加雇员到链表
    //1、假定，当添加雇员时,id时自增长的，即id的分配从小到大
    //因此将该雇员直接加到本链表的最后一个即可
    public void add(Emp emp){
        //如果是添加第一个雇员
        if (head == null){
            head = emp;
            return;
        }
        //如果不是第一个雇员,则使用一个辅助的指针帮助我们定位到最后
        Emp curEmp = head;
        while (true){
            if (curEmp.next == null){
                break;
            }
            curEmp = curEmp.next;
        }
        //退出时，直接将Emp加入链表
        curEmp.next = emp;
    }
    //遍历链表的雇员信息
    public void list(int no){
        if (head == null) {
            System.out.println("第 "+(no+1)+"链表为空");
            return;
        }
        System.out.print("第 "+ (no+1)+"链表的信息为:");
        Emp curEmp = head; //辅助指针
        while (true){
            System.out.printf("=>id=%d  name=%s\t",curEmp.id,curEmp.name);
            if (curEmp.next == null){ //说明已经时最后一个结点
                break;
            }
            curEmp = curEmp.next;
        }
        System.out.println();
    }
    //根据id查找雇员
    //如果找到返回，没有返回null
    public Emp findEmpById(int id){
        if (head == null){
            System.out.println("链表空");
            return null;
        }
        Emp curEmp = head;
        while (true){
            if (curEmp.id == id){
                break;// 这时curEmp 就这指向要查找的雇员
            }
            if (curEmp.next == null){
                //说明遍历当前链表没有找到该雇员
                curEmp = null;
                break;
            }
            curEmp = curEmp.next;
        }
        return curEmp;
    }
}
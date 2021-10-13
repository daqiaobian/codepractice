package demeter;

import java.util.ArrayList;
import java.util.List;

public class Demeter {
   /* public static void main(String[] args) {
        //创建了一个学校的管理类
        SchoolManger schoolManger = new SchoolManger();
        //输出了学院员工的id和学校总部的员工信息
        schoolManger.printAllEmployee(new CollegeManager());
    }
}

class Employee{
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

class CollegeEmployee{
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

class CollegeManager{
    public List<CollegeEmployee> getAllEmployee() {
        List<CollegeEmployee> list = new ArrayList<CollegeEmployee>();
        for (int i = 0; i < 10; i++){
            CollegeEmployee emp = new CollegeEmployee();
            emp.setId("学院员工id= " + i);
            list.add(emp);
        }
        return list;
    }
}


//分析直接朋友类，Employee,CollegeManger
//CollegeEmployee不是直接朋友，而是一个陌生类，违反了蒂米卡法则
class SchoolManger {
    public List<Employee> getAllEmployee(){
        List<Employee> list = new ArrayList<Employee>();
        for (int i = 0; i < 5; i++){   //五个员工放在学校
            Employee emp = new Employee();
            emp.setId("学校总部员工id= " + i);
            list.add(emp);
        }
        return list;
    }
    //该方法完成输出
    void printAllEmployee(CollegeManager sub){
        //1、这里的CollegeManager不是Schoolmanger的直接朋友
        //2、CollegeEmployee是以局部变量方式出现在SchoolManager
        //3、违背迪米特法则


        List<CollegeEmployee> list1 = sub.getAllEmployee();
        System.out.println("-----------学院员工------------");
        for (CollegeEmployee e : list1){
            System.out.println(e.getId());
        }
        //获取到学校中部的员工信息
        List<Employee> list2 = this.getAllEmployee();
        System.out.println("-----------学校总部员工------------");
        for (Employee e : list2)
            System.out.println(e.getId());
    }*/
}
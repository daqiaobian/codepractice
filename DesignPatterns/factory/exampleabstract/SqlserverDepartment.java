package factory.exampleabstract;

public class SqlserverDepartment implements IDepartment{
    public void Insert(Department department){
        System.out.println("在SQL server中给Department表增加一条记录");
    }

    @Override
    public Department GetDepartment(int id) {
        System.out.println("在SQL server中根据ID得到Department表一个记录");
        return null;
    }
}

package factory.exampleabstract;

public class AccessDepartment implements IDepartment{

    @Override
    public void Insert(Department department) {
        System.out.println("在access中给Department增加一条记录");
    }

    @Override
    public Department GetDepartment(int id) {
        System.out.println("在access中根据ID得到Department表一条记录");
        return null;
    }
}

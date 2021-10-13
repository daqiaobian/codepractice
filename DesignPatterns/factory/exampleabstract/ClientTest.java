package factory.exampleabstract;

public class ClientTest {
    public static void main(String[] args) {
        User user = new User();
        Department department = new Department();

        IFactory factory = new SqlserverFactory();        //AccessFactory();
        IUser iu = factory.CreateUser(); //此时已与具体的数据库访问解除了依赖

        iu.Insert(user);
        iu.GetUser(1);

        IDepartment id = factory.CreateDepartment();
        id.Insert(department);
        id.GetDepartment(3);

    }
}

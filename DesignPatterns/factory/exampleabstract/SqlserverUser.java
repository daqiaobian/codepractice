package factory.exampleabstract;

public class SqlserverUser implements IUser{

    @Override
    public void Insert(User user) {
        System.out.println("在SQL server中给User增加一条记录");
    }

    @Override
    public User GetUser(int id) {
        System.out.println("在SQL server中根据ID得到User表一条jilu ");
        return null;
    }
}

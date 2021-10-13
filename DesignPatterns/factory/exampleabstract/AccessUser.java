package factory.exampleabstract;

public class AccessUser implements IUser{

    @Override
    public void Insert(User user) {
        System.out.println("在Access中给user增加一条记录");
    }

    @Override
    public User GetUser(int id) {
        System.out.println("在Access中根据ID得到User表一条记录");
        return null;
    }
}

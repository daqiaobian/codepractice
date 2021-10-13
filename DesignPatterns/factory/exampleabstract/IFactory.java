package factory.exampleabstract;

public interface IFactory {
    public IUser CreateUser();

    //增加的接口方法
    public IDepartment CreateDepartment();
}

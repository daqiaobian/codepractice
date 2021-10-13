package prototype.deepclone;

public class Client {
    public static void main(String[] args) {
        DeepProtoType deepProtoType = new DeepProtoType();
        deepProtoType.name = "songjiang";
        deepProtoType.deepCloneableTarget = new DeepCloneableTarget("daniu","daleiclass");

        //方式一进行深拷贝

    }
}

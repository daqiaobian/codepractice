package prototype.deepclone;

import java.io.*;

public class DeepProtoType implements Serializable, Cloneable {
    public String name;
    public DeepCloneableTarget deepCloneableTarget; //引用类型
    public DeepProtoType() {
        super();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object deep = null;
        //这里完成对基本类型（属性）和String的克隆
        deep = super.clone();
        //对引用类型的属性，进行单独处理
        DeepProtoType deepProtoType = (DeepProtoType) deep;
        deepProtoType.deepCloneableTarget = (DeepCloneableTarget) deepCloneableTarget.clone();
        return deepProtoType;
    }

    //通过对象的序列化实行深拷贝(推荐);
    public Object deepClone() {
        ByteArrayOutputStream bos = null; //字节数组输出流
        ObjectOutputStream oos = null;//对象输出流
        ByteArrayInputStream bis = null;//字节数组输入流
        ObjectInputStream ois = null;

        try{
            //序列化
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            //翻序列化
            bis = new ByteArrayInputStream(bos.toByteArray());//相对于实现克隆
            ois = new ObjectInputStream(bis);
            DeepProtoType copyObj = (DeepProtoType) ois.readObject();
            return copyObj;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                bos.close();
                oos.close();
                bis.close();
                ois.close();
            }catch (Exception e2){
                System.out.println(e2.getMessage());
            }
        }
    }
}

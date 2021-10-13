package symboltable;

public class SymbolTest {
    public static void main(String[] args) {
        /*SymbolTable<Integer, String> st = new SymbolTable<>();
        st.put(1, " zhangshan");
        st.put(2,"细看");
        st.put(3, " shkdjfh");

        System.out.println(st.size());

        st.put(1, " 老三");
        System.out.println(st.get(1));*/

        OrderSymbolTable<Integer, String> bt = new OrderSymbolTable<>();
        bt.put(4,"二哈");
        bt.put(3,"hk");
        bt.put(6,"ll");
        
    }
}

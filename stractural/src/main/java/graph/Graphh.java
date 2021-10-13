package graph;

/*
* 构造方法： Graphh(int v)：创建一个包含V个顶点但不包含便的图
*
* 成员方法：
*   public int V(): 获取途中顶点的数量
*   public int E(): 获取图中便的数量
*   public void addEdge(int v, int w): 向图中添加一条边V-w
*   public Queue adj(int v): 获取和顶点v相邻的所有顶点
*
* 成员变量：
*   private final int V: 记录顶点的数量
*   private int E: 记录边数量
*   private Queue[] adj: 邻接表
*
* */

import xianxing.Queue;

public class Graphh {
    private final int V;
    private int E;
    private Queue<Integer>[] adj;

    public Graphh(int V) {
        this.V = V;
        this.E = 0;
        this.adj = new Queue[V];
        for (int i = 0; i < adj.length; i++){
            adj[i] = new Queue<Integer>();
        }
    }
    public Queue<Integer> adj(int v){
        return adj[v];
    }
    public int V(){
        return V;
    }
    public int E(){
        return E;
    }
    public void addEdge(int v, int w){
        adj[v].enqueue(w);
        adj[w].enqueue(v);
        E++;
    }
}

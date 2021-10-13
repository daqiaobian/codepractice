package graph;

import java.util.ArrayList;
import java.util.Arrays;

public class Graph {
    private ArrayList<String> vertexList;//存储顶点集合
    private int[][] edges;  //存储图对应的邻接矩阵
    private int numOfEdges; //边的数
    //给定数组boolean[]，记录某个结点是否呗访问
    private boolean[] isVisited;

    public static void main(String[] args) {
        int n = 5;
        String VertexValue[] = {"A","B","c","D","E"};
        Graph graph = new Graph(n);
        for (String value : VertexValue){
            graph.insertVertex(value);
        }
        //添加边
        //a-b a-c b-c b-d b-e
        graph.insertEdge(0,1,1);
        graph.insertEdge(0,2,1);
        graph.insertEdge(1,2,1);
        graph.insertEdge(1,3,1);
        graph.insertEdge(1,4,1);

    }

    //
    public Graph(int n) {
        //初始化矩阵和vertexlist
        edges = new int[n][n];
        vertexList = new ArrayList<>(n);
        numOfEdges = 0;
    }

    //得到第一个邻接结点的下标w
    //如果存在就返回对应的下标，否则返回-1
    public int getFirstNeighbor(int index){
        for (int j = 0; j < vertexList.size(); j++){
            if (edges[index][j] > 0){
                return j;
            }
        }
        return -1;
    }
    //根据前一个邻接结点的下标来获取下一个邻接结点
    public int getNextNeighbor(int v1, int v2){
        for (int j = v2 + 1;j < vertexList.size(); j++){
            if (edges[v1][j] > 0){
                return j;
            }
        }
        return -1;
    }
    //深度优先遍历算法
    //i第一次就是0
    public void dfs(boolean[] isVisited, int i){
        //首先我们访问该节点输出
        System.out.print(getValueByIndex(i) + "->");
        //将结点设置为已经访问
        isVisited[i] = true;
        //查找结点i的第一个邻接结点w
        int w = getFirstNeighbor(i);
        while (w != -1){
            if (!isVisited[w]){
                dfs(isVisited,w);
            }
            w = getNextNeighbor(i, w);
        }
    }
    //对dfs进行一个重载，遍历我们所有结点，并进行dfs
    public void dfs() {
        isVisited = new boolean[vertexList.size()];
        //遍历所有结点，进行dfs[回溯]
        for (int i = 0; i < getNumOfVertex(); i++){
            if (!isVisited[i]){
                dfs(isVisited, i);
            }
        }
    }

    //图中常用的方法打
    //返回结点的个数
    public int getNumOfVertex(){
        return vertexList.size();
    }
    //得到边的数目
    public int getNumOfEdges(){
        return numOfEdges;
    }
    //返回结点i（下标对应的数据）, 0->"A" 1->"B"
    public String getValueByIndex(int i){
        return vertexList.get(i);
    }

    //返会v1和v2的权值
    public int getWeight(int v1, int v2){
        return edges[v1][v2];
    }

    //显示图对应的举证
    public void showGraph(){
        for (int[] link : edges){
            System.out.println(Arrays.toString(link));
        }
    }

    //插入结点
    public void insertVertex(String vertex){
        vertexList.add(vertex);
    }

    //添加边
    /*
    * v1表示点的下表即是第几个顶点 “A”
    * v2 第二个顶点对应的下标
    * */
    public void insertEdge(int v1, int v2, int weight){
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }
}

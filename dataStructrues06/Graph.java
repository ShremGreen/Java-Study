package Graph;

import java.util.ArrayList;
import java.util.Arrays;
/*
连接情况如下：
    a
   / \
  b---c
  |\
  d e
 */

public class Graph {
    private ArrayList<String> vertexList;// 存储顶点的集合
    private int[][] edges;// 存储图对应的邻接矩阵
    private int numEdges;// 边的数目
    private boolean[] isVisited;// 标记节点是否被访问

    public static void main(String[] args) {
        String[] vertex = {"a", "b", "c", "d", "e"};
        Graph graph = new Graph(5);
        for(String temp : vertex) {
            graph.insertVertex(temp);
        }

        //添加边
        //ab ac bc bd be
        graph.insertEdge(0,1,1);
        graph.insertEdge(0,2,1);
        graph.insertEdge(1,2,1);
        graph.insertEdge(1,3,1);
        graph.insertEdge(1,4,1);

        graph.getEdges();

        System.out.println("深度遍历：");
        graph.DFS();
    }

    //构造方法
    public Graph(int n) {
        edges = new int[n][n];
        vertexList = new ArrayList<String>(n);
        numEdges = 0;
        isVisited = new boolean[n];
    }

    // 插入节点
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    /**
     * @param v1 节点一
     * @param v2 节点二
     * @param weight 连接节点一和二的边
     */
    //添加边
     public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numEdges ++;
     }

     //返回边的数目
    public int getEdgeNum() {
         return numEdges;
    }

    //返回节点个数
    public int getVertexNum() {
         return vertexList.size();
    }

    //返回下标对应的节点
    public String getValue(int i) {
         return vertexList.get(i);
    }

    //返回节点间的权值
    public int getWeight(int v1, int v2) {
         return edges[v1][v2];
    }

    //显示邻接矩阵
    public void getEdges() {
         for(int[] temp : edges) {
             System.out.println(Arrays.toString(temp));
        }
    }

    //获得第一个邻接节点的下标
    /**
     * @param index 传入节点号
     * @return 输出第一个邻接节点号
     */
    public int getFirstNeighbor(int index) {
         for(int i = 0; i < vertexList.size(); i ++) {
             if(edges[index][i] > 0) {
                 return i;
             }
         }
         return -1;
    }

    //获得下一个邻接节点的下标（当递归判断失败后）
    /**
     * @param index 传入节点
     * @param vertex1 第一个邻接节点
     * @return 后一个邻接节点
     */
    public int getNextNeighbor(int index, int vertex1) {
        for(int i = vertex1 + 1; i < vertexList.size(); i ++) {
            if(edges[index][i] > 0) {// 邻接矩阵，行标为当前节点，列标为要找的邻接节点
                return i;
            }
        }
        return -1;
    }

    //深度优先算法
    public void DFS(int i) {
        System.out.print(getValue(i) + "->");
        isVisited[i] = true;
        int w = getFirstNeighbor(i);// 第一个邻接节点
        while(w != -1) {
            if(! isVisited[w]) {// 若当前节点没有被标记
                DFS(w);// 找当前节点的第一个邻接节点
            }
            w = getNextNeighbor(i,w);
        }
    }

    //重载DFS，遍历所有节点，并进行DFS(回溯)
    public void DFS() {
        for(int i = 0; i < getVertexNum(); i ++) {
            if(! isVisited[i]) {
                DFS(i);
            }
        }
    }
}

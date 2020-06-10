package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Graph {
    //存储顶点的集合
    private ArrayList<String> vertexList;
    //存储图对应的邻结矩阵
    private int[][] edges;
    //存储边的数目
    private int numOfEdges;
    //记录某个节点是否被访问
    private boolean[] isVisited;

    //图结构初始化
    public Graph(int n) {
        vertexList = new ArrayList<String>(n);
        numOfEdges = 0;
        edges = new int[n][n];
        numOfEdges = 0;
        isVisited = new boolean[5];
    }

    public static void main(String[] args) {
        //测试一把图是否创建ok
        Graph graph = new Graph(5);
        String vertexvalue[] = {"A", "B", "C", "D", "E"};
        //循环添加顶点
        for (String value : vertexvalue) {
            graph.insertVertex(value);
        }
        //添加边
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);
        //显示临结矩阵
        graph.showGraph();
        //dfs测试
        //   graph.dfs();
        //bfs测试
        graph.bfs();
    }

    //得到第一个临接结点的下标w
    public int getFirstNeighbor(int index) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (edges[index][i] > 0)
                return i;
        }
        return -1;
    }

    //dfs
    private void dfs(boolean[] isVisited, int i) {
        //首先我们访问该结点，输出
        System.out.print(getValueByIndex(i) + "->");
        //将结点设置为已经访问
        isVisited[i] = true;
        //查找结点i的第一个临接结点w
        int w = getFirstNeighbor(i);
        while (w != -1) {
            if (!isVisited[w])
                dfs(isVisited, w);
            //如果w结点已经被访问过
            w = getNextNeighbor(i, w);
        }
    }

    //对dfs进行一个重载，遍历我们所有的结点，并进行dfs
    public void dfs() {
        //遍历所有的结点，进行回溯
        for (int i = 0; i < getNumOfVerTex(); i++) {
            if (!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
    }

    //遍历所有结点，进行bfs
    public void bfs() {
        for (int i = 0; i < getNumOfVerTex(); i++) {
            if (!isVisited[i])
                bfs(isVisited, i);
        }
    }

    //插入结点
    public void insertVertex(String verTex) {
        vertexList.add(verTex);
    }

    //添加边
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }

    //返回结点的个数
    public int getNumOfVerTex() {
        return vertexList.size();
    }

    //返回边的数目
    public int getNumOfEdges() {
        return numOfEdges;
    }

    //返回结点i对应的数据
    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    //返回v1和v2的权值
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    //显示图对应的矩阵
    public void showGraph() {

        for (int[] link : edges) {
            System.out.println(Arrays.toString(link));
        }

    }

    //bfs
    private void bfs(boolean[] isVisited, int i) {
        //队列头节点对应的下标
        int u;
        //邻接结点
        int w;
        //队列，记录结点的访问顺序
        LinkedList queue = new LinkedList();
        //访问结点,输出结点信息
        System.out.println(getValueByIndex(i) + "=>");
        //标记为已访问
        isVisited[i] = true;
        //将结点加入队列
        queue.addLast(i);
        while (!queue.isEmpty()) {
            //取出队列的头结点下标
            u = (int) queue.removeFirst();
            //得到第一个邻接结点的下标w
            w = getFirstNeighbor(u);
            while (w != -1) {
                //是否访问过
                if (!isVisited[w]) {
                    System.out.println(getValueByIndex(w) + "=>");
                    //标记已经访问
                    isVisited[w] = true;
                    //入队
                    queue.addLast(w);
                }
                //以u为前驱点，找w后面的下一个邻结点
                w = getNextNeighbor(u, w);
            }
        }
    }

    //根据前一个临接结点的下标来获取下一个邻接结点
    public int getNextNeighbor(int v1, int v2) {
        for (int i = v2 + 1; i < vertexList.size(); i++) {
            if (edges[v1][i] > 0) {
                return i;
            }
        }
        return -1;
    }
}
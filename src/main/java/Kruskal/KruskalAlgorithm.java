package Kruskal;

import lombok.ToString;

import java.util.Arrays;

/**
 * @Author: yangkai
 * @Date: 2022/7/19 10:26
 */
public class KruskalAlgorithm {
    private int edgeNum;//边的条数
    private char[] vertexs;//存储各点
    private int[][] matrix;//领接矩阵
    private static final int INF=Integer.MAX_VALUE;//表示两个顶点不能联通
    public static void main(String[] args) {
        char[] vertexs={'A','B','C','D','E','F','G'};
        int matrix[][]=new int[][]{
                {0,12,INF,INF,INF,16,14},
                {12,0,10,INF,INF,7,INF},
                {INF,10,0,3,5,6,INF},
                {INF,INF,3,0,4,INF,INF},
                {INF,INF,5,4,0,2,8},
                {16,7,6,INF,2,0,9},
                {14,INF,INF,INF,8,9,0}
        };
        KruskalAlgorithm kruskalAlgorithm = new KruskalAlgorithm(vertexs, matrix);
        kruskalAlgorithm.show();
        EData[] edges=kruskalAlgorithm.getEdges();
        kruskalAlgorithm.sort(edges);
        System.out.println(Arrays.toString(edges));
    }
    public KruskalAlgorithm(char[] vertexs,int[][] matrix){
        this.vertexs=vertexs;
        this.matrix=matrix;
        int vLen=vertexs.length;
        for (int i = 0; i < vLen; i++) {
            for (int j = i+1; j < vLen; j++) {
                if(this.matrix[i][j]!=INF){
                    edgeNum++;
                }
            }
        }
    }
    public void show(){
        System.out.println("领接矩阵为： ");
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = 0; j < vertexs.length; j++) {
                System.out.printf("%20d",matrix[i][j]);
            }
            System.out.println();
        }
    }
    //对边进行冒泡排序
    public void sort(EData[] edges){
        for (int i = 0; i < edges.length-1; i++) {
            for (int j = 0; j < edges.length-1-i; j++) {
                if(edges[j].weight>edges[j+1].weight){
                    EData temp=edges[j];
                    edges[j]=edges[j+1];
                    edges[j+1]=temp;
                }
            }
        }
    }
    private int getPosition(char ch){
        for (int i = 0; i < vertexs.length; i++) {
            if(vertexs[i]==ch){
                return i;
            }
        }
        return -1;
    }
    private EData[] getEdges(){
        int index=0;
        EData[] edges=new EData[edgeNum];
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = i+1; j < vertexs.length; j++) {
                if(matrix[i][j]!=INF){
                    edges[index++]=new EData(vertexs[i],vertexs[j],matrix[i][j]);
                }
            }
        }
        return edges;
    }
}
//它的对象表示一条边
class EData{
    char start;//边的起点
    char end;//边的终点
    int weight;
    public EData(char start,char end,int weight){
        this.start=start;
        this.end=end;
        this.weight=weight;
    }

    @Override
    public String toString() {
        return "EData{" +
                "start=" + start +
                ", end=" + end +
                ", weight=" + weight +
                '}';
    }
}

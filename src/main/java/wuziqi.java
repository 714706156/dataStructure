/**
 * @Author: yangkai
 * @Date: 2022/2/10 10:25
 */
public class wuziqi {
    public static void main(String[] args) {
        int arrays[][]=new int[11][11];
        arrays[1][2]=1;
        arrays[2][3]=2;
        //打印原二维数组
        for (int[] row:arrays){
            for (int item:row){
                System.out.printf("%d\t",item);
            }
            System.out.println();
        }
        int sum=0;
        for(int i=0;i<11;i++){
            for(int j=0;j<11;j++){
                if(arrays[i][j]!=0){
                    sum++;
                }
            }
        }
        System.out.println(sum);

        //创建稀疏数组
        int sparse[][]=new int[sum+1][3];
        sparse[0][0]=11;
        sparse[0][1]=11;
        sparse[0][2]=sum;
        int count=0;
        for(int i=0;i<11;i++){
            for(int j=0;j<11;j++){
                if(arrays[i][j]!=0){
                    count++;
                    sparse[count][0]=i;
                    sparse[count][1]=j;
                    sparse[count][2]=arrays[i][j];
                }
            }
        }
        //打印稀疏数组
        for (int[] row:sparse){
            for (int item:row){
                System.out.printf("%d\t",item);
            }
            System.out.println();
        }

        //恢复成二维数组
        int array2[][]=new int[sparse[0][0]][sparse[0][1]];
        for (int i=1;i<sparse.length;i++){
            array2[sparse[i][0]][sparse[i][1]]=sparse[i][2];
        }
        //打印恢复后的二维数组
        for (int[] row:array2){
            for (int item:row){
                System.out.printf("%d\t",item);
            }
            System.out.println();
        }

    }
}

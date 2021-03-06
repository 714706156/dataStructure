package recursion;

/**
 * @Author: yangkai
 * @Date: 2022/2/15 17:15
 */
public class MiGong {
    public static void main(String[] args) {
        int[][] map=new int[8][7];
        for(int i=0;i<7;i++){
            map[0][i]=1;
            map[7][i]=1;
        }
        for (int i=0;i<8;i++){
            map[i][0]=1;
            map[i][6]=1;
        }
        map[3][1]=1;
        map[3][2]=1;
        for(int i=0;i<8;i++){
            for (int j=0;j<7;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
        getWay(map,1,1);
        for(int i=0;i<8;i++){
            for (int j=0;j<7;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
    //0表示没走过，1表示墙壁，2表示该路可以走，3表示该路已走过但走不通
    public static boolean getWay(int[][] map,int i,int j){
        if(map[6][5]==2){
            return true;
        }else {
            if(map[i][j]==0){
                map[i][j]=2;
                if (getWay(map,i+1,j)){
                    return true;
                }else if(getWay(map,i,j+1)){
                    return true;
                }else if(getWay(map,i-1,j)){
                    return true;
                }else if(getWay(map,i,j-1)){
                    return true;
                }
                else {
                    map[i][j]=3;
                    return false;
                }
            }else {
                return false;
            }
        }
    }
}

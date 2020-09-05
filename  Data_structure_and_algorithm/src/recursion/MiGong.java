package recursion;

public class MiGong {
    public static void main(String[] args) {
        int[][] map =new int[8][7];
        for (int i = 0;i<7;i++){
            map[0][i] = 1;
            map[7][i] = 1;

        }
        for (int i = 0; i <8 ; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;
        for (int i = 0;i<8;i++){
            for (int j = 0; j <7 ; j++) {
                System.out.print(map[i][j]+"  ");
            }
            System.out.println();
        }
        System.out.println("地图的情况");
        setWay(map,1,1);
        for (int i = 0;i<8;i++){
            for (int j = 0; j <7 ; j++) {
                System.out.print(map[i][j]+"  ");
            }
            System.out.println();
        }
    }

    /**
     *
     * @param map 表示地图
     * @param i 从那个位置找
     * @param j
     * @return 如果找到路，返回true 否则false
     */
    public static boolean setWay(int[][] map ,int i,int j){
        if(map[6][5]==2){
            return true;
        }else{
            if (map[i][j]==0){
                //按照策略走
                map[i][j] = 2;
                if (setWay(map,i+1,j)){
                    return true;
                }else if (setWay(map,i,j+1)){
                    return true;
                }else if (setWay(map,i-1,j)){
                    return true;
                }else if (setWay(map,i,j-1)){
                    return true;
                }else{
                    map[i][j] = 3;
                }
            }else{
                return false;
            }
        }
        return false;
    }
}

package P11_06;
//동전 뒤집기
public class P3 {
    public static void main(String[] args) {
        int[][] beginning = new int[][]{
                {0,1,0,0,0}, {1,0,1,0,1}, {0,1,1,1,0}, {1,0,1,1,0}, {0,1,0,1,0}
        };

        int[][] target = new int[][]{
                {0,0,0,1,1}, {0,0,0,0,1}, {0,0,1,0,1}, {0,0,0,1,0}, {0,0,0,0,1}
        };

        int m = beginning.length;;
        int n = beginning[0].length;
        // beginning과 target에서 다른 부분을 추출 (직사각형 모양) 뒤집힐 필요가 없는 부분은0, 뒤집어야 하는 부분은 1
        int[][] dif = new int[m][n];

        int[] sum1 = new int[m]; //행
        int[] sum2 = new int[n]; //열

        for(int i = 0; i<m; i++){
            for(int j = 0; j< n; j++){
                if(beginning[i][j] != target[i][j]) {
                    dif[i][j] = 1;
                    sum1[i] += 1;
                    sum2[j] += 1;
                }
            }
        }

        //dif 배열의 요소가 전부 0이 될때까지 반복
        //변경해야 하는 요소가 가장 많은 행/열을 먼저 뒤집기




    }

}

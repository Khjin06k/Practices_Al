package P11_06;
//삼각형 달팽이
//아래>>오른쪽>>대각선

import java.util.Scanner;

public class P2 {
    public static boolean isValid(int row, int col, int M) {
        return (row >= 0 && col >= 0 && row < M && col < M);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt(); //삼각형 한 변의 길이

        int[][] result = new int[m][m]; //결과 저장할 배열

        int[] down = new int[]{1,0}; //아래로 이동
        int[] right = new int[]{0,1}; //오른쪽 이동
        int[] up = new int[]{-1,-1}; //위로 이동 (삼각형이므로 위로 이동하면서 왼쪽으로 이동
        int[][] moves = new int[][]{ //삼각형을 움직이는 방향
                down, right, up
        };

        int count = 1 /*입력할 숫자*/, cnt = 0 /*매트릭스 내의 삼각형 넓이 만큼만 움직여야 함*/, row = -1, col = 0, dir=0;
        while(cnt < m*(m+1)/2){
            int[] move = moves[dir];
            row = row+move[0];
            col = col+move[1];
            while(isValid(row, col, m) && result[row][col] == 0){//범위를 벗어나지 않아야 함 + 한바퀴를 다 돌았을 때 값이 들어가지 않은 경우 인덱스 변동 필요
//            while(row >= 0 && row < m && col >= 0 && col < n){//범위를 벗어나지 않아야 함
                result[row][col] = count;
                row = row+move[0];
                col = col+move[1];
                count++;
                cnt++;
            }
            //범위를 벗어나면 방향 변경 필요
            row = row - move[0];
            col = col - move[1];
            dir = (dir+1)%3; // 각 방향 순환, 순환을 위해 +1한 것을 %3함
        }

        for(int i = 0; i<m; i++){
            for(int j = 0; j<m; j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.println("");
        }
    }
}

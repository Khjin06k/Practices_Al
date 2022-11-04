package P11_06;
import java.util.*;

//사각형 달팽이
public class P1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt(); //사각형 세로 길이
        int n = sc.nextInt(); //사격형 가로 길이

        int[][] result = new int[m][n]; //결과 저장할 배열

        int[] right = new int[]{0,1}; //오른쪽 이동
        int[] down = new int[]{1,0}; //아래로 이동
        int[] left = new int[]{0,-1}; //왼쪽으로 이동
        int[] up = new int[]{-1,0}; //위로 이동
        int[][] moves = new int[][]{ //사각형을 움직이는 방향
                right, down, left, up
        };

        int count = 1 /*입력할 숫자*/, cnt = 0 /*매트릭스 내의 넓이만큼만 움직여야 함*/, row = 0, col = -1, dir=0;
        while(cnt < m*n){
            int[] move = moves[dir];
            row = row+move[0];
            col = col+move[1];
            while((row >= 0 && row < m && col >= 0 && col < n) && (result[row][col] != 0)){//범위를 벗어나지 않아야 함
                result[row][col] = count;
                row = row+move[0];
                col = col+move[1];
                count++;
                cnt++;
            }
            //범위를 벗어나면 방향 변경 필요
            row = row - move[0];
            col = col - move[1];
            dir = (dir+1)%4; // 각 방향 순환, 순환을 위해 +1한 것을 %4함
        }

        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.println("");
        }

    }
}


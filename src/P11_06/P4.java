package P11_06;
import java.util.*;

//등대 (프로그래머스)
//열결되어 있는 그래프들을 보고 가장 적게 등대를 켤 수 있는 방법을 찾아라
// 등대의 개수 n개 / 연결된 뱃길을 나타내는 이차원 배열이 주어짐.
// 인접 행렬 또는 리스트를 통해 등대의 연결 관계를 정리하고 모든 등대에 연결되는 경우를 뽑아서 갯수를 판별하기

public class P4 {
    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
        int n = 8; //등대의 개수
        int[][] lighthouse = new int[][]{{1,2}, {1,3}, {1,4}, {1,5}, {5,6}, {5,7}, {5,8}}; //등대 연결 관련 배열

        int[][] array = new int[n+1][n+1]; //0,0에는 저장하지 않아 배열의 크기를 1씩 키움
        for(int i = 0; i<lighthouse.length; i++){ //lighthouse 내의 요소를 가지고 인접 배열 나타내기
            int a = lighthouse[i][0];
            int b = lighthouse[i][1];
            array[a][b] = 1;
            array[b][a] = 1;
        } //열결되어 있는 경우 1, 그렇지 않는 경우는 디폴트로0의 값을 가짐

        int[][] ch = new int[n+1][2];
        for(int i = 1; i<=n; i++){
            int sum = 0;
            for(int j = 1; j<=n; j++){
                sum += array[i][j];
            }
            ch[i][0] = sum; // 연결된 등대 수
            ch[i][1] = i; //인덱스
        }

        //첫번째 인덱스를 기준으로 정렬하기
        Arrays.sort(ch, Comparator.comparingInt((int[] o) -> o[0]));

        int count = 0;
        int i = 0;
        boolean[] check = new boolean[n+1]; //모든 등대가 포함되었는지 확인하기 위함
        while(true){
            count++;
            i++;
            for(int j = 1; j<=n; j++){
                if(array[ch[i][1]][j] == 1) {
                    check[ch[i][1]] = true;
                }
            }
            if(!visit(check)) continue;
            else break;
        }
        System.out.println(count);
    }
    public static boolean visit(boolean[] check){
        for(int i = 1; i<check.length; i++){
            if(!check[i]){ //false를 만날 경우 등대 추가가 필요
                return false;
            }
        }
        return true;
    }
}
//연결된 등대가 많은 등대를 뽑을수록 불이 켜지는 등대 수가 줄어둚
//Map을 이용해 key는 인덱스, value는 값으로 하여 value가 큰 값의 key를 가지고 array에서 등대 방문 여부를 확인하기
        /*HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 1; i<=n; i++){
            int sum = 0;
            for(int j = 1; j<=n; j++){
                sum += array[i][j];
            }
            map.put(i, sum);
        }
        List<Integer> valueList = new ArrayList<>(map.values()); //HashMap의 value값을 기준으로 정렬하기
        valueList.sort(Integer::compareTo);*/
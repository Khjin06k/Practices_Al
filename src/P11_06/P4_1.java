package P11_06;
import java.util.*;

//등대 (프로그래머스)
//열결되어 있는 그래프들을 보고 가장 적게 등대를 켤 수 있는 방법을 찾아라
// 등대의 개수 n개 / 연결된 뱃길을 나타내는 이차원 배열이 주어짐.
// 인접 행렬 또는 리스트를 통해 등대의 연결 관계를 정리하고 모든 등대에 연결되는 경우를 뽑아서 갯수를 판별하기

public class P4_1 {
    public static void main(String[] args) {
       int n = 10;
        int[][] lighthouse = new int[][]{{4,1}, {5,1}, {5,6}, {7,6}, {1,2}, {1,3}, {6,8}, {2,9}, {9,10}};

        int[][] array = new int[n + 1][n + 1]; //0,0에는 저장하지 않아 배열의 크기를 1씩 키움
        for (int i = 0; i < lighthouse.length; i++) { //lighthouse 내의 요소를 가지고 인접 배열 나타내기
            int a = lighthouse[i][0];
            int b = lighthouse[i][1];
            array[a][b] = 1;
            array[b][a] = 1;
        } //열결되어 있는 경우 1, 그렇지 않는 경우는 디폴트로0의 값을 가짐

        int[][] ch = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= n; j++) {
                sum += array[i][j]; //i번 등대에 연결된 등대의 수를 알 수 있음
            }
            ch[i][0] = sum; // 연결된 등대 수
            ch[i][1] = i; //인덱스
        }

        //첫번째 인덱스를 기준으로 정렬하기 >> sum이 큰것부터 내림차순 정렬 (마지막 요소는 0,0이기 때문에 따로 출력할 필요x)
        Arrays.sort(ch, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });

        /*for (int i = 0; i < n; i++) { //정렬 확인 출력문
            System.out.print(ch[i][0]);
            System.out.println(ch[i][1]);
        }*/

        int count = 0; //켜져야 하는 등대 개수
        int i = 0;
        boolean[] check = new boolean[n+1]; //모든 등대가 포함되었는지 확인하기 위함
        ArrayList<Integer> list = new ArrayList<Integer>(); //불이 켜진 등대 인덱스
        check[0] = true; //혹시 모르니 디폴트값 true로 변경
        while(true){
            if(list.size() == 0){
                list.add(ch[i][1]);
                count++;
                i++;
            }
            if(!istrue(list, array, n, ch[i][1])){
                check[ch[i][1]] = true;
                for(int j = 1; j<=n; j++){
                    if(array[ch[i][1]][j] == 1) { //1로 연결되어 있다면 방문 여부 체크 (count ++)
                        check[j] = true;
                    }
                }
                list.add(ch[i][1]); //불켜진 등대 추가
                count++;
                i++;
            } else{
                i++;
            }

            if(visit(check)||i>=ch.length) break;
        }
        System.out.println(count-1);
        for(int j = 0; j<list.size(); j++){
            System.out.println(list.get(j));
        }
    }
    public static boolean visit(boolean[] check){ //모든 등대가 연결되어 있는지 확인 후 반환
        for(int i = 1; i<check.length; i++){
            if(!check[i]){ //만약 false를 만날 경우 등대 추가 연결이 필요
                return false;
            }
        }
        return true;
    }

    public static boolean istrue(ArrayList<Integer> list, int[][] array, int n, int m){ //모든 등대가 연결되어 있는지 확인 후 반환
        for(int j = 1; j<=n; j++){
            if(array[m][j] == 1 && list.contains(j)) { //1이면서 list에 j가 존재한다면 켜진 등대와 연결되어 있으므로 true 리턴
                return true;
            }
        }
        return false; //모든 등대가 1이면서 true라면 패스
    }
}
// 조건이 하나 더 필요함.
// (array[ch[i][1]][j] == 1에서 방문 여부를 체크할 경우 array 배열의 ch[i][1] 인덱스를 연결할 때,
// 이미 해당 인덱스에 해당하는 모든 배열이 연결이 되어있다면 해당 등대는 불을 켤 필요가 없으므로 해당 등대는 넘어간다.
/*
boolean[] check = new boolean[n+1]; //모든 등대가 포함되었는지 확인하기 위함
        while(true){
        //해당 인덱스에 해당하는 모든 등대가 연결이 되어 있는지 확인하기
        if(for(int j = 1; j<=n; j++){
                if(array[ch[i][1]][j] == 1 && check[j] == true) { //1로 연결되어 있다면 방문 여부 체크 (count ++)
                    check[j] = true;
                }
            }

            for(int j = 1; j<=n; j++){
                if(array[ch[i][1]][j] == 1) { //1로 연결되어 있다면 방문 여부 체크 (count ++)
                    check[j] = true;
                }
            }
            i++;
            count++;
            if(visit(check)) break;
        }
*/
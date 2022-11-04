package P11_06;
import java.util.*;

//혼자 놀기의 달인(프로그래머스)

public class P6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt(); //입력받을 카드 수
        int[] cards = new int[num+1];
        for(int i = 1; i<=num; i++){ //카드 입력받기 (카드 번호사 순서대로 담긴 배열 (헷갈리지 않도록 인덱스 1부터 입력받기)
            cards[i] = sc.nextInt();
        }

        boolean[] check = new boolean[num+1]; //방문했는지 여부 체크하기 (디폴트값 false)
        ArrayList<Integer> group1 = new ArrayList<>(); //그룹1 의 숫자들
        ArrayList<Integer> group2 = new ArrayList<>(); //그룹2 의 숫자들

        int start = 1;
        int result = 1;
        while(true){
            if(!check[start]) { //방문한 적이 없다면
                check[start] = true;
                int ch = cards[start];
                group1.add(ch);
                start = ch;
            } else break; //방문한 적이 있다면 group1은 끝
        }
        for(int i = 1; i<num+1; i++){
            if(!check[i]) {//방문하지 않은 곳부터 다시 시작하기 위해 시작점을 찾음
                start = i;
                break;
            } else{ //group1에 모든 숫자가 들어있다면 점수는 0점
                result = 0;
            }
        }
        while(true){
            if(!check[start]) { //방문한 적이 없다면
                check[start] = true;
                int ch = cards[start];
                group2.add(ch);
                start = ch;
            } else break; //방문한 적이 있다면 group2은 끝
        }
        result =group1.size()* group2.size();
        System.out.println(result);

    }
}

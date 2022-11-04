package P11_06;
import java.util.*;
//택배상자(프로그래머스)
//스택을 이용해야 함
public class P5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //기본 컨테이너는 순서대로 상자가 놓여있음
        int[] cont1 = new int[]{1,2,3,4,5};
        //보조 컨테이너
        Stack<Integer> cont2 = new Stack<>();

        //원하는 순서를 작성받음
        int[] order = new int[5];
        for(int i = 0; i<5; i++){
            order[i] = sc.nextInt();
        }

        // 실을 수 있는 택배 상자 개수 count; // order의 인덱스 관리 //
        int i = 0, j = 0, t=1;
        while(true){
            if(!cont2.isEmpty() && order[i] == cont2.peek()){ // 스택이 비어있지 않으면서 order와 동일할 경우 짐을 실을 수 있음을 의미
                i++;
                j++;
                cont2.pop();

                continue;
            }

            if(t>order.length) break; // 더이상 비교할 것이 없다면 break;

            if(order[i] == t){
                cont2.add(cont2.pop());
                i++;
                j++;
                t++;

                continue;
            }

            cont2.push(t);
            t++;
        }

        System.out.println(i);


    }
}

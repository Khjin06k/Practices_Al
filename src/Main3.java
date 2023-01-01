import java.util.*;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        int a = 0;
        int b = 0;
        int c = 0;

        for(a = 0; a<10; a++){
            for(b = 0; b<10; b++){
                for(c = 0; c<10; c++){
                    if(a*101+b*11+2*c == num){
                        break;
                    }
                }
                if(a*101+b*11+2*c == num){
                    break;
                }
            }
            if(a*101+b*11+2*c == num){
                break;
            }
        }

       /*
       생성자가 존재하지 않는 경우 해결 필요
       if(a == 10 && b == 10 && c == 10){ //생성자가 존재하지 않는 경우
            System.out.println(0);
        }else {
            System.out.println(a * 100 + b * 10 + c);
        }*/
    }
}

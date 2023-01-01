/*public class Main {
    public static void main(String[] args) {
        int[][] data = {
                        { 0 , 0 , 0 , 0 , 1 , 0 , 0 , 0 },
                        { 0 , 1 , 1 , 0 , 1 , 0 , 1 , 1 },
                        { 0 , 0 , 1 , 0 , 0 , 0 , 0 , 0 },
                        { 1 , 0 , 1 , 1 , 1 , 1 , 1 , 1 },
                        { 0 , 0 , 0 , 0 , 0 , 0 , 0 , 1 },
                        { 1 , 0 , 1 , 1 , 1 , 1 , 0 , 1 },
                        { 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 },
                        { 0 , 1 , 1 , 1 , 0 , 1 , 1 , 1 },
                        { 0 , 0 , 0 , 0 , 0 , 0 , 0 , 2 }
        };
        //(0,0)에서 시작
        data = Set(data, 0, 0);
        System.out.println(data);
    }

    //클래스 따로 생성
    /* 조건
    1) 0은 길 / 1은 벽
    2) (0,0)에서 시작하여 2를 도달할해야 함 (이동 가능한 경로를 0에서 8로 변경함)
    3) 위/아래/왼쪽/오른쪽으로 이동이 가능하며, 배열을 벗어나면 안됨
    4) 길을 가다가 1을 만나 더이상 이동이 불가능한 경우 되돌아와야 하며, 방문한 적이 있는지 여부를 체크하는 배열을 통해 방문한 적이 없는 곳으로 돌아와야 함.
     >> 처음 길을 확인할 때 경로를 0에서 8로 변경할 경우 길이 아닐 경우 다시 0으로 바꾸는 과정이 필요함
     >> 재귀함수로 타고 들어가서 맞을 경우 밖으로 나오면서 8로 변경하는 과정으로 변경 필요
     */
    // 2를 만나는 경우까지 도달하거나, 경로를 더이상 찾을수 없을때까지 반복 진행
    /*public static int[][] Find(int[][] data, int startx, int starty){

        return data;
    }*/
    //미로찾기 진행
    /*public static int[][] Set(int[][] data, int startx, int starty){
        //방문 여부 확인 배열 생성 >> 방문한 경우 true 표시 (기본적으로 boolean 배열은 false이므로 방문했을 경우 true로 변경해줌)
        boolean[][] visited = new boolean[data.length][data.length];

        data[startx][starty] = 8;
        visited[startx][starty] = true;

        //위로 이동
        data = Set(data, startx--, starty);

        /*while(data[startx][starty] != 2){ //미로에서 2를 찾을 경우 종료
            //위/아래/왼쪽/오른쪽 이동을 할지 여부 결정 (0일 경우 이동, 1일 경우 다른 경로 탐색)

            if()
            {
            }

            //1) 위로 이동
            if()
            {
            }
            startx--;
            //경로를 벗어난 경우
            if(startx<0) startx+=1;

            //경로를 벗어나지 않았으면서 길이 있는 경우 이동 (단, 방문한 적이 없어야 함)
            else if(data[startx][starty] == 0 && visited[startx][starty] == false){
                //방문 여부와
                visited[startx][starty] = true;
                data = Set(data);
            }

            //2) 아래로 이동
            startx++;
            //경로를 벗어난 경우
            if(startx>data.length-1) startx-=1;



            //3) 오른쪽으로 이동
            starty++;
            //경로를 벗어난 경우
            if(starty > data.length-1) starty-=1;

            //4) 왼쪽으로 이동
            starty--;
            //경로를 벗어난 경우 되돌아옴
            if(starty<0) starty+=1;

        }



        Set(data, startx, starty);
    }


}*/
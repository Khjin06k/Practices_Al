public class Main2 {
    public static void main(String[] args) {
        int[][] room = new int[][]{
                {0, 0, 0, 0, 0, 0},
                {0, 1, 1, 0, 1, 0},
                {0, 1, 0, 0, 0, 0},
                {0, 0, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 0}
        };
        int[] src = new int[]{4, 2}; // y좌표, x좌표 순서
        int[] dst = new int[]{2, 2}; // y좌표, x좌표 순서
        int output = robotPath(room, src, dst);
        System.out.println(output);
    }

    public static int robotPath(int[][] room, int[] src, int[] dst) {
        // TODO : src에서 dst로 가는 최소 시간 리턴
        // 최소 시간 >> BFS?
        //int count = 1; //각 인덱스 위치의 최소 시간
        int a = room.length;
        int b = room[0].length;
        room = move(a, b,1, src, room);
        return room[dst[0]][dst[1]]-1;
    }

    //배열을 이동하면서 해당 배열로 이동할 때의 최소 시간을 배열에 넣어서 최종적으로 최소 시간을 리턴함
    public static int[][] move(int a, int b, int count, int[] src, int[][] room){

        //시작지점
        int x = src[0];
        int y = src[1];

        //상하좌우 움직이면서 범위를 하나라도 벗어나는 경우는 그대로 유지 >> 최소시간 변동 없음
        if(x < 0 || x >= a || y < 0 || y >= b) return room; //해당되면 return >> break

        //벗어난 경우는 위에서 걸러졌으므로 범위를 벗어나지 않은 경우만 존재함
        if(room[x][y] >= count || room[x][y] == 0){ //방문하지 않은 경우 room[x][y] == 0, 현재 최소시간보다 큰 경우 최소시간 변경 필요
            room[x][y] = count;
            //조건에 맞도록 BFS 적용 필요
            //전체적으로 StackOverflow 발생 >>
            move(a, b,count+1, new int[]{x+1, y}, room); //위로 이동
            move(a, b,count+1, new int[]{x, y+1}, room); //왼쪽으로 이동
            move(a, b,count+1, new int[]{x-1, y}, room); //아래로 이동
            move(a, b, count+1, new int[]{x, y-1}, room); //오른쪽으로 이동
        }
        return room;

    }
}

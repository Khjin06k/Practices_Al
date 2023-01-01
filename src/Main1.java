/*import java.util.Random;
import java.util.Scanner;

class LinkedList
{
    Block header=null;

    void add(int x, int y)
    {
        Block block=new Block(0,"X",0,0);

        block.x=x;
        block.y=y;
        block.next=header;
        header=block;
    }

    void back()
    {
        header=header.next;
    }

    void print()
    {
        Block block=header;
        while(block!=null)
        {
            System.out.println("x:"+block.x+"  y:"+block.y);


            block=block.next;
        }
    }

}

class Player
{
    int x=0;
    int y=0;

    int find(Block[][] block)
    {
        int way = 0;

        block[y][x].str="X";

        boolean check=false;

        if(x<block[0].length-1 && block[y][x+1].num!=1 && !block[y][x+1].str.equals("X")) //동쪽
        {
            check=true;
            way=1;
        }
        else if(x>0 && block[y][x-1].num!=1 && !block[y][x-1].str.equals("X")) // 서쪽
        {
            check=true;
            way=2;
        }

        else if(y<block.length-1 && block[y+1][x].num!=1 && !block[y+1][x].str.equals("X")) //남쪽
        {
            check=true;
            way=3;
        }

        else if(y>0 && block[y-1][x].num!=1 && !block[y-1][x].str.equals("X")) //북쪽
        {
            check=true;
            way=4;
        }

        if(!check)
        {
            way=5;
        }

        return way;
    }

    void move(Block[][] block, int way)
    {
        if(way==1)
        {
            x=x+1;
        }
        else if(way==2)
        {
            x=x-1;
        }
        else if(way==3)
        {
            y=y+1;
        }
        else if(way==4)
        {
            y=y-1;
        }
    }
}


class Block
{
    Block next;
    int num;
    String str;
    int x;
    int y;

    Block(int num, String str, int x, int y)
    {
        this.num=num;
        this.str=str;
        this.x=x;
        this.y=y;
    }
}

public class Main extends Thread
{
    Scanner sc = new Scanner(System.in);
    Random r=new Random(System.currentTimeMillis());

    Main()
    {
        int[][] data =
                {
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

        Player p=null;
        p=new Player();

        Block[][] block;
        block=new Block[data.length][data[0].length];

        for(int i=0;i<block.length;i=i+1)
        {
            for(int j=0;j<block[i].length;j++)
            {
                block[i][j]=new Block(data[i][j],".",j,i);
            }
        }

        LinkedList list=null;
        list=new LinkedList();

        list.add(0, 0);

        int way=0;
        while(true)
        {
            try
            {
                Thread.sleep(1000);
            }
            catch(Exception e) {}

            map(block, data, p);
            way = p.find(block);
            if(way==5)
            {
                list.back();
                p.x=list.header.x;
                p.y=list.header.y;
            }
            else
            {
                p.move(block, way);

                list.add(p.x, p.y);
            }

            if(block[p.y][p.x].num==2)
                break;
        }
    }


    void map(Block[][] block, int[][] data, Player p)
    {
        for(int i=0;i<block.length;i=i+1)
        {
            for(int j=0;j<block[i].length;j=j+1)
            {
                if(p.x==j && p.y==i)
                {
                    System.out.print(8+" ");
                }
                else
                {
                    System.out.print(block[i][j].num+" ");
                }
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        new Main();
    }
}*/
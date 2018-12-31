package Creature;

import BattleField.Existance;
import BattleField.Space;
import Record.Record;
import UI.SScreen;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * @ Author     ：cjh
 * @ Description：葫芦娃
 */

public class CalabashBrothers extends Creature implements Runnable{
    private Thread t;

    String color;// 葫芦娃的颜色
    int rank;// 葫芦娃中的排行
    Image image;

    CalabashBrothers(int i,int m,int n)
    {
        init(m,n);
        this.color = CalabashEnum.values()[i].getColor();
        this.name =CalabashEnum.values()[i].getName();
        this.rank = CalabashEnum.values()[i].getRank();
        ListCalabash.add(this);
        String url=null;
        java.io.File file = new java.io.File("resource\\"+rank+".png");
        url = file.toURI().toString();

        image = new Image(url);
        standOnMap(m,n);
        this.start();
    }
    @Override
    public void draw(GraphicsContext gc) {

        gc.drawImage(image,column*80,row*80,80,80);
    }
    @Override
    public void standOnMap(int i,int j)
    {
        row=i;
        column=j;
        switch(rank)
        {
            case 1:
                Space.space[(int)i][(int)j]= Existance.bigbrother;
                break;
            case 2:
                Space.space[(int)i][(int)j]=Existance.secondbrother;
                break;
            case 3:
                Space.space[(int)i][(int)j]=Existance.thirdbrother;
                break;
            case 4:
                Space.space[(int)i][(int)j]=Existance.fourthbrother;
                break;
            case 5:
                Space.space[(int)i][(int)j]=Existance.fifthbrother;
                break;
            case 6:
                Space.space[(int)i][(int)j]=Existance.sixthbrother;
                break;
            case 7:
                Space.space[(int)i][(int)j]=Existance.seventhbrother;
                break;
        }
    }

    public static void swapPosition(CalabashBrothers[] brothers,int i,int j)/**两个葫芦娃交换位置*/
    {
        CalabashBrothers temp;
        temp=brothers[i];
        brothers[i]=brothers[j];
        brothers[j]=temp;
    }

    public void reportColor()/**报颜色*/
    {
        System.out.print(color+"  ");
    }
    public void reportSwap(int i,int j)/**报位置改变*/
    {
        System.out.println(name + ":" + i + "->" + j);
    }
    public static CalabashBrothers[] birth()/**葫芦娃出生（随机顺序）*/
    {
        CalabashBrothers[] brothers=new CalabashBrothers[7];
        for(int i=0;i<7;i++)
        {
            brothers[i]=new CalabashBrothers(i,i,3);
        }
        /*
        for(int i=0;i<7;i++)
        {
            int num1 = (int) (Math.random() * 7);
            int num2 = (int) (Math.random() * 7);
            CalabashBrothers.swapPosition(brothers,num1,num2);
        }*/
        return brothers;
    }
    public static void main(String[] args)/**程序测试入口*/
    {
        // 让葫芦娃随便站队
        CalabashBrothers[] brothers=CalabashBrothers.birth();
        // 冒泡法以姓名排序
        System.out.println("排序中报告位置改变:");
        CalabashBrothersSort.sortByName(brothers);
        System.out.println("排序后按姓名报数：");
        for(CalabashBrothers s:brothers)
            s.reportName();

        // 再次让葫芦娃打乱位置
        brothers=CalabashBrothers.birth();
        /*
        for(int i=0;i<7;i++) {
            int num1 = (int) (Math.random() * 7);
            int num2 = (int) (Math.random() * 7);
            CalabashBrothers.swapPosition(brothers,num1,num2);
        }*/
        System.out.println();
        System.out.println("再次随机后位置：");
        for(CalabashBrothers s:brothers)
            s.reportName();
        System.out.println();
        // 二分法以颜色排序
        System.out.println("排序中报告位置改变:");
        CalabashBrothersSort.sortByColor(brothers);
        System.out.println("排序后按颜色报数：");
        for(CalabashBrothers s:brothers)
            s.reportColor();
    }
    public void run() {
        try {

            while (SScreen.getmGameState()!= SScreen.GameState.GAME_END&&Creature.ListCalabash.contains(this)) {
                if(SScreen.getmGameState()!=SScreen.GameState.GAME_PAUSE) {
                    int oldCol=column;
                    int oldRow=row;
                    int temp = (int) (Math.random() * 4);
                    switch (temp) {
                        case 0:
                            //left
                            if (column == 0 && row == 0) {
                                temp = (int) (Math.random() * 2);
                                switch (temp) {
                                    case 0:
                                        column += 1;
                                        break;
                                    case 1:
                                        row += 1;
                                        break;
                                }
                            } else if (column == 0 && row == 7) {
                                temp = (int) (Math.random() * 2);
                                switch (temp) {
                                    case 0:
                                        column += 1;
                                        break;
                                    case 1:
                                        row -= 1;
                                        break;
                                }
                            } else if (column == 0) {
                                temp = (int) (Math.random() * 3);
                                switch (temp) {
                                    case 0:
                                        column += 1;
                                        break;
                                    case 1:
                                        row += 1;
                                        break;
                                    case 2:
                                        row -= 1;
                                        break;
                                }
                            } else {

                                column -= 1;

                            }
                            break;
                        case 1:
                            //down
                            if (row == 7 && column == 0) {
                                temp = (int) (Math.random() * 2);
                                switch (temp) {
                                    case 0:
                                        column += 1;
                                        break;
                                    case 1:
                                        row -= 1;
                                        break;
                                }
                            } else if (row == 7 && column == 11) {
                                temp = (int) (Math.random() * 2);
                                switch (temp) {
                                    case 0:
                                        row -= 1;
                                        break;
                                    case 1:
                                        column -= 1;
                                        break;
                                }
                            } else if (row == 7) {
                                temp = (int) (Math.random() * 3);
                                switch (temp) {
                                    case 0:
                                        row -= 1;
                                        break;
                                    case 1:
                                        column += 1;
                                        break;
                                    case 2:
                                        column -= 1;
                                        break;

                                }
                            }else{
                            row += 1;}
                            break;
                        case 2:
                            //up
                            if (row == 0 && column == 0) {
                                temp = (int) (Math.random() * 2);
                                switch (temp) {
                                    case 0:
                                        column += 1;
                                        break;
                                    case 1:
                                        row += 1;
                                        break;
                                }
                            } else if (row == 0 && column == 11) {
                                temp = (int) (Math.random() * 2);
                                switch (temp) {
                                    case 0:
                                        column -= 1;
                                        break;
                                    case 1:
                                        row += 1;
                                        break;
                                }
                            } else if (row == 0) {
                                temp = (int) (Math.random() * 3);
                                switch (temp) {
                                    case 0:
                                        row += 1;
                                        break;
                                    case 1:
                                        column += 1;
                                        break;
                                    case 2:
                                        column -= 1;
                                        break;

                                }
                            } else {
                                row -= 1;
                            }
                            break;
                        case 3:
                            //right
                            if (column == 11 && row == 0) {
                                temp = (int) (Math.random() * 2);
                                switch (temp) {
                                    case 0:
                                        column -= 1;
                                        break;
                                    case 1:
                                        row += 1;
                                        break;
                                }
                            } else if (column == 11 && row == 7) {
                                temp = (int) (Math.random() * 2);
                                switch (temp) {
                                    case 0:
                                        column -= 1;
                                        break;
                                    case 1:
                                        row -= 1;
                                        break;
                                }
                            } else if (column == 11) {
                                temp = (int) (Math.random() * 3);
                                switch (temp) {
                                    case 0:
                                        column -= 1;
                                        break;
                                    case 1:
                                        row += 1;
                                        break;
                                    case 2:
                                        row -= 1;
                                        break;

                                }
                            } else {
                                column += 1;
                            }
                            break;
                    }

                    for(int i=0;i<ListCalabash.indexOf(this);i++)
                    {
                        if(ListCalabash.get(i).row==this.row&&ListCalabash.get(i).column==this.column)
                        {
                            row=oldRow;
                            column=oldCol;
                        }
                    }
                    //Record r=new Record(rank,row,column);
                    //Record.records.add(r);
                }

                //System.out.println(column+" "+row);

                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        if (t == null) {
            t = new Thread (this);
            t.start ();
        }
    }
    @Deprecated
    public void close()
    {
        if(t!=null)
        {
            t.stop();
        }
    }
}


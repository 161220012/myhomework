package Creature;

import BattleField.*;
import Record.Record;
import UI.SScreen;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * @ Author     ：cjh
 * @ Description：小喽啰
 */
public class Underlings extends Creature implements Runnable{/**创建人：陈剑豪 创建时间：2018.10.2*/
    private Thread t;
    static int number=0;
    Image image;
    public Underlings(int i,int j)
    {
        init(i,j);
        name="喽啰";
        number++;
        ListMonster.add(this);
        String url=null;
        java.io.File file = new java.io.File("resource\\1s.jpg");
        url = file.toURI().toString();
        image = new Image(url);
        standOnMap(i,j);
        this.start();
    }
    public static void Number()
    {
        System.out.println(number);
    }// 统计小喽啰的数量
    @Override
    public void standOnMap(int i,int j)
    {
        Space.space[(int)i][(int)j]=Existance.underlings;

    }
    @Override
    public void draw(GraphicsContext gc) {
        gc.drawImage(image,column*80,row*80,80,80);
    }

    public void run() {
        try {
            while (SScreen.getmGameState()!= SScreen.GameState.GAME_END&&Creature.ListMonster.contains(this)) {
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
                            }
                            else{
                            row += 1;
                            }
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
                    for(int i=0;i<ListMonster.indexOf(this);i++)
                    {
                        if(ListMonster.get(i).row==this.row&&ListMonster.get(i).column==this.column)
                        {
                            row=oldRow;
                            column=oldCol;
                        }
                    }
                }
                //System.out.println(column+" "+row);
                //Record r=new Record(ListMonster.indexOf(this)+8,row,column);
                //Record.records.add(r);
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

}

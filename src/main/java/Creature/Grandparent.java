package Creature;

import BattleField.*;
import Record.Record;
import UI.CountDown;
import UI.SScreen;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import java.io.File;

/**
 * @ Author     ：cjh
 * @ Description：爷爷
 */
public class Grandparent extends Creature implements Runnable{/**创建人：陈剑豪 创建时间：2018.10.2*/
    private Thread t;
    Image image;
public Grandparent(int i,int j)
{
    init(i,j);
    standOnMap(i,j);
    name="爷爷";
    ListCalabash.add(this);
    String url=null;
    java.io.File file = new java.io.File("classes"+File.separator+"yeye.png");
    url = file.toURI().toString();

    image = new Image(url);

    this.start();
}
    @Override
    public void standOnMap(int i,int j)
    {
        Space.space[i][j]=Existance.grandparent;

    }
    public void cheer()
    {

    }
    @Override
    public void draw(GraphicsContext gc) {

        gc.drawImage(image,column*80,row*80,80,80);
    }
    @Override
    public void update() {

    }

    public void run() {

        try {
            while (SScreen.getmGameState()!= SScreen.GameState.GAME_END&&Creature.ListCalabash.contains(this)) {
                if(SScreen.getmGameState()!=SScreen.GameState.GAME_PAUSE) {
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
                            else {
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
                    Record r=new Record(0,row,column);
                    Record.records.add(r);
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
    public void stop()
    {
        if(t!=null)
        {
            t.stop();
        }
    }

}

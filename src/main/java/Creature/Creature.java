package Creature;

import java.util.*;
import UI.SObject;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.concurrent.atomic.AtomicInteger;
/**
 * @ Author     ：cjh
 * @ Description：生物基类
 */
public class Creature extends SObject{
    boolean Battle;
    protected int row;//生物在地图上的纵坐标
    protected int column;//生物在地图上的横坐标
    protected String name;//生物的名字
    public void reportName(){System.out.print(name+"  ");}//生物报自己的名字
    public void standOnMap(int i,int j){}//生物站上地图
    public void init(int i,int j){row=i;column=j;}//生物坐标初始化

    public static LinkedList<Creature> ListCalabash=new LinkedList<Creature>();
    public static LinkedList<Creature> ListMonster=new LinkedList<Creature>();
    @Override
    public void draw(GraphicsContext gc) {
    }
    @Override
    public void update() {

    }

    public int detect()
    {

            for(int i=0;i<ListMonster.size();i++)
            {
                if(ListMonster.get(i).row==this.row&&Math.abs(this.column-ListMonster.get(i).column)==1)
                {
                    return i;
                    //this.BattleWith(ListMonster.get(i));
                } else if (ListMonster.get(i).column==this.column&&Math.abs(this.row-ListMonster.get(i).row)==1)
                {
                    return i;
                    //this.BattleWith(ListMonster.get(i));
                }
                else if(ListMonster.get(i).row==this.row&&ListMonster.get(i).column==this.column)
                {
                    return i;
                }
            }
            return -1;

    }
    public boolean BattleWith(Creature B)
    {
        this.Battle=true;
        B.Battle=true;
        int temp=(int)(Math.random()*2);
        if(temp==0)//A胜
        {
            this.Battle=false;
            return false;
        }
        else//B胜
        {
            B.Battle=false;

            return true;
        }
    }
    public boolean isBattle()
    {
        return Battle;
    }
}

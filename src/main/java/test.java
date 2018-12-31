import Creature.*;
import BattleField.*;
import Formation.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.text.SimpleDateFormat;

public class test {/**创建人：陈剑豪 创建时间：2018.10.6*/
public static void main(String[] args)
{

    Creature A=new Creature();
    Creature B=new Creature();
    A.BattleWith(B);
    System.out.println(A.isBattle());
    System.out.println(B.isBattle());

    FileWriter fw = null;
    try {
        //如果文件存在，则追加内容；如果文件不存在，则创建文件
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm");
        File f=new File(df.format(new Date())+".txt");
        fw = new FileWriter(f, true);
    } catch (IOException e) {
        e.printStackTrace();
    }
    PrintWriter pw = new PrintWriter(fw);
    pw.println("写文本测试");
    pw.flush();
    try {
        fw.flush();
        pw.close();
        fw.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
    /*
    Space map=new Space(25);
    CalabashBrothers[] brothers=CalabashBrothers.birth();// 初始乱序产生
    CalabashBrothersSort.sortByName(brothers);// 有序排队
    ChangsheBattleArray changshe=new ChangsheBattleArray();
    changshe.form(brothers,6,5);//将葫芦娃排成长蛇阵

    Creature scorpionMonster=new ScorpionMonster();
    Creature[] underlings=new Underlings[10];
    for(int i=0;i<10;i++)
    {
        underlings[i]=new Underlings();
    }
    FangyuanBattleArray fangyuan=new FangyuanBattleArray();
    fangyuan.form(scorpionMonster,underlings,9,12);// 将蝎子和小喽啰排成方円阵

    Grandparent grandparent=new Grandparent();
    map.putOnGrandparent(grandparent,9,2);// 将爷爷放在地图上

    SnakeMonster snakeMonster=new SnakeMonster();
    map.putOnSnakeMonster(snakeMonster,9,18);// 将蛇精放在地图上

    map.display();// 展示地图上站位情况

    map.remove();// 重置地图

    changshe.form(brothers,6,5);//将葫芦娃排成长蛇阵
    ChongeBattleArray chonge=new ChongeBattleArray();
    chonge.form(scorpionMonster,underlings,9,10);// 将蝎子和小喽啰排成衝轭阵
    map.putOnGrandparent(grandparent,9,1);// 将爷爷放进地图中
    map.putOnSnakeMonster(snakeMonster, 9,23);//  将蛇精放进地图中
    map.display();*/
}
}

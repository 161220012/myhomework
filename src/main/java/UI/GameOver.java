package UI;

import Creature.Creature;
import Record.Record;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import java.io.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GameOver extends SObject{

    String string;

    /*
    * 游戏结束前保存rep
    */
    public GameOver(int score1, int score2) {

        if (score1 > score2) {
            string = "葫芦娃阵营胜";
        }
        else if(score1==score2)
        {
            string = "未分胜负";
        }
        else
        {
            string = "妖精阵营胜";
        }
        if(GameScreen.NeworRep==1)
        {
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
        //pw.println(Record.records.size()+" "+Record.records.get(Record.records.size()-1).col);
            int i=0;
            while(!Record.records.isEmpty())
            {
                i++;
                Record temp=Record.records.pop();
                pw.print(i+" "+temp.index+" "+temp.row+" "+temp.col);
                pw.println();
            }
        pw.flush();
        try {
            fw.flush();
            pw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }}



    @Override
    public void draw(GraphicsContext gc) {

        gc.setFill(Color.web("#333", 0.6));
        gc.fillRect(0, 0, SContants.WIDTH, SContants.HEIGHT);

        gc.setFill(Color.web("#ddd"));
        gc.fillRoundRect(300, 180, 350, 240, 20, 20);

        gc.setFont(Font.font(null, FontWeight.BLACK, 40));
        gc.setFill(Color.web("#333"));
        gc.fillText(string, 340, 230);

        gc.setFont(Font.font(null, FontWeight.BLACK, 20));
        gc.fillText("文件已自动保存至游戏所在文" , 350, 280);
        gc.fillText("件夹，录像回放则不再保存！" , 350, 320);

        gc.setFill(Color.web("#80b4ff"));
        gc.fillRoundRect(403, 360, 150, 40, 15, 15);

        gc.setFill(Color.web("#fff"));
        gc.fillText("退出", 460, 386);
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub

    }

}

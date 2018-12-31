package UI;

import Creature.Creature;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
public class Info extends SObject {

    private boolean isLive;
    private CountDown countDown = new CountDown(300);

    public Info() {

        init();
        countDown.start();
    }

    @Override
    public void init() {

        super.init();
    }

    @Override
    public void draw(GraphicsContext gc) {

        gc.setFont(Font.font(null, FontWeight.BLACK, 20));

        gc.setFill(Color.web("#999", 0.5));
        gc.fillRoundRect(SContants.WIDTH-160, 5, 150, 70, 15, 15);
        gc.fillRoundRect(SContants.WIDTH/2 - 80, SContants.HEIGHT - 18, 150, 20, 10, 10);
        gc.setFill(Color.web("#FFFFFF"));
        gc.fillText("我方剩余:" +Creature.ListCalabash.size(), SContants.WIDTH-150, 30);
        gc.fillText("敌方剩余:" +Creature.ListMonster.size(), SContants.WIDTH-150, 60);

        gc.setFont(Font.font(null, FontWeight.BLACK, 12));
        gc.fillText(" 空格键开始/暂停", SContants.WIDTH/2 - 55, SContants.HEIGHT - 4);

        gc.setFont(Font.font(null, FontWeight.BLACK, 40));
        gc.fillText(String.format("%02d", (countDown.getCnt() / 60)) + ":" + String.format("%02d", (countDown.getCnt() % 60)), SContants.WIDTH/2 - 50, 50);

        gc.setFill(Color.web("#80b4ff"));
        gc.fillRoundRect(SContants.WIDTH - 70, SContants.HEIGHT - 20, 90, 40, 10, 10);
        gc.setFill(Color.web("#fff"));
        gc.setFont(Font.font(null, FontWeight.BLACK, 12));
        gc.fillText("点此退出", SContants.WIDTH - 60, SContants.HEIGHT - 4);
    }

    @Override
    public void update() {

    }

    public boolean isLive() {

        return isLive;
    }

    public void setLive(boolean isLive) {

        this.isLive = isLive;
    }


    public int getTimes() {

        return countDown.getCnt();
    }
}


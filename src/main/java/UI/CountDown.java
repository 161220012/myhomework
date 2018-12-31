package UI;
/*
*.@ Author     ：cjh
* @ Description：计时器类
 */

public class CountDown implements Runnable{

    private Thread t;
    private int cnt;


    public CountDown(int times) {

        cnt = times;
    }

    public void run() {

        try {
            while (cnt > 0) {
                if(SScreen.getmGameState()!= SScreen.GameState.GAME_PAUSE)
                cnt--;
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

    public int getCnt() {
        return cnt;
    }
}


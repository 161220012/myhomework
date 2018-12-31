package UI;

import BattleField.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import Creature.*;
import Formation.*;
public class GameScreen extends SScreen
{


    Info info = new Info();

    public GameScreen(double width, double height) {
        super(width, height);
        mGameState=GameState.GAME_PAUSE;
        Space map=new Space(12);
        Creature grandparent=new Grandparent(3,2);
        CalabashBrothers[] brothers=CalabashBrothers.birth();
        Creature scorpion=new ScorpionMonster(3,6);
        Creature snake=new SnakeMonster(3,10);
        Creature underlings[]=new Underlings[6];


        underlings[0]=new Underlings(2,7);
        underlings[1]=new Underlings(1,8);
        underlings[2]=new Underlings(2,9);
        underlings[3]=new Underlings(4,7);
        underlings[4]=new Underlings(5,8);
        underlings[5]=new Underlings(4,9);

        addObject(grandparent);

        addObject(brothers[0]);
        addObject(brothers[1]);
        addObject(brothers[2]);
        addObject(brothers[3]);
        addObject(brothers[4]);
        addObject(brothers[5]);
        addObject(brothers[6]);

        addObject(scorpion);
        addObject(snake);
        addObject(underlings[0]);
        addObject(underlings[1]);
        addObject(underlings[2]);
        addObject(underlings[3]);
        addObject(underlings[4]);
        addObject(underlings[5]);
        //removeObject(underlings[5]);
        //removeObject(Creature.ListMonster.get(7));
        // 信息在最上层
        addObject(info);

        //super.draw(gc);
        /*
        if(NeworRep==1) {
            ((Grandparent) grandparent).start();
            for(int i=0;i<7;i++)
            brothers[i].start();
            ((ScorpionMonster) scorpion).start();
            ((SnakeMonster) snake).start();
            for(int i=0;i<6;i++)
            {
                ((Underlings) underlings[i]).start();
            }
        }*/

    }

    @Override
    public void draw(GraphicsContext gc) {
        super.draw(gc);
        // 暂停
        if (mGameState == GameState.GAME_PAUSE||mGameState==GameState.GAME_END) {
            return;
        }

        if (info.getTimes() == 0||Creature.ListCalabash.size()==0||Creature.ListMonster.size()==0) {
            mGameState = GameState.GAME_END;
            GameOver gameOver = new GameOver(Creature.ListCalabash.size(), Creature.ListMonster.size());
            addObject(gameOver);
        }

    }

    @Override
    public void update() {
        // 暂停

        for(int i=0;i<Creature.ListCalabash.size();i++)
        {
            int index=Creature.ListCalabash.get(i).detect();
            if(index!=-1)
            {
                boolean temp;
                temp=Creature.ListCalabash.get(i).BattleWith(Creature.ListMonster.get(index));
                if(!temp)
                {
                    removeObject(Creature.ListMonster.get(index));
                    Creature.ListMonster.remove(index);
                }
                else
                {
                    removeObject(Creature.ListCalabash.get(i));
                    Creature.ListCalabash.remove(i);
                }
            }

        }
        if (mGameState == GameState.GAME_PAUSE) {
            return;
        }

        // 调用更新操作
        super.update();


    }

    @Override
    public void onKeyReleased(KeyEvent event) {
        // 暂停
        if (event.getCode() == KeyCode.SPACE) {
            if (mGameState == GameState.GAME_PAUSE) {
                mGameState = GameState.GAME_START;
            } else {
                mGameState = GameState.GAME_PAUSE;
            }
        }

    }

    public void setGameState(int i) {

        if (i == 1) {
            mGameState = GameState.GAME_START;
        }
        else if(i==2)
        {
            mGameState = GameState.GAME_PAUSE;
        }
    }
}

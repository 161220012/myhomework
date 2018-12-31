package UI;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*
 *.@ Author     ：cjh
 * @ Description：主页面父类
 */
public abstract class SApplication extends Application {
    private Group mGroup;
    private Scene mScene;

    @Override
    public void start(Stage primaryStage) throws Exception {
        before();
        mGroup = new Group();
        mScene = new Scene(mGroup, SContants.WIDTH, SContants.HEIGHT);
        after();
        showStage(primaryStage);
    }

    protected void before() {

    }

    protected void after() {

    }

    protected void showStage(Stage stage) {
        stage.setScene(mScene);
        stage.show();
    }

    protected Scene getScene() {
        return mScene;
    }

    protected Group getRoot() {
        return mGroup;
    }

    public void setWindowSize(int width, int height) {
        SContants.init(width, height);
    }

}


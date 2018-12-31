package UI;

import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.scene.shape.Line;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import java.io.*;
import javafx.stage.Stage;

/*
 *.@ Author     ：cjh
 * @ Description：程序主入口
 */
public class Main extends SApplication {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    protected void before() {

        setWindowSize(960, 640);

        //music
        String url=null;
        java.io.File file = new java.io.File("resource\\test.mp3");
        url = file.toURI().toString();
        Media media = new Media(url);
        MediaPlayer mplayer = new MediaPlayer(media);
        MediaView mView = new MediaView(mplayer);

        // play music
        mplayer.setAutoPlay(true);
        mplayer.setCycleCount(MediaPlayer.INDEFINITE);
        mplayer.play();
    }

    @Override
    protected void after() {

        String url=null;
        java.io.File file = new java.io.File("resource\\title.png");
        url = file.toURI().toString();

        Image image = new Image(url);
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(450);
        imageView.setFitHeight(200);
        imageView.setLayoutX(250);
        imageView.setLayoutY(100);
        getRoot().getChildren().add(imageView);

        file = new java.io.File("resource\\background.png");
        url = file.toURI().toString();
        image = new Image(url);
        ImageView imageView1 = new ImageView(image);
        imageView1.setFitWidth(960);
        imageView1.setFitHeight(640);
        imageView1.setLayoutX(0);
        imageView1.setLayoutY(0);

        Button button = new Button();
        button.setText("新的游戏");
        button.setLayoutX(SContants.WIDTH / 2 - 80);
        button.setLayoutY(SContants.HEIGHT / 2);
        button.setMinWidth(150);
        button.setMinHeight(70);
        button.setStyle("-fx-font: 24 arial; -fx-font-weight: bold; -fx-text-fill: white; -fx-background-color: #ff4e4e; -fx-background-radius: 20; ");

        Button button1 = new Button();
        button1.setText("读取存档");
        button1.setLayoutX(SContants.WIDTH / 2 - 80);
        button1.setLayoutY(SContants.HEIGHT / 2+100);
        button1.setMinWidth(150);
        button1.setMinHeight(70);
        button1.setStyle("-fx-font: 24 arial; -fx-font-weight: bold; -fx-text-fill: white; -fx-background-color: #ff4e4e; -fx-background-radius: 20; ");

        button.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                getRoot().getChildren().remove(imageView);
                getRoot().getChildren().remove(button);
                getRoot().getChildren().remove(button1);


                getRoot().getChildren().add(imageView1);
                for (int i = 0; i < SContants.WIDTH; i += 80) {
                    Line line = new Line(i, 0, i, SContants.HEIGHT);
                    line.setStroke(Color.web("#500", 0.5));
                    getRoot().getChildren().add(line);
                }
                for (int i = 0; i < SContants.HEIGHT; i += 80) {
                    Line line = new Line(0, i, SContants.WIDTH, i);
                    line.setStroke(Color.web("#500", 0.5));
                    getRoot().getChildren().add(line);
                }

                GameScreen gameScreen = new GameScreen(SContants.WIDTH, SContants.HEIGHT);
                getRoot().getChildren().add(gameScreen);

                gameScreen.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

                    @Override
                    public void handle(MouseEvent event) {

                        if ((event.getX() > 403 && event.getX() < 403 + 150 && event.getY() > 360 && event.getY() < 360 + 40) ||
                                (event.getX() > SContants.WIDTH-70 && event.getY() > SContants.HEIGHT-20)) {
                            System.exit(0);
                            //getRoot().getChildren().remove(gameScreen);

                        }
                    }

                });

                gameScreen.start();
                gameScreen.initEvents();
                //gameScreen.setGameState(1);
                gameScreen.setGameState(2);


            }
        });
        button1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Stage stage=new Stage();
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("选择一个录像txt");

                File file=fileChooser.showOpenDialog(null);
                getRoot().getChildren().remove(imageView);
                getRoot().getChildren().remove(button);
                getRoot().getChildren().remove(button1);

                GameScreen.NeworRep=2;
                getRoot().getChildren().add(imageView1);
                for (int i = 0; i < SContants.WIDTH; i += 80) {
                    Line line = new Line(i, 0, i, SContants.HEIGHT);
                    line.setStroke(Color.web("#500", 0.5));
                    getRoot().getChildren().add(line);
                }
                for (int i = 0; i < SContants.HEIGHT; i += 80) {
                    Line line = new Line(0, i, SContants.WIDTH, i);
                    line.setStroke(Color.web("#500", 0.5));
                    getRoot().getChildren().add(line);
                }

                GameScreen gameScreen = new GameScreen(SContants.WIDTH, SContants.HEIGHT);
                getRoot().getChildren().add(gameScreen);

                gameScreen.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

                    @Override
                    public void handle(MouseEvent event) {

                        if ((event.getX() > 403 && event.getX() < 403 + 150 && event.getY() > 360 && event.getY() < 360 + 40) ||
                                (event.getX() > SContants.WIDTH-70 && event.getY() > SContants.HEIGHT-20)) {
                            System.exit(0);
                            //getRoot().getChildren().remove(gameScreen);

                        }
                    }

                });

                gameScreen.start();
                gameScreen.initEvents();
                //gameScreen.setGameState(1);
                gameScreen.setGameState(2);
            }
        });


        getRoot().getChildren().add(button);
        getRoot().getChildren().add(button1);

    }

    @Override
    protected void showStage(Stage stage) {

        super.showStage(stage);
        stage.setTitle("葫芦娃大战妖精");
    }
}

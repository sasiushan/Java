package edu.curtin.saed.assignment1;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class App extends Application implements ArenaListener {


    private int score = 0, no;
    private Label scoreLabel, commands;


    //set the map aspect globally, and it will change everywhere.
    private int gridWidth = 9, gridHeight = 9;



    public static void main(String[] args)
    {
        launch();
    }

    @Override
    public void start(Stage stage)
    {
        TextArea logger = new TextArea();
        stage.setTitle("Example App (JavaFX)");


        JFXArena arena = new JFXArena(gridWidth, gridHeight,logger);
        Group root = new Group();

        ToolBar toolbar = new ToolBar();
//         Button btn1 = new Button("My Button 1");
//         Button btn2 = new Button("My Button 2");


        scoreLabel = new Label("Score : " + score);
        commands = new Label("Commands : " + no);



        toolbar.getItems().addAll(scoreLabel, commands);

//        JFXArena jfxArena = new JFXArena(gridWidth, gridHeight);
        arena.setScoreListener(this);
        arena.addListener(this);
        arena.queueCommandListener(this);



//      toolbar.getItems().addAll(btn1, btn2, label);

//        toolbar.getItems().addAll(label);

//         btn1.setOnAction((event) ->
//         {
//             System.out.println("Button 1 pressed");
//         });


        RobotLogic robotGenerator = new RobotLogic(arena, gridWidth, gridHeight);
        robotGenerator.callToBuildRobots();




        logger.setEditable(false);

        SplitPane splitPane = new SplitPane();
        splitPane.getItems().addAll(arena, logger);
        arena.setMinWidth(300.0);

        BorderPane contentPane = new BorderPane();
        contentPane.setTop(toolbar);
        contentPane.setCenter(splitPane);

        Scene scene = new Scene(contentPane, 800, 800);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void squareClicked(int x, int y) {

    }

    @Override
    public void updatedScore(int score) {
        scoreLabel.setText("Score =" + score);
    }

    @Override
    public void printCommand(int no) {
        commands.setText("| Queued Commands = " + no);
    }
}

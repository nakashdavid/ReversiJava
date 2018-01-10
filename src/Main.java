import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
//public class Main {
private static final int SIZE = 8;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    public static void main(String[] args) {
        Board board = new Board(SIZE);
        board.init();
        GenericLogic genericLogic = new GenericLogic();
        HumanPlayer p1 = new HumanPlayer('X', board, genericLogic);
        HumanPlayer p2 = new HumanPlayer('O', board, genericLogic);
        Game game = new Game(p1, p2);
        GameFlow gameFlow = new GameFlow(game);
        gameFlow.play();
        //launch(args);
    }
}

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage arg0) throws Exception {
    Parent scene = FXMLLoader.load(getClass().getResource("main.fxml"));

    arg0.setTitle("hello");
    arg0.setScene(new Scene(scene,400,300));
    arg0.show();
    }
}

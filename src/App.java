import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) throws Exception {
        try {
			GlobalScreen.registerNativeHook();
		}
		catch (NativeHookException ex) {
			System.err.println("There was a problem registering the native hook.");
			System.err.println(ex.getMessage());

			System.exit(1);
		}

		GlobalScreen.addNativeKeyListener(new ClickerController());
        launch(args);
    }

    @Override
    public void start(Stage arg0) throws Exception {
    Parent scene = FXMLLoader.load(getClass().getResource("main.fxml"));

    arg0.setTitle("hello");
    arg0.setScene(new Scene(scene));
    arg0.show();
    }
}

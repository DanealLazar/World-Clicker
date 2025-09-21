import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.Label;

public class ClickerController implements NativeKeyListener {

    private boolean isChangingKey = false;

    private int selectedKeyCode = -1;


    @FXML
    private ToggleButton changeKey;

    @FXML
    private TextField hours;

    @FXML
    private Label keyLabel;

    @FXML
    private TextField milliseconds;

    @FXML
    private TextField minutes;

    @FXML
    private TextField seconds;


    @FXML
    void onChangeKey(ActionEvent event) {
        isChangingKey = changeKey.isSelected();
    }

    public void nativeKeyPressed(NativeKeyEvent e){
        if (isChangingKey) {
        selectedKeyCode = e.getKeyCode();
        Platform.runLater(() -> {
            keyLabel.setText("Key: "+NativeKeyEvent.getKeyText(selectedKeyCode));
            changeKey.setSelected(false); // or whatever UI update you need
            isChangingKey = false;
        });
    }
    }
}
package sample;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.*;



public class Controller {

    @FXML private TextField mailSender;
    @FXML private PasswordField passwordGetter;

    @FXML
    private void handleButtonAction(ActionEvent event) throws Exception {
        JavaMailTest.sendMail(mailSender.getText());
    }

    @FXML
    private void handleButtonAction1(ActionEvent event) throws Exception {

    }
}

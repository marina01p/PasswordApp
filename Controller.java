package sample;

import java.io.*;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import java.util.Scanner;


public class Controller {

    @FXML
    private TextField mailSender;
    @FXML
    private PasswordField passwordGetter;
    @FXML
    private Button passBtn;
    @FXML
    private Button logBtn;
    @FXML
    private Label greetingslabel;
    @FXML
    private Label passThread;


    @FXML
    private void handleButtonAction(ActionEvent event) throws Exception {
        passwordGetter.setDisable(false);
        logBtn.setDisable(false);
        JavaMailTest.sendMail(mailSender.getText());
    }


    @FXML
    private void handleButtonAction1(ActionEvent event) throws Exception {

        File file = new File("out.txt");
        Scanner sc = new Scanner(file);
        sc.useDelimiter("\\Z");

        String b = sc.next();
        System.out.println(b);

        String c = passwordGetter.getText();

        if(b.equals(c)) {
            mailSender.setVisible(false);
            passwordGetter.setVisible(false);
            passBtn.setVisible(false);
            logBtn.setVisible(false);
            greetingslabel.setVisible(true);
            passThread.setVisible(false);
        } else {
            passThread.setVisible(true);
            System.out.println("Failed Login");
        }

}}



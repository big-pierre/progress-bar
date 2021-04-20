package io.javasmithy.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    private Stage stage;

    @FXML
    ProgressBar progressBar;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void setStage(Stage stage){
        this.stage = stage;
    }

    @FXML
    private void exit(){
        Platform.exit();
        System.exit(0);
    }
    @FXML
    private void incProgress(){
        double currentProgress = this.progressBar.getProgress();
        currentProgress += .005;
        this.progressBar.setProgress(currentProgress);
        setColor(currentProgress);
    }
    @FXML
    private void decProgress(){
        double currentProgress = this.progressBar.getProgress();
        currentProgress -= .005;
        if (currentProgress <= 0){
            this.progressBar.setProgress(0);
        } else {
            this.progressBar.setProgress(currentProgress);
        }
        setColor(currentProgress);
    }
    @FXML
    private void setColor(double progress){
        //
        int r, g, b;
        b = 0;
        if(progress < .5){
            r = 255;
            g = (int) (255 * progress) * 2;
        } else {
            r = (int) (255 - (255*((progress*2)-1)));
            g = 255;
        }

        System.out.println("Progress: " + progress + " R: " + r + " G: " + g + " B: " +b);
        this.progressBar.lookup(".bar").setStyle(
                "-fx-background-color: " +
                        "-fx-box-border, " +
                        "rgb(" + r + "," + g + ", " + b + ");");
    }

}
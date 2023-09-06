package com.cellimage.malariacellproject;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.embed.swing.SwingFXUtils;

import java.io.File;
import java.net.URL;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class MainAppGUIController {

    @FXML
    private ImageView imageViewArea;

    @FXML
    private Label locationLabel;

    String imageURLPath;
    Image loadedImage;
    BufferedImage preProcessedImage;


    @FXML
    void exitButton(ActionEvent event) {
        Platform.exit();
        event.consume();
    }

    @FXML
    void loadImageButton(ActionEvent event) {
        FileChooser selectImage=new FileChooser();
        selectImage.setInitialDirectory(new File("C:\\"));
        selectImage.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image File","*.png","*.jpg","*.jpeg"));
        //Get the current Stage
        Stage stage= (Stage) ((Node)event.getTarget()).getScene().getWindow();
        File selectedImage=selectImage.showOpenDialog(stage);
        if(selectedImage != null){
            try{
                imageURLPath = selectedImage.getPath();
                URL imageURL=selectedImage.toURI().toURL();
                loadedImage=new Image(imageURL.toString());
                imageViewArea.setImage(loadedImage);
                locationLabel.setText(imageURLPath);

            }catch(Exception e){
                System.out.println(e);
            }

        }

    }

    @FXML
    void preProcessButton(ActionEvent event) {
        // Convert JavaFX Image to BufferedImage
        BufferedImage bufferedImage = SwingFXUtils.fromFXImage(loadedImage, null);

        // Perform rescaling
        int newWidth = 224;
        int newHeight = 224;
        BufferedImage scaledImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
        scaledImage.getGraphics().drawImage(bufferedImage, 0, 0, newWidth, newHeight, null);
        preProcessedImage = scaledImage;
    }

    @FXML
    void resetButton(ActionEvent event) {
        imageViewArea.setImage(null);
        locationLabel.setText("");

    }

    @FXML
    void resultsButton(ActionEvent event) {

    }

    @FXML
    void runModel(ActionEvent event) {

    }

}

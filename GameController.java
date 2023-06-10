package test;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.TextField;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GameController {

    @FXML
    private TextField headLine;

    @FXML
    private ImageView image;

    private String [] names;

    private final int n = 5;

    private Image [] images;
    private int curPic = 0;

    public void initialize(){
        names = new String[n];

        images = new Image[n];
        for(int i = 0; i < n; i++){
            String name = "pic" + (i + 1) + ".gif";
            try{
                images[i] = new Image(new FileInputStream(name));
            }catch (FileNotFoundException e){
                e.printStackTrace();
            }
            names[i] = name;
        }
        image.setImage(images[curPic]);
        headLine.setText(names[curPic].substring(0, names[0].length() - 4));
    }

    @FXML
    void jumpPressed(ActionEvent event) {
        TextInputDialog td = new TextInputDialog("the pic num: ");
        td.showAndWait();
        String num = td.getResult();
        int num1 = Integer.parseInt(num);
        num1 = (num1 - 1) % n;
        curPic = num1;
        image.setImage(images[curPic]);
        headLine.setText(names[curPic].substring(0, names[0].length() - 4));
    }

    @FXML
    void nextPressed(ActionEvent event) {
        curPic++;
        if(curPic == n-1){
            curPic = 0;
        }
        image.setImage(images[curPic]);
        headLine.setText(names[curPic].substring(0, names[0].length() - 4));
    }

}

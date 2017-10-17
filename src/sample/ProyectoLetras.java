
package sample ;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class ProyectoLetras extends Application{

    private final int height =600, width=800;
    
     @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Traductor de letras");
        primaryStage.getIcons().add(new Image("/resources/icon.png"));
        primaryStage.setScene(new Scene(root, this.width,this.height));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        Controller c = new Controller();
        launch(args);
    }
}

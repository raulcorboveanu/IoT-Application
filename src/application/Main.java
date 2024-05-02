package application;

import javafx.stage.Stage;
import javafx.application.Application;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
    	Things t = new Things();
    	HomePage.displayHomePage(primaryStage, t);
    } 
    
    
    public static void main(String[] args) {
        launch(args);
    }
}

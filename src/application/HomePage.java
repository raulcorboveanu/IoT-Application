package application;

import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Cursor;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.paint.Stop;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.LinearGradient;

public class HomePage {

    public static void displayHomePage(Stage primaryStage, Things t) {
        // Create labels
        Label title = new Label("Your Home");
        title.setStyle("-fx-font-size: 35px; -fx-font-weight: bold; -fx-text-fill: black;");

        // Create VBox for each button containing label and image
        VBox lightBox = createButtonBox("Light", "Lights.jpg");
        VBox heatingBox = createButtonBox("Heating", "Heating.jpg");
        VBox camerasBox = createButtonBox("Cameras", "Cameras.jpg");
        VBox tvBox = createButtonBox("TV", "TvConsole.jpg");
        VBox alexaBox = createButtonBox("Alexa", "Alexa.jpg");
        VBox lockBox = createButtonBox("Locks", "Locks.jpg");

        // All actions
        lightBox.setOnMouseClicked(event -> LightsPage.displayLightsPage(primaryStage, t));
        heatingBox.setOnMouseClicked(event -> HeatingPage.displayLightsPage(primaryStage, t));
        camerasBox.setOnMouseClicked(event -> CamerasPage.displayLightsPage(primaryStage, t));
        tvBox.setOnMouseClicked(event -> TVPage.displayLightsPage(primaryStage, t));
        alexaBox.setOnMouseClicked(event -> AlexaScreen.displayLightsPage(primaryStage, t));
        

        // Create grid pane layout
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(30));
        grid.setVgap(30);
        grid.setHgap(30);
        grid.setAlignment(Pos.CENTER);
        grid.add(title, 1, 1);

        grid.add(lightBox, 0, 2);
        grid.add(heatingBox, 1, 2);
        grid.add(camerasBox, 2, 2);

        grid.add(tvBox, 0, 3);
        grid.add(alexaBox, 1, 3);
        grid.add(lockBox, 2, 3);

        // Set background colour to a sky-like gradient
        Stop[] stops = new Stop[]{
                new Stop(0, Color.LIGHTBLUE),
                new Stop(1, Color.LIGHTYELLOW)
        };
        LinearGradient gradient = new LinearGradient(0, 0, 0, 1, true, javafx.scene.paint.CycleMethod.NO_CYCLE, stops);
        grid.setBackground(new Background(new BackgroundFill(gradient, CornerRadii.EMPTY, Insets.EMPTY)));

        // Add hover effect
        addHoverEffect(lightBox);
        addHoverEffect(heatingBox);
        addHoverEffect(camerasBox);
        addHoverEffect(tvBox);
        addHoverEffect(alexaBox);
        addHoverEffect(lockBox);

        // Create scene
        Scene scene = new Scene(grid, 900, 620);

        // Set stage properties
        primaryStage.setScene(scene);
        primaryStage.setTitle("IoT System");
        primaryStage.setMaximized(false);
        primaryStage.show();
    }

    // Method to create VBox for a button with label and image
    private static VBox createButtonBox(String labelText, String imageName) {
        VBox box = new VBox();
        box.setAlignment(Pos.CENTER);
        
        // Create label
        Label label = new Label(labelText);
        label.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
        
        // Create image
        ImageView icon = new ImageView(new Image(LightsPage.class.getResourceAsStream(imageName)));
        icon.setFitWidth(200);
        icon.setFitHeight(130);
        
        // Add label and image to VBox
        box.getChildren().addAll(label, icon);
        
        return box;
    }

    // Method to add hover effect to a VBox
    private static void addHoverEffect(VBox box) {
        box.setOnMouseEntered(event -> {
            box.setStyle("-fx-background-color: lightblue;");
            box.setCursor(Cursor.HAND);
        });

        box.setOnMouseExited(event -> {
            box.setStyle("-fx-background-color: transparent;");
            box.setCursor(Cursor.DEFAULT);
        });
    }
}

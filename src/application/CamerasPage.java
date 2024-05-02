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
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.LinearGradient;

public class CamerasPage {
	public static void displayLightsPage(Stage lightsStage, Things t) {
		// Apply green shadow effect
        DropShadow greenOn = new DropShadow();
        greenOn.setColor(Color.GREEN);
        greenOn.setSpread(0.7);
        
        DropShadow redOff = new DropShadow();
        redOff.setColor(Color.RED);
        redOff.setSpread(0.7);

		
		// Create labels
        Label title = new Label("Your Security System");
        title.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: black;");

        // Create VBox for each button containing label and image
        VBox Camera1Box = createButtonBox("Camera 1", "Camera1to6.jpg");
        VBox Camera2Box = createButtonBox("Camera 2", "Camera1to6.jpg");
        VBox Camera3Box = createButtonBox("Camera 3", "Camera1to6.jpg");
        VBox Camera4Box = createButtonBox("Camera 4", "Camera1to6.jpg");
        VBox Camera5Box = createButtonBox("Camera 5", "Camera1to6.jpg");
        VBox Camera6Box = createButtonBox("Camera 6", "Camera1to6.jpg");
        
	    Button backButton = new Button("Back");	  
        
	    backButton.setOnAction(new EventHandler<ActionEvent>() {
	    	@Override
	    	public void handle(ActionEvent event) {
	    		HomePage.displayHomePage(lightsStage, t);
	    		}
	    	});

	    Camera1Box.setOnMouseClicked(new EventHandler<MouseEvent>() {
	    	@Override
	    	public void handle(MouseEvent event) {
	    		if(t.Camera1)
	    			Camera1Box.setEffect(redOff);
	    		else
	    			Camera1Box.setEffect(greenOn);
	    		
	    		t.Camera1 = !t.Camera1;
	    		}
	    	});
	    
	    Camera2Box.setOnMouseClicked(new EventHandler<MouseEvent>() {
	    	@Override
	    	public void handle(MouseEvent event) {
	    		if(t.Camera2)
	    			Camera2Box.setEffect(redOff);
	    		else
	    			Camera2Box.setEffect(greenOn);
	    		
	    		t.Camera2 = !t.Camera2;
	    		}
	    	});
	    
	    Camera3Box.setOnMouseClicked(new EventHandler<MouseEvent>() {
	    	@Override
	    	public void handle(MouseEvent event) {
	    		if(t.Camera3)
	    			Camera3Box.setEffect(redOff);
	    		else
	    			Camera3Box.setEffect(greenOn);
	    		
	    		t.Camera3 = !t.Camera3;
	    		}
	    	});
	    
	    Camera4Box.setOnMouseClicked(new EventHandler<MouseEvent>() {
	    	@Override
	    	public void handle(MouseEvent event) {
	    		if(t.Camera4)
	    			Camera4Box.setEffect(redOff);
	    		else
	    			Camera4Box.setEffect(greenOn);
	    		
	    		t.Camera4 = !t.Camera4;
	    		}
	    	});
	    
	    Camera5Box.setOnMouseClicked(new EventHandler<MouseEvent>() {
	    	@Override
	    	public void handle(MouseEvent event) {
	    		if(t.Camera5)
	    			Camera5Box.setEffect(redOff);
	    		else
	    			Camera5Box.setEffect(greenOn);
	    		
	    		t.Camera5 = !t.Camera5;
	    		}
	    	});
	    
	    Camera6Box.setOnMouseClicked(new EventHandler<MouseEvent>() {
	    	@Override
	    	public void handle(MouseEvent event) {
	    		if(t.Camera6)
	    			Camera6Box.setEffect(redOff);
	    		else
	    			Camera6Box.setEffect(greenOn);
	    		
	    		t.Camera6 = !t.Camera6;
	    		}
	    	});
	    
	    
        // Create grid pane layout
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(30));
        grid.setVgap(30);
        grid.setHgap(30);
        grid.setAlignment(Pos.CENTER);
        grid.add(backButton, 0, 0);
        grid.add(title, 1, 0);

        grid.add(Camera1Box, 0, 2);
        grid.add(Camera2Box, 1, 2);
        grid.add(Camera3Box, 2, 2);

        grid.add(Camera4Box, 0, 3);
        grid.add(Camera5Box, 1, 3);
        grid.add(Camera6Box, 2, 3);
        

        // Set background color to a sky-like gradient
        Stop[] stops = new Stop[]{
                new Stop(0, Color.LIGHTBLUE),
                new Stop(1, Color.LIGHTYELLOW)
        };
        LinearGradient gradient = new LinearGradient(0, 0, 0, 1, true, javafx.scene.paint.CycleMethod.NO_CYCLE, stops);
        grid.setBackground(new Background(new BackgroundFill(gradient, CornerRadii.EMPTY, Insets.EMPTY)));

        // Add hover effect
        addHoverEffect(Camera1Box);
        addHoverEffect(Camera2Box);
        addHoverEffect(Camera3Box);
        addHoverEffect(Camera4Box);
        addHoverEffect(Camera5Box);
        addHoverEffect(Camera6Box);
        
	    // Check Things
	    CheckThings(Camera1Box, t.Camera1, greenOn, redOff);
	    CheckThings(Camera2Box, t.Camera2, greenOn, redOff);
	    CheckThings(Camera3Box, t.Camera3, greenOn, redOff);
	    CheckThings(Camera4Box, t.Camera4, greenOn, redOff);
	    CheckThings(Camera5Box, t.Camera5, greenOn, redOff);
	    CheckThings(Camera6Box, t.Camera6, greenOn, redOff);

        // Create scene
        Scene scene = new Scene(grid, 900, 620);

        // Set stage properties
        lightsStage.setScene(scene);
        lightsStage.setTitle("IoT System");
        lightsStage.setMaximized(false);
        lightsStage.show();
	}
    
    // Method to add hover effect to a VBox
    private static void addHoverEffect(VBox box) {
        box.setOnMouseEntered(event -> {
            box.setCursor(Cursor.HAND);
        });

        box.setOnMouseExited(event -> {
            box.setCursor(Cursor.DEFAULT);
        });
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
    
    public static void CheckThings(VBox button, boolean thing, DropShadow greenOn, DropShadow redOff) {
    	button.setStyle("-fx-background-color: lightblue;");
    	if(thing)
    		button.setEffect(greenOn);
    	else
    		button.setEffect(redOff);
    }
}

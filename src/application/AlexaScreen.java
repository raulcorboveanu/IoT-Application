package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.stage.Stage;

public class AlexaScreen {
	public static void displayLightsPage(Stage lightsStage, Things t) {
		// Apply green shadow effect
        DropShadow greenOn = new DropShadow();
        greenOn.setColor(Color.GREEN);
        greenOn.setSpread(0.7);
        
        DropShadow redOff = new DropShadow();
        redOff.setColor(Color.RED);
        redOff.setSpread(0.7);

        Label alexaLabel = new Label("Current Usage: " + String.format("%.2f",t.alexausage) + "kWh");
        alexaLabel.setStyle("-fx-text-fill: black;");
        
        // Create VBox for each button containing label and image
        VBox alexa = createButtonBox("Alexa", "Alexa.jpg");
	    Button backButton = new Button("Back");	  
        
	    backButton.setOnAction(new EventHandler<ActionEvent>() {
	    	@Override
	    	public void handle(ActionEvent event) {
	    		HomePage.displayHomePage(lightsStage, t);
	    		}
	    	});

	    alexa.setOnMouseClicked(new EventHandler<MouseEvent>() {
	    	@Override
	    	public void handle(MouseEvent event) {
	    		if(t.alexa) {
	    			t.alexausage = 0.00;
	    			alexa.setEffect(redOff);
	    		}
	    		else {
	    			alexa.setEffect(greenOn);
	    			t.alexausage = 0.04;
	    		}
	    		
	    		alexaLabel.setText("Current Usage: " + String.format("%.2f",t.alexausage) + "kWh");
	    		t.alexa = !t.alexa;
	    		}
	    	});
	    
	    
        // Create grid pane layout
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setVgap(20);
        grid.setHgap(20);
        grid.setAlignment(Pos.CENTER);
        grid.add(backButton, 0, 1);

        grid.add(alexa, 0, 2);
        grid.add(alexaLabel, 0, 3);

        // Set background colour to a sky-like gradient
        Stop[] stops = new Stop[]{
                new Stop(0, Color.LIGHTBLUE),
                new Stop(1, Color.LIGHTYELLOW)
        };
        LinearGradient gradient = new LinearGradient(0, 0, 0, 1, true, javafx.scene.paint.CycleMethod.NO_CYCLE, stops);
        grid.setBackground(new Background(new BackgroundFill(gradient, CornerRadii.EMPTY, Insets.EMPTY)));

        // Add hover effect
        addHoverEffect(alexa);
        
	    // Check Things
	    CheckThings(alexa, t.alexa, greenOn, redOff);

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

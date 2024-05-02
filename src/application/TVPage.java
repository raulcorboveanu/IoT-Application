package application;

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

public class TVPage {
	public static void displayLightsPage(Stage lightsStage, Things t) {
		// Apply green shadow effect
        DropShadow greenOn = new DropShadow();
        greenOn.setColor(Color.GREEN);
        greenOn.setSpread(0.7);
        
        DropShadow redOff = new DropShadow();
        redOff.setColor(Color.RED);
        redOff.setSpread(0.7);

		
		Label title = new Label("Your Entertainment System");
		title.setStyle("-fx-font-size: 30px; -fx-font-weight: bold; -fx-text-fill: black;");
        title.setLayoutX(300);
        title.setLayoutY(50);
        
        Label lgtv = new Label("Current Usage: " + String.format("%.2f",t.LGTVusage) + "kWh");
        lgtv.setStyle("-fx-text-fill: black;");
        lgtv.setLayoutX(330);
        lgtv.setLayoutY(210);
        
        Label bosespeaker = new Label("Current Usage: " + String.format("%.2f",t.BoseSpeakerusage) + "kWh");
        bosespeaker.setStyle("-fx-text-fill: black;");
        bosespeaker.setLayoutX(330);
        bosespeaker.setLayoutY(410);
        
        Label ps5 = new Label("Current Usage: " + String.format("%.2f",t.PS5usage) + "kWh");
        ps5.setStyle("-fx-text-fill: black;");
        ps5.setLayoutX(730);
        ps5.setLayoutY(210);
        
        
        // Create VBox for each button containing label and image
        VBox LGTV = createButtonBox("LG TV", "LG Tv.jpg", 120, 150);
        VBox BoseSpeaker = createButtonBox("Bose Speaker", "BoseSpeaker.jpg", 120, 340);
        VBox PS5 = createButtonBox("PS5", "PS5.jpg", 520, 150);
        
        Button backButton = new Button("Back");
        backButton.setLayoutX(50);
        backButton.setLayoutY(60);
        
        
        backButton.setOnAction(new EventHandler<ActionEvent>() {
	    	@Override
	    	public void handle(ActionEvent event) {
	    		HomePage.displayHomePage(lightsStage, t);
	    		}
	    	});

	    LGTV.setOnMouseClicked(new EventHandler<MouseEvent>() {
	    	@Override
	    	public void handle(MouseEvent event) {
	    		if(t.LGTV) {
	    			LGTV.setEffect(redOff);
	    			t.LGTVusage = 0.00;
	    		}
	    		else {
	    			LGTV.setEffect(greenOn);
	    			t.LGTVusage = 203;
	    		}
	    		
	    		lgtv.setText("Current Usage: " + String.format("%.2f",t.LGTVusage) + "kWh");
	    		t.LGTV = !t.LGTV;
	    		}
	    	});
	    
	    BoseSpeaker.setOnMouseClicked(new EventHandler<MouseEvent>() {
	    	@Override
	    	public void handle(MouseEvent event) {
	    		if(t.BoseSpeaker) {
	    			BoseSpeaker.setEffect(redOff);
	    			t.BoseSpeakerusage = 0.00;
	    		}
	    		else {
	    			BoseSpeaker.setEffect(greenOn);
	    			t.BoseSpeakerusage = 0.04;
	    		}
	    		
	    		bosespeaker.setText("Current Usage: " + String.format("%.2f",t.BoseSpeakerusage) + "kWh");
	    		t.BoseSpeaker = !t.BoseSpeaker;
	    		}
	    	});
	    
	    PS5.setOnMouseClicked(new EventHandler<MouseEvent>() {
	    	@Override
	    	public void handle(MouseEvent event) {
	    		if(t.PS5) {
	    			PS5.setEffect(redOff);
	    			t.PS5usage = 0;
	    		}
	    		else {
	    			PS5.setEffect(greenOn);
	    			t.PS5usage = 131;
	    		}
	    		
	    		ps5.setText("Current Usage: " + String.format("%.2f",t.PS5usage) + "kWh");
	    		t.PS5 = !t.PS5;
	    		}
	    	});
        
        // Set background colour to a sky-like gradient
        Stop[] stops = new Stop[]{
                new Stop(0, Color.LIGHTBLUE),
                new Stop(1, Color.LIGHTYELLOW)
        };
        LinearGradient gradient = new LinearGradient(0, 0, 0, 1, true, javafx.scene.paint.CycleMethod.NO_CYCLE, stops);

        // Hover Effect
        addHoverEffect(LGTV);
        addHoverEffect(PS5);
        addHoverEffect(BoseSpeaker);
        
        // Check Things
	    CheckThings(LGTV, t.LGTV, greenOn, redOff);
	    CheckThings(BoseSpeaker, t.BoseSpeaker, greenOn, redOff);
	    CheckThings(PS5, t.PS5, greenOn, redOff);
        
        // Create a new Pane
        Pane pane = new Pane(title, LGTV, lgtv, BoseSpeaker, bosespeaker, PS5, ps5, backButton);

        // Set the background of the Pane
        pane.setBackground(new Background(new BackgroundFill(gradient, CornerRadii.EMPTY, Insets.EMPTY)));

        // Set the root of the scene to the Pane
        lightsStage.getScene().setRoot(pane);

        
        // Set stage properties
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
    private static VBox createButtonBox(String labelText, String imageName, double x, double y) {
        VBox box = new VBox();
        box.setAlignment(Pos.CENTER);
        box.setLayoutX(x);
        box.setLayoutY(y);

        // Create label
        Label label = new Label(labelText);
        label.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        // Create image
        ImageView icon = new ImageView(new Image(TVPage.class.getResourceAsStream(imageName)));
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


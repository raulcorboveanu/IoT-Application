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

import java.util.Random;

import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.LinearGradient;

public class HeatingPage {
	public static void displayLightsPage(Stage lightsStage, Things t) {
		Random random = new Random();
		// Apply green shadow effect
        DropShadow greenOn = new DropShadow();
        greenOn.setColor(Color.GREEN);
        greenOn.setSpread(0.7);
        
        DropShadow redOff = new DropShadow();
        redOff.setColor(Color.RED);
        redOff.setSpread(0.7);

		
		// Create labels
        Label title = new Label("Heating");
        title.setStyle("-fx-font-size: 35px; -fx-font-weight: bold; -fx-text-fill: black;");
        
        
        Label Bedroom1Label = new Label();
        Label Bedroom2Label = new Label();
        Label KitchenLabel = new Label();
        Label LivingRoomLabel = new Label();
        Label BathroomLabel = new Label();


        // Create VBox for each button containing label and image
        VBox Bedroom1Box = createButtonBox("Bedroom 1", "Bedroom1.jpg");
        VBox Bedroom2Box = createButtonBox("Bedroom 2", "Bedroom2.jpg");
        VBox KitchenBox = createButtonBox("Kitchen", "Kitchen.jpg");
        VBox LivingRoomBox = createButtonBox("Living Room", "LivingRoom.jpg");
        VBox BathroomBox = createButtonBox("Bathroom", "Bathroom.jpg");
        
	    Button backButton = new Button("Back");	  
        
	    backButton.setOnAction(new EventHandler<ActionEvent>() {
	    	@Override
	    	public void handle(ActionEvent event) {
	    		HomePage.displayHomePage(lightsStage, t);
	    		}
	    	});

	    Bedroom1Box.setOnMouseClicked(new EventHandler<MouseEvent>() {
	    	@Override
	    	public void handle(MouseEvent event) {
	    		if(t.BedRoom1Temp) {
	    			Bedroom1Box.setEffect(redOff);
		            double randomNumber = 18.5 + (21 - 18.5) * random.nextDouble();
		            t.BedRoom1 = randomNumber;
	    		}
	    		else {
	    			Bedroom1Box.setEffect(greenOn);
	    			double randomNumber = 22.5 + (25 - 22.5) * random.nextDouble();
		            t.BedRoom1 = randomNumber;
	    		}
	    		
	    		Bedroom1Label.setText(String.format("%.2f", t.BedRoom1) + "°C");
	    		t.BedRoom1Temp = !t.BedRoom1Temp;
	    		}
	    	});
	    
	    KitchenBox.setOnMouseClicked(new EventHandler<MouseEvent>() {
	    	@Override
	    	public void handle(MouseEvent event) {
	    		if(t.KitchenTemp) {
	    			KitchenBox.setEffect(redOff);
	    			double randomNumber = 18.5 + (21 - 18.5) * random.nextDouble();
		            t.Kitchen = randomNumber;
	    		}
	    		else {
	    			KitchenBox.setEffect(greenOn);
	    			double randomNumber = 22.5 + (25 - 22.5) * random.nextDouble();
		            t.Kitchen = randomNumber;
	    		}
	    		
	    		KitchenLabel.setText(String.format("%.2f",t.Kitchen) + "°C");
	    		t.KitchenTemp = !t.KitchenTemp;
	    		}
	    	});
	    
	    Bedroom2Box.setOnMouseClicked(new EventHandler<MouseEvent>() {
	    	@Override
	    	public void handle(MouseEvent event) {
	    		if(t.BedRoom2Temp) {
	    			Bedroom2Box.setEffect(redOff);
	    			double randomNumber = 18.5 + (21 - 18.5) * random.nextDouble();
		            t.BedRoom2 = randomNumber;
	    		}
	    		else {
	    			Bedroom2Box.setEffect(greenOn);
	    			double randomNumber = 22.5 + (25 - 22.5) * random.nextDouble();
		            t.BedRoom2 = randomNumber;
	    		}
	    		
	    		Bedroom2Label.setText(String.format("%.2f",t.BedRoom2) + "°C");
	    		t.BedRoom2Temp = !t.BedRoom2Temp;
	    		}
	    	});
	    
	    LivingRoomBox.setOnMouseClicked(new EventHandler<MouseEvent>() {
	    	@Override
	    	public void handle(MouseEvent event) {
	    		if(t.LivingRoomTemp) {
	    			LivingRoomBox.setEffect(redOff);
	    			double randomNumber = 18.5 + (21 - 18.5) * random.nextDouble();
		            t.LivingRoom = randomNumber;
	    		}
	    		else {
	    			LivingRoomBox.setEffect(greenOn);
	    			double randomNumber = 22.5 + (25 - 22.5) * random.nextDouble();
		            t.LivingRoom = randomNumber;
	    		}
	    		
	    		LivingRoomLabel.setText(String.format("%.2f",t.LivingRoom) + "°C");
	    		t.LivingRoomTemp = !t.LivingRoomTemp;
	    		}
	    	});
	    
	    BathroomBox.setOnMouseClicked(new EventHandler<MouseEvent>() {
	    	@Override
	    	public void handle(MouseEvent event) {
	    		if(t.BathRoomTemp) {
	    			BathroomBox.setEffect(redOff);
	    	        double randomNumber = 18.5 + (21 - 18.5) * random.nextDouble();
		            t.BathRoom = randomNumber;
	    		}
	    		else {
	    			BathroomBox.setEffect(greenOn);
	    	        double randomNumber = 22.5 + (25 - 22.5) * random.nextDouble();
		            t.BathRoom = randomNumber;
	    		}
	    		
	    		BathroomLabel.setText(String.format("%.2f",t.BathRoom) + "°C");
	    		t.BathRoomTemp = !t.BathRoomTemp;
	    		}
	    	});
	    
	    
        // Create grid pane layout
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setVgap(20);
        grid.setHgap(20);
        grid.setAlignment(Pos.CENTER);
        grid.add(backButton, 0, 1);
        grid.add(title, 1, 1);

        grid.add(Bedroom1Box, 0, 2);
        grid.add(Bedroom2Box, 0, 3);
        grid.add(KitchenBox, 0, 4);
        
        grid.add(Bedroom1Label, 1, 2);
        grid.add(Bedroom2Label, 1, 3);
        grid.add(KitchenLabel, 1, 4);

        grid.add(LivingRoomBox, 2, 2);
        grid.add(BathroomBox, 2, 3);
        
        grid.add(LivingRoomLabel, 3, 2);
        grid.add(BathroomLabel, 3, 3);

        // Set background colour to a sky-like gradient
        Stop[] stops = new Stop[]{
                new Stop(0, Color.LIGHTBLUE),
                new Stop(1, Color.LIGHTYELLOW)
        };
        LinearGradient gradient = new LinearGradient(0, 0, 0, 1, true, javafx.scene.paint.CycleMethod.NO_CYCLE, stops);
        grid.setBackground(new Background(new BackgroundFill(gradient, CornerRadii.EMPTY, Insets.EMPTY)));

        // Add hover effect
        addHoverEffect(Bedroom1Box);
        addHoverEffect(Bedroom2Box);
        addHoverEffect(KitchenBox);
        addHoverEffect(LivingRoomBox);
        addHoverEffect(BathroomBox);
        
        CheckThings(Bedroom1Box, t.BedRoom1Temp, greenOn, redOff);
        CheckThings(Bedroom2Box, t.BedRoom2Temp, greenOn, redOff);
        CheckThings(KitchenBox, t.KitchenTemp, greenOn, redOff);
        CheckThings(LivingRoomBox, t.LivingRoomTemp, greenOn, redOff);
        CheckThings(BathroomBox, t.BathRoomTemp, greenOn, redOff);
        
        
	    // Check Things
	    Bedroom1Label.setText(String.format("%.2f",t.BedRoom1) + "°C");
	    Bedroom2Label.setText(String.format("%.2f",t.BedRoom2) + "°C");
	    KitchenLabel.setText(String.format("%.2f",t.Kitchen) + "°C");
	    LivingRoomLabel.setText(String.format("%.2f",t.LivingRoom) + "°C");
	    BathroomLabel.setText(String.format("%.2f",t.BathRoom) + "°C");

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
        if (thing) {
            button.setEffect(greenOn);
        } else {
            button.setEffect(redOff);
        }
    }
}

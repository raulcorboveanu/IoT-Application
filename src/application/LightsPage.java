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

public class LightsPage {

	public static void displayLightsPage(Stage lightsStage, Things t) {
        GridPane grid = new GridPane();
		
		// Apply green shadow effect
        DropShadow greenOn = new DropShadow();
        greenOn.setColor(Color.GREEN);
        greenOn.setSpread(0.7);
        
        DropShadow redOff = new DropShadow();
        redOff.setColor(Color.RED);
        redOff.setSpread(0.7);

		
		// Create labels
        Label title = new Label("Lights");
        title.setStyle("-fx-font-size: 35px; -fx-font-weight: bold; -fx-text-fill: black;");
        
        Label usage = new Label("Current Usage: " + String.format("%.2f", t.Usage) + " kWh");
        usage.setStyle("-fx-text-fill: black;");

        // Create VBox for each button containing label and image
        VBox Bedroom1Box = createButtonBox("Bedroom 1", "Bedroom1.jpg");
        VBox Bedroom2Box = createButtonBox("Bedroom 2", "Bedroom2.jpg");
        VBox KitchenBox = createButtonBox("Kitchen", "Kitchen.jpg");
        VBox LivingRoomBox = createButtonBox("Living Room", "LivingRoom.jpg");
        VBox BathroomBox = createButtonBox("Bathroom", "Bathroom.jpg");
        VBox FrontGardenBox = createButtonBox("Front Garden", "FrontGarden.jpg");
        VBox BackGardenBox = createButtonBox("Back Garden", "BackGarden.jpg");
        
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
	    		if(t.BedRoom1Light)
	    		{
	    			Bedroom1Box.setEffect(redOff);
	    			t.Usage -= 0.05;
	    		}
	    		else
	    		{
	    			Bedroom1Box.setEffect(greenOn);
	    			t.Usage += 0.05;
	    		}
	    		
	    		t.BedRoom1Light = !t.BedRoom1Light;
	    		
	    		usage.setText("Current Usage: " + String.format("%.2f", t.Usage) + " kWh");            
	    		}
	    	});
	    
	    KitchenBox.setOnMouseClicked(new EventHandler<MouseEvent>() {
	    	@Override
	    	public void handle(MouseEvent event) {
	    		if(t.KitchenLight) {
	    			KitchenBox.setEffect(redOff);
	    			t.Usage -= 0.05;
	    		}
	    		else {
	    			KitchenBox.setEffect(greenOn);
	    			t.Usage += 0.05;
	    		}
	    		
	    		t.KitchenLight = !t.KitchenLight;
	    		
	    		usage.setText("Current Usage: " + String.format("%.2f", t.Usage) + " kWh");
	    		}
	    	});
	    
	    Bedroom2Box.setOnMouseClicked(new EventHandler<MouseEvent>() {
	    	@Override
	    	public void handle(MouseEvent event) {
	    		if(t.BedRoom2Light) {
	    			Bedroom2Box.setEffect(redOff);
	    			t.Usage -= 0.05;
	    		}
	    		else {
	    			Bedroom2Box.setEffect(greenOn);
	    			t.Usage += 0.05;
	    		}
	    		
	    		t.BedRoom2Light = !t.BedRoom2Light;
	    		
	    		usage.setText("Current Usage: " + String.format("%.2f", t.Usage) + " kWh");
	    		}
	    	});
	    
	    LivingRoomBox.setOnMouseClicked(new EventHandler<MouseEvent>() {
	    	@Override
	    	public void handle(MouseEvent event) {
	    		if(t.LivingRoomLight) {
	    			LivingRoomBox.setEffect(redOff);
	    			t.Usage -= 0.05;
	    		}
	    		else {
	    			LivingRoomBox.setEffect(greenOn);
	    			t.Usage += 0.05;
	    		}
	    		
	    		t.LivingRoomLight = !t.LivingRoomLight;
	    		
	    		usage.setText("Current Usage: " + String.format("%.2f", t.Usage) + " kWh");
	    		}
	    	});
	    
	    BathroomBox.setOnMouseClicked(new EventHandler<MouseEvent>() {
	    	@Override
	    	public void handle(MouseEvent event) {
	    		if(t.BathRoomLight) {
	    			BathroomBox.setEffect(redOff);
	    			t.Usage -= 0.05;
	    		}
	    		else {
	    			BathroomBox.setEffect(greenOn);
	    			t.Usage += 0.05;
	    		}
	    		
	    		t.BathRoomLight = !t.BathRoomLight;
	    		
	    		usage.setText("Current Usage: " + String.format("%.2f", t.Usage) + " kWh");
	    		}
	    	});
	    
	    FrontGardenBox.setOnMouseClicked(new EventHandler<MouseEvent>() {
	    	@Override
	    	public void handle(MouseEvent event) {
	    		if(t.FrontGardenLight) {
	    			FrontGardenBox.setEffect(redOff);
	    			t.Usage -= 0.05;
	    		}
	    		else {
	    			FrontGardenBox.setEffect(greenOn);
	    			t.Usage += 0.05;
	    		}
	    		
	    		t.FrontGardenLight = !t.FrontGardenLight;
	    		
	    		usage.setText("Current Usage: " + String.format("%.2f", t.Usage) + " kWh");
	    		}
	    	});
	    
	    BackGardenBox.setOnMouseClicked(new EventHandler<MouseEvent>() {
	    	@Override
	    	public void handle(MouseEvent event) {
	    		if(t.BackGardenLight) {
	    			BackGardenBox.setEffect(redOff);
	    			t.Usage -= 0.05;
	    		}
	    		else {
	    			BackGardenBox.setEffect(greenOn);
	    			t.Usage += 0.05;
	    		}
	    		
	    		t.BackGardenLight = !t.BackGardenLight;
	    		
	    		usage.setText("Current Usage: " + String.format("%.2f", t.Usage) + " kWh");
	    		}
	    	});
	    
	    
        // Create grid pane layout
        grid.setPadding(new Insets(30));
        grid.setVgap(30);
        grid.setHgap(30);
        grid.setAlignment(Pos.CENTER);
        grid.add(backButton, 0, 1);
        grid.add(title, 1, 1);
        
        grid.add(usage, 0, 2);

        grid.add(Bedroom1Box, 0, 3);
        grid.add(Bedroom2Box, 1, 3);
        grid.add(KitchenBox, 2, 3);

        grid.add(LivingRoomBox, 0, 4);
        grid.add(BathroomBox, 1, 4);
        grid.add(FrontGardenBox, 2, 4);
        
        grid.add(BackGardenBox, 1, 5);

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
        addHoverEffect(FrontGardenBox);
        addHoverEffect(BackGardenBox);
        
	    // Check Things
	    CheckThings(Bedroom1Box, t.BedRoom1Light, greenOn, redOff);
	    CheckThings(Bedroom2Box, t.BedRoom2Light, greenOn, redOff);
	    CheckThings(KitchenBox, t.KitchenLight, greenOn, redOff);
	    CheckThings(LivingRoomBox, t.LivingRoomLight, greenOn, redOff);
	    CheckThings(BathroomBox, t.BathRoomLight, greenOn, redOff);
	    CheckThings(FrontGardenBox, t.FrontGardenLight, greenOn, redOff);
	    CheckThings(BackGardenBox, t.BackGardenLight, greenOn, redOff);

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
        icon.setFitWidth(150);
        icon.setFitHeight(100);
        
        // Add label and image to VBox
        box.getChildren().addAll(label, icon);
        
        return box;
    }
    
    public static void CheckThings(VBox button, boolean thing, DropShadow greenOn, DropShadow redOff) {
    	button.setStyle("-fx-background-color: lightblue;");
    	if(thing) {
    		button.setEffect(greenOn);
    	}
    	else
    		button.setEffect(redOff);
    }
}

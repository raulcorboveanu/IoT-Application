package application;

import java.util.Random;

public class Things {
	public boolean BedRoom1Light;
	public boolean BedRoom2Light;
	public boolean KitchenLight;
	public boolean LivingRoomLight;
	public boolean BathRoomLight;
	public boolean FrontGardenLight;
	public boolean BackGardenLight;
	public double Usage;
	
	public boolean BedRoom1Temp;
	public boolean BedRoom2Temp;
	public boolean KitchenTemp;
	public boolean LivingRoomTemp;
	public boolean BathRoomTemp;
	public double BedRoom1;
	public double BedRoom2;
	public double Kitchen;
	public double LivingRoom;
	public double BathRoom;
	
	
	
	public boolean Camera1;
	public boolean Camera2;
	public boolean Camera3;
	public boolean Camera4;
	public boolean Camera5;
	public boolean Camera6;
	
	public boolean LGTV;
	public boolean BoseSpeaker;
	public boolean PS5;
	
	public double LGTVusage;
	public double BoseSpeakerusage;
	public double PS5usage;
	
	public boolean alexa;
	public double alexausage;
	
	public Things() {
		BedRoom1Light = false;
		BedRoom2Light = false;
		KitchenLight = false;
		LivingRoomLight = false;
		BathRoomLight = false;
		FrontGardenLight = false;
		BackGardenLight = false;
		Usage = 0;
		
		BedRoom1Temp = false;
		BedRoom2Temp = false;
		KitchenTemp = false;
		LivingRoomTemp = false;
		BathRoomTemp = false;
		
		Random random = new Random();
        double randomNumber = 18.5 + (21 - 18.5) * random.nextDouble();
        
        BedRoom1 = randomNumber;
        BedRoom2 = randomNumber;
        Kitchen = randomNumber;
        LivingRoom = randomNumber;
        BathRoom = randomNumber;
		
		Camera1 = false;
		Camera2 = false;
		Camera3 = false;
		Camera4 = false;
		Camera5 = false;
		Camera6 = false;
		
		LGTV = false;
		BoseSpeaker = false;
		PS5 = false;
		LGTVusage = 0.00;
		BoseSpeakerusage = 0.00;
		PS5usage = 0.00;
		
		alexa = false;
		alexausage = 0.00;
	}
}

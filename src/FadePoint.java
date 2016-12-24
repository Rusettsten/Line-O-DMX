public class FadePoint implements Runnable {

	static int fadeSign;
	static long fadeAccess;
	static long fadeAccess2;
	static int fadePoint = 0;
	static int fadeChan = 0;
	static int fadePoint1 = 0;
	static int fadePoint2 = 0;
	static int fadePoint3 = 0;
	static int fadePoint4 = 0;
	static int fadePoint5 = 0;
	static int fadePoint6 = 0;
	static int fadePoint7 = 0;
	static int fadePoint8 = 0;
	static int fadePoint9 = 0;
	static long fadeTimer = 1;
	static long fadePause = 0;
	static float fadeGap1;
	static boolean fadeGapBool1;
	static boolean fadeGapBool2;
	static boolean fadeGapBool3;
	static boolean fadeGapBool4;
	static boolean fadeGapBool5;
	static boolean fadeGapBool6;
	static boolean fadeGapBool7;
	static boolean fadeGapBool8;
	static boolean fadeGapBool9;
	static float fadeGap2;
	static float fadeGap3;
	static float fadeGap4;
	static float fadeGap5;
	static float fadeGap6;
	static float fadeGap7;
	static float fadeGap8;
	static float fadeGap9;
	static int fadePointStage = 1;
	static float preciseDMXChanVar;
	
	public static void main() {
		
		System.out.println("FadePoint Loaded...");//System Message
		FadePoint obj = new FadePoint();
		Thread fadeThread = new Thread(obj);
		fadeThread.start();
		return;

	}

	public void run() {
    
		do{
			
				try {
					Thread.sleep(5);
				} catch (InterruptedException e1) {
					System.out.println("Oh jeez oh man oh jeez...");
					System.out.println("Failure to sleep main FadePoint thread.");
				}
			
			
			if(FadePoint.fadeAccess - 100 > FadePoint.fadeAccess2){ //Timer based on system-time for all fades
				
				if(FadePoint.fadePoint == 2){ //For 2 Point Fade
				
					try {
						FadePoint.twoPoint();
					} catch (InterruptedException e) {
						System.out.println("Oh jeez oh man oh jeez...");
						System.out.println("Failure to go to two point function.");
					}
					
				}else if(FadePoint.fadePoint == 3){
					
					try {
						FadePoint.threePoint();
					} catch (InterruptedException e) {
						System.out.println("Oh jeez oh man oh jeez...");
						System.out.println("Failure to go to three point function.");
					}
					
				}else if(FadePoint.fadePoint == 4){
					
					try {
						FadePoint.fourPoint();
					} catch (InterruptedException e) {
						System.out.println("Oh jeez oh man oh jeez...");
						System.out.println("Failure to go to four point function.");
					}
					
				}else if(FadePoint.fadePoint == 5){
					
					try {
						FadePoint.fivePoint();
					} catch (InterruptedException e) {
						System.out.println("Oh jeez oh man oh jeez...");
						System.out.println("Failure to go to five point function.");
					}
					
				}
				
			}
		
		

		FadePoint.fadeAccess = System.currentTimeMillis();
		
		}while(Main.dmxBool);

		
		
	}
	
	public static void fade(boolean fadeGapBool,float fadeGap, int fadePointTo){
		
		DMXReturns.dmxValueReturn(FadePoint.fadeChan); //Updates DMXChanVar
		
		if(fadeGapBool == true){ //Makes sure it goes in the right direction
				if(fadeGap>=1){ //This if/else makes sure if it's under 1, it just adds one.
					if((Main.DMXChanVar + fadeGap) > fadePointTo){//Makes sure it doesn't overdue the value
						Main.DMXChanVar =(int) (fadePointTo);
					}else{
						Main.DMXChanVar =(int)(Main.DMXChanVar + fadeGap);
					}
				}else{
					Main.DMXChanVar++;
				}
				DMXReturns.dmxIntFinder(FadePoint.fadeChan, Main.DMXChanVar);
			
		}else{
				if(fadeGap>=1){//This if/else makes sure if it's under 1, it just adds one.
					if((Main.DMXChanVar - fadeGap) < fadePointTo){//Makes sure it doesn't overdue the value
						Main.DMXChanVar =(int) (fadePointTo);
					}else{
						Main.DMXChanVar =(int)(Main.DMXChanVar - fadeGap);
					}
				}else{
					Main.DMXChanVar--;
				}
				DMXReturns.dmxIntFinder(FadePoint.fadeChan, Main.DMXChanVar);
			
		}
		
		
	}
	public static void twoPoint() throws InterruptedException{
		
		FadePoint.fadeAccess2 = System.currentTimeMillis();
		
		if(FadePoint.fadePointStage == 1){
			
			if(Main.DMXChanVar == FadePoint.fadePoint2){ //Makes sure it doesn't go past what it should
				FadePoint.fadePointStage = 2;
				FadePoint.preciseDMXChanVar = FadePoint.fadePoint2;
				Thread.sleep(FadePoint.fadePause);
			}else{
				FadePoint.fade(FadePoint.fadeGapBool1,FadePoint.fadeGap1,FadePoint.fadePoint2);
			}

		}else if(FadePoint.fadePointStage == 2){
			
			DMXReturns.dmxValueReturn(FadePoint.fadeChan); //Updates DMXChanVar
			
			if(Main.DMXChanVar == FadePoint.fadePoint1){ //Makes sure it doesn't go past what it should
				FadePoint.fadePointStage = 1;
				FadePoint.preciseDMXChanVar = FadePoint.fadePoint1;
				Thread.sleep(fadePause);
			}else{
				FadePoint.fade(FadePoint.fadeGapBool2,FadePoint.fadeGap2,FadePoint.fadePoint1);
			}
		}
		
	}
public static void threePoint() throws InterruptedException{
		
		FadePoint.fadeAccess2 = System.currentTimeMillis();
		
		if(FadePoint.fadePointStage == 1){
			
			if(Main.DMXChanVar == FadePoint.fadePoint2){ //Makes sure it doesn't go past what it should
				FadePoint.fadePointStage = 2;
				Thread.sleep(FadePoint.fadePause);
			}else{
				FadePoint.fade(FadePoint.fadeGapBool1,FadePoint.fadeGap1,FadePoint.fadePoint2);
			}

		}else if(FadePoint.fadePointStage == 2){
			
			DMXReturns.dmxValueReturn(FadePoint.fadeChan); //Updates DMXChanVar
			
			if(Main.DMXChanVar == FadePoint.fadePoint3){ //Makes sure it doesn't go past what it should
				FadePoint.fadePointStage = 3;
				Thread.sleep(fadePause);
			}else{
				FadePoint.fade(FadePoint.fadeGapBool2,FadePoint.fadeGap2,FadePoint.fadePoint3);
			}
		}else if(FadePoint.fadePointStage == 3){
			
			DMXReturns.dmxValueReturn(FadePoint.fadeChan); //Updates DMXChanVar
			
			if(Main.DMXChanVar == FadePoint.fadePoint1){ //Makes sure it doesn't go past what it should
				FadePoint.fadePointStage = 1;
				FadePoint.preciseDMXChanVar = FadePoint.fadePoint1;
				Thread.sleep(fadePause);
			}else{
				FadePoint.fade(FadePoint.fadeGapBool3,FadePoint.fadeGap3,FadePoint.fadePoint1);
			}
		}
		
	}

public static void fourPoint() throws InterruptedException{
	
	FadePoint.fadeAccess2 = System.currentTimeMillis();
	
	if(FadePoint.fadePointStage == 1){
		
		if(Main.DMXChanVar == FadePoint.fadePoint2){ //Makes sure it doesn't go past what it should
			FadePoint.fadePointStage = 2;
			Thread.sleep(FadePoint.fadePause);
		}else{
			FadePoint.fade(FadePoint.fadeGapBool1,FadePoint.fadeGap1,FadePoint.fadePoint2);
		}

	}else if(FadePoint.fadePointStage == 2){
		
		DMXReturns.dmxValueReturn(FadePoint.fadeChan); //Updates DMXChanVar
		
		if(Main.DMXChanVar == FadePoint.fadePoint3){ //Makes sure it doesn't go past what it should
			FadePoint.fadePointStage = 3;
			Thread.sleep(fadePause);
		}else{
			FadePoint.fade(FadePoint.fadeGapBool2,FadePoint.fadeGap2,FadePoint.fadePoint3);
		}
	}else if(FadePoint.fadePointStage == 3){
		
		DMXReturns.dmxValueReturn(FadePoint.fadeChan); //Updates DMXChanVar
		
		if(Main.DMXChanVar == FadePoint.fadePoint4){ //Makes sure it doesn't go past what it should
			FadePoint.fadePointStage = 4;
			Thread.sleep(fadePause);
		}else{
			FadePoint.fade(FadePoint.fadeGapBool3,FadePoint.fadeGap3,FadePoint.fadePoint4);
		}
	}else if(FadePoint.fadePointStage == 4){
		
		DMXReturns.dmxValueReturn(FadePoint.fadeChan); //Updates DMXChanVar
		
		if(Main.DMXChanVar == FadePoint.fadePoint1){ //Makes sure it doesn't go past what it should
			FadePoint.fadePointStage = 1;
			Thread.sleep(fadePause);
		}else{
			FadePoint.fade(FadePoint.fadeGapBool4,FadePoint.fadeGap4,FadePoint.fadePoint1);
		}
	}
	
}

public static void fivePoint() throws InterruptedException{
	
	FadePoint.fadeAccess2 = System.currentTimeMillis();
	
	if(FadePoint.fadePointStage == 1){
		
		if(Main.DMXChanVar == FadePoint.fadePoint2){ //Makes sure it doesn't go past what it should
			FadePoint.fadePointStage = 2;
			Thread.sleep(FadePoint.fadePause);
		}else{
			FadePoint.fade(FadePoint.fadeGapBool1,FadePoint.fadeGap1,FadePoint.fadePoint2);
		}

	}else if(FadePoint.fadePointStage == 2){
		
		DMXReturns.dmxValueReturn(FadePoint.fadeChan); //Updates DMXChanVar
		
		if(Main.DMXChanVar == FadePoint.fadePoint3){ //Makes sure it doesn't go past what it should
			FadePoint.fadePointStage = 3;
			Thread.sleep(fadePause);
		}else{
			FadePoint.fade(FadePoint.fadeGapBool2,FadePoint.fadeGap2,FadePoint.fadePoint3);
		}
	}else if(FadePoint.fadePointStage == 3){
		
		DMXReturns.dmxValueReturn(FadePoint.fadeChan); //Updates DMXChanVar
		
		if(Main.DMXChanVar == FadePoint.fadePoint4){ //Makes sure it doesn't go past what it should
			FadePoint.fadePointStage = 4;
			Thread.sleep(fadePause);
		}else{
			FadePoint.fade(FadePoint.fadeGapBool3,FadePoint.fadeGap3,FadePoint.fadePoint4);
		}
	}else if(FadePoint.fadePointStage == 4){
		
		DMXReturns.dmxValueReturn(FadePoint.fadeChan); //Updates DMXChanVar
		
		if(Main.DMXChanVar == FadePoint.fadePoint5){ //Makes sure it doesn't go past what it should
			FadePoint.fadePointStage = 5;
			Thread.sleep(fadePause);
		}else{
			FadePoint.fade(FadePoint.fadeGapBool4,FadePoint.fadeGap4,FadePoint.fadePoint5);
		}
	}else if(FadePoint.fadePointStage == 5){
		
		DMXReturns.dmxValueReturn(FadePoint.fadeChan); //Updates DMXChanVar
		
		if(Main.DMXChanVar == FadePoint.fadePoint1){ //Makes sure it doesn't go past what it should
			FadePoint.fadePointStage = 1;
			Thread.sleep(fadePause);
		}else{
			FadePoint.fade(FadePoint.fadeGapBool5,FadePoint.fadeGap5,FadePoint.fadePoint1);
		}
	}
	
}

}


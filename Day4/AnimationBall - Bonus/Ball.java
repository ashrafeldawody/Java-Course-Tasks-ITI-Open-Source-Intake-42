import java.util.Random;

class Ball implements Runnable {  
	Thread t;
	static Ball balls[] = new Ball[40];
	static int NumberOfBalls = 0;
	int currentX, currentY;
	int offsetX, offsetY;
	int maxX = 600, maxY = 400;
	Boolean shouldDuplicate = false;
	public Ball(int x, int y,int offsetX,int offsetY){
		NumberOfBalls++;
		currentX = x;
		currentY = y;
		this.offsetX = offsetX;
		this.offsetY = offsetY;
		t = new Thread(this);
    	t.start();
	}

	public void startMoving(){
		if ((currentX + offsetX < 0) || (currentX + 50 + offsetX > maxX)) {
			offsetX = -offsetX;
			shouldDuplicate = true;
		}
      	if ((currentY + offsetY < 0) || (currentY + 50 + offsetY > maxY)){
		  	offsetY = -offsetY;
			shouldDuplicate = true;
		}

	  	currentX += offsetX;
      	currentY += offsetY;
		if(shouldDuplicate){
			Random rn = new Random();
			createBall(currentX, currentY,offsetX + rn.nextInt(10) + 1, offsetY + rn.nextInt(10) + 1);
			shouldDuplicate = false;
		}
	} 
	
	public void run() {
		while (true) {
			startMoving();
			  try {
				Thread.sleep(30);
			  } catch (Exception e) {
				System.out.println(e);
			  };
		}
	}
	public static void createBall(int x, int y,int offsetx,int offsety){
		if(NumberOfBalls < 40){
			balls[NumberOfBalls] = new Ball(x,y,offsetx,offsety);
		}

	}

}  
package com.Frogger.Model;

public class Level {

	private static final int SPACE = 50;
	private static final Actor[] LEVEL1 = new Actor[] {
			
		//street row 1
		new Obstacle(500,SPACE*13 +1,"long blue truck")
			
			/*new MovingActor("file:res/Obstacles/whitetruckright.png",0, 655 , 95, 1,false),
			new MovingActor("file:res/Obstacles/whitetruckright.png",300, 655 , 95, 1,false),
			
			
			new MovingActor("file:res/Obstacles/car1Left.png", 0, 615, 45, -1, true),
			new MovingActor("file:res/Obstacles/car1Left.png", 100, 615, 45, -1, true),
			new MovingActor("file:res/Obstacles/car1Left.png", 200, 615, 45, -1, true),
			new MovingActor("file:res/Obstacles/car1Left.png", 300, 615, 45, -1, true)*/
	};
	
	private static final Actor[] LEVEL2 = new Actor[] {
			
	
			
			
	};
	
	private static final Actor[] LEVEL3 = new Actor[] {
			
	};
	
	private static final Actor[] LEVEL4 = new Actor[] {
			
	};
	
    public static Actor[] getGameLevel(int level) {
        switch (level) {
            case 1:
                return LEVEL1;
            case 2:
                return LEVEL2;

            default:
                return null;
        }
    }
 }

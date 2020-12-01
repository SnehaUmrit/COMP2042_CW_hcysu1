package model;

/**
 * 
 * @author hcysu1
 * Class that creates arrays of type Actor for the different levels
 * Allows us to add the classes that inherits Actor class
 * Obstacle (x position, y position, obstacle name, speed)
 * WetTurtle (x position, y position, speed)
 * Log(x position, y position, width, speed)
 * Snake(x position, y position, speed)
 * 
 */
public class Level {
	
	private static final int START_Y = 719;
	private static final int START_X = 300;
	/**
	 * Creating a static array of type actor named LEVEL1
	 * To generate Level 1 obstacles 
	 * Level 1 has four lanes of traffic
	 * Level 1 has five streams of river
	 * Level 1 has bonus insects appearing randomly
	 */
	private static final Actor[] LEVEL1 = new Actor[] {
		
			
		
		/*//street row 1
		new Obstacle(0,645,"long blue truck",1),	
		new Obstacle(500,645,"long blue truck",1),
		
		//street row 2
		new Obstacle(100,585,"normal car",-1),
		new Obstacle(250,585,"normal car",-1),
		new Obstacle(400,585,"normal car",-1),
		new Obstacle(550,585,"normal car",-1),
		
		//street row 3
		new Obstacle(0,510,"short white truck",1),
		new Obstacle(300,510,"short white truck",1),
		new Obstacle(600,510,"short white truck",1),
		
		//street row 4
		new Obstacle(400,445,"race car",-3),
		new Obstacle(500,445,"race car",-3),
				
		//Level 1 - No snake on median*/
		
		//river row 1
		new WetTurtle(200,310,-1),
		new WetTurtle(400,310,-1),
		new WetTurtle(600,310,-1),
		
		//river row 2
		new Log(0,268,150,0.75),
		new Log(220,268,150,0.75),
		new Log(880,268,150,0.75),
		
		//river row 3
		new Log(0,210,300,-2),
		new Log(400,210,300,-2),
		
		//river row 4
		new WetTurtle(0,163,-1),
		new WetTurtle(200,163,-1),
		new WetTurtle(400,163,-1),

		//river row 5
		new Log(0,120,300,0.75),
		new Log(400,120,300,0.75),
		
		new Animal(START_X,START_Y)
		
	};
	
	
	/**
	 * Creating an array of type Actor named LEVEL2
	 * LEVEL2 has four lanes of traffic
	 * In level2, a snake appear on the median
	 * LEVEL2 has five streams of river
	 * LEVEL 2 has bonus insects appearing randomly
	 */
	private static final Actor[] LEVEL2 = new Actor[] {
			
			
			//street row 1
			new Obstacle(0,645,"long blue truck",1),	
			new Obstacle(500,645,"long blue truck",1),
			
			//street row 2
			new Obstacle(100,585,"normal car",-1),
			new Obstacle(250,585,"normal car",-1),
			new Obstacle(400,585,"normal car",-1),
			new Obstacle(550,585,"normal car",-1),
			
			//street row 3
			new Obstacle(0,510,"short white truck",1),
			new Obstacle(300,510,"short white truck",1),
			new Obstacle(600,510,"short white truck",1),
			
			//street row 4
			new Obstacle(400,445,"race car",-3),
			new Obstacle(500,445,"race car",-3),
			
			//Appearance of snake on median
			new Snake(200,367,-1),
			
			//river row 1
			new WetTurtle(200,310,-1),
			new WetTurtle(400,310,-1),
			new WetTurtle(600,310,-1),
			
			//river row 2
			new Log(0,268,150,0.75),
			new Log(220,268,150,0.75),
			new Log(880,268,150,0.75),
			
			//river row 3
			new Log(0,210,300,-2),
			new Log(400,210,300,-2),
			
			//river row 4
			new WetTurtle(0,163,-1),
			new WetTurtle(200,163,-1),
			new WetTurtle(400,163,-1),

			//river row 5
			new Log(0,120,300,0.75),
			new Log(400,120,300,0.75),
			
			
			new Animal(START_X,START_Y)
	};
	
		
	/**
	 * Creating an array of type Actor named LEVEL3
	 * LEVEL3 has bonus insects appearing randomly
	 * LEVEL3 has five lanes of traffic
	 * LEVEL3 has fives streams of river
	 * LEVEL3 has crocodiles appearing randomly at the ends
	 */
	private static final Actor[] LEVEL3 = new Actor[] {
		
			//street row 1
			new Obstacle(0,660,"long blue truck",1),	
			new Obstacle(500,660,"long blue truck",1),
			
			//street row 2
			new Obstacle(100,610,"normal car",-1),
			new Obstacle(250,610,"normal car",-1),
			new Obstacle(400,610,"normal car",-1),
			new Obstacle(550,610,"normal car",-1),
			
			//street row 3
			new Obstacle(0,525,"tractor",1),
			new Obstacle(300,525,"tractor",1),

			
			//street row 4
			new Obstacle(400,465,"race car",-4),
			
			//street row 5
			new Obstacle(0,410,"short white truck",1),
			new Obstacle(300,410,"short white truck",1),
			new Obstacle(600,410,"short white truck",1),

			//Safe Median
			
			//river row 1
			new WetTurtle(200,310,-1),
			new WetTurtle(400,310,-1),
			new WetTurtle(600,310,-1),
			
			//river row 2
			new Log(0,268,150,0.75),
			new Log(220,268,150,0.75),
			new Log(880,268,150,0.75),
			
			//river row 3
			new Log(0,210,300,-2),
			new Log(400,210,300,-2),
			
			//river row 4
			new WetTurtle(0,163,-1),
			new WetTurtle(200,163,-1),
			new WetTurtle(400,163,-1),

			//river row 5
			new Log(0,120,300,0.75),
			new Log(400,120,300,0.75),
			
			new Animal(START_X,START_Y)
			
			
			
	};
	
	
	/**
	 * Creating an array of type Actor named LEVEL4
	 * Level 4 has fives lanes of traffic
	 * Level 4 has five streams of river
	 * Level 4 has a crocodile that appears randomly at the end
	 * Level 4 has a crocodile that in the river stream
	 */
	private static final Actor[] LEVEL4 = new Actor[] {
			
			//street row 1
			new Obstacle(0,660,"long blue truck",1),	
			new Obstacle(500,660,"long blue truck",1),
			
			//street row 2
			new Obstacle(100,610,"normal car",-1),
			new Obstacle(250,610,"normal car",-1),
			new Obstacle(400,610,"normal car",-1),
			new Obstacle(550,610,"normal car",-1),
			
			//street row 3
			new Obstacle(0,525,"tractor",1),
			new Obstacle(300,525,"tractor",1),

			
			//street row 4
			new Obstacle(400,465,"race car",-4),
			
			//street row 5
			new Obstacle(0,410,"short white truck",1),
			new Obstacle(300,410,"short white truck",1),
			new Obstacle(600,410,"short white truck",1),
			
			//Safe Median
			
			//river row 1
			new WetTurtle(200,310,-1),
			new WetTurtle(400,310,-1),
			new WetTurtle(600,310,-1),
			
			//river row 2
			new Log(0,268,150,0.75),
			new Log(220,268,150,0.75),
			new Log(880,268,150,0.75),
			
			//river row 3
			new Log(0,210,300,-2),
			new Log(400,210,300,-2),
			
			//river row 4
			new WetTurtle(0,163,-1),
			new WetTurtle(200,163,-1),
			new WetTurtle(400,163,-1),

			//river row 5
			new Log(0,120,300,0.75),
			new Log(360,120,150,0.75),
			new UnsafeCrocodile(600,105,0.75),
			
			new Animal(START_X,START_Y)
			
	};
	
	/**
	 * Creating an array of type Actor named LEVEL5
	 * Level 5 has five lanes of traffic
	 * Level 5 has a snake that appears on the median
	 * Level 5 has a crocodile that in the rive
	 * Level 5 has a crocodile that appears randomly at each end
	 */
	private static final Actor[] LEVEL5 = new Actor[] {
			
			//street row 1
			new Obstacle(0,660,"long blue truck",1),	
			new Obstacle(500,660,"long blue truck",1),
			
			//street row 2
			new Obstacle(100,610,"normal car",-1),
			new Obstacle(250,610,"normal car",-1),
			new Obstacle(400,610,"normal car",-1),
			new Obstacle(550,610,"normal car",-1),
			
			//street row 3
			new Obstacle(0,525,"tractor",1),
			new Obstacle(300,525,"tractor",1),

			
			//street row 4
			new Obstacle(400,465,"race car",-4),
			
			//street row 5
			new Obstacle(0,410,"short white truck",1),
			new Obstacle(300,410,"short white truck",1),
			new Obstacle(600,410,"short white truck",1),
			
			//Appearance of snake on median
			new Snake(200,367,-1),
			
			//river row 1
			new WetTurtle(200,310,-1),
			new WetTurtle(400,310,-1),
			new WetTurtle(600,310,-1),
			
			//river row 2
			new Log(0,268,150,0.75),
			new Log(220,268,150,0.75),
			new Log(880,268,150,0.75),
			
			//river row 3
			new Log(0,210,300,-2),
			new Log(400,210,300,-2),
			
			//river row 4
			new WetTurtle(0,163,-1),
			new WetTurtle(200,163,-1),
			new WetTurtle(400,163,-1),

			//river row 5
			new Log(0,120,300,0.75),
			new Log(360,120,150,0.75),
			new UnsafeCrocodile(600,105,0.75),
			
			new Animal(START_X,START_Y)
			
			
			
	};
	
    public static Actor[] getGameLevel(int level) {
        switch (level) {
            case 1:
                return LEVEL1;
            case 2:
                return LEVEL2;
            case 3:
            	return LEVEL3;
            case 4:
            	return LEVEL4;
            case 5:
            	return LEVEL5;

            default:
                return null;
        }
    }
 }

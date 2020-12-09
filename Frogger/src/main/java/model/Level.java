package model;

/**
 * 
 * New class that creates arrays of type Actor for the different levels. <p>
 * Allows us to add the classes that inherits Actor class. <br>
 * Obstacle (x position, y position, obstacle name, speed) <br>
 * WetTurtle (x position, y position, speed) <br>
 * Log (x position, y position, width, speed) <br>
 * Snake (x position, y position, speed) <br>
 * UnsafeCrocodile (x position, y position, speed)<br>
 * Level 1 to 5 have four lanes of traffic while the remaining levels have five lanes of traffic.
 * All of the game levels have five streams in the river each with different elements.
 * The snake appears only on levels 2,4,5,7,8,9 and 10.
 * This crocodile appears only on levels 4,5,8,9 and 10.
 * @author hcysu1
 * 
 */
public class Level {
	
	private static final int START_Y = 719;
	private static final int START_X = 300;
	/**
	 * Creating a static array of type actor named LEVEL1.
	 * To generate Level 1 obstacles. 
	 * Level 1 has four lanes of traffic.
	 * Level 1 has five streams of river.
	 * Level 1 has bonus insects appearing randomly.
	 * Fairly Easy Level.
	 */
	private static final Actor[] LEVEL1 = new Actor[] {

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
				
		//Level 1 - No snake on median
		
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
	 * LEVEL3 has four lanes of traffic
	 */
	private static final Actor[] LEVEL3 = new Actor[] {
			
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
	 * Level 4 has four lanes of traffic
	 */
	private static final Actor[] LEVEL4 = new Actor[] {
			
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
			new Log(360,120,150,0.75),
			new UnsafeCrocodile(600,105,0.75),
			
			new Animal(START_X,START_Y)
			
	};
	
	/**
	 * Creating an array of type Actor named LEVEL5
	 * Set elements of level 5
	 */
	private static final Actor[] LEVEL5 = new Actor[] {
			
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
			new Log(360,120,150,0.75),
			new UnsafeCrocodile(600,105,0.75),
			
			new Animal(START_X,START_Y)
			
			
			
	};
	
	/**
	 * Level 6 has five lanes of traffic
	 */
	private static final Actor[] LEVEL6 = new Actor[] {
			
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
	 * Level7 has five lanes of traffic with a snake
	 */
	private static final Actor[] LEVEL7 = new Actor[] {
			
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
			new Log(400,120,300,0.75),
			
			new Animal(START_X,START_Y)
			
			
			
			
	};
	
	/**
	 * Level 8 has five levels of traffic with varying speeds and crocodiles at the end
	 */
	private static final Actor[] LEVEL8 = new Actor[] {
			
			//street row 1
			new Obstacle(0,660,"long blue truck",1.5),	
			new Obstacle(500,660,"long blue truck",1.5),
			
			//street row 2
			new Obstacle(100,610,"normal car",-1),
			new Obstacle(250,610,"normal car",-1),
			new Obstacle(400,610,"normal car",-1),
			new Obstacle(550,610,"normal car",-1),
			
			//street row 3
			new Obstacle(0,525,"tractor",1),
			new Obstacle(300,525,"tractor",1),

			
			//street row 4
			new Obstacle(400,465,"race car",-5),
			
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
	 * Level 9 has a five levels of traffic, a snake in the median, and crocodiles
	 */
	private static final Actor[] LEVEL9 = new Actor[] {
			
			//street row 1
			new Obstacle(0,660,"long blue truck",1.5),	
			new Obstacle(500,660,"long blue truck",1.5),
			
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
			new Snake(200,367,-2),
			
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
	 * Level 10 is the most difficult level as there is a greater chance for the player to lose the game
	 */
	private static final Actor[] LEVEL10 = new Actor[] {
			
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
			new Obstacle(400,465,"race car",-5),
			
			//street row 5
			new Obstacle(0,410,"short white truck",1),
			new Obstacle(300,410,"short white truck",1),
			new Obstacle(600,410,"short white truck",1),
			
			//Appearance of snake on median
			new Snake(200,367,-2),
			
			//river row 1
			new WetTurtle(200,310,-1),
			new WetTurtle(400,310,-1),
			new WetTurtle(600,310,-1),
			
			//river row 2
			new Log(0,268,150,0.75),
			new UnsafeCrocodile(300,259,0.75),
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
			new UnsafeCrocodile(380,105,0.75),
			new UnsafeCrocodile(600,105,0.75),
			
			new Animal(START_X,START_Y)
	};
	
	
	/**
	 * 
	 * @param level The level number
	 * @return elements of specified level
	 */
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
            case 6:
            	return LEVEL6;
            case 7:
            	return LEVEL7;
            case 8:
            	return LEVEL8;
            case 9:
            	return LEVEL9;
            case 10:
            	return LEVEL10;

            default:
                return null;
        }
    }
 }

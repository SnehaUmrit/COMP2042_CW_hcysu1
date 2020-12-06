# Frogger (Classic Retro Game)
This report provides a summary on the major refactorings and additions made from the [given](https://github.com/hirish99/Frogger-Arcade-Game) codes for the Software Maintenance Coursework. 


## Gradle Run
In order to run the Frogger application from the command line, the following steps can be followed:
1. Open command prompt and change the directory to where the files have been downloaded.
2. Run the application using the command "gradle run".

```
 > cd "Path of files"
```

``` 
 > gradle run
```


## Major Refactorings and Extensions
**1. Rearranging the classes and resources**

The classes that were previously all in one package have been arranged into meaningful packages using the MVC pattern. The resources have also been arranged into different folders namely 'Background', 'Buttons', 'Font', 'Logo', 'Music', 'Obstacles' and 'Sprites'. This allows us to easily identify the numerous resources and easily set the path. 


**2. Using Model View Controller Pattern**

The MVC pattern has been used to arrange the classes. The Model handles data and represents the game objects. It also allows us to update the controller of the data changes. The Controller controls the data flow into model object and update the view whenever data changes. The view is responsible for rendering the data received from the model.

**3. Fixing background image and adding new ones**

The background image was fixes to allow us to set the timer and the number of player lives, as well as indication for the score and level during the game. In order to make the game more interesting different types of obstacles were added such as the snake, crocodiles, and also different images for the vehicles.

**4. Actor class, Intersecting Object class and AnimatedObject class**

Considerable changes has been made to the Actor class to support the idea of single responsibility. A constructor is now being used to set the x and y position of the actor. The Actor class also extends the IntersectingObject class that allows us to implement methods to check the intersection between the frog and other game elements. The AnimatedObject class extends the Actor class and primarily allows us to set the animation of the different game elements at different speeds.
  
**5. Replacing AnimationTimer **

Timeline is now used in GameController class to control animation of the different game elements. This allows us to incorporate the events that can be triggered during the timeline play.

**6. Game Levels**

This game has a total of 10 distinct levels.  A level class is created to set the elements of each level. This is done by creating arrays of type Actor for each level and using a switch case to return the level elements that are initialised in each array based on the level number. This allows us to set distinct speed for the various objects. The difficulty increases from level 1 to level 10 making the first level the easiest to complete and the last level the most challenging. 


Levels 1 to 5 have four lanes of traffic and also have bonus insects that appear randomly and help the player gain more points. Levels 2, 4, 7, 8, 9 and 10 have snake appearing randomly based on the appearance ratio set in the Snake class. The speed of the obstacles vary from level to level. Some levels have crocodile appearing at the ends while other levels have crocodiles appearing in the river.

**7. Player Lives**

The player is allocated a total of 6 lives at the beginning of the game for all the ten levels. The lives of the player is represented using pictures of hearts. The lives of the player is set using setter and getter methods in LivesController class. The LivesController class uses LivesView to display the hearts on the game pane. A method is also used in LivesController that allows us to remove an object which in this case is the last image in the array of type ImageView. 

**8. Game Timer**

A progress bar is also added to the game and is used as a game timer. This allows the player to gain extra points if the end is reached before the timer ends. The TimeController class is used to set the number of seconds for the timer to end. This is done by creating an object of the TimeView class which imports the ProgressBar and Timeline classes from the javafx library. ProgressBar visualizes  the progress as a completion bar. Timeline has the capability to update the completion seconds along the progression of time. 

**9. Score System**

The ScoreController class is used to set the path of the CSV file that stores the game scores. The controller class uses ScoreView class as it allows the updated score to be displayed on the game pane. The ScoreController class also uses the ScoreModel class to call the read method. 

**10. Game Bonus**

A new class known as the Insect class in added as a model. The Insect class extends the IntersectingObject class. An additional 50 points is given if the frog intersects the insect.




## Amended File Structure

``` 
src
|
|-- main
|	|-- java
|	|	|-- controller
|	|	|	|-- AudioController
|	|	|	|-- EndController
|	|	|	|-- GameController
|	|	|	|-- LevelController
|	|	|	|-- LivesController
|	|	|	|-- MenuController
|	|	|	|-- ScoreController
|	|	|	|__ TimeController
|	|	|
|	|	|-- model
|	|	|	|-- Actor
|	|	|	|-- Animal
|	|	|	|-- AnimatedObject
|	|	|	|-- BackgroundImage
|	|	|	|-- End
|	|	|	|-- Insect
|	|	|	|-- IntersectingObject
|	|	|	|-- Level
|	|	|	|-- Log
|	|	|	|-- Obstacle
|	|	|	|-- SafeCrocodile
|	|	|	|-- ScoreBoardInput
|	|	|	|-- ScoreModel
|	|	|	|-- Snake
|	|	|	|-- Turtle
|	|	|	|-- UnsafeCrocodile
|	|	|	|__ WetTurtle
|	|	|
|	|	|-- controller
|	|	|	|-- AudioController
|	|	|	|-- EndController
|	|	|	|-- GameController
|	|	|	|-- LevelController
|	|	|	|-- LivesController
|	|	|	|-- MenuController
|	|	|	|-- ScoreController
|	|	|	|__ TimeController
|	|	|
|	|	|__ game
|	|	
|	|__ resources	
|	
|-- test
	|-- java
	|__ resources

```


## Screenshots of Game
**Frogger Menu**

<img src="https://www.linkpicture.com/q/froggerMenu.png" width="300" height="400">



**Frogger Level 10**

<img src="https://www.linkpicture.com/q/level10.png" width="300" height="400">


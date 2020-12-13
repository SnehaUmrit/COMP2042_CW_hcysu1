# Frogger (Classic Retro Game)
This report provides a summary on the major refactorings and additions made from the [given](https://github.com/hirish99/Frogger-Arcade-Game) codes for the Software Maintenance Coursework. 


## Gradle Run

**Pre-requisite : Java 10 or Newer**

A build file is added as it automatically downloads and configures the dependencies and other libraries used. Gradle Wrapper allows us to run the build file without installing Gradle. When we invoke "gradlew", it downloads and builds the Gradle version specified. 
In order to run the Frogger application from the command line, the following steps can be followed:
1. Open command prompt and change the directory to where the **build.gradle** file is found.
2. Run the application using the command "gradlew run".

```
 > cd "C:\Users\<Admin_Name>\<Folder_Name>\Umrit_Sneha_Eclipse_15\Frogger\Frogger"
```

``` 
 > gradlew run
```


## Major Refactorings
**1. Rearranging the classes and resources**

Classes that were previously all in one package have been arranged using the MVC pattern. The resources have also been arranged into a resources folder which is further divided into meaningful folders. Allows easy identification of the numerous resources and easily set the path. 


**2. Using Model View Controller Pattern**

The MVC pattern has been used to arrange the classes. The Model handles data and represents the game objects. It also allows us to update the controller of the data changes. The Controller controls the data flow into model object and update the view whenever data changes. The view is responsible for rendering the data received from the model.

**3. Actor class, Intersecting Object class and AnimatedObject class**

Considerable changes has been made to the Actor class to support the idea of single responsibility. The Actor class extends IntersectingObject class which allows us to implement methods to verify the intersection between the frog and the other game elements. The AnimatedObject class extends the Actor class and primarily allows us to set the animation of the different game elements at different speeds. 

**4. Replacing AnimationTimer**

TimeLine is used in GameController class to control animation of the different game elements. This allows us to incorporate the events that can be triggered during the timeline play.

**5. Animal Class**

Extends Animated Object class as this allows us to set the states for the frog's animation quicker. Also uses PauseTransition in order to determine a key release instead of the previously used setOnKeyRelease method thus optimising the codes. 

**6. Main Class**

Modified to initialise the main stage using MenuController class.

**7. Fixing game background**

Fixed in order to add the timer and the number of player lives, as well as indication for the score and level.

**8. Obstacle class**

Used to set the path for the images of the obstacles instead of setting it when the object is called. This makes it easier as there is no need to set the image path repeatedly.

**9. Allocation of Score**

Previously a forward move would get the player 50 points, however this has been changed as several other game elements have been added that allows the player to gain points. Thus a forward move now only contribute to a single score.

**10. End Class**

Modified to allow us to implement an end with a crocodile. Using methods to check whether the end is safe or unsafe depending on the presence of a crocodile and also check whether an end is active or inactive depending on the presence of the frog. The crocodile appear at the ends only in levels 3,5,7,9 and 10.




## Major Extensions

**1. Game Levels**

This game has a total of 10 distinct levels.  A level class is created to set the elements of each level. This is done by creating arrays of type Actor for each level and using a switch case to return the level elements that are initialised in each array based on the level number. This allows us to set distinct speed for the various obstacles present.

**2. Game Menu and SubScenes**

The class MenuController has been added which uses ButtonView, SubSceneView and LabelView to add and maintain the menu elements. MenuController class also controls the actions to be taken when the buttons are pressed. Has help and score button which when pressed gives the instruction and rankings respectively. Uses TranslateTransition  with a set duration to make the appearance of the sub-scenes subtle and more interactive.

**3. Game Lives**

The player is allocated a total of 5 lives at the beginning of the game for all the ten levels. The lives of the player is represented using an array of images and are accessed using setter and getter methods. The LivesController class uses LivesView to display the hearts on the game pane. The game ends if there are no lives left.

**4. Game Timer**

A progress bar is also added to the game and is used as a game timer. This allows the player to gain extra points if the end is reached before the timer ends. The TimeController class is used to set the number of seconds for the timer to end. This is done by creating an object of the TimeView class which imports the ProgressBar and TimeLine classes from the JavaFX library. ProgressBar visualizes  the progress as a completion bar. TimeLine has the capability to update the completion seconds along the progression of time. 

**5. Game Audio**

AudioController class has been added as it allows us to set different sound snippets depending on the player's action. 

**6. Using CSV file to store scores**

ScoreController class is used to set the path of the CSV file that stores the game scores. The controller class uses ScoreView class as it allows the updated score to be displayed on the game pane. The ScoreController class also uses the ScoreModel class to call the read method. 

**7. Insect and PurpleFrog Classes**

Both classes extend IntersectingObject. An additional 50 points is given if the frog intersects the insect. The insect only appears on levels 1,2 and 5 while purple frog appears on levels 3,6 and 8. If the player intersects the purple frog and reaches the end safely, 200 points will be allocated to the player.

**8. Snake class**

Extends AnimatedObject. It allows us to implement methods that check the intersection between the frog and the snake which leads to a loss of life. The snake appears only on levels 2,4,5,7,8,9 and 10.

**9. Crocodile classes**

Two classes have been added namely SafeCrocodile which extends AnimatedObject and UnsafeCrocodile which extends the SafeCrocodile class. The crocodile is safe when its mouth is closed and can be used as a safe ride to cross the river. However if the frog steps on a crocodile with an open mouth, a life will be lost. These crocodiles appear on levels 4,5,8,9 and 10.

**10. Home button**

A button has been added in the game pane that allows us to return to the menu screen any time during the game. This is done by closing the current stage and initialising the menu stage.


## Reflections

After making the changes, it can be deduced that it is now better to manage the classes as well as the relationships between them while also improving encapsulation. The classes have been made more maintainable and we can easily add more game obstacles or levels. The game has also been made more interesting with the varying audio and different levels with better graphics. There are also several test classes that have been implemented to check the proper functionality of several elements.


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
|	|	|	|-- PurpleFrog
|	|	|	|-- Obstacle
|	|	|	|-- SafeCrocodile
|	|	|	|-- ScoreBoardInput
|	|	|	|-- ScoreModel
|	|	|	|-- Snake
|	|	|	|-- Turtle
|	|	|	|-- UnsafeCrocodile
|	|	|	|__ WetTurtle
|	|	|
|	|	|-- view
|	|	|	|-- ButtonView
|	|	|	|-- GameView
|	|	|	|-- LabelView
|	|	|	|-- LevelView
|	|	|	|-- LivesView
|	|	|	|-- ScoreView
|	|	|	|-- SubSceneView
|	|	|	|__ TimeView
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
**Frogger Menu, Help SubScene and Score SubScene**

<p float="left">
  <img src=https://www.linkpicture.com/q/froggerMenu_1.png width="300" height="400" />
  <img src=https://www.linkpicture.com/q/helpSubScene.png width="300" height="400"/> 
  <img src=https://www.linkpicture.com/q/scoreSubScene_1.png width="300" height="400"/>
</p>


**Level 1, Level 5 and Level 10**

<p float="left">
  <img src=https://www.linkpicture.com/q/level1.png width="300" height="400" />
  <img src=https://www.linkpicture.com/q/level5.png width="300" height="400"/> 
  <img src=https://www.linkpicture.com/q/level10_1.png width="300" height="400"/>
</p>

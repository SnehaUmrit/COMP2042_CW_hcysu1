# Frogger (Classic Retro Game)
This report provides a summary on the major refactorings and additions made from the [given](https://github.com/hirish99/Frogger-Arcade-Game) codes for the Software Maintenance Coursework. 


## Gradle Run
A build file is added as it automatically downloads and configures the dependencies and other libraries used. Several other tasks can also be carried out when using gradle such as running all the test classes or generating the javadocs. 
In order to run the Frogger application from the command line, the following steps can be followed:
1. Open command prompt and change the directory to where the files have been downloaded.
2. Run the application using the command "gradle run".

```
 > cd "Path of files"
```

``` 
 > gradle run
```


## Major Refactorings
**1. Rearranging the classes and resources**

The classes that were previously all in one package have been arranged using the MVC pattern. The resources have also been arranged into a resources folder which is further divided into meaningful folders namely 'Background', 'Buttons', 'Font', 'Logo', 'Music', 'Obstacles' and 'Sprites'. This allows us to easily identify the numerous resources and easily set the path. 


**2. Using Model View Controller Pattern**

The MVC pattern has been used to arrange the classes. The Model handles data and represents the game objects. It also allows us to update the controller of the data changes. The Controller controls the data flow into model object and update the view whenever data changes. The view is responsible for rendering the data received from the model.

**3. Actor class, Intersecting Object class and AnimatedObject class**

Considerable changes has been made to the Actor class to support the idea of single responsibility. The Actor class now extends IntersectingObject class which allows us to implement methods to verify the intersection between the frog and the other game elements. The AnimatedObject class extends the Actor class and primarily allows us to set the animation of the different game elements at different speeds. 

**4. Replacing AnimationTimer**

Timeline is now used in GameController class to control animation of the different game elements. This allows us to incorporate the events that can be triggered during the timeline play.

**5. Animal Class**

Animal class now extends Animated Object class as this allows us to set the states for the frog's animation much quicker and without any glitches. Animal class also uses PauseTransition in order to determine a key release instead of the previously used setOnKeyRelease method thus optimising the codes. 

**6. Main Class**

The main class has been modified as it is only used to initialise the main stage using MenuController class.

**7. Fixing game background**

The background image was fixed to allow us to add the timer and the number of player lives, as well as indication for the score and level during the game. 

**8. Obstacle class**

The Obstacle class is now used to set the path for the images of the obstacles instead of setting it when the object is called. This makes it easier as there is no need to set the image path repeatedly.

**9. Allocation of Score**

Previously a forward move would get the player 50 points, however this has been changed as several other game elements have been added that allows the player to gain points. Thus a forward move now only contribute to a single score.

**10. End Class**

The End class has been modified to allow us to implement an end with a crocodile. Using methods to check whether the end is safe or unsafe depending on the presence of a crocodile. It is also possible to check whether an end is active or inactive depending on the presence of the frog. The crocodile appear at the ends only in levels 3,5,7,9 and 10.

**11. Alert Messages**
Alert messages are shown when the game ends, thereby showing the player's score and also letting them know if they have won the game or not.


## Major Extensions

**1. Game Levels**

This game has a total of 10 distinct levels.  A level class is created to set the elements of each level. This is done by creating arrays of type Actor for each level and using a switch case to return the level elements that are initialised in each array based on the level number. This allows us to set distinct speed for the various obstacles present.

**2. Game Menu**

The class MenuController has been added which uses ButtonView, SubSceneView and LabelView to add and maintain the menu elements. MenuController class also controls the actions to be taken when the buttons are pressed. 

**3. Game Lives**

The player is allocated a total of 5 lives at the beginning of the game for all the ten levels. The lives of the player is represented using an array of images. The lives are accessed using setter and getter methods in LivesController class. The LivesController class uses LivesView to display the hearts on the game pane. A method is also used in LivesController that allows us to remove an object which in this case is the last image in the array of type ImageView. This method is called whenever the frog dies and a life is removed. The game ends if there are no lives left.

**4. Game Timer**

A progress bar is also added to the game and is used as a game timer. This allows the player to gain extra points if the end is reached before the timer ends. The TimeController class is used to set the number of seconds for the timer to end. This is done by creating an object of the TimeView class which imports the ProgressBar and Timeline classes from the javafx library. ProgressBar visualizes  the progress as a completion bar. Timeline has the capability to update the completion seconds along the progression of time. 

**5. Game Audio**

AudioController class has been added as it allows us to set different sound snippets depending on the player's action. There also is a separate music for the menu that runs on loop. Once the game is started, the menu audio stops and if the player moves using the W,A,S,D keys then a movement audio is heard. This is done by constantly rewinding those snippets after they have been played so that they can be played again. There are also different snippets for car death and water death. A cheerful snippet is played when the frog reaches the end. 

**6. Using CSV file to store scores**

The ScoreController class is used to set the path of the CSV file that stores the game scores. The controller class uses ScoreView class as it allows the updated score to be displayed on the game pane. The ScoreController class also uses the ScoreModel class to call the read method. 

**7. Insect class**

An Insect class has been added that extends IntersectingObject class. An additional 50 points is given if the frog intersects the insect. The insect only appears on levels 1,2 and 5.

**8. Snake class**

A snake class has been added that extends AnimatedObject. It allows us to implement methods that check the intersection between the frog and the snake which leads to a loss of life. The snake appears only on levels 2,4,5,7,8,9 and 10.

**9. Adding crocodile classes**

Two classes have been added namely SafeCrocodile which extends AnimatedObject and UnsafeCrocodile which extends the SafeCrocodile class. The crocodile is safe when its mouth is closed and can be used as a safe ride to cross the river. However if the frog steps on a crocodile with an open mouth, a life will be lost. This crocodile appears only on levels 4,5,8,9 and 10.

**10. PurpleFrog class**

A new class has been added to set the attributes and implements methods for the purple frog. This class extends IntersectingObject. If the player intersects the purple frog and reaches the end safely, 200 points will be allocated to the player.

**11. Home button**

A button has been added in the game pane that allows us to return to the menu screen any time during the game. This is done by closing the current stage and initialising the menu stage.

**12. SubScenes**
When the help button found in the game menu is pressed, a subscene appears that shows instructions on how the game should be played. When the score button is pressed, a subscene showing the best five scores is shown. Using TranslateTransition  with a set duration to make the appearance of the subscenes subtle and more interactive.




## Reflections

After making the changes, it can be deduced that it is now better to manage the classes as well as the relationships between them while also improving encapsulation. The classes have been made more maintenable and we can easily add more game obstacles or levels. The game has also been made more interesting with the varying audio and different levels with better graphics. There are also several test classes that have been implemented to check the proper functionality of several elements.


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

# Frogger (Classic Retro Game)



## Major Refactorings and Extensions
1. Rearranging the classes and resources
The classes that were previously all in one package have been arranged into meaningful packages using the MVC pattern. The resources have also been arranged into different folders namely 'Background', 'Buttons', 'Font', 'Logo', 'Music', 'Obstacles' and 'Sprites'. This allows us to easily identify the numerous resources and easily set the path.

2. Using Model View Controller Pattern
The MVC pattern has been used to arrange the classes. The Model handles data and represents the game objects. It also allows us to update the controller of the data changes. The Controller controls the data flow into model object and update the view whenever data changes. The view is responsible for rendering the data received from the model.

3. The Model Package


4. The Controller Package


5. The View Package

3. Fixing background image and adding new ones.
The background image was fixes to allow us to set the timer and the number of player lives, as well as indication for the score and level during the game. In order to make the game more interesting different types of obstacles were added such as the snake, crocodiles, and also different images for the vehicles.

4. Actor class, Intersecting Object class and AnimatedObject class
Considerable changes has been made to the Actor class to support the idea of single responsibility. A constructor is now being used to set the x and y position of the actor. The Actor class also extends the IntersectingObject class that allows us to implement methods to check the intersection between the frog and other game elements. The AnimatedObject class extends the Actor class and primarily allows us to set the animation of the different game elements at different speeds.
 
 
5. Replacing AnimationTimer


6. Game Levels
This game has a total of 10 distinct levels. This allows us to make the game more interesting. A level class is created to set the elements of each level. This is done by creating arrays of type Actor for each level and using a switch case to return the level elements that are initialised in each array. This allows us to set distinct speed for the various objects. The difficulty increases from level 1 to level 10 making the first level the easiest to complete and the last level the most challenging. Levels 1 to 5 have four lanes of traffic and also have bonus insects that appear randomly and help the player gain more points. Levels 2, 4, 7, 8, 9 and 10 have snake appearing randomly based on the appearance ratio set in the Snake class. The speed of the obstacles vary from level to level. Some levels have crocodile appearing at the ends while other levels have crocodiles appearing in the river.

7. Player Lives



8. Game Timer

9. Score System

10. Game Bonus

11. 


## File Structure

###### Using MVC Pattern


## Gradle Run
In order to run the Frogger application from the command line, the following steps can be followed:
1. Open command prompt.
2. Change the directory to where the files have been downloaded.
3. Run the application using the command "gradle run".

```
 >cd "Path of files"
```

``` 
 >gradle run
```

## Screenshots of Game
![alt text](https://raw.githubusercontent.com/hirish99/Frogger-Arcade-Game/master/arcade.png)



File Structure

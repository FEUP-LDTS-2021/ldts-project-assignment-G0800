# LDTS_T08_G0800 - DONKEY KONG

## Game Description
DONKEY KONG is played as Mario (the jumping man) and the goal is to rescue the Princess from Donkey Kong (the big monkey) by climbing up the existing ladders and structures (the set of platforms), avoid the moving barrels and fire creatures. The player (Mario) is controlled with the Keyboard Arrows.

This project was developed by Gabriel Machado Jr. (up2020060@edu.fe.up.pt), Milena Gouveia (up202008862@edu.fe.up.pt) and Sofia Moura (up201907201@edu.fe.up.pt) for LDTS 2021⁄22.

## Design Patterns
For now, in this project we applied as a main pattern, the **_Architectural Pattern_**, more specifically the Model-View-Controller style which is commonly used in a GUI. But in this delivery the Controller is still not implemented.

Besides the Architectural Pattern, we also applied the **_Factory Method Pattern_** by defining the game element as an abstract superclass for all game elements, and separating the elements by dynamic ones and static ones, letting these subclasses be responsible to create the instance of the class.

Last but not least, the **_Builder Pattern_** was used to create Structures and Ladder, because they both use the object Stair.

## Implemented Features
Mario has a score that increases every time he jumps over a barrel or gets a hammer.

### PLANNED FEATURES
- **GUI:** At this moment, the output of the arena is done by using some special symbols such as ‘!’, ‘*’. ‘+’, etc but we plan on using FontForge software to create a font that represents each element of the game.
- **Movement:** We would also like to change the x and y fields of the Position class to float type, so we can have a more realistic movement of the dynamic elements.
- **Connected Menus:** The user has the capability of browsing through the different menus including in game ones. (Ex: Main Menu, Instructions, Play, Shop and Pause).
- **Buttons:** Functional and interactive buttons.
- **Player control:** The player may move with the keyboard arrows and break the barrels with a hammer when the space bar is pressed.
- **Collisions detection:** Collisions between different objects are verified. (Ex: Mario, FireEnemy, Barrels, Ladder, Structure).
- **More levels:** 5 different levels with an increasing difficulty were implemented.
- **Animations:** Several animations are incorporated in this game, from barrel breaking to level loading, etc.

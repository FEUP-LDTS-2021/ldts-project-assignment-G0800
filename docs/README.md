# LDTS_T08_G0800 - DONKEY KONG

## Game Description
DONKEY KONG is played as Mario (the jumping man) and the goal is to rescue the Princess from Donkey Kong (the big monkey) by climbing up the existing ladders and structures (the set of platforms), avoid the moving barrels and fire creatures. The player (Mario) is controlled with the Keyboard Arrows.

**How to play**

You can move the character using
- `Left arrow` to move left
- `Right arrow` to move right
- `Up arrow` to climb ladders
- `Tab` to jump over barrels and fire enemies


- Mario can only walk on top of the structures
- Mario has a score that increases every time he jumps over a barrel or gets a hammer
- Mario can hit barrels or fire enemies every time he grabs the hammer, in a total of 5 hits

This project was developed by Gabriel Machado Jr. (up202008860@edu.fe.up.pt), Milena Gouveia (up202008862@edu.fe.up.pt) and Sofia Moura (up201907201@edu.fe.up.pt) for LDTS 2021⁄22.

## Design Patterns
**Architectural Pattern**

<img src="docs/images/mvc.png"/>

To approach the way the game is built, we decided to implement the MVC (Model-Viewer-Controller) design pattern:

- Model: stores and represents all the structures of the game and does nothing else. It doesn't depend on the controller or the viewer
- Controller: connects the model and the user interaction by commanding all the changes that occur.
- Viewer (gui): outputs the representation of the model's data and handles the interaction with the user (by pressing the keyboard's keys)

Why we decided to use it:
- easier for simultaneous development
- better testability because supports TDD
- easily modifiable
- easy planning and maintenance


**Abstract Factory Pattern**

//meter aqui screenshot do uml

Participating classes: 

Why we decided to use it:
- it isolates clients from implementation classes (defining the game element as an abstract superclass for all game elements, and separating the elements by dynamic ones and static ones, letting these subclasses be responsible to create the instance of the class)

**Builder Pattern**

//screenshot do uml

Participating classes:

Why we decided to use it:
- allows to vary a product's internal representation (Structure and Ladder both use Stair)

**States Pattern**

//screenshot uml

Participating classes:

Why we decided to use it:
- minimizes conditional complexity, eliminating the need for if and switch statements in objects that have different behavior requirements unique to different state transitions


## Implemented Features
- Starting menu
- Super Mario Movement
- Ladders and Structures
- Hammer
- Moving enemies with different movements (barrels and fire enemies)



### Tetris

<p align="center">
  <strong>Welcome to the Tetris project! This README will give you a    quick overview of the project's content and features.</strong>
</p>

## Project Overview
<div style="text-align: justify">
  The Tetris project is a simplified implementation of the famous       Tetris game, developed in Java as part of an Object-Oriented          Programming course. This project was designed to practice object-     oriented programming concepts and Java programming through a          concrete example.
</div>

## Project Contents
**bin/:** This directory contains the binary files generated after compiling the source code.

**source/**: This directory contains the source code of the Tetris application. Here, you'll find classes and packages organized to implement the game's functionalities.

**test/:** This directory contains unit test files to test different parts of the source code.

**README.md:** You are currently reading the project's README file, which provides general information and instructions to get started.

## Game Rules
<div style="text-align: justify">
  The rules of the Tetris game are simple. A piece, composed of four elements, is randomly chosen from seven possible shapes. Once selected, the piece falls into a well under the force of gravity. During its descent, the player can manipulate the piece by moving it left or right or by rotating it clockwise or counterclockwise.
  
  When a piece reaches the bottom of the well, it becomes immobile, and its elements are added to a stack of elements at the bottom of the well. If a piece touches an element of the stack, its elements are also added to the stack.
  
  When the elements of a piece form a horizontal line crossing the well, the line is cleared, the player scores points, and the elements above the cleared line move down.

  If the stack reaches the top of the well, the game ends.
</div>

## My Implementation
This project will allow you to create a simplified version of the Tetris game, where two types of pieces (the I and O pieces) fall into a well and are controlled by the player using their mouse. The stack will build up based on the fallen pieces.

## Model-View-Controller (MVC) Architecture
The Model-View-Controller (MVC) architecture model has existed since the early days of Smalltalk. It provides a high-level classification of different types of objects in an application and defines their roles.

**Model Objects:** Represent the data and basic functionalities of the application.

**View Objects:** Present the data to the user and may allow for modifications.

**Controller Objects:** Ensure communication between Model and View objects.

This architecture promotes separation of concerns and improves code reusability and maintainability.

## Getting Started

If you want to explore the source code or test the Tetris game, follow these simple steps:

1. Clone this repository to your local machine.
2. Open the project in your preferred Java development environment.
3. Explore the source files to understand the Tetris game implementation.
4. Run the application to play the Tetris game on your computer.

## Java Version
This project is recommended to be developed using Java version 11.

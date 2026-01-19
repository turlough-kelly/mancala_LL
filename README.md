# Mancala - a board game made in Java using Linked Lists

What is Mancala?
- 



Mancala is a board game about picking up stones and putting them down somewhere else. The premise is simple:

- You have 6 pockets, as well as a "home" - called a mancala - where you deposit your stones.
- The opposite player also has 6 pockets and a mancala, with each player's mancala being on their right.
- There are 48 stones on the board; your goal is to capture the most stones. Once stones are in your mancala, they are 
permenantly removed from play.
- The game ends when one player has no stones in any of their pockets when it is their turn.

How does a turn work?
-

First, you pick one of your 6 pockets that are not empty and pick up all the stones.
Starting with the pocket to the right of your chosen pocket, you drop a stone and move on to the next.
- If you pass over your own mancala, you place a stone in there. If you pass your opponent's mancala, you skip it.

There are some plays that can occur when you make a move.
- If the last stone you have lands in your mancala, you take another turn.
- If the last stone lands in an empty pocket on your side, you move that stone and all stones in the opposite pocket on 
your opponent's side to your mancala.

Why did I choose Mancala?
-

Growing up with Club Penguin, a game by Screenhog and RocketSnail created circa 2005, I was alwasys obssessed with this
game, even if it was really difficult to little me! As I got older, I found a greater appreciation for the game, and I
found that it was the perfect project to create to add to my portfolio for both me and future employers.

Any future plans?
-
Yes! This is currently a text-based verison of Mancala, played within CMD. My plan is to use this as a basis to learn 
Spring (and maybe Springboot) and create a full application out of this.

At present, the game is designed for two players only, but I would like to add a CPU to allow a single player to play on their own, but this is something that will be revisited when the game is complete, so that I can design it around the game's core functions.


# Running this application

To run this application simply download the files and run the Main file in your IDE of choice. When it is fully done, I 
plan to create it's own file that can be executed in CMD.

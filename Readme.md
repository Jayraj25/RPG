## Role Playing Game

## Overview
The project is about creating a Role-playing game which is based on turn by turn. In this game, Players
go against each other in the battlefield or arena. The winner of this 
battle tend to depend upon the abilities of the players, the gear that they have at their disposal, 
and, a little bit, on their luck. Here, luck is based on the randomness introduced in the program.

## Features
1. Player 1 attacks using the weapon that they have in-hand by taking a swing at player 2 who tries to avoid the attack. If player 1 hits player 2, then player 2 potentially takes damage.
2. Player 2 attacks using the weapon that they have in-hand by taking a swing at player 1 who tries to avoid the attack. If player 2 hits player 1, then player 1 potentially takes damage.
3. Turns continue back and forth until one of the players has taken total damage that is greater than or equal to their health.
4. A player has 4 different abilities:
   1. **Strength** affects how effective the player is at striking their opponent.
   2. **Constitution** affects how much damage a player can take when they are hit in battle.
   3. **Dexterity** affects how effective the player is at avoiding a strike from their opponent.
   4. **Charisma** affects how their opponent views them.
5. Each player ability is determined randomly by rolling four 6-sided dice, re-rolling any 1s, and then adding together the highest 3 values resulting in a value between 6 and 18.
6. Players' abilities can be temporarily affected, either positively or negatively, by the gear that they use. The available gears are **HeadGear**, **Footwear**, **Belts (Small, Medium, Large)** and Potions.
7. The player can wield a sword, an axe, or a flail as their weapon of choice.
   1. **Two Handed Sword**: Damage range (8-12).
   2. **Broad Sword**: Damage range (6-10).
   3. **Katanas**: Damage range (4-6).
   4. **Axes**: Damage range (6-10).
   5. **Flails**: Damage range (8-12).
8. Players equip themselves from a bag of equipment that contains a minimum of 5 items of headgear, 5 items of footwear, 15 belts, and 15 potions. When players equip themselves from the bag, they are randomly assigned 20 items from the bag. Any item that is randomly assigned must be used unless it cannot be combined with what the player is already using. 25% of the items that are in the bag will diminish the player's ability rather than enhance it.
9. Players request weapon from the armory.
10. A player's health is calculated to be the sum of their 4 abilities. Players start a battle with full health.
11. Striking power is the sum of the strength of the player, any of the gear that adds (or substracts) from strength, and a random number between 1 and 10 (inclusive).
12. Avoidance ability is the sum of the dexterity of the player, any of the gear that adds (or subtracts) from dexterity, and a random number between 1 and 6 (inclusive).
13. If the striking power of the attacking player is greater than the avoidance ability of their opponent, the attacking player successfully strikes their opponent and the damage must be calculated.
14. The potential striking damage is calculated by adding the strength of the attacking player to a random value in the range of the damage that their weapon can inflict (if they have a weapon).
15. The actual damage is the potential striking damage minus the constitution of their opponent. 
16. If the actual damage is greater than 0, it is subtracted from the player's health.

## How to run

### Option 1
- Directly double click on .jar file provided you have Java runtime environment.

### Option 2:
- Download the .jar file from the project result folder
- open terminal
- locate your .jar file from terminal using
```sh
cd %usersDirectory%
java -jar %filename%.jar
```

### Option 3
- Open the project in intellij
- Locate the Driver class in the src directory and open the Driver class file
- Here, right click on the class name "Driver" and click 'Run Driver.main()'


## How to use the program

This project requires Java Runtime environment installed on the user's PC to run and build successfully.
- Open the Driver class and create two player objects p1 and p2.
- Instantiate Battle arena and pass two players in the battle model.
- Set the properties for both the players using setProperties method from player class.
- Equip the gears from the battle arena for both the players.
- After equipping gears make the changes in player's ability caused due to equipment of gears.
- Generate the armory in the battle arena using armory interface.
- Equip the players with a weapon from the armory.
- Create a while loop which runs until the total health of one of the player is less than or equal to 0.
- Check if the game is over using isGameOver method from battle arena and print the winner.

## Description of Examples

- The battle takes place between two players 'Tom' and 'Jerry'. In the Run1 txt file, Tom is the winner and in Run2 txt file Jerry is the winner.
  - In Run1 file initially, the two players are created with their basic abilities and their basic abilities is printed.
  - Next, 20 gears are assigned to each player randomly from a bag of equipments and these equipments are printed.
  - The list of gears are also printed in sorted order.
  - Then, the player's updated abilities are printed as they are affected by the gears.
  - Then, a weapon is assigned to each player from the armory and is printed.
  - The initial total health of the players are computed and shown before the battle starts.
  - Then, the battle starts.
  - Once the battle starts, details like the name of the player who takes the strike and name of the player whose turn is to defend are shown with the striking power of attacker and avoidance ability of the defender.
  - Once, the strike is done, the round winner and actual damage caused are printed along with the total health of each player.
  - These details are printed until a winner is found.
  - Once, the winner is found, it is printed with total health of both the players after the game is over.
  - After this, a rematch option is also provided where user have to answer 'N' for no and 'Y' for yes.

## Design Changes
There were major design changes as in my original design, I did not implement a union data type, didn't had interface for weapons and gears.
Also, armory and BagOfEquipments interface and classes were not created. In original design, I thought of using players as enums, but realized that was not good design choice.
So finally, I have Weapon and Gear interface and abstract class respectively. Also, I have created armory and bag interface along with classes.
Additionally, some enumerations, Player Model and Battle model are also created as a part of design change.

## Assumptions
- My bag of equipments and armory are created as the user wants i.e. the user is independent of deciding how big the bag and armory they want. They can pass the number of gears abd number of individual weapons they need in bag and armory respectively.
- I have assumed that Katanas always comes in pairs and so the damage of two katanas is in the range of 8-12 rather than 4-6 of individual Katana.
- I have assumed that Headgear always affects constitution by 5 units positively.
- Footwear always affects dexterity by 4 units positively.
- Small Belts affects Constitution by 3 units positively and 1 unit dexterity negatively.
- This affect is multiplied by two if medium belt and by 4 if large belt.
- When Potions are created, a random value is assigned to each player's ability and therefore, each potion affects all the player's abilities.

## Limitations
- If after equipping gears, the ability goes below zero, it has not been handled.
- The battle never ends in a draw or is stalemate.

## Citations
https://cnx.org/contents/QCsgrcAf@37.6:YCGmE3x9@11/Union-Design-Pattern-Inheritance-and-Polymorphism
https://www.opentextbooks.org.hk/ditatopic/8182
https://www.journaldev.com/1392/factory-design-pattern-in-java
https://www.geeksforgeeks.org/implement-interface-using-abstract-class-in-java/
https://www.w3schools.com/java/java_abstract.asp
https://www.geeksforgeeks.org/enum-in-java/
https://careerkarma.com/blog/java-enum/
https://www.javatpoint.com/java-hashmap
https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html

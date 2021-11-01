import battleground.ArmoryProducer;
import battleground.BattleModel;
import gear.Gear;
import gear.GearCategory;
import numbergenerator.GenerateRandomNumber;
import player.Player;
import player.PlayerGenerator;
import weapon.Weapon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Driver class to run the program.
 * */
public class Driver {
  /**
   * The main method for driver class.
   * @param args Command line arguments
   * */
  public static void main(String[] args) throws IllegalAccessException {

    GenerateRandomNumber r = new GenerateRandomNumber();

    boolean rematch = true;
    System.out.println("Welcome to Kal's Battle arena.");
    System.out.println("--------------------------------------");
    while (rematch) {
      Player p1 = new PlayerGenerator(new PlayerGenerator("Tom",r));
      Player p2 = new PlayerGenerator(new PlayerGenerator("Jerry",r));

      p1.setProperties();

      p2.setProperties();
      System.out.println(p1.getPlayerName() + ": " + p1.getAbilitiesMap());
      System.out.println(p2.getPlayerName() + ": " + p2.getAbilitiesMap());

      BattleModel battleModel = new BattleModel(new BattleModel(p1,p2));
      battleModel.equipGears(p1);
      battleModel.equipGears(p2);

      List<Gear> p1TempGears = p1.getEquippedGears();
      List<Gear> p2TempGears = p2.getEquippedGears();
      List<String> p1Gears = new ArrayList<>();
      List<String> p2Gears = new ArrayList<>();

      for (Gear s : p1TempGears) {
        if (s.getGearCategory().equals(GearCategory.BELT)) {
          p1Gears.add(s.getName() + "(" + s.getBeltType() + ")");
        }
        else {
          p1Gears.add(s.getName());
        }
      }

      for (Gear s : p2TempGears) {
        if (s.getGearCategory().equals(GearCategory.BELT)) {
          p2Gears.add(s.getName() + "(" + s.getBeltType() + ")");
        }
        else {
          p2Gears.add(s.getName());
        }
      }

      System.out.println("\n" + p1.getPlayerName() + ":\n" + p1Gears);
      System.out.println("Sorted order:\n" + p1.sortGears());
      System.out.println("\n" + p2.getPlayerName() + ":\n" + p2Gears);
      System.out.println("Sorted order:\n" + p2.sortGears());
      p1.makeChangesInAbilities();
      p2.makeChangesInAbilities();

      System.out.println("\nAfter equipping gears, " + p1.getPlayerName() + ": \n"
              + p1.getAbilitiesMap());
      System.out.println("\nAfter equipping gears, " + p2.getPlayerName() + ": \n"
              + p2.getAbilitiesMap());

      ArmoryProducer a = new ArmoryProducer(new ArmoryProducer(
              4,6,4, 7,5));
      List<Weapon> armory = a.generateArmory();
      p1.equipWeapon(armory);
      p2.equipWeapon(armory);
      System.out.println("===================================");
      System.out.println(p1.getPlayerName() +  "'s Weapon: " + p1.getWeaponEquippedType());
      System.out.println(p2.getPlayerName() + "'s Weapon: " + p2.getWeaponEquippedType());
      System.out.println("===================================");
      System.out.println("Initial Health:");
      System.out.println(p1.getPlayerName() + ": " + p1.getPlayerHealth());
      System.out.println(p2.getPlayerName() + ": " + p2.getPlayerHealth());
      System.out.println("\nBattle Starts.");
      System.out.println("-----------------------------------");
      while (p1.getPlayerHealth() > 0 && p2.getPlayerHealth() > 0) {
        List<String> temp = battleModel.makeMove();
        String nameAttacker = temp.get(0);
        String nameDefender = temp.get(1);
        System.out.println(nameAttacker + "'s turn to attack.");
        System.out.println(nameDefender + "'s turn to defend.");
        String attackerStrikingPower = temp.get(2);
        String defenderAvoidanceAbility = temp.get(3);
        String roundWinner = temp.get(4);
        System.out.println(nameAttacker + "'s striking power is: " + attackerStrikingPower);
        System.out.println(nameDefender + "'s avoidance ability is: " + defenderAvoidanceAbility);
        System.out.println(roundWinner + " is the round winner.");
        System.out.println("The actual damage is: " + temp.get(5));
        System.out.println("Player's health after round " + battleModel.getTrackRounds() + ":");
        System.out.println(p1.getPlayerName() + "'s health: " + p1.getPlayerHealth());
        System.out.println(p2.getPlayerName() + "'s health: " + p2.getPlayerHealth());
        System.out.println("===================================");
      }
      if (battleModel.isGameOver()) {
        System.out.println("The game is over after " + battleModel.getTrackRounds() + " rounds.");
        System.out.println(p1.getPlayerName() + "'s health: " + p1.getPlayerHealth());
        System.out.println(p2.getPlayerName() + "'s health: " + p2.getPlayerHealth());
        Player x = null;
        try {
          x = battleModel.getWinner();
        } catch (IllegalStateException e) {
          e.printStackTrace();
        }
        assert x != null;
        System.out.println("The winner is: " + x.getPlayerName());
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Do you want a rematch [Y/N]:");
        String temp = myObj.nextLine().trim();
        if (temp.equalsIgnoreCase("N")) {
          rematch = false;
        }
      }
      else {
        System.out.println("The game is over.");
      }
    }


  }
}

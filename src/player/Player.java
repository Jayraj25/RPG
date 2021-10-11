package player;

import numbergenerator.GenerateRandomNumber;

import java.util.Arrays;

/**
 * Creates the player for the battle.
 * */
public class Player {

  private final int playerID;
  private int strength;
  private int constitution;
  private int dexterity;
  private int charisma;
  private final GenerateRandomNumber g;

  /**
   * Constructs a player.
   * @param g the type of random generator to be used
   * */
  public Player(int ID, GenerateRandomNumber g) {
    this.playerID = ID;
    this.g = g;
  }

  /**
   * Create the attributes of the player.
   * */
  public void setProperties() {
    this.strength = generateProperty();
    this.charisma = generateProperty();
    this.constitution = generateProperty();
    this.dexterity = generateProperty();
  }

  private int generateProperty() {
    int[] arr = new int[4];
    int result = 0;
    for (int i = 0; i < 4; i++) {
      arr[i] = rollDice(g);
    }
    Arrays.sort(arr);
    for (int i = 1; i < 4; i++) {
      result += arr[i];
    }
    return result;
  }

  public void setStrength(int strength) {
    this.strength = strength;
  }

  public void setConstitution(int constitution) {
    this.constitution = constitution;
  }

  public void setDexterity(int dexterity) {
    this.dexterity = dexterity;
  }

  public void setCharisma(int charisma) {
    this.charisma = charisma;
  }

  private int rollDice(GenerateRandomNumber g) {
    int temp = g.getRandomNumber(1,6);
    while (temp < 2) {
      temp = g.getRandomNumber(1,6);
    }
    return temp;
  }

  public int getPlayerID() {
    return playerID;
  }

  public int getStrength() {
    return strength;
  }

  public int getConstitution() {
    return constitution;
  }

  public int getDexterity() {
    return dexterity;
  }

  public int getCharisma() {
    return charisma;
  }

  @Override
  public String toString() {
    return String.format("(Strength: %d, Constitution: %d, Dexterity: %d, Charisma: %d)",
            this.strength,this.constitution,this.dexterity,this.charisma);
  }
}

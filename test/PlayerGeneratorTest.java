import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import battleground.ArmoryProducer;
import battleground.Bag;
import battleground.BagOfEquipments;
import battleground.BattleModel;
import gear.Gear;
import numbergenerator.GenerateRandomNumber;
import player.Player;
import player.PlayerGenerator;
import weapon.Weapon;
import weapon.WeaponTypes;

import static org.junit.Assert.assertEquals;

/**
 * Test the player class with all of its functionalities
 */
public class PlayerGeneratorTest {

  GenerateRandomNumber g = new GenerateRandomNumber(7);
  Player p = new PlayerGenerator("Scorpion",g);
  Player p2 = new PlayerGenerator("Vince",g);
  BattleModel battleModel = new BattleModel(p,p2);

  @Before
  public void setUp() {
    p.setProperties();
  }

  @Test
  public void getPlayerID() {
    assertEquals("Scorpion",p.getPlayerName());
  }

  @Test
  public void getStrength() {
    assertEquals(14,p.getStrength());
  }

  @Test
  public void getConstitution() {
    assertEquals(16,p.getConstitution());
  }

  @Test
  public void getDexterity() {
    assertEquals(11,p.getDexterity());
  }

  @Test
  public void getCharisma() {
    assertEquals(13,p.getCharisma());
  }

  @Test
  public void testToString() {
    assertEquals("(Strength: 14, Constitution: 16, Dexterity: 11, Charisma: 13)",
            p.toString());
  }

  @Test
  public void testDefaultWeaponBeforeBattleStarts() {
    assertEquals(WeaponTypes.BARE_HANDS,p.getWeaponEquipped());
  }

  /**
   * Accessing the gear list before assigning the gears.
   */
  @Test (expected = IllegalStateException.class)
  public void testEquippedGears() {
    p.getEquippedGears();
  }

  @Test
  public void testEquippedGearsList() {
    Bag bag = new BagOfEquipments(7,7,
            23,43);
    battleModel.equipGears(p);
    battleModel.equipGears(p2); //seed 4 in player model
    List<Gear> gearList = p.getEquippedGears();
    List<String> assignedGearNames = new ArrayList<>();
    for (Gear g: gearList) {
        assignedGearNames.add(g.getName());
    }
    String[] expected = new String[]{"Belt 9", "Potion 34", "Potion 4", "Potion 17", "Potion 39",
            "Belt 18", "Potion 10", "Footwear 2", "Potion 38", "Potion 26", "HeadGear 3",
            "Potion 36", "Potion 33", "Potion 21", "Potion 16", "Potion 7", "Potion 22",
            "Potion 20", "Potion 23", "Potion 43"};

    List<String> temp = Arrays.asList(expected);
    assertEquals(temp,assignedGearNames);
  }

  @Test
  public void testGearsSortedOrder() {
    Bag bag = new BagOfEquipments(7,7,
            23,43);
    battleModel.equipGears(p);
    battleModel.equipGears(p2); //seed 4 in player model
    List<Gear> gearList = p.getEquippedGears();
    List<String> actual = p.sortGears();
    String[] expected = new String[]{"HeadGear 3", "Potion 4", "Potion 7", "Potion 10", "Potion 16",
            "Potion 17", "Potion 20", "Potion 21", "Potion 22", "Potion 23", "Potion 26",
            "Potion 33", "Potion 34", "Potion 36", "Potion 38", "Potion 39", "Potion 43",
            "Belt 9", "Belt 18", "Footwear 2"};

    List<String> temp = Arrays.asList(expected);
    assertEquals(temp,actual);
  }

  /**
   * Equipping weapon with empty armory.
   */
  @Test (expected = IllegalStateException.class)
  public void testEquipWeaponBeforeWithEmptyArmory() {
    List<Weapon> armory = new ArrayList<>();
    p.equipWeapon(armory);
  }

  @Test
  public void getWeaponEquipped() {
    ArmoryProducer a = new ArmoryProducer(5,5,
            5,5,5);
    List<Weapon> armory = a.generateArmory();
    p.equipWeapon(armory);
    assertEquals(WeaponTypes.BROADSWORD,p.getWeaponEquipped()); //seed 4 in player model class
  }
}
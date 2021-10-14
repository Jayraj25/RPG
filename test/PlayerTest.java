import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import battleground.Armory;
import gear.Gear;
import numbergenerator.GenerateRandomNumber;
import player.Player;
import weapon.Weapon;
import weapon.WeaponTypes;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

  GenerateRandomNumber g = new GenerateRandomNumber(7);
  Player p = new Player(3,g);

  @Before
  public void setUp() {
    p.setProperties();
  }

  @Test
  public void getPlayerID() {
    assertEquals(3,p.getPlayerID());
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
  @Test (expected = IllegalAccessException.class)
  public void testEquippedGears() throws IllegalAccessException {
    p.getEquippedGears();
  }

  @Test
  public void testEquippedGearsList() throws IllegalAccessException {
    p.equipGears();
    List<Gear> gearList = p.getEquippedGears();
    List<String> assignedGearNames = new ArrayList<>();
    for (Gear g: gearList) {
        assignedGearNames.add(g.getName());
    }
    List<String> temp = new ArrayList<>() {
      {
        add("P16");add("B13");add("B12");add("P18");add("P8");add("FW2");add("B22");
        add("HG5");add("B1");add("B9");add("P22");add("P14");add("P28");add("FW6");
        add("B18");add("P12");add("B3");add("P13");add("P7");add("B14");
      }
    };
    assertEquals(temp,assignedGearNames);
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
    Armory a = new Armory();
    List<Weapon> armory = a.generateArmory();
    p.equipWeapon(armory);
    assertEquals(WeaponTypes.BARE_HANDS,p.getWeaponEquipped());
  }
}
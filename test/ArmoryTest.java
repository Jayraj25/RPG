import battleground.Armory;
import battleground.ArmoryProducer;
import weapon.Weapon;

import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;

import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;


/**
 * Test the functions of armory like armory creation and minimum valid weapons allowed, etc.
 */
public class ArmoryTest {

  Armory a;

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void testArmoryCreation() {
    assertEquals("Armory created successfully",new ArmoryProducer(new ArmoryProducer(
            2,2,2,2,2)).toString());
  }

  @Test (expected = IllegalArgumentException.class)
  public void testMinAxeInArmory() {
    new ArmoryProducer(new ArmoryProducer(
            2,2,2,0,1));
    thrown.expectMessage("There should be at least one weapon of each type.");
  }

  @Test (expected = IllegalArgumentException.class)
  public void testMinFlailInArmory() {
    new ArmoryProducer(new ArmoryProducer(
            2,2,2,2,0));
    thrown.expectMessage("There should be at least one weapon of each type.");
  }

  @Test (expected = IllegalArgumentException.class)
  public void testMinKatanaInArmory() {
    new ArmoryProducer(new ArmoryProducer(
            0,2,2,5,1));
    thrown.expectMessage("There should be at least one weapon of each type.");
  }

  @Test (expected = IllegalArgumentException.class)
  public void testMinTwoHandedSwordInArmory() {
    new ArmoryProducer(new ArmoryProducer(
            2,2,0,3,1));
    thrown.expectMessage("There should be at least one weapon of each type.");
  }

  @Test (expected = IllegalArgumentException.class)
  public void testMinBroadSwordInArmory() {
    new ArmoryProducer(new ArmoryProducer(
            2,0,3,3,1));
    thrown.expectMessage("There should be at least one weapon of each type.");
  }

  @Test
  public void generateArmory() {
    a = new ArmoryProducer(new ArmoryProducer(2,2,
            1,1,1));
    List<Weapon> temp = a.generateArmory();
    List<String> actual = new ArrayList<>();
    for (Weapon w : temp) {
      actual.add(w.getTypeOfWeapon().toString());
    }
    List<String> expected = new ArrayList<>() {
      {
        add("Katana");
        add("Katana");
        add("Bare Hands");
        add("Bare Hands");
        add("Bare Hands");
        add("Broad Sword");
        add("Broad Sword");
        add("Two Handed Swords");
        add("Axe");
        add("Flail");
      }
    };
    assertEquals(expected,actual);
  }
}
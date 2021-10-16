import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import battleground.Armory;
import battleground.ArmoryProducer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class ArmoryTest {

  Armory a;

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void testArmoryCreation() {
    assertEquals("Armory created successfully",new ArmoryProducer(
            2,2,2,2,2).toString());
  }

  @Test (expected = IllegalArgumentException.class)
  public void testMinAxeInArmory() {
    new ArmoryProducer(
            2,2,2,0,1);
    thrown.expectMessage("There should be at least one weapon of each type.");
  }

  @Test (expected = IllegalArgumentException.class)
  public void testMinFlailInArmory() {
    new ArmoryProducer(
            2,2,2,2,0);
    thrown.expectMessage("There should be at least one weapon of each type.");
  }

  @Test (expected = IllegalArgumentException.class)
  public void testMinKatanaInArmory() {
    new ArmoryProducer(
            0,2,2,5,1);
    thrown.expectMessage("There should be at least one weapon of each type.");
  }

  @Test (expected = IllegalArgumentException.class)
  public void testMinTwoHandedSwordInArmory() {
    new ArmoryProducer(
            2,2,0,3,1);
    thrown.expectMessage("There should be at least one weapon of each type.");
  }

  @Test (expected = IllegalArgumentException.class)
  public void testMinBroadSwordInArmory() {
    new ArmoryProducer(
            2,0,3,3,1);
    thrown.expectMessage("There should be at least one weapon of each type.");
  }

  @Test
  public void generateArmory() {
  }
}
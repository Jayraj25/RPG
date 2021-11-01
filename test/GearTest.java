import gear.Gear;
import gear.GearCategory;
import gear.GearFactory;
import player.PlayerAbilities;

import java.util.HashMap;
import java.util.Map;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

/**
 * Test regarding gears like checking for null values, getting how the gear affects ability,
 * creation of gears, testing the type of gear, etc.
 */
public class GearTest {

  GearFactory gf = new GearFactory();
  Gear headGear = gf.createGears("Head protector", GearCategory.HEADGEAR);
  Gear footWear = gf.createGears("Speed booster", GearCategory.FOOTWEAR);
  Gear belt = gf.createGears("Body protector", GearCategory.BELT);
  Gear potion = gf.createGears("Spider's Blood", GearCategory.POTION);

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test (expected = NullPointerException.class)
  public void testNullGearCreation() {
    gf.createGears("asd",null);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testBullGearName() {
    gf.createGears(null,GearCategory.POTION);
    thrown.expectMessage("Gear name cannot be null");
  }

  @Test
  public void testHeadGearCreation() {
    assertEquals("Headgear created successfully.",
            gf.createGears("HG 1",GearCategory.HEADGEAR).toString());
  }

  @Test
  public void testFootwearCreation() {
    assertEquals("Footwear created successfully.",
            gf.createGears("Foot SD",GearCategory.FOOTWEAR).toString());
  }

  @Test
  public void testPotionCreation() {
    assertEquals("Potion created successfully.",
            gf.createGears("PotionPQ",GearCategory.POTION).toString());
  }

  @Test
  public void testBeltCreation() {
    assertEquals("Belt created successfully.",
            gf.createGears("Belt AB",GearCategory.BELT).toString());
  }

  @Test
  public void testCorrectCreation() {
    assertEquals("Potion created successfully.",
            gf.createGears("poison",GearCategory.POTION).toString());
  }

  @Test
  public void testHeadGearAffectOnPlayerAbility() {
    Map<PlayerAbilities, Integer> temp = new HashMap<>();
    temp.put(PlayerAbilities.CONSTITUTION,5);
    assertEquals(temp,headGear.getAffectOnPlayerAbility());
  }

  @Test
  public void testFootwearAffectOnPlayerAbility() {
    Map<PlayerAbilities, Integer> temp = new HashMap<>();
    temp.put(PlayerAbilities.DEXTERITY,4);
    assertEquals(temp,footWear.getAffectOnPlayerAbility());
  }

  @Test
  public void testBeltAffectOnPlayerAbility() {
    Map<PlayerAbilities, Integer> temp = new HashMap<>();
    temp.put(PlayerAbilities.DEXTERITY,1);
    temp.put(PlayerAbilities.CONSTITUTION,3);
    assertEquals(temp, belt.getAffectOnPlayerAbility());
  }

  @Test
  public void testPotionAffectOnPlayerAbility() {
    Map<PlayerAbilities, Integer> temp = new HashMap<>();
    temp.put(PlayerAbilities.DEXTERITY,0);
    temp.put(PlayerAbilities.CONSTITUTION,0);
    temp.put(PlayerAbilities.CHARISMA,4);
    temp.put(PlayerAbilities.STRENGTH,6);
    assertEquals(temp, potion.getAffectOnPlayerAbility());
  }

  @Test
  public void getName() {
    assertEquals("Spider's Blood",potion.getName());
    assertEquals("Head protector",headGear.getName());
    assertEquals("Speed booster", footWear.getName());
    assertEquals("Body protector", belt.getName());
  }

  @Test
  public void getGearCategory() {
    assertEquals("Headgear",headGear.getGearCategory().toString());
    assertEquals("Potion",potion.getGearCategory().toString());
    assertEquals("Footwear",footWear.getGearCategory().toString());
  }

  @Test(expected = IllegalStateException.class)
  public void testHeadGearBeltType() {
    headGear.getBeltType();
  }

  @Test(expected = IllegalStateException.class)
  public void testFootwearBeltType() {
    footWear.getBeltType();
  }

  @Test(expected = IllegalStateException.class)
  public void testPotionBeltType() {
    potion.getBeltType();
  }

  @Test
  public void testBeltType() {
    assertEquals("Large",belt.getBeltType().toString());
  }

  @Test
  public void getGearUnit() {
    assertEquals(4,belt.getGearUnit());
  }
}
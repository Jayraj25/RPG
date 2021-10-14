import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import gear.Belts;
import gear.Gear;
import gear.GearCategory;
import gear.GearFactory;
import player.PlayerAbilities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class GearTest {

  GearFactory gf = new GearFactory();
  Gear headGear = gf.createGears("Head protector", GearCategory.HEADGEAR);
  Gear footWear = gf.createGears("Speed booster", GearCategory.FOOTWEAR);
  Gear belt = gf.createGears("Body protector", GearCategory.BELT);
  Gear potion = gf.createGears("Spider's Blood", GearCategory.POTION);

  @Test (expected = NullPointerException.class)
  public void testNullGearCreation() {
    gf.createGears("asd",null);
  }

  @Test
  public void testCorrectCreation() {
    gf.createGears("poison",GearCategory.POTION);
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

  @Test(expected = IllegalAccessException.class)
  public void testHeadGearBeltType() throws IllegalAccessException {
    headGear.getBeltType();
  }

  @Test(expected = IllegalAccessException.class)
  public void testFootwearBeltType() throws IllegalAccessException {
    footWear.getBeltType();
  }

  @Test(expected = IllegalAccessException.class)
  public void testPotionBeltType() throws IllegalAccessException {
    potion.getBeltType();
  }

  @Test
  public void testBeltType() throws IllegalAccessException {
    assertEquals("Small",belt.getBeltType().toString());
  }

  @Test
  public void getGearUnit() throws IllegalAccessException {
    assertEquals(1,belt.getGearUnit());
  }
}
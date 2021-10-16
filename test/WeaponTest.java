import org.junit.Test;

import numbergenerator.GenerateRandomNumber;
import weapon.Axes;
import weapon.BareHands;
import weapon.BroadSwords;
import weapon.Flails;
import weapon.Katanas;
import weapon.TwoHandedSwords;
import weapon.Weapon;
import weapon.WeaponFactory;
import weapon.WeaponTypes;

import static org.junit.Assert.*;

public class WeaponTest {

  GenerateRandomNumber g= new GenerateRandomNumber(1);
  WeaponFactory wf = new WeaponFactory();
  Weapon w;
  Weapon f = wf.createWeapon(WeaponTypes.FLAIL);
  Weapon a = wf.createWeapon(WeaponTypes.AXE);
  Weapon sk = wf.createWeapon(WeaponTypes.KATANA);
  Weapon sb = wf.createWeapon(WeaponTypes.BROADSWORD);
  Weapon st = wf.createWeapon(WeaponTypes.TWO_HANDED_SWORD);
  Weapon bh = wf.createWeapon(WeaponTypes.BARE_HANDS);

  @Test (expected = NullPointerException.class)
  public void testNullWeaponCreation() {
    wf.createWeapon(null);
  }

  @Test
  public void testFlailCreation() {
    assertEquals(WeaponTypes.FLAIL,f.getTypeOfWeapon());
    assertEquals("Flails created successfully.",new Flails().toString());
  }

  @Test
  public void testAxeCreation() {
    assertEquals("Axe",a.getTypeOfWeapon().toString());
    assertEquals("Axe created successfully.",new Axes().toString());
  }

  @Test
  public void testKatanaCreation() {
    assertEquals("Katana",sk.getTypeOfWeapon().toString());
    assertEquals("Katana created successfully.",new Katanas().toString());
  }

  @Test
  public void testBroadSwordCreation() {
    assertEquals("Broad Sword",sb.getTypeOfWeapon().toString());
    assertEquals("Broad Sword created successfully.",new BroadSwords().toString());
  }

  @Test
  public void testTwoHandedSwordCreation() {
    assertEquals("Two Handed Swords",st.getTypeOfWeapon().toString());
    assertEquals("Two Handed Sword created successfully.",
            new TwoHandedSwords().toString());
  }

  @Test
  public void testBareHandsCreation() {
    assertEquals("Bare Hands",bh.getTypeOfWeapon().toString());
    assertEquals("Bare Hands created successfully.",new BareHands().toString());
  }

  @Test
  public void testFlailsDamage() {
    assertEquals(8,f.getWeaponDamage(g));
  }

  @Test
  public void testAxesDamage() {
    assertEquals(6,a.getWeaponDamage(g));
  }

  @Test
  public void testKatanaDamage() {
    assertEquals(4,sk.getWeaponDamage(g));
  }

  @Test
  public void testBroadSwordDamage() {
    assertEquals(6,sb.getWeaponDamage(g));
  }

  @Test
  public void testTwoHandedSwordDamage() {
    assertEquals(8,st.getWeaponDamage(g));
  }

  @Test
  public void testBareHandsDamage() {
    assertEquals(8,st.getWeaponDamage(g));
  }
}
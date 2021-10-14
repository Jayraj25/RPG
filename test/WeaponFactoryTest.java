import org.junit.Before;
import org.junit.Test;

import numbergenerator.GenerateRandomNumber;
import weapon.Weapon;
import weapon.WeaponFactory;
import weapon.WeaponTypes;

import static org.junit.Assert.*;

public class WeaponFactoryTest {

  GenerateRandomNumber g= new GenerateRandomNumber(1);
  WeaponFactory wf = new WeaponFactory();
  Weapon f = wf.createWeapon(WeaponTypes.FLAIL);
  Weapon a = wf.createWeapon(WeaponTypes.AXE);
  Weapon sk = wf.createWeapon(WeaponTypes.KATANA);
  Weapon sb = wf.createWeapon(WeaponTypes.BROADSWORD);
  Weapon st = wf.createWeapon(WeaponTypes.TWO_HANDED_SWORD);
  Weapon bh = wf.createWeapon(WeaponTypes.BARE_HANDS);

  @Test
  public void testFlailCreation() {
    assertEquals(WeaponTypes.FLAIL,f.getTypeOfWeapon());
  }

  @Test
  public void testAxeCreation() {
    assertEquals("Axe",a.getTypeOfWeapon());
  }

  @Test
  public void testKatanaCreation() {
    assertEquals("Katana",sk.getTypeOfWeapon());
  }

  @Test
  public void testBroadSwordCreation() {
    assertEquals("Broad Sword",sb.getTypeOfWeapon());
  }

  @Test
  public void testTwoHandedSwordCreation() {
    assertEquals("Two handed sword",st.getTypeOfWeapon());
  }

  @Test
  public void testBareHandsCreation() {
    assertEquals("Bare Hands",bh.getTypeOfWeapon());
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
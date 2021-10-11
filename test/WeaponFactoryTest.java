import org.junit.Before;
import org.junit.Test;

import numbergenerator.GenerateRandomNumber;
import weapon.Weapon;
import weapon.WeaponFactory;

import static org.junit.Assert.*;

public class WeaponFactoryTest {

  GenerateRandomNumber g= new GenerateRandomNumber(1);
  WeaponFactory wf = new WeaponFactory();
  Weapon f = wf.createWeapon("Flail");
  Weapon a = wf.createWeapon("Axe");
  Weapon sk = wf.createWeapon("Katana");
  Weapon sb = wf.createWeapon("Broad sword");
  Weapon st = wf.createWeapon("Two handed sword");

  @Test
  public void testFlailCreation() {
    assertEquals("Flail",f.getTypeOfWeapon());
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
}
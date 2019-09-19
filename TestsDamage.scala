package Tests

import org.scalatest.FunSuite

import Character.Character


class TestsDamage extends FunSuite {

test("Tests takeDamage Method") {


  val newChar1: Character = new Character(200, 1000,
    20, 100, 2000, 20, 20)
  val newChar2: Character = new Character(20, 200,
    200, 1000, 200, 1000, 5)


  newChar1.takeDamage(newChar2.attackPower)
  println(newChar1.currentHP)

  newChar2.takeDamage(newChar1.attackPower)
  println(newChar2.currentHP)

  assert(newChar1.lifeStatus)
  assert(!newChar2.lifeStatus)

  newChar1.healingPotion()
  newChar2.healingPotion()
  assert(newChar1.lifeStatus)
  assert(newChar2.lifeStatus)

  newChar1.physicalAttack(newChar2)
  println(newChar1.currentHP)
  assert(newChar1.lifeStatus)

  newChar2.magicAttack(newChar1)
  println(newChar2.currentHP)
  println(newChar2.currentMP)

  newChar1.magicAttack(newChar2)
  println(newChar1.currentHP)
  assert(newChar1.mpStatus)
  newChar1.magicAttack(newChar2)
  println(newChar1.currentHP)
  assert(!newChar1.mpStatus)

}
}




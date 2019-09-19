package Character

class Character(var attackPower: Int, var defense: Int, var magicAttack: Int,
                var magicDefense: Int, var maxHP: Int, var maxMP: Int, var mpCost: Int) {


  var currentHP: Int = this.maxHP
  var currentMP: Int = this.maxMP

  var lifeStatus: Boolean = true
  var mpStatus: Boolean = true

  def takeDamage(damage: Int): Unit= {
    this.currentHP = this.maxHP - damage

    if (currentHP == 0) {
      this.lifeStatus = false
    }
    else {
      this.lifeStatus = true
    }
  }

  def physicalAttack(newCharacter: Character): Unit = {
    val damage = newCharacter.attackPower
    this.takeDamage(damage)
  }

  def magicAttack(newCharacter: Character): Unit = {
    val damage = newCharacter.magicAttack
    this.takeDamage(damage)
    if (this.currentMP >= this.mpCost) {
      this.currentMP = this.currentMP - this.mpCost
    }
    else{
      this.mpStatus = false
    }
  }

  def healingPotion(): Unit = {
    this.lifeStatus = true
    this.currentHP = this.maxHP
  }

}

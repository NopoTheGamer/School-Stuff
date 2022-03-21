import random
import Items
import Utils
import Stats

zombieHP = 25

def room3():
    Utils.printTrimmer()
    Utils.printFormattedLine("You walk into the sewer")
    Utils.printFormattedLine("There is water and a bridge")
    Utils.printFormattedLine("You get ambushed by a zombie")
    Utils.printFormattedLine("You are forced to fight them")
    Utils.printTrimmer()
    global zombieHP
    while zombieHP > 0 and Stats.health > 0:
        Utils.printFormattedLine(f"You have {Stats.health} health")
        Utils.printFormattedLine(f"The zombie has {zombieHP} health")
        Utils.printFormattedLine("Do you want to attack or use an item?")
        Utils.printTrimmer()
        match input().lower():
            case "attack":
                Utils.printTrimmer()
                Utils.printFormattedLine("You attack the zombie")
                damage = (random.randint(1, 3) * Stats.attack)
                zombieHP -= damage
                Utils.printFormattedLine(f"You did {damage} damage to the zombie")
                Utils.printFormattedLine(f"The zombie has {zombieHP} health left")
                Utils.printTrimmer()
                zombieDamage = (random.randint(1, 3) * 8)
                Utils.printFormattedLine(f"The zombie attacks you for {zombieDamage} damage")
                Stats.health -= zombieDamage
            case "use item" | "use" | "item":
                Utils.printTrimmer()
                Items.listItems()
                if Items.hasAnyItems():
                    Utils.printFormattedLine("Which item do you want to use?")
                    Utils.printTrimmer()
                    match input().lower():
                        case "play dough":
                            Utils.printTrimmer()
                            Utils.printFormattedLine("ugh... that's gross")
                            Utils.printFormattedLine("You eat it and gain 3 health")
                            Stats.health += 3
                        case "chug splash":
                            Utils.printTrimmer()
                            Utils.printFormattedLine("You splash it on you and gain 20 health")
                            Stats.health += 20
                        case _:
                            Utils.printTrimmer()
                            Utils.printFormattedLine("You can't do that")
                else:
                    Utils.printFormattedLine("You don't have any items")
                    Utils.printTrimmer()
    if Stats.health > 0:
        Utils.printFormattedLine("You killed the zombie!")
        Utils.printFormattedLine("You pick up the zombies dagger and gain 3 attack!")
        Stats.attack += 3
        Utils.printFormattedLine("You quickly leave the sewer")
        Utils.goToNextRoom(4)
    elif zombieHP > 0:
        Utils.printTrimmer()
        Utils.printFormattedLine("You died")
        Utils.printFormattedLine("You were not the right person for this gauntlet")
        Utils.exitGame()
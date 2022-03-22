import Utils
import Stats
import random
import Items


def fight(enemyName, enemyHP, enemyAttack, room):

    while enemyHP > 0 and Stats.health > 0:
        Utils.printFormattedLine(f"You have {Stats.health} health")
        Utils.printFormattedLine(f"{enemyName} has {enemyHP} health")
        Utils.printFormattedLine("Do you want to attack or use an item?")
        Utils.printTrimmer()
        match input().lower():
            case "attack":
                Utils.printTrimmer()
                Utils.printFormattedLine(f"You attack {enemyName}")
                damage = (random.randint(1, 3) * Stats.attack)
                enemyHP -= damage
                Utils.printFormattedLine(f"You did {damage} damage to {enemyName}")
                Utils.printFormattedLine(f"{enemyName} has {enemyHP} health left")
                Utils.printTrimmer()
                enemyDamage = enemyAttack
                Utils.printFormattedLine(f"{enemyName} attacks you for {enemyDamage} damage")
                Stats.health -= enemyDamage
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
        Utils.goToNextRoom(room)
    elif enemyHP > 0:
        Utils.printTrimmer()
        Utils.printFormattedLine("You died")
        Utils.printFormattedLine("You were not the right person for this gauntlet")
        Utils.exitGame()
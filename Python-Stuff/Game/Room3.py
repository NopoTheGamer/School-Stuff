import random
import Items
import Utils
import Fight
import Stats


def room3():
    Utils.printTrimmer()
    Utils.printFormattedLine("You walk into the sewer")
    Utils.printFormattedLine("There is water and a bridge")
    Utils.printFormattedLine("You get ambushed by a zombie")
    Utils.printFormattedLine("You are forced to fight them")
    Utils.printTrimmer()
    Fight.fight("Zombie", 25, (random.randint(1, 3) * 8), 4)
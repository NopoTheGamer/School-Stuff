import Utils
import Items
from Room1 import room1
import Room5


def gameLoop():
    Utils.printTrimmer()
    Utils.printFormattedLine("What is ur name?")
    Utils.printTrimmer()
    playerName = input("")
    Utils.printTrimmer()
    Utils.printFormattedLine(f"Welcome {playerName} to the sewers!")
    Utils.printFormattedLine(f"You jump down the hatch")
    Utils.printFormattedLine("It doesn't look like you can get back up")
    Utils.printTrimmer()
    #Items.addItem("phone")
    #Items.useItem("deez")
    #if Items.hasItem("deez"):
    #    print("yes")
    #else: print("no")
    #Room5.room5()
    room1()


gameLoop()

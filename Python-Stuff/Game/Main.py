import Utils
import Items
from Room1 import room1


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
    room1()


gameLoop()

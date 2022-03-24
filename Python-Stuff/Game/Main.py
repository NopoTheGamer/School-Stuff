import Utils
import Tests
import Stats
from Room1 import room1
import Room4


def gameLoop():
    Utils.printTrimmer()
    Utils.printRedFormattedLine("Warning: is this string red?")
    Utils.printFormattedLine("Yes | No")
    Utils.printTrimmer()
    match input().lower():
        case "yes":
            Stats.coloredText = True
        case _:
            Stats.coloredText = False
    Utils.printTrimmer()
    Utils.printFormattedLine("What is your name?")
    Utils.printTrimmer()
    playerName = input("")
    if playerName == "test":
        Tests.test()
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
    # Room4.room4()
    room1()


gameLoop()

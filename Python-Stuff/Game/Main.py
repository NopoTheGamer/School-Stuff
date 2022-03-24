import Utils
import Tests
import Stats
from Room1 import room1



def gameLoop():
    Utils.printTrimmer()
    # This is a check to see if ansi colors work in your terminal
    # I dont think they work on Windows but idk
    Utils.printRedFormattedLine("Warning: is this string red?")
    Utils.printFormattedLine("Yes | No")
    Utils.printTrimmer()
    # I like using match statment over if else's because its cooler 👍
    # I think they were added in the newest python version
    match input().lower():
        case "yes":
            # updates a variable in the stats file that makes it so colors will show or not
            Stats.coloredText = True
        case _:
            Stats.coloredText = False
    Utils.printTrimmer()
    # askes for you name and never really uses it anywhere 👍
    Utils.printFormattedLine("What is your name?")
    Utils.printTrimmer()
    playerName = input("")
    # If the player name puts in "test" the desk check runs
    if playerName == "test":
        Tests.deskCheck()
    # In the marking guide line it says we need movement but uhhh my game only has go to next room
    # So i made a movement demo
    elif playerName == "movement":
        Tests.movement(0, 0)
    Utils.printTrimmer()
    # f strings are cool
    # I wish java had them
    # POV: "Welcome " + playerName + " to the sewers!"
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

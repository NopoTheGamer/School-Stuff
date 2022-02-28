import Utils


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
    Utils.printFormattedLine("It looks like you are in a bunker")
    Utils.printFormattedLine("You look around and spot:")
    Utils.printFormattedLine("A computer")
    Utils.printFormattedLine("A toolbox")
    Utils.printFormattedLine("And a power inverter")
    Utils.printFormattedLine("What would you like to do?")
    Utils.printFormattedLine("Interact | Check inventory | Go to the next room")
    Utils.printTrimmer()
    match (input("")).lower():
        case "interact":
            Utils.printFormattedLine("What would you like to interact with?")

        case "check" | "inventory" | "check inventory" | "inv":
            print("nuts")
        case "room" | "go" | "next" | "go to next room":
            print("sir im so mature with my naming")


Utils.interact("a", "b", "b")
gameLoop()

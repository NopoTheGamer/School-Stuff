import Utils

global toolbox
global computer
global powerinverter
toolbox = False
computer = False
powerinverter = False


def room1():
    Utils.printFormattedLine("It looks like you are in a bunker")
    Utils.printFormattedLine("You look around and spot:")
    Utils.printFormattedLine("A computer")
    if toolbox is False:
        Utils.printFormattedLine("A toolbox")
    Utils.printFormattedLine("And a power inverter")
    Utils.printFormattedLine("What would you like to do?")
    Utils.printTrimmer()
    Utils.printFormattedLine("Interact | Check inventory | Go to the next room")
    Utils.printFormattedLine("Exit")
    Utils.printTrimmer()
    match (input("")).lower():
        case "interact":
            Utils.printTrimmer()
            Utils.printFormattedLine("What would you like to interact with?")
            array = []
            if not computer:
                array.append("Computer")
            if not toolbox:
                array.append("Toolbox")
            if not powerinverter:
                array.append("Power inverter")
            Utils.interact(array)
        case "check" | "inventory" | "check inventory" | "inv":
            print("nuts")
        case "room" | "go" | "next" | "go to next room":
            print("sir im so mature with my naming")
        case "exit" | "quit":
            Utils.exitGame()

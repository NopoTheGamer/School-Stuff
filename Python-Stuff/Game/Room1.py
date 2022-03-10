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
    if computer is False:
        Utils.printFormattedLine("A computer")
    if toolbox is False:
        Utils.printFormattedLine("A toolbox")
    if powerinverter is False:
        Utils.printFormattedLine("A power inverter")
    Utils.printFormattedLine("What would you like to do?")
    Utils.printTrimmer()
    Utils.printFormattedLine("Interact | Check inventory | Go to the next room")
    Utils.printFormattedLine("Exit")
    Utils.printTrimmer()
    Utils.mainInput(1)


def room1Interact():
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

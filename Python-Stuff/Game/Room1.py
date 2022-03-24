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
    # If you havent been to these places before it will say you can go there
    if computer is False:
        Utils.printFormattedLine("A computer")
    if toolbox is False:
        Utils.printFormattedLine("A toolbox")
    if powerinverter is False:
        Utils.printFormattedLine("A power inverter")
    # Sends you to the interact function
    Utils.mainInput(1)


def room1Interact():
    Utils.printTrimmer()
    Utils.printFormattedLine("What would you like to interact with?")
    array = []
    # Using the same tech as above i add stuff to the array if you havent been there before
    if not computer:
        array.append("Computer")
    if not toolbox:
        array.append("Toolbox")
    if not powerinverter:
        array.append("Power inverter")
    # Sends off the array
    if not array:
        Utils.printTrimmer()
        Utils.printFormattedLine("There is nothing you can interact with")
        Utils.printTrimmer()
        Utils.mainInput(1)
    Utils.interact(array)

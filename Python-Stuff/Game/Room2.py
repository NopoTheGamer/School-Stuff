import Utils
vendingMachine = False
playDough = False
flashLight = False
flashLightOn = False
jukebox = False

def room2():
    Utils.printTrimmer()
    Utils.printFormattedLine("You enter the storage room!")
    Utils.printFormattedLine("On the ground you spot")
    if vendingMachine is False:
        Utils.printFormattedLine("A vending machine")
    if playDough is False:
        Utils.printFormattedLine("Some tubs of play dough")
    if flashLight is False:
        Utils.printFormattedLine("A flash light")
    if flashLightOn is True and jukebox is False:
        Utils.printFormattedLine("A Jukebox")
    Utils.mainInput(2)

def room2Interact():
    Utils.printTrimmer()
    Utils.printFormattedLine("What would you like to interact with?")
    array = []
    if not vendingMachine:
        array.append("Vending machine")
    if not playDough:
        array.append("Play Dough")
    if not flashLight:
        array.append("Flash light")
    if flashLightOn and jukebox is not False:
        array.append("Jukebox")
    Utils.interact(array)

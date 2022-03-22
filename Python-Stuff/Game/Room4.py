import random

import Utils
numberle = []
green = [0, 0, 0, 0, 0]
yellow = [0, 0, 0, 0, 0]
ansiGreen = "\u001b[32m"
ansiYellow = "\u001b[33m"

def room4():
    for i in range(1, 6):
        numberle.append(random.randint(0, 9))
    print(numberle)
    Utils.printTrimmer()
    Utils.printFormattedLine("You enter into what looks like a classroom")
    Utils.printFormattedLine("On a table there is a machine")
    Utils.printFormattedLine("It has a numpad and no letters")
    Utils.printTrimmer()
    puzzle()


def puzzle():
    displayNumber = [-1, -1, -1, -1, -1]
    displayNumberStr = ""
    Utils.printFormattedLine("Enter a 5 digit number")
    Utils.printTrimmer()
    numberInput = input("")
    if len(numberInput) == 5:
        for i in range(1, 6):
            if int(str(numberInput)[i-1:i]) == numberle[i-1]:
                green[i-1] = 1
                displayNumber[i-1] = "\u001b[32m" + str(numberInput)[i-1:i]
        for z in range(0, 5):
            displayNumberStr += str(displayNumber[z]) + " | "
        Utils.printFormattedLine(f"{displayNumberStr}")
        #TODO: Made a check for yellow numbers
    else:
        Utils.printTrimmer()
        Utils.printFormattedLine("The number has to be 5 digits")
        puzzle()


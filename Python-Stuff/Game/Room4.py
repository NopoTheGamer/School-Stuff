import random

import Utils
numberle = []
green = [0, 0, 0, 0, 0]
yellow = [0, 0, 0, 0, 0]

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
    Utils.printFormattedLine("Enter a 5 digit number")
    Utils.printTrimmer()
    numberInput = input("")
    if len(numberInput) == 5:
        for i in range(1, 6):
            if int(str(numberInput)[i-1:i]) == numberle[i-1]:
                green[i-1] = 1
                print("Correct")
        #TODO: Made a check for yellow numbers
    else:
        Utils.printTrimmer()
        Utils.printFormattedLine("The number has to be 5 digits")
        puzzle()


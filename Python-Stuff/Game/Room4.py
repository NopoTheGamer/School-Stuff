import random
import Stats
import Utils
numberle = []
green = [0, 0, 0, 0, 0]
yellow = [0, 0, 0, 0, 0]
ansiGreen = "\u001b[32m"
ansiYellow = "\u001b[33m"
guessCount = 0

def room4():
    for i in range(1, 6):
        numberle.append(random.randint(0, 9))
    # print(numberle)
    Utils.printTrimmer()
    Utils.printFormattedLine("You enter into what looks like a classroom")
    Utils.printFormattedLine("On a table there is a machine")
    Utils.printFormattedLine("It has a numpad and no letters")
    Utils.printTrimmer()
    puzzle()


def puzzle():
    fullyCorrect = 0
    displayNumber = [-1, -1, -1, -1, -1]
    displayNumberStr = ""
    Utils.printFormattedLine("Enter a 5 digit number")
    Utils.printTrimmer()
    numberInput = input("")
    Utils.printTrimmer()
    global guessCount
    guessCount += 1
    if len(numberInput) == 5:
        for i in range(1, 6):
            try:
                if int(str(numberInput)[i-1:i]) == numberle[i-1]:
                    green[i-1] = 1
                    displayNumber[i-1] = "\u001b[32m" + str(numberInput)[i-1:i]
                    fullyCorrect += 1
            except ValueError:
                Utils.printFormattedLine("The number has to be a number")
                puzzle()
        for z in range(0, 5):
            displayNumberStr += str(displayNumber[z]) + " \u001b[0m| "
        displayNumberStr = displayNumberStr.replace("-1", "\u001b[31mX")
        if guessCount % 5 == 0 and fullyCorrect != 5:
            Utils.printFormattedLine("The machine zaps you for 10 health")
            Stats.health -= 10
            if Stats.health > 0:
                Utils.printFormattedLine(f"You have {Stats.health} health")
                Utils.printTrimmer()
            else:
                Utils.printFormattedLine("You have 0 health")
                Utils.printFormattedLine("You have died")
                Utils.exitGame()

            # guessCount = 0
        Utils.printFormattedLineWithSpaces(f"{displayNumberStr}", 45)
        if fullyCorrect == 5:
            Utils.printTrimmer()
            Utils.printFormattedLine("You have beat the puzzle!")
            Utils.printFormattedLine("You advance to the next room")
            Utils.printTrimmer()
            Utils.goToNextRoom(5)
        Utils.printTrimmer()
        puzzle()
    else:
        # Utils.printTrimmer()
        Utils.printFormattedLine("The number has to be 5 digits")
        puzzle()


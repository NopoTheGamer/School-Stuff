import random
import Stats
import Utils
numberle = []
green = [0, 0, 0, 0, 0]
yellow = [0, 0, 0, 0, 0]
ansiGreen = "\u001b[32m"
ansiRed = "\u001b[31m"
ansiReset = "\u001b[0m"
guessCount = 0

def room4():
    # Wordle clone !!!!!!
    # I gave up on doing the yellow numbers because that would make it easier than it already is
    # totally not because my for loop didnt work and I thought it was just too much effort to bother with
    if not Stats.coloredText:
        # Funny ansi text not being support in windows
        global ansiGreen
        ansiGreen = ""
        global ansiRed
        ansiRed = ""
        global ansiReset
        ansiReset = ""
    # Unsure why i did 1,6 instead of 0,5
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
    # a counter variable
    fullyCorrect = 0
    # What ends up getting displayed
    displayNumber = [-1, -1, -1, -1, -1]
    # Well this one is but its just data from the one above
    displayNumberStr = ""
    Utils.printFormattedLine("Enter a 5 digit number")
    Utils.printTrimmer()
    numberInput = input("")
    Utils.printTrimmer()
    global guessCount
    guessCount += 1
    if len(numberInput) == 5:
        # range 1,6 strikes again
        for i in range(1, 6):
            try:
                # String slicing to get just single digits
                if int(str(numberInput)[i-1:i]) == numberle[i-1]:
                    green[i-1] = 1
                    displayNumber[i-1] = ansiGreen + str(numberInput)[i-1:i]
                    fullyCorrect += 1
            # python dont got typed variables so i gotta stick it in a try except (try catch is a better name)
            except ValueError:
                # The number does have to be a number 👍
                Utils.printFormattedLine("The number has to be a number")
                puzzle()
        for z in range(0, 5):
            displayNumberStr += str(displayNumber[z]) + " " + ansiReset + "| "
        # Replace -1 with a "red" X
        displayNumberStr = displayNumberStr.replace("-1", ansiRed + "X")
        # If you get zapped more than twice you are bad smh
        # It should be a max of 10 guesses if you are fully unlucky
        # just like guess 00000, 11111 etc
        if guessCount % 5 == 0 and fullyCorrect != 5:
            Utils.printFormattedLine("The machine zaps you for 10 health")
            Stats.health -= 10
            if Stats.health > 0:
                Utils.printFormattedLine(f"You have {Stats.health} health")
                Utils.printTrimmer()
            # Would be funny if you died to "numberle"
            else:
                Utils.printFormattedLine("You have 0 health")
                Utils.printFormattedLine("You have died")
                Utils.exitGame()
            # I was gonna set your guess count back to 0 but there was no reason to
            # guessCount = 0
        # Check if you have colored text on
        # Because the ansi reset counts as text but doesnt get rendered i have to added extra spaces (45)
        Utils.printFormattedLineWithSpaces(f"{displayNumberStr}", 45 if Stats.coloredText else 0)
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
        # how hard is it to read the instructions smh
        # jk you prob mistyped right?
        Utils.printFormattedLine("The number has to be 5 digits")
        puzzle()


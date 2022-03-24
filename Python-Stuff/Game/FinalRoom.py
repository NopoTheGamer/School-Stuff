import Utils
import Stats

def ending():
    Utils.printTrimmer()
    Utils.printFormattedLine("You have reached the end of the game.")
    Utils.printFormattedLine("Thank you for playing!")
    Utils.printTrimmer()
    Utils.printFormattedLine(f"You score was {Stats.score}.")
    # Utils.printFormattedLine(f"This means your ranking is {ranking}")

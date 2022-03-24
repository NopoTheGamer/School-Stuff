import Utils
import Stats

def ending():
    ranking = ""
    if Stats.score == 0:
        ranking = "F"
    elif Stats.score < 10:
        ranking = "D"
    elif Stats.score < 15:
        ranking = "C"
    elif Stats.score < 20:
        ranking = "B"
    elif Stats.score < 25:
        ranking = "A"
    elif Stats.score < 30:
        ranking = "S"
    elif Stats.score >= 30:
        ranking = "S+"
    Utils.printTrimmer()
    Utils.printFormattedLine("You have reached the end of the game.")
    Utils.printFormattedLine("Thank you for playing!")
    Utils.printTrimmer()
    Utils.printFormattedLine(f"You score was {Stats.score}.")
    Utils.printFormattedLine(f"This means your ranking is {ranking}")

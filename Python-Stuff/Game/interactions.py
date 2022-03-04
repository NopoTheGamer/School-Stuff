import Stats
import Utils


def interactWithRoom(arg):
    Utils.printTrimmer()
    match arg:
        case "computer":
            Utils.printFormattedLine("You see a computer. It's a bit old, but it's still working.")
        case "toolbox":
            Utils.printFormattedLine("You open up the toolbox and find a shovel.")
            Stats.attack += 3
            Utils.printFormattedLine(f"You gain +3 attack! Your attack is now {Stats.attack}")
            interactWithRoom("computer")
        case "power inverter":
            Utils.printFormattedLine("You see a power inverter. It's a bit old, but it's still working.")

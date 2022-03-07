import Room1
import Stats
import Utils


def interactWithRoom(arg):
    Utils.printTrimmer()
    match arg:
        case "computer":
            Utils.printFormattedLine("You see a computer")
            Utils.printFormattedLine("You turn it on and there is a prompt")
            Utils.printFormattedLine("It asks you \"Are you sure\"")
            match input(""):
                case "yes":
                    print("deez")
                case "no":
                    print("nuts")
                case _:
                    print("paper")
            Room1.computer = True
            Room1.room1()
        case "toolbox":
            Utils.printFormattedLine("You open up the toolbox and find a shovel.")
            Stats.attack += 3
            Utils.printFormattedLine(f"You gain +3 attack! Your attack is now {Stats.attack}")
            Utils.printTrimmer()
            Room1.toolbox = True
            Room1.room1()
        case "power inverter":
            Utils.printFormattedLine("You see a power inverter. It's a bit old, but it's still working.")

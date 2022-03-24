import Utils
import Fight
import random
# from Stats import playerName

def room5():
    Utils.printTrimmer()
    Utils.printFormattedLine("Welcome to my lair")
    Utils.printFormattedLine("You have heard me narrate your adventure")
    Utils.printFormattedLine("But now you shall die!")
    Utils.printRedFormattedLine(f"I dont know what to do")
    Utils.printRedFormattedLine("I can either run to the door or fight the narrator")
    Utils.printRedFormattedLine("What should I do?")
    Utils.printTrimmer()
    match input("").lower():
        case "run" | "run to door" | "leave" | "door":
            Utils.printRedFormattedLine("You escaped this whole place")
            Utils.printRedFormattedLine("You are now free")

            # run credits and score and stuff
        case "fight" | "attack" | "battle" | "kill" | "fight the narrator" | "narrator":
            Utils.printTrimmer()
            Utils.printFormattedLine("You want to fight me?? Prepare to go down")
            Fight.fight("Narrator", 40, (random.randint(2, 4) * 7), 6)


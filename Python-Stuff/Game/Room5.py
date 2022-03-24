import Utils
import Fight
import random
import FinalRoom
# from Stats import playerName

def room5():
    # Final room
    # Scary
    Utils.printTrimmer()
    Utils.printFormattedLine("Welcome to my lair")
    Utils.printFormattedLine("You have heard me narrate your adventure")
    Utils.printFormattedLine("But now you shall die!")
    # ig this makes less sense if you dont have the colors on
    # idk why its red but its meant to indicate that it isnt the narrator talking
    Utils.printRedFormattedLine(f"I dont know what to do")
    Utils.printRedFormattedLine("I can either run to the door or fight the narrator")
    Utils.printRedFormattedLine("What should I do?")
    Utils.printTrimmer()
    match input("").lower():
        case "run" | "run to door" | "leave" | "door":
            # You dont even gotta kill the final boss
            # You can just dip 👍
            # You dont get the +10 score tho D:
            Utils.printRedFormattedLine("You escaped this whole place")
            Utils.printRedFormattedLine("You are now free")
            FinalRoom.ending()

            # run credits and score and stuff
        case "fight" | "attack" | "battle" | "kill" | "fight the narrator" | "narrator":
            # Sometimes you gotta make sure they dont type in the full line you give em
            Utils.printTrimmer()
            Utils.printFormattedLine("You want to fight me?? Prepare to go down")
            Fight.fight("Narrator", 40, (random.randint(2, 4) * 7), 6)
        case _:
            Utils.printFormattedLine("Invalid input")
            Utils.printFormattedLine("Let me go over this again")
            room5()


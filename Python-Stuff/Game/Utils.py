import Room1
import Room2
import Room3
import Room4
import Room5
import interactions
import Items
import Stats
import FinalRoom


def printFormattedLine(string):
    # gets string length and removes it from 50
    numLen = 50 - len(string)
    # then multiples somes spaces
    # Funny formatted lines that look nice  👍
    # instead of ooga booga print()
    spaces = " " * numLen
    if Stats.coloredText:
        print(f"| {string}{spaces}\u001b[0m|")
    else:
        print(f"| {string}{spaces}|")

def printFormattedLineWithSpaces(string, numberOfSpaces):
    # due to ansi escape codes not rendering but counting as char's
    # needed some extra spaces
    numLen = 50 - len(string)
    spaces = " " * (numLen + numberOfSpaces)
    if Stats.coloredText:
        print(f"| {string}{spaces}\u001b[0m|")
    else:
        print(f"| {string}{spaces}|")

def printRedFormattedLine(string):
    # red !!!
    # useless if colors are off
    numLen = 50 - len(string)
    spaces = " " * numLen
    if Stats.coloredText:
        print(f"\u001b[31m| {string}{spaces}|\u001b[0m")
    else:
        print(f"| {string}{spaces}|")

def printTrimmer():
    # Have a break between text
    # formatting top priority
    # thats why these funcs were made first
    dashes = "-" * 51
    print(f"|{dashes}|")


def interact(args):
    # Loops over the array and prints it
    for s in range(len(args)):
        printFormattedLine(f"{args[s]}")
    printTrimmer()
    playerInput = input("")
    # A counter to tell if you typed an invalid input
    i = 0
    for interactables in args:
        # Checks the player input against the array
        # in lower case in order to avoid case sensitivity 👍
        if playerInput.lower() == interactables.lower():
            # Sends off the one you picked
            interactions.interactWithRoom(playerInput.lower())
            break
        i += 1
        if i == len(args):
            printTrimmer()
            printFormattedLine("Invalid input")
            printTrimmer()
            interact(args)


def exitGame():
    printFormattedLine("Goodbye")
    printTrimmer()
    # Exit is a built in function
    # You can just uh close the program any other way
    # but ok
    exit()


def goToNextRoom(room):
    # Calling functions based on the room number 👍
    if room == 0:
        print("how??")
    if room == 1:
        Room1.room1()
    if room == 2:
        Room2.room2()
    if room == 3:
        Room3.room3()
    if room == 4:
        Room4.room4()
    if room == 5:
        Room5.room5()
    if room == 6:
        # +10 social credit 👍
        Stats.score += 10
        FinalRoom.ending()

def roomInteract(room):
    if room == 1:
        Room1.room1Interact()
    if room == 2:
        Room2.room2Interact()

def mainInput(CurrentRoom):
    printFormattedLine("What would you like to do?")
    printTrimmer()
    printFormattedLine("Interact | Check inventory | Go to the next room")
    printFormattedLine("Map | Exit")
    printTrimmer()
    # Match statement 👍
    match (input("")).lower():
        case "interact":
            roomInteract(CurrentRoom)
        case "check" | "inventory" | "check inventory" | "inv":
            Items.listItems()
            mainInput(CurrentRoom)
        case "room" | "go" | "next" | "go to next room":
            goToNextRoom(CurrentRoom + 1)
        case "exit" | "quit":
            exitGame()
        case "map":
            printTrimmer()
            # Here i use ternary operators to put a arrow at the start of the string if the room is the current room
            # I would of used them elsewhere but i got confused between ternary and lambda expressions and googled the wrong thing 👍
            printFormattedLine("-> Room 1: Bunker" if CurrentRoom == 1 else "Room 1: Bunker")
            printFormattedLine("-> Room 2: Storage" if CurrentRoom == 2 else "Room 2: Storage")
            printFormattedLine("-> Room 3: Sewer" if CurrentRoom == 3 else "Room 3: Sewer")
            printFormattedLine("-> Room 4: Classroom" if CurrentRoom == 4 else "Room 4: Classroom")
            printFormattedLine("-> Room 5: Lair" if CurrentRoom == 5 else "Room 5: Lair")
            printTrimmer()
            mainInput(CurrentRoom)
        # "case _:" is basically the else statement for match statements
        case _:
            printTrimmer()
            printFormattedLine("Invalid input")
            mainInput(CurrentRoom)

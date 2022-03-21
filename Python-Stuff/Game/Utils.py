import Room1
import Room2
import Room3
import Room4
import interactions
import Items


def printFormattedLine(string):
    numLen = 50 - len(string)
    spaces = " " * numLen
    print(f"| {string}{spaces}|")


def printTrimmer():
    dashes = "-" * 51
    print(f"|{dashes}|")


def interact(args):
    for s in range(len(args)):
        printFormattedLine(f"{args[s]}")
    printTrimmer()
    playerInput = input("")
    i = 0
    for st in args:
        if playerInput.lower() == st.lower():
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
    exit()


def goToNextRoom(room):
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


def roomInteract(room):
    if room == 0:
        print("how??")
    if room == 1:
        Room1.room1Interact()
    if room == 2:
        Room2.room2Interact()
    if room == 3:
        # Room3.room3Interact()
        # i mean this shouldnt ever run but ill remove it to be safe
        print("how??")

def mainInput(CurrentRoom):
    printFormattedLine("What would you like to do?")
    printTrimmer()
    printFormattedLine("Interact | Check inventory | Go to the next room")
    printFormattedLine("Exit")
    printTrimmer()
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
        case _:
            printTrimmer()
            printFormattedLine("Invalid input")
            mainInput(CurrentRoom)

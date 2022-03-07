import interactions


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
            print("cant do that")


def exitGame():
    print("Goodbye")
    exit()

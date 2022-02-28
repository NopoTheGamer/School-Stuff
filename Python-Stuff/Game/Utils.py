def printFormattedLine(string):
    numLen = 50 - len(string)
    spaces = " " * numLen
    print(f"| {string}{spaces}|")


def printTrimmer():
    dashes = "-" * 51
    print(f"|{dashes}|")


def interact(*args):
    for s in args:
        printFormattedLine(f"{s}")
    playerInput = input("")
    i = 0
    for st in args:
        if playerInput == st:
            print("do stuff")
            break
        i += 1
        if i == len(args):
            print("cant do that")

def main():
    name = input("What is your name?\n")
    print(f"Welcome to the sewers {name}!")
    print("You have just dropped down into this sewer system.")
    print("You look around and spot:\nAn old computer\nA toolbox\nA book\nAnd a power generator")
    getPlayerInput(["Use the computer", "Open up the book", "Turn on the power generator"])


def getPlayerInput(validInputs):
    print("What would you like to do")
    print(f"You can: ", end='')
    for s in validInputs:
        if s == validInputs[len(validInputs) - 1]:
            comma = "\n"
        else:
            comma = ", "
        print(s + comma, end='')
    playerInput = input("")
    i = 0
    for ss in validInputs:
        if playerInput.lower() == ss.lower():
            useObject(ss.lower())
            break
        i += 1
        if i == len(validInputs):
            print("Invalid input")


def useObject(object):
    if object == "use the computer":
        print("darcy's lack of nuts showed up on the screen")
    else:
        print("pro codr")


main()

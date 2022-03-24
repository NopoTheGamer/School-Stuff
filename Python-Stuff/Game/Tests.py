import Items
import Utils

def deskCheck():
    # I dont think this is how a test is really meant to be done
    # but it does test the items function so i guess it works 👍
    Items.listItems()
    Items.addItem("test")
    Items.listItems()
    Items.useItem("test")
    Items.listItems()
    print("You should of gained a 'test' item and then lost it")

def movement(x, y):
    # Movement is really simple
    # you have x and y
    # they go up or down
    # and then you run the loop again
    Utils.printFormattedLine("Where would you like to go?")
    Utils.printFormattedLine(f"You are at x: {x} y: {y}")
    Utils.printFormattedLine("w | a | s | d")
    Utils.printTrimmer()
    match input("").lower():
        case "w":
            y += 1
        case "a":
            x -= 1
        case "s":
            y -= 1
        case "d":
            x += 1
        case _:
            x = 0
            y = 0
    # i even put 2 "areas" for you to interact with
    if x == 1 and y == 1:
        Utils.printFormattedLine("You are at area 1!")
    if x == -1 and y == -1:
        Utils.printFormattedLine("You are at area 2!")
    Utils.printTrimmer()
    movement(x, y)

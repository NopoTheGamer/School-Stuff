import Utils
# Ok now i have to comment this file 👍
# This array stores your items
# "EMPTY" is like a null value
# It doesnt appear there is null in python
itemList = ["EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY"]

# I just got half way through commenting this function before realising i never used it anywhere 👍
# dw its still soild code
def backpack():
    # the end="" makes it so 1. there isnt a new line and 2. prints a lil pipe between the items
    print("| You have: ", end="| ")
    for Entries in itemList:
        # If the entry isnt empty (you have an item) it will print it
        if Entries != "EMPTY":
            print(Entries, end = " | ")
    # We didnt get a new line before so i use this to add one
    print()
    # match statement 👍👍👍👍👍
    Utils.printFormattedLine("Do you want to use an item? | Yes | No")
    match input(""):
        case "yes":
            Utils.printFormattedLine("What item do you want to use?")
            itemInput = input("")
            for Item in itemList:
                # if player input equals an item you have it will use it (in lower case(👍))
                if itemInput.lower() == Item.lower():
                    # You cant just use "EMPTY" smh
                    if itemInput != "EMPTY":
                        Utils.printFormattedLine(f"You used {Item} !!!!!!")
                        break
        # Using case _ instead of a case "no" for the miss typers in the future
        case _:
            Utils.printFormattedLine("You didnt use an item")
# addItem does get used 👍
def addItem(item):
    # iteration 👍
    for itemListLength in range(len(itemList)):
        #print(f"{i} {len(itemList)}")
        # If you have a slot called "EMPTY" it will replace that
        if itemList[itemListLength] == "EMPTY":
            itemList[itemListLength] = item
            break
        # If you dont have an empty slot (I dont think this is possible in game)
        # It will ask you to replace an item
        if itemListLength == len(itemList) - 1:
            Utils.printFormattedLine("Your backpack is full")
            Utils.printFormattedLine("Do you want to replace an item you have?")
            listItems()
            Utils.printTrimmer()
            match input(""):
                case "yes":
                    Utils.printTrimmer()
                    Utils.printFormattedLine("What item do you want to replace?")
                    Utils.printTrimmer()
                    itemToDrop = input("")
                    # print(itemList)
                    # the variable *might* of been called "userPlayerInputForDroppingInFortnite" at some point in development
                    #for a in range(len(userPlayerInputForDroppingInFortnite)):
                    #print("a")

                    for ItemListLength2 in range(len(itemList)):
                        # print("b")
                        # print(f"{userPlayerInputForDroppingInFortnite} + {itemList[b]}")
                        # i am unsure why i call you a "drongo" for trying to replace empty
                        # this should be impossible to get to if you have empty slots
                        if itemToDrop.lower() == itemList[ItemListLength2].lower():
                            if itemToDrop == "EMPTY":
                                Utils.printFormattedLine("nice try drongo")
                                Utils.printTrimmer()
                                break
                            else:
                                itemList[ItemListLength2] = item
                                listItems()
                                break
                case _:
                    Utils.printFormattedLine(f"You just left \"{item}\" on the ground")
                    Utils.printTrimmer()


def listItems():
    itemString = str("")
    # I found out you can times strings together
    # its kinda weird but it works
    itemString += "| Items:"
    # print("| You have: ", end="| ")
    i = 0
    for entry in itemList:
        if entry != "EMPTY":
            # if entry isnt empty then adds it to what should be printed
            itemString += " | " + entry
            # print(a, end=" | ")
        else:
            # a counter to see how many empty slots you have
            i += 1
        # if 5 empty slots then you are item less
        if i == 5:
            itemString = "| You have no items"
    if i != 5:
        # a lil formatting at the end
        itemString += " |"
    itemStringlen = len(itemString)
    # timesing strings to add spaces at the end
    itemString += " " * (52 - itemStringlen)
    Utils.printTrimmer()
    # a lil formatting at the end v2
    print(itemString + "|")
    Utils.printTrimmer()

def hasAnyItems():
    # i think i could of used something else in here for this but it was too easy not to make
    for Items in itemList:
        if Items != "EMPTY":
            return True
    return False

def useItem(Item):
    # just removes an item from your inventory
    for counter in range(len(itemList)):
        if Item == itemList[counter]:
            # print("deez")
            itemList[counter] = "EMPTY"
            # listItems()
            break

def hasItem(Item):
    # checks if you own an item
    # used for the jukebox
    counter = 1
    for Items in itemList:
        # print(f"{a} + {Item}")
        if Items == Item:
            return True
        else:
            counter += 1
        # returns false if you lack the needed item
        if counter == len(itemList):
            return False
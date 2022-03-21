import Utils
itemList = ["EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY"]
def backpack():
    print("| You have: ", end="| ")
    for a in itemList:
        if a != "EMPTY":
            print(a, end = " | ")
    print()
    Utils.printFormattedLine("Do you want to use an item? | Yes | No")
    match input(""):
        case "yes":
            Utils.printFormattedLine("What item do you want to use?")
            itemInput = input("")
            for b in itemList:
                if itemInput.lower() == b.lower():
                    if itemInput != "EMPTY":
                        Utils.printFormattedLine(f"You used {b} !!!!!!")
        case _:
            Utils.printFormattedLine("You didnt use an item")
def addItem(item):
    for i in range(len(itemList)):
        #print(f"{i} {len(itemList)}")
        if itemList[i] == "EMPTY":
            itemList[i] = item
            break
        if i == len(itemList) - 1:
            Utils.printFormattedLine("Your backpack is full bozo")
            Utils.printFormattedLine("Do you want to replace an item you have?")
            listItems()
            Utils.printTrimmer()
            match input(""):
                case "yes":
                    Utils.printTrimmer()
                    Utils.printFormattedLine("What item do you want to replace?")
                    Utils.printTrimmer()
                    userPlayerInputForDroppingInFortnite = input("")
                    # print(itemList)
                    #for a in range(len(userPlayerInputForDroppingInFortnite)):
                    #print("a")
                    for b in range(len(itemList)):
                        # print("b")
                        # print(f"{userPlayerInputForDroppingInFortnite} + {itemList[b]}")
                        if userPlayerInputForDroppingInFortnite.lower() == itemList[b].lower():
                            if userPlayerInputForDroppingInFortnite == "EMPTY":
                                Utils.printFormattedLine("nice try drongo")
                                Utils.printTrimmer()
                                break
                            else:
                                itemList[b] = item
                                listItems()
                                break
                case _:
                    Utils.printFormattedLine(f"You just left \"{item}\" on the ground")
                    Utils.printTrimmer()


def listItems():
    itemString = str("")
    itemString += "| Items:"
    # print("| You have: ", end="| ")
    i = 0
    for a in itemList:
        if a != "EMPTY":
            itemString += " | " + a
            # print(a, end=" | ")
        else: i += 1
        if i == 5:
            itemString = "| You have no items"
    if i != 5:
        itemString += " |"
    itemStringlen = len(itemString)
    itemString += " " * (52 - itemStringlen)
    Utils.printTrimmer()
    print(itemString + "|")
    Utils.printTrimmer()

def useItem(Item):
    for a in range(len(itemList)):
        if Item == itemList[a]:
            # print("deez")
            itemList[a] = "EMPTY"
            # listItems()
            break

def hasItem(Item):
    i = 1
    for a in itemList:
        # print(f"{a} + {Item}")
        if a == Item:
            return True
        else: i += 1
        if i == len(itemList):
            return False
import Utils
itemList = ["EMPTY", "nuts", "EMPTY", "EMPTY", "deez"]
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
        if itemList[i] == "EMaPTY":
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
                    print(itemList)
                    #for a in range(len(userPlayerInputForDroppingInFortnite)):
                    #THIS DOESNT WORK YOU FUCKER
                    #FUCKING STUPID
                    print("a")
                    for b in range(len(itemList)):
                        print("b")
                        print(f"{userPlayerInputForDroppingInFortnite} + {itemList[b]}")
                        if userPlayerInputForDroppingInFortnite.lower() == itemList[b].lower():
                            if userPlayerInputForDroppingInFortnite == "EMPTY":
                                Utils.printFormattedLine("nice try drongo")
                            else:
                                itemList[b] = userPlayerInputForDroppingInFortnite
                                print(itemList)
                case _:
                    Utils.printFormattedLine(f"You just left \"{item}\" on the ground")
                    Utils.printTrimmer()


def listItems():
    print("| You have: ", end="| ")
    for a in itemList:
        if a != "EMPTY":
            print(a, end=" | ")
    print()
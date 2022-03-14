import Utils
itemList = ["EMPTY", "nuts", "EMPTY", "EMPTY", "deez"]
def backpack():
    print("| You have: ", end="")
    for a in itemList:
        if a != "EMPTY":
            print(a, end = " ")
    Utils.printFormattedLine("Do you want to use an item?")
    itemInput = input("")
    for b in itemList:
        if itemInput.lower() == b.lower():
            if itemInput != "EMPTY":
                Utils.printFormattedLine("You used an item !!!!!!")
def score():
    score = 0
    while True:
        string = input(str("add or check?\n"))
        match string:
            case "add":
                number = int(input("what number to add\n"))
                score += number
            case "check":
                print(score)


def getFirstLetter(str, firstLetter):
    if str[0] == firstLetter:
        return True
    else:
        return False


def move(input):
    match input:
        case "w" | "a" | "s" | "d":
            print(f"You moved {input}")
        case "bongo":
            print("print()")
        case _:
            print("drongo")


userInput = input("what u wanna do?\nscore or firstletter\n")
match userInput:
    case "score":
        score()
    case "firstletter":
        string = input("WHaT string do you want to check\n")
        thefirstletter = input("first letter u wanna check?\n")
        if getFirstLetter(string, thefirstletter):
            print("Same first letter")
        else:
            print("Not same first letter ")
    case "move":
        movement = input("move?\n")
        move(movement)

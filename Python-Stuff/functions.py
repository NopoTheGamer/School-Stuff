def score():
    score = 0
    while True:
        string = input(str("add or check?\n"))
        if string == "add":
            score += 1
        elif string == "check":
            print(score)
        else:
            print("bozo")


score()

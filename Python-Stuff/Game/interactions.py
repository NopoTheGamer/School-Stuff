import Room1
import Room2
import Stats
import Utils
import webbrowser
import Items


def interactWithRoom(arg):
    Utils.printTrimmer()
    match arg:
        case "computer":
            Utils.printFormattedLine("You see a computer")
            Utils.printFormattedLine("You turn it on and there is a prompt")
            Utils.printFormattedLine("It asks you \"Are you sure\"")
            Utils.printTrimmer()
            match input(""):
                case "yes":
                    webbrowser.open("https://www.youtube.com/watch?v=dQw4w9WgXcQ", new=1, autoraise=True)
                    Utils.printTrimmer()
                    Utils.printFormattedLine("The 1987 hit song \"Never gonna give you up\" plays")
                    Utils.printFormattedLine("The CD drive opens")
                    Utils.printFormattedLine("You pick up the CD for \"Never gonna give you up\"")
                    Items.addItem("CD")
                case "no":
                    print("""⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣶⣿⣿⣿⣿⣿⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣿⣿⣿⠿⠟⠛⠻⣿⠆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣆⣀⣀⠀⣿⠂⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠻⣿⣿⣿⠅⠛⠋⠈⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⢼⣿⣿⣿⣃⠠⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣟⡿⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣛⣛⣫⡄⠀⢸⣦⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⣴⣾⡆⠸⣿⣿⣿⡷⠂⠨⣿⣿⣿⣿⣶⣦⣤⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣤⣾⣿⣿⣿⣿⡇⢀⣿⡿⠋⠁⢀⡶⠪⣉⢸⣿⣿⣿⣿⣿⣇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣿⣿⣿⣿⣿⣿⣿⣿⡏⢸⣿⣷⣿⣿⣷⣦⡙⣿⣿⣿⣿⣿⡏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⣿⣿⣿⣿⣿⣿⣿⣿⣇⢸⣿⣿⣿⣿⣿⣷⣦⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢹⣿⣵⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣯⡁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀""")
                case _:
                    Utils.printFormattedLine("You just leave and walk away")
            Room1.computer = True
            Utils.printTrimmer()
            Room1.room1()
        case "toolbox":
            Utils.printFormattedLine("You open up the toolbox and find a shovel.")
            Stats.attack += 3
            Utils.printFormattedLine(f"You gain +3 attack! Your attack is now {Stats.attack}")
            Utils.printTrimmer()
            Room1.toolbox = True
            Room1.room1()
        case "power inverter":
            Utils.printFormattedLine("You spot a power inverter.")
            Utils.printFormattedLine("You turn it and it makes a loud noise")
            Utils.printFormattedLine("The lights turn on and you can see a crate")
            Utils.printFormattedLine("You open it up and you find a gold coin")
            Utils.printTrimmer()
            Items.addItem("Coin")
            Items.listItems()
            Utils.printTrimmer()
            Room1.powerinverter = True
            Room1.room1()
        case "vending machine":
            Room2.vendingMachine = True
            Utils.printFormattedLine("You spot a vending machine")
            if Items.hasItem("Coin"):
                Utils.printFormattedLine("Do you want to put your coin into it?")
                Utils.printTrimmer()
                match input("").lower():
                    case "yes":
                        Items.useItem("Coin")
                        Utils.printTrimmer()
                        Utils.printFormattedLine("You put in the coin and out comes a chug splash")
                        Items.addItem("Chug splash")
                    case _:
                        Utils.printFormattedLine("You are spooked by it so you walk away")
            else:
                Utils.printFormattedLine("You dont have any money so you walk away")
            Room2.room2()
        case "play dough":
            Room2.playDough = True
            Items.addItem("Play Dough")
            Utils.printFormattedLine("You picked up a tub of play dough")
            Room2.room2()
        case "flash light":
            Room2.flashLight = True
            Utils.printFormattedLine("You pick up a flash light")
            Utils.printFormattedLine("On the table next to you")
            Utils.printFormattedLine("There is AA and AAA batteries")
            Utils.printFormattedLine("What batteries do you want to put in?")
            Utils.printTrimmer()
            match input("").lower():
                case "aa":
                    Utils.printTrimmer()
                    Utils.printFormattedLine("You slide in the batteries and turn it on")
                    Utils.printFormattedLine("The flash light short circuits and becomes unusable")
                case "aaa":
                    Utils.printTrimmer()
                    Room2.flashLightOn = True
                    Utils.printFormattedLine("You slide in the batteries and turn it on")
                    Utils.printFormattedLine("The flashlight produces a powerful beam")
                    Utils.printFormattedLine("Now you can see more of the room")
            Room2.room2()
        case "jukebox":
            Room2.jukebox = True
            if Items.hasItem("CD"):
                Items.useItem("CD")
                webbrowser.open("https://www.youtube.com/watch?v=yPYZpwSpKmA", new=1, autoraise=True)
                Utils.printFormattedLine("You put your cd in")
                Utils.printFormattedLine("\"Together forever\" Starts playing")
                # you get forever togertherd'd
                Utils.printFormattedLine("A part of the jukebox opens")
                Utils.printFormattedLine("You pick up a sword from the jukebox")
                Utils.printFormattedLine("+2 attack")
                Stats.attack += 2
            else:
                Utils.printFormattedLine("It looks like it takes a CD to play")
                Utils.printFormattedLine("You dont have a CD so you walk away")
            Room2.room2()



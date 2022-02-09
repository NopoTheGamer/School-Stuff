from time import sleep

if __name__ == "__main__":
    # I stole the idea from zak
    def funnidots():
        s = "."
        while True:
            print(s)
            s += "."
            sleep(1 / 100)
            print("\033c")


    # runs swag neofetch
    def neofetch():
        print(r"""                        [0;34m-`                    nopo[0;37m@[0;34mnopo
                           [0;34m.o+`                   [0;37m---------
                         [0;34m.`ooo/                   OS[0;37m: Arch Linux x86_64
                        [0;34m.`+oooo:                  Host[0;37m: OMEN by HP Laptop 15-dh0xxx
                       [0;34m.`+oooooo:                 Kernel[0;37m: 5.16.1-arch1-1
                       [0;34m.-+oooooo+:                Uptime[0;37m: 1 hour, 26 mins
                     [0;34m.`/:-:++oooo+:               Packages[0;37m: 958 (pacman)
                    [0;34m.`/++++/+++++++:              Shell[0;37m: zsh 5.8
                   [0;34m.`/++++++++++++++:             Resolution[0;37m: 1920x1080, 1920x1080
                  [0;34m.`/+++ooooooooooooo/`           WM[0;37m: i3
                 [0;34m../ooosssso++osssssso+`          Theme[0;37m: Breeze [GTK2/3]
                [0;34m..oossssso-``\``/ossssss+`        Icons[0;37m: breeze-dark [GTK2/3]
               [0;34m.-osssssso.      :ssssssso.        Terminal[0;37m: kitty
              [0;34m.:osssssss/        osssso+++.       CPU[0;37m: Intel i7-9750H (12) @ 4.500GHz
             [0;34m./ossssssss/        +ssssooo/-       GPU[0;37m: NVIDIA GeForce GTX 1660 Ti Mobile
           [0;34m.`/ossssso+/:-        -:/+osssso+-     Memory[0;37m: 2626MiB / 15875MiB
          [0;34m.`+sso+:-`                 `.-/+oso:
         [0;34m.`++:.                           `-/+/
        [0;34m. .`                                 `/ [m""")
        maininput()


    # I asked for some ideas and someone told me to make this
    def converter():
        converterInput = input("What would you like to convert\n(1) KG to Pounds\n(2) Pounds to KG\n")
        if converterInput == "1":
            kg = float(input("Enter the amount of kilograms you would like to convert to pounds\n"))
            pounds = kg * 2.205
            print(f"{kg} kg is {pounds} pounds")
            maininput()
        elif converterInput == "2":
            pounds = float(input("Enter the amount of pounds you would like to convert to kilograms\n"))
            kg = pounds * 0.454
            print(f"{pounds} pounds is {kg} kilograms")
            maininput()
        else:
            print("Invalid input")
            maininput()


    # Main loop
    def maininput():
        textInput = input("What would you like to run\n(1) dots display\n(2) neofetch\n(3) converter\n")
        if textInput == "1":
            funnidots()
        elif textInput == "2":
            neofetch()
        elif textInput == "3":
            converter()
        else:
            print("Invalid input")
            maininput()


    maininput()

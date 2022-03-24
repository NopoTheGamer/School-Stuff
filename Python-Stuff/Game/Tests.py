import Items

def test():
    # I dont think this is how a test is really meant to be done
    # but it does test the items function so i guess it works 👍
    Items.listItems()
    Items.addItem("test")
    Items.listItems()
    Items.useItem("test")
    Items.listItems()
    print("You should of gained a 'test' item and then lost it")

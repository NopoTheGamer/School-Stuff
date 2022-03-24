import Items
def test():
    Items.listItems()
    Items.addItem("test")
    Items.listItems()
    Items.useItem("test")
    Items.listItems()
    print("You should of gained a 'test' item and then lost it")

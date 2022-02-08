b = "Hello, World!"
import time

# import only system from os
import os

# import sleep to show output for some time period
from time import sleep

x = 1
s = "."

while True:
    print(s)
    s += "."
    sleep(1/100)
    print("\033c")

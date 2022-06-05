# writes a bunch of test scenarios for dice construction
# with string

import random

TESTSIZE = 40

# setup

# x coordinate in string encoding
positions = list("abcdefg")

alphabet = list ("abcdefghijklmnopqrstuvwxyz")

# generation
tests = []

# generate tests
for _ in range (TESTSIZE):
    # dice
    x = random.randrange (len(positions)-1)                                 # x
    y = random.randrange (1,7)                                              # y
    player1 = random.randrange (0,2) == 1                                   # player1?
    top = random.randrange (1,6)                                            # top
    choices = [x for x in range (1, 6) if (x != top and 7 - top != x)]
    wh = random.randrange (len(choices) - 1)
    front = choices[wh]                                                     # front

    # orientation
    o = alphabet[((top - 1) * 4 + wh) % 26]
    orientation = o.capitalize() if player1 else o

    # encoding
    pos = positions[x] + str(y)

    tests.append ((x, y - 1, player1, top, front, orientation, pos))

# writing
f = open ("diceStringTest.txt", "w")

# dice
f.write ("// dice\n")
f.write ("Dice[] dice = new Dice[] {\n")
for (_,_,_,_,_,o, p) in tests:
    f.write (f' new Dice("{o}{p}"),\n')
f.write ("};\n\n")

# strings
f.write ("// strings\n")
f.write ("String[] strings = new String[] {\n")
for (_,_,_,_,_,o, p) in tests:
    f.write (f' "{o}{p}",\n')
f.write ("};\n\n")

f.close()
print ("done")

# writes a bunch of test scenarios for dice construction
# with string

import random

TESTSIZE = 20

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
f = open ("dicetest.txt", "w")

# inputs
f.write ("// inputs\n")
f.write ("String[] inputs = new String[] {\n")
for (_,_,_,_,_,o, p) in tests:
    f.write (f' "{o}{p}",\n')
f.write ("};\n\n")

# expected pos
f.write ("// positions\n")
f.write ("Position[] expectedPos = new Position[] {\n")
for (x,y,_,_,_,_,_) in tests:
    f.write (f" new Position ({x}, {y}),\n")
f.write ("};\n\n")

# expected player
f.write ("// players\n")
f.write ("Player[] expectedPlayer = new Player[] {\n")
for (_,_,p,_,_,_,_) in tests:
    f.write (f" Player.PLAYER{'1' if p else '2'},\n")
f.write ("};\n\n")

# expected top
f.write ("// top\n")
f.write ("int[] expectedTop = new int[] {\n")
for (_,_,_,t,_,_,_) in tests:
    f.write (f" {t},")
f.write ("};\n\n")

# expected front
f.write ("// front\n")
f.write ("int[] expectedFront = new int[] {\n")
for (_,_,_,_,k,_,_) in tests:
    f.write (f" {k},")
f.write ("};\n\n")

f.close()
print ("done")

import random
from collections import deque 

TESTLENGTH = 10
DECKLENGTH = 5
LOWERSHIFT = -5
HIGHERSHIFT = 4

output = []

for i in range (TESTLENGTH):
    deck = deque()
    for j in range (DECKLENGTH):
        deck.append (random.randint(0,10))

    for k in range (LOWERSHIFT, HIGHERSHIFT):
        decc = deck.copy()
        decc.rotate (k)
        output.append ((deck, k, decc))

# print to file
f = open ("shifttests.txt", "w")


f.write ("int[][] preshift = new int[][] {\n")
for (pre, _, _) in output:
    f.write ("new int[] { ")
    for i in pre:
        f.write (str(i) + ",")
    f.write ("},\n")
f.write ("};\n")
    
f.write ("int[] shift = new int[] {\n")
for (_, n, _) in output:
    f.write (str(n) + ", ")
f.write ("};\n")
 
f.write ("int[][] postshift = new int[][] {\n")
for (_, _, post) in output:
    f.write ("new int[] {")
    for i in post:
        f.write (str(i) + ",")
    f.write ("},\n")
f.write ("};\n")

f.close()


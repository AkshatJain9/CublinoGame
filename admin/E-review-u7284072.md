## Code Review

Reviewed by: Akshat Jain, u7284072

Reviewing code written by: Chris Kim

Component: [Contra-Heuristic-Basic](https://gitlab.cecs.anu.edu.au/u7279868/comp1140-ass2-thu11r/-/blob/master/src/comp1140/ass2/AI/Heuristics/ContraHeuristicBasic.java#L21-49)

### Comments 

Code is concise, understandable an is an appropriate Contra heuristic which can be used by an AI
and it matches how evaluation was done in other areas of the assignment. There are no unreasonable inefficiencies which will be helpful in AI computation since this method may need to be called several times on multiple inputs. 

Documentation is sufficient for understanding and style follows Java conventions and reads well with the rest of the 
assignment. Variable names are appropriate and aid the understanding of the functions. The structure of the overall code also provides some guidance on how other Heuristics can be made.

Good use of external functions to abstract some logic to other objects. No unecessary complications in the code either. No errors found. You can replace "pieceDiffHeuristic + diceW.size() - diceB.size();" with just "diceW.size() - diceB.size();" but that is a minor criticism. Some whitespace could be removed between lines but that's more of a personal preference.



## Code Review

Reviewed by: Justin Tieu, u7280302

Reviewing code written by: Akshat Jain, u7284072

Component: `getLegalMoves` and `allJumps` in [purGame](https://gitlab.cecs.anu.edu.au/u7279868/comp1140-ass2-thu11r/-/blob/master/src/comp1140/ass2/Game/PurGame.java#L85-158)

### Comments 
The code is written in a very efficient manner, the use of an iterative breadth first search in `allJumps` ensures that general complexity of the code is kept low which allows for better performance overall. Code contains lots of useful comments that explain how the algorithms work in the different methods. The `allJumps` method serves as a helper method for the `getLegalMoves` method which is ideal as functionality from `allJumps` can be used in other methods, this is an appropriate use of methods. The methods however do exhibit an excessive amount of nesting which can make the code more difficult to read, for example, on line 94, instead of nesting everything inside the case where `board.getAtIndex` is not null, the condition can check for a null value and use the `continue` keyword, keeping everything on the same indent. The code does follow Java code conventions; all the methods start with a lowercase letter and use camel case and all variables inside the methods also use this same convention. I do not suspect there is an error in the code.


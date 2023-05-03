# Calculator

Simple calculator that execute basic mathematical operation

### How it works
All the calculator logic is located at the *Calculation.java* class, in the *calc package*, and the process of receiving the user input, is located at the *UserInput.java* class, in the *input package*.

First: he program uses the *input* function in the UserInput class to verify through a regex if the expression has only numbers (since the calculator can't use letters yet), if the match is ok, it then passes the expression to *expression* function, also with regex, it takes all the string and separate each number and signal into a list, and return it.

Second: Now that the expression was dissolved in a list, it goes to the calculation part of the program. At first, the program looks in the list for any parenthesis aside of any number, and insert a multiplication sign between them, then it goes again in the list, searching for the deepest parenthesis, and calculate the expression inside it, after the calculations, the program put the result back in the same index of where it was taken from. The program runs it recursively until the list has the lenth of one.

### Usage
First, clone the repository.
```console
git clone https://github.com/rafaeltxc/Calculator/
```
Once it's opened, build the project and run *Frame.java* located at the *gui package* in the source folder, this class is responsible for running the JFrame application.

After running it, a new window should appear in your workspace. Because of dimensioning problems, if the window open just as a black screen, try to resize it for a bigger size, after that, the calculator should appear, and it's ready for use. It's possible to write the expression with the keyboard, or through the GUI.

### Problems
The calculator can excute all the operations, returning the right result and with no problems, however, when writing an expression with parenthesis, that are some calculations that can break the program. For example the expression: 
```console
2+((2+2)+2)+2
```
Will fail. The way that the program reads the expression, makes that it can't read the second parenthesis properly.

And a second problem is that the JFrame interface don't show the calculator as soon as you run the program.

### Plans
The project is still very simple, but the ideia is to transform it into a complete scientific calculator, and to develop a better GUI without JFrame, since it's very limited in lots of aspects.

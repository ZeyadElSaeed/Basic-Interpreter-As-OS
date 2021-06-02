# Basic-Interpreter-As-OS


Project Objective :
The best way for you to understand the concepts of an Operating System is to build
an operating system and then to experiment with it to see how the OS manages
resources and processes. In this project, you are asked to build a simulation of an
operating system.

Milestone 1 :
In this milestone, you are asked to implement a basic interpreter. You have a text
file that represents a program. When you read that text file and start executing it,
it becomes a process. You are provided with 3 text files, each representing
a program. You are asked to create an interpreter that reads the txt
files and executes their code.

System Calls :
A system call is the process’s way of interacting with the Operating System. In
order for a process to be able to use any of the available hardware, it makes a
request, system call, to the operating system.
Types of system calls required:

1. Read the data of any file from the disk.
2. Write text output to a file in the disk.
3. Print data on the screen.
4. Take text input from the user.
5. Reading data from memory.
6. Writing data to memory.

Programs :
We have 3 main Programs:
Program 1:
It should take input from the user: a filename. Then print the content of this file
on the screen.
Program 2:
It should take two inputs from the user: a filename, and some data. Then write
the data to the file.
Program 3:
It should take 2 numbers as input from the user, and perform the addition of these
numbers. The output of the addition should be displayed on the screen.

Program Syntax :
For the programs, the following syntax is used:
• print: to print the output on the screen. Example: print x
• assign: to initialize a new variable and assign a value to it. Example: assign x y, where x is the variable and y is the value assigned. The value could be an integer number, or a string
• add: to perform the summation of 2 numbers. Example: add x y, where x and y are the 2 values summed, and the result of the summation is saved in x.
• writeFile: to write data to a file. Example: writeFile x y, where x is the filename and y is the data.
• readFile: to read data from a file. Example: readFile x, where x is the filename

Output :
For this Milestone, your Simulated OS should be able to read the provided programs and execute them sequentially.
  
Work Distribution :
• Code parser/interpreter, the print and input instructions.
• The assign instruction with all its sub cases.
• The add, read file and write file instructions.

You will work in teams of strictly 3. You should register your team through the
following link: https://forms.gle/A11T5hGFpz9e122T8 by maximum Tuesday,
11th of May. The programming language that you will use is JAVA. The project
should be submitted as ONE zip folder containing the java files you created. Please
make sure to name your folder as follows, Team_number (ex. Team_00). Late
submissions will not be accepted. Submission will be through the following link:
https://forms.gle/SJnXfygxoPiwgzqp6.

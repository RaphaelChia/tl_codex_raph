# tl_codex_raphael
### Table of Contents
- [Question 1](#ex1---the-nearest-available-room)
  - [Design Considerations](#application-design-considerations)
  - [pre-req](#setup-pre-requisites)
  - [Instructions](#instructions)
- [Question 2](#ex2)
  - [The big Problem](#the-big-problem-negation-vs-subtraction)
  - [pre-req](#setup-pre-requisites-1)
  - [Instructions](#instructions-1)

![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png)
# EX1 - The Nearest Available Room
When reading the question, there are 3 things that came to my mind:
1. Can i think of an algorithm to find the nearest available room?
1. How do i manage the states?
1. How do continuously read the inputs to interact with the application?

##### An algorithm to find the nearest available room
After giving some thought about time and space complexity, trying using as little space to represent the hotel rooms, i decided to roll with a 1 Dimensional Fixed Array. The mode of finding the nearest available room is a simple traversal of the array, which has a time complexity of o(n).

#### State Management
To manage the states, I engaged the **state design pattern** to allow a class to 'morph' into multiple different states and allow different actions depending on the state.

#### Input Output
Since we have to allow multiple input commands repititively, i decided to go with a menu-option CLI type application.

## Application Design Considerations
- **Scalability:** For now, it is a hotel booking application, but being able to scale out into other booking application is important.
- **Change proof:** A menu-option CLI type application might be required to change its options now and then.

## Setup pre-requisites:
- Have Java 8 JDK installed and ready in your environment. Double check by typing `java --version` in your console.
- Have maven installed ready in your environment. Double check by typing `mvn --version` in your console.
- Ensure you have internet connection that is not being any proxy.

## Instructions:
#### Running the program:
1. Navigate to ex1 folder
1. Run in the console: `mvn clean compile exec:java "-Dexec.mainClass=codex.tl.App"`

#### Ex1 Sample

![Requesting Room](https://user-images.githubusercontent.com/54928277/189200590-4745c0eb-b42e-4810-ba7f-68de4e9380f3.png) 
![Request Successful](https://user-images.githubusercontent.com/54928277/189200750-74418551-382d-4bc4-b9e1-9f4fbeb959f0.png)
![Mark repair Failed](https://user-images.githubusercontent.com/54928277/189201303-57f0666c-730e-4f2f-8025-de7d5b3798fa.png)


#### Running JUnit Tests:
1. Navigate to ex1 folder
1. Run in the console: `mvn clean test`

#### Junit test Results:
![demo](https://user-images.githubusercontent.com/54928277/189200226-44b69456-49dc-4141-ace9-32bf5a2d58da.png)


![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png)
# EX2
Reading the question, i know that multiple algorithms are required to make this work. The first thing that came to my mind was
**How are programs evluating arithmetic expressions?**
After some reasearch, i found that one of the best ways to evaluate arithmetic expressions for computers was to convert infix expressions into postfix expressions. Hence, the solution that i intend to come up with revolves around the idea of: 
```
 Convert infix expression > postfix > Binary Tree > compute Binary Tree using preorder depth first search.
```
Converting a string to binary tree and then traversing a binary tree are just leet code questions with solutions all over the internet. The problem for me, is managing the precedence of the operators and negatives.

### The big problem: Negation VS Subtraction
Precedence of the operators was ok, but solving this problem took me the longest time. I devised a solution to this problem that would fix it during the conversion of postfix expression into a binary tree, and no matter how i do it, it seems to have flaws here and there. I finally found an explanation online as to how to differentiate and when should i step in to fix this problem. Eventually, i got it to work by fixing this problem during the conversion from infix to postfix expression. Now, equations such as -4-(-3*2) would work like a charm too.

## Setup pre-requisites:
- Have python 3 installed
- Ensure python keyword is accessible globally (if not, go to environment variables and set it)

## Instructions: 
#### Running the program:
1. Navigate into ex2 folder 
1. Run the command `python ex2.py`

#### Ex2 Sample

![Example1](https://user-images.githubusercontent.com/54928277/189201910-65d4f1d4-74ef-44d3-b174-cf0efde58fb1.png)
![Example2](https://user-images.githubusercontent.com/54928277/189202010-9f6b6f53-36a6-4292-b1ec-7ae04fe1b546.png)

#### Running python unittest:
1. Navigate into ex2 folder 
1. Run: `python -m unittest test_ex2.py -vvv`

#### Python Unittest Results
![image](https://user-images.githubusercontent.com/54928277/189203405-7710f93b-32b5-4759-b6f7-f3fd562c42f8.png)

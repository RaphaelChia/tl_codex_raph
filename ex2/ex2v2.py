'''
IDEA:   To convert Arithmetic string expression >  postfix > binary tree > compute using depth first search.
        When it reaches a postfix notation, the precedence of the operators are already settled.
        Just add it into the binary tree, and then 
'''

from constants import Operators, Priority
from dfs_calc import dfs

class Node:
    def __init__(self,data=0.0,left=None,right=None):
        self.left = left
        self.right = right
        self.data = data


def infixToPostfix(arithmeticString):
    stack   = [] # initialization of empty stack
    output  = ''
    prev    = '' # Store the last character. This is for
    for character in arithmeticString:

        # We know there are 4 scenarios. If its open bracket, close bracket, operator, or digit.
        # After considering the negatives, there must be a total of 5 scenario.
        if character not in Operators:  # if digit, append in postfix expression
            output+= character
        elif character=='(':  # else Operators push onto stack
            stack.append('(')
        elif character==')': # closing bracket works differently, need to pop into output
            while stack and stack[-1]!='(':
                output+=stack.pop()
            stack.pop() # This is to pop the opening bracket just before finishing
        elif character=='-' and (prev=='' or prev in Operators) :
            output+='0'
            stack.append(character)
        else: 
            while stack and stack[-1]!='(' and Priority[character]<=Priority[stack[-1]]: # when reaches here, has to be operator already.
                output+=stack.pop() # If the incoming operator is lower priority, the stack last item gets popped into postfix output
            stack.append(character)
        prev=character
    # Handling the remaining operators in the stack            
    while stack:
        output+=stack.pop()
    return output


def strToTree(postFix: str)->Node:
    
    # if empty string
    if not postFix:
        return
    stack = [] # init stack
    
    for char in postFix:
        if char in Operators:
            # there will already be 2 nodes in the stack if we encounter 1 operator here
            # pop 2 number nodes and make the root the operator
            n1 = stack.pop()
            n2 = stack.pop()
            # append new node back into the stack. basically every 3 items will be combined
            # into one single node. e.g. ab+ will end up as + as the root, a b as the left right.
            stack.append(Node(char,n2,n1))
        else:
            # if its a digit, we just want to blankly add it to stack
            stack.append(Node(char))

    return stack[-1]


def main():
    expression = input('Enter infix expression ')
    postFixString = infixToPostfix(expression)
    print(postFixString)
    headNode = strToTree(postFixString)
    print(dfs(headNode))

if __name__ == "__main__":
    main()

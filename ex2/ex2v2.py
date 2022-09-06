'''
IDEA:   To convert Arithmetic string expression >  postfix > binary tree > compute using depth first search.
        When it reaches a postfix notation, the precedence of the operators are already settled.
        Just add it into the binary tree, and then 
ASSUME: -Balanced equation, meaning correct parernthesis
        -Correct symbols
        -Operands are int type not float
'''

from constants import Operators, Priority,Operators_without_closebracket
from dfs_calc import dfs

class Node:
    def __init__(self,data=0.0,left=None,right=None):
        self.left = left
        self.right = right
        self.data = data


def infixToPostfix(arithmeticString):
    stack           = [] # initialization of empty stack that will hold operators
    postfixStack    = [] # intialization of stack that will contain the nodes of final postfix form
    prev            = '' # Store the last character. This is for
    i=0
    while i < len(arithmeticString):
        character = arithmeticString[i]
        # We know there are 4 scenarios. If its open bracket, close bracket, operator, or digit.
        # After considering the negatives, there must be a total of 5 scenario.
        if character not in Operators:  # if digit, append in postfix expression
            # output+= character
            num = 0
            # i = idx
            while i<len(arithmeticString) and arithmeticString[i].isdigit():
                num = num * 10 + int(arithmeticString[i]) # In case its like 39+8*(6-2) <- this is to get the '39' as a whole
                i+=1
            postfixStack.append(Node(num))
            i-=1
        elif character=='(':  # else Operators push onto stack
            stack.append('(')
        elif character==')': # closing bracket works differently, need to pop into output
            while stack and stack[-1]!='(':
                # output+=stack.pop()
                postfixStack.append(Node(stack.pop()))
            stack.pop() # This is to pop the opening bracket just before finishing
        elif character=='-' and (prev=='' or prev in Operators_without_closebracket) :
            # output+='0'
            postfixStack.append(Node('0'))
            stack.append(character)
        else: 
            while stack and stack[-1]!='(' and Priority[character]<=Priority[stack[-1]]: # when reaches here, has to be operator already.
                # output+=stack.pop() # If the incoming operator is lower priority, the stack last item gets popped into postfix output
                postfixStack.append(Node(stack.pop()))
            stack.append(character)
        prev=character
        i+=1
    # Handling the remaining operators in the stack            
    while stack:
        # output+=stack.pop()
        postfixStack.append(Node(stack.pop()))
    return postfixStack


def strToTree(postFix: list)->Node:
    # if empty string
    if not postFix:
        return
    stack = [] # init stack
    
    for charNode in postFix:
        if charNode.data in Operators:
            # there will already be 2 nodes in the stack if we encounter 1 operator here
            # pop 2 number nodes and make the root the operator
            n1 = stack.pop()
            n2 = stack.pop()
            # append new node back into the stack. basically every 3 items will be combined
            # into one single node. e.g. ab+ will end up as + as the root, a b as the left right.
            # stack.append(Node(charNode.data,n2,n1))
            charNode.left=n2
            charNode.right=n1
            stack.append(charNode)
        else:
            # if its a digit, we just want to blankly add it to stack
            stack.append(charNode)

    return stack[-1]


def main():
    expression = input('Enter infix expression ')
    postFixString = infixToPostfix(expression)
    # print(postFixString)
    headNode = strToTree(postFixString)
    print(dfs(headNode))

if __name__ == "__main__":
    main()

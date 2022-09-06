'''
IDEA:   To convert Arithmetic string expression >  postfix > binary tree > compute using depth first search.
        When it reaches a postfix notation, the precedence of the operators are already settled.
        Just add it into the binary tree, and then 
'''

from constants import Operators, Priority


class Node:
    def __init__(self,data=0.0,left=None,right=None):
        self.left = left
        self.right = right
        self.data = data


def infixToPostfix(arithmeticString):
    stack   = [] # initialization of empty stack
    output  = ''
    for character in arithmeticString:

        # We know there are 4 scenarios. If its open bracket, close bracket, operator, or digit.
        if character not in Operators:  # if digit, append in postfix expression
            output+= character
        elif character=='(':  # else Operators push onto stack
            stack.append('(')
        elif character==')': # closing bracket works differently, need to pop into output
            while stack and stack[-1]!='(':
                output+=stack.pop()
            stack.pop() # This is to pop the opening bracket just before finishing
        else: 
            while stack and stack[-1]!='(' and Priority[character]<=Priority[stack[-1]]: # when reaches here, has to be operator already.
                output+=stack.pop() # If the incoming operator is lower priority, the stack last item gets popped into postfix output
            stack.append(character)
        prev=character
    # Handling the remaining operators in the stack            
    while stack:
        output+=stack.pop()
    return output



def main():
    expression = input('Enter infix expression ')
    postFixString = infixToPostfix(expression)
    print(postFixString)


if __name__ == "__main__":
    main()

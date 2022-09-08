'''
IDEA:   To convert Arithmetic infix string expression > postfix > binary tree > compute using depth first search.
        When it reaches a postfix notation, the precedence of the operators are already settled.
        
ASSUME: -Balanced equation, meaning correct parernthesis
        -Correct symbols
        -Operands are int type not float
        -No spaces in the input string

ISSUE:  Negation and subtract uses the same sign but acts differently. 
        To solve this, while transforming it to postfix, i pad a 0 at the postfix result whenever i detect a negation 
            A subtract is when the minus sign comes after an digit, or closed bracket.
            A negation is when the minus sign comes after an operator, after an open bracket, or is at the start of the infix string.
'''

from dfs_calc import dfs
from util import *


def main():
    expression = input('Enter infix expression ')
    postfixList = infixToPostfix(expression)
    headNode = strToTree(postfixList)
    print(f"Final Result: {dfs(headNode)}")
    print("Displaying Binary Tree in preorder fashion:") 
    preOrderTraverse(headNode)

if __name__ == "__main__":
    main()

    # Pytest verbosity
    
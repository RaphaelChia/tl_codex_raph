'''
IDEA:   To convert Arithmetic string expression >  postfix > binary tree > compute using depth first search.
        When it reaches a postfix notation, the precedence of the operators are already settled.
        Just add it into the binary tree, and then 
ASSUME: -Balanced equation, meaning correct parernthesis
        -Correct symbols
        -Operands are int type not float
'''

from dfs_calc import dfs
from util import *


def main():
    expression = input('Enter infix expression ')
    postFixString = infixToPostfix(expression)
    # print(postFixString)
    headNode = strToTree(postFixString)
    print(dfs(headNode))
    print("Displaying Binary Tree in preorder fashion:")
    preOrderTraverse(headNode)

if __name__ == "__main__":
    main()

    # Pytest verbosity
    
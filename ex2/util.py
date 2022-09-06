from constants import Operators, Priority,Operators_without_closebracket


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
        # After considering the negatives vs negation, there must be a total of 5 scenarios.
        if character not in Operators:  # if digit, append in postfixStack
            num = 0
            # here im finding out if there's multi digit numbers like 23 or 348
            while i<len(arithmeticString) and arithmeticString[i].isdigit():
                num = num * 10 + int(arithmeticString[i]) # In case its like 39+8*(6-2) <- this is to get the '39' as a whole
                i+=1
            postfixStack.append(Node(num))
            i-=1
        elif character=='(':  # else Operators push onto stack
            stack.append('(')
        elif character==')': # closing bracket works differently, need to pop into output
            while stack and stack[-1]!='(':
                postfixStack.append(Node(stack.pop()))
            stack.pop() # This is to pop the opening bracket just before we finish matching the close bracket
        elif character=='-' and (prev=='' or prev in Operators_without_closebracket) :
            postfixStack.append(Node('0'))
            stack.append(character)
        else: 
            while stack and stack[-1]!='(' and Priority[character]<=Priority[stack[-1]]: # when reaches here, has to be operator already.
                # If the incoming operator is lower priority than stack, the stack last item gets popped into postfixStack
                # e.g.  incoming: -
                #       top of stack: *
                #       * has higher priority, so * goes into postfixStack first, while - goes into stack
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

def preOrderTraverse(rootNode: Node):
    if not rootNode:
        return
    print(f"{rootNode.data} ",end='')
    preOrderTraverse(rootNode.left)
    preOrderTraverse(rootNode.right)



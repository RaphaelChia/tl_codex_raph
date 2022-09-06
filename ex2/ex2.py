'''
@Author: Raphael Chia Song Zuo
@Date: 5 September 2022

LIMITATIONS:
1)  Negative numbers will not work specifically if its at the start of the number like so:
    (-4+2)
    3*(-6+4)

    This is due to the method of representing the arithmetic equation in a Binary Tree AT THE SAME TIME
    using a depth first search to compute the Arithmetic Tree. An example is shown below:
    An arithmetic of 4+(-2+8) is very different from 4+-(2+8), but the Arithmetic Tree representation 
    of the data, coupled with using DFS to compute, makes it so that there's no way of differentiating 
    between the 2 equations.

Potential Solution:
1)  We could implement a different way of representing the data
'''
# Assuming balanced equation
# Assume that equation will always be in the simplest form, a {operand} b, 
#   Never as such: a {operand} b {operand} c    
# Assuming no decimals in string arithmetic input



from constants import op_list
from dfs_calc import dfs
 


class Node:
    def __init__(self,data=0.0,left=None,right=None):
        self.left = left
        self.right = right
        self.data = data

op_list = {"+", "-", "/", "*"}
def str_to_tree(s:str) -> Node:
    if not s:
        return None
    stack = []
    input_length = len(s) 
    i = 0 # current string index
    while i < input_length: 
        if s[i] in op_list: # o(1)
            stack.append(Node(s[i])) # o(1)
        elif s[i].isdigit(): 
            num = 0
            while i<input_length and s[i].isdigit():
                num = num * 10 + int(s[i]) # In case its like 39+8*(6-2) <- this is to get the '39' as a whole
                i+=1
            stack.append(Node(num))
            i-=1
        elif s[i]==')': 

            right_node = stack.pop() 
            if stack[-2].data in op_list and stack[-2].left==None and stack[-2].right == None:
                # Checking if there are 2 BASE arithmetic side by side
                # accounting for negative numbers A.K.A (4/2)*-16
                first_arithmetic_node = stack.pop() 
                parent_node = stack[-1] # second arithmetic
                left_node = stack.pop(-2)
                parent_node.right = first_arithmetic_node
                parent_node.left = left_node
                first_arithmetic_node.right = right_node
            else:    
                left_node = stack.pop(-2)
                parent_node = stack[-1] 
                parent_node.right = right_node
                parent_node.left = left_node
       
        i+=1
    # need to handle for if there is no more brackets but still stuff left in the stack 
    if len(stack)==4:
        # accounting for negative numbers
        right_node = stack.pop() 
        first_arithmetic_node = stack.pop() 
        parent_node = stack[-1] # second arithmetic
        left_node = stack.pop(-2)
        parent_node.right = first_arithmetic_node
        parent_node.left = left_node
        first_arithmetic_node.right = right_node
    elif len(stack)==3:
        right_node = stack.pop() 
        left_node = stack.pop(-2)
        parent_node = stack[-1] 
        parent_node.right = right_node
        parent_node.left = left_node
       

    return stack[0]


def main():
    arithmetic_string = input("Input arithmetic string without spaces: ")
    headNode = str_to_tree(arithmetic_string)
    print2D((headNode))
    print(dfs(headNode))

if __name__ == "__main__":
    main()



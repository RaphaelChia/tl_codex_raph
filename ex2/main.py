'''
@Author: Raphael Chia Song Zuo
@Date: 5 September 2022
'''
# Assuming balanced equation
# Assume that equation will always be in the simplest form, a {operand} b, 
#   Never a {operand} b {operand} c    
# Assuming no decimals in string arithmetic input


class Node:
    def __init__(self,data=0.0,left=None,right=None):
        self.left = left
        self.right = right
        self.data = data

op_list = {"+", "-", "/", "*"}
def str_to_tree(s:str) -> Node:
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
            if stack[-2] in op_list:
                # Checking if there are 2 arithmetic side by side
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
    arithString = input("Input arithmetic string without spaces: ")
    headNode = str_to_tree(arithString)


if __name__ == "__main__":
    main()



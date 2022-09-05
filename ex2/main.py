

# Assuming balanced equation
# Assuming no decimals in string arithmetic input

class Node:
    def __init__(self,data=0.0,left=None,right=None):
        self.leftNode = left
        self.rightNode = right
        self.data = data

op_list = {"+", "-", "/", "*"}
def str_to_tree(s:str) -> Node:
    stack = []
    input_length = len(s) 
    curr_string_idx = 0
    while curr_string_idx < input_length:
        if s[curr_string_idx] in op_list:
            #does it like an arithmetic
            print(f"{s[curr_string_idx]} is arithmetic!")
        elif s[curr_string_idx].isdigit():
            print(f"{s[curr_string_idx]} is number!")
            #does it like its a number
        elif s[curr_string_idx]==')':
            print(f"{s[curr_string_idx]} is closed bracket!")
            #pop stack and assign nodes
        else:
            print(f"{s[curr_string_idx]} is open bracket!")
        curr_string_idx+=1
            
def main():
    arithString = input("Input arithmetic string without spaces: ")
    str_to_tree(arithString)

if __name__ == "__main__":
    main()
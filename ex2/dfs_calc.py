#Depth first search
from constants import op_list
def dfs(current_node)->float:
    if not current_node:
        return 0
    if current_node.data in op_list:
        return do_calculation(dfs(current_node.left), dfs(current_node.right), current_node.data)
    return current_node.data

def do_calculation(op1, op2, operator):
    if operator == "/":
        return float(op1) / float(op2)
    if operator == "*":
        return float(op1) * float(op2)
    if operator == "+":
        return float(op1) + float(op2)
    if operator == "-":
        return float(op1) - float(op2)
    return None


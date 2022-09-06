Operators = set(['+','-','*','/','(',')'])  # unique collection of Operators
Operators_without_closebracket = set(['+','-','*','/','('])  # unique collection of Operators
Priority = {'+':1,'-':1,'*':2,'/':2} # dictionary having priorities of Operators, because * and / need to be evaluated first.


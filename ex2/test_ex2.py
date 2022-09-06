import unittest
import ex2v2 as ex2
from dfs_calc import dfs

class TextEx2(unittest.TestCase):
    # def test_str2tree_correctResultRootNode(self):
    #     self.assertEqual(ex2.strToTree("4+-2").data,"+")
    #     self.assertEqual(ex2.strToTree("4-2").data,"-")
    #     self.assertEqual(ex2.strToTree("((4*(2+10))+(3*4))+-16").data,"+")
    #     self.assertEqual(ex2.strToTree("(4+-2)*(6/3)").data,"*")

    # def test_ex2_correctEndToEnd(self):
    #     self.assertEqual(dfs(ex2.strToTree("4+-2")),2.0)
    #     self.assertEqual(dfs(ex2.strToTree("-4-2")),-6.0)
    #     self.assertEqual(dfs(ex2.strToTree("((4*(2+10))+(3*4))+-16")),44.0)
    #     self.assertEqual(dfs(ex2.strToTree("(4+-2)*(6/3)")),4.0)

    def test_infix2Postfix_BoundaryTest(self):
        self.assertEqual(ex2.infixToPostfix("4+-2"),"402-+")
        self.assertEqual(ex2.infixToPostfix("4-(-9/4)"),"4094/--")
        self.assertEqual(ex2.infixToPostfix("-6+(3-2)*9-3"),"06-32-9*+3-")
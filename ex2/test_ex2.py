import unittest
import ex2
from dfs_calc import dfs

class TextEx2(unittest.TestCase):

    @classmethod
    def setUpClass(cls) -> None:
        print("Starting All Tests...\n")
        # unittest.main(verbosity=2)

    @classmethod
    def tearDownClass(cls) -> None:
        print("\nAll tests ended!")

    def test_ex2End2EndSuccess_Brackets(self):
        astr1 = "4+(3/(6*5))-4*8"
        astr2 = "4-(3+0)"
        astr3 = "((15/(7-(1+1)))*-3)-(2+(1+1))" # Default example
        astr4 = "6*(-3+1)"
        astr5 = "-(4-3)-(3*2)"
        
        self.assertEqual(dfs(ex2.strToTree(ex2.infixToPostfix(astr1))),-27.9)
        self.assertEqual(dfs(ex2.strToTree(ex2.infixToPostfix(astr2))),1)
        self.assertEqual(dfs(ex2.strToTree(ex2.infixToPostfix(astr3))),-13)
        self.assertEqual(dfs(ex2.strToTree(ex2.infixToPostfix(astr4))),-12)
        self.assertEqual(dfs(ex2.strToTree(ex2.infixToPostfix(astr5))),-7)

    def test_ex2End2EndSuccess_Chaining(self):
        astr1 = "4+3/6*5-4*8"
        astr2 = "4--3"
        astr3 = "--4-3"
        astr4 = "-4*-3+1"
        astr5 = "-4-3-3*2"
        
        self.assertEqual(dfs(ex2.strToTree(ex2.infixToPostfix(astr1))),-25.5)
        self.assertEqual(dfs(ex2.strToTree(ex2.infixToPostfix(astr2))),7)
        self.assertEqual(dfs(ex2.strToTree(ex2.infixToPostfix(astr3))),1)
        self.assertEqual(dfs(ex2.strToTree(ex2.infixToPostfix(astr4))),13)
        self.assertEqual(dfs(ex2.strToTree(ex2.infixToPostfix(astr5))),-13)

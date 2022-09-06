import unittest
import ex2
from dfs_calc import dfs

class TextEx2(unittest.TestCase):
    def test_str2tree_correctResultRootNode(self):
        self.assertEqual(ex2.str_to_tree("4+-2").data,"+")
        self.assertEqual(ex2.str_to_tree("4-2").data,"-")
        self.assertEqual(ex2.str_to_tree("((4*(2+10))+(3*4))+-16").data,"+")
        self.assertEqual(ex2.str_to_tree("(4+-2)*(6/3)").data,"*")

    def test_ex2_correctEndToEnd(self):
        self.assertEqual(dfs(ex2.str_to_tree("4+-2")),2.0)
        self.assertEqual(dfs(ex2.str_to_tree("-4-2")),-6.0)
        self.assertEqual(dfs(ex2.str_to_tree("((4*(2+10))+(3*4))+-16")),44.0)
        self.assertEqual(dfs(ex2.str_to_tree("(4+-2)*(6/3)")),4.0)
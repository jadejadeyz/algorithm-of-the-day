class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def isMirror(self, tree1, tree2):
        if tree1 is None and tree2 is None:
            return True
        if tree1 is None or tree2 is None:
            return False
        return tree1.val == tree2.val and self.isMirror(tree1.left, tree2.right) and self.isMirror(tree1.right, tree2.left)


    def isSymmetric(self, root: TreeNode) -> bool:
        return self.isMirror(root, root)

from collections import deque

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def levelOrderBottom(self, root: TreeNode):
        if not root:
            return []

        if not root.left and not root.right:
            return [[root.val]]


class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None



class Tree:
    def __init__(self, data):
        self.root = Node(data)



    def inOrderTraversal(self, node):
        if node != None:
            self.inOrderTraversal(node.left)
            print(node.data)
            self.inOrderTraversal(node.right)



def getHeight(node):
    if node is None:
        return -1

    return max(getHeight(node.left), getHeight(node.right)) + 1


def isBalance(node):
    if node is None:
        return True

    diff = getHeight(node.left) - getHeight(node.right)

    if abs(diff) > 1:
        return False
    else:
        return isBalance(node.left) and isBalance(node.right)

def checkheight(node):
    if node is None:
        return -1

    leftHeight = checkheight(node.left)
    if leftHeight == -2:
        return -2

    rightHeight = checkheight(node.right)
    if rightHeight == -2:
        return -2

    diff = leftHeight - rightHeight
    if abs(diff) > 1:
        return -2
    else:
        return max(leftHeight, rightHeight) + 1

def isBalance2(node):
    return checkheight(node) != -2


def checkBST(node):
    return checkBSTHelper(node, None, None)


def checkBSTHelper(node, minimum, maximum):
    if node is None:
        return True

    if minimum is not None and node.data <= minimum or maximum is not None and node.data > maximum:
        return False

    if checkBSTHelper(node.left, minimum, node.data) == False or checkBSTHelper(node.right, node.data, maximum) == False:
        return False

    return True



n1 = Node(2)
n2 = Node(1)
n3 = Node(30)
n4 = Node(0)
n5 = Node(40)
n6 = Node(6)

n1.left = n2
n1.right = n3
n3.left = n4
n3.right = n5

print(checkBST(n1))
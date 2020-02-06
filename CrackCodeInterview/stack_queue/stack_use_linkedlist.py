class Node:
    def __init__(self, val):
        self.val = val
        self.next = None


class Stack:
    def __init__(self):
        self.top = None


    def isEmpty(self):
        return self.top is None


    def push(self, val):
        if self.isEmpty():
            self.top = Node(val)
        else:
            node = Node(val)
            node.next = self.top
            self.top = node


    def pop(self):
        if self.isEmpty():
            raise RuntimeError('No item to pop!')
        else:
            val = self.top.val
            self.top = self.top.next
            return val


    def peek(self):
        if self.isEmpty():
            raise RuntimeError('Empty Stack!')

        return self.top.val



stack = Stack()
for i in range(5):
    stack.push(i)
    print(stack.peek())

print('-----')

for i in range(6):
    print(stack.pop())

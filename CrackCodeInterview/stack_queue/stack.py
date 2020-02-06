class Stack:
    def __init__(self):
        self.stack = []
        self.top = -1
        self.max_size = 10000

    def isEmpty(self):
        if self.top < 0:
            return True
        else:
            return False

    def push(self, val):
        if self.top == self.max_size - 1:
            raise OverflowError('Stack is full! No place to push.')
        else:
            self.top += 1
            self.stack.append(val)


    def pop(self):
        if self.isEmpty():
            raise OverflowError('Stack is empty! No item to pop.')
        else:
            self.top -= 1
            return self.stack.pop()


    def peek(self):
        if self.isEmpty():
            raise OverflowError('Stack is empty.')
        else:
            return self.stack[self.top]


class StackWithMin(Stack):
    def __init__(self):
        self.minStack = Stack()


    def getMin(self):
        if self.minStack.isEmpty():
            return 0xffffffffffff
        else:
            return self.minStack.peek()


    def push(self, val):
        if val < self.getMin():
            self.minStack.push(val)

        super().push(val)


    def pop(self):
        value = super().pop()
        if value == self.minStack.peek():
            self.minStack.pop()

        return value


stack = StackWithMin()
a = [3, 1, 5, -1, 7]
for i in a:
    stack.push(i)
stack.pop()
stack.pop()
print(stack.peek())
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


4
stack = Stack()
print(stack.isEmpty())
array = [i for i in range(10)]
for i in array:
    stack.push(i)
for i in array:
    print(stack.pop())
stack.pop()

print(stack.peek())
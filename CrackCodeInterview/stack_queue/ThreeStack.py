class ThreeStack:
    def __init__(self, length):
        self.stack_starts = [0, length // 3, length // 3 * 2]
        self.tops = [-1, self.stack_starts[0]-1, self.stack_starts[1]-1]
        self.stack = [0 for _ in range(length)]
        self.total_length = length


    def isEmpty(self, stack_id):
        return self.tops[stack_id-1] == -1 or self.tops[stack_id-1] == self.stack_starts[stack_id-2]-1


    def isFull(self, stack_id):
        if stack_id == 3:
            return self.tops[stack_id-1] == self.total_length - 1
        else:
            return self.tops[stack_id-1] == self.stack_starts[stack_id]-1


    def push(self, val, stack_id):
        if self.isFull(stack_id):
            raise Exception("Stack is full!")

        self.tops[stack_id-1] += 1
        self.stack[self.tops[stack_id-1]] = val


    def pop(self, stack_id):
        if self.isEmpty(stack_id):
            raise Exception('Stack is empty!')

        self.tops[stack_id-1] -= 1
        return self.stack[self.tops[self.stack_id-1]+1]


    def peek(self, stack_id):
        if self.isEmpty():
            print('Empty Stack {}'.format(stack_id))

        return self.stack[self.tops[stack_id-1]]


ts = ThreeStack(10)
for i in range(1, 4):
    ts.push(i, 1)

for i in range(11, 14):
    ts.push(i, 2)

for i in range(101, 105):
    ts.push(i, 3)


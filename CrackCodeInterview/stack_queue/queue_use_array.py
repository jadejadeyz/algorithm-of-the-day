class Queue:
    def __init__(self, length):
        self.head = 0
        self.tail = 0
        self.length = length
        self.queue = [0 for _ in range(length)]


    def isEmpty(self):
        return self.head == self.tail


    def isFull(self):
        return self.head == 0 and self.tail == self.length - 1 or self.head == self.tail + 1


    def add(self, val):
        if self.isFull():
            raise RuntimeError('Queue is full!')
        else:
            self.queue[self.tail] = val
            self.tail = (self.tail + 1) % self.length


    def remove(self):
        if self.isEmpty():
            raise RuntimeError('Queue is empty!')
        else:
            val = self.queue[self.head]
            self.head = (self.head + 1) % self.length
            return val


    def peek(self):
        if self.isEmpty():
            raise RuntimeError('Queue is empty!')
        else:
            return self.queue[self.head]



q = Queue(6)
for i in range(5):
    q.add(i)

q.remove()
q.remove()
q.add(11)
q.add(12)
for i in range(5):
    print(q.remove())



class Node:
    def __init__(self, val):
        self.val = val
        self.next = None


class Queue:
    def __init__(self):
        self.first = None
        self.last = None


    def isEmpty(self):
        return self.first == None


    def add(self, val):
        if self.isEmpty():
            self.first = Node(val)
            self.last = self.first
        else:
            self.last.next = Node(val)
            self.last = self.last.next


    def remove(self):
        if self.isEmpty():
            raise RuntimeError('Empty Queue!')

        val = self.first.val
        self.first = self.first.next
        return val


    def peek(self):
        if self.isEmpty():
            raise RuntimeError('Empty Queue!')
        return self.first.val



q = Queue()
for i in range(5):
    q.add(i)

q.remove()
q.remove()
q.add(21)
q.add(22)
q.add(23)
q.add(24)
q.add(25)

while not q.isEmpty():
    print(q.remove())
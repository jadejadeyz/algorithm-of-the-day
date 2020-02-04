class SingleLinkedList:
    head = None

    def __init__(self, val):
        if SingleLinkedList.head is None:
            SingleLinkedList.head = self
        self.value = val
        self.next = None


    def addNode(self, val):
        node = SingleLinkedList(val)
        current = SingleLinkedList.head
        while current.next:
            current = current.next

        current.next = node

    def deleteNode(self, val):
        if val == SingleLinkedList.head.value:
            SingleLinkedList.head = SingleLinkedList.head.next
            return

        current = SingleLinkedList.head

        while current.next and current.value != val:
            prev = current
            current = current.next

        prev.next = current.next

    def printList(self):
        current = SingleLinkedList.head
        while current:
            print(current.value, end='  ')
            current = current.next


    def removeDups(self):
        hashset = set()
        hashset.add(SingleLinkedList.head.value)
        prev = SingleLinkedList.head
        curr = SingleLinkedList.head.next
        while curr:
            if curr.value in hashset:
                prev.next = curr.next
            hashset.add(curr.value)
            prev = curr
            curr = curr.next

    def runnerRemoveDups(self):
        curr = SingleLinkedList.head
        runner = SingleLinkedList.head.next
        while curr:
            prev = curr
            runner = curr.next
            while runner:
                if runner.value == curr.value:
                    prev.next = runner.next
                prev = runner
                runner = runner.next
            curr = curr.next


    def kth2Last(self, k):
        curr = SingleLinkedList.head
        runner = curr
        while k > 0:
            runner = runner.next
            k -= 1

        while runner:
            curr = curr.next
            runner = runner.next

        # print(curr.value)
        return curr




if __name__ == "__main__":
    values = [1, 2, 3, 2, 4, 3]
    linkedlist = SingleLinkedList(0)
    for v in values:
        linkedlist.addNode(v)

    # linkedlist.deleteNode(4)
    linkedlist.printList()
    # linkedlist.removeDups()
    # linkedlist.runnerRemoveDups()
    # print()
    print()
    kthlast = linkedlist.kth2Last(3).value
    print(kthlast)
    # linkedlist.printList()


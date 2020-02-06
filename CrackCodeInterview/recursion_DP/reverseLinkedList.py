class Node:
    def __init__(self, val):
        self.val = val
        self.next = None


def createList(values):
    head = Node(values[0])
    current = head
    for i in range(1, len(values)):
        current.next = Node(values[i])
        current = current.next

    return head

def reverseLinkedList(seq):
    if seq is None or seq.next is None:
        return seq

    new_head = reverseLinkedList(seq.next)
    seq.next.next = seq
    seq.next = None

    return new_head

def printList(seq):
    if seq is None:
        print('Empty Linked List.\n')

    while seq:
        print(seq.val, end='  ')
        seq = seq.next
    print('\n')



a = [1, 2, 3, 4]
linkedlist = createList(a)
printList(linkedlist)
printList(reverseLinkedList(linkedlist))

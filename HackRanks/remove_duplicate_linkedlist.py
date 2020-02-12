class Node:
    def __init__(self, data):
        self.data = data
        self.next = None



def removeDups(head):
    if not head or head.next is None:
        return head


    cur = head.next
    prev = head


    while prev.next:
        if prev.data == cur.data:
            prev.next = cur.next
            cur = cur.next
        else:
            cur = cur.next
            prev = prev.next


    return head


def printList(head):
    while head.next:
        print(head.data, end=" ")
        head = head.next

    print(head.data)


head = Node(1)
a = [2, 2, 3, 4]
cur = head
for i in a:
    cur.next = Node(i)
    cur = cur.next

printList(removeDups(head))

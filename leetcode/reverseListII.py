class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def reverseBetween(self, head, m, n):
        if m == n or head is None:
            return head

        current = head
        for i in range(m-1):
            prev = current
            current = current.next
        holder = current.next.next

        num = n - m
        while current.next and num > 0:
            current.next.next = current
            current = current.next
            holder = holder.next.next
            num -= 1

        if m > 1:
            prev.next.next = holder
            prev.next = current
            return head
        else:
            head.next = holder
            return current


def printList(head):
    while head:
        print(head.val, end='  ')
        head = head.next
    print('\n')


nodes = []
for i in range(1, 7):
    nodes.append(ListNode(i))

for i in range(len(nodes)-1):
    nodes[i].next = nodes[i+1]

solution = Solution()
printList(nodes[0])
newhead = solution.reverseBetween(nodes[0], 2, 3)
printList(newhead)

# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        if not l1:
            return l2
        if not l2:
            return l1

        if l1.val < l2.val:
            res = ListNode(l1.val)
            l1 = l1.next
        else:
            res = ListNode(l2.val)
            l2 = l2.next

        current = res


        while l1 != None and l2 != None:
            if l1.val < l2.val:
                current.next = l1
                l1 = l1.next
                current = current.next
            else:
                current.next = l2
                l2 = l2.next
                current = current.next

        if l1 == None:
            current.next = l2
            return res

        if l2 == None:
            current.next = l1
            return res


    def printResult(self, res):
        while res != None:
            print(res.val, end=', ')
            res = res.next
        print('\n')

l1 = ListNode(1)
x = ListNode(2)
l1.next = x

l2 = ListNode(1)
y = ListNode(3)
z = ListNode(5)
l2.next = y
y.next = z

s = Solution()
s.mergeTwoLists(l1, l2)

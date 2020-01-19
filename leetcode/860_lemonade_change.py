"""
At a lemonade stand, each lemonade costs $5.

Customers are standing in a queue to buy from you, and order one at a time (in the order specified by bills).

Each customer will only buy one lemonade and pay with either a $5, $10, or $20 bill.
You must provide the correct change to each customer, so that the net transaction is that the customer pays $5.

Note that you don't have any change in hand at first.

Return true if and only if you can provide every customer with correct change.
"""

class Solution:
    def lemonadeChange(self, bills) -> bool:
        income = {5:0, 10:0}

        if not bills:
            return True

        if bills[0] > 5:
            return False

        for bill in bills:
            if bill == 5:
                income[5] += 1

            if bill == 10:
                if income[5] > 0:
                    income[5] -= 1
                    income[10] += 1
                else:
                    return False

            if bill == 20:
                if income[10] > 0 and income[5] > 0:
                    income[10] -= 1
                    income[5] -= 1
                elif income[10] == 0 and income[5] > 2:
                    income[5] -= 3
                else:
                    return False

        return True


if __name__ == "__main__":
    s = Solution()
    x = input('test case: ')
    while x != '.':
        x = [int(i) for i in x.split()]
        print(s.lemonadeChange(x))
        x = input('test case: ')


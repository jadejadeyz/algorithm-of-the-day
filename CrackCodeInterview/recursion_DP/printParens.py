def printParens(n):
    result = getParens(n)
    for i in result:
        print(i)


def getParens(n):
    if n < 1:
        return []
    if n == 1:
        return ["()"]

    result = []
    subset = getParens(n-1)
    for item in subset:
        result.extend(combineOneMore(item))
    return result


def combineOneMore(string):
    if symmetric(string):
        return ['()'+string, '('+string+')']
    return ['()'+string, string+'()', '('+string+')']


def symmetric(string):
    for i in range(len(string)):
        if i % 2 == 0 and string[i] != '(':
            return False
        if i % 2 == 1 and string[i] != ')':
            return False
    return True



printParens(3)

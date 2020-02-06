def allPermutation(string):
    return permuteHelper(string, 0, len(string)-1)

def permuteHelper(string, start, end):
    if end == start:
        return [string[start]]

    subList = permuteHelper(string, start, end-1)
    resultPermutations = []
    for seq in subList:
        combinedSeq = [rotate(seq + string[end], i) for i in range(len(seq)+1)]
        resultPermutations.extend(combinedSeq)

    return resultPermutations

def rotate(string, i):
    if i == 0:
        return string
    return string[i:] + string[:i]

class Permutations:
    def __init__(self, string):
        self.string = string
        self.letterDict = self.getHashDict()
        self.result = []


    def getHashDict(self):
        hashtable = {}
        for c in self.string:
            if c not in hashtable:
                hashtable[c] = 1
            else:
                hashtable[c] += 1
        return hashtable


    def getPermutations(self, prefix, remaining):
        if remaining == 0:
            self.result.append(prefix)
            return

        for key in self.letterDict:
            count = self.letterDict[key]
            if count > 0:
                self.letterDict[key] -= 1
                self.getPermutations(prefix+key, remaining-1)
                self.letterDict[key] += 1




seq = Permutations("aabc")
seq.getPermutations("", len(seq.string))
print(seq.result)

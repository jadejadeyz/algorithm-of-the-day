class Tower:
    def __init__(self):
        self.disks = []


    def addDisk(self, val):
        self.disks.append(val)


    def addMultipleDisks(self, values):
        self.disks = [v for v in values]


    def moveDisk(self, tower):
        disk = self.disks.pop()
        tower.addDisk(disk)


    def solveHanoi(self, n, destination, buffer):
        if n > 0:
            self.solveHanoi(n-1, buffer, destination)
            self.moveDisk(destination)
            buffer.solveHanoi(n-1, destination, self)


    def showTower(self):
        for i in self.disks:
            print(i, end='  ')
        print('\n')



A = Tower()
B = Tower()
C = Tower()

A.addMultipleDisks([1, 2, 3, 4])
A.solveHanoi(4, C, B)
C.showTower()
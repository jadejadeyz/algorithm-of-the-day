def countingValleys(n, s):
    atValley = False
    counts = 0
    altitude = 0

    for step in s:
        delta = 1 if step == 'U' else -1
        altitude += delta
        if altitude < 0 and atValley == False:
            counts += 1
            atValley = True
        if altitude >= 0:
            atValley = False

    return counts

steps = "U D D D U D U U U U D D D"
print(countingValleys(8, steps.split()))


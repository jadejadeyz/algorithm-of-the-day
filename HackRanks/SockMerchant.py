def sockMerchant(ar):
    inventory = {}
    for sock in ar:
        if sock in inventory:
            inventory[sock] += 1
        else:
            inventory[sock] = 1

    pairs = 0
    for sock in inventory:
        pairs += (inventory[sock] // 2)

    return pairs

ar = "1 1 3 1 2 1 3 3 3 3"

print(sockMerchant(ar.split()))
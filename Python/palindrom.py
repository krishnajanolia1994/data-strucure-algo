list = [1,2,3,2,1,2]
i=0
j= len(list)-1

isPalindrom=True

while(i<j):
    if(list[i] != list[j]):
        isPalindrom=False
        break
    i+=1
    j-=1

print(isPalindrom)
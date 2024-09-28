
num="123432124567876543234567890987654321"

digits = [0]*10
i=0
while i< len(num):
    print(num[i])
    digits[int(num[i])]+=1
    i+=1

print(digits)

even=[]
odd=[]
for val in digits:
    if((val%2)==0):
        even.append(val)
    else:
        odd.append(val)

maxOdd = -1
for val in odd:
    if val>maxOdd:
        maxOdd=val

result=""

if maxOdd >-1:
    result+=str(maxOdd)
freq=0
for val in even:
    freq= digits[val]
    freq//=2
    print((str(val))*freq)

print(result)


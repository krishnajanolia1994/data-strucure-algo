S="aaaabbaa"
ar=[[0]*len(S) for _ in range(len(S))]
print(ar)
i=0
maxI=0
maxJ=0
while i<len(S):
    ar[i][i]=1
    i+=1
i=0
j=1
print(ar)

print(ar,11)
while j<len(S):
    if S[i]==S[j]:
        ar[i][j]=2
        maxI=i
        maxJ=j
    i+=1
    j+=1
        
        
        

i=0
j=2
print(ar,25)
while j<len(S):
    if S[i]==S[j] and ar[i+1][j-1]!=0:
        print("inside",i,j )
        ar[i][j]=2+ar[i+1][j-1]
        if ar[maxI][maxJ]<ar[i][j]:
            maxI=i
            maxJ=j
    if j==(len(S)-1):
        j=j-i+1
        i=0
    else:
        i+=1
        j+=1
print(maxI,maxJ)
print(S[maxI:maxJ+1])
        
        
            
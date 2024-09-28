def removeDu(i,s):
    j=i
    
    while j<len(s)-1:
        print(s[j],s[j+1])
        if s[j]==s[j+1]:
            print("in")
            s.pop(j)
            s.pop(j)
            print(s)
            if(j==0):
                removeDu(0,s)
            else:
                removeDu(j-1,s)
        j+=1
    return s



s = "geeksforgeek_"

#li=removeDu(0,list(s))
#print("".join(li))
#gksforgk

print(2*s*2*3)

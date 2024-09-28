def perm(arr, i):
    if i==len(arr)-1:
        print("".join(arr))
    else:
        for j in range(i,len(arr)):
            swap(i,j,arr)
            perm(arr,i+1)
            swap(i,j,arr)
def swap(i,j,arr):
    ch=arr[i]
    arr[i]=arr[j]
    arr[j]=ch






perm(list("krishna"),0)

def MergeSort(arr,p,r):
    if p>=r:
        return
    q=(p+r)//2
    MergeSort(arr,p,q)
    MergeSort(arr,q+1,r)
    Merge(arr,p,q,r)

def Merge(arr,p,q,r):
    n1=q-p+1
    n2=r-q
    l=[]
    r=[]
    for i in range(n1):
        l[i]=arr[p+i]
    for i in range(n2):
        r[i]=arr[q+i+1]
    l[n1+1]=10e9
    r[n2+1]=10e9
    i=1
    j=1
    for k in range(p,r):
        if l[i]<=r[j]:
            arr[k]=l[i]
            i+=1
        else:
            arr[k]=r[j]
            j+=1

arr=[2,5,8,3,9,0,1,5,7]
MergeSort(arr,0,8)
print(arr)

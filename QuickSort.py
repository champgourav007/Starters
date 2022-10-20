def Partition(A,p,r):
    x=A[r]
    i=p-1
    for j in range(p,r):
        if A[j]<=x:
            i+=1
            A[i],A[j]=A[j],A[i]
    A[i+1],A[r]=A[r],A[i+1]
    return i+1

def QuickSort(A,p,r):
    if p<r:
        j=Partition(A,p,r)
        QuickSort(A,p,j-1)
        QuickSort(A,j+1,r)

arr=[0,7,6,9,1,4,5,2]
QuickSort(arr,1,7)
print(arr)
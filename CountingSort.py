def CountingSort(A):
    m=max(A)
    C=[0]*(m+1)
    for i in range(len(A)):
        C[A[i]]+=1
    for i in range(1,m+1):
        C[i]=C[i]+C[i-1]
    B=[0]*len(A)
    for i in range(len(A)-1,-1,-1):
        B[C[A[i]]-1]=A[i]
        C[A[i]]-=1
    return B

A=list(map(int,input().split()))
ans=CountingSort(A)
print("Sorted array : ",ans)

    
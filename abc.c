#include<stdio.h>
int main()
{
    int n,a[100],i,j,key;
    printf("enter the size of array:\n");
    scanf("%d",&n);
    prinf("enter array element:\n");
    for(i=0;i<n;i++)
    {
        scanf("%d",&a[i]);
    }
    for(j=1;j<n;j++)
    {
        key=a[j];
        i=j-1;
    while(i>0 && a[i}>key])
    {
        a[i+1]=a[i];
        i--;

    }
    a[i+1]=key;
    }
    printf("sorted array:");
    for(j=0;j<n;j++)
    {
    
    printf("%d",a[j]);
    }
}
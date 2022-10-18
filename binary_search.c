#include<stdio.h>
void main()
{
    int a[10],i,n,f,l,ele,c=0,mid,pos;
    printf("enter no of elements");
    scanf("%d",&n);
    printf("enter th elements");
    for(i=0;i<n;i++)
    {
      scanf("%d",&a[i]);
    }
    printf("enter the element to be searched");
    scanf("%d",&ele);
    f=0;
    l=n-1;

    while(f<=l)
    {
      mid=(f+l)/2;

      if(a[mid]>ele)
        l=mid-1;
      else if(a[mid]<ele)
        l=mid+1;
      else if(a[mid]==ele)
      {
          c=1;
          pos=mid+1;
          break;
      }
      if(c==1)
      printf("element found at %d position",pos);
    else
        printf("element not found");



    }
}

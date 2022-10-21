#include <bits/stdc++.h>
using namespace std;
int main(){
    int num;
    cout<<"enter the number: ";
    cin>>num;
    int temp=num;
    int rem=0,pal=0;
    while (num>0)
    {
       rem=num%10;
        pal=pal*10+rem;
         num/=10;

    }
    if(pal==temp)
    cout<<"yes! it is a pallindrome";
    else
    cout<<"not pallindrome";
    
}
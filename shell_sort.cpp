#include<bits/stdc++.h>
using namespace std;

void shell_sort(int a[], int n){
    int temp;
    for(int gap=n/2;gap>=1;gap=gap/2){
        for(int i=gap;i<n;i++){
            for(int j=i-gap;j>=0;j=j-gap){
                if(a[j+gap]>a[j])
                break;
                else
                {
                    temp=a[j+gap];
                    a[j+gap]=a[j];
                    a[j]=temp;
                }
            }
        }
    }
    for(int i=0;i<n;i++)
    cout<<a[i]<<" ";
}


int main(){
    int num;
    cout<<"enter the order of the array: ";
    cin>>num;
    cout<<"enter the elements: ";
    int arr[num];
    
    for (int  i = 0; i < num; i++)
    {
        cin>>arr[i];
    }
    shell_sort(arr,num);
}
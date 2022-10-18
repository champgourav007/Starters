#include<bits/stdc++.h>
using namespace std;


void selection_sort(int arr[],int n){
    int min,temp;
    for(int i=0;i<n;i++){
        min=i,temp=0;
        for(int j=i+1;j<n;j++){
            if(arr[min]>arr[j])
            min=j;
        }
        if(min!=i)
        swap(arr[min],arr[i]);
    }
    for(int i=0;i<n;i++)
    cout<<arr[i]<<" ";
}

int main(){
    int num;
    cout<<"enter the number: ";
    cin>>num;

    int arr[num];
    cout<<"enter the elements: ";

    for(int i=0;i<num;i++)
    cin>>arr[i];

    selection_sort(arr,num);
}
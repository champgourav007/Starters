# include<iostream>
# include<time.h>
# include<climits>
# include<chrono>
using namespace std;


void merging(int *arr,int start,int mid,int last){
    int i=start,j=mid+1,k=0;
    int *temp= new int[last-start+1];
    while(i<=mid && j<=last){
        if(*(arr+i)<= *(arr+j)){
        temp[k]=arr[i]; k++; i++;

        }
        else {temp[k]=arr[j]; k++; j++;}
        }
    while(i<=mid){
        temp[k]=arr[i]; k++; i++;
        }
    while(j<=last){
        temp[k]=arr[j]; k++; j++;
        }
    i=start;
    k=0;
    while(i<=last){
        arr[i]=temp[k];
        i++;
        k++;
        }
}

void mergesort(int *arr,int start , int endidx){
    if(start>=endidx) return;
    int mid=(start+endidx)/2;
    mergesort(arr,start,mid);
    mergesort(arr,mid+1,endidx);
    merging(arr,start,mid,endidx);

}

void mergeSort(int input[], int siz){

    mergesort(input,0,siz-1);

}


void swa(int &a, int &b){
    int temp=a; a=b;b=temp;
}







int main(){
    int n;
    int t;
    cin>>t;
    for(int i=0; i<t ;i++){
    cin>>n;
    int * arr= new int [n];
    for(int i=0; i<n; i++){
        arr[i]=rand();
    }
    auto start = std::chrono::high_resolution_clock::now();
    mergeSort(arr,n);


    auto elapsed = std::chrono::high_resolution_clock::now() - start;
     long long microseconds = std::chrono::duration_cast<std::chrono::microseconds>(elapsed).count();
    cout<<"time:"<<microseconds<<"microseconds \n";
    //cout<<"Array: \n";
   /* for(int i=0; i<n; i++){
        cout<<arr[i]<<" ";
    }
    cout<<"\n";
*/



}
}

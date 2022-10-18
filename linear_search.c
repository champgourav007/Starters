#include<stdio.h>

int linear_search(int num,int arr[],int key){
   int count=0;
    for(int i=0;i<num;i++){
        if(arr[i]==key){
           count++;
            break;
        }  
    }
    if(count>0){
        printf("The key is present.");
    }
    else
    printf("the key is not present");
}

int main(){
    int num;
    printf("Enter the order of the array: ");
    scanf("%d",&num);
    int arr[num];
    printf("Enter the elements of array: ");
    for (int i = 0; i < num; i++)
    {
        scanf("%d",&arr[i]);
    }
    int key;
    printf("Enter the key element to be found: ");
    scanf("%d",&key);

    linear_search(num,arr,key);

    
}
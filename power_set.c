//ALGORITHM
//1- START
//2- ENTER A STRING SET.
//3- FIRST CALCULATE THE SIZE OF THE SET i.e 2^n-1.
//4- NOW , CHECK IF THE BIT IS SET OR NOT BY CALCULATING N&(1<<M).
//5- IF THE BIT IS SET , PRINT RESPECTIVE CHAR.
//6- END


#include<stdio.h>
#include<math.h>
int main(){
    char arr[]={'a','b','c'};
   
    int size=pow(2,3);
    for (int i = 0; i < size; i++)
    {
        for (int  j = 0; j < 3; j++)
        {
            if(i&(1<<j))
            printf("%c ",arr[j]);
        }
        printf("\n");
    }
    
}
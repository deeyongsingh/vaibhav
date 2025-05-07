#include<stdio.h>
int number(int n){
    if(n>5){
        return 1;
    }
    printf("%d",n);
    return number(n+1);
}
int main(){
    int n;
    printf("enter your number:");
    scanf("%d",&n);
    number(n);
    return 0;
    
}
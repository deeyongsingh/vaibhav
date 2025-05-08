#include<stdio.h>
#define s 5
int stack[s];
int top=-1;
void push(int n){
    
    if(top==s-1){
        printf("stack is overflow");
    }
    else{
        top++;
        stack[top]=n;
    }
}
void display(){
    if(top == -1){
    printf("stack is empty:");
    }
    else{
        for(int i=top;i>=0;i--){
            printf("%d ",stack[i]);
        }
    }
}
void pop(){
    int n;
    if(top==-1){
        printf("stack is empty");
    }
    else{
        n=stack[top];
        top--;
        printf("popped element %d",n);
    }
}
int main(){
    push(10);
    push(20);
    push(30);
    pop();
    pop();
    push(10);
    
    push(40);
    display();
    return 0;
}
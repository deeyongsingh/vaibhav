#include<stdio.h>
#include<stdlib.h>
int main(){
    int row=3,column=3;
    int**ptr=(int**)malloc(row*sizeof(int*));
    for(int i=0;i<row;i++){
    ptr[i]=malloc(column*sizeof(int));
    }
    for(int i=0;i<row;i++){
        for(int j=0;j<column;j++){
            printf("enter a element:");
            scanf("%d",&ptr[i][j]);
        }
    }
    for(int i=0;i<row;i++){
        for(int j=0;j<column;j++){
            printf("%d",ptr[i][j]);
        }
        printf("\n");
    }
    for(int i=0;i<row;i++){
        free(ptr[i]);
    }
    free(ptr);
    return 0;
}
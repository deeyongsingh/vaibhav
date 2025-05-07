#include<stdio.h>
int main(){
   int number,count=0;

   for(;;){
      printf("enter a number:");
      scanf("%d",&number);
      if(number<0){
         count++;
         printf("negative number found:");
         break;
      }
   }
   return 0;
}
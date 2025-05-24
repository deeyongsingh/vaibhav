#include<stdio.h>
#include<string.h>
struct book{
    char title[50];
    float price;
    int quantity;
};
int main(){
    int n;
    float total=0,tax,gtotal;
    printf("enter the number of book:");
    scanf("%d",&n);

    struct book Books[n];
    for(int i=0;i<n;i++){
        printf("enter: detials of book %d\n",i+1);
        printf("Title:");
        scanf(" %[^\n]",Books[i].title);
        printf("price:");
        scanf("%f",&Books[i].price);
        printf("quantity:");
        scanf("%d",&Books[i].quantity);
        total += Books[i].price*Books[i].quantity;
    }
    tax=total*0.05;
    gtotal=total+tax;
    printf("\n\n-------BookStore Bill-------\n");
    printf("n0.  title                  prince     Qty      Total\n");
    printf("---------------------------------------------------------\n");
    for(int i=0;i<n;i++){
        printf("%-5d%-25s%-9.2f%-7d%.2f\n",i+1,Books[i].title,Books[i].price,Books[i].quantity,Books[i].price*Books[i].quantity);

    }

    printf("-----------------------------------------------------------\n");
    printf("subtotal:%.2f\n",total);
    printf("Tax(5%%):%.2f\n",tax);
    printf("GrandTotal:%.2f\n",gtotal);
    printf("--------------------------\n");
    return 0;

}
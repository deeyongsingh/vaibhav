#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#define MAX_BOOKS 100
  typedef struct {
    char title[100];
    int quantity;
    float price;
}Book;
typedef struct{
    char customername[50];
    Book books[MAX_BOOKS];
    int n;
    float total,tax,gtotal;
}Bill;
void createBill(){
    Bill bill;
  bill.total=0;
    printf("enter customer Name:");
   scanf(" %[^\n]",bill.customername);
    printf("enter the number of book:");
    scanf("%d",&bill.n);
      //struct book Books[bill.n];
    for(int i=0;i<bill.n;i++){
        printf("enter: detials of book %d\n",i+1);
        printf("Title:");
        scanf(" %[^\n]",bill.books[i].title);
        printf("price:");
        scanf("%f",&bill.books[i].price);
        printf("quantity:");
        scanf("%d",&bill.books[i].quantity);
        bill.total += bill.books[i].price*bill.books[i].quantity;
    }
        bill.tax=bill.total*0.05;
    bill.gtotal=bill.total+bill.tax;
     
    FILE *file = fopen("billpt.txt", "ab");
    if (file != NULL) {
        fwrite(&bill, sizeof(Bill), 1, file);
        fclose(file);
        printf("\nBill saved.\n");
    } else {
        printf("\nError.\n");
    }
 
}
void searchBill(){
    char searchname[50];
    Bill bill;
    printf("\n Enter Customer Name for search Bill: ");
    scanf("%[^\n]",searchname); 
    FILE *file = fopen("billpt.txt","rb");
    if(file==NULL){
        printf("\n No bill found!");
        return ;
    }
     
    //struct book Books[bill.n];
    while(fread(&bill, sizeof(Bill), 1, file)){
         if (strcmp(bill.customername, searchname) == 0){
          printf("\n\n\t\t-------BookStore Bill-------\n");
    printf("N0.  Customer Name                    title                        prince      Qty       Total\n");
    printf("------------------------------------------------------------------------------------------------\n");
    for(int i=0;i<bill.n;i++){
        printf("%-5d%-25s         %-30s%-7.2f   %-9d%.2f\n",i+1,bill.customername,bill.books[i].title,bill.books[i].price,bill.books[i].quantity,bill.books[i].price*bill.books[i].quantity);

    }

    printf("------------------------------------------------------------------------------------------------------\n");
    printf("subtotal:%.2f\n",bill.total);
    printf("Tax(5%%):%.2f\n",bill.tax);
    printf("GrandTotal:%.2f\n",bill.gtotal);
    printf("--------------------------\n");
         }
    }

    fclose(file);
}

int main(){
      int choice;
    do {
        printf("\n--- Bookstore Billing System ---\n");
        printf("1. Create and Save Bill\n");
        printf("2. search bill\n");
        printf("3. exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                createBill();
                break;
            case 2:
               searchBill();
               break;
            case 3:
            printf("exiting program:");
            break;
            default:
                printf("Invalid choice. Try again.\n");
        }
    } while (choice != 3);

    return 0;
}

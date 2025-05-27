#include<stdio.h>
#include<stdlib.h>
#include<string.h>
struct book{
    char title[100];
    int quantity;
    float price;
};
typedef struct{
    char customername[50];
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
      struct book Books[bill.n];
    for(int i=0;i<bill.n;i++){
        printf("enter: detials of book %d\n",i+1);
        printf("Title:");
        scanf(" %[^\n]",Books[i].title);
        printf("price:");
        scanf("%f",&Books[i].price);
        printf("quantity:");
        scanf("%d",&Books[i].quantity);
        bill.total += Books[i].price*Books[i].quantity;
    }
        bill.tax=bill.total*0.05;
    bill.gtotal=bill.total+bill.tax;
     printf("\n\n\t\t-------BookStore Bill-------\n");
    printf("n0.  Customer Name                  title                      prince       Qty       Total\n");
    printf("------------------------------------------------------------------------------------------------\n");
    for(int i=0;i<bill.n;i++){
        printf("%-5d%-25s     %-30s%-7.2f   %-9d%.2f\n",i+1,bill.customername,Books[i].title,Books[i].price,Books[i].quantity,Books[i].price*Books[i].quantity);

    }

    printf("------------------------------------------------------------------------------------------------------\n");
    printf("subtotal:%.2f\n",bill.total);
    printf("Tax(5%%):%.2f\n",bill.tax);
    printf("GrandTotal:%.2f\n",bill.gtotal);
    printf("--------------------------\n");
     
    FILE *file = fopen("billpt.dat", "ab");
    if (file != NULL) {
        fwrite(&bill, sizeof(Bill), 1, file);
        fclose(file);
        printf("\nBill saved successfully.\n");
    } else {
        printf("\nError saving the bill.\n");
    }
 
}
void searchBill(){
    char searchName[50];
    printf("\n Enter Customer Name for search Bill: ");
    scanf(" %[^\n]",searchName); 
    FILE *file = fopen("billpt.dat","rb");
    if(file==NULL){
        printf("\n No bill found!");
        return ;
    }
     Bill bill;
    struct book Books[bill.n];
    while(fread(&bill, sizeof(Bill), 1, file)){
         if (strcmp(bill.customername, searchName) == 0){
          printf("\n\n\t\t-------BookStore Bill-------\n");
    printf("N0.  Customer Name                  title                      prince       Qty       Total\n");
    printf("------------------------------------------------------------------------------------------------\n");
    for(int i=0;i<bill.n;i++){
        printf("%-5d%-25s     %-30s%-7.2f   %-9d%.2f\n",i+1,bill.customername,Books[i].title,Books[i].price,Books[i].quantity,Books[i].price*Books[i].quantity);

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

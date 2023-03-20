#include <stdio.h>

int main()
{
   int temp=0;
   int i=0;
   int max=0;
   int index=0;
   for(i=0;i<9;i++){
   scanf("%d",&temp);
   if(max<temp){
   max=temp;
   index=i;
   }
   }
   
   printf("%d\n",max);
   printf("%d",index+1);

}
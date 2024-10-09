#include <stdio.h>     
#include <stdlib.h>     
#include <unistd.h>     
#include <sys/types.h>  
#include <sys/wait.h>   

int main() {
    int pid, num;  
    num=6; //We asign a value
    printf("Valor inicial de la variable: %d\n",num);
    pid = fork();  // We create a child process
        if (pid == 0) {  
            num=num-5; // In the child, we change the value
            printf("Valor en proceso hijo: %d\n",num); // We print it
            exit(0); //We exit child
        } else if (pid == -1) {  // We control the posible error 
            perror("fallo en fork"); 
            exit(-1);  
        } else {  
            pid = wait(NULL);  //Parent waits child to end
        }
    

   
    if (pid > 0) {  
        num=num+5;//In the parent, we change the value
        printf("Valor en proceso padre: %d\n",num); // We print it
    }
}

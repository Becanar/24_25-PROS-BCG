#include <stdio.h>     
#include <stdlib.h>     
#include <unistd.h>     
#include <sys/types.h>  
#include <sys/wait.h>   

int main() {
    int pid, i;  

    // For to create 3 child processes
    for (i = 1; i < 4; i++) {
        pid = fork();  // We create a new child using fork()
        
        if (pid == 0) {  
            //We enter the child process
            printf("Soy el hijo %d, Mi padre es PID= %d y mi PID es %d\n", i, getppid(), getpid());//We print information
            exit(0);  // We exit the child
        } else if (pid == -1) { //We control the posible error.
            perror("fallo en fork"); 
            exit(-1);
        } else {  // The parent waits child to exit
            pid = wait(NULL);  
        }
    }

    
    if (pid > 0) {  // We print parent information
        printf("Proceso padre %d\n", getpid());
    }
}

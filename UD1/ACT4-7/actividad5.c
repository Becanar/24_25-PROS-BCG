#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

int main() {
    int n, pid, i;

    n = 4;

    // For to create 'n' child processes
    for (i = 1; i <= n; i++) {
        pid = fork();  // We create a new child using fork()
        
        if (pid == 0) {   //We enter the child process
           
            printf("Yo soy el hijo %d, mi padre es PID= %d, yo soy PID=%d\n", i, getppid(), getpid());
          
        } else {
            if (pid > 0) {  // We enter the parent
                // The parent waits child to exit
                pid = wait(NULL);  
                exit(0);  // We exit the parent
               
            } else {
                if (pid == -1) {  //We control the posible error.
                    perror("fallo en fork");  
                    exit(-1); 
                }
            }
        }
    }
}

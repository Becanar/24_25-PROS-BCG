#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>

int main() {
    pid_t pid1, pid2, pid3;

    pid2 = fork();//We create child 2
    if (pid2 == 0) {
        // In child 2
        printf("Yo soy el hijo 2, mi padre es PID= %d, yo soy PID= %d\n", getppid(), getpid());
        pid3 = fork();
        if (pid3 == 0) {
            // In child 3
            printf("Yo soy el hijo 3, mi padre es PID= %d, yo soy PID= %d\n", getppid(), getpid());
        } else if (pid3 < 0) {
            // Control posible error
            printf("No es posible crear el hijo 3!");
            exit(-1);
        }
        wait(NULL); // Wait for child 2
        exit(0);
    } else if (pid2 < 0) {
        // Control posible error
        printf("No es posible crear el hijo 2!");
        exit(-1);
    }
    pid1 = fork(); // Create child 1
    if (pid1 == 0) {
        // In child 1
        printf("Yo soy el hijo 1, mi padre es PID= %d, yo soy PID= %d\n", getppid(), getpid());
        exit(0);
    } else if (pid1 < 0) {
       // Control posible error
        printf("No es posible crear el hijo 1!");
        exit(-1);
    }
    wait(NULL);
    wait(NULL);
    exit(0);
}
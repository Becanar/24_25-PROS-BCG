#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <signal.h>
#include <sys/wait.h>

volatile sig_atomic_t terminate_flag = 0;  // flag to check SIGTERM

// create the signal handler
void signal_handler(int sig) {
    if (sig == SIGUSR1) {
        printf("Padre recibe señal...%d\n", sig);
    }else if (sig == SIGTERM) {
        terminate_flag = 1;  // set flag
    }
}

int main() {
    pid_t pid;

    // set up signal handlers
    signal(SIGUSR1, signal_handler);
    signal(SIGTERM, signal_handler);  

    // create a child
    pid = fork();

    if (pid < 0) {
        perror("Error creating child process");
        exit(EXIT_FAILURE);
    }

    if (pid == 0) {  
        // send 3 SIGUSR1 signals
        for (int i = 0; i < 3; i++) {
            kill(getppid(), SIGUSR1);
            sleep(1);  // sleep to let parent process
        }

        // SIGTERM to terminate the parent
        kill(getppid(), SIGTERM);
        exit(0);
    } else { 
        // Wait for the SIGTERM signal
        while (!terminate_flag) {
            pause();  // pause the process and wait
        }

        // wait the child
        wait(NULL);

        // print the final message
        printf("Terminado(killed)\n");
    }

    return 0;
}
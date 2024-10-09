#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <sys/wait.h>

int main() {
    int fd1[2], fd2[2];  // fd1 y fd2 pipes
    pid_t pid_hijo, pid_nieto;
    char buffer[100];

    // create pipes
    if (pipe(fd1) == -1 || pipe(fd2) == -1) {
        perror("Error al crear los pipes");
        exit(EXIT_FAILURE);
    }

    // create HIJO
    pid_hijo = fork();
    if (pid_hijo == -1) {
        perror("Error al crear el proceso hijo");
        exit(EXIT_FAILURE);
    }

    if (pid_hijo == 0) {  
        // create NIETO
        pid_nieto = fork();
        if (pid_nieto == -1) {
            perror("Error al crear el proceso nieto");
            exit(EXIT_FAILURE);
        }

        if (pid_nieto == 0) {  
           
            close(fd1[1]);  // close fd1 writing
            close(fd2[0]);  // vlose fd2 reading

            // Read HIJO
            read(fd2[1], buffer, sizeof(buffer));
            printf("El NIETO recibe mensaje del padre: %s\n", buffer);

            // Write HIJO
            strcpy(buffer, "Saludo del nieto");
            printf("El NIETO envia un mensaje al HIJO...................\n");
            write(fd1[0], buffer, sizeof(buffer));
            exit(0);  //Exit NIETO
        }

        // HIJO
        close(fd1[0]);  // close fd1 reading
        close(fd2[1]);  // vlose fd2 writing

        // Read ABUELO
        read(fd1[1], buffer, sizeof(buffer));
        printf("El Hijo recibe mensaje de abuelo: %s\n", buffer);

        // Write NIETO
        strcpy(buffer, "Saludo del padre");
        printf("El HIJO  envia un mensaje al NIETO............\n");
        write(fd2[0], buffer, sizeof(buffer));

        // wait NIETO
        wait(NULL);

        // Read NIETO
        read(fd1[1], buffer, sizeof(buffer));
        printf("El HIJO recibe mensaje de su hijo: %s\n", buffer);

        // Write to ABUELO
        strcpy(buffer, "Saludo del hijo");
        printf("El HIJO envia un mensaje al ABUELO......\n");
        write(fd2[0], buffer, sizeof(buffer));

        exit(0); // exit HIJO
    }

    // ABUELO
    close(fd1[1]);  // close fd1 writing
    close(fd2[0]);  // vlose fd2 reading

    // Write to HIJO
    strcpy(buffer, "Saludo del abuelo");
    printf("El ABUELO envia un mensaje al HIJO.......\n");
    write(fd1[0], buffer, sizeof(buffer));

    // Wait HIJO
    wait(NULL);

    // Read final message
    read(fd2[1], buffer, sizeof(buffer));
    printf("El ABUELO recibe mensaje del HIJO: %s\n", buffer);

    return 0;
}
#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>

int main(void) {
    int fp;
    int bytesleidos;
    char buffer[100];  // Buffer to store the message
    int p;

    // Create the pipe
    p = mkfifo("FIFO2", 0666);  // gives permissions
    if (p == -1) {
        printf("Error al crear la FIFO...\n");
        exit(1);
    }

    while (1) {
        // Open to read
        fp = open("FIFO2", O_RDONLY);
        if (fp == -1) {
            printf("Error al abrir la FIFO...\n");
            exit(1);
        }

        printf("Obteniendo información...\n");

        // Read the message from the FIFO
        while ((bytesleidos = read(fp, buffer, sizeof(buffer))) > 0) {
            printf("%s", buffer); 
        }

        close(fp);
    }

    return 0;
}
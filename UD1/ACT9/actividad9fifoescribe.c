#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <fcntl.h>
#include <unistd.h>

int main(void) {
    int fp;
    char saludo[] = "Un saludo !!!!!\n";

    // Open to write
    fp = open("FIFO2", O_WRONLY);
    if (fp == -1) {
        printf("Error al abrir la FIFO...\n");
        exit(1);
    }

    printf("Mandando información al FIFO...\n");

    // Write the message to the FIFO
    write(fp, saludo, strlen(saludo) + 1);

    close(fp); 
    return 0;
}

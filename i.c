#include <stdio.h>

int main() {
    int i = 2;

    printf("%d\n", ++i); // 3
    i = 2;

    printf("%d\n", i);   // 2
    i = 2;

    printf("%d\n", i++); // 2
    printf("\n%d", i);   // 3

    return 0;
}
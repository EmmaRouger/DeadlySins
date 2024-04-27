/*
*   Mitchell Misischia
*   Sin: 6 - Format String Problems
*/
#include <stdio.h>
#include <string>

int main(int argc, char* argv[])
{
    if(argc > 1)
    {
        std::string str = argv[1]; //formats directly to a string so it cannot be interpreted
        printf("%s",str.c_str()); // format function using %s to format input disallowing direct user input to be used in the function
        // printf(argv[1]);
    }
    else
    {
        printf("Usage: <enter a string>");
        exit(0);
    }

    return 0;
}
/*
    Mitchell Misischia
    Sin 8 - C++ Catastophes

    This sin blanket covers a large number of bad practices and aims to inform
    the reader of small changes that can be done to build better habits when
    coding rather than focusing on one specific vulnerability or threat.

*/


#include <stdio.h>
#include <iostream>
#include <vector> // one point was to remember that this was a useful class

int main()
{
    //First concern talked about
    int *intPtr = new int[25]; // Declaring Array with correct new operator
    delete[] intPtr; //Freeing with correct operator
    intPtr = nullptr;

}

class myClass
{
    public:
        myClass(std::string* d): data(nullptr){} //When creating a constructor (This is just a small example) there are chances of creating a sinful constructor //Also initializng pointer to NULL
                                                 //using an initialization list it tends to be more efficent and has less of a chance at creating a sinful constructor
        void init(std::string* str) //Similary the INIT method should be used to handle other initialization
        {
            this->data = str;
        }
        ~myClass() //destructor to handle removal of data
        {
            delete data;
        }

    private:
        std::string* data;

        myClass(const myClass& rhs);            //declaration of both copy constructor and operator as private. Limiting the ability to use such default methods without propper implementation
                                                //This causes a linking error if called because there is no implementation
        myClass& operator=(const myClass& rhs);
};
#include <iostream>
using namespace std;

int main() {
    int a; 
    int b; 
    
    cin >> a;
    cin >> b;

    // Perform the multiplication and store the result in a 64-bit integer
    long long result = static_cast<long long>(a) * b;

    // Check for overflow by examining the high-order bits
    bool overflow = result > 0x7FFFFFFFLL || result < -0x80000000LL;

    if (overflow) {
        cout << "Overflow occurred!" << endl;
    } 
    else {
        cout << "No overflow occurred." << endl;
    }

    return 0;
}


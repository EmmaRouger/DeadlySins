#include <iostream>
#include <sstream>
using namespace std;

int main() {
  int choice;
  string junk;
  string temp;

  cout << "  1  Quiz\n";
  cout << "  2  Exam\n";
  cout << "  3  Paper\n\n";

  cout << "Enter the number for the grade type you want (1-3): ";
  cin >> temp;
  // check to make sure the length of the input is not longer than it should be
  if(temp.length()>1){
    choice = stoi(temp.substr(0,1));
  }else{
    choice = stoi(temp);
  }
  getline(cin,junk);
  return choice;
}

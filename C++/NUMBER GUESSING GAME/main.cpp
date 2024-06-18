#include <iostream>
#include <cstdlib>
#include <time.h>

using namespace std;


int randomInt(int LW, int UP)
{
    int intMid = UP - LW + 1;

    return (rand() % intMid) + LW;
}
int main()
{
    srand(time(0));

    const int intLower = 0;
    const int intUpper = 101;

    cout << "********Welcome to the Guessing Game!********" << endl;
    cout << endl;
    cout << "Please Enter Your Username: " << endl;

    string strUsrname = "";

    cin >> strUsrname;

    if(cin.fail())
    {
        cerr << "Error When Storing Your Username. PLease Enter Characters ONLY!!" << endl;
        cin >> strUsrname;
    }

    cout << "Are you Ready to Guess your way to CHECKPOT "<< strUsrname << "??!!" << endl;
    cout << "Enter your first guess if so: " << endl;

    int random = randomInt(intLower, intUpper);
    int guess = 0;

    bool notWon = true;
    int rounds = 0;
    while(notWon)
    {
        cin >> guess;

        rounds++;

        if(guess == random)
        {
            cout << "********Game Over. YOU WIN!!!********" << endl;
            cout << "It took you " << rounds << " guesses to Guess It Right...Guess not smart after all Huh. ;-) "<< endl;
            notWon = false;
        }
        if(guess > random)
        {
            cout << "Too High, Guess a LOWER value." << endl;
        }
        if(guess < random)
        {
            cout << "Too Low, Guess a HIGHER value." << endl;
        }
    }

    return 0;
}

#include <iostream>
#include <string>
#include <vector>
#include <stack>
#include <algorithm>
#include <queue>
#include <tuple>
#include <math.h>
using namespace std;
//cin.tie(NULL);
//ios::sync_with_stdio(false);
int alpabet[26] = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
char alpa[26] = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
int main()
{
    string str;
    
    cin >> str;
    
    for(int i=0; i< str.size(); i++)
    {
        if(str[i] == 'A' || str[i] == 'a')
        {
            alpabet[0]++;
        }
        if(str[i] == 'B' || str[i] == 'b')
        {
            alpabet[1]++;
        }
        if(str[i] == 'C' || str[i] == 'c')
        {
            alpabet[2]++;
        }
        if(str[i] == 'D' || str[i] == 'd')
        {
            alpabet[3]++;
        }
        if(str[i] == 'E' || str[i] == 'e')
        {
            alpabet[4]++;
        }if(str[i] == 'F' || str[i] == 'f')
        {
            alpabet[5]++;
        }
        if(str[i] == 'G' || str[i] == 'g')
        {
            alpabet[6]++;
        }
        if(str[i] == 'H' || str[i] == 'h')
        {
            alpabet[7]++;
        }
        if(str[i] == 'I' || str[i] == 'i')
        {
            alpabet[8]++;
        }
        if(str[i] == 'J' || str[i] == 'j')
        {
            alpabet[9]++;
        }
        if(str[i] == 'K' || str[i] == 'k')
        {
            alpabet[10]++;
        }
        if(str[i] == 'L' || str[i] == 'l')
        {
            alpabet[11]++;
        }
        if(str[i] == 'M' || str[i] == 'm')
        {
            alpabet[12]++;
        }
        if(str[i] == 'N' || str[i] == 'n')
        {
            alpabet[13]++;
        }
        if(str[i] == 'O' || str[i] == 'o')
        {
            alpabet[14]++;
        }
        if(str[i] == 'P' || str[i] == 'p')
        {
            alpabet[15]++;
        }
        if(str[i] == 'Q' || str[i] == 'q')
        {
            alpabet[16]++;
        }
        if(str[i] == 'R' || str[i] == 'r')
        {
            alpabet[17]++;
        }
        if(str[i] == 'S' || str[i] == 's')
        {
            alpabet[18]++;
        }
        if(str[i] == 'T' || str[i] == 't')
        {
            alpabet[19]++;
        }
        if(str[i] == 'U' || str[i] == 'u')
        {
            alpabet[20]++;
        }
        if(str[i] == 'V' || str[i] == 'v')
        {
            alpabet[21]++;
        }
        if(str[i] == 'W' || str[i] == 'w')
        {
            alpabet[22]++;
        }
        if(str[i] == 'X' || str[i] == 'x')
        {
            alpabet[23]++;
        }
        if(str[i] == 'Y' || str[i] == 'y')
        {
            alpabet[24]++;
        }
        if(str[i] == 'Z' || str[i] == 'z')
        {
            alpabet[25]++;
        }
    }
    int num =-1;
    int max_num =0;
    int temp =0;
    for(int i=0; i< 26; i++)
    {
        
        temp = num;
        num = max(alpabet[i], num);
        
        if(num > temp)
        {
            max_num = i;
        }
        
    }
    
    for(int i=0; i< 26; i++)
    {
        if(i == max_num) continue;
        
        if(num == alpabet[i])
        {
            cout << "?" << endl;
            return 0;
        }
        
    }
    
    cout << alpa[max_num] << endl;
    
}
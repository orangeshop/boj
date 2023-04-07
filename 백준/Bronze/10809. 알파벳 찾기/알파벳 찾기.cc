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

int alpabet[26] = {-1,-1,-1,-1,-1,
                    -1,-1,-1,-1,-1,
                    -1,-1,-1,-1,-1,
                    -1,-1,-1,-1,-1,
                    -1,-1,-1,-1,-1,-1};
char alpa[26] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
int main()
{
    string str;
    cin >> str;
    

        for(int i=0; i< str.size(); i++)
        {
            if(str[i] == 'A' || str[i] == 'a')
            {
                if(alpabet[0] != -1) continue;
                alpabet[0] = i;
            }
            if(str[i] == 'B' || str[i] == 'b')
            {
                if(alpabet[1] != -1) continue;
                alpabet[1] = i;
            }
            if(str[i] == 'C' || str[i] == 'c')
            {
                if(alpabet[2] != -1) continue;
                alpabet[2] = i;
            }
            if(str[i] == 'D' || str[i] == 'd')
            {
                if(alpabet[3] != -1) continue;
                alpabet[3] = i;
            }
            if(str[i] == 'E' || str[i] == 'e')
            {if(alpabet[4] != -1) continue;
                alpabet[4] = i;
            }if(str[i] == 'F' || str[i] == 'f')
            {if(alpabet[5] != -1) continue;
                alpabet[5] = i;
            }
            if(str[i] == 'G' || str[i] == 'g')
            {if(alpabet[6] != -1) continue;
                alpabet[6] = i;
            }
            if(str[i] == 'H' || str[i] == 'h')
            {if(alpabet[7] != -1) continue;
                alpabet[7] = i;
            }
            if(str[i] == 'I' || str[i] == 'i')
            {if(alpabet[8] != -1) continue;
                alpabet[8] = i;
            }
            if(str[i] == 'J' || str[i] == 'j')
            {if(alpabet[9] != -1) continue;
                alpabet[9] = i;
            }
            if(str[i] == 'K' || str[i] == 'k')
            {if(alpabet[10] != -1) continue;
                alpabet[10] = i;
            }
            if(str[i] == 'L' || str[i] == 'l')
            {if(alpabet[11] != -1) continue;
                alpabet[11] = i;
            }
            if(str[i] == 'M' || str[i] == 'm')
            {if(alpabet[12] != -1) continue;
                alpabet[12] = i;
            }
            if(str[i] == 'N' || str[i] == 'n')
            {if(alpabet[13] != -1) continue;
                alpabet[13] = i;
            }
            if(str[i] == 'O' || str[i] == 'o')
            {if(alpabet[14] != -1) continue;
                alpabet[14] = i;
            }
            if(str[i] == 'P' || str[i] == 'p')
            {if(alpabet[15] != -1) continue;
                alpabet[15] = i;
            }
            if(str[i] == 'Q' || str[i] == 'q')
            {if(alpabet[16] != -1) continue;
                alpabet[16] = i;
            }
            if(str[i] == 'R' || str[i] == 'r')
            {if(alpabet[17] != -1) continue;
                alpabet[17] = i;
            }
            if(str[i] == 'S' || str[i] == 's')
            {if(alpabet[18] != -1) continue;
                alpabet[18] = i;
            }
            if(str[i] == 'T' || str[i] == 't')
            {if(alpabet[19] != -1) continue;
                alpabet[19] = i;
            }
            if(str[i] == 'U' || str[i] == 'u')
            {if(alpabet[20] != -1) continue;
                alpabet[20] = i;
            }
            if(str[i] == 'V' || str[i] == 'v')
            {if(alpabet[21] != -1) continue;
                alpabet[21] = i;
            }
            if(str[i] == 'W' || str[i] == 'w')
            {if(alpabet[22] != -1) continue;
                alpabet[22] = i;
            }
            if(str[i] == 'X' || str[i] == 'x')
            {if(alpabet[23] != -1) continue;
                alpabet[23] = i;
            }
            if(str[i] == 'Y' || str[i] == 'y')
            {if(alpabet[24] != -1) continue;
                alpabet[24] = i;
            }
            if(str[i] == 'Z' || str[i] == 'z')
            {if(alpabet[25] != -1) continue;
                alpabet[25] = i;
            }
            
        }
    
   
    for(int i=0; i< 26; i++)
    {
        cout << alpabet[i] << " ";
    }
}
#include <iostream>
#include <string>
#include <vector>
#include <stack>
#include <algorithm>
#include <queue>
using namespace std;

bool isused_1[50];
bool isused_2[50];
bool isused_3[50];

int cnt =0;
int n=0;
vector<pair<int,int>> V;
void back_tracking(int depth)
{
    if(depth==n)
    {
        cnt++;
        return;
    }
    
    for(int i=depth; i<n; i++)
    {
        for(int k=0; k<n; k++)
        {
            if(!isused_1[k] && !isused_2[i+k] && !isused_3[i-k+n-1])
            {
                
                V.push_back({i,k});
                isused_1[k]=1;
                isused_2[i+k]=1;
                isused_3[i-k+n-1]=1;
                back_tracking(depth+1);
                V.pop_back();
                isused_1[k]=0;
                isused_2[i+k]=0;
                isused_3[i-k+n-1]=0;
                
                
            }
            if(k==n-1) return;
        }
        
    }
    
    
    
}

int main()
{
    cin >> n;
    back_tracking(0);
    cout << cnt << endl;
}
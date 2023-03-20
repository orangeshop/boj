
#include <iostream>
#include <string>
#include <vector>
#include <stack>
#include <algorithm>
#include <queue>
using namespace std;

vector<int> A;
vector<int> B;
int binary_search(int a, int num)
{
    int st = 0;
    int en = num;
    int mid =0;
    while(st <= en)
    {
        if(a == A[mid])
        {
            return 1;
        }
        
        mid = (st+en)/2;
        
        if(A[mid]>a)
        {
            en = mid-1;
           
        }
        else if(A[mid] < a)
        {
            st = mid +1;
            
        }
    }
    
    return 0;
}

int main()
{
    
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    int a=0;
    cin >> a;
    
    for(int i=0; i< a; i++)
    {
        int num=0;
        cin >> num;
        A.push_back(num);
        
    }
    sort(A.begin() , A.end());
    
    int b=0;
    cin>> b;
    for(int i=0; i< b; i++)
    {
        int num=0;
        cin >> num;
        B.push_back(num);
    }
    
    
    for(int i=0; i< b; i++)
    {
        cout << binary_search(B[i] , b) << '\n';
    }
}
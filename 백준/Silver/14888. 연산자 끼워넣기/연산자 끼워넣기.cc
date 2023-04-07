#include <iostream>
#include <string>
#include <vector>
#include <stack>
#include <algorithm>
#include <queue>
using namespace std;

int arr[4];
int num=0;
long long Min=1000000000;
long long Max=-1000000000;
//vector<int> V;
int V[100];
long long result=0;
int number_check =0;
long long garbge =0;

void back_tracking(int a,int fuc_result, int c)
{
    if(a==num-1)
    {
        
        if(fuc_result > Max)
        {
            Max = fuc_result;
        }
        if(fuc_result < Min)
        {
            Min = fuc_result;
        }
        return;
    }
    
    for(int k=0; k< 4; k++)
    {
        if(arr[k]!=0)
        {
            if(k==0)
            {
                arr[k]--;
                back_tracking(a+1, fuc_result+ V[c], c+1);

                arr[k]++;
            }
            else if(k==1)
            {
                arr[k]--;
                back_tracking(a+1, fuc_result- V[c], c+1);
                arr[k]++;
            }
            else if(k==2)
            {
                arr[k]--;
                back_tracking(a+1, fuc_result* V[c], c+1);
                arr[k]++;
            }
            else if(k==3)
            {
                arr[k]--;
                back_tracking(a+1, fuc_result/ V[c], c+1);
                arr[k]++;
            }
        }// 기호 for문 끝나는 라인
    }// for문 끝나는 라인
}

int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    
    cin >> num;
    
    for(int i=0; i< num; i++)
    {
        int b=0;
        cin >> b;
        V[i] = b;
    }
    for(int i=0; i< 4; i++)
    {
        int b=0;
        cin >> b;
        arr[i] = b;
    }
    if(number_check==0)
    {
        result = V[number_check];
        number_check++;
    }
    back_tracking(0,result,number_check);
    
    cout << Max << endl << Min << endl;
}
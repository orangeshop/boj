#include <iostream>
#include <string>
#include<cstring>
#include <vector>
#include <stack>
#include <memory.h>
#include <algorithm>
#include <queue>
#include <tuple>
#include <math.h>
#include <set>
#include <map>
using namespace std;
//cin.tie(NULL);
//ios::sync_with_stdio(false);


int dp[1005][1005];
string string_n;
string string_m;

int main()
{
	cin >> string_n >> string_m;


	for (int i = 0; i <= string_n.size(); i++)
	{
		for (int k = 0; k <= string_m.size(); k++)
		{
			if (i == 0 || k == 0)
			{
				dp[i][k] = 0;
			}
			else if (string_n[i-1] == string_m[k-1])
			{
				dp[i][k] = dp[i - 1][k - 1] + 1;
			}
			else {
				dp[i][k] = max(dp[i - 1][k], dp[i][k - 1]);
			}
		}
	}
	int max_num = 0;
	for (int i = 0; i <= string_n.size(); i++)
	{
		for (int k = 0; k <= string_m.size(); k++)
		{
			max_num = max(dp[i][k], max_num);
		}
	}

	cout << max_num << endl;

}
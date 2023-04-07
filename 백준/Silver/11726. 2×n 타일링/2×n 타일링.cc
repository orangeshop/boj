#include <string>
#include <vector>
#include<iostream>
using namespace std;

long long dist[1000];

int main()
{
	int a = 0;
	cin >> a;
	dist[0] = 1;
	dist[1] = 2;

	for (int i = 2; i < a; i++)
	{
		dist[i] = (dist[i - 1] + dist[i - 2]) % 10007;
	}

	
		cout << dist[a-1] << endl;
	
}
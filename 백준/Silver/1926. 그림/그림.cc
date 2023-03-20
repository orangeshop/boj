#include <iostream>
#include <queue>
using namespace std;

int bord[502][502];
/*{ {1 ,1 ,0 ,1 ,1},
{0, 1, 1, 0, 0},
{0 ,0 ,0 ,0 ,0},
{1 ,0, 1, 1, 1},
{0 ,0 ,1 ,1 ,1},
	{0 ,0 ,1 ,1 ,1 } };*/
bool vis[502][502];
int n = 0 , m= 0;
int dx[4] = { 1,0,-1,0 };
int dy[4] = { 0,1,0,-1 };

int main()
{
	cin >> n >> m;
	
	for (int i = 0; i < n; i++)
	{
		for (int k = 0; k < m; k++)
		{
			cin >> bord[i][k];
		}
	}


	queue<pair<int, int>> Q;
	ios::sync_with_stdio(0);
	cin.tie(0);
	int num = 0, size = 0;

	for (int i = 0; i < n; i++)
	{
		for (int k = 0; k < m; k++)
		{
			if (bord[i][k] && vis[i][k] == 0)
			{
				vis[i][k] = 1;
				Q.push( {i,k});
				int tmp_size=0;
				while (!Q.empty())
				{
					pair<int, int> cur = Q.front(); Q.pop();
				
					for (int dir = 0; dir < 4; dir++)
					{
						int nx = cur.first + dx[dir];
						int ny = cur.second + dy[dir];

						if (nx< 0 || 0>nx >= n || ny < 0 || ny >= m) continue;
						if (vis[nx][ny] || bord[nx][ny] != 1) continue;
						vis[nx][ny] = 1;
						Q.push({ nx,ny });
					}
					tmp_size++;
					if (tmp_size > size)
					{
						size = tmp_size;
					}
				}
			
				num++;
			}
		}
	}

	cout << num << endl;
	cout << size << endl;

}
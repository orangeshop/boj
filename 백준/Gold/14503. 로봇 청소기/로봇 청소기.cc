#include <iostream>
#include <string>
#include <vector>
#include <stack>
#include <algorithm>
#include <queue>
#include <tuple>
#include <math.h>
#include <set>
#include <map>
using namespace std;
//cin.tie(NULL);
//ios::sync_with_stdio(false);


int board[55][55];
bool vis[55][55];
int n,m;
int nx,ny,dis,clean_count;

int dx[4] = {0,1,0,-1};
int dy[4] = {-1,0,1,0};

bool fianl_return = false;


void clean(){
    clean_count++;
}

int navigate(int a){
    if(a == 0)
    {
        return 3;
    }
    else if(a == 3){
        return 2;
    }
    else if(a == 2){
        return 1;
    }
    else{
        return 0;
    }
    
    
}

void number2_1()
{
    
    if(fianl_return == true){
        return;
    }
    for(int i=0; i<n; i++)
    {
        for(int k=0; k<m; k++)
        {
            //cout << vis[i][k] << " ";
        }
        //cout << endl;
    }
    //cout << "현재 위치 : " << nx << " " << ny << "총 청소 "<< clean_count <<endl;
    bool back = false;
    bool up = false;
    bool down = false;
    bool left = false;
    bool right = false;
    for(int dir =0; dir<4; dir++)
    {
        int check_x = dx[dir] + nx;
        int check_y = dy[dir] + ny;
        
        if(board[check_x][check_y] == 1 || vis[check_x][check_y] == 1)
        {
            if(dir == 0)
            {
                up = true;
                continue;
            }
            else if(dir == 1)
            {
                down = true;
                continue;
            }
            else if(dir == 2)
            {
                left = true;
                continue;
            }
            else{
                right = true;
                continue;
            }
           
        }
    }
    if(up == true && down == true && left == true && right == true)
    {
        back= true;
    }
    if(back == true){
        back = false;
        
        if(dis == 0)
        {
            int check_x = nx+1;
            int check_y = ny;
            
            if(board[check_x][check_y]==1)
            {
                fianl_return = true;
                //cout << "작동을 종료" << endl;
                return;
            }
            else{
                nx += 1;
                number2_1();
            }
        }
        else if(dis == 1)
        {
            int check_x = nx;
            int check_y = ny-1;
            
            if(board[check_x][check_y]==1)
            {
                fianl_return = true;
                //cout << "작동을 종료" << endl;
                return;
            }
            else{
                ny -= 1;
                number2_1();
            }
        }
        else if(dis == 2)
        {
            int check_x = nx-1;
            int check_y = ny;
            
            if(board[check_x][check_y]==1)
            {
                fianl_return = true;
                //cout << "작동을 종료" << endl;
                return;
            }
            else{
                nx -= 1;
                number2_1();
            }
        }
        else
        {
            int check_x = nx;
            int check_y = ny+1;
            
            if(board[check_x][check_y]==1)
            {
                fianl_return = true;
                //cout << "작동을 종료" << endl;
                return;
            }
            else{
                ny += 1;
                number2_1();
            }
        }
    }
    
    
    if(dis == 0)
    {
        int check_x =0;
        int check_y =0;
        
        check_x = nx;
        check_y = ny-1;
        
        if(board[check_x][check_y] == 0 && vis[check_x][check_y] == 0) // 청소 x
        {
            dis = navigate(dis);
            ny -= 1;
            clean();
            vis[nx][ny] = 1;
            number2_1();
            
        }
        else{
            dis = navigate(dis);
            number2_1();
        }
        
    }
    else if (dis == 1)
    {
        int check_x =0;
        int check_y =0;
        
        check_x = nx-1;
        check_y = ny;
        
        if(board[check_x][check_y] == 0 && vis[check_x][check_y] == 0) // 청소 x
        {
            dis = navigate(dis);
            nx -= 1;
            clean();
            vis[nx][ny] = 1;
            number2_1();
        }
        else{
            dis = navigate(dis);
            number2_1();
        }
    }
    else if (dis == 2)
    {
        int check_x =0;
        int check_y =0;
        
        check_x = nx;
        check_y = ny+1;
        
        if(board[check_x][check_y] == 0 && vis[check_x][check_y] == 0) // 청소 x
        {
            dis = navigate(dis);
            ny += 1;
            clean();
            vis[nx][ny] = 1;
            number2_1();
        }
        else{
            dis = navigate(dis);
            number2_1();
        }
    }
    else{
        int check_x =0;
        int check_y =0;
        
        check_x = nx+1;
        check_y = ny;
        
        if(board[check_x][check_y] == 0 && vis[check_x][check_y] == 0) // 청소 x
        {
            dis = navigate(dis);
            nx += 1;
            clean();
            vis[nx][ny] = 1;
            number2_1();
        }
        else{
            dis = navigate(dis);
            number2_1();
        }
    }
}

int main(){
    
    cin >> n >> m;
    cin >> nx >> ny >> dis;
    for(int i=0; i<n; i++)
    {
        for(int k=0; k<m; k++)
        {
            cin >> board[i][k];
        }
    }
    clean();
    vis[nx][ny] = 1;
    
    
    
    number2_1();
    
    
    
    cout << clean_count << endl;
    
}

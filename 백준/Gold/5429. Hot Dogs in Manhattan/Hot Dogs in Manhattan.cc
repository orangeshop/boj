 
#include <iostream>
#include <string>
#include <cstring>
#include <vector>
#include <stack>
#include <memory.h>
#include <algorithm>
#include <queue>
#include <tuple>
#include <math.h>
#include <list>
#include <set>
#include <map>
#include <iterator>
#include <fstream>
using namespace std;
#define S second
#define F first
#define l long
#define MAX 0x7ffffff
int dx[4] = {-1,0,1,0};
int dy[4] = {0,1,0,-1};
int ddx[8] = {-1,-2,-2,-1,1,2,2,1};
int ddy[8] = {-2,-1,1,2,-2,-1,1,2};
int cdx[8] = {-1,0,1,0,-1,-1,1,1};
int cdy[8] = {0,1,0,-1,-1,1,1,-1};




bool check_vis[3];
bool check_vis2[2];




int max_number = 0;

int N;
int board[1005][1005];
bool vis[1005][1005];
int count_board[1005][1005];
int answer = 0;



vector<pair<int,int>> check_array[2000];
queue<pair<int,int>> Q;
vector<int> answer_V;
vector<string> File_Input;
void max_count(int W, int H){
    for(int i=0; i<W; i++)
    {
        for(int k=0; k<H; k++)
        {
            count_board[i][k] = MAX;
        }
    }
}



void see_and_clear(int W, int H){
    
    //cout << endl;
    for(int i=0; i<W; i++)
    {
        for(int k=0; k<H; k++)
        {
            //cout << count_board[i][k] << " ";
            check_array[count_board[i][k]].push_back({i,k});
            vis[i][k] = false;
        }
        //cout << endl;
    }
    //cout << endl;
    
    //cout << max_number << endl;
    bool check = false;
    
    for(int i=max_number; i>=0; i--)
    {
        
        if((check_array[i].size() < 2) == true) continue;
        
        if((check == false) == true)
        {
            
            for(int k=0; k<check_array[i].size(); k++){
                for(int j=k+1; j<check_array[i].size(); j++){
                    
                    //cout << i <<" : "<< check_array[i][k].first << " " << check_array[i][k].second <<  " "<< check_array[i][j].first << " " << check_array[i][j].second<<endl;
                    
                    int check_x = check_array[i][k].first - check_array[i][j].first;
                    int check_y = check_array[i][k].second - check_array[i][j].second;
                    
                    if(check_x < 0 ) check_x *= -1;
                    if(check_y < 0 ) check_y *= -1;
                    
                    answer = check_x + check_y;
                    
                    
                    if((answer >= i) == true){
                        
                        if(check == false)
                        {
                            answer = i;
                            check = true;
                        }
                    }
                    
                    if(check == true) break;
                }
                
                if(check == true) break;
            }
        }
        check_array[i].clear();
    }
    
    
    for(int i=max_number; i>=0; i--)
    {
        check_array[i].clear();
    }
}


void bfs(int W, int H){
    
    
    max_number = 0;
    
    while(!Q.empty())
    {
        pair<int,int> cur = Q.front();
        Q.pop();
        
        for(int dir = 0; dir < 4; dir++){
            
            int nx = cur.first + dx[dir];
            int ny = cur.second + dy[dir];
            
            if(0 > nx || nx > W-1 || 0 > ny || ny > H-1) continue;
            if(vis[nx][ny] == true) continue;
            
            Q.push({nx,ny});
            count_board[nx][ny] = min(count_board[nx][ny], count_board[cur.first][cur.second] + 1);
            vis[nx][ny] = true;
        }
    }
    
    for(int i=0; i<W; i++){
        for(int k=0; k<H; k++)
        {
            max_number = max(max_number, count_board[i][k]);
        }
    }
    
    //cout << "max_number : " << max_number << endl;
}

int main()
{
    
    //cin.tie(NULL);
    //ios::sync_with_stdio(false);
    //cout.tie(NULL);
    //----
//    ifstream readFile;
//    readFile.open("sample.txt");
//
//    //readFile.open("sub_test.txt");
//
//    int check_number =0;
//    if(readFile.is_open())
//    {
//        while(!readFile.eof()){
//            string str;
//            getline(readFile, str);
//
//            //cout <<check_number <<" "<< str << endl;
//            //check_number++;
//            File_Input.push_back(str);
//
//        }
//        readFile.close();
//    }
    //----
    
    cin >> N;
    
    //----
//    int file_input_number =0;
//
//    N = stoi(File_Input[0]);
//    file_input_number++;
//
//    cout << "N : " << N << endl;
//
    //----
    
    for(int i=0; i<N; i++){
        
        int count = 0;
        int W =0;
        int H =0;
        
        cin >> count >> W >> H;
        
        //----
        
        
//        string str ="";
//
//        for(int k=0; k<File_Input[file_input_number].size(); k++){
//
//            str += File_Input[file_input_number][k];
//
//            //cout << str << endl;
//
//            if(k == File_Input[file_input_number].size()-1){
//                H = stoi(str);
//                str = "";
//                continue;
//            }
//
//            if(File_Input[file_input_number][k] == ' '){
//
//                //cout << "hi" << endl;
//
//                if(check_vis[0] == false){
//
//                    //cout << "in count : " << str << endl;
//                    count = stoi(str);
//                    str = "";
//                    check_vis[0] = true;
//                    continue;
//                }
//
//                if(check_vis[1] == false){
//                    W = stoi(str);
//                    str = "";
//                    check_vis[1] = true;
//                    continue;
//                }
//            }
//        }
//
//        check_vis[0] = false;
//        check_vis[1] = false;
//        check_vis[2] = false;
//
//        file_input_number++;
//
//        cout << "count : " << count << " W : " << W << " H : " << H << endl;
//
        //----
        
        max_count(W, H);
        
        if(count == 0)
        {
            
            Q.push({0,0});
            vis[0][0] = true;
            count_board[0][0] = 0;
            bfs(W,H);
            
            answer = max_number;
            
            max_number =0;
        
            for(int j=0; j<W; j++)
            {
                for(int k=0; k<H; k++)
                {
                    vis[j][k] = false;
                }
            }
            
            //file_input_number++;
            
            
        }else{
            
            int x = 0;
            int y = 0;
            
            
                for(int kr=0; kr<count; kr++)
                {
//                    //------
//                    string str1 = "";
//                    for(int k=0; k<File_Input[file_input_number].size(); k++){
//
//                        str1 += File_Input[file_input_number][k];
//
//                        //cout <<  File_Input[file_input_number] <<"  "<<k<<" " <<str1 << endl;
//
//                        if(k == File_Input[file_input_number].size()-1){
//                            y = stoi(str1);
//                            str1 = "";
//                            break;;
//                        }
//
//
//                        if(File_Input[file_input_number][k] == ' '){
//
//                            if(check_vis2[0]== false){
//                                x = stoi(str1);
//                                str1 = "";
//                                check_vis2[0] = true;
//                                continue;
//                            }
//                        }
//
//
//
//
//                    }
//                    file_input_number++;
//
//                    //file_input_number++;
//
//                    check_vis2[0] = false;
//
//                    check_vis2[1] = false;
//
//                    cout << "x : " << x << " y : " << y << endl;
//
//
//                    Q.push(make_pair(x,y));
//                    vis[x][y] = true;
//                    count_board[x][y] = 0;
                    
                    //------
                    
                    cin >> x >> y;
                    
                    
                    Q.push(make_pair(x,y));
                    vis[x][y] = true;
                    count_board[x][y] = 0;
                    
                 
                }
                
                
            
            
            bfs(W, H);
            see_and_clear(W, H);
        }
        answer_V.push_back(answer);
        answer = 0;
        
        //cout << i << endl;
        //vis, count 초기화
    }
    
    
    for(int i=0; i<answer_V.size(); i++)
    {
        cout << answer_V[i] << '\n';
    }
    
}




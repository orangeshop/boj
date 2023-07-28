#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

int min_x, min_y, max_x, max_y;

vector<int> solution(vector<string> wallpaper) {
    vector<int> answer;
    min_x = 100;
    min_y = 100;
    for(int i =0; i< wallpaper.size(); i++){
        
        for(int k =0; k<wallpaper[i].size(); k++){
            // cout << i << " " << k << wallpaper[i][k] << endl;
            if(wallpaper[i][k] == '#'){
                
                min_x = min(min_x, i);
                min_y = min(min_y, k);
                max_x = max(max_x, i);
                max_y = max(max_y, k);
            }
        }
    }
    
    cout << min_x << min_y << max_x << max_y << endl;
    
    answer.push_back(min_x);
    answer.push_back(min_y);
    answer.push_back(max_x+1);
    answer.push_back(max_y+1);
    
    return answer;
}
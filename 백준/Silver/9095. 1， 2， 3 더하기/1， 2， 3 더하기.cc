#include <iostream>
#include <algorithm>

using namespace std;

int N;
int main(int argc, const char * argv[]) {
    cin >> N;
    for(int i =0; i < N; i++){
        int d[15];
        fill(d, d+15, 0);
        int n;
        cin >> n;
        d[1] = 1;
        d[2] = 2;
        d[3] = 4;
        
        for(int i = 4; i < 12; i++){
            d[i] = d[i-1] + d[i-2] + d[i-3];
        }
        
        cout << d[n] << endl;
    }
}
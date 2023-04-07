#include <iostream>
#include <string>
#include <vector>
#include <stack>
#include <algorithm>
#include <queue>
#include <tuple>
using namespace std;







int main()
{
    
    
    
    int a=0;
    cin >> a;
    queue<string> QQQ;
    for(int i=0; i<a; i++)
    {
        int b=0;
        cin >> b;
        
        queue<string> Q;
        int up[3][3] = {{1,1,1},{1,1,1},{1,1,1}};
        int front[3][3] = {{2,2,2},{2,2,2},{2,2,2}};
        int down[3][3] = {{3,3,3},{3,3,3},{3,3,3}};
        int back[3][3] = {{4,4,4},{4,4,4},{4,4,4}};
        int left[3][3] = {{5,5,5},{5,5,5},{5,5,5}};
        int right[3][3] = {{6,6,6},{6,6,6},{6,6,6}};
        
        
        for(int k=0; k< b; k++)
        {
            string str;
            cin >> str;
            
            Q.push(str);
            
        }
        
        for(int k=0; k< b; k++)
        {
            string str = Q.front(); Q.pop();
            
            if(str[0]=='F')
            {

                //cout << "F" << endl;
                if(str[1]=='-')
                {
                    int tmp_1 =0;
                    int tmp_2 =0;
                    int tmp_3 =0;
                    int tmp2_1 =0;
                    int tmp2_2 =0;
                    int tmp2_3 =0;
                    int tmp3_1 =0;
                    int tmp3_2 =0;
                    int tmp3_3 =0;
                    
                    tmp_1 = left[0][2];
                    tmp_2 = left[1][2];
                    tmp_3 = left[2][2];
                    tmp2_1 = down[0][0];
                    tmp2_2 = down[0][1];
                    tmp2_3 = down[0][2];
                    tmp3_1 = right[0][0];
                    tmp3_2 = right[1][0];
                    tmp3_3 = right[2][0];
                    
                    /*
                    right[0][0] = up[2][0];
                    right[1][0] = up[2][1];
                    right[2][0] = up[2][2];

                    down[2][2] = tmp_1;
                    down[2][1] = tmp_2;
                    down[2][0] = tmp_3;
                    
                    left[0][2] = tmp2_1;
                    left[1][2] = tmp2_2;
                    left[2][2] = tmp2_3;
                    
                    up[2][2] = tmp3_1;
                    up[2][1] = tmp3_2;
                    up[2][0] = tmp3_3;
                    */
                    left[2][2] = up[2][0];
                    left[1][2] = up[2][1];
                    left[0][2] = up[2][2];
                
                    down[0][0] = tmp_1;
                    down[0][1] = tmp_2;
                    down[0][2] = tmp_3;
                    
                    right[2][0] = tmp2_1;
                    right[1][0] = tmp2_2;
                    right[0][0] = tmp2_3;
                    
                    up[2][0] = tmp3_1;
                    up[2][1] = tmp3_2;
                    up[2][2] = tmp3_3;
                    
                    
                    int temp1=0;
                    int temp2=0;
                    int temp3=0;
                    int temp4=0;
                    int temp5=0;
                    int temp6=0;
                    int temp7=0;
                    int temp8=0;
                    
                    temp1 = front[0][0];
                    temp2 = front[0][1];
                    temp3 = front[0][2];
                    temp4 = front[1][0];
                    temp5 = front[1][2];
                    temp6 = front[2][0];
                    temp7 = front[2][1];
                    temp8 = front[2][2];
                    
                    front[2][0] = temp1;
                    front[2][1] = temp4;
                    front[2][2] = temp6;
                    front[1][2] = temp7;
                    front[0][2] = temp8;
                    front[0][1] = temp5;
                    front[0][0] = temp3;
                    front[1][0] = temp2;
                    
                    
                    
                    
                    
                }
                else if(str[1]=='+')
                {
                    int tmp_1 =0;
                    int tmp_2 =0;
                    int tmp_3 =0;
                    int tmp2_1 =0;
                    int tmp2_2 =0;
                    int tmp2_3 =0;
                    int tmp3_1 =0;
                    int tmp3_2 =0;
                    int tmp3_3 =0;
                    
                    tmp_1 = right[0][0];
                    tmp_2 = right[1][0];
                    tmp_3 = right[2][0];
                    tmp2_1 = down[0][0];
                    tmp2_2 = down[0][1];
                    tmp2_3 = down[0][2];
                    tmp3_1 = left[0][2];
                    tmp3_2 = left[1][2];
                    tmp3_3 = left[2][2];
                    
                    right[0][0] = up[2][0];
                    right[1][0] = up[2][1];
                    right[2][0] = up[2][2];

                    down[0][2] = tmp_1;
                    down[0][1] = tmp_2;
                    down[0][0] = tmp_3;
                    
                    left[0][2] = tmp2_1;
                    left[1][2] = tmp2_2;
                    left[2][2] = tmp2_3;
                    
                    up[2][2] = tmp3_1;
                    up[2][1] = tmp3_2;
                    up[2][0] = tmp3_3;
                    /*
                    left[2][2] = up[2][0];
                    left[1][2] = up[2][1];
                    left[0][2] = up[2][2];
                
                    down[2][0] = tmp_1;
                    down[2][1] = tmp_2;
                    down[2][2] = tmp_3;
                    
                    right[2][0] = tmp2_1;
                    right[1][0] = tmp2_2;
                    right[0][0] = tmp2_3;
                    
                    up[2][0] = tmp3_1;
                    up[2][1] = tmp3_2;
                    up[2][2] = tmp3_3;
                    */
                    int temp1=0;
                    int temp2=0;
                    int temp3=0;
                    int temp4=0;
                    int temp5=0;
                    int temp6=0;
                    int temp7=0;
                    int temp8=0;
                    
                    temp1 = front[0][0];
                    temp2 = front[0][1];
                    temp3 = front[0][2];
                    temp4 = front[1][0];
                    temp5 = front[1][2];
                    temp6 = front[2][0];
                    temp7 = front[2][1];
                    temp8 = front[2][2];
                    
                    front[0][2] = temp1;
                    front[1][2] = temp2;
                    front[2][2] = temp3;
                    front[2][1] = temp5;
                    front[2][0] = temp8;
                    front[1][0] = temp7;
                    front[0][0] = temp6;
                    front[0][1] = temp4;
                    
                    
                }
                /*
                cout << "f" << endl;
                
                for(int j=0; j<3; j++)
                {
                    for(int l=0; l<3; l++)
                    {
                        cout << front[j][l] << " ";
                    }
                    cout << endl;
                }
                cout << "u" << endl;
                for(int j=0; j<3; j++)
                {
                    for(int l=0; l<3; l++)
                    {
                        cout << up[j][l] << " ";
                    }
                    cout << endl;
                }
                cout << "b" << endl;
                for(int j=0; j<3; j++)
                {
                    for(int l=0; l<3; l++)
                    {
                        cout << back[j][l] << " ";
                    }
                    cout << endl;
                }
                cout << "d" << endl;
                for(int j=0; j<3; j++)
                {
                    for(int l=0; l<3; l++)
                    {
                        cout << down[j][l] << " ";
                    }
                    cout << endl;
                }
                cout << "l" << endl;
                for(int j=0; j<3; j++)
                {
                    for(int l=0; l<3; l++)
                    {
                        cout << left[j][l] << " ";
                    }
                    cout << endl;
                }
                cout << "r" << endl;
                for(int j=0; j<3; j++)
                {
                    for(int l=0; l<3; l++)
                    {
                        cout << right[j][l] << " ";
                    }
                    cout << endl;
                }*/
                
                

            }
            
            if(str[0]=='U')
            {
                //cout << "U" << endl;
                if(str[1]=='+')
                {
                    int tmp_1 =0;
                    int tmp_2 =0;
                    int tmp_3 =0;
                    int tmp2_1 =0;
                    int tmp2_2 =0;
                    int tmp2_3 =0;
                    int tmp3_1 =0;
                    int tmp3_2 =0;
                    int tmp3_3 =0;
                    
                    tmp_1 = left[0][0];
                    tmp_2 = left[0][1];
                    tmp_3 = left[0][2];
                    
                    tmp2_1 = back[0][0];
                    tmp2_2 = back[0][1];
                    tmp2_3 = back[0][2];
                    
                    tmp3_1 = right[0][0];
                    tmp3_2 = right[0][1];
                    tmp3_3 = right[0][2];
                    
                    left[0][0] = front[0][0];
                    left[0][1] = front[0][1];
                    left[0][2] = front[0][2];
                    
                    back[0][0] = tmp_1;
                    back[0][1] = tmp_2;
                    back[0][2] = tmp_3;
                    
                    right[0][0] = tmp2_1;
                    right[0][1] = tmp2_2;
                    right[0][2] = tmp2_3;
                    
                    front[0][0] = tmp3_1;
                    front[0][1] = tmp3_2;
                    front[0][2] = tmp3_3;
                    
                    int temp1=0;
                    int temp2=0;
                    int temp3=0;
                    int temp4=0;
                    int temp5=0;
                    int temp6=0;
                    int temp7=0;
                    int temp8=0;
                    
                    temp1 = up[0][0];
                    temp2 = up[0][1];
                    temp3 = up[0][2];
                    temp4 = up[1][0];
                    temp5 = up[1][2];
                    temp6 = up[2][0];
                    temp7 = up[2][1];
                    temp8 = up[2][2];
                    
                    up[0][2] = temp1;
                    up[1][2] = temp2;
                    up[2][2] = temp3;
                    up[2][1] = temp5;
                    up[2][0] = temp8;
                    up[1][0] = temp7;
                    up[0][0] = temp6;
                    up[0][1] = temp4;
                    
                    
                    
                }
                else if(str[1]=='-')
                {
                    int tmp_1 =0;
                    int tmp_2 =0;
                    int tmp_3 =0;
                    int tmp2_1 =0;
                    int tmp2_2 =0;
                    int tmp2_3 =0;
                    int tmp3_1 =0;
                    int tmp3_2 =0;
                    int tmp3_3 =0;
                    
                    tmp_1 = left[0][0];
                    tmp_2 = left[0][1];
                    tmp_3 = left[0][2];
                    
                    tmp2_1 = back[0][0];
                    tmp2_2 = back[0][1];
                    tmp2_3 = back[0][2];
                    
                    tmp3_1 = right[0][0];
                    tmp3_2 = right[0][1];
                    tmp3_3 = right[0][2];
                    
                    right[0][0] = front[0][0];
                    right[0][1] = front[0][1];
                    right[0][2] = front[0][2];
                    
                    back[0][0] = tmp3_1;
                    back[0][1] = tmp3_2;
                    back[0][2] = tmp3_3;
                    
                    left[0][0] = tmp2_1;
                    left[0][1] = tmp2_2;
                    left[0][2] = tmp2_3;
                    
                    front[0][0] = tmp_1;
                    front[0][1] = tmp_2;
                    front[0][2] = tmp_3;
                    
                    int temp1=0;
                    int temp2=0;
                    int temp3=0;
                    int temp4=0;
                    int temp5=0;
                    int temp6=0;
                    int temp7=0;
                    int temp8=0;
                    
                    temp1 = up[0][0];
                    temp2 = up[0][1];
                    temp3 = up[0][2];
                    temp4 = up[1][0];
                    temp5 = up[1][2];
                    temp6 = up[2][0];
                    temp7 = up[2][1];
                    temp8 = up[2][2];
                    
                    up[2][0] = temp1;
                    up[2][1] = temp4;
                    up[2][2] = temp6;
                    up[1][2] = temp7;
                    up[0][2] = temp8;
                    up[0][1] = temp5;
                    up[0][0] = temp3;
                    up[1][0] = temp2;
                    
                }
                
                /*
                cout << "f" << endl;
                
                for(int j=0; j<3; j++)
                {
                    for(int l=0; l<3; l++)
                    {
                        cout << front[j][l] << " ";
                    }
                    cout << endl;
                }
                cout << "u" << endl;
                for(int j=0; j<3; j++)
                {
                    for(int l=0; l<3; l++)
                    {
                        cout << up[j][l] << " ";
                    }
                    cout << endl;
                }
                cout << "b" << endl;
                for(int j=0; j<3; j++)
                {
                    for(int l=0; l<3; l++)
                    {
                        cout << back[j][l] << " ";
                    }
                    cout << endl;
                }
                cout << "d" << endl;
                for(int j=0; j<3; j++)
                {
                    for(int l=0; l<3; l++)
                    {
                        cout << down[j][l] << " ";
                    }
                    cout << endl;
                }
                cout << "l" << endl;
                for(int j=0; j<3; j++)
                {
                    for(int l=0; l<3; l++)
                    {
                        cout << left[j][l] << " ";
                    }
                    cout << endl;
                }
                cout << "r" << endl;
                for(int j=0; j<3; j++)
                {
                    for(int l=0; l<3; l++)
                    {
                        cout << right[j][l] << " ";
                    }
                    cout << endl;
                }*/
                
                               
            }
            
            
            
            if(str[0]=='B')
            {
                //cout << "B" << endl;
                if(str[1]=='-')
                {
                    int tmp_1 =0;
                    int tmp_2 =0;
                    int tmp_3 =0;
                    int tmp2_1 =0;
                    int tmp2_2 =0;
                    int tmp2_3 =0;
                    int tmp3_1 =0;
                    int tmp3_2 =0;
                    int tmp3_3 =0;
                    
                    tmp_1 = right[0][2];
                    tmp_2 = right[1][2];
                    tmp_3 = right[2][2];
                    
                    tmp2_1 = down[2][0];
                    tmp2_2 = down[2][1];
                    tmp2_3 = down[2][2];
                    
                    tmp3_1 = left[0][0];
                    tmp3_2 = left[1][0];
                    tmp3_3 = left[2][0];
                    
                    
                    right[0][2] = up[0][0];
                    right[1][2] = up[0][1];
                    right[2][2] = up[0][2];
                    
                    down[2][2] = tmp_1;
                    down[2][1] = tmp_2;
                    down[2][0] = tmp_3;
                    
                    left[2][0] = tmp2_3;
                    left[1][0] = tmp2_2;
                    left[0][0] = tmp2_1;
                    
                    up[0][0] = tmp3_3;
                    up[0][1] = tmp3_2;
                    up[0][2] = tmp3_1;
                    
                    int temp1=0;
                    int temp2=0;
                    int temp3=0;
                    int temp4=0;
                    int temp5=0;
                    int temp6=0;
                    int temp7=0;
                    int temp8=0;
                    
                    temp1 = back[0][0];
                    temp2 = back[0][1];
                    temp3 = back[0][2];
                    temp4 = back[1][0];
                    temp5 = back[1][2];
                    temp6 = back[2][0];
                    temp7 = back[2][1];
                    temp8 = back[2][2];
                    
                    back[2][0] = temp1;
                    back[2][1] = temp4;
                    back[2][2] = temp6;
                    back[1][2] = temp7;
                    back[0][2] = temp8;
                    back[0][1] = temp5;
                    back[0][0] = temp3;
                    back[1][0] = temp2;
                    
                    
                }
                else if(str[1]=='+')
                {
                    int tmp_1 =0;
                    int tmp_2 =0;
                    int tmp_3 =0;
                    int tmp2_1 =0;
                    int tmp2_2 =0;
                    int tmp2_3 =0;
                    int tmp3_1 =0;
                    int tmp3_2 =0;
                    int tmp3_3 =0;
                    
                    tmp_1 = right[0][2];
                    tmp_2 = right[1][2];
                    tmp_3 = right[2][2];
                    
                    tmp2_1 = down[2][0];
                    tmp2_2 = down[2][1];
                    tmp2_3 = down[2][2];
                    
                    tmp3_1 = left[0][0];
                    tmp3_2 = left[1][0];
                    tmp3_3 = left[2][0];
                    
                    left[2][0] = up[0][0];
                    left[1][0] = up[0][1];
                    left[0][0] = up[0][2];
                    
                    down[2][0] = tmp3_1;
                    down[2][1] = tmp3_2;
                    down[2][2] = tmp3_3;
                    
                    right[2][2] = tmp2_1;
                    right[1][2] = tmp2_2;
                    right[0][2] = tmp2_3;
                    
                    up[0][2] = tmp_3;
                    up[0][1] = tmp_2;
                    up[0][0] = tmp_1;
                    
                    
                    int temp1=0;
                    int temp2=0;
                    int temp3=0;
                    int temp4=0;
                    int temp5=0;
                    int temp6=0;
                    int temp7=0;
                    int temp8=0;
                    
                    temp1 = back[0][0];
                    temp2 = back[0][1];
                    temp3 = back[0][2];
                    temp4 = back[1][0];
                    temp5 = back[1][2];
                    temp6 = back[2][0];
                    temp7 = back[2][1];
                    temp8 = back[2][2];
                    
                    back[0][2] = temp1;
                    back[1][2] = temp2;
                    back[2][2] = temp3;
                    back[2][1] = temp5;
                    back[2][0] = temp8;
                    back[1][0] = temp7;
                    back[0][0] = temp6;
                    back[0][1] = temp4;
                }
                
                /*
                cout << "f" << endl;
                
                for(int j=0; j<3; j++)
                {
                    for(int l=0; l<3; l++)
                    {
                        cout << front[j][l] << " ";
                    }
                    cout << endl;
                }
                cout << "u" << endl;
                for(int j=0; j<3; j++)
                {
                    for(int l=0; l<3; l++)
                    {
                        cout << up[j][l] << " ";
                    }
                    cout << endl;
                }
                cout << "b" << endl;
                for(int j=0; j<3; j++)
                {
                    for(int l=0; l<3; l++)
                    {
                        cout << back[j][l] << " ";
                    }
                    cout << endl;
                }
                cout << "d" << endl;
                for(int j=0; j<3; j++)
                {
                    for(int l=0; l<3; l++)
                    {
                        cout << down[j][l] << " ";
                    }
                    cout << endl;
                }
                cout << "l" << endl;
                for(int j=0; j<3; j++)
                {
                    for(int l=0; l<3; l++)
                    {
                        cout << left[j][l] << " ";
                    }
                    cout << endl;
                }
                cout << "r" << endl;
                for(int j=0; j<3; j++)
                {
                    for(int l=0; l<3; l++)
                    {
                        cout << right[j][l] << " ";
                    }
                    cout << endl;
                }*/
            }
            
            if(str[0]=='D')
            {
                //cout << "D" << endl;
                if(str[1]=='-')
                {
                    int tmp_1 =0;
                    int tmp_2 =0;
                    int tmp_3 =0;
                    int tmp2_1 =0;
                    int tmp2_2 =0;
                    int tmp2_3 =0;
                    int tmp3_1 =0;
                    int tmp3_2 =0;
                    int tmp3_3 =0;
                    
                    tmp_1 = right[2][0];
                    tmp_2 = right[2][1];
                    tmp_3 = right[2][2];
                    
                    tmp2_1 = back[2][0];
                    tmp2_2 = back[2][1];
                    tmp2_3 = back[2][2];
                    
                    tmp3_1 = left[2][0];
                    tmp3_2 = left[2][1];
                    tmp3_3 = left[2][2];
                    
                    left[2][2] = front[2][2];
                     left[2][1] = front[2][1];
                     left[2][0] = front[2][0];
                     
                     back[2][2] = tmp3_3;
                     back[2][1] = tmp3_2;
                     back[2][0] = tmp3_1;
                     
                     right[2][0] = tmp2_1;
                     right[2][1] = tmp2_2;
                     right[2][2] = tmp2_3;
                     
                     front[2][2] = tmp_3;
                     front[2][1] = tmp_2;
                     front[2][0] = tmp_1;
                    /*
                    right[2][0] = front[2][2];
                    right[2][1] = front[2][1];
                    right[2][2] = front[2][0];
                    
                    back[2][0] = tmp_1;
                    back[2][1] = tmp_2;
                    back[2][2] = tmp_3;
                    
                    left[2][0] = tmp2_3;
                    left[2][1] = tmp2_2;
                    left[2][2] = tmp2_1;
                    
                    front[2][0] = tmp3_1;
                    front[2][1] = tmp3_2;
                    front[2][2] = tmp3_3;

                    */
                    int temp1=0;
                    int temp2=0;
                    int temp3=0;
                    int temp4=0;
                    int temp5=0;
                    int temp6=0;
                    int temp7=0;
                    int temp8=0;
                    
                    temp1 = down[0][0];
                    temp2 = down[0][1];
                    temp3 = down[0][2];
                    temp4 = down[1][0];
                    temp5 = down[1][2];
                    temp6 = down[2][0];
                    temp7 = down[2][1];
                    temp8 = down[2][2];
                    
                    down[2][0] = temp1;
                    down[2][1] = temp4;
                    down[2][2] = temp6;
                    down[1][2] = temp7;
                    down[0][2] = temp8;
                    down[0][1] = temp5;
                    down[0][0] = temp3;
                    down[1][0] = temp2;
                }
                else if(str[1] == '+')
                {
                    int tmp_1 =0;
                    int tmp_2 =0;
                    int tmp_3 =0;
                    int tmp2_1 =0;
                    int tmp2_2 =0;
                    int tmp2_3 =0;
                    int tmp3_1 =0;
                    int tmp3_2 =0;
                    int tmp3_3 =0;
                    
                    tmp_1 = right[2][0];
                    tmp_2 = right[2][1];
                    tmp_3 = right[2][2];
                    
                    tmp2_1 = back[2][0];
                    tmp2_2 = back[2][1];
                    tmp2_3 = back[2][2];
                    
                    tmp3_1 = left[2][0];
                    tmp3_2 = left[2][1];
                    tmp3_3 = left[2][2];
                    
                    
                   /* left[2][2] = front[2][2];
                    left[2][1] = front[2][1];
                    left[2][0] = front[2][0];
                    
                    back[2][2] = tmp3_1;
                    back[2][1] = tmp3_2;
                    back[2][0] = tmp3_3;
                    
                    right[2][0] = tmp_1;
                    right[2][1] = tmp_2;
                    right[2][2] = tmp_3;
                    
                    front[2][2] = tmp_1;
                    front[2][1] = tmp_2;
                    front[2][0] = tmp_3;*/
                    right[2][0] = front[2][0];
                    right[2][1] = front[2][1];
                    right[2][2] = front[2][2];
                    
                    back[2][0] = tmp_1;
                    back[2][1] = tmp_2;
                    back[2][2] = tmp_3;
                    
                    left[2][0] = tmp2_1;
                    left[2][1] = tmp2_2;
                    left[2][2] = tmp2_3;
                    
                    front[2][0] = tmp3_1;
                    front[2][1] = tmp3_2;
                    front[2][2] = tmp3_3;

                    int temp1=0;
                    int temp2=0;
                    int temp3=0;
                    int temp4=0;
                    int temp5=0;
                    int temp6=0;
                    int temp7=0;
                    int temp8=0;
                    
                    temp1 = down[0][0];
                    temp2 = down[0][1];
                    temp3 = down[0][2];
                    temp4 = down[1][0];
                    temp5 = down[1][2];
                    temp6 = down[2][0];
                    temp7 = down[2][1];
                    temp8 = down[2][2];
                    
                    down[0][2] = temp1;
                    down[1][2] = temp2;
                    down[2][2] = temp3;
                    down[2][1] = temp5;
                    down[2][0] = temp8;
                    down[1][0] = temp7;
                    down[0][0] = temp6;
                    down[0][1] = temp4;
                    
                }
                
                /*
                cout << "f" << endl;
                
                for(int j=0; j<3; j++)
                {
                    for(int l=0; l<3; l++)
                    {
                        cout << front[j][l] << " ";
                    }
                    cout << endl;
                }
                cout << "u" << endl;
                for(int j=0; j<3; j++)
                {
                    for(int l=0; l<3; l++)
                    {
                        cout << up[j][l] << " ";
                    }
                    cout << endl;
                }
                cout << "b" << endl;
                for(int j=0; j<3; j++)
                {
                    for(int l=0; l<3; l++)
                    {
                        cout << back[j][l] << " ";
                    }
                    cout << endl;
                }
                cout << "d" << endl;
                for(int j=0; j<3; j++)
                {
                    for(int l=0; l<3; l++)
                    {
                        cout << down[j][l] << " ";
                    }
                    cout << endl;
                }
                cout << "l" << endl;
                for(int j=0; j<3; j++)
                {
                    for(int l=0; l<3; l++)
                    {
                        cout << left[j][l] << " ";
                    }
                    cout << endl;
                }
                cout << "r" << endl;
                for(int j=0; j<3; j++)
                {
                    for(int l=0; l<3; l++)
                    {
                        cout << right[j][l] << " ";
                    }
                    cout << endl;
                }*/

            }
            
            
            if(str[0] == 'L')
            {
                //cout << "L" << endl;
                if(str[1]=='+')
                {
                    int tmp_1 =0;
                    int tmp_2 =0;
                    int tmp_3 =0;
                    int tmp2_1 =0;
                    int tmp2_2 =0;
                    int tmp2_3 =0;
                    int tmp3_1 =0;
                    int tmp3_2 =0;
                    int tmp3_3 =0;
                    
                    tmp_1 = front[0][0];
                    tmp_2 = front[1][0];
                    tmp_3 = front[2][0];
                    
                    tmp2_1 = down[0][0];
                    tmp2_2 = down[1][0];
                    tmp2_3 = down[2][0];
                    
                    tmp3_1 = back[0][2];
                    tmp3_2 = back[1][2];
                    tmp3_3 = back[2][2];
                    
                    /*
                    back[2][2] = up[0][0];
                    back[1][2] = up[1][0];
                    back[0][2] = up[2][0];
                    
                    down[2][0] = tmp3_1;
                    down[1][0] = tmp3_2;
                    down[0][0] = tmp3_3;
                    
                    front[2][0] = tmp2_3;
                    front[1][0] = tmp2_2;
                    front[0][0] = tmp2_1;
                    
                    up[2][0] = tmp_3;
                    up[1][0] = tmp_2;
                    up[0][0] = tmp_1;
                    */
                    front[2][0] = up[2][0];
                    front[1][0] = up[1][0];
                    front[0][0] = up[0][0];
                    
                    down[0][0] = tmp_1;
                    down[1][0] = tmp_2;
                    down[2][0] = tmp_3;
                    
                    back[0][2] = tmp2_3;
                    back[1][2] = tmp2_2;
                    back[2][2] = tmp2_1;
                    
                    up[0][0] = tmp3_3;
                    up[1][0] = tmp3_2;
                    up[2][0] = tmp3_1;
                    
                    int temp1=0;
                    int temp2=0;
                    int temp3=0;
                    int temp4=0;
                    int temp5=0;
                    int temp6=0;
                    int temp7=0;
                    int temp8=0;
                    
                    temp1 = left[0][0];
                    temp2 = left[0][1];
                    temp3 = left[0][2];
                    temp4 = left[1][0];
                    temp5 = left[1][2];
                    temp6 = left[2][0];
                    temp7 = left[2][1];
                    temp8 = left[2][2];
                    
                    left[0][2] = temp1;
                    left[1][2] = temp2;
                    left[2][2] = temp3;
                    left[2][1] = temp5;
                    left[2][0] = temp8;
                    left[1][0] = temp7;
                    left[0][0] = temp6;
                    left[0][1] = temp4;
  
                }
                else if(str[1]=='-')
                {
                    int tmp_1 =0;
                    int tmp_2 =0;
                    int tmp_3 =0;
                    int tmp2_1 =0;
                    int tmp2_2 =0;
                    int tmp2_3 =0;
                    int tmp3_1 =0;
                    int tmp3_2 =0;
                    int tmp3_3 =0;
                    
                    tmp_1 = front[0][0];
                    tmp_2 = front[1][0];
                    tmp_3 = front[2][0];
                    
                    tmp2_1 = down[0][0];
                    tmp2_2 = down[1][0];
                    tmp2_3 = down[2][0];
                    
                    tmp3_1 = back[0][2];
                    tmp3_2 = back[1][2];
                    tmp3_3 = back[2][2];
                    /*
                    front[2][0] = up[2][0];
                    front[1][0] = up[1][0];
                    front[0][0] = up[0][0];
                    
                    down[0][0] = tmp_1;
                    down[1][0] = tmp_2;
                    down[2][0] = tmp_3;
                    
                    back[0][2] = tmp2_3;
                    back[1][2] = tmp2_2;
                    back[2][2] = tmp2_1;
                    
                    up[0][0] = tmp3_3;
                    up[1][0] = tmp3_2;
                    up[2][0] = tmp3_1;
                    */
                    back[2][2] = up[0][0];
                    back[1][2] = up[1][0];
                    back[0][2] = up[2][0];
                    
                    down[2][0] = tmp3_1;
                    down[1][0] = tmp3_2;
                    down[0][0] = tmp3_3;
                    
                    front[2][0] = tmp2_3;
                    front[1][0] = tmp2_2;
                    front[0][0] = tmp2_1;
                    
                    up[2][0] = tmp_3;
                    up[1][0] = tmp_2;
                    up[0][0] = tmp_1;
                    
                    int temp1=0;
                    int temp2=0;
                    int temp3=0;
                    int temp4=0;
                    int temp5=0;
                    int temp6=0;
                    int temp7=0;
                    int temp8=0;
                    
                    temp1 = left[0][0];
                    temp2 = left[0][1];
                    temp3 = left[0][2];
                    temp4 = left[1][0];
                    temp5 = left[1][2];
                    temp6 = left[2][0];
                    temp7 = left[2][1];
                    temp8 = left[2][2];
                    
                    left[2][0] = temp1;
                    left[2][1] = temp4;
                    left[2][2] = temp6;
                    left[1][2] = temp7;
                    left[0][2] = temp8;
                    left[0][1] = temp5;
                    left[0][0] = temp3;
                    left[1][0] = temp2;
                }
                /*
                cout << "f" << endl;
                
                for(int j=0; j<3; j++)
                {
                    for(int l=0; l<3; l++)
                    {
                        cout << front[j][l] << " ";
                    }
                    cout << endl;
                }
                cout << "u" << endl;
                for(int j=0; j<3; j++)
                {
                    for(int l=0; l<3; l++)
                    {
                        cout << up[j][l] << " ";
                    }
                    cout << endl;
                }
                cout << "b" << endl;
                for(int j=0; j<3; j++)
                {
                    for(int l=0; l<3; l++)
                    {
                        cout << back[j][l] << " ";
                    }
                    cout << endl;
                }
                cout << "d" << endl;
                for(int j=0; j<3; j++)
                {
                    for(int l=0; l<3; l++)
                    {
                        cout << down[j][l] << " ";
                    }
                    cout << endl;
                }
                cout << "l" << endl;
                for(int j=0; j<3; j++)
                {
                    for(int l=0; l<3; l++)
                    {
                        cout << left[j][l] << " ";
                    }
                    cout << endl;
                }
                cout << "r" << endl;
                for(int j=0; j<3; j++)
                {
                    for(int l=0; l<3; l++)
                    {
                        cout << right[j][l] << " ";
                    }
                    cout << endl;
                }*/
            }
            
            if(str[0] == 'R')
            {
                //cout << "R" << endl;
                if(str[1]=='+')
                {
                    int tmp_1 =0;
                    int tmp_2 =0;
                    int tmp_3 =0;
                    int tmp2_1 =0;
                    int tmp2_2 =0;
                    int tmp2_3 =0;
                    int tmp3_1 =0;
                    int tmp3_2 =0;
                    int tmp3_3 =0;
                    
                    tmp_1 = front[0][2];
                    tmp_2 = front[1][2];
                    tmp_3 = front[2][2];
                    
                    tmp2_1 = down[0][2];
                    tmp2_2 = down[1][2];
                    tmp2_3 = down[2][2];
                    
                    tmp3_1 = back[0][0];
                    tmp3_2 = back[1][0];
                    tmp3_3 = back[2][0];
                    
                    //cout << front[0][2] << front[1][2]<< front[2][2] << endl;
                    back[0][0] = up[2][2];
                    back[1][0] = up[1][2];
                    back[2][0] = up[0][2];
                    
                    
                    down[2][2] = tmp3_1;
                    down[1][2] = tmp3_2;
                    down[0][2] = tmp3_3;
                    
                    front[0][2] = tmp2_1;
                    front[1][2] = tmp2_2;
                    front[2][2] = tmp2_3;
                    
                    up[0][2] = tmp_1;
                    up[1][2] = tmp_2;
                    up[2][2] = tmp_3;
                    
                    int temp1=0;
                    int temp2=0;
                    int temp3=0;
                    int temp4=0;
                    int temp5=0;
                    int temp6=0;
                    int temp7=0;
                    int temp8=0;
                    
                    temp1 = right[0][0];
                    temp2 = right[0][1];
                    temp3 = right[0][2];
                    temp4 = right[1][0];
                    temp5 = right[1][2];
                    temp6 = right[2][0];
                    temp7 = right[2][1];
                    temp8 = right[2][2];
                    
                    right[0][2] = temp1;
                    right[1][2] = temp2;
                    right[2][2] = temp3;
                    right[2][1] = temp5;
                    right[2][0] = temp8;
                    right[1][0] = temp7;
                    right[0][0] = temp6;
                    right[0][1] = temp4;
                    
                }
                else if(str[1]=='-')
                {
                    int tmp_1 =0;
                    int tmp_2 =0;
                    int tmp_3 =0;
                    int tmp2_1 =0;
                    int tmp2_2 =0;
                    int tmp2_3 =0;
                    int tmp3_1 =0;
                    int tmp3_2 =0;
                    int tmp3_3 =0;
                    
                    tmp_1 = front[0][2];
                    tmp_2 = front[1][2];
                    tmp_3 = front[2][2];
                    
                    tmp2_1 = down[0][2];
                    tmp2_2 = down[1][2];
                    tmp2_3 = down[2][2];
                    
                    tmp3_1 = back[0][0];
                    tmp3_2 = back[1][0];
                    tmp3_3 = back[2][0];
                    
                    front[0][2] = up[0][2];
                    front[1][2] = up[1][2];
                    front[2][2] = up[2][2];
                    
                    down[0][2] = tmp_1;
                    down[1][2] = tmp_2;
                    down[2][2] = tmp_3;
                    
                    back[0][0] = tmp2_3;
                    back[1][0] = tmp2_2;
                    back[2][0] = tmp2_1;
                    
                    up[0][2] = tmp3_3;
                    up[1][2] = tmp3_2;
                    up[2][2] = tmp3_1;
                    
                    int temp1=0;
                    int temp2=0;
                    int temp3=0;
                    int temp4=0;
                    int temp5=0;
                    int temp6=0;
                    int temp7=0;
                    int temp8=0;
                    
                    temp1 = right[0][0];
                    temp2 = right[0][1];
                    temp3 = right[0][2];
                    temp4 = right[1][0];
                    temp5 = right[1][2];
                    temp6 = right[2][0];
                    temp7 = right[2][1];
                    temp8 = right[2][2];
                    
                    right[2][0] = temp1;
                    right[2][1] = temp4;
                    right[2][2] = temp6;
                    right[1][2] = temp7;
                    right[0][2] = temp8;
                    right[0][1] = temp5;
                    right[0][0] = temp3;
                    right[1][0] = temp2;
                }
                /*
                cout << "f" << endl;
                
                for(int j=0; j<3; j++)
                {
                    for(int l=0; l<3; l++)
                    {
                        cout << front[j][l] << " ";
                    }
                    cout << endl;
                }
                cout << "u" << endl;
                for(int j=0; j<3; j++)
                {
                    for(int l=0; l<3; l++)
                    {
                        cout << up[j][l] << " ";
                    }
                    cout << endl;
                }
                cout << "b" << endl;
                for(int j=0; j<3; j++)
                {
                    for(int l=0; l<3; l++)
                    {
                        cout << back[j][l] << " ";
                    }
                    cout << endl;
                }
                cout << "d" << endl;
                for(int j=0; j<3; j++)
                {
                    for(int l=0; l<3; l++)
                    {
                        cout << down[j][l] << " ";
                    }
                    cout << endl;
                }
                cout << "l" << endl;
                for(int j=0; j<3; j++)
                {
                    for(int l=0; l<3; l++)
                    {
                        cout << left[j][l] << " ";
                    }
                    cout << endl;
                }
                cout << "r" << endl;
                for(int j=0; j<3; j++)
                {
                    for(int l=0; l<3; l++)
                    {
                        cout << right[j][l] << " ";
                    }
                    cout << endl;
                }*/
            
            }
            
            
        }
        
       
        
        
        for(int j=0; j<3; j++)
        {
            string line;
            
            for(int l=0; l<3; l++)
            {
                if(up[j][l]== 1)
                {
                    line += "w";
                }
                else if(up[j][l]== 2)
                {
                    
                    line += "r";
                }
                else if(up[j][l]== 3)
                {
                    //cout << "y ";
                    line += "y";
                }
                else if(up[j][l]== 4)
                {
                    //cout << "o ";
                    line += "o";
                }
                else if(up[j][l]== 5)
                {
                    //cout << "g ";
                    line += "g";
                }
                else if(up[j][l]== 6)
                {
                    //cout << "b ";
                    line += "b";
                }
            }
            
            QQQ.push(line);
        }
        
    }
    
    for(int i=0; i<a; i++)
    {
        for(int k=0; k<3;k++)
        {
            cout << QQQ.front() << endl;
            QQQ.pop();
        }
    }
    
}
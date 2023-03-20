#include <iostream>
#include <list>
#include <string>
using namespace std;



int main()
{
	list<char> li;
	string str;

	cin >> str;

	for (int i = 0; i < str.size(); i++)
	{
		li.push_back(str[i]);
	}

	int num = 0;
	cin >> num;

	list<char>::iterator iter_begin = li.begin();
	
	list<char>::iterator iter_cs = li.begin();

	for (int i = 0; i < str.size(); i++)
	{
		iter_cs++;
	}
	
	for (int i = 0; i < num+1; i++)
	{
		
		string str_1;
		getline(cin, str_1);

		if (str_1[0] == 'L')
		{
			if (iter_cs == li.begin())
			{
			}
			else {
				iter_cs--;
			}
		}
		if (str_1[0] == 'D')
		{
			if (iter_cs == li.end())
			{
			}
			else {
				iter_cs++;
			}
		}
		if (str_1[0] == 'B')
		{
			
			
			if (iter_cs == li.begin())
			{
			}
			else {
				iter_cs--;
				iter_cs =li.erase(iter_cs);
			}
		}
		if (str_1[0] == 'P')
		{
			
			li.insert(iter_cs,str_1[2]);
		}
	}
	
	for (int i : li)
	{
		cout << (char)i ; // 출력
	}

}
#include <iostream>
#include <list>
#include <string>
using namespace std;
int main()
{
	int num = 0;
	cin >> num;
	int while_i = 0;

	while (true)
	{
		if (while_i == num) 
		{ 
			break; 
		}

		string str;

		cin >> str;
		
		list<char> lis;
		list<char>::iterator iter_cs = lis.begin();
		for (int i = 0; i < str.size(); i++)
		{
			
			if (str[i] == '<')
			{
				if (iter_cs == lis.begin())
				{
				}
				else
				{
					iter_cs--;
				}
			}
			else if (str[i] == '>')
			{
				if (iter_cs == lis.end())
				{
				}
				else
				{
					iter_cs++;
				}
			}
			else if (str[i] == '-')
			{
				if (iter_cs == lis.begin())
				{
				}
				else {
					iter_cs--;
					iter_cs = lis.erase(iter_cs);
				}

			}
			else
			{
				if (iter_cs == lis.end())
				{
					lis.push_back(str[i]);
				}
				else {
					lis.insert(iter_cs, str[i]);
				}
			}
		}

		for (iter_cs = lis.begin(); iter_cs != lis.end(); iter_cs++)
		{
			cout << *iter_cs;
		}

		cout << endl;




		while_i++;
	}
}
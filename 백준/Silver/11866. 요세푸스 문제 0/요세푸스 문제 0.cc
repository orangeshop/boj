#include <iostream>
#include <list>
#include <string>
using namespace std;
int main()
{
	int num1, num2 = 0;
	cin >> num1;
	cin >> num2;

	list<int> lis;
	
	for (int i = 1; i <= num1; i++)
	{
		lis.push_back(i);
	}
	cout << "<";

	list<int>::iterator iter = lis.begin();
	
	for (int i = 0; i < num1; i++)
	{
		
		for (int k = 0; k < num2-1; k++)
		{
			
			

			iter++;
		

			if (iter == lis.end())
			{
				
				iter = lis.begin();
				
				
			}
			
				
			
			
		}

		
		cout << *iter;
		if (i == num1 - 1)
		{
		}
		else
		{
			cout << ", ";
		}
		
		iter = lis.erase(iter);
		if (iter == lis.end())
		{

			iter =lis.begin();

		}
		

	}

	cout << ">";
	
}
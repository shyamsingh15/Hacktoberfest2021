#include<iostream.h>
#include<conio.h>
void main()
{
	clrscr();
	int small, arr[50], size, j;
	cout<<"Enter Array Size (max 50) : ";
	cin>>size;
	cout<<"Enter array elements : ";
	for(j=0; j<size; j++)
	{
		cin>>arr[j];
	}
	cout<<"Searching for smallest element ...\n\n";
	small=arr[0];
	for(j=0; j<size; j++)
	{
		if(small>arr[j])
		{
			small=arr[j];
		}
	}
	cout<<"Smallest Element = "<<small;
	getch();
}

package stringProgram;

import java.lang.String;
import java.lang.System;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MaxNumberOfWords 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		String text="";
		
		System.out.println("\nEnter your text: ");
		text=sc.nextLine();
		
		if(text.equals(""))
		{
			System.out.println("\nInvalid Input");
			return;
		}
		else
		{
			MaxNumberOfWords obj=new MaxNumberOfWords();
			System.out.println("\nMaximum number of words in a sentence: "+obj.maxNumberOfWords(text));
		}
	}
	
	public int maxNumberOfWords(String text)
	{
		StringTokenizer st=new StringTokenizer(text,".!?");
		int numberOfSentences=st.countTokens();
		
		StringTokenizer st2=null;
		int arr[]=new int[numberOfSentences];
		int i=0;
		while(st.hasMoreTokens())
		{
			String sentence=st.nextToken();
			st2=new StringTokenizer(sentence," ");
			arr[i]=st2.countTokens();
			i++;
		}
		
		// maximum number of words in sentence
		int max=0;
		try{
			max=arr[0];
			for(i=1;i<numberOfSentences;i++)
			{
				if(max<arr[i])
					max=arr[i];
			}
		}catch(ArrayIndexOutOfBoundsException exp){
			exp.printStackTrace();
		}
		
		return max;
	}
}


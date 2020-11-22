package CircularString;

public class Index {
	public static void main(String[] args) {
		/*
		 * String s="navaneetha"; String s1="van"; System.out.println(s.indexOf(s1));
		 */
		String s2="navan";
		char array[]= {'n','a','v','a','n'};
		for(int i=0;i<array.length;i++)
		{
			char ch=array[i];
			array[i]='#';
			int l=s2.indexOf(ch);
			if(l<0)
			{
				System.out.println(array[i]);
			}
		}
	}

}


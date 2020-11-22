package StringExpressionEvaluating;

public class StringExpressionEvaluating {

	public static void main(String[] args) {

	}

	public static String calc()
	{
		String s = result.getText();
		int index, op, k = 0, d = 0, m = 0;
		float result1 = 0, num1 = 0, num2 = 0;
		boolean flag = true;
		while (flag)
		{
			flag = false;
			index = 0;
			op = 0;
			m = 0;
			d = 0;
			for (int j = 0; j < s.length(); j++)
			{
				if ((s.charAt(j) >= '0' && s.charAt(j) <= '9') || (s.charAt(j) == '.')
						|| (s.charAt(j) == '-' && j == 0))

					continue;

				if (pri(s.charAt(j)) > op)
				{
					index = j;
					op = pri(s.charAt(j));
				}
			}
			String temp = "", temp1 = "", temp2 = "";
			for (k = index - 1; ((k >= 0) && ((s.charAt(k) >= '0' && s.charAt(k) <= '9') || (s.charAt(k) == '.')
					|| (s.charAt(k) == '-' && k == 0))); k--)
			{
				temp += s.charAt(k);
				d = k;
			}
			for (k = index + 1; ((k < s.length())
					&& ((s.charAt(k) >= '0' && s.charAt(k) <= '9') || (s.charAt(k) == '.'))); k++)
			{
				temp2 += s.charAt(k);
				m = k;
			}
			for (k = temp.length() - 1; k >= 0; k--)
				temp1 += temp.charAt(k);
			try
			{
				num1 = Float.parseFloat(temp1);
				num2 = Float.parseFloat(temp2);
			}
			catch (Exception e11)
			{
				result.setText("Syntax Error");
			}
			switch (s.charAt(index))
			{

			case '+':
				result1 = num1 + num2;

				break;

			case '-':
				result1 = num1 - num2;

				break;

			case '*':
				result1 = num1 * num2;

				break;

			case '/':
				if (num2 == 0)

				{
					result.setText("Syntax Error");
					break;
				}
				result1 = num1 / num2;
				break;
			case '%':
				result1 = (num1 / 100) * num2;
				break;
			}
			if (d != 0 || m != 0)
			{
				String r = Float.toString(result1);
				if (r.substring(r.indexOf(".") + 1).equals("0"))
				{
					r = r.substring(0, r.indexOf("."));
				}
				s = s.substring(0, d) + r + s.substring(m + 1, s.length());
			}
			else
				break;
			for (k = 0; k < s.length(); k++)
			{
				if (s.charAt(k) == '-' && k == 0)
				{
					flag = false;
				}
				else if (s.charAt(k) == '+' || s.charAt(k) == '-' || s.charAt(k) == '*' || s.charAt(k) == '/')
					flag = true;
			}
		}
		return s;
	}

	public static int pri(char ch) {
		if (ch == '*' || ch == '/' || ch == '%')
			return 2;
		else if (ch == '+' || ch == '-')
			return 1;
		return 0;
	}
}

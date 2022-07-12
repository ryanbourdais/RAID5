
public class Tools
	{
		public static String StrToBinstr(String input)
		{
			char[] strChar = input.toCharArray();
			String result = "";
			for (int i = 0; i < strChar.length; i++)
			{
				String temp  = Integer.toBinaryString(strChar[i]);
				int  k = 0;
				while(8 - k >= temp.length())
				{
					k++;
					temp = "0" + temp;
				}
				result += temp + "";
			}
			return result;
		}
		
		public static String BinstrToStr(String input)
		{
			String output="";
			String [] inputs = null;
			inputs = new String[input.length()/8];
			int k = 0;
			for(int i = 0; i < input.length() / 8; i++)
			{
				inputs[i] = "";
			}
			for(int i = 0; i < input.length(); i+= 8)
			{
				inputs[k]  = input.substring(i, i + 8) + "";
				k++;
			}
			for(int i = 0; i < inputs.length; i++)
			{
				int temp = Integer.parseInt(inputs[i],2);
				output = output + (char)temp;
			}
			return output;
		}
	}

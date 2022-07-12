
public class SequenceStorage {
		Storage storage;
		public SequenceStorage(Storage storage)
		{
			if(storage.state == true)
			{
				System.out.println("No data");
			}
			this.storage = storage;
		}
		
		public String sequenceread()
		{
			System.out.println("start sequence read");
			String result ="";
			for (int i = 0; i < storage.size; i++)
			{
				if(storage.data.get(i) == "-1")
					break;
				result += storage.data.get(i) + "";
			}
			System.out.println("sequence  read stop");
			return result;
		}
		
		public boolean sequencewrite(String input)
		{
			int len = input.length();
			if(input.length() + storage.realsize > storage.size)
			{
				System.out.println("disk not large enough");
				len = storage.size  - storage.realsize;
				return false;
			}
			System.out.println("start sequence write");
			for (int i = 0; i < len; i++)
			{
				storage.data.set(i + storage.realsize, (String)(input.charAt(i) + ""));
			}
			storage.realsize += len;
			storage.state = false;
			System.out.println("sequence write stop");
			return true;
		}
		
		public  String sequenceByteread(int offset, int point)
		{
			return (String) storage.data.get(offset + point);
		}
	}
	
	
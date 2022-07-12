import java.util.ArrayList;

public abstract class Raid {
		 protected static ArrayList <Disk> disklist = new ArrayList<Disk>();
		 protected static int disknum=0;
		 
		 public boolean init(int disknum,int[] disksize)
		 {
			 int i;
			 for(i =0;i<disknum;i++)
			 {
				 Disk temp = new Disk(disksize[i]);
				 temp.setDescription("I am NO "+i+" disk.");
			 }
			 for(i=0;i<disklist.size();i++)
			 {
				 if(!disklist.get(i).clear())
					 return false;
			 }
			 return true;	 
		 }
		 
		public Raid(int disknum,int[] disksize)
		{
			if(disknum != disksize.length)
			{
				System.out.println("raid disk num is error");
			}
			init(disknum,disksize);
		}
			
		public static void readAll()
		{
			for(int i=0;i<disknum;i++)
			{
				String result ="";
				System.out.println("NO "+i);
				for(int j=0;j<disklist.get(i).size;j++)
				{
					result +=disklist.get(i).data.get(j)+"";
				}
				System.out.println(result);
			}
		}
	}
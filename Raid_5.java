
//Bourdais, Ryan
//rbourd4@lsu.edu
//PA-2 (RAID)
//Feng Chen
//CS4103-AU21
//CS410309






import java.io.FileReader;
import java.util.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;

public class Raid_5 {
	
	public static void main(String[ ] arg)  throws FileNotFoundException
	{
		
		Scanner cs = new Scanner(System.in);
		System.out.print("Enter a filename: ");
		String filename = cs.nextLine();
		System.out.print("Enter Number of Member Disks:  ");
		int Disks = cs.nextInt();
		cs.nextLine();
		System.out.print("Enter Block Size (In Bytes): ");
		int BlockSize = cs.nextInt();
		cs.nextLine();
		System.out.println("Enter Operation (Write, Read, Or Rebuild): ");
		String Operation = cs.nextLine();
		
		Disk disk = new Disk(Disks);	
		
		int[] size = new  int[Disks];
		for(int i = 0; i < BlockSize; i++)
		{
			size[i] = BlockSize;
		}
		
		Raid5 raid5 =new Raid5(Disks, size);
		
		if (Operation == "Write") 
		{
			raid5.SequenceRaidwrite(filename, disk);
		}
		else if (Operation == "Read")
		{
			SequenceStorage sequenceStorage = new SequenceStorage(null);
			sequenceStorage.sequenceread();
		}
		else if (Operation == "Rebuild")
		{
			raid5.rebuildRaid(Disks);
		}
		else {
			return;
		}
	}
	
}

		
	
	
	
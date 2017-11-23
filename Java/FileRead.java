import java.io.*;

public class FileRead {

	//FileRead newFile = new FileRead();
	static String textFile = "testdb.txt";
	
	public static void main(String[] args) throws Exception{
		
	FileReader fileReader = new FileReader(textFile);
	BufferedReader bufferReader = new BufferedReader(fileReader);
	
	LinkedListRecord thisLinkedList = new LinkedListRecord();
	int tempRecNum;
	String tempFName;
	String tempLName;
	String tempAddress;
	String tempCity;
	String tempState;
	String tempZip;
	String tempDate;
	String tempStuff1;
	String tempStuff2;
	String tempStuff3;
	String tempStuff4;
	
	String inputLine="";
	
	while((inputLine = bufferReader.readLine()) != null){
		String[] line = inputLine.split(",");
		tempLName = line[2];
		tempLName = tempLName.replace("\"","");
		tempLName = tempLName.trim();
		
		if(line[1].isEmpty() || thisLinkedList.findRecord(tempLName)!=null){continue;}
		
		else{
			
			tempRecNum = Integer.parseInt(line[0]);
			tempFName = line[1];
			tempAddress = line[3];
			tempCity = line[4];
			tempState = line[5];
			tempZip = line[6];
			tempDate = line[7];
			tempStuff1 = line[8];
			tempStuff2=line[9];
			tempStuff3 = line[10];
			tempStuff4 = inputLine.substring(inputLine.lastIndexOf(",") + 1);
		
		Record tempRecord;
		tempRecord = new Record(tempRecNum, tempLName, tempFName, tempAddress, tempCity, tempState, tempZip, tempDate, tempStuff1, tempStuff2,tempStuff3,tempStuff4);
		
		thisLinkedList.addRecord(tempRecord);
		
			}//else
	}//while

	thisLinkedList.printList();
	bufferReader.close();
	
	//CREATE TREE AND ADD NODES
	
	thisLinkedList.buildTree();
	

	}//main
	
}

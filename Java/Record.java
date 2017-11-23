
public class Record {

	Record prev;
	Record next;
	
	int recNum;
	String lName;
	String fName;
	String address;
	String city;
	String state;
	String zip;
	String date;
	String stuff1;
	String stuff2;
	String stuff3;
	String stuff4;
	
	public Record(
			int pRecNum,
			String pLName,
			String pFName,
			String pAddress,
			String pCity,
			String pState,
			String pZip,
			String pDate,
			String pStuff1,
			String pStuff2,
			String pStuff3,
			String pStuff4){
		
		recNum = pRecNum;
		lName = pLName;
		fName = pFName;
		address = pAddress;
		city = pCity;
		state = pState;
		zip = pZip;
		date = pDate;
		stuff1 = pStuff1;
		stuff2 = pStuff2;
		stuff3 = pStuff3;
		stuff4 = pStuff4;
		
	}//Record constructor
	
	public void print(){
		System.out.println(recNum + ":" + lName);
	}
	

}

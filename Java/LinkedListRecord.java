import java.util.Scanner;


public class LinkedListRecord {
	AVLTree thisTree=new AVLTree();

	long startSearch;
	long endSearch;
	long startBuild;
	long endBuild;
	
	Record firstRecord;
	Record lastRecord;

	
	public Record findRecord(String pLName){
		
		if(firstRecord==null){return null;}
		
		Record tempRecord = firstRecord;
		
		while(!tempRecord.lName.equals(pLName)){
			if(tempRecord.next == null){
				return null;
			}//if
			else{
				tempRecord = tempRecord.next;
			}//else
		}//while
		return tempRecord;
	}
	
	public void addRecord(Record pRecord){
	
		if(firstRecord == null){
			firstRecord = pRecord;}
		else{
			lastRecord.next=pRecord;
			pRecord.prev=lastRecord;
		}//else
		
		lastRecord = pRecord;
	}//add record
	
	
	public void printList(){
		Record tempRecord = firstRecord;
		
		while(tempRecord!=null){
			tempRecord.print();
//			System.out.println("Next:");
//			tempRecord.next.print();
//			System.out.println("\n");
			tempRecord = tempRecord.next;
		}//while
	}//printList
	
	public void buildTree(){
		
	startBuild = System.currentTimeMillis();
	
	Record tempRecord = firstRecord;
	
	while(tempRecord!=null){
		thisTree.addNode(tempRecord);
		tempRecord = tempRecord.next;
		
	}//while
	
	endBuild = System.currentTimeMillis();
	
	thisTree.traverse(thisTree.root);
	
	System.out.println("Number of Nodes: " + AVLTree.numberOfNodes);
	
	System.out.println("Root: " + thisTree.root.name);
	
	System.out.println("Total time to build: " + (endBuild - startBuild) +  " milliseconds.");
	
	System.out.println();
	
	searchTree();
	
	}//buildTree
	
	public void searchTree(){
		System.out.println("Enter a name that you would like to search for:");
		
		Scanner input = new Scanner(System.in);
		String searchName = (input.nextLine()).toUpperCase();
		
		startSearch = System.currentTimeMillis();
		Node returnNode = thisTree.searchName(searchName);
		endSearch = System.currentTimeMillis();
		
		System.out.println();
		
		if(returnNode==null){
			System.out.println(searchName + " was not found.");}
		else{
			System.out.println(searchName + " was found.");
			System.out.println("Parent: " + returnNode.parent);
			System.out.println("Balance: " + returnNode.balanceFactor);
			System.out.println("Height: " + returnNode.height);
			
			if(returnNode.leftChild==null){
				System.out.println("Left Child: null");}
			else{System.out.println("Left Child: " + returnNode.leftChild.name);}
			
			if(returnNode.rightChild==null){
				System.out.println("Right Child: null");}
			else{System.out.println("Right: " + returnNode.rightChild.name);}
			
		System.out.println("Record No.: " + returnNode.record.recNum +
						"; \t First Name: " + returnNode.record.fName +
						"; \t Address: " + returnNode.record.address +
						"; \t City: " + returnNode.record.city +
						"; \t State: " + returnNode.record.state +
						"; \t Zip: " + returnNode.record.zip);
		}//else
		
		System.out.println();
		System.out.println("Time to complete search: " + (endSearch-startSearch) + " milliseconds.");	
		System.out.println();
		
		searchTree();
	}//searchTree
}

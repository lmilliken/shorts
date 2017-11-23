public class AVLTree {
	
	Node root;
	static int numberOfNodes;

	
	long startSearch;
	long endSearch;
	
	
	public void addNode(Record pRecord){
		
		numberOfNodes = numberOfNodes + 1;
		
		Node newNode = new Node(pRecord);
		
		if(root==null){
			root = newNode;}
			
		else{
			Node thisNode = root;
			Node parent;
			
		while(true){
			
			parent = thisNode;
			
				if(pRecord.lName.compareTo(thisNode.record.lName) < 0){
					thisNode = thisNode.leftChild;
					if(thisNode==null){
						
						parent.leftChild = newNode;
						parent.leftChild.parent = parent;
						updateHeight(parent.leftChild);
						updateBalanceFactor(parent.leftChild);
						reBalance(parent.leftChild);
						return;
					}//if	
				}//if
				
				else{
					thisNode = thisNode.rightChild;
					if(thisNode == null){
						parent.rightChild = newNode;
						parent.rightChild.parent = parent;
						updateHeight(parent.rightChild);
						updateBalanceFactor(parent.rightChild);
						reBalance(parent.rightChild);
						return;
					}//if
					}//end else
			}//end while
		}//end Else
			
	}//addNode
	
	public void traverse(Node pNode){
		if(pNode!=null){
			traverse(pNode.leftChild);
			System.out.println(pNode.record.lName);
			
			if(pNode.parent==null){System.out.println("Root");}
			else{System.out.println("Parent: " + pNode.parent);}
			
			System.out.println("Balance: " + pNode.balanceFactor);
			System.out.println("Height:" + pNode.height);
			
			if (pNode.leftChild == null){
				System.out.println("L: null");
			}
			else{
			System.out.println("L: " + pNode.leftChild.record.lName);}
			

			if(pNode.rightChild == null){
				System.out.println("R: null");
			}
			else{System.out.println("R: " + pNode.rightChild.record.lName);}
			
			
			
			System.out.println();
			
			traverse(pNode.rightChild);
		}//if

	}//traverse
	
	
	public void updateHeight(Node pNode){
		
		Node parent = pNode;
		
		while(parent!=null){
			parent.height= 1 + java.lang.Math.max(height(parent.rightChild),height(parent.leftChild));
			parent = parent.parent;
		}
	}//updateHeight
	
	public int height(Node pNode){
		if(pNode==null){return -1;}
		else{return pNode.height;}
	}
	
	public void updateBalanceFactor(Node pNode){
		Node parent = pNode;
		
		while(parent!=null){
			parent.balanceFactor = height(parent.leftChild) - height(parent.rightChild);
			parent = parent.parent;
		}
	}//updateBalanceFactor
	
	public void reBalance(Node pNode){
		Node parent = pNode;
		while(parent!=null){
			
			//if right heavy
			if(parent.balanceFactor == -2){	
				//if left heavy
				if(parent.rightChild.balanceFactor == 1){
					doubleLeftRotate(parent);}//end if
				else{leftRotate(parent);}
			}//right heavy
			
			
			//if left heavy
			if(parent.balanceFactor ==2){
				//if right heavy
				if(parent.leftChild.balanceFactor == -1){
					doubleRightRotate(parent);}//end if
				else{rightRotate(parent);}
			}
			
			parent=parent.parent;
		}//while
	}//reBalance
	
	public void leftRotate(Node pNode){
		Node child = pNode;
		Node parent = child.rightChild;
		
		//checking to make sure if we are at the root
		if(child.parent!=null){
			parent.parent = child.parent;
			if(child.parent.rightChild==child){
				child.parent.rightChild=parent;}
			else{child.parent.leftChild=parent;}
			;}
		else{parent.parent=null;
			root = parent;}
		
		//check to see if left child is null
		if(parent.leftChild!=null){
			parent.leftChild.parent=child;
			child.rightChild = parent.leftChild;}
		else{child.rightChild = null;}
		
		//reassign the node
		parent.leftChild = child;
		child.parent = parent;
		
		updateHeight(child);
		updateBalanceFactor(child);
	}//left rotate
	
	
	public void doubleLeftRotate(Node pNode){
		
		rightRotate(pNode.rightChild);
		leftRotate(pNode);
		
	}//double Left
	
	public void rightRotate(Node pNode){
		Node child = pNode;
		Node parent = child.leftChild;
		
		//checking to make sure if we are at the root
		if(child.parent!= null){
			parent.parent = child.parent;
			//figure out if it goes on parent's right or left
			if(child.parent.rightChild==child){
				child.parent.rightChild = parent;}
			else{child.parent.leftChild=parent;}
			;}
		else{parent.parent=null;
			root = parent;}
		
		//check to see if right child is null
		if(parent.rightChild!=null){
			parent.rightChild.parent=child;
			child.leftChild = parent.rightChild;
		}
		else{child.leftChild = null;}
		
		//reassign the node
		parent.rightChild = child;
		child.parent = parent;
		
		
		updateHeight(child);
		updateBalanceFactor(child);
	}//left rotate
	
	public void doubleRightRotate(Node pNode){
		leftRotate(pNode.leftChild);
		rightRotate(pNode);
	}
	
	public Node searchName(String pName){
		Node thisNode = root;
		
		while(thisNode!=null){
			if(pName.compareTo(thisNode.name)<0){
				thisNode = thisNode.leftChild;}
			else if (pName.compareTo(thisNode.name)>0){
				thisNode = thisNode.rightChild;}
			else {return thisNode;}
		}//while
			
		return null;
	}//searchName
		
}//AVL Tree


class Node{
	
	Record record;
	String name;
	int height;
	int balanceFactor;
	
	Node parent;
	Node leftChild;
	Node rightChild;
	
	//node constructor
	Node(Record pRecord){
		record = pRecord;
		height = 0;
		name = pRecord.lName;
	}
	
	public String toString(){
		return record.lName;
	}
	
}


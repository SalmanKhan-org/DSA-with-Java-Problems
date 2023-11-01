package DSA_programs.IntroToHeaps;
import  java.util.*;
public class mergeKSortedList {
    static class Node{
		int data;
		int row;
		int col;
		Node(int data,int row,int col){
			this.data=data;
			this.row=row;
			this.col=col;
		}
       
	}
   static class Compare implements Comparator<Node>{
    public int compare(Node o1, Node o2) {
            if(o1.data<o2.data){
                return -1;
            }else if(o1.data==o2.data){
               return 0;
            }
        return 1;
     }
}
	public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k)
	{
		Queue<Node> minHeap=new PriorityQueue<Node>(new Compare());
		//1.put the first element of all the lists in minHeap
		for(int i=0;i<k;i++){
			Node node=new Node(kArrays.get(i).get(0),i,0);
			minHeap.add(node);
		}
		//2.put the minElement in Answer list
		ArrayList<Integer> sortedList=new ArrayList<>();
		while(minHeap.size()>0){
			//Extract min Element
			Node minNode=minHeap.remove();
			sortedList.add(minNode.data);

			int row=minNode.row;
			int col=minNode.col;
			//if element present in the list of minElement add that element to minHeap
			if(col+1<kArrays.get(row).size()){
				Node newNode=new Node(kArrays.get(row).get(col+1),row,col+1);
				minHeap.add(newNode);
			}
		}
		return sortedList;
	}
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> ar=new ArrayList<>();
        ArrayList<Integer> list1=new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(4);
        list1.add(7);
        ArrayList<Integer> list2=new ArrayList<>();
        list2.add(9);
        list2.add(10);
        list2.add(12);
        list2.add(17);
        ArrayList<Integer> list3=new ArrayList<>();
        list3.add(19);
        list3.add(20);
        list3.add(21);
        list3.add(22);
        ar.add(list1);
        ar.add(list2);
        ar.add(list3);
        ArrayList<Integer> mergedList=mergeKSortedArrays(ar, 3);
        System.out.println("The  merged list is:");
        System.out.println(mergedList);
    }
}

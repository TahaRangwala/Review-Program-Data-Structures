/*Name: Taha Rangwala
 * Date: September 15, 2016
 * Purpose: The purpose of this class to perform all the sorts and searchs that the user wants to
 * be done as generally as possible. All these sorts and searches below work for all employees, students,
 * and widgets as well.
 */

//Sort Search class header
public class SortSearch {
	
	/*Purpose: This uses the insertion sort technique on the array that is passed into this method
	 * @param compareArray This is the array that will be sorted
	 * @param Count This is the number of elements in the compareArray
	 * @return This returns an array of comparables that is sorted
	 */
	public static Comparable [] insertionSort(Comparable []compareArray, int Count){
		for(int i = 1; i < Count; i++){
			Comparable itemInsert = compareArray[i];
			int s = i - 1;
			boolean Finding = true;
			while(s >= 0 && Finding){
				if(itemInsert.compareTo(compareArray[s]) < 0){
					compareArray[s+1] = compareArray[s];
					s--;
				}
				else Finding = false;
				compareArray[s+1] = itemInsert;	
			}
		}
		return compareArray;
	}
	
	/*Purpose: This uses the selection sort technique on the array that is passed into this method
	 * @param compareArray This is the array that will be sorted
	 * @param Count This is the number of elements in the compareArray
	 * @return This returns an array of comparables that is sorted
	 */
	public static Comparable [] selectionSort(Comparable[] compareArray, int Count){
		for(int i = 0; i < Count; i++){
			int minIndex = findMinIndex(i, compareArray, Count);
			if(minIndex != i)
				compareArray = changeComparables(i, minIndex, compareArray);
		}
		return compareArray;
	}
	
	/*Purpose: This is used in the selection sort method to find the minimum index
	 * @param compareArray This is the array that is being sorted using selection sort
	 * @param Count This is the number of elements in the array
	 * @return This returns an integer value of the minimum index that is found
	 */
	private static int findMinIndex(int Position, Comparable [] compareArray, int Count){
		for(int i = Position + 1; i < Count; i++){
			if(compareArray[Position].compareTo(compareArray[i]) > 0)
				return i;
		}
		return Position;
	}
	
	/*Purpose: This makes certain elements switch places in the array of comparables for the selection
	 * sort
	 * @param Current This is the current value that is being switched
	 * @param Min This is the minimum value that is switching places with the cureent value
	 * @param compareArray This is the array of comparables that has been passed in
	 * @return This returns the array of comparables with the elements in different places since they
	 * have been switched
	 */
	private static Comparable [] changeComparables(int Current, int Min, Comparable [] compareArray){
		Comparable Change = compareArray[Current];
		compareArray[Current] = compareArray[Min];
		compareArray[Min] = Change;
		return compareArray;
	}
	
	/*Purpose: The purpose of this method is to search for a certain element in the array using the binary search
	 * technique
	 * @param compareArray This is the array of comparables passed in to be searched
	 * @param Count This is the number of elements in the array
	 * @param searchComparable This is the comparable that is being searched in the array
	 * @return This returns that position of the element that is being searched if it is found otherwise it returns
	 * -1
	 */
	public static int binarySearch(Comparable [] compareArray, int Count, Comparable searchComparable){
		int left = 0;
		int right = Count - 1;
		while(left <= right){
			int midpoint = (left+right)/2;
			if(compareArray[midpoint].compareTo(searchComparable) == 0)
				return midpoint;
			else if(compareArray[midpoint].compareTo(searchComparable) < 0)
				left = midpoint + 1;
			else right = midpoint - 1;
		}
		return -1;
	}
	
	/*Purpose: The purpose of this method is to search for a certain element in the array using the sequential search
	 * technique
	 * @param compareArray This is the array of comparables passed in to be searched
	 * @param Count This is the number of elements in the array
	 * @param searchComparable This is the comparable that is being searched in the array
	 * @return This returns that position of the element that is being searched if it is found otherwise it returns
	 * -1
	 */
	public static int sequentialSearch(Comparable [] compareArray, int Count, Comparable searchComparable){
		String Output = "";
		for(int i = 0; i < Count; i++){
			if(compareArray[i].compareTo(searchComparable) == 0)
				return i;
		}
		return -1;
	}
	
}
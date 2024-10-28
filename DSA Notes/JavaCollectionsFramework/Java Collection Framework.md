# Fundamentals for DSA

1. Insertion: add or put
2. Delete: remove
3. Traversal
4. Searching
5. Updating

## Arrays

## One Dimensional Array

![oneDimArray.png](./../docImages/img/arrays/oneDimArray.png)

	int[] array; // Declaration
    array = new int[10]; // Initialization

    // Combined Declaration and Initialization
    int[] arr = new int[]{1,2,3,4,5};

    // copy arr -> array
    System.arraycopy(arr, 0, array, 0, arr.length);

    for(int i: array){
        System.out.print(i+" ");
    }
    System.out.println();

    int[] num = {5,4,9,2,7,44,53,23,11};

    Arrays.sort(num); //If not sorted
    //Arrays.sort(num, fromIndex, toIndex); //Sort in range

    //Make sure element is sorted
    //It returns the index of the element if found
    int index = java.util.Arrays.binarySearch(num, 4);
    assert (index == 1):"Index is "+index+". Found the key.";

    Arrays.fill(num, -1); //Fill all array with same value
    //Arrays.fill(num, fromIndex, toIndex, value);

    //fromIndex is inclusive
    //toIndex is exclusive
    int[] nums = {5,4,9,2,7,44,53,23,11,0,-2};
    int[] copy = Arrays.copyOf(nums, 5); //5 is the length of the new copy array
    int[] copyOfRange = Arrays.copyOfRange(nums, 3, 7); //fromIndex - toIndex

    System.out.println(Arrays.toString(copy));
    System.out.println(Arrays.toString(copyOfRange));

    int[] a = {5,4,9,2,7};
    int[] b = {5,4,9,2,7};

    boolean isEquals = Arrays.equals(a, b);
    System.out.println(isEquals);

    //Multi-Dimensional arrays
    //Arrays.deepEquals(a, b);

    //Convert arrays to strings
    String arrayAsString = Arrays.toString(a);
    System.out.println(arrayAsString);

    //Convert arrays to a list
    //Converting an array to a list using Arrays.asList(a) can sometimes lead to unexpected results
    //Either use loop, stream or Integer instead of int :)
    List<int[]> arrayAsList = Arrays.asList(a);

    // reverse the array
    Collections.reverse(java.util.Arrays.asList(a));

    //This will go to the string section
    //Reverse array using string builder
    String[] stringArr = {"Hello", "World"};
    StringBuilder reversed = new StringBuilder();
    for (int i = stringArr.length; i > 0; i--) {
        reversed.append(stringArr[i - 1]).append(" ");
    }

    String[] reversedArray = reversed.toString().split(" ");
    System.out.println(Arrays.toString(reversedArray));

## Two Dimensional Array

![twoDimArray.png](./../docImages/img/arrays/twoDimArray.png)

	public static void twoDimensionalArray() {
        System.out.println("\n\n\n----------------------------------------");
        // Combined Declaration and Initialization
        int[][] matrix = new int[3][3];

        int firstElement = matrix[0][0];
        matrix[1][2] = 10;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println("\n");

        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element+" ");
            }
            System.out.println();
        }

        int[][] matrix1 = {
                {1, 2, 3},
                {4, 5, 6}
        };
        int[][] matrix2 = {
                {7, 8},
                {9, 10},
                {11, 12}
        };

        class MultiplyMatrices {
            int[][] multiplyMatrices(int[][] firstMatrix, int[][] secondMatrix) {
                int r1 = firstMatrix.length;
                int c1 = firstMatrix[0].length;
                int c2 = secondMatrix[0].length;
                int[][] product = new int[r1][c2];
                for (int i = 0; i < r1; i++) {
                    for (int j = 0; j < c2; j++) {
                        for (int k = 0; k < c1; k++) {
                            product[i][j] += firstMatrix[i][k] * secondMatrix[k][j];
                        }
                    }
                }
                return product;
            }

            void printMatrix(int[][] matrix) {
                for (int[] row : matrix) {
                    for (int column : row) {
                        System.out.print(column + " ");
                    }
                    System.out.println();
                }
            }
        }

        MultiplyMatrices multiplyMatrices = new MultiplyMatrices();
        int[][] result = multiplyMatrices.multiplyMatrices(matrix1, matrix2);
        System.out.println("Matrix Multiplication: \n");
        multiplyMatrices.printMatrix(result);
    }

## Strings In Java

## **Important Methods in Java's `String` and `StringBuilder` Classes**

In Java, `String` and `StringBuilder` are fundamental classes used for handling sequences of characters. Understanding their key methods is essential for effective string manipulation and performance optimization in your Java programs.

---

### **String Class**

The `String` class represents immutable character sequences. Once a `String` object is created, it cannot be modified. Here are some important methods you should know:

#### 1. **Creation and Initialization**

    String str = "Hello, World!";
    String str2 = new String("Hello, World!");


#### 2. **Length of a String**

- **`length()`**
    - Returns the length of the string.


    int len = str.length();
  

#### 3. **Character Access**

- **`charAt(int index)`**
    - Returns the character at the specified index.

  
    char ch = str.charAt(0); // 'H'
  

#### 4. **Substring Extraction**

- **`substring(int beginIndex)`**
    - Returns a new string starting from `beginIndex` to the end.

      
    String substr = str.substring(7); // "World!"

- **`substring(int beginIndex, int endIndex)`**
    - Returns a new string from `beginIndex` to `endIndex - 1`.

  
    String substr = str.substring(7, 12); // "World"
  

### 5. **String Comparison**

- **`equals(Object anotherObject)`**
    - Compares the content of two strings for equality.

  
    boolean isEqual = str.equals("Hello, World!"); // true
  

- **`equalsIgnoreCase(String anotherString)`**
    - Compares strings, ignoring case differences.


    boolean isEqual = str.equalsIgnoreCase("hello, world!"); // true
  

- **`compareTo(String anotherString)`**
    - Compares two strings lexicographically.

    
    int result = str.compareTo("Hello"); // positive value
  

#### 6. **Searching within a String**

- **`indexOf(String str)`**
    - Returns the index of the first occurrence of the specified substring.


    int index = str.indexOf("World"); // 7
  

- **`lastIndexOf(String str)`**
    - Returns the index of the last occurrence.

  
    int lastIndex = str.lastIndexOf("o"); // 8
  

- **`contains(CharSequence s)`**
    - Checks if the string contains the specified sequence.

    
    boolean contains = str.contains("World"); // true
  

#### 7. **String Modification (Returns New String)**

- **`toUpperCase()` / `toLowerCase()`**
    - Converts all characters to upper or lower case.


    String upper = str.toUpperCase(); // "HELLO, WORLD!"
  

- **`trim()`**
    - Removes leading and trailing white spaces.

  
    String trimmed = "   Hello ".trim(); // "Hello"
  

- **`replace(char oldChar, char newChar)`**
    - Replaces all occurrences of a character.


    String replaced = str.replace('o', 'a'); // "Hella, Warld!"


- **`replace(CharSequence target, CharSequence replacement)`**
    - Replaces each substring that matches the target sequence.

    
    String replaced = str.replace("World", "Java"); // "Hello, Java!"
  

- **`replaceAll(String regex, String replacement)`**
    - Replaces each substring that matches the regex.


    String digitsOnly = "abc123xyz".replaceAll("\\D", ""); // "123"


- **`split(String regex)`**
    - Splits the string around matches of the regex.

    
    String[] words = str.split(", "); // ["Hello", "World!"]
  

#### 8. **String Formatting**

- **`format(String format, Object... args)`**
    - Returns a formatted string.


      String formatted = String.format("Name: %s, Age: %d", "Alice", 30);
      // "Name: Alice, Age: 30"
      

#### 9. **String Conversion**

- **`valueOf(Object obj)`**
    - Returns the string representation of the object.

  
    String numStr = String.valueOf(123); // "123"
  

#### 10. **Checking String Characteristics**

- **`isEmpty()`**
    - Checks if the string is empty (`length() == 0`).

  
    boolean empty = "".isEmpty(); // true
  

- **`isBlank()`** *(Java 11 and above)*
    - Checks if the string is empty or contains only white spaces.

    
    boolean blank = "   ".isBlank(); // true
  

#### 11. **Joining Strings**

- **`join(CharSequence delimiter, CharSequence... elements)`**
    - Joins the given strings with the specified delimiter.

  
    String joined = String.join(", ", "Alice", "Bob", "Charlie");
    // "Alice, Bob, Charlie"
  

#### 12. String - String.valueOf() and .toString()

- **`String.valueOf() used when objects are static and has null values`**
- **`Arrays.toString() used when objects are not static and has no null values. It doesn't work with primitives`**


---

### **StringBuilder Class**

The `StringBuilder` class is used for creating mutable sequences of characters. It is more efficient than `String` when you need to modify strings frequently, especially in loops.

#### 1. **Creating a StringBuilder**


    StringBuilder sb = new StringBuilder(); // Default capacity 16
    StringBuilder sb = new StringBuilder("Hello");
    StringBuilder sb = new StringBuilder(50); // Specified capacity


#### 2. **Appending**

- **`append(String str)`**
    - Appends the specified string to the sequence.


      sb.append(", World!");
      // sb now contains "Hello, World!"
  

- **Overloaded `append` Methods**
    - You can append various data types.

    
    sb.append(123);          // Appends "123"
    sb.append(true);         // Appends "true"
    sb.append(45.67);        // Appends "45.67"
    sb.append(new char[]{'A', 'B'}); // Appends "AB"
    

#### 3. **Inserting**

- **`insert(int offset, String str)`**
    - Inserts the specified string at the specified position.

  
    sb.insert(5, ", Java");
    // If sb was "Hello, World!", now it's "Hello, Java, World!"
  

#### 4. **Replacing**

- **`replace(int start, int end, String str)`**
    - Replaces the characters in a substring with the specified string.

  
    sb.replace(7, 12, "Universe");
    // Changes "Hello, World!" to "Hello, Universe!"
  

#### 5. **Deleting**

- **`delete(int start, int end)`**
    - Removes characters from `start` (inclusive) to `end` (exclusive).

  
    sb.delete(5, 7);
    // Removes characters at index 5 and 6
  

- **`deleteCharAt(int index)`**
    - Removes the character at the specified index.

  
    sb.deleteCharAt(0);
    // Removes the first character
  

#### 6. **Reversing**

- **`reverse()`**
    - Reverses the sequence of characters.


    sb.reverse();
    // Reverses the entire sequence
  

#### 7. **Capacity and Size**

- **`capacity()`**
    - Returns the current capacity (allocated size) of the `StringBuilder`.

    
    int cap = sb.capacity();
  

- **`ensureCapacity(int minimumCapacity)`**
    - Ensures that the capacity is at least equal to the specified minimum.


    sb.ensureCapacity(100);


- **`length()`**
      - Returns the number of characters (the length) in the sequence.

     
      int len = sb.length();


- **`setLength(int newLength)`**
    - Sets the length of the character sequence.


    sb.setLength(5); // Truncates or pads with null characters


#### 8. **Character Access and Modification**

- **`charAt(int index)`**
    - Returns the character at the specified index.


    char ch = sb.charAt(0);
    

- **`setCharAt(int index, char ch)`**
    - Sets the character at the specified index.

    
    sb.setCharAt(0, 'h');
    // Changes first character to 'h'
  

#### 9. **Substring Extraction**

- **`substring(int start)`**
    - Returns a new `String` starting from `start` to the end.


    String substr = sb.substring(7);
  

- **`substring(int start, int end)`**
    - Returns a new `String` from `start` to `end - 1`.


    String substr = sb.substring(7, 12);


#### 10. **Converting to String**

- **`toString()`**
    - Converts the `StringBuilder` to a `String`.


    String result = sb.toString();

### **Comparison between `String` and `StringBuilder`**

- **Mutability**
    - `String`: Immutable. Any modification creates a new string.
    - `StringBuilder`: Mutable. Modifications change the original object.

- **Thread-Safety**
    - `StringBuilder`: Not thread-safe. Use `StringBuffer` if synchronization is required.
    - `String`: Immutable, inherently thread-safe.

- **Performance**
    - `StringBuilder` is generally faster for modifying strings, especially in loops or frequent concatenations.


### **When to Use Which**

- Use **`String`** when:
    - You have a constant or unchanging sequence of characters.
    - You need thread safety with immutable objects.
    - You are performing read-only operations.

- Use **`StringBuilder`** when:
    - You need to modify the string frequently.
    - You are concatenating strings in a loop.
    - Performance is critical, and thread safety is not a concern.


### **Example Usage**

**Using `String` in Concatenation (Inefficient in Loops)**


    String result = "";
    for (int i = 0; i < 5; i++) {
        result += i; // Creates a new String object each time
    }
    // result: "01234"

**Using `StringBuilder` in Concatenation (Efficient in Loops)**

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 5; i++) {
        sb.append(i); // Modifies the existing object
    }
    String result = sb.toString();
    // result: "01234"


### **Summary of Important Methods**

#### **String Methods**

- **Creation**: `String str = "text";`
- **Length**: `length()`
- **Access**: `charAt(index)`
- **Substring**: `substring(start, end)`
- **Comparison**: `equals()`, `equalsIgnoreCase()`, `compareTo()`
- **Search**: `indexOf()`, `lastIndexOf()`, `contains()`
- **Modification** (returns new string): `toUpperCase()`, `toLowerCase()`, `trim()`, `replace()`, `replaceAll()`, `split()`
- **Formatting**: `format()`
- **Conversion**: `valueOf()`
- **Checks**: `isEmpty()`, `isBlank()`
- **Joining**: `join()`

#### **StringBuilder Methods**

- **Creation**: `new StringBuilder()`, `new StringBuilder("text")`
- **Append**: `append()`
- **Insert**: `insert(index, "text")`
- **Replace**: `replace(start, end, "text")`
- **Delete**: `delete(start, end)`, `deleteCharAt(index)`
- **Reverse**: `reverse()`
- **Capacity**: `capacity()`, `ensureCapacity(minCapacity)`
- **Length**: `length()`, `setLength(newLength)`
- **Access**: `charAt(index)`, `setCharAt(index, ch)`
- **Substring**: `substring(start, end)`
- **Conversion**: `toString()`

---

### **Additional Tips**

- For Java versions 11 and above, explore new `String` methods like `isBlank()`, `lines()`, `repeat()`, and `strip()`.
- Use `StringBuffer` if you need a thread-safe mutable sequence of characters.
- Always consider performance implications when manipulating strings inside loops.

### **Conclusion**

Understanding these methods will greatly enhance your ability to work with strings in Java effectively. Remember to choose between `String` and `StringBuilder` based on your specific needs regarding mutability, performance, and thread safety.

Hope this helps you grasp the essential methods for `String` and `StringBuilder` in Java!


## Collection Framework

![CollectionFramework.png](./../docImages/img/CollectionFramework.png)

### Iterator Interface

	Iterator<data-type> itr = list.iterator();

	public boolean hasNext(); //Returns true if the iterator has more elements 
	
	public Object next(); //Returns the element and moves to the next element.
	
	public void remove(); //Removes the last elements returned by the iterator.

### Collection Interface

	Collection<Integer> list = new ArrayList<>();
	Collection.min(list);
	Collection.max(list);
	Collection.frequency(list, element);
	Collection.sort(list);
	Collection.sort(list, Comparator.reserveOrder());

#### List Interface

ArrayList:

	List<Character> list = new ArrayList<>();
	List<Character> list = new ArrayList<>(10); //Initial Capacity increaseable

	list.add('A');  // boolean
	list.add('F');  // boolean
	list.add('G');  // boolean
	System.out.println(list);  // void (prints the list)
	
	list.add(0, 'B');  // void (inserts 'B' at index 0)
	System.out.println(list);  // void (prints the list)
	
	list.remove(1);  // E (removes the element at index 1 and returns it)
	System.out.println(list);  // void (prints the list)
	
	list.remove(Character.valueOf('B')); //Pass Element as object. boolean (removes the first occurrence of 'B' and returns true if successful)
	
	System.out.println(list);  // void (prints the list)
	
	list.get(1);  // E (returns the element at index 1)
	list.set(0, 'D'); // E (replaces the element at index and returns the old element)
	
	list.size();  // int (returns the number of elements in the list)
	list.isEmpty(); // boolean (returns true if the list is empty)
	list.contains('E'); // boolean (returns true if the list contains 'E')
	list.indexOf('A');  // int (returns index of the first occurrence or -1)
	  
	System.out.println(list);
	
	for(int i=0; i<list.size(); i++){
	    System.out.println(list.get(i));
	}
	
	for(Integer element: list){
	    System.out.println(element);
	}


	Iterator<String> iterator = list.iterator();
	while(iterator.hasNext()){
		iterator.next();		
	}
	
	ListIterator<String> listIterator = list.iterator();
	while(listIterator.hasNext()){
		listIterator.next();		
	}

	//Note: With iterator, we can iterate the list and remove the element simultaneously. Else it is not possible using list, array list etc.
	
	// Using toArray to get array of elements
	Object[] array = list.toArray();
	System.out.println("Array from list:");
	for (Object element : array) {
		System.out.print(element + " ");
	}

	System.out.println(); // Output: B C D
	// Using toArray with type parameter
	
	String[] stringArray = list.toArray(new String[0]);
	System.out.println("String array from list:");
	for (String element : stringArray) {
	    System.out.print(element + " ");
	}
	
	System.out.println(); // Output: B C D
	list.clear();
		

Linked List:

- Insert at head/ Insert as tail/ Insert at index
- Delete at head/ delete at tail/ delete at index

Code:

	List<Character> list = new LinkedList<>();
	List<Character> list = new LinkedList<>(10); //Initial Capacity increaseable

	list.add('A');  // boolean
	list.add('F');  // boolean
	list.add('G');  // boolean
	System.out.println(list);  // void (prints the list)
	
	list.add(0, 'B');  // void (inserts 'B' at index 0)
	System.out.println(list);  // void (prints the list)
	
	list.remove(1);  // E (removes the element at index 1 and returns it)
	System.out.println(list);  // void (prints the list)
	
	list.remove(Character.valueOf('B')); //Pass Element as object. boolean (removes the first occurrence of 'B' and returns true if successful)
	
	System.out.println(list);  // void (prints the list)
	
	list.get(1);  // E (returns the element at index 1)
	list.set(0, 'D'); // E (replaces the element at index and returns the old element)
	
	list.size();  // int (returns the number of elements in the list)
	list.isEmpty(); // boolean (returns true if the list is empty)
	list.contains('E'); // boolean (returns true if the list contains 'E')
	list.indexOf('A');  // int (returns index of the first occurrence or -1)
	  
	System.out.println(list);
	
	for(int i=0; i<list.size(); i++){
	    System.out.println(list.get(i));
	}
	
	for(Integer element: list){
	    System.out.println(element);
	}


	Iterator<String> iterator = list.iterator();
	while(iterator.hasNext()){
		iterator.next();		
	}
	
	ListIterator<String> listIterator = list.iterator();
	while(listIterator.hasNext()){
		listIterator.next();		
	}

	//Note: With iterator, we can iterate the list and remove the element simultaneously. Else it is not possible using list, array list etc.
	
	// Using toArray to get array of elements
	Object[] array = list.toArray();
	System.out.println("Array from list:");
	for (Object element : array) {
		System.out.print(element + " ");
	}

	System.out.println(); // Output: B C D 
	// Using toArray with type parameter
	
	String[] stringArray = list.toArray(new String[0]);
	System.out.println("String array from list:");
	for (String element : stringArray) {
	    System.out.print(element + " ");
	}
	
	System.out.println(); // Output: B C D
	list.clear();

	If,
	LinkedList<Character> list = new LinkedList<>();
	list.addFirst(E);
	list.addLast(E);
	list.removeFirst();
	list.removeLast();
	list.getFirst();
	list.getLast();

### Stack in Java

Use the concept of Last In First Out.  

![Stack.png](./../docImages/img/stackAndQueues/Stack.png)

	// Basic initialize  
	Stack<Integer> stack = new Stack<>();  
	stack.isEmpty(); // returns true/false  
	stack.peek(); // returns the top value but will not remove  
	stack.pop(); // retruns the top and remove it from the stack  
	stack.push();  
	stack.size(); // returns the size of the stack  
	stack.search(O);
	stack.toArray();  
	stack.toString();

### Queue in Java

First in first out

![Queue.png](./../docImages/img/stackAndQueues/Queue.png)

	// Basic initialization  
	Queue<Integer> queue = new LinkedList<>();  
	  
	queue.isEmpty(); // returns true/false  
	queue.peek(); // returns the first element of the queue and don't remove  
	queue.element(); -> Returns the head of the queue. Throws an exception if the queue is empty.
	  
	// Add item  
	queue.offer(10); // add end of the queue. don't throw exception  
	queue.add(10); // add end of the queue throw exception  
	  
	// Remove  
	queue.poll(); // return the first element and remove the first of the queue  
	queue.remove(); // same as poll but capable to throws an exception  
	  
	queue.size(); // returns the size of the queue  
	queue.toArray();

#### PriorityQueue

It uses heap data structure, where the top priority queue is entered into the queue and then queue  operations are performed.

	// Basic initialization  
	Queue<Integer> pQueue = new PriorityQueu<>() // By default ASC  
	
	// DSC  
	PriorityQueue<Integer> pQueue =  new PriorityQueue<Integer>(Collections.reverseOrder());  
	
	PriorityQueue<Integer> pQueue =  new PriorityQueue<Integer>((a, b) -> b - a);  
	  
	pQueue.isEmpty(); // returns true/false  
	  
	pQueue.peek(); // returns the first element of the queue and don't remove  
	  
	// Add item  
	pQueue.offer(10); // add end of the priority queue. don't throw exception  
	pQueue.add(10); // add end of the priority queue throw exception  
	  
	// Remove  
	pQueue.poll(); // return first item and remove first item of priority queue  
	pQueue.remove(); // same as poll but capable to throws an exception  
	  
	pQueue.size(); // returns the size of the queue  
	pQueue.toArray();

#### ArrayDequeue

Offer element from rear end and front end.  
E.g. Window proper

    ArrayDeque<Integer> arrayDeque = new ArrayDequeue<>();
    arrayDeque.offer(23);
    arrayDeque.offerFirst(12);
    arrayDeque.offerLast(45); 
    
    arrayDeque.peek();
    arrayDeque.peekFirst();
    arrayDeque.peekLast();
    
    arrayDeque.poll();
    arrayDeque.pollFirst();
    arrayDeque.pollLast();

<hr>

## HashMap in Java

Java HashMap class inplements Map interface which allows storing data in <Key, Value> pair where keys are unique. If user tries to insert duplicate Key with same or different Value, it will replace the element (Value) of the corresponding Key.

- Key is unique and no duplication is allowed.
- HashMap allows one null key and multiple null values.
- HashMap is not synchronized, which means it is not thread-safe

HashMap class in found in the java.util package.

1. Java HashMap contains values based on the key.
2. Java HashMap contains only unique keys.
3. Java HashMap may have one null key and multiple null values.
4. Java HashMap is non synchronized.
5. Java HashMap maintains no order.
6. The initial default capacity of Java HashMap class is 16 with a load factor of 0.75.

Map Operations:

	// Basic initialization  
	public class HashMap<K,V> extends AbstractMap<K,V> implements Map<K,V>, Cloneable, Serializable
	
	Map<K, V> map = new HashMap<>();  
	Map<Integer, List<String>> map = new HashMap<>();  
	Map<Integer, List<String>> map = new HashMap<>(Capacity);  
	  
	map.size();
	map.isEmpty();
	map.clear();
	
	// Contains  
	map.containsKey(key); // Returns true if this map contains key.  
	map.containsValue(V); // Returns true if this map contains value.  
	  
	// Get item  
	map.get(key);  
	map.getOrDefault(key, defaultValue);  
	  
	// Put item  
	map.put(K,V); // Adding or putting elements at a given key forming a key-value pair
	
	map.putIfAbsent(K, V);
	map2.putAll(map1);
	  
	// Remove  
	map.remove(key); //remove a key-value pari by key
	map.remove(K,V);
	
	// Replace
	map.replace(K,V);
	map.replace(K,V,V1);
	map.replaceAll((k,v) -> "Ajay");
	  
	// Looping through the HashMap  
	for (Map.Entry<String,Integer> element : map.entrySet()) {  
	    String key = element.getKey();  
	    int value = element.getValue();  
	}  
	  
	// List of keys  
	map.keySet();
	List<String> list = new ArrayList<>(map.keySet()); // make list  
	  
	// List of values  
	map.values();
	List<Value> list = new ArrayList<Value>(map.values());  
	  
	// how to check the key is available or not  
	if(map.get(key) != null){  
		  // to do  
	}  
	  
	// array of map  
	Map<String, String>[] map = new HashMap[26];  
	for(int i = 0; i < 26; i++){  
		  map[i] = new HashMap<>();  
	}  
	
	for(int i = 0; i < 26; i++){  
		  for(int j = 0; j<10; j++){  
		    map[i].put("key"+j, "value"+j);  
		  }  
	}

	//Iterate over key-value pair
	for (Map.Entry<KeyType, ValueType> entry : map.entrySet()) {
	
		KeyType key = entry.getKey(); //1,2,3
		ValueType value = entry.getValue(); //One, Two, Three
		System.out.println(entry.getKey()+" -> "+entry.getValue()+" "+entry);
		// process the key and value
	}
	
	// Iterating over keys only
	for (Integer key : map.keySet()) {
		System.out.println("Key = " + key); //1,2,3
	}
	
	// Iterating over values only
	
	for (Integer value : map.values()) {
		System.out.println(value); //One, Two, Three
	}

### Map to Set

In order to traverse the map, we need to convert the map into a set first using Entry and entrySet().

	Set<Map.Entry<Integer, String>> set = map.entrySet(); // Converting map to set using map.entrySet()
	
	System.out.println("Set: "+set);

### Using Non-Generic Method

Calling iterator method which we use to traverse collection objects like Lists, Sets etc.

	Iterator itr = set.iterator();
	while(itr.hasNext()){
	
		Map.Entry entry = (Map.Entry) itr.next(); //Converting to Map.Entry so that we can get key and value separately.
	
		System.out.println(entry.getKey()+" -> "+entry.getValue());
	}

### Using Generic Method

	Map<K,V> map = new HashMap<>();
	
	for(Map.Entry<Integer, String> entry: map.entrySet()){
		System.out.println(entry.getKey()+" -> "+entry.getValue()+" "+entry);
	}

## Tree Map
	
	// Basic initialization  
	Map<String, Integer> treeMap = new TreeMap<>(); // by default ASC  
	Map<K, V> treeMap = new TreeMap<>(Collections.reverseOrder());  
	  
	treeMap.get(key)  
	treeMap.getOrDefault(Object key, V defaultValue);  
	  
	// Put item  
	treeMap.put(key, vlaue)  
	  
	// Remove  
	treeMap.remove(Object key)  
	  
	// Entry access  
	Map.Entry<K,V> entry = treeMap.firstEntry();  
	Map.Entry<K,V> entry = treeMap.lastEntry();  
	  
	// Looping through the HashMap  
	for (Map.Entry<String,Integer> element : treeMap.entrySet()) {  
	    String key = element.getKey();  
	    int value = element.getValue();  
	}  
	  
	// List of keys  
	treeMap.keySet()  
	List<String> list = new ArrayList<>(treeMap.keySet()); // makes list  
	  
	// List of valu  
	treeMap.values()  
	List<Value> list = new ArrayList<Value>(treeMap.values());

---

### HashSet in Java

Element can be inserted only once. So no duplicate value is provided. Order doesn't matter.  
Operations are mainly O(1).
For objects, set doesn't find unique values, like new Student(1, "Varun") and new Student(1, "Varun"),  to identify unique objects, we have hashCode() and equals()  
Methods: add(E), remove(O), isEmpty(), contains(O), size(), clear()

	// Basic Initialization  
	Set<String> set= new HashSet<>();  
	  
	set.size();  
	set.add()  
	set.contains()  
	set.remove(Object o) // Removes the element from this set if it's present.  
	  
	set.clear();  
	set.isEmpty();  
	  
	// Looping through  
	for (String s : set) {  
		System.out.println(s);  
	}

#### LinkedHashSet

Linked HashSet: Maintain the order

#### TreeSet

TreeSet: Sorted Set (Binary Search Tree)  
Operations are mainly O(log n)  
It uses comparator to compare two objects, not hashCode() or equals()

	Set<Integer> treeSet = new TreeSet<Integer>() // default ASC  
	// reverse order  
	TreeSet<Integer> treeSet = new TreeSet<Integer>(  
		new Comparator<Integer>(){  
			public int compare(Integer i1,Integer i2){  
				return i2.compareTo(i1);  
			}  
		}
	);  
	  
	  
	treeSet.size();  
	treeSet.add()  
	treeSet.contains()  
	treeSet.remove(Object o) //Removes the element from this set if present.  
	  
	treeSet.clear();  
	treeSet.isEmpty();  
	  
	treeSet.first() // Returns the first element currently in this set.  
	treeSet.last()  
	  
	// Retrieves and removes the first element, or  
	// returns null if this set is empty  
	treeSet.pollFirst()  
	treeSet.pollLast()

---

### String Builder

	// Basic initialization  
	StringBuilder sb = new StringBuilder();  
	StringBuilder sb = new StringBuilder("Hello world"); // accept string  
	  
	sb.length()  
	sb.reverse();  
	sb.toString();  
	  
	// Add  
	sb.append('c'); // adding char  
	sb.append("Stirng") // adding string  
	sb.append(int num) // adding number, float  
	  
	sb.charAt(int index) // Returns the char value at that index  
	sb.setCharAt(index, 'a'); // set the char  
	sb.indexOf(String str) // return index or -1  
	sb.toString().equals(sbGoal.toString()); // equals  
	  
	//split  
	String str = sb.toString();  
	String strArr[] = str.split(":");  
	  
	//Int to String  
	int i=200;  
	String s=String.valueOf(i);  
	  
	// string to int  
	String s="200";  
	int value = Integer.parseInt(s);  
	  
	// Char array to string;  
	char ch_arr[] = {'H','e','l','l','o',' ','W','o','r','l','d','!'};  
	String str1 = new String(ch_arr);  
	System.out.println("String: "+ str1);  
	  
	// char array to string builder  
	char ch_arr[] = {'J','a','v','a',' ','P','r','o','g','r','a','m'};  
	StringBuilder sb_obj = new StringBuilder();  
	
	for(int i = 0; i < ch_arr.length; i++){  
		sb_obj.append(ch_arr[i]);  
	}  
	  
	  
	int[] frequency = new int[26];  
	for (char ch : s.toCharArray()) {  
		frequency[ch - 'a'] += 1;  
		if (frequency[ch - 'a'] == 2) {  
			return true;  
		}  
	}



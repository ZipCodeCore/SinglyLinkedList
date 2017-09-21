# Data structures

Fork this repository and submit your code via pull request.

## Linked List


### Requirements

Implement a singly linked list:

- You may not use the `LinkedList` or `ArrayList` class or any other predefined Java collections
- Your linked list must have a node inner class to represent each element
- Your linked list must have add, remove, contains, find, size, get, copy and sort methods
- Method definitions:
	- add -- add an element to the list
	- remove -- remove an element (specified by numeric index) from the list
	- contains -- returns true if the element is in the list, false otherwise
	- find -- returns the element's index if it is in the list, -1 otherwise
	- size -- returns the current size of the list
	- get -- returns the element at the specified index
	- copy -- returns a new linked list containing the same values (look up deep versus shallow copy)
	- sort -- sorts the list using your algorithm of choice. You must perform the sorting yourself (no fair using someone else's library)


### Optional features

- implement your linked list as a generic class that can store any type of object
- Add a reverse method
- Add a slice method that returns a copy of a subset of the element of the list (eg slice(2,8) returns a new linked list containing elements #2,3,4,5,6,7 -- but not 8)

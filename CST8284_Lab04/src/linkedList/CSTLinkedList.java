package linkedList;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class CSTLinkedList<R> implements CSTList<R> {

	private Node<R> head;
	private Node<R> tail;
	private int size;

	public CSTLinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	public CSTLinkedList(List<R> list) {
		for (R node : list)
			addLast(node);
	}

	private Node<R> getNodeBefore(int index) {
		isIndexValid(index);
		Node<R> prevNode = head;
		for (int i = 0; i < (index - 1); i++) {
			prevNode = prevNode.next;
		}
		return prevNode;
	}

	private void isIndexValid(int index) {
		if (index < 0 || index > size)
			throw new IllegalArgumentException("Invalid input index");
	}

	public String toString() {
		String result = "";
		for (int i = 0; i < size; i++) {

			result += "index = " + i + " element = " + this.get(i).toString() + "\n";
		}
		return result;
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int choice = 1;
		CSTLinkedList<Integer> cst = new CSTLinkedList<Integer>();
		while (choice != 0) {
			System.out.print("Please select one of the following:\r\n" + "1: Add at the First position\r\n"
					+ "2: Add at the Last position\r\n" + "3: Add at a specific position\r\n"
					+ "4: remove first element\r\n" + "5: remove last element\r\n"
					+ "6: remove an element at specific position\r\n" + "7: Print elements\r\n" + "0: To Exit\r\n"
					+ "> ");

			choice = scan.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter an integer value");
				cst.addFirst(scan.nextInt());
				break;
			case 2:
				System.out.println("Enter an integer to add");
				cst.addLast(scan.nextInt());
				break;
			case 3:
				System.out.println("Enter an integer to add");
				int value = scan.nextInt();
				System.out.println("Enter the position you want to add to");
				int position = scan.nextInt();
				cst.insert(value, position);
				break;
			case 4:
				cst.removeFirst();
				break;
			case 5:
				cst.removeLast();
				break;
			case 6:
				System.out.println("Enter the position of the element you want to delete");
				cst.remove(scan.nextInt());
				break;
			case 7:
				System.out.println(cst.toString());
				break;
			case 0:
				System.out.println("Exiting.....");
				break;
			default:
				System.out.println("Invalid choice");
				break;
			}
		}

	}

	public class Node<T> {
		private Node<T> next;
		private T element;

		private Node(T t) {
			this.next = null;
			this.element = t;
		}

		private Node(T t, Node<T> next) {
			this.element = t;
			this.next = next;
		}

		public int hashCode() {
			int hash = 7;
			hash = 31 * hash + (int) element;
			return hash;
		}

		public String toString() {
			return this.element.toString();
		}

		public boolean equals(Object obj) {
			if (obj == null || getClass() != obj.getClass())
				return false;

			if (obj == this)
				return true;

			@SuppressWarnings("unchecked")
			Node<T> node = (Node<T>) obj;

			return Objects.equals(this.element, node.element);
		}

	}

	@Override
	public void addFirst(R r) {
		Node<R> newNode = new Node<R>(r);
		if (isEmpty()) {
			head = newNode;
			tail = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
		size++;
	}

	@Override
	public void addLast(R r) {
		Node<R> newNode = new Node<R>(r);
		if (isEmpty()) {
			tail = newNode;
			head = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
		size++;
	}

	@Override
	public void insert(R r, int index) {
		isIndexValid(index);
		Node<R> newNode = new Node<R>(r);
		if (isEmpty()) {
			head = newNode;
			tail = newNode;
		} else if (index == 0) {
			addFirst(r);

			return;
		} else if (index == size) {
			addLast(r);
			return;
		} else {
			Node<R> temp = head;
			for (int i = 0; i < (index - 1); i++) {
				temp = temp.next;
			}
			newNode.next = temp.next;
			temp.next = newNode;

		}
		size++;
	}

	@Override
	public R removeFirst() {
		if (size == 0) {
			return null;
		}
		Node<R> temp = head;
		head = head.next;
		size--;
		return temp.element;
	}

	@Override
	public R removeLast() {
		if (head == null) {
			return null;
		}
		Node<R> t = tail;
		Node<R> temp = getNodeBefore(size - 1);
		tail = temp;
		tail.next = null;
		size--;
		return t.element;
	}

	@Override
	public R remove(int index) {

		isIndexValid(index);
		Node<R> i = null;
		if (index == 0) {
			return removeFirst();
		} else {
			Node<R> temp = this.getNodeBefore(index);
			i = temp.next;
			temp.next = temp.next.next;
			size--;
			return i.element;
		}
	}

	@Override
	public R getFirst() {
		if (head == null) {
			return null;
		}
		return head.element;
	}

	@Override
	public R getLast() {
		if (head == null) {
			return null;
		}
		return tail.element;
	}

	@Override
	public R get(int index) {

		isIndexValid(index);
		if (isEmpty()) {
			return null;
		}

		if (index >= size - 1) {
			return tail.element;
		}

		if (index == 0) {
			return head.element;
		}

		Node<R> n = head;
		for (int i = 0; n.next != null; i++) {
			if (i == index) {
				return n.element;
			}
			n = n.next;
		}
		return null;
	}

	@Override
	public boolean isEmpty() {
		return (size == 0);
	}

	@Override
	public int size() {

		return size;
	}

	@Override
	public void clear() {
		size = 0;
		head = null;
		tail = null;

	}

}

package stack;

public class My_Stack {
	private int size, top, stack[];

	public My_Stack() {
		size = 5;
		stack = new int[size];
		top = -1;
	}

	public My_Stack(int size) {
		this.size = size;
		stack = new int[size];
		top = -1;
	}

	public boolean push(int item) throws StackIsFullException {
		if (!isFull()) {
			top++;
			stack[top] = item;
			return true;
		} else {
			throw new StackIsFullException("stack is full");
		}
	}

	public int pop() throws StackIsEmptyException {
		if (!isEmpty()) {
			return stack[top--];
		} else {
			throw new StackIsEmptyException("Stack is empty");
		}
	}

	public boolean isFull() {
		return top == size - 1;
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public static void main(String[] args)   {
		My_Stack my_Stack = new My_Stack();
		int[] stack = { 1, 2, 3, 5, 4 };
		for (int i : stack) {
			try {
				my_Stack.push(i);
				//System.out.println();
			} catch (StackIsFullException e) {
				e.printStackTrace();
			}
		}
		try {
			System.out.println(my_Stack.pop());
			System.out.println(my_Stack.pop());
		}
		catch(StackIsEmptyException e) {
			e.printStackTrace();
		}
	}
}

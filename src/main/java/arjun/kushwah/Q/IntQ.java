package arjun.kushwah.Q;

public class IntQ {
	private int q[];
	private int rear;
	private int front;
	private int total;
	private int size;
	public IntQ(int size){
		this.size=size;
		q=new int[size];
		total=0;
		front=0;
		rear=0;
	}
	public boolean enque(int item) {
		if(!isFull()) {
			q[rear]=item;
			rear=(rear+1)%size;
			total++;
			return true;
		}
		else
			return false;
	}
	public boolean isFull() {
		return total==size;
	}
	public int deque() throws Exception {
		if(!isEmpty()) {
		int item=q[front];
		front=(front+1)%size;
		total--;
		return item;
		}
		else
		{
		 throw new Exception(" que is empty");
		}
		
	}
	public boolean isEmpty() {
		return total==0;
	}
	public int getFront() {
		return q[front];
	}
	public int getRear() {
		return q[rear];
	}
	public void showAll() {
		int f=front;
		if(isEmpty()) {
			System.out.println(" que is empty");
		}else {
		for(int i=0;i<total;i++) {
			System.out.println(" " +q[f]);
			f=(f+1)%size;
		}
		}
	}
	public static void main(String[] args) throws Exception {
		IntQ q=new IntQ(4);
		q.enque(1);
		q.enque(2);
		q.enque(3);
		q.enque(4);
		for(int i=q.total;i>0;i--) {
			System.out.println(q.deque());
		}
		q.enque(5);
		System.out.println(q.deque());
		q.showAll();
	}
}

package venya;
class Sup {
	void rose()
	{
		System.out.println("rose");
	}
}
class Sub extends Sup{
	void lilly()
	{
		System.out.println("lilly");
	}
public static void main(String[]args) {
	 Sub p =new Sub();p.rose();p.lilly();
	}
}

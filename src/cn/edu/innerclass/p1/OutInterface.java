package cn.edu.innerclass.p1;

public interface OutInterface {
	void say();
	static class InterClass extends TT  implements OutInterface{
		@Override
		public void say() {
			System.out.println("OutInterface   InterClass  ,....");
		}
		{
			class aa{
				public aa(int a){}
			}
		}
	}
}
class TT{
	public static void main(String[] args) {
		new OutInterface.InterClass().say();
	}

	public void say() {
		int a = 0;
		class b{
			void a(){
			}
		}
	}
}
abstract class ty{
	public ty(int a,int b){}
	abstract void h();
}

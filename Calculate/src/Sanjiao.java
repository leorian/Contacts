
public class Sanjiao {
	private double a = 0;
	private double b = 0;
	private int du ;
	public Sanjiao(double a, int du) {
		super();
		if(du==0) {
			this.a = a;
			this.b = (a/180.0)*(Math.PI);
		}
		if(du==1) {
			this.b = a;
			this.a = (b*180)/Math.PI;
		}
	}
	public double getA() {
		return a;
	}
	public double getAs() {
		if(a<0) {
			return Math.abs(a)+180;
		}
		return a;
	}
	public double getAc() {
		return Math.abs(a);
	}
	public double getAt() {
		if(a<0) {
			return Math.abs(a)+180;
		}
		return a;
	}
	public void setA(double a) {
		this.a = a;
	}
	public double getB() {
		return b;
	}
	public void setB(double b) {
		this.b = b;
	}
	public int getDu() {
		return du;
	}
	public void setDu(int du) {
		this.du = du;
	}
	
}

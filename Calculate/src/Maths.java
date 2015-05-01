
public class Maths {

	public static double sinh(Sanjiao sj) {
		if(sj.getAs()%360==0) {//特殊值
			return 0;
		}else if(sj.getAs()%360==30){
			return 0.5;
		}else if(sj.getAs()%360==90){
			return 1;
		}else if(sj.getAs()%360==150){
			return 0.5;
		}else if(sj.getAs()%360==180){
			return 0;
		}else if(sj.getAs()%360==210){
			return -0.5;
		}else if(sj.getAs()%360==270){
			return -1;
		}else if(sj.getAs()%360==330){
			return -0.5;
		}else {
			return Math.sin(sj.getB());
		}
	}
	
	public static double sech(Sanjiao sj) {
		if(sj.getAs()%360==0) {//特殊值
			return 0;
		}else if(sj.getAs()%360==180){
			return 0;
		}else {
			return 1/sinh(sj);
		}
	}
	
	public static double cosh(Sanjiao sj) {
		if(sj.getAc()%360==0) {
			return 1;
		}else if(sj.getAc()%360==60){
			return 0.5;
		}else if(sj.getAc()%360==90){
			return 0;
		}else if(sj.getAc()%360==120){
			return -0.5;
		}else if(sj.getAc()%360==180){
			return -1;
		}else if(sj.getAc()%360==240){
			return -0.5;
		}else if(sj.getAc()%360==270){
			return 0;
		}else if(sj.getAc()%360==300){
			return 0.5;
		}else {
			return Math.cos(sj.getB());
		}
	}
	
	public static double csch(Sanjiao sj) {
		if(sj.getAc()%360==90){
			return 0;
		}else if(sj.getAc()%360==270){
			return 0;
		}else {
			return 1/cosh(sj);
		}
	}
	
	public static double tanh(Sanjiao sj) {
		if(sj.getAt()%180==0) {
			return 0;
		}else if(sj.getAt()%180==45){
			return 1;
		}else if(sj.getAt()%180==135){
			return -1;
		}else {
			return Math.tan(sj.getB());
		}
	}
	
	public static double coth(Sanjiao sj) {
		if(sj.getAt()%180==0) {
			return 0;
		}else {
			return 1/tanh(sj);
		}
	}
	
	public static double jiecheng(int n) {
		double result = 1;
		
		for(int i=1;i<=n;i++) {
			result *= i;
		}
		return result;
	}
	
	public static double A(int a,int b) {
		double result = jiecheng(a)/jiecheng(a-b);
		return result;
	}
	
	public static double C(int a,int b) {
		double result = A(a,b)/jiecheng(b);
		return result;
	}
}

import java.util.Stack;

public class JinzhiUtil {
	public static double toshi(String s,int jz) {
		//将其它进制转换为十进制表示
		int c = 0;
		if (s.startsWith("-")) {
			c = 1;
			s = s.substring(1, s.length());
		}
		String[] ss = s.split("\\.");//以“.”作为分隔符将字符创分割为字符串数组
		if(ss.length==2) {
			//判断该数是否包含小数部分
			s = ss[0]+ss[1];
		} else {
			s = ss[0];
		}
		double a = 0;
		for(int i=0;i<s.length();i++) {
			String b = s.substring(i,i+1);
			if ("A".equals(b)) {
				b = "10";
			} else if("B".equals(b)){
				b = "11";
			} else if("C".equals(b)){
				b = "12";
			} else if("D".equals(b)){
				b = "13";
			} else if("E".equals(b)){
				b = "14";
			} else if("F".equals(b)){
				b = "15";
			}
			a = a +Integer.parseInt(b)*(Math.pow(jz,ss[0].length()-1-i));
		}
		if(c==1) {
			a = -a;
		}
		return a;
	}
	
	public String fromshiInt(long a,int jz) {
		//十进制整数部分转换为其它进制
		Stack<String> stack = new Stack<String>();//使用stack作为临时存储结构
		while(a>0) {
			long b = a%jz;
			String s = "";
			if(b==10) {
				s = "A";
			} else if (b==11) {
				s = "B";
			} else if (b==12) {
				s = "C";
			} else if (b==13) {
				s = "D";
			} else if (b==14) {
				s = "E";
			} else if (b==15) {
				s = "F";
			} else {
				s = Long.toString(b);
			}
			stack.push(s);
			a = a/jz;
		}
		String str = "";
		while(!stack.isEmpty()) {
			str += stack.pop();
		}
		return str;
	}
	
	public String fromshiFloat(double a,int jz) {
		//将十进制小数转换为其它进制
		String str = "";
		int i = 0;
		while(a!=0 && i<10) {
			//最长10位，防止无限循环
			a = a*jz;
			int b = (int)a;
			if(b==10) {
				str += "A";
			} else if (b==11) {
				str += "B";
			} else if (b==12) {
				str += "C";
			} else if (b==13) {
				str += "D";
			} else if (b==14) {
				str += "E";
			} else if (b==15) {
				str += "F";
			} else {
				str += Integer.toString(b);
			}
			a = a-b;
			i ++;
		}
		return str;
	}
	
	public static String fromshi(double a,int jz) {
		//十进制转换为其它进制表示
		String str = "";
		if(a<0) {
			a = -a;
			str = "-";
		}
		long b = (long)a;
		a = a - b;
		if("".equals(new JinzhiUtil().fromshiFloat(a, jz))) {
			return str += new JinzhiUtil().fromshiInt(b, jz);
		}else {
			return str += new JinzhiUtil().fromshiInt(b, jz)+"."+new JinzhiUtil().fromshiFloat(a, jz);
		}
	}
}

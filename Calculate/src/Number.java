
public class Number {

	private Double num;
	private String shi;
	private String er;
	private String ba;
	private String shiliu;
	
	public static void main(String[] args) {
		System.out.println(new Number(23422.0));
	}
	public Number(Double num) {
		super();
		this.num = num;
		shi = strdian(Double.toString(num));
		er = strdian(JinzhiUtil.fromshi(num, 2));
		ba = strdian(JinzhiUtil.fromshi(num, 8));
		shiliu = strdian(JinzhiUtil.fromshi(num, 16));
		
	}
	
	public String strdian(String str) {
		String s = str;
		if(str.endsWith(".")) {
			s = str.substring(0, str.length()-1);
		}
		if(str.endsWith(".0")) {
			s = str.substring(0, str.length()-2);
		}
		return s;
	}
	public Double getNum() {
		return num;
	}
	public void setNum(Double num) {
		this.num = num;
	}
	public String getShi() {
		return shi;
	}
	public void setShi(String shi) {
		this.shi = shi;
	}
	public String getEr() {
		return er;
	}
	public void setEr(String er) {
		this.er = er;
	}
	public String getBa() {
		return ba;
	}
	public void setBa(String ba) {
		this.ba = ba;
	}
	public String getShiliu() {
		return shiliu;
	}
	public void setShiliu(String shiliu) {
		this.shiliu = shiliu;
	}
	@Override
	public String toString() {
		return "Number [num=" + num + ", shi=" + shi + ", er=" + er + ", ba="
				+ ba + ", shiliu=" + shiliu + "]";
	}
}

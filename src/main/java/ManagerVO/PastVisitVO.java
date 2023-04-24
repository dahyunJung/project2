package ManagerVO;
public class PastVisitVO {
	int vCnt, vCnt1, vCnt2, vCnt3, vCnt4;

	public PastVisitVO() {
	}

	public PastVisitVO(int vCnt4, int vCnt3, int vCnt2, int vCnt1, int vCnt) {
		this.vCnt = vCnt;
		this.vCnt1 = vCnt1;
		this.vCnt2 = vCnt2;
		this.vCnt3 = vCnt3;
		this.vCnt4 = vCnt4;
	}

	public int getvCnt() {
		return vCnt;
	}

	public void setvCnt(int vCnt) {
		this.vCnt = vCnt;
	}

	public int getvCnt1() {
		return vCnt1;
	}

	public void setvCnt1(int vCnt1) {
		this.vCnt1 = vCnt1;
	}

	public int getvCnt2() {
		return vCnt2;
	}

	public void setvCnt2(int vCnt2) {
		this.vCnt2 = vCnt2;
	}

	public int getvCnt3() {
		return vCnt3;
	}

	public void setvCnt3(int vCnt3) {
		this.vCnt3 = vCnt3;
	}

	public int getvCnt4() {
		return vCnt4;
	}

	public void setvCnt4(int vCnt4) {
		this.vCnt4 = vCnt4;
	}

	@Override
	public String toString() {
		return "PastVisitVO [vCnt=" + vCnt + ", vCnt1=" + vCnt1 + ", vCnt2=" + vCnt2 + ", vCnt3=" + vCnt3 + ", vCnt4="
				+ vCnt4 + "]";
	}
	
	
	

}

package ManagerVO;
public class PastJoinVO {
	int sCnt, sCnt1, sCnt2, sCnt3, sCnt4;

	public PastJoinVO() {
	}

	public PastJoinVO(int sCnt4, int sCnt3, int sCnt2, int sCnt1, int sCnt) {
		this.sCnt = sCnt;
		this.sCnt1 = sCnt1;
		this.sCnt2 = sCnt2;
		this.sCnt3 = sCnt3;
		this.sCnt4 = sCnt4;
	}

	public int getsCnt() {
		return sCnt;
	}

	public void setsCnt(int sCnt) {
		this.sCnt = sCnt;
	}

	public int getsCnt1() {
		return sCnt1;
	}

	public void setsCnt1(int sCnt1) {
		this.sCnt1 = sCnt1;
	}

	public int getsCnt2() {
		return sCnt2;
	}

	public void setsCnt2(int sCnt2) {
		this.sCnt2 = sCnt2;
	}

	public int getsCnt3() {
		return sCnt3;
	}

	public void setsCnt3(int sCnt3) {
		this.sCnt3 = sCnt3;
	}

	public int getsCnt4() {
		return sCnt4;
	}

	public void setsCnt4(int sCnt4) {
		this.sCnt4 = sCnt4;
	}

	@Override
	public String toString() {
		return "PastJoinVO [sCnt=" + sCnt + ", sCnt1=" + sCnt1 + ", sCnt2=" + sCnt2 + ", sCnt3=" + sCnt3 + ", sCnt4="
				+ sCnt4 + "]";
	}

	

	

}

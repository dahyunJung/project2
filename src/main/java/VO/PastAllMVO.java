package VO;

public class PastAllMVO {
int allMCNT, allMCNT1, allMCNT2, allMCNT3, allMCNT4;

public PastAllMVO() {
}

public PastAllMVO(int allMCNT4, int allMCNT3, int allMCNT2, int allMCNT1, int allMCNT) {
	this.allMCNT = allMCNT;
	this.allMCNT1 = allMCNT1;
	this.allMCNT2 = allMCNT2;
	this.allMCNT3 = allMCNT3;
	this.allMCNT4 = allMCNT4;
}

public int getAllMCNT() {
	return allMCNT;
}

public void setAllMCNT(int allMCNT) {
	this.allMCNT = allMCNT;
}

public int getAllMCNT1() {
	return allMCNT1;
}

public void setAllMCNT1(int allMCNT1) {
	this.allMCNT1 = allMCNT1;
}

public int getAllMCNT2() {
	return allMCNT2;
}

public void setAllMCNT2(int allMCNT2) {
	this.allMCNT2 = allMCNT2;
}

public int getAllMCNT3() {
	return allMCNT3;
}

public void setAllMCNT3(int allMCNT3) {
	this.allMCNT3 = allMCNT3;
}

public int getAllMCNT4() {
	return allMCNT4;
}

public void setAllMCNT4(int allMCNT4) {
	this.allMCNT4 = allMCNT4;
}

@Override
public String toString() {
	return "pastAllMVO [allMCNT=" + allMCNT + ", allMCNT1=" + allMCNT1 + ", allMCNT2=" + allMCNT2 + ", allMCNT3="
			+ allMCNT3 + ", allMCNT4=" + allMCNT4 + "]";
}


	

}

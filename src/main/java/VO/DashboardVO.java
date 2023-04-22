package VO;

public class DashboardVO {
	private int memberCnt, novelCnt, todaySignUpCnt, todayVisitCnt, todayCreateNovelCnt, todayCreateEpCnt;

	public DashboardVO() {
	}

	public DashboardVO(int memberCnt, int novelCnt, int todaySignUpCnt, int todayVisitCnt, int todayCreateNovelCnt,
			int todayCreateEpCnt) {
		this.memberCnt = memberCnt;
		this.novelCnt = novelCnt;
		this.todaySignUpCnt = todaySignUpCnt;
		this.todayVisitCnt = todayVisitCnt;
		this.todayCreateNovelCnt = todayCreateNovelCnt;
		this.todayCreateEpCnt = todayCreateEpCnt;
	}

	public int getMemberCnt() {
		return memberCnt;
	}

	public void setMemberCnt(int memberCnt) {
		this.memberCnt = memberCnt;
	}

	public int getNovelCnt() {
		return novelCnt;
	}

	public void setNovelCnt(int novelCnt) {
		this.novelCnt = novelCnt;
	}

	public int getTodaySignUpCnt() {
		return todaySignUpCnt;
	}

	public void setTodaySignUpCnt(int todaySignUpCnt) {
		this.todaySignUpCnt = todaySignUpCnt;
	}

	public int getTodayVisitCnt() {
		return todayVisitCnt;
	}

	public void setTodayVisitCnt(int todayVisitCnt) {
		this.todayVisitCnt = todayVisitCnt;
	}

	public int getTodayCreateNovelCnt() {
		return todayCreateNovelCnt;
	}

	public void setTodayCreateNovelCnt(int todayCreateNovelCnt) {
		this.todayCreateNovelCnt = todayCreateNovelCnt;
	}

	public int getTodayCreateEpCnt() {
		return todayCreateEpCnt;
	}

	public void setTodayCreateEpCnt(int todayCreateEpCnt) {
		this.todayCreateEpCnt = todayCreateEpCnt;
	}

	@Override
	public String toString() {
		return "DashboardVO [memberCnt=" + memberCnt + ", novelCnt=" + novelCnt + ", todaySignUpCnt=" + todaySignUpCnt
				+ ", todayVisitCnt=" + todayVisitCnt + ", todayCreateNovelCnt=" + todayCreateNovelCnt
				+ ", todayCreateEpCnt=" + todayCreateEpCnt + "]";
	}
	
	
	
}

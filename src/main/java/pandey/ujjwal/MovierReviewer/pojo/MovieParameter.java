package pandey.ujjwal.MovierReviewer.pojo;

public class MovieParameter {
	private int page = 0;
	private int next = 12;

	public MovieParameter(int page, int next) {
		super();
		this.page = page;
		this.next = next;
	}

	public MovieParameter() {
		super();
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getNext() {
		return next;
	}

	public void setNext(int next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "\nMovieParameter [page=" + page + ", next=" + next + "]";
	}

}

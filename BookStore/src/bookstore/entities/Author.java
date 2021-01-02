package bookstore.entities;

/**
 *
 * @author Nguyen Xuan Vinh
 */
public class Author {
    private String tenGiaGia, ghiChu;
    private Integer maTacGia;
	
    public Author(Integer maTacGia, String tenGiaGia, String ghiChu) {
		super();
		this.tenGiaGia = tenGiaGia;
		this.ghiChu = ghiChu;
		this.maTacGia = maTacGia;
	}

	public String getTenGiaGia() {
		return tenGiaGia;
	}

	public void setTenGiaGia(String tenGiaGia) {
		this.tenGiaGia = tenGiaGia;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public Integer getMaTacGia() {
		return maTacGia;
	}

	public void setMaTacGia(Integer maTacGia) {
		this.maTacGia = maTacGia;
	}
}

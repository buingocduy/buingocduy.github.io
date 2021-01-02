package bookstore.entities;

/**
 *
 * @author Nguyen Xuan Vinh
 */
public class Publisher {
	private String tenNXB, diaChi, email, nguoiLienHe;
    private Integer maNXB;
    
	public Publisher(Integer maNXB, String tenNXB, String diaChi, String email, String nguoiLienHe) {
		super();
		this.tenNXB = tenNXB;
		this.diaChi = diaChi;
		this.email = email;
		this.nguoiLienHe = nguoiLienHe;
		this.maNXB = maNXB;
	}

	public String getTenNXB() {
		return tenNXB;
	}

	public void setTenNXB(String tenNXB) {
		this.tenNXB = tenNXB;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNguoiLienHe() {
		return nguoiLienHe;
	}

	public void setNguoiLienHe(String nguoiLienHe) {
		this.nguoiLienHe = nguoiLienHe;
	}

	public Integer getMaNXB() {
		return maNXB;
	}

	public void setMaNXB(Integer maNXB) {
		this.maNXB = maNXB;
	}
    
    
}

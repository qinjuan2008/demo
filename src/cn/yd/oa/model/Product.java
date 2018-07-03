package cn.yd.oa.model;

import java.util.Date;

//��->��,����->��¼,����->�ֶ�
public class Product {
	private Integer id=null;//����д��
//	private int num=0;//ȱʡ��0������д��
	private String name;
	private Double price;
	private String remark;
	private Date date;
	
	
	public Product() {
		super();
	}

	public Product(Integer id, String name, Double price, String remark) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", remark=" + remark + ", date=" + date
				+ "]";
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public Product(String name, Double price, String remark) {
		this.name = name;
		this.price = price;
		this.remark = remark;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	
	
}

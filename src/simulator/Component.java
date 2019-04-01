package simulator;

public abstract class Component {
	private String name;
	private String lif;
	private String tii;
	private String tdi;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLif() {
		return lif;
	}
	public void setLif(String lif) {
		this.lif = lif;
	}
	public String getTii() {
		return tii;
	}
	public void setTii(String tii) {
		this.tii = tii;
	}
	public String getTdi() {
		return tdi;
	}
	public void setTdi(String tdi) {
		this.tdi = tdi;
	}
//	public String LIFInfo() {
//		//提供组件功能属性时间属性、本地接口的语义描述
//		return 
//	}
	
}

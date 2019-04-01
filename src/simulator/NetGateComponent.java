package simulator;

import java.util.Scanner;

//网关组件
public class NetGateComponent extends Component{
	private String localInterface;
	private int info;
	//private String result;
	public String getLocalInterface() {
		return localInterface;
	}
	public void setLocalInterface(String localInterface) {
		this.localInterface = localInterface;
	}
	public int getInfo() {
		return info;
	}
	public void setInfo(int info) {		
		this.info = info;
	}
	public void InputInfo() {
		System.out.println("输入此时的锅炉温度：");
		setInfo(new Scanner(System.in).nextInt());		
	}
	public void OutputInfo(String result) {
		System.out.println("此时的温度状态为"+result);
	}

}

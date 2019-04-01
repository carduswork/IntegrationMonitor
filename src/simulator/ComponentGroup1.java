package simulator;

import java.lang.reflect.Method;
import java.util.List;

public class ComponentGroup1 extends ComponentGroup {
	private String state;
	private int currenttemp;
	public ComponentGroup1(List<Component> g) {
		super(g);
	}

	@Override
	public void AddComponent(Component c) {
		// TODO Auto-generated method stub
		GroupMember.add(c);
	}

	//接收消息,调度处理，反射的参数类型应该也改成从lif读取
	public String exec(int param,Component cnext) throws Exception{
		//存储当前温度
		currenttemp=param;
		Class componentclass=cnext.getClass();
		Method method=componentclass.getMethod(cnext.getLif(), int.class);
		Object result=method.invoke(cnext, param);
		//存储状态
		state=result.toString();
		return state;
	}
	//回显
	public void replay(Component cnext,String param) throws Exception{
		Class componentclass=cnext.getClass();
		Method method=componentclass.getMethod("OutputInfo", String.class);
		Object result=method.invoke(cnext, param);
		
	}
	//执行冷却检查
	public void checktempbytime(Component checker,Component computer) throws Exception{		
		Class componentclass=checker.getClass();
		Method method=componentclass.getMethod(checker.getLif(), String.class,int.class);
		Object result=method.invoke(checker,state,currenttemp);
		//存储降温后的温度
		currenttemp=Integer.parseInt(result.toString());
		//再传递新的温度，设置新状态
		exec(currenttemp, computer);
		//执行完毕后回显状态
		System.out.println("经过了冷却处理，此时系统的温度状态是："+state+"当前温度"+currenttemp);
	}
}

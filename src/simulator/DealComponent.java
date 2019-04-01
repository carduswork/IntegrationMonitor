package simulator;

import java.lang.reflect.Method;

//处理温度异常的组件
public class DealComponent extends Component {
	
	public int checkstate(String state,int currenttemp){
		//
		if(state.equals("过热")) 
			return currenttemp-1;
		return currenttemp;
	}
}

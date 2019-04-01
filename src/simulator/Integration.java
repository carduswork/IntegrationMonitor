package simulator;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Integration {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		// 先进行组件与组件的集成。创建3个组件
		List<Component> memebertoadd = new ArrayList<>();
		ComputeComponent c1 = new ComputeComponent();
		c1.setName("普通组件1");
		//指定处理函数名及参数
		c1.setLif("Compare");
		
		NetGateComponent c2 = new NetGateComponent();
		c2.setName("网关组件1");
		c2.setLif("");
		c2.setLocalInterface("");
		
		DealComponent c3 = new DealComponent();
		c3.setName("普通组件2");
		c3.setLif("checkstate");
		memebertoadd.add(c1);

		// 新建一个空的集群
		ComponentGroup1 componentGroup1 = new ComponentGroup1(memebertoadd);
		componentGroup1.AddComponent(c2);
		componentGroup1.AddComponent(c3);
		
		componentGroup1.setLocalInterface(c2.getLocalInterface());
		componentGroup1.setLif(c2.getLif());
		
		//消息传递,inputinfo可以与setter整合一下
		c2.InputInfo();		
		componentGroup1.replay(c2,componentGroup1.exec(c2.getInfo(),c1));
		//时域控制
		Timer timer=new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				try {
					componentGroup1.checktempbytime(c3,c1);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
			}
		}, 0,1000);
		
		
	}

}

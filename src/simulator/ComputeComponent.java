package simulator;

//封闭组件
public class ComputeComponent extends Component {
	private static int state = 0;

	public String Compare(int temperature) {
		if (temperature > 100) {
			state = 1;
			return "过热";
		} else {
			state = 0;
			return "安全";
		}
	}
}

package simulator;

import java.util.ArrayList;
import java.util.List;

public abstract class ComponentGroup {
	public List<Component> GroupMember;
	public String localInterface;
	public String lif;
	
	public  ComponentGroup(List<Component> g) {GroupMember=g;};
	abstract public void AddComponent(Component c);
	public String getLocalInterface() {
		return localInterface;
	}
	public void setLocalInterface(String localInterface) {
		this.localInterface = localInterface;
	}
	public String getLif() {
		return lif;
	}
	public void setLif(String lif) {
		this.lif = lif;
	}
	
}

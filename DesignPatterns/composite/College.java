package composite;

import composite.OrganizationComponent;

import java.util.ArrayList;
import java.util.List;

public class College extends OrganizationComponent {

	//List 管理 Department
	List<OrganizationComponent> organizationComponents = new ArrayList<OrganizationComponent>();

	public College(String name, String des) {
		super(name, des);
		// TODO Auto-generated constructor stub
	}

	// add
	@Override
	protected void add(OrganizationComponent organizationComponent) {
		// TODO Auto-generated method stub
		//  将来实际业务中，Colleage 的add 和University add 不一定完全一样
		organizationComponents.add(organizationComponent);
	}

	// remove
	@Override
	protected void remove(OrganizationComponent organizationComponent) {
		// TODO Auto-generated method stub
		organizationComponents.remove(organizationComponent);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return super.getName();
	}

	@Override
	public String getDes() {
		// TODO Auto-generated method stub
		return super.getDes();
	}

	// print�������������University ������ѧԺ
	@Override
	protected void print() {
		// TODO Auto-generated method stub
		System.out.println("--------------" + getName() + "--------------");
		// organizationComponents
		for (OrganizationComponent organizationComponent : organizationComponents) {
			organizationComponent.print();
		}
	}


}

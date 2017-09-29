package reflectasmsample;

import com.esotericsoftware.reflectasm.FieldAccess;
import com.esotericsoftware.reflectasm.MethodAccess;

public class ReflectObject {

	public String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static void main(String[] args) {

		//Method reflection with ReflectASM
		ReflectObject reflectObject = new ReflectObject();
		MethodAccess mAccess = MethodAccess.get(ReflectObject.class);
		mAccess.invoke(reflectObject, "setName", "Awesome McLovin");
		String name = (String) mAccess.invoke(reflectObject, "getName");
		
		System.out.println(name);
		
		//Field reflection with ReflectASM:
		
		FieldAccess fAccess = FieldAccess.get(ReflectObject.class);
		fAccess.set(reflectObject, "name", "Awesome McLovin - a");
		String fName = (String)fAccess.get(reflectObject, "name");
		
		System.out.println(fName);
		
		
		
	}
}

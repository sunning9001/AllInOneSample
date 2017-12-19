package sample.functionalinterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class People {
	private List<Person> persons = new ArrayList<Person>();

	public List<Person> getMaleList1(PersonInterface filter) {
		List<Person> res = new ArrayList<Person>();
		persons.forEach((Person person) -> {
			if (filter.test(person)) {// 调用 PersonInterface 的方法
				res.add(person);
			}
		});
		return res;
	}
	
	
	public List<Person> getMaleList2(Predicate<Person> filter) {
		List<Person> res = new ArrayList<Person>();
		persons.forEach((Person person) -> {
			if (filter.test(person)) {// 调用 PersonInterface 的方法
				res.add(person);
			}
		});
		return res;
	}
	
	public static void main(String[] args) {
		
		People p =new People();
		
		p.getMaleList1( person-> person.isMale());
		p.getMaleList2( person-> person.isMale());
	}
}

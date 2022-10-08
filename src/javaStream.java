import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.stream.*;

public class javaStream {
//@Test

	public void Regular() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Abhijeet");
		names.add("Don");
		names.add("Alekya");
		names.add("Adam");
		names.add("Ram");
		int count = 0;
		for (int i = 0; i < names.size(); i++) {
			String actual = names.get(i);
			if (actual.startsWith("A")) {
				count++;
			}
			
		}
		System.out.println(count);
	}

//@Test
public void Stream() {
	ArrayList<String> names = new ArrayList<String>();
	names.add("Abhijeet");
	names.add("Don");
	names.add("Alekya");
	names.add("Adam");
	names.add("Ram");
	Long c=names.stream().filter(s->s.startsWith("A")).count();
	System.out.println(c);
}
//@Test
public void Stream1() {
	long d=Stream.of("Abhijeet","Don","Alekya","Adam","Ram").filter(s->s.startsWith("A")).count();
	
	System.out.println(d);
}
//@Test
public void Stream2() {
	long e=Stream.of("Abhijeet","Don","Alekya","Adam","Ram").filter(s->
	{
	s.startsWith("A");
	return false;
	//two statements,m deliberately giving false,so that it does not execute
	}).count();

	System.out.println(e);
	//o/p:0
}
//@Test
//print names that are greater than 4 in length
public void Stream3() {
	//Stream.of("Abhijeet","Don","Alekya","Adam","Ram").filter(s->s.length()>4).forEach(s->System.out.println(s));
	Stream.of("Abhijeet","Don","Alekya","Adam","Ram").filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));
	
	
}
//@Test
public void Stream4() {
	//Stream.of("Abhijeet","Don","Alekya","Adam","Ram").filter(s->s.length()>4).forEach(s->System.out.println(s));
	Stream.of("Abhijeet","Don","Alekya","Adam","Rama").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
	
	
}
//@Test
public void Stream5() {
	//print names with first letter as "a" with upperCase and sorted way
	List<String> names=Arrays.asList("Abhijeet","Don","Alekya","Adam","Rama");
	names.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
}
//@Test
public void Stream6() {
	ArrayList<String> names = new ArrayList<String>();
	names.add("man");
	names.add("bon");
	names.add("Women");
	
	//print names with first letter as "a" with upperCase and sorted way
	List<String> names1=Arrays.asList("Abhijeet","Don","Alekya","Adam","Rama");
	//names.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
	Stream<String> newStream=Stream.concat(names.stream(),names1.stream());
	boolean flag=newStream.anyMatch(s->s.equalsIgnoreCase("Adam"));
	System.out.println(flag);
	Assert.assertTrue(flag);
	
	
}
//@Test
public void Stream8() {
	//Stream.of("Abhijeet","Don","Alekya","Adam","Ram").filter(s->s.length()>4).forEach(s->System.out.println(s));
	List<String>ls=Stream.of("Abhijeet","Don","Alekya","Adam","Rama").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).collect(Collectors.toList());
	System.out.println(ls.get(0));
	
	
}
//@Test
public void stream9()
{
	List<Integer> values= Arrays.asList(3,2,2,7,5,1,9,7);
	values.stream().distinct().sorted().forEach(s->System.out.println(s));
}
@Test
public void stream10()
{
	List<Integer> values= Arrays.asList(3,2,2,7,5,1,9,7);
	List<Integer>li =values.stream().distinct().sorted().collect(Collectors.toList());
	System.out.println(li.get(3));
	
}

}



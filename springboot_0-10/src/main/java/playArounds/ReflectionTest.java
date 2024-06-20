package playArounds;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.function.Predicate;

import com.learining.springboot.model.Person;

public class ReflectionTest {
	public static void main(String[] args) {
		reflection();
	}

	public static void reflection() {
		System.out.println("Person.class.getCanonicalName() :: " + Person.class.getCanonicalName());
//		Person.class.getCanonicalName() :: com.learining.springboot.model.Person
		try {
			System.out.println(
					"constructor new instance :: " + Person.class.getConstructors()[0].newInstance("name", 41));
//			constructor new instance :: Person [name=name, age=41]
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| SecurityException e) {
			e.printStackTrace();
		}
		System.out.println("class loader :: " + Person.class.getClassLoader());
//		class loader :: jdk.internal.loader.ClassLoaders$AppClassLoader@76ed5528

		System.out.println("declared methods :: ");
		Arrays.stream(Person.class.getDeclaredMethods()).forEach(System.out::println);
//		declared methods :: 
//			public java.lang.String com.learining.springboot.model.Person.getName()
//			public boolean com.learining.springboot.model.Person.equals(java.lang.Object)
//			public java.lang.String com.learining.springboot.model.Person.toString()
//			public int com.learining.springboot.model.Person.hashCode()
//			public void com.learining.springboot.model.Person.setName(java.lang.String)
//			public int com.learining.springboot.model.Person.getAge()
//			public void com.learining.springboot.model.Person.setAge(int)

		System.out.println("fields :: ");
		Arrays.stream(Person.class.getDeclaredFields()).forEach(System.out::println);
//		fields :: 
//			private java.lang.String com.learining.springboot.model.Person.name
//			private int com.learining.springboot.model.Person.age

		System.out.println("primitive? " + Person.class.isPrimitive());

		System.out.println("int isPrimitive? " + int.class.isPrimitive()); // true
		System.out.println("Integer isPrimitive? " + Integer.class.isPrimitive());
		System.out.println("[] isPrimitive? " + String[].class.isPrimitive());

		var p = new Person("temp", 14);
		System.out.println(p.getClass().getSuperclass()); // class java.lang.Object

		var p1 = 5;

//		lambda expression returned instance returns true for Class.isSynthetic()
		Predicate<Integer> pred = a -> a < 20;
		System.out.println("local class? " + pred.getClass().isLocalClass());
		System.out.println("member class? " + pred.getClass().isMemberClass());
		System.out.println("interface? " + pred.getClass().isInterface());
		System.out.println("isAnonymousClass? " + pred.getClass().isAnonymousClass());
		System.out.println("isEnum? " + pred.getClass().isEnum());
		System.out.println("isRecord? " + pred.getClass().isRecord());
		System.out.println("isSealed? " + pred.getClass().isSealed());
		System.out.println("isSynthetic? " + pred.getClass().isSynthetic()); // true
	}
}

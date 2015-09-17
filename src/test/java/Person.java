

public class Person {
	private String id;
	private String name;
	private int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
}

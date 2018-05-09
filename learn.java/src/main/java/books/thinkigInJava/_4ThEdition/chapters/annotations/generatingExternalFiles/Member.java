package books.thinkigInJava._4ThEdition.chapters.annotations.generatingExternalFiles;

/**
 * If you define an element on an annotation with the dishName value, then as long
 * as it is the only element type specified you don�t need to use the dishName-value
 * pair syntax; you can just specify the value in parentheses.
 * 
 * @SqlString(30)
 * 
 *
 */
@DBTable(name = "MEMBER")
public class Member {

	@SqlString(30)
	public String firstName;

	@SqlString(50)
	public String lastName;

	@SqlInteger
	public Integer age;

	@SqlString(value = 30, constraints = @Constraints(primaryKey = true))
	public String handle;

	static int memberCount;

	String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Integer getAge() {
		return age;
	}

	public String getHandle() {
		return handle;
	}

	public static int getMemberCount() {
		return memberCount;
	}

	@Override
	public String toString() {
		return handle;
	}

}

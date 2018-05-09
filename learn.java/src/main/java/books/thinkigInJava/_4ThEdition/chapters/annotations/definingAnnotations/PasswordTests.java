package books.thinkigInJava._4ThEdition.chapters.annotations.definingAnnotations;

import java.util.List;

public class PasswordTests {

	@UseCase(id = 47, description = "Passowrd must contain at leat one numeric")
	boolean validatePass(String pass) {
		return (pass.matches("\\w*\\d\\w*"));
	}

	@UseCase(id = 48)
	String encryptePass(String pass) {
		return new StringBuilder(pass).reverse().toString();
	}

	@UseCase(id = 49, description = "New pass can't equal previosly used ones")
	boolean checkIfNewPass(List<String> passes, String newPass) {
		return !passes.contains(newPass);
	}
}

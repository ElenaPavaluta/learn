package chapters.c6_exceptions.usingATryStatement.throwingASecondException;

class Tricky {

	static String exceptions() {
		String result = "";
		String v = null;

		try {
			try {
				result += " before";  //result = before
				v.length();
				result += " after";
			} catch (NullPointerException e) {
				result +=  " catch"; // result = before catch
				throw new RuntimeException();
			} finally {
				result += " finally";  //result = before catch finally
				throw new Exception();
			}

		} catch (Exception e) {
			result += " done"; //result = before catch finally
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(exceptions());
	}
}

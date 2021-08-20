package week2.day2.assignments;

public class SumOfDigitsFromString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String text = "Tes12Le79af65";
		int sum = 0;

		String replaceAll = text.replaceAll("\\D", "");
		// System.out.println(replaceAll);
		char[] charArray = replaceAll.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			sum += Character.getNumericValue(charArray[i]);
		}
		System.out.println("Sum of Digits from String " + text + " is : " + sum);

	}

}

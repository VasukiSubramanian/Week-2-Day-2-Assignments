package week2.day2.assignments;

public class RemoveDuplicateStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String text = "We learn java basics as part of java sessions in java week1";
		// int count;
		String[] split = text.split(" ");
		for (int i = 0; i < split.length - 1; i++) {
			// count = 0;
			for (int j = i + 1; j < split.length; j++) {
				if (split[i].equalsIgnoreCase(split[j])) {
					// System.out.println(split[i]);
					split[j] = "";
					// break;
				}
			}

		}

		for (int i = 0; i < split.length; i++) {
			System.out.print(split[i] + " ");
		}

	}
}

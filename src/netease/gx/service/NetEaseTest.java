package netease.gx.service;

public class NetEaseTest {
	public static boolean isInt(int index) {
		if (index == 0) {
			return false;
		}
		String str = String.valueOf(index);
		return str.matches("[0-9]+$");
	}
	public static void main(String[] args) {
	System.out.println(isInt(2));
	System.out.print(Integer.parseInt(null));
	}
}

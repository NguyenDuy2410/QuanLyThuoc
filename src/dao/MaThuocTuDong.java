package dao;

import java.sql.Connection;

public class MaThuocTuDong {
	public static String fomatDPAA000000(String s) {
		int so = Integer.parseInt(s.substring(2));
		String stringSo = "000000";
		String ma1 = s.substring(0, 1);
		String ma2 = s.substring(1, 2);
		
		if (so >= 999999) {
			if (ma2.equalsIgnoreCase("Z")) {
				if (!ma1.equalsIgnoreCase("Z")) {
					char a  =(char) ((int) ma1.charAt(0)+1);
					ma1 = String.valueOf(a);
					ma2 ="A";			
				} else {
					System.err.println("Da toi gioi han ma");
					return null;
				}
			}else {
				// chua dat toi gioi han
				char a  =(char) ((int) ma2.charAt(0)+1);
				ma2 = String.valueOf(a);
			}
		}else {
			 stringSo = String.format("%06d", so + 1);
		}
		return (ma1 + ma2 + stringSo);
	}
	public static void main(String[] args) {
		Connection conn = connect.Connect.CreateConnection();
		String s = "AA999901";
		for (int i = 0; i < 1000; i++) {
			s = fomatDPAA000000(s);
			System.out.println(s);
		}
	}
}

package com.jp.string;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Locale;

public class EncryptionDecryption {

	static final int ALPHBETS_SIZE = 26;
	char alphabets[] = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
			'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
	char ercyptionArray[] = new char[ALPHBETS_SIZE];
	char decryptionArray[] = new char[ALPHBETS_SIZE];

	EncryptionDecryption() {

		for (int i = 0; i < ALPHBETS_SIZE; i++) {
			ercyptionArray[i] = alphabets[(i + 3) % ALPHBETS_SIZE];
		}
		for (int i = 0; i < ALPHBETS_SIZE; i++) {
			decryptionArray[ercyptionArray[i] - 'A'] = alphabets[i];
		}
	}

	public String enrcyptMessege(String message) {
		char[] ch = message.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			if (Character.isUpperCase(ch[i]))
			ch[i] = ercyptionArray[ch[i] - 'A'];
		}
		return new String(ch);
	}

	public String decryptMessege(String message) {
		char[] ch = message.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			if (Character.isUpperCase(ch[i]))
				ch[i] = decryptionArray[ch[i] - 'A'];
		}
		return new String(ch);
	}

	public static void main(String[] args) {
		EncryptionDecryption encDec = new EncryptionDecryption();
		System.out.println(encDec.ercyptionArray);
		System.out.println(encDec.decryptionArray);
        String message="Hello how are you";
        message = encDec.enrcyptMessege(message);
		System.out.println(message);
		message = encDec.decryptMessege(message);
		System.out.println(message);
		
		 Calendar calendar = Calendar.getInstance();
         calendar.set(2015,8-1,5);
         System.out.println(calendar.getTime());
         System.out.println(calendar.get(4));
         double payment=9.002;
         NumberFormat fr=NumberFormat.getCurrencyInstance(new Locale("en", "IN"));
         System.out.println(fr.format(payment));
         String s="";
         char c='A';
         System.out.println(s+c+c);
	}
	private static String getDayOfWeek(int value){
	    String day = "";
	    switch(value){
	    case 1:
	        day="SUNDAY";
	        break;
	    case 2:
	        day="MONDAY";
	        break;
	    case 3:
	        day="TUESDAY";
	        break;
	    case 4:
	        day="WEDNESDAY";
	        break;
	    case 5:
	        day="THURSDAY";
	        break;
	    case 6:
	        day="FRIDAY";
	        break;
	    case 7:
	        day="SATURDAY";
	        break;
	    }
	    return day;
	    }
}

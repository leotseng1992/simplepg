package com.xxx;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class TimeFormat {
	public static void main(String[] args) {

		private int ha = 3;
		private int haha = 3;
		
		String timeFormat = "^([0-9]{4}){1}(0[1-9]|1[0-2]){1}(0[1-9]|[1-2][0-9]|3[0-1]){1}$";
		System.out.println("請輸入日期(年月日,例如:20110131)");
		Scanner sc = new Scanner(System.in);
		String inputTime = sc.next();
		while(true) {
			if(inputTime.matches(timeFormat)){
				if(dateCheack(inputTime)){
					break;
				}else {
					System.out.println("輸入的日期不對,請重新輸入");
					inputTime = sc.next();
					continue;
				}
			}else {
			System.out.println("輸入的格式不對,請重新輸入");
			inputTime = sc.next();
			}
		}
		System.out.println("請輸入想設定的格式1.年/月/日  2.月/日/年  3.日/月/年");
		Scanner sc2 = new Scanner(System.in);
		int select = sc2.nextInt();
		while(true) {
			if(select>3) {
				System.out.println("沒有此選項");
				select = sc2.nextInt();
			}else{
				break;
			}
		}
		TimeFormat.formatOption(select, inputTime);
		sc.close();
		sc2.close();
	}
	public static void formatOption(int selectOption,String inputTime) {
		Date date =null;
		SimpleDateFormat sfm = new SimpleDateFormat("yyyyMMdd");
		String type =null;
		
		try {
			date = sfm.parse(inputTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		switch(selectOption) {
		case 1: type = "yyyy/MM/dd";
			break;
		case 2: type = "MM/dd/yyyy";
			break;
		case 3: type = "dd/MM/yyyy";
			break;
		}
		Format fm = new SimpleDateFormat(type);
		 System.out.println(fm.format(date));
	}
	public static boolean dateCheack(String inputTime) {
		int[] mdays = {31,28,31,30,31,30,31,31,30,31,30,31};
		int year =Integer.parseInt(inputTime.substring(0, 4));
		int month = Integer.parseInt(inputTime.substring(4, 6));
		int day = Integer.parseInt(inputTime.substring(6));
		GregorianCalendar gcd = new GregorianCalendar();
	
		if(gcd.isLeapYear(year)){
					mdays[1] = 29;
				}
	
		if(mdays[month-1] >= day) {
			return true;
		}
		return false;
	}

}

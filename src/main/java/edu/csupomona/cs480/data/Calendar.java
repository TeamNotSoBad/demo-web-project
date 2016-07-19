package edu.csupomona.cs480.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calendar {
	private boolean[][] calendar;

	public Calendar() {
		calendar = new boolean[7][48];
	}
	

	
	public void flipTime(int day, int time) {
		calendar[day][time] = !(calendar[day][time]);
	}

	/**
	 * [0 := 12 am] [1 := 1 am] [2 := 2 am] [3 := 3 am] [4 := 4 am] [5 := 5 am] [6 := 6 am] 
	 * [7:= 7 am] [8 := 8 am] [9 := 9 am] [10 := 10 am] [11 := 11 am] [12 := 12 pm] 
	 * [13 := 1pm] [14 := 2 pm] [15 := 3 pm] [16 := 4 pm] [17 := 5 pm] [18 := 6 pm] [19 := 7 pm] 
	 * [20:= 8 pm] [21 := 9 pm] [22 := 10 pm] [23 := 11 pm]
	 */
	public void flipTime(int day, double time) {
		flipTime(day, (int) (time * 2));
	}

	public ArrayList<Boolean> getTimesForDay(int day) {
		ArrayList<Boolean> d = new ArrayList<Boolean>();

		for (int i = 0; i < 48; i++) {
			d.add(calendar[day][i]);
		}

		return d;
	}
	
	public void setDay(int i, List<Boolean> list){
		if(list.size() == 48){
			for(int j = 0; j < 48; j++){
				calendar[i][j] = list.get(j);
			}
		}
	}
	
	public String toString() {
		String s = "Sun Mon Tue Wed Thu Fri Sat";
		
		s+= "\n";
		for (int i = 0; i < 48; i++) {
			String time = "";
			for (int j = 0; j < 7; j++) {
				s += "[";
				
				if (calendar[j][i]) {
					s += "X] ";
				} else{
					s += " ] ";
				}

			}
			time += ((i + 1)/2)	;
			if(i % 2 == 0){
				time += ":30";
			} else{
				time += ":00";
			}
			s += " "  + time + " \n";
		}
		return s;
	}
	
	private Calendar matches(Calendar c){
		Calendar matches = new Calendar();
		
		for(int i = 0; i < 7; i++){
			for(int j = 0; j < 48; j++){
				matches.calendar[i][j] = calendar[i][j] && c.calendar[i][j];
			}
		}
		
		return matches;
	}
	
	public ArrayList<Boolean> matchingDays(int day, Calendar c){
		Calendar temp = matches(c);
		return temp.getTimesForDay(day);
	}

}

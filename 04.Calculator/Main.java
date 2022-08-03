import java.util.Scanner;

public class Main {
	
	public static int convert_romes_to_arabic (String value) {
		switch (value) {
			case "I": return 1;
			case "II": return 2;
			case "III": return 3;
			case "IV": return 4;
			case "V": return 5;
			case "VI": return 6;
			case "VII": return 7;
			case "VIII": return 8;
			case "IX": return 9;
			case "X": return 10;
		}
		return 0;
	}
	public static String convert_arabic_to_romes (int value) {
	    String s = "";
	    while (value >= 100) {
	        s += "C";
	        value -= 100;
	    }
	    while (value >= 90) {
	        s += "XC";
	        value -= 90;
	    }
	    while (value >= 50) {
	        s += "L";
	        value -= 50;
	    }
	    while (value >= 40) {
	        s += "XL";
	        value -= 40;
	    }
	    while (value >= 10) {
	        s += "X";
	        value -= 10;
	    }
	    while (value >= 9) {
	        s += "IX";
	        value -= 9;
	    }
	    while (value >= 5) {
	        s += "V";
	        value -= 5;
	    }
	    while (value >= 4) {
	        s += "IV";
	        value -= 4;
	    }
	    while (value >= 1) {
	        s += "I";
	        value -= 1;
	    }    
	    return s;
	}
	
	public static void main(String[] args) {
		Scanner input_a_value = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String[] input = input_a_value.nextLine().split(" ");
        if (input.length == 1) {
        	System.out.println("throws Exception //т.к. строка не является математической операцией");
        	System.exit(0);
        }
        if (input.length != 3) {
        	System.out.println("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        	System.exit(0);
        }
        
        else {
        	String operation = input[1];
        	int count_romes = 0;
        	int value1;
        	try {
        		value1 = Integer.parseInt(input[0]);
        	}
        	catch (NumberFormatException e) {
        		value1 = convert_romes_to_arabic(input[0]);
        		count_romes++;
        	}
        	int value2;
        	try {
        		value2 = Integer.parseInt(input[2]);
        	}
        	catch (NumberFormatException e) {
        		value2 = convert_romes_to_arabic(input[2]);
        		count_romes++;
        	}
        	if (count_romes == 1) {
        		System.out.print("throws Exception //т.к. используются одновременно разные системы счисления");
        		System.exit(0);
        	}
        	if (count_romes == 0) {
        		switch (operation) {
            		case "+":
            			System.out.print(value1 + value2);
            			break;
            		case "-":
            			System.out.print(value1 - value2);
            			break;
            		case "*":
            			System.out.print(value1 * value2);
            			break;
            		case "/":
            			System.out.print(value1 / value2);
            			break;
        		}
        	}
        	if (count_romes == 2) {
        		switch (operation) {
        			case "+":
        				System.out.print(convert_arabic_to_romes(value1 + value2));
        				break;
        			case "-":
        				if ((value1 - value2) < 0) {
        					System.out.print("throws Exception //т.к. в римской системе нет отрицательных чисел");
        					break;
        				}
        				else {
        					System.out.print(convert_arabic_to_romes(value1 - value2));
            				break;
        				}
        			case "*":
        				System.out.print(convert_arabic_to_romes(value1 * value2));
        				break;
        			case "/":
        				System.out.print(convert_arabic_to_romes(value1 / value2));
        				break;
        		}
        	}
        }
	}
}

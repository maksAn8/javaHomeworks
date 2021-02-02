
public class Stars {
	
	public static void main(String args[]) {
		starsFormSquare(7);
		starsFormEmptySquare(7);
		starsFormTriangle1(7);
		starsFormTriangle2(7);
		starsFormTriangle3(7);
		starsFormTriangle4(7);
		starsFormTriangle5(7);
		starsFormTriangle6(7);
		starsFormX(7);
	}

	public static void starsFormSquare(int size) {
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				if(j == size - 1) {
					System.out.println("*");
				} else {
					System.out.print("* ");
				}
			}
		}
		System.out.println();
	}
	
	public static void starsFormEmptySquare(int size) {
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				if(j == size - 1) {
					System.out.println("*");
				} else if(i == 0 || i == size - 1) {
					System.out.print("* ");
				} else {
					if (j == 0) {
						System.out.print("* ");
					} else {
						System.out.print("  ");
					}
				}
			}
		}
		System.out.println();
	}
	
	public static void starsFormX(int size) {
		if(size <= 2) {
			throw new IllegalArgumentException("Size must be an odd natural number more than 2");
		}
		int firstStar = 0, lastStar = size - 1;
		for(int i = 0; i < size; i++, firstStar++, lastStar--) {
			for(int j = 0; j < size; j++) {
				if(j == lastStar) {
					if(lastStar >= firstStar) {
						System.out.println("*"); 
						break;
					} else {
						System.out.print("* ");
					}
				} else if(j == firstStar) {
					if(firstStar > lastStar) {
						System.out.println("*");
						break;
					} else {
						System.out.print("* ");
					}
				} else {
					System.out.print("  ");
				}
			}
		}
		System.out.println();
	}
	
	public static void starsFormTriangle1(int size) {
		int lastStar = size - 1;
		for(int i = 0; i < size; i++,  lastStar--) {
			for(int j = 0; j < size; j++) {
				if(j == lastStar) {
					System.out.println("*");
					break;
				} else if(i == 0 || j == 0) {
					System.out.print("* ");
				} else {
					System.out.print("  ");
				}
			}
		}
		System.out.println();
	}
	
	public static void starsFormTriangle2(int size) {
		int lastStar = 0;
		for(int i = 0; i < size; i++, lastStar++) {
			for(int j = 0; j < size; j++) {
				if(j == lastStar) {
					System.out.println("*");
					break;
				} else if(j == 0 || i == size - 1) {
					System.out.print("* ");					
				} else {
					System.out.print("  ");
				}
			}
		}
		System.out.println();
	}
	
	public static void starsFormTriangle3(int size) {
		int firstStar = size - 1;
		for(int i = 0; i < size; i++, firstStar--) {
			for(int j = 0; j < size; j++) {
				if(j == size - 1) {
					System.out.println("*");
				} else if(i == size - 1) {
					System.out.print("* ");
				} else if(j == firstStar){ 
					System.out.print("* ");
				} else {
					System.out.print("  ");
				}
			}
		}
		System.out.println();
	}

	public static void starsFormTriangle4(int size) {
		int firstStar = 0;
		for(int i = 0; i < size; i++, firstStar++) {
			for(int j = 0; j < size; j++) {
				if(j == size - 1) {
					System.out.println("*");
				} else if (j == firstStar || i == 0) {
					System.out.print("* ");
				} else {
					System.out.print("  ");
				}
			}
		}
		System.out.println();
	}
	
	public static void starsFormTriangle5(int size) { 
		if(size <= 3) {
			throw new IllegalArgumentException("Size must be an odd natural number more than 3");
		}
		int firstStar = 0, lastStar = size - 1;
		for(int i = 0; i < size / 2 + 1; i++, firstStar++, lastStar--) {
			for(int j = 0; j < size; j++) {
				if(j == lastStar) {
					System.out.println("*"); 
					break;
				} else if(j == firstStar || i == 0) {
					System.out.print("* ");
				} else {
					System.out.print("  ");
				}
			}
		}
		System.out.println();
	}
	
	public static void starsFormTriangle6(int size) {
		if(size <= 3) {
			throw new IllegalArgumentException("Size must be an odd natural number more than 3");
		}
		int firstStar = size / 2, lastStar = size / 2;
		for(int i = 0; i < size / 2 + 1; i++, firstStar--, lastStar++) {
			for(int j = 0; j < size; j++) {
				if(j == lastStar) {
					System.out.println("*"); 
					break;
				} else if(j == firstStar || i == size / 2) {
					System.out.print("* ");
				} else {
					System.out.print("  ");
				}
			}
			
		}
		System.out.println();
	}

}

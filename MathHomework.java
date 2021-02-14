
public class MathHomework {
	
	public static double getFlightDistanceDegree(int v, int a) {
		if(a < 0 || a > 70) {
			throw new IllegalArgumentException("Incorrect angle");
		}
		double distance = 0;
		try {
			distance = Math.pow(v, 2) * Math.sin(Math.toRadians(a)) / 9.8;
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
		}
		return distance;
	}
	
	public static double getFlightDistanceRad(int v, double a) {
		if(a < 0 || a > Math.PI / 3) {
			throw new IllegalArgumentException("Incorrect angle");
		}
		double distance = 0;
		try {
			distance = Math.pow(v, 2) * Math.sin(a) / 9.8;
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
		}
		return distance;
	}
	
	public static boolean pointIsInTheArea(double x, double y) {
		double[] apex1 = new double[] {0.0, -1.0};
		double[] apex2 = new double[] {0.0, 0.0};
		double[] apex3 = new double[] {2.0, 2.0};
		double[] apex4 = new double[] {-2.0, 2.0};
		double side1 = (apex1[0] - x) * (apex2[1] - apex1[1]) - (apex2[0] - apex1[0]) * (apex1[1] - y);
		double side2 = (apex2[0] - x) * (apex3[1] - apex2[1]) - (apex3[0] - apex2[0]) * (apex2[1] - y);
		double side3 = (apex3[0] - x) * (apex1[1] - apex3[1]) - (apex1[0] - apex3[0]) * (apex3[1] - y);
		if(side1 >= 0 && side2 >= 0 && side3 >= 0 || 
				side1 <= 0 && side2 <= 0 && side3 <= 0) { //true if point belongs to the right triangle
			return true;
		}
		side1 = (apex4[0] - x) * (apex2[1] - apex4[1]) - (apex2[0] - apex4[0]) * (apex4[1] - y);
		side2 = (apex2[0] - x) * (apex1[1] - apex2[1]) - (apex1[0] - apex2[0]) * (apex2[1] - y);
		side3 = (apex1[0] - x) * (apex4[1] - apex1[1]) - (apex4[0] - apex1[0]) * (apex1[1] - y);
		if(side1 >= 0 && side2 >= 0 && side3 >= 0 || 
				side1 <= 0 && side2 <= 0 && side3 <= 0) { //true if point belongs to the left triangle
			return true;
		}
		return false;
	}
	
	public static double distanceBetweenTwoCars(int car1Speed, int car2Speed, int initialDistance, double time) {
		if(car1Speed < 0 || car2Speed < 0 || initialDistance < 0 || time < 0) {
			throw new IllegalArgumentException("Incorrect data!");
		}
        return initialDistance + car1Speed * time + car2Speed * time;
    }
	
	public static double findZ(double rad){
        double numerator = Math.exp(rad + 1) + 2 * Math.exp(rad) * Math.cos(rad);
        double denominator = rad - Math.exp(rad + 1) * Math.sin(rad);
        double fraction = Math.abs(Math.cos(rad) / Math.exp(Math.sin(rad)));
        double Z;
        if (denominator <= 0 || numerator <= 0) {
            throw new IllegalArgumentException("Input value is not acceptable.");
        }
        Z = 6 * Math.log(Math.sqrt(numerator)) / Math.log(denominator) + fraction;
        return Z;
    }
	
}

public class Drachenkurve {

     
	public static void kurveR(Canvas s, int ordnung) {
		if (ordnung <= 0) {
			s.drawForward(10);
		} else {
			kurveR(s, ordnung - 1);
			s.rotate(90);
			kurveL(s, ordnung - 1);
		}
	}

	public static void kurveL(Canvas s, int ordnung) {
		if (ordnung <= 0) {
			s.drawForward(10);
		} else {
			kurveR(s, ordnung - 1);
			s.rotate(-90);
			kurveL(s, ordnung - 1);
		}
	}

	public static void main(String[] args) {
		Canvas s = new Canvas();
		s.rotate(180); // Rotiert die aktuelle Ausrichtung nach oben
		kurveR(s, 10);
	}
}

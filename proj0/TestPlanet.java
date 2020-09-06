public class TestPlanet {
    public static void main(String[] args) {
        checkPlanet();
    }

    private static void checkPlanet() {
        Planet p1 = new Planet(1.0, 1.0, 3.0, 4.0, 5.0, "jupiter.gif");

        Planet p2 = new Planet(4.0, 5.0, 3.0, 4.0, 1000.0, "jupiter.gif");

        double force12 = p1.calcForceExertedBy(p2);
        double force21 = p2.calcForceExertedBy(p1);

        checkEqual(1.334e-8, force12, "force 1 to 2", 0.01);
        checkEqual(1.334e-8, force21, "force 2 to 1", 0.01);
    }

    private static void checkEqual(double expected,double actual,String label, double eps){
        if(Math.abs(expected - actual) <= eps * Math.max(Math.abs(expected),Math.abs(actual))){
            System.out.println("PASS: " + label + ": Expected "+expected + " and you gave " + actual);
        }
        else{
            System.out.println("FAIL: " + label + ": Expected "+expected + " but you gave " + actual);
        }
    }
}

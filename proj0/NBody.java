import java.util.LinkedList;
import java.util.List;

public class NBody {
    public static double readRadius(String filePath){
       In in = new In(filePath);
       in.readLine();
       return in.readDouble();
    }

    public static LinkedList<Planet> readPlanets(String filepath) {
        In in = new In(filepath);
        int number = in.readInt();
        LinkedList<Planet> planets = new LinkedList<>();
        in.readDouble();
        for(int i = 1; i<= number;i++){
            double px = in.readDouble();
            double py = in.readDouble();
            double vx = in.readDouble();
            double vy = in.readDouble();
            double m = in.readDouble();
            String imgpath = in.readString();
            
            planets.add(new Planet(px,py,vx,vy,m,imgpath));
        }
        return planets;
    }

    public static double dt,totalTime,radius;

    public static void main(String[] args) {
        totalTime = Double.parseDouble(args[0]);
        dt = Double.parseDouble(args[1]);
        String filename = args[2];

        LinkedList<Planet> planets = readPlanets(filename);
        radius = readRadius(filename);
        
        StdDraw.setScale(-radius, radius);
        drawBackgroud();

        // make amination smooth
        StdDraw.enableDoubleBuffering();


        double t = 0;
        double coolDown = 100;
        while(t<totalTime){
            if(coolDown==100 && StdDraw.isMousePressed()){
                double x = StdDraw.mouseX();
                double y = StdDraw.mouseY();
                planets.add(createAnEarth(x,y));
                coolDown = 0;
            }
            // update planets and draw bg with planets
            updatePlanets(planets);
            drawBackgroud();
            drawPlanets(planets);


            StdDraw.show();
            StdDraw.pause(10);
            t += dt;
            if(coolDown<100){
                coolDown ++;
            }
        }
        printInfo(planets);
    }

    /**
     * print info when simulation is over
     * @param planets
     */
    public static void printInfo(List<Planet> planets){
        StdOut.printf("%d\n", planets.size());
        StdOut.printf("%.2e\n", radius);
        for (Planet planet:planets) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planet.xxPos, planet.yyPos, planet.xxVel,
                    planet.yyVel, planet.mass, planet.imgFileName);
        }
    }

    public static void updatePlanets(LinkedList<Planet> planets){
        int number = planets.size();
        double[] xforces = new double[number];
        double[] yforces = new double[number];
        for (int i = 0; i < number; i++) {
            xforces[i] = planets.get(i).calcNetForceExertedByX(planets);
            yforces[i] = planets.get(i).calcNetForceExertedByY(planets);
        }
        for (int i = 0; i < number; i++) {
            planets.get(i).update(dt,xforces[i],yforces[i]);
        }
    }

    public static void drawBackgroud(){
        StdDraw.picture(0,0,"images/starfield.jpg",2*radius,2*radius);
    }
    
    public static void drawPlanets(List<Planet> planets){
        for (Planet p : planets ) {
            p.draw();
        }
    }

    public static Planet createAnEarth(double x,double y){
        return new Planet(x,y,0,0,5.9740e+24,"earth.gif");
    }

}

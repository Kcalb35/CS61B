public class NBody {
    public static double readRadius(String filePath){
       In in = new In(filePath);
       in.readLine();
       return in.readDouble();
    }

    public static Planet[] readPlanets(String filepath) {
        In in = new In(filepath);
        int number = in.readInt();
        Planet[] planets = new Planet[number];
        in.readDouble();
        for(int i = 1; i<= number;i++){
            double px = in.readDouble();
            double py = in.readDouble();
            double vx = in.readDouble();
            double vy = in.readDouble();
            double m = in.readDouble();
            String imgpath = in.readString();
            
            planets[i-1] = new Planet(px,py,vx,vy,m,imgpath);
        }
        return planets;
    }

    public static void main(String[] args) {
        double totalTime = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];

        Planet[] planets = readPlanets(filename);
        int number = planets.length;
        double radius = readRadius(filename);
        
        StdDraw.setScale(-radius, radius);
        StdDraw.picture(0,0,"images/starfield.jpg",2*radius,2*radius);

        // make amination smooth
        StdDraw.enableDoubleBuffering();

        double t = 0;
        while(t<totalTime){
            double[] xforces = new double[number];
            double[] yforces = new double[number];
            for (int i = 0; i < number; i++) {
                xforces[i] = planets[i].calcNetForceExertedByX(planets);
                yforces[i] = planets[i].calcNetForceExertedByY(planets);
            }
            for (int i = 0; i < number; i++) {
                planets[i].update(dt,xforces[i],yforces[i]);
            }
            StdDraw.picture(0,0,"images/starfield.jpg",2*radius,2*radius);
            for(Planet p : planets){
                StdDraw.picture(p.xxPos,p.yyPos,"images\\"+p.imgFileName);
            }
            StdDraw.show();
            StdDraw.pause(10);
            t += dt;
        }
    }
}

public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    /**
     * construct a planet
     * @param xP x pos
     * @param yP y pos
     * @param xV x velocity
     * @param yV y velocity
     * @param m mass
     * @param img img file name
     */
    public Planet(double xP,double yP,double xV,double yV,double m,String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    /**
     * construct a planet with copy
     * @param p
     */
    public Planet(Planet p){
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p){
        double dx = p.xxPos - this.xxPos;
        double dy = p.yyPos - this.yyPos;

        return Math.sqrt(dx * dx + dy * dy);
    }

    public double calcForceExertedBy(Planet p){
        double distance = calcDistance(p);

        return 6.67e-11 * p.mass * this.mass/(distance*distance);
    }

    public double calcForceExertedByX(Planet p) {
        double distance = calcDistance(p);
        double force = calcForceExertedBy(p);
        
        return (p.xxPos - this.xxPos) / distance * force;
    }

    public double calcForceExertedByY(Planet p) {
        double distance = calcDistance(p);
        double force = calcForceExertedBy(p);
        
        return (p.yyPos - this.yyPos) / distance * force;
    }

    public double calcNetForceExertedByX(Planet[] planets){
        double force = 0;
        for (Planet planet:planets){
            if(this.equals(planet)) continue;
            force += calcForceExertedByX(planet);
        }
        return force;
    }

    public double calcNetForceExertedByY(Planet[] planets){
        double force = 0;
        for(Planet planet:planets){
            if(this.equals(planet)) continue;
            force += calcForceExertedByY(planet);
        }
        return force;
    }

    public void update(double dt,double fx,double fy){
        double ax = fx / mass;
        double ay = fy / mass;

        xxVel += ax * dt;
        yyVel += ay * dt;

        xxPos += dt * xxVel;
        yyPos += dt * yyVel;
    }

    public void draw(){
        StdDraw.picture(xxPos,yyPos,"images\\"+imgFileName);
    }

}

public class Planet {
    double xxPos;
    double yyPos;
    double xxVel;
    double yyVel;
    double mass;
    String imgFileName;

    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        this.xxPos = xP;
        this.yyPos = yP;
        this.xxVel = xV;
        this.yyVel = yV;
        this.mass = m;
        this.imgFileName = img;
    }

    public Planet(Planet p) {
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }
    public  double calcDistance(Planet p)
    {double dx,dy;
    dx=this.xxPos-p.xxPos;
    dy=this.yyPos-p.yyPos;
    return Math.sqrt(dx*dx+dy*dy);
    }
    public double calcForceExertedBy(Planet p)
    {double f;
    f=6.67e-11*this.mass*p.mass/(this.calcDistance(p)*this.calcDistance(p));
            return  f;
    }
    public double calcForceExertedByX(Planet p)
    {
        double x;
        x=(p.xxPos-this.xxPos)*this.calcForceExertedBy(p)/this.calcDistance(p);
        return x;
    }
    public double calcForceExertedByY(Planet p)
    {
        double y;
        y=(p.yyPos-this.yyPos)*this.calcForceExertedBy(p)/this.calcDistance(p);
        return y;
    }
    public double calcNetForceExertedByX(Planet[] pr)
    {double sumX=0;
        for(Planet p:pr)
        {if(!equals(p))
        sumX+=calcForceExertedByX(p);}
        return sumX;
    }
    public double calcNetForceExertedByY(Planet[] pr)
    {double sumY=0;
        for(Planet p:pr)
        {if(!equals(p))
            sumY+=calcForceExertedByY(p);}
        return sumY;
    }

    public void update(double dt,double fX,double fY)
    {double aX,aY;
    aX=fX/this.mass;
    aY=fY/this.mass;
    xxVel+=aX*dt;
    yyVel+=aY*dt;
    xxPos+=dt*xxVel;
    yyPos+=dt*yyVel;
    }
    public void draw()
    {String filename;
        filename = "images/" + imgFileName;
        StdDraw.picture(xxPos, yyPos, filename);
        StdDraw.show();
    }
}

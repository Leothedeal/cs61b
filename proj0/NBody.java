public class NBody {
    public static double readRadius(String filename) {
        In in = new In(filename);
        in.readInt();
        return in.readDouble();
    }

    public static Planet[] readPlanets(String filename) {
        In in = new In(filename);
        in.readInt();
        in.readDouble();
        Planet[] pr = new Planet[5];
        for (int i = 0; i < 5; i++) {
            double xxPos = in.readDouble();
            double yyPos = in.readDouble();
            double xxVel = in.readDouble();
            double yyVel = in.readDouble();
            double mass = in.readDouble();
            String imgFileName = in.readString();
            pr[i] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
        }
        return pr;
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double uniRadius = readRadius(filename);
        Planet[] pr = readPlanets(filename);

        /* Draw */
        StdDraw.setScale(-uniRadius, uniRadius);
        StdDraw.clear();
        StdDraw.picture(0, 0, "images/starfield.jpg");
        for (Planet p : pr) {
            p.draw();
        }
        StdDraw.enableDoubleBuffering();
        double t = 0;
        while (t < T) {
            double[] xForce = new double[pr.length];
            double[] yForce = new double[pr.length];
            for (int i = 0; i < pr.length; i++) {
                xForce[i] = pr[i].calcNetForceExertedByX(pr);
                yForce[i] = pr[i].calcNetForceExertedByY(pr);
            }
            for (int i = 0; i < pr.length; i++) {
                pr[i].update(dt, xForce[i], yForce[i]);

            }
            StdDraw.setScale(-uniRadius, uniRadius);
            StdDraw.clear();
            StdDraw.picture(0, 0, "images/starfield.jpg");
            for (Planet p : pr) {
                p.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            t += dt;
        }
        StdOut.printf("%d\n", pr.length);
        StdOut.printf("%.2e\n", uniRadius);
        for (int i = 0; i < pr.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    pr[i].xxPos, pr[i].yyPos, pr[i].xxVel,
                    pr[i].yyVel, pr[i].mass, pr[i].imgFileName);
        }
    }
}

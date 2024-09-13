package section1_intro.part1_language_basics;

import java.text.NumberFormat;

public class GeometryAnalyser {
    public static void main(String[] args) {
        int x1 = Integer.parseInt(args[0]);
        int y1 = Integer.parseInt(args[1]);
        int x2 = Integer.parseInt(args[2]);
        int y2 = Integer.parseInt(args[3]);
        String excuteFunction = (args[4]);

        Point firsPoint = new Point();
        firsPoint.x = x1;
        firsPoint.y = y1;

        Point secondPoint = new Point();
        secondPoint.x = x2;
        secondPoint.y = y2;

        if (excuteFunction.equals("surf")) {
            Rectangle rectangle = new Rectangle();
            rectangle.upperLeft = firsPoint;
            rectangle.lowerRight = secondPoint;
            int surface = rectangle.getSurface();
            System.out.println(surface);
        }else if (excuteFunction.equals("dist")) {
            double distance = firsPoint.euclideanDistanceTo(secondPoint);

            NumberFormat numberFormat = NumberFormat.getNumberInstance();
            numberFormat.setMaximumFractionDigits(1);
            System.out.println(numberFormat.format(distance));
        }


    }
}

import java.util.*;

public class B166 {

    static class Point {
        long x, y;
        Point(long x, long y){
            this.x = x;
            this.y = y;
        }
    }

    static long cross(Point O, Point A, Point B){
        return (A.x - O.x)*(B.y - O.y) - (A.y - O.y)*(B.x - O.x);
    }

    static boolean strictlyInside(ArrayList<Point> poly, Point p){
        int n = poly.size();
        for(int i = 0; i < n; i++){
            long c = cross(poly.get(i), poly.get((i+1)%n), p);
            if(c >= 0) return false;
        }
        return true;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList<Point> A = new ArrayList<>();

        for(int i = 0; i < n; i++)
            A.add(new Point(sc.nextLong(), sc.nextLong()));

        int m = sc.nextInt();
        ArrayList<Point> B = new ArrayList<>();

        for(int i = 0; i < m; i++)
            B.add(new Point(sc.nextLong(), sc.nextLong()));

        for(Point p : B){
            if(!strictlyInside(A, p)){
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }
}
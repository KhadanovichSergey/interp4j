package assignment_fqn_access;

class Main {
    public static void main(String... args) {
        String name = "Alex";
        String greet = new dev.khbd.interp4j.core.internal.s.SInterpolator("Hello ", "").interpolate(name);
        System.out.println(greet);
    }
}
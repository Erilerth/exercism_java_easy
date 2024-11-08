class Darts {
    int score(double xOfDart, double yOfDart) {
        double distance = Math.sqrt(Math.pow(xOfDart, 2) + Math.pow(yOfDart, 2));

        if (distance <= 1)
            return 10;
        else if (distance > 1 && distance <= 5)
            return 5;
        else if (distance > 5 && distance <= 10)
            return 1;
        else return 0;

    }
}

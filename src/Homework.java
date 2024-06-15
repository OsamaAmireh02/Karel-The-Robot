import stanford.karel.SuperKarel;

public class Homework extends SuperKarel {

    private int steps = 0;
    private int width = 0;
    private int height = 0;

    private int calculate() {
        int counter = 1;
        while (frontIsClear()) {
            moveWithCalculation();
            counter++;
        }
        turnLeft();
        return counter;
    }

    private void setWidth() {
        width = calculate();
    }

    private void setHeight() {
        height = calculate();
    }

    private void put() {
        if (noBeepersPresent()) {
            putBeeper();
        }
    }

    private void moveWithCalculation() {
        move();
        System.out.println(++steps);
    }

    private void drawLine() {
        while (frontIsClear()) {
            put();
            moveWithCalculation();
        }
        put();
    }

    private void putDouble() {
        put();
        turnRight();
        moveWithCalculation();
        put();
        turnAround();
        moveWithCalculation();
        turnRight();
    }

    private void twoWithFiveCase(int s) {
        turnLeft();
        moveWithCalculation();
        if (s == 0) {
            turnRight();
            moveWithCalculation();
        }
        putDouble();
        moveWithCalculation();
        moveWithCalculation();
        putDouble();
        moveWithCalculation();
        if (s == 1) {
            turnRight();
            moveWithCalculation();
        }
        turnAround();
    }

    private void OneOrTwoWithMoreThanFourCases(int n, int x) {
        int count = 1;
        if (n % 4 == 3) {
            n++;
            count = 2;
        } else if (x == 1)
            put();
        while (frontIsClear()) {
            moveWithCalculation();
            if (n < 7) {
                if (count % 2 == 0)
                    if (x == 1)
                        put();
                    else putDouble();
            } else if (count % (n / 4) == 0) {
                if (x == 1)
                    put();
                else putDouble();
            }
            count++;
        }
        if (n > 6 && n % 4 == 2) {
            if (x == 1)
                put();
            else putDouble();
        }
        if (n == 1)
            turnAround();
    }

    private void oneWithMoreThanThree(int n) {
        if (n == 3) {
            moveWithCalculation();
            put();
            moveWithCalculation();
            turnLeft();
        } else if (n == 5) {
            for (int i = 0; i < 2; i++) {
                moveWithCalculation();
                put();
                moveWithCalculation();
            }
            turnLeft();
        } else if (n >= 4) {
            OneOrTwoWithMoreThanFourCases(n, 1);
            turnLeft();
        }
    }

    private void drawVerticalWhenOdd() {
        int count = 0;
        while (count < width / 2) {
            moveWithCalculation();
            count++;
        }
        turnLeft();
        drawLine();
        turnRight();
        while (frontIsClear()) {
            moveWithCalculation();
        }
        turnRight();
    }

    private void drawVerticalWhenEven() {
        int count = 0;
        while (count < width / 2 - 1) {
            moveWithCalculation();
            count++;
        }
        turnLeft();
        drawLine();
        turnRight();
        moveWithCalculation();
        turnRight();
        drawLine();
        turnLeft();
        while (frontIsClear()) {
            moveWithCalculation();
        }
        turnLeft();
    }

    private void drawHorizontalWhenOdd() {
        int count = 0;
        while (count < height / 2) {
            moveWithCalculation();
            count++;
        }
        if (width % 2 == 1) turnRight();
        else turnLeft();
        drawLine();
        turnRight();
        while (frontIsClear()) {
            moveWithCalculation();
        }
        turnRight();
        while (frontIsClear()) {
            moveWithCalculation();
        }
        turnAround();
    }

    private void drawHorizontalWhenEven() {
        int count = 0;
        while (count < height / 2 - 1) {
            moveWithCalculation();
            count++;
        }
        if (width % 2 == 0) turnLeft();
        else turnRight();
        drawLine();
        if (width % 2 == 0) turnRight();
        else turnLeft();
        moveWithCalculation();
        if (width % 2 == 0) turnRight();
        else turnLeft();
        drawLine();
        turnLeft();
        while (frontIsClear()) {
            moveWithCalculation();
        }
        turnLeft();
    }

    public void run() {
        steps = 0;
        setWidth();
        setHeight();
        setBeepersInBag(1000);

        if (height == 2 && width == 2) {
            put();
            moveWithCalculation();
            turnLeft();
            moveWithCalculation();
            put();
            turnLeft();
        } else if (width == 1) {
            if (height == 2) {
                turnLeft();
                moveWithCalculation();
            }
            turnLeft();
            if (height >= 3) {
                oneWithMoreThanThree(height);
            }
        } else if (height == 1) {
            if (width == 2) {
                moveWithCalculation();
                turnLeft();
            } else if (width >= 3) {
                oneWithMoreThanThree(width);
            }
            turnLeft();
        } else if (width == 2) {
            if (height == 3) {
                for (int i = 0; i < 2; i++) {
                    put();
                    moveWithCalculation();
                    turnLeft();
                    moveWithCalculation();
                }
                put();
                turnAround();
                moveWithCalculation();
                turnAround();
            } else if (height == 4) {
                put();
                for (int i = 0; i < 2; i++) {
                    moveWithCalculation();
                    turnLeft();
                    moveWithCalculation();
                    put();
                }
                turnRight();
                moveWithCalculation();
                turnRight();
                moveWithCalculation();
                turnAround();
                put();
            } else if (height == 5) {
                twoWithFiveCase(1);
            } else if (height > 5) {
                turnLeft();
                if (height != 7)
                    putDouble();
                OneOrTwoWithMoreThanFourCases(height, 2);
                turnRight();
                moveWithCalculation();
                turnAround();
            }
        } else if (height == 2) {
            if (width == 3) {
                put();
                moveWithCalculation();
                moveWithCalculation();
                put();
                turnAround();
                moveWithCalculation();
                turnRight();
                moveWithCalculation();
                put();
                turnRight();
                moveWithCalculation();
                turnAround();
            } else if (width == 4) {
                put();
                moveWithCalculation();
                moveWithCalculation();
                put();
                turnLeft();
                moveWithCalculation();
                turnLeft();
                moveWithCalculation();
                put();
                turnAround();
                moveWithCalculation();
                moveWithCalculation();
                put();
                turnAround();
            } else if (width == 5) {
                twoWithFiveCase(0);
            } else if (width > 5) {
                turnLeft();
                moveWithCalculation();
                turnRight();
                if (width != 7)
                    putDouble();
                OneOrTwoWithMoreThanFourCases(width, 2);
                turnAround();
            }
        } else if (width % 2 == 1 && height % 2 == 1) {
            drawVerticalWhenOdd();
            drawHorizontalWhenOdd();
        } else if (width % 2 == 0 && height % 2 == 0) {
            drawVerticalWhenEven();
            drawHorizontalWhenEven();
        } else if (width % 2 == 1 && height % 2 == 0) {
            drawVerticalWhenOdd();
            drawHorizontalWhenEven();
        } else if (width % 2 == 0 && height % 2 == 1) {
            drawVerticalWhenEven();
            drawHorizontalWhenOdd();
        }
    }
}

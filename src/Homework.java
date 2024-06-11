import stanford.karel.SuperKarel;

public class Homework extends SuperKarel {

    private int steps = 0;
    private int width = 0;
    private int height = 0;

    public int calculate(){
        int counter = 1;
        while (frontIsClear()){
            moveWithCalculation();
            counter++;
        }
        turnLeft();
        return counter;
    }

    private void setWidth(){
        width = calculate();
    }

    private void setHeight(){
        height = calculate();
    }

    public void put(){
        if (noBeepersPresent()){
            putBeeper();
        }
    }

    public void moveWithCalculation() {
        move();
        System.out.println(++steps);
    }

    public void drawLine(){
        while (frontIsClear()){
            put();
            moveWithCalculation();
        }
        put();
    }

    private void oneWithFiveCase(){
        for (int i =0; i<2; i++) {
            moveWithCalculation();
            put();
            moveWithCalculation();
        }
    }

    private void oneWithMoreThanFourCases(int n){
        int count = 1;
        put();
        if (n % 4 ==3) {
            n++;
            count = 2;
            pickBeeper();
        }
        while (frontIsClear()) {
            moveWithCalculation();
            if(n < 7){
                if(count % 2 == 0)
                    put();
            }else if (count % (n / 4) == 0) {
                put();
            }
            count++;
        }
        if (n > 6 && n % 4 == 2) {
            put();
        }
    }

    private void twoWithMoreThanFiveCases(int n){
        int count = 1;
        if (n % 4 == 3) {
            n++;
            count = 2;
            pickBeeper();
        }
        while (frontIsClear()) {
            moveWithCalculation();
            if(n < 7){
                if(count % 2 == 0)
                    putDouble();
            }else if (count % (n / 4) == 0) {
                putDouble();
            }
            count++;
        }
        if (n > 6 && n % 4 == 2) {
            putDouble();
        }
    }

    private void drawHorizontalWhenOdd(){
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

    private void drawHorizontalWhenEven(){
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

    private void drawVerticalWhenOdd(){
        int count = 0;
        while (count < height / 2) {
            moveWithCalculation();
            count++;
        }
        if (width % 2 == 1) turnRight();
        else turnLeft();
        drawLine();
    }

    private void drawVerticalWhenEven(){
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
    }

    private void putDouble(){
        put();
        turnRight();
        moveWithCalculation();
        put();
        turnAround();
        moveWithCalculation();
        turnRight();
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
            if(height == 3){
                moveWithCalculation();
                put();
                moveWithCalculation();
                turnLeft();
            }else if(height == 5) {
                oneWithFiveCase();
            }else if (height >= 4) {
                oneWithMoreThanFourCases(height);
            }
        } else if(height == 1){
            if (width == 2) {
                moveWithCalculation();
                turnAround();
            }else if ( width == 3 ) {
                moveWithCalculation();
                put();
                moveWithCalculation();
                turnAround();
            }else if(width == 5) {
                oneWithFiveCase();
            } else if (width >= 4) {
                oneWithMoreThanFourCases(width);
            }
        } else if(width == 2){
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
                for (int i = 0; i < 2; i++) {
                    moveWithCalculation();
                    turnLeft();
                    moveWithCalculation();
                    put();
                }
            } else if (height == 5) {
                moveWithCalculation();
                turnLeft();
                moveWithCalculation();
                put();
                turnLeft();
                moveWithCalculation();
                put();
                turnRight();
                moveWithCalculation();
                moveWithCalculation();
                put();
                turnRight();
                moveWithCalculation();
                put();
            } else if (height > 5) {
                put();
                moveWithCalculation();
                put();
                turnAround();
                moveWithCalculation();
                turnRight();
                twoWithMoreThanFiveCases(height);
            }
        } else if (height == 2){
            if (width == 3) {
                moveWithCalculation();
                put();
                moveWithCalculation();
                turnLeft();
                moveWithCalculation();
                turnLeft();
                put();
                moveWithCalculation();
            } else if (width == 5) {
                turnLeft();
                moveWithCalculation();
                turnRight();
                moveWithCalculation();
                putDouble();
                moveWithCalculation();
                moveWithCalculation();
                putDouble();
                moveWithCalculation();
                turnAround();
            } else if (width > 5) {
                put();
                turnLeft();
                moveWithCalculation();
                put();
                turnRight();
                twoWithMoreThanFiveCases(width);
            }
        } else if (width % 2 == 1 && height % 2 == 1) {
            drawHorizontalWhenOdd();
            drawVerticalWhenOdd();
        } else if (width % 2 == 0 && height % 2 == 0) {
            drawHorizontalWhenEven();
            drawVerticalWhenEven();
        } else if (width % 2 == 1 && height % 2 == 0) {
            drawHorizontalWhenOdd();
            drawVerticalWhenEven();
        } else if (width % 2 == 0 && height % 2 == 1) {
            drawHorizontalWhenEven();
            drawVerticalWhenOdd();
        }
    }
}
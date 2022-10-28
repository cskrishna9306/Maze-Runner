import java.util.Scanner;
import java.lang.System;
public class MazeRunner {
    Maze myMap = new Maze();
    public static void main(String[] args) {
        Maze myMap = new Maze();
        String a,b;
        intro();
        myMap.printMap();
        int i=0;
        while (!myMap.didIWin()) {
            i++;
            a = userMove();
            if (a.equalsIgnoreCase("R")) {
                if (myMap.canIMoveRight()) {
                    myMap.moveRight();
                    if (myMap.isThereAPit("R")) {
                        b = navigatePit();
                        if (b.startsWith("y")) {
                            myMap.jumpOverPit("R");
                        }
                    }
                    myMap.printMap();
                } else {
                    System.out.println("Sorry you've hit a wall");
                }
            } else if (a.equalsIgnoreCase("L")) {
                if (myMap.canIMoveLeft()) {
                    myMap.moveLeft();
                    if (myMap.isThereAPit("L")) {
                        b = navigatePit();
                        if (b.startsWith("y")) {
                            myMap.jumpOverPit("L");
                        }
                    }
                    myMap.printMap();
                } else {
                    System.out.println("Sorry you've hit a wall");
                }
            } else if (a.equalsIgnoreCase("U")) {
                if (myMap.canIMoveUp()) {
                    myMap.moveUp();
                    if (myMap.isThereAPit("U")) {
                        b = navigatePit();
                        if (b.startsWith("y")) {
                            myMap.jumpOverPit("U");
                        }
                    }
                    myMap.printMap();
                } else {
                    System.out.println("Sorry you've hit a wall");
                }
            } else if (a.equalsIgnoreCase("D")){
                if (myMap.canIMoveDown()) {
                    myMap.moveDown();
                    if (myMap.isThereAPit("D")) {
                        b = navigatePit();
                        if (b.startsWith("y")) {
                            myMap.jumpOverPit("D");
                        }
                    }
                    myMap.printMap();
                } else {
                    System.out.println("Sorry you've hit a wall");
                }
            } else {
                System.out.println("Invalid move");
            }
            movesMessage(i);
        }
        System.out.println("Congratulations, you made it out alive and you made it in " + i + " moves");
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void intro() {
        System.out.println("Welcome to Maze Runner!");
        System.out.println("Here is your current position: ");
        //myMap.printMap();
    }

    public static String userMove() {
        Scanner input = new Scanner(System.in);
        String a = "J";
        //while (!a.equalsIgnoreCase("R")&&!a.equalsIgnoreCase("L")&&!a.equalsIgnoreCase("U")&&!a.equalsIgnoreCase("D")){
            System.out.print("Where would you like to move? (R, L, U, D) ");
            a = input.nextLine();
        //}
        return a;
        /*do{
            System.out.print("Where would you like to move? (R, L, U, D) ");
            a = input.next();
        } while ((a!='R')||(a!='L')||(a!='U')||(a!='D')||(a!='r')||(a!='l')||(a!='u')||(a!='d'));*/
        /*if (a.equalsIgnoreCase("R")||a.equalsIgnoreCase("L")||a.equalsIgnoreCase("U")||a.equalsIgnoreCase("D")) {
            return a;
        } else {
            return userMove();
        }*/
    }

    public static void movesMessage(int moves) {
        if (moves==50) {
            System.out.println("Warning: You have made 50 moves, you have 50 remaining before the maze exit closes");
        } else if (moves==75) {
            System.out.println("Alert! You have made 75 moves, you only have 25 moves left to escape.");
        } else if (moves==90) {
            System.out.println("DANGER! You have made 90 moves, you only have 10 moves left to escape!!");
        } else if (moves==100) {
            System.out.println("Oh no! You took too long to escape, and now the maze exit is closed FOREVER>:[");
            System.out.println("Sorry, but you didn't escape in time- you lose!");
            System.exit(0);
        } else {
            System.out.print("");
        }
    }


    public static String navigatePit() {
        Scanner input = new Scanner(System.in);
        System.out.print("Watch out! There's a pit ahead, jump it? ");
        String a  = input.nextLine();
        return a;
    }
}

import static java.lang.System.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int fieldPlayer[][] = new int[12][12];
        int fieldBot[][] = new int[12][12];
        int forNumberUp = 0;
        int forNumberLeft = 0;
        // ЗАПОЛНЕНИЕ ПОЛЯ
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {

                if (i == 0 && j == j) {

                    fieldPlayer[i][j] = forNumberUp;
                    forNumberUp++;


                } else if (i == i && j == 0) {
                    forNumberLeft++;
                    fieldPlayer[i][j] = forNumberLeft;


                } else {
                    fieldPlayer[i][j] = 0;
                }
            }
        }

        ShowField(fieldPlayer);
        // ЛОГИКА ПОСТАНОВКИ КОрАБЛЕЙ нА ПОЛЕ
        int coutnOneShip = 4;
        int coutnTwoShip = 3;
        int countThreeShip =2;
        int choiceAboutShip = 0;
        while (true) {
            out.println("\nПоставте корабль на поле: \n1. Однопалубный \n2. Двухпалубный \n3. Трехпалубный \n4. Четырехпалубный \n5. ПОКАЗАТЬ ПОЛЕ\n");
            choiceAboutShip = in.nextInt();
            switch (choiceAboutShip) {
                case 1:
                    if (coutnOneShip <= 0) {
                        out.println("нельзя ставить однопалубный корабль больше 4");
                        break;

                    }

                    out.println("Укажите координаты СЛЕВА!.");
                    String ShipPositioLeftInput = in.next();
                    out.println("Укажите координаты СВЕРХУ!.");
                    String ShipPositionUpInput = in.next();
                    if (Util.toNumber(ShipPositioLeftInput) == null  || Util.toNumber(ShipPositionUpInput) == null) {
                        out.println("\nНекоректное число.");
                        break;
                    }

                    int ShipPositioLeft = Util.toNumber(ShipPositioLeftInput);
                    int ShipPositionUp = Util.toNumber(ShipPositionUpInput);

                    if ((ShipPositioLeft > 10 || ShipPositioLeft <= 0) || (ShipPositionUp > 10 || ShipPositioLeft <= 0)) {
                        out.println("\nНеверный диапозон.");
                        break;
                    }


                    // В этом ифе проверка идет на то что вокруг нет других корабликов
                    if (fieldPlayer[ShipPositioLeft + 1][ShipPositionUp] != 1 &&
                            fieldPlayer[ShipPositioLeft][ShipPositionUp] != 1 &&
                            fieldPlayer[ShipPositioLeft - 1][ShipPositionUp] != 1 &&
                            fieldPlayer[ShipPositioLeft][ShipPositionUp + 1] != 1 &&
                            fieldPlayer[ShipPositioLeft][ShipPositionUp - 1] != 1 &&
                            fieldPlayer[ShipPositioLeft + 1][ShipPositionUp + 1] != 1 &&
                            fieldPlayer[ShipPositioLeft + 1][ShipPositionUp - 1] != 1 &&
                            fieldPlayer[ShipPositioLeft - 1][ShipPositionUp + 1] != 1 &&
                            fieldPlayer[ShipPositioLeft - 1][ShipPositionUp - 1] != 1 &&
                            ShipPositioLeft >= 2 && ShipPositionUp >= 2) {

                        fieldPlayer[ShipPositioLeft][ShipPositionUp] = 1;
                        out.println("\nВы успешно поставили корабль");

                    } else if (ShipPositioLeft == 1 && ShipPositionUp >= 2 &&
                            fieldPlayer[ShipPositioLeft][ShipPositionUp] != 1 &&
                            fieldPlayer[ShipPositioLeft][ShipPositionUp - 1] != 1 &&
                            fieldPlayer[ShipPositioLeft][ShipPositionUp + 1] != 1 &&
                            fieldPlayer[ShipPositioLeft + 1][ShipPositionUp] != 1 &&
                            fieldPlayer[ShipPositioLeft + 1][ShipPositionUp + 1] != 1 &&
                            fieldPlayer[ShipPositioLeft + 1][ShipPositionUp - 1] != 1) {

                        fieldPlayer[ShipPositioLeft][ShipPositionUp] = 1;
                        out.println("\nВы успешно поставили корабль");

                    } else if (ShipPositioLeft >= 2 && ShipPositionUp == 1 &&
                            fieldPlayer[ShipPositioLeft][ShipPositionUp] != 1 &&
                            fieldPlayer[ShipPositioLeft + 1][ShipPositionUp] != 1 &&
                            fieldPlayer[ShipPositioLeft - 1][ShipPositionUp] != 1 &&
                            fieldPlayer[ShipPositioLeft - 1][ShipPositionUp + 1] != 1 &&
                            fieldPlayer[ShipPositioLeft + 1][ShipPositionUp + 1] != 1 &&
                            fieldPlayer[ShipPositioLeft][ShipPositionUp + 1] != 1) {

                        fieldPlayer[ShipPositioLeft][ShipPositionUp] = 1;
                        out.println("\nВы успешно поставили корабль");

                    } else if (ShipPositioLeft == 1 && ShipPositionUp == 1 &&
                            fieldPlayer[ShipPositioLeft + 1][ShipPositionUp] != 1 &&
                            fieldPlayer[ShipPositioLeft + 1][ShipPositionUp + 1] != 1 &&
                            fieldPlayer[ShipPositioLeft][ShipPositionUp + 1] != 1) {
                        fieldPlayer[ShipPositioLeft][ShipPositionUp] = 1;
                        out.println("\nВы успешно поставили корабль");
                    } else {
                        out.println("__________________________________________________ \n");
                        out.println("СЛИШКОМ БЛИЗКО К ДРУГОМУ КОРАБЛЮ!!!!");
                        out.println("__________________________________________________");
                        break;
                    }
                    coutnOneShip--;

//

                    break;
                case 2:

                    boolean horizontal = true;

                    if (coutnTwoShip <= 0) {
                        out.println("нельзя ставить двухпалубный корабль больше 3");
                        break;
                    }

                    out.println("Укажите координаты СЛЕВА!.");
                    String TwoShipPositioLeftInput = in.next();
                    out.println("Укажите координаты СВЕРХУ!.");
                    String TwoShipPositionUpInput = in.next();

                    if (Util.toNumber(TwoShipPositioLeftInput) == null || Util.toNumber(TwoShipPositionUpInput) == null){

                        out.println("\nНекоректное число");
                        break;
                    }

                    int TwoShipPositioLeft = Util.toNumber(TwoShipPositioLeftInput);
                    int TwoShipPositionUp = Util.toNumber(TwoShipPositionUpInput);

                    if ((TwoShipPositioLeft > 10 || TwoShipPositioLeft <= 0) || (TwoShipPositionUp > 10 || TwoShipPositionUp <= 0)) {
                        out.println("\nНеверный диапозон.");

                        break;
                    }
                    out.println("1. Вертикально\n2. Горизонтально");

                    String choicePositionInput = in.next();
                    if (Util.toNumber(choicePositionInput) == null){
                        out.println("Некоректное число.");
                        break;
                    }

                    int choicePosition = Util.toNumber(choicePositionInput);


                    if (choicePosition == 2) {
                        horizontal = false;
                    }

                    if (horizontal && TwoShipPositioLeft >= 2 && fieldPlayer[TwoShipPositioLeft][TwoShipPositionUp] != 1 &&
                            fieldPlayer[TwoShipPositioLeft + 1][TwoShipPositionUp] != 1 &&
                            fieldPlayer[TwoShipPositioLeft + 1][TwoShipPositionUp - 1] != 1 &&
                            fieldPlayer[TwoShipPositioLeft + 1][TwoShipPositionUp + 1] != 1 &&
                            fieldPlayer[TwoShipPositioLeft][TwoShipPositionUp + 1] != 1 &&
                            fieldPlayer[TwoShipPositioLeft][TwoShipPositionUp - 1] != 1 &&
                            fieldPlayer[TwoShipPositioLeft - 1][TwoShipPositionUp] != 1 &&
                            fieldPlayer[TwoShipPositioLeft - 1][TwoShipPositionUp - 1] != 1 &&
                            fieldPlayer[TwoShipPositioLeft - 1][TwoShipPositionUp + 1] != 1 &&
                            fieldPlayer[TwoShipPositioLeft - 2][TwoShipPositionUp] != 1 &&
                            fieldPlayer[TwoShipPositioLeft - 2][TwoShipPositionUp] != 1 &&
                            fieldPlayer[TwoShipPositioLeft - 2][TwoShipPositionUp + 1] != 1 &&
                            fieldPlayer[TwoShipPositioLeft - 2][TwoShipPositionUp - 1] != 1) {

                        for (int j = TwoShipPositioLeft; j > TwoShipPositioLeft - 2; j--) {
                            fieldPlayer[j][TwoShipPositionUp] = 1;
                        }
                        out.println("\nВы успешно поставили двухпалубный корабль");
                        coutnTwoShip--;

                    } else if (!horizontal && fieldPlayer[TwoShipPositioLeft][TwoShipPositionUp] != 1 &&
                            fieldPlayer[TwoShipPositioLeft][TwoShipPositionUp - 1] != 1 &&
                            fieldPlayer[TwoShipPositioLeft + 1][TwoShipPositionUp - 1] != 1 &&
                            fieldPlayer[TwoShipPositioLeft + 1][TwoShipPositionUp - 1] != 1 &&
                            fieldPlayer[TwoShipPositioLeft + 1][TwoShipPositionUp] != 1 &&
                            fieldPlayer[TwoShipPositioLeft - 1][TwoShipPositionUp] != 1 &&
                            fieldPlayer[TwoShipPositioLeft][TwoShipPositionUp + 1] != 1 &&
                            fieldPlayer[TwoShipPositioLeft - 1][TwoShipPositionUp + 1] != 1 &&
                            fieldPlayer[TwoShipPositioLeft + 1][TwoShipPositionUp + 1] != 1 &&
                            fieldPlayer[TwoShipPositioLeft][TwoShipPositionUp + 2] != 1 &&
                            fieldPlayer[TwoShipPositioLeft + 1][TwoShipPositionUp + 2] != 1 &&
                            fieldPlayer[TwoShipPositioLeft - 1][TwoShipPositionUp + 2] != 1 && TwoShipPositionUp < 10) {
                        for (int j = TwoShipPositionUp; j < TwoShipPositionUp + 2; j++) {
                            fieldPlayer[TwoShipPositioLeft][j] = 1;
                        }
                        out.println("\nВы успешно поставили двухпалубный корабль");
                        coutnTwoShip--;
                    } else {
                        out.println("Слишком близко к границе или к другому кораблю! Невозможно поставить корабль");
                    }
                    break;
                case 3:

                    if (countThreeShip <= 0) {
                        out.println("нельзя ставить трехпалубный корабль больше 2");
                        break;
                    }
                    boolean position = true;
                    out.println("Укажите координаты СЛЕВА!.");
                    String ThreeShipPositioLeftInput = in.next();
                    out.println("Укажите координаты СВЕРХУ!.");
                    String ThreeShipPositionUpInput = in.next();

                    if (Util.toNumber(ThreeShipPositioLeftInput) == null || Util.toNumber(ThreeShipPositionUpInput) == null){

                        out.println("\nНекоректное число");
                        break;
                    }

                    int ThreeShipPositioLeft = Util.toNumber(ThreeShipPositioLeftInput);
                    int ThreeShipPositionUp = Util.toNumber(ThreeShipPositionUpInput);

                    if ((ThreeShipPositioLeft > 10 || ThreeShipPositioLeft <= 0) || (ThreeShipPositionUp > 10 || ThreeShipPositionUp <= 0)) {
                        out.println("\nНеверный диапозон.");
                        break;
                    }

                    out.println("1. Вертикально\n2. Горизонтально");

                    String choicePositionForThreeShipInput = in.next();

                    if (Util.toNumber(choicePositionForThreeShipInput) == null){
                        out.println("Некоректное число.");
                        break;
                    }

                    int choicePositionThree = Util.toNumber(choicePositionForThreeShipInput);

                    if (choicePositionThree == 2){
                        position = false;
                    }



                    if (position && ThreeShipPositioLeft >= 2 && fieldPlayer[ThreeShipPositioLeft][ThreeShipPositionUp] != 1 &&
                            fieldPlayer[ThreeShipPositioLeft + 1][ThreeShipPositionUp] != 1 &&
                            fieldPlayer[ThreeShipPositioLeft + 1][ThreeShipPositionUp - 1] != 1 &&
                            fieldPlayer[ThreeShipPositioLeft + 1][ThreeShipPositionUp + 1] != 1 &&
                            fieldPlayer[ThreeShipPositioLeft][ThreeShipPositionUp + 1] != 1 &&
                            fieldPlayer[ThreeShipPositioLeft][ThreeShipPositionUp - 1] != 1 &&
                            fieldPlayer[ThreeShipPositioLeft - 1][ThreeShipPositionUp] != 1 &&
                            fieldPlayer[ThreeShipPositioLeft - 1][ThreeShipPositionUp - 1] != 1 &&
                            fieldPlayer[ThreeShipPositioLeft - 1][ThreeShipPositionUp + 1] != 1 &&
                            fieldPlayer[ThreeShipPositioLeft - 2][ThreeShipPositionUp] != 1 &&
                            fieldPlayer[ThreeShipPositioLeft - 2][ThreeShipPositionUp] != 1 &&
                            fieldPlayer[ThreeShipPositioLeft - 2][ThreeShipPositionUp + 1] != 1 &&
                            fieldPlayer[ThreeShipPositioLeft - 2][ThreeShipPositionUp - 1] != 1) {

                        for (int j = ThreeShipPositioLeft; j > ThreeShipPositioLeft - 3; j--) {
                            fieldPlayer[j][ThreeShipPositionUp] = 1;
                        }
                        out.println("\nВы успешно поставили двухпалубный корабль");
                        countThreeShip--;

                    }






                    break;

                case 5:
                    ShowField(fieldPlayer);
                    break;
                default:
                    out.println("Некоректный выбор");
                    break;

            }
        }


    }


    // ПОКАЗ МАТРИЦЫ
   public static void ShowField(int[][] field) {
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                out.print(field[i][j] + "\t");
                if (i == 0 && j == j && j < 10) {
                    out.print("A");
                }
            }

            out.println();
        }
    }


}

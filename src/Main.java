import static java.lang.System.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int fieldPlayer[][] = new int[12][12];
        int fieldBot[][] = new int[12][12];
        int fieldBattle[][] = new int[12][12];
        int forNumberUp = 0;
        int forNumberLeft = 0;
        // ЗАПОЛНЕНИЕ ПОЛЯ
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {

                if (i == 0 && j == j) {

                    fieldBattle[i][j] = forNumberUp;
                    forNumberUp++;


                } else if (i == i && j == 0) {
                    forNumberLeft++;
                    fieldBattle[i][j] = forNumberLeft;


                } else {
                    fieldBattle[i][j] = 0;
                }
            }
        }
        // ЗАПОЛНЕНИЕ ПОЛЯ
        forNumberUp = 0;
        forNumberLeft = 0;
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
        int countThreeShip = 2;
        int countFourShip = 1;
        int choiceAboutShip = 0;

        while (countThreeShip > 0 || countFourShip > 0 || coutnTwoShip > 0 || coutnOneShip > 0) {
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
                    if (Util.toNumber(ShipPositioLeftInput) == null || Util.toNumber(ShipPositionUpInput) == null) {
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

                    if (Util.toNumber(TwoShipPositioLeftInput) == null || Util.toNumber(TwoShipPositionUpInput) == null) {

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
                    if (Util.toNumber(choicePositionInput) == null) {
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

                    if (Util.toNumber(ThreeShipPositioLeftInput) == null || Util.toNumber(ThreeShipPositionUpInput) == null) {

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

                    if (Util.toNumber(choicePositionForThreeShipInput) == null) {
                        out.println("Некоректное число.");
                        break;
                    }

                    int choicePositionThree = Util.toNumber(choicePositionForThreeShipInput);

                    if (choicePositionThree == 2) {
                        position = false;
                    }


                    if (position && ThreeShipPositioLeft >= 3 && fieldPlayer[ThreeShipPositioLeft][ThreeShipPositionUp] != 1 &&
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
                            fieldPlayer[ThreeShipPositioLeft - 2][ThreeShipPositionUp - 1] != 1 &&
                            fieldPlayer[ThreeShipPositioLeft - 3][ThreeShipPositionUp] != 1 &&
                            fieldPlayer[ThreeShipPositioLeft - 3][ThreeShipPositionUp + 1] != 1 &&
                            fieldPlayer[ThreeShipPositioLeft - 3][ThreeShipPositionUp - 1] != 1) {

                        for (int j = ThreeShipPositioLeft; j > ThreeShipPositioLeft - 3; j--) {
                            fieldPlayer[j][ThreeShipPositionUp] = 1;
                        }
                        out.println("\nВы успешно поставили трехпалубный корабль");
                        countThreeShip--;

                    } else if (!position && fieldPlayer[ThreeShipPositioLeft][ThreeShipPositionUp] != 1 &&
                            fieldPlayer[ThreeShipPositioLeft][ThreeShipPositionUp - 1] != 1 &&
                            fieldPlayer[ThreeShipPositioLeft + 1][ThreeShipPositionUp - 1] != 1 &&
                            fieldPlayer[ThreeShipPositioLeft + 1][ThreeShipPositionUp - 1] != 1 &&
                            fieldPlayer[ThreeShipPositioLeft + 1][ThreeShipPositionUp] != 1 &&
                            fieldPlayer[ThreeShipPositioLeft - 1][ThreeShipPositionUp] != 1 &&
                            fieldPlayer[ThreeShipPositioLeft][ThreeShipPositionUp + 1] != 1 &&
                            fieldPlayer[ThreeShipPositioLeft - 1][ThreeShipPositionUp + 1] != 1 &&
                            fieldPlayer[ThreeShipPositioLeft + 1][ThreeShipPositionUp + 1] != 1 &&
                            fieldPlayer[ThreeShipPositioLeft][ThreeShipPositionUp + 2] != 1 &&
                            fieldPlayer[ThreeShipPositioLeft + 1][ThreeShipPositionUp + 2] != 1 &&
                            fieldPlayer[ThreeShipPositioLeft - 1][ThreeShipPositionUp + 2] != 1 && ThreeShipPositionUp < 9 &&
                            fieldPlayer[ThreeShipPositioLeft][ThreeShipPositionUp + 3] != 1 &&
                            fieldPlayer[ThreeShipPositioLeft - 1][ThreeShipPositionUp + 3] != 1 &&
                            fieldPlayer[ThreeShipPositioLeft + 1][ThreeShipPositionUp + 3] != 1
                    ) {
                        for (int j = ThreeShipPositionUp; j < ThreeShipPositionUp + 3; j++) {
                            fieldPlayer[ThreeShipPositioLeft][j] = 1;
                        }
                        out.println("\nВы успешно поставили трехпалубный корабль");
                        countThreeShip--;
                    } else {
                        out.println("Слишком близко к границе или к другому кораблю! Невозможно поставить корабль");
                    }
                    break;

                case 4:


                    if (countFourShip <= 0) {
                        out.println("нельзя ставить четырехпалубный корабль больше 1");
                        break;
                    }
                    boolean positionFour = true;
                    out.println("Укажите координаты СЛЕВА!.");
                    String FourShipPositioLeftInput = in.next();
                    out.println("Укажите координаты СВЕРХУ!.");
                    String FourShipPositionUpInput = in.next();

                    if (Util.toNumber(FourShipPositioLeftInput) == null || Util.toNumber(FourShipPositionUpInput) == null) {

                        out.println("\nНекоректное число");
                        break;
                    }

                    int FourShipPositioLeft = Util.toNumber(FourShipPositioLeftInput);
                    int FourShipPositionUp = Util.toNumber(FourShipPositionUpInput);

                    if ((FourShipPositioLeft > 10 || FourShipPositioLeft <= 0) || (FourShipPositionUp > 10 || FourShipPositionUp <= 0)) {
                        out.println("\nНеверный диапозон.");
                        break;
                    }

                    out.println("1. Вертикально\n2. Горизонтально");

                    String choicePositionForFourShipInput = in.next();

                    if (Util.toNumber(choicePositionForFourShipInput) == null) {
                        out.println("Некоректное число.");
                        break;
                    }

                    int choicePositionFour = Util.toNumber(choicePositionForFourShipInput);

                    if (choicePositionFour == 2) {
                        positionFour = false;
                    }


                    if (positionFour && FourShipPositioLeft >= 4 && fieldPlayer[FourShipPositioLeft][FourShipPositionUp] != 1 &&
                            fieldPlayer[FourShipPositioLeft + 1][FourShipPositionUp] != 1 &&
                            fieldPlayer[FourShipPositioLeft + 1][FourShipPositionUp - 1] != 1 &&
                            fieldPlayer[FourShipPositioLeft + 1][FourShipPositionUp + 1] != 1 &&
                            fieldPlayer[FourShipPositioLeft][FourShipPositionUp + 1] != 1 &&
                            fieldPlayer[FourShipPositioLeft][FourShipPositionUp - 1] != 1 &&
                            fieldPlayer[FourShipPositioLeft - 1][FourShipPositionUp] != 1 &&
                            fieldPlayer[FourShipPositioLeft - 1][FourShipPositionUp - 1] != 1 &&
                            fieldPlayer[FourShipPositioLeft - 1][FourShipPositionUp + 1] != 1 &&
                            fieldPlayer[FourShipPositioLeft - 2][FourShipPositionUp] != 1 &&
                            fieldPlayer[FourShipPositioLeft - 2][FourShipPositionUp] != 1 &&
                            fieldPlayer[FourShipPositioLeft - 2][FourShipPositionUp + 1] != 1 &&
                            fieldPlayer[FourShipPositioLeft - 2][FourShipPositionUp - 1] != 1 &&
                            fieldPlayer[FourShipPositioLeft - 3][FourShipPositionUp] != 1 &&
                            fieldPlayer[FourShipPositioLeft - 3][FourShipPositionUp + 1] != 1 &&
                            fieldPlayer[FourShipPositioLeft - 3][FourShipPositionUp - 1] != 1 &&
                            fieldPlayer[FourShipPositioLeft - 4][FourShipPositionUp] != 1 &&
                            fieldPlayer[FourShipPositioLeft - 4][FourShipPositionUp - 1] != 1 &&
                            fieldPlayer[FourShipPositioLeft - 4][FourShipPositionUp + 1] != 1) {

                        for (int j = FourShipPositioLeft; j > FourShipPositioLeft - 4; j--) {
                            fieldPlayer[j][FourShipPositionUp] = 1;
                        }
                        out.println("\nВы успешно поставили четырехпалубный корабль");
                        countFourShip--;

                    } else if (!positionFour && fieldPlayer[FourShipPositioLeft][FourShipPositionUp] != 1 &&
                            fieldPlayer[FourShipPositioLeft][FourShipPositionUp - 1] != 1 &&
                            fieldPlayer[FourShipPositioLeft + 1][FourShipPositionUp - 1] != 1 &&
                            fieldPlayer[FourShipPositioLeft + 1][FourShipPositionUp - 1] != 1 &&
                            fieldPlayer[FourShipPositioLeft + 1][FourShipPositionUp] != 1 &&
                            fieldPlayer[FourShipPositioLeft - 1][FourShipPositionUp] != 1 &&
                            fieldPlayer[FourShipPositioLeft][FourShipPositionUp + 1] != 1 &&
                            fieldPlayer[FourShipPositioLeft - 1][FourShipPositionUp + 1] != 1 &&
                            fieldPlayer[FourShipPositioLeft + 1][FourShipPositionUp + 1] != 1 &&
                            fieldPlayer[FourShipPositioLeft][FourShipPositionUp + 2] != 1 &&
                            fieldPlayer[FourShipPositioLeft + 1][FourShipPositionUp + 2] != 1 &&
                            fieldPlayer[FourShipPositioLeft - 1][FourShipPositionUp + 2] != 1 && FourShipPositionUp < 8 &&
                            fieldPlayer[FourShipPositioLeft][FourShipPositionUp + 3] != 1 &&
                            fieldPlayer[FourShipPositioLeft - 1][FourShipPositionUp + 3] != 1 &&
                            fieldPlayer[FourShipPositioLeft + 1][FourShipPositionUp + 3] != 1 &&
                            fieldPlayer[FourShipPositioLeft][FourShipPositionUp + 4] != 1 &&
                            fieldPlayer[FourShipPositioLeft - 1][FourShipPositionUp + 4] != 1 &&
                            fieldPlayer[FourShipPositioLeft + 1][FourShipPositionUp + 4] != 1) {
                        for (int j = FourShipPositionUp; j < FourShipPositionUp + 4; j++) {
                            fieldPlayer[FourShipPositioLeft][j] = 1;
                        }
                        out.println("\nВы успешно поставили четырехпалубный корабль");
                        countFourShip--;
                    } else {
                        out.println("Слишком близко к границе или к другому кораблю! Невозможно поставить корабль");
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

        int countOneBOT = 4;
        int countTwoBOT = 3;
        int countThreeBOT = 2;
        int countFourBOT = 1;
        int left = 0;
        int up = 0;
        //Новый Цикл для того чтобы заполнить поле для  бота.
        while (countOneBOT > 0 || countTwoBOT > 0 || countThreeBOT > 0 || countFourBOT > 0) {

            if (countOneBOT > 0) {
                left = 2 + (int) (Math.random() * 8);
                up = 2 + (int) (Math.random() * 8);
                if (fieldBot[left][up] != 1 &&
                        fieldBot[left][up] != 1 &&
                        fieldBot[left - 1][up] != 1 &&
                        fieldBot[left][up + 1] != 1 &&
                        fieldBot[left][up - 1] != 1 &&
                        fieldBot[left + 1][up + 1] != 1 &&
                        fieldBot[left + 1][up - 1] != 1 &&
                        fieldBot[left - 1][up + 1] != 1 &&
                        fieldBot[left - 1][up - 1] != 1 &&
                        left >= 2 && up >= 2) {

                    fieldBot[left][up] = 1;
                    countOneBOT--;
                }

            }

            if (countTwoBOT > 0) {
                left = 2 + (int) (Math.random() * 8);
                up = 2 + (int) (Math.random() * 8);
                if (left >= 2 && fieldBot[left][up] != 1 &&
                        fieldBot[left + 1][up] != 1 &&
                        fieldBot[left + 1][up - 1] != 1 &&
                        fieldBot[left + 1][up + 1] != 1 &&
                        fieldBot[left][up + 1] != 1 &&
                        fieldBot[left][up - 1] != 1 &&
                        fieldBot[left - 1][up] != 1 &&
                        fieldBot[left - 1][up - 1] != 1 &&
                        fieldBot[left - 1][up + 1] != 1 &&
                        fieldBot[left - 2][up] != 1 &&
                        fieldBot[left - 2][up] != 1 &&
                        fieldBot[left - 2][up + 1] != 1 &&
                        fieldBot[left - 2][up - 1] != 1) {

                    for (int j = left; j > left - 2; j--) {
                        fieldBot[j][up] = 1;
                    }
                    countTwoBOT--;
                }

            }

            if (countThreeBOT > 0) {
                left = 2 + (int) (Math.random() * 8);
                up = 2 + (int) (Math.random() * 8);
                if (fieldBot[left][up] != 1 &&
                        fieldBot[left][up - 1] != 1 &&
                        fieldBot[left + 1][up - 1] != 1 &&
                        fieldBot[left + 1][up - 1] != 1 &&
                        fieldBot[left + 1][up] != 1 &&
                        fieldBot[left - 1][up] != 1 &&
                        fieldBot[left][up + 1] != 1 &&
                        fieldBot[left - 1][up + 1] != 1 &&
                        fieldBot[left + 1][up + 1] != 1 &&
                        fieldBot[left][up + 2] != 1 &&
                        fieldBot[left + 1][up + 2] != 1 &&
                        fieldBot[left - 1][up + 2] != 1 && up < 9 &&
                        fieldBot[left][up + 3] != 1 &&
                        fieldBot[left - 1][up + 3] != 1 &&
                        fieldBot[left + 1][up + 3] != 1
                ) {
                    for (int j = up; j < up + 3; j++) {
                        fieldBot[left][j] = 1;
                    }
                    countThreeBOT--;
                }
            }
            if (countFourBOT > 0) {
                left = 2 + (int) (Math.random() * 8);
                up = 2 + (int) (Math.random() * 8);
                if (left >= 4 && fieldBot[left][up] != 1 &&
                        fieldBot[left + 1][up] != 1 &&
                        fieldBot[left + 1][up - 1] != 1 &&
                        fieldBot[left + 1][up + 1] != 1 &&
                        fieldBot[left][up + 1] != 1 &&
                        fieldBot[left][up - 1] != 1 &&
                        fieldBot[left - 1][up] != 1 &&
                        fieldBot[left - 1][up - 1] != 1 &&
                        fieldBot[left - 1][up + 1] != 1 &&
                        fieldBot[left - 2][up] != 1 &&
                        fieldBot[left - 2][up] != 1 &&
                        fieldBot[left - 2][up + 1] != 1 &&
                        fieldBot[left - 2][up - 1] != 1 &&
                        fieldBot[left - 3][up] != 1 &&
                        fieldBot[left - 3][up + 1] != 1 &&
                        fieldBot[left - 3][up - 1] != 1 &&
                        fieldBot[left - 4][up] != 1 &&
                        fieldBot[left - 4][up - 1] != 1 &&
                        fieldBot[left - 4][up + 1] != 1) {

                    for (int j = left; j > left - 4; j--) {
                        fieldBot[j][up] = 1;
                    }

                    countFourBOT--;

                }

            }

        }


        boolean isGameEnd = true;
        boolean turn = true;
        out.println("\nИгра началась");
        while (isGameEnd) {
            if (turn) {
                out.println("Координаты слева");
                String leftCordInput = in.next();
                out.println("Координаты сверху");
                String upCordInput = in.next();
                if (Util.toNumber(leftCordInput) == null || Util.toNumber(upCordInput) == null) {

                    out.println("\nНекоректное число");
                    break;
                }

                int leftCord = Util.toNumber(leftCordInput);
                int upCord = Util.toNumber(upCordInput);

                if ((leftCord > 10 || leftCord <= 0) || (upCord > 10 || upCord <= 0)) {
                    out.println("\nНеверный диапозон.");
                    break;
                }

                if (fieldBot[leftCord][upCord] == 1) {
                    out.println("\nПопадание!");
                    fieldBattle[leftCord][upCord] = 2;
                    ShowField(fieldBattle);
                    turn = true;
                } else {
                    out.println("\nПромах! Ход переходит противнику!");
                    turn = false;

                }

                        } else {
                int leftBotCord = 1 + (int) (Math.random() * 9);
                int upBotCord = 1 + (int) (Math.random() * 9);
                if (fieldPlayer[leftBotCord][upBotCord] == 1) {
                    out.println("\nПо вам попал бот! Он ходит еще раз!");
                    fieldPlayer[leftBotCord][upBotCord] = 2;
                    ShowField(fieldPlayer);
                    turn = false;
                } else {
                    out.println("\nБот промахнулся\n Ход переходит вам\n");
                    turn = true;

                }
                if (!isShipOnField(fieldBot)) {
                    out.println("Игра окончена! Вы выиграли =");
                    isGameEnd = false;
                }
                if (!isShipOnField(fieldPlayer)) {
                    out.println("Вы проирали!");
                    isGameEnd = false;
                }
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


    public static boolean isShipOnField(int[][] field) {
        for (int i = 1; i < 11; i++) {
            for (int j = 1; j < 11; j++) {
                if (field[i][j] == 1) {
                    return true;
                } else {
                    return false;
                }
            }
        }
    return true;

    }

}

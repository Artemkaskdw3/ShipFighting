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
        for (int i = 0; i < 12; i++){
            for (int j = 0; j < 12; j++){

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
        int choiceAboutShip = 0;
        while (true){
            out.println("\nПоставте корабль на поле: \n1. Однопалубный \n2. Двухпалубный \n3. Трехпалубный \n4. Четырехпалубный \n5. ПОКАЗАТЬ ПОЛЕ\n");
            choiceAboutShip = in.nextInt();
            switch (choiceAboutShip){
                case 1:
                    if (coutnOneShip <= 0){
                        out.println("нельзя ставить однопалубный корабль больше 4");
                        break;

                    }

                        out.println("Укажите координаты СЛЕВА!.");
                        int ShipPositioLeft = in.nextInt();
                        out.println("Укажите координаты СВЕРХУ!.");
                        int ShipPositionUp = in.nextInt();
                        if ((ShipPositioLeft  > 10 || ShipPositioLeft <= 0) && (ShipPositionUp > 10 || ShipPositioLeft  <= 0)){
                            out.println("Неверное значение.");
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
                                out.println("\nВы успешно поставили корабль ✓✓✓");

                        }
                        else if(ShipPositioLeft == 1 && ShipPositionUp >= 2 &&
                                fieldPlayer[ShipPositioLeft][ShipPositionUp] != 1 &&
                                fieldPlayer[ShipPositioLeft][ShipPositionUp - 1] != 1 &&
                                fieldPlayer[ShipPositioLeft][ShipPositionUp + 1] != 1 &&
                                fieldPlayer[ShipPositioLeft + 1][ShipPositionUp] != 1 &&
                                fieldPlayer[ShipPositioLeft + 1][ShipPositionUp + 1] != 1 &&
                                fieldPlayer[ShipPositioLeft + 1][ShipPositionUp - 1] != 1){

                            fieldPlayer[ShipPositioLeft][ShipPositionUp] = 1;
                            out.println("\nВы успешно поставили корабль ✓✓✓");

                        }
                        else if(ShipPositioLeft >= 2 && ShipPositionUp == 1 &&
                                fieldPlayer[ShipPositioLeft][ShipPositionUp] != 1 &&
                                fieldPlayer[ShipPositioLeft + 1][ShipPositionUp] != 1 &&
                                fieldPlayer[ShipPositioLeft - 1][ShipPositionUp] != 1 &&
                                fieldPlayer[ShipPositioLeft - 1][ShipPositionUp + 1] != 1 &&
                                fieldPlayer[ShipPositioLeft + 1][ShipPositionUp + 1] != 1 &&
                                fieldPlayer[ShipPositioLeft][ShipPositionUp + 1] != 1){

                            fieldPlayer[ShipPositioLeft][ShipPositionUp] = 1;
                            out.println("\nВы успешно поставили корабль ✓✓✓");

                        }
                        else if(ShipPositioLeft == 1 && ShipPositionUp == 1 &&
                                fieldPlayer[ShipPositioLeft + 1][ShipPositionUp] != 1 &&
                                fieldPlayer[ShipPositioLeft + 1][ShipPositionUp + 1] != 1 &&
                                fieldPlayer[ShipPositioLeft][ShipPositionUp + 1] != 1 ){
                                    fieldPlayer[ShipPositioLeft][ShipPositionUp] = 1;
                                    out.println("\nВы успешно поставили корабль ✓✓✓");
                        }
                        else{
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

                    if (coutnTwoShip <= 0){
                        out.println("нельзя ставить двухпалубный корабль больше 3");
                        break;
                    }

                        out.println("Укажите координаты СЛЕВА!.");
                        int TwoShipPositioLeft = in.nextInt();
                        out.println("Укажите координаты СВЕРХУ!.");
                        int TwoShipPositionUp = in.nextInt();
                        out.println("1. Горизонтально\n2. Вертикально.");
                        int choicePosition = in.nextInt();
                        if (choicePosition == 2){
                            horizontal = false;
                        }

                        if (horizontal && TwoShipPositioLeft >= 2 && fieldPlayer[TwoShipPositioLeft][TwoShipPositionUp] != 1 &&
                                fieldPlayer[TwoShipPositioLeft + 1][TwoShipPositionUp] != 1 &&
                                fieldPlayer[TwoShipPositioLeft + 1][TwoShipPositionUp -1] != 1 &&
                                fieldPlayer[TwoShipPositioLeft + 1][TwoShipPositionUp + 1] != 1 &&
                                fieldPlayer[TwoShipPositioLeft][TwoShipPositionUp + 1] != 1 &&
                                fieldPlayer[TwoShipPositioLeft][TwoShipPositionUp - 1] != 1 &&
                                fieldPlayer[TwoShipPositioLeft - 1][TwoShipPositionUp] != 1 &&
                                fieldPlayer[TwoShipPositioLeft - 1][TwoShipPositionUp - 1] != 1 &&
                                fieldPlayer[TwoShipPositioLeft - 1][TwoShipPositionUp + 1] != 1 &&
                                fieldPlayer[TwoShipPositioLeft - 2][TwoShipPositionUp] != 1 &&
                                fieldPlayer[TwoShipPositioLeft - 2][TwoShipPositionUp] != 1 &&
                                fieldPlayer[TwoShipPositioLeft - 2][TwoShipPositionUp + 1] != 1 &&
                                fieldPlayer[TwoShipPositioLeft - 2][TwoShipPositionUp - 1] != 1){

                                for (int j = TwoShipPositioLeft; j > TwoShipPositioLeft - 2; j--){
                                fieldPlayer[j][TwoShipPositionUp] = 1;
                            }
                                out.println("\nВы успешно поставили двухпалубный корабль ✓✓✓");
                            coutnTwoShip--;

                        }else if(horizontal == false && TwoShipPositionUp >= 2){
                            for (int j = TwoShipPositionUp; j > TwoShipPositionUp - 2; j--){
                                fieldPlayer[TwoShipPositionUp][j] = 1;
                            }
                            out.println("\nВы успешно поставили двухпалубный корабль ✓✓✓");
                            coutnTwoShip--;
                        }
                        else{
                            out.println("Слишком близко к границе или к другому кораблю! Невозможно поставить корабль");
                }
                        break;

                case 5: ShowField(fieldPlayer) ;
                break;
                default: out.println("Некоректный выбор");break;

            }
        }



    }


// ПОКАЗ МАТРИЦЫ
    static void ShowField(int[][]field){
        for (int i = 0; i < 11; i++)
        {
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

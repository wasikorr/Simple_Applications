import java.util.*;


public class main {

    String newLine = System.getProperty("line.separator");


    public static void main(String[] args) {

        List<Integer> numbers = input();
        printNumbers(numbers);
        List <Integer> result = lottery();
        int points = countPoints(numbers,result);
        System.out.println("$$$  Trafiles " + points + " liczb  $$$");



    }

    public static List<Integer> input() {

        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();

        int tempNumber;
        for (int i = 0; i < 6; i++) {

            boolean correctness = false;

            System.out.println("Podaj " + (i + 1) + " liczbe:");
            while (!correctness) {

                //sprawdzenie czy zostala podana liczba calkowita
                while (!scanner.hasNextInt()) {
                    scanner.next();
                    System.out.println("Nie podales liczby. Podaj liczbe:");
                }

                tempNumber = scanner.nextInt();
                scanner.nextLine();

                //sprawdzenie czy nie podalismy wybranej juz liczby
                boolean repeated = false;

                for(Integer num : numbers){
                    if(tempNumber == num){
                        repeated = true;
                        break;
                    }
                }



                //sprawdzamy czy liczba miesci sie w zakresie 1-49
                if (tempNumber > 49 || tempNumber < 1 || repeated) {
                    System.out.println("Liczba spoza zakresu 1-49 lub zostala juz podana. Podaj liczbę:");
                    continue;
                }

                //jesli powyzsze warunki niespelnione zaakceptuj liczbe
				else{
                    numbers.add(tempNumber);
                    correctness = true;
                }
            }
        }
        return numbers;
    }

    public static void printNumbers(List<Integer> list) {
        Collections.sort(list);
        System.out.println("---Wytypowane liczby---");
        for (int number : list) {
            System.out.print(number + " ");
        }
        System.out.println();

    }

    public static List<Integer> lottery(){

        List<Integer> options = new ArrayList<Integer>();
        for(int i=1 ; i<= 49; i++){
            options.add(i);
        }

        //losowanie
        Collections.shuffle(options);

        List<Integer> result = new ArrayList<Integer>();
        System.out.println("---W dzisiejszej kumulacji wygrywajace liczby to--- ");
        for(int i=0;i<6;i++){

           //wstrzymaj program na 2 sekundy
            try {
                Thread.sleep(2000);                 //1000 milliseconds is one second.
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }

            int number = options.get(i);
            System.out.print(number + " ");
            result.add(number);
        }
        System.out.println();

        return result;

    }

    public static int countPoints(List<Integer> numbers, List<Integer> result){

        int points = 0;

        for(Integer num : result){
            for(Integer num2 : numbers){
                if(num == num2)
                    points++;
            }
        }

        return points;
    }


}
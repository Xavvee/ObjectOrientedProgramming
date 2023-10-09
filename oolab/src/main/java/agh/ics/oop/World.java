package agh.ics.oop;

public class World {
    public static void main(String[] args){
        System.out.println("System wystartował.");
        run(args);
        System.out.println("System zakończył działanie.");
    }

    static void run(String[] arr){
        System.out.println("Zwierzak idzie do przodu.");
        if(arr.length >0) {
            for (int i = 0; i < arr.length - 1; i++) {
                System.out.print(arr[i] + ", ");
            }
            System.out.println(arr[arr.length - 1]);
        }
    }
}


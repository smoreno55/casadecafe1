package com.example.casadelcafe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundl
        package hoteltest;
// Objeto de habitación
public class Room {
    int roomnum;
    String type;
    boolean statu;


    public Room() {
        super();
    }


    public Room(int roomnum) {
        super();
        this.roomnum = roomnum;
    }


    public Room(int roomnum, String type) {
        super();
        this.roomnum = roomnum;
        this.type = type;
    }


    public Room(int roomnum, String type, boolean statu) {
        super();
        this.roomnum = roomnum;
        this.type = type;
        this.statu = statu;
    }


    @Override
    public String toString() {
        return "número de habitación" + roomnum + ", Tipo de habitación" + type + ", ¿Es el ocupante de la habitación" + statu;
    }


}
package com.example.casadelcafe;

public class Hotel {
    Room[][] room;

    // Crear método
    public Hotel() {
        super();
    }

    public Hotel(int a) {// a representa el número de pisos
        this.room = new Room[a][];
    }

    public Hotel(int a,int b) {// b representa el número de habitaciones en el piso a
        this.room = new Room[a][b];
    }

    //Reservar una habitación
    public void inroom(int roomnum) {
        int a = (roomnum / 100) - 1;// a representa el número de pisos. Debido a que el índice de la matriz comienza desde cero, se debe restar uno
        int b = (roomnum % 100) - 1;// b representa el número de habitación porque el índice de la matriz comienza desde cero, por lo que se resta uno
        if(room[a][b].statu == true) {// Juzga si la habitación se puede reservar.
            System.out.println("¡Esta habitación ya ha sido reservada!");
            return ;
        }
        room[a][b].statu = true;
    }


    //revisa
    public void outroom(int roomnum) {
        int a = (roomnum / 100) - 1;// a representa el número de pisos. Debido a que el índice de la matriz comienza desde cero, se debe restar uno
        int b = (roomnum % 100) - 1;// b representa el número de habitación porque el índice de la matriz comienza desde cero, por lo que se resta uno
        if(room[a][b].statu == false) {// Juzga si la habitación se puede reservar.
            System.out.println("Es posible que haya ingresado un error. ¡Nadie vive en esta habitación y no puede darse de baja!");
            return ;
        }
        room[a][b].statu = false;
    }

    // Imprime el estado de todas las habitaciones
    public void printroom() {
        // Recorre toda la información de la habitación, usando dos bucles for
        for(int i = 0 ; i < room.length ; i++) {
            for(int j = 0 ; j < room[i].length ; j++) {
                System.out.println(room[i][j]);
            }
        }

    }

}
package com.example.casadelcafe;
        import java.util.Scanner;

public class Hoteltest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub


        Scanner sc = new Scanner(System.in);
        // Crear hotel
        System.out.println("Por favor ingrese las especificaciones de su hotel (número de pisos, número de habitaciones en cada piso):");
        int floor,number;// Número y número de capas
        floor = sc.nextInt();
        number = sc.nextInt();
        Hotel hotel = new Hotel(floor,number);// Creó un objeto de hotel
        Room[][] room = hotel.room;// Cree una matriz de habitaciones para almacenar información sobre las habitaciones.

        // Inicializar la información de la matriz de habitaciones de hotel
        for(int i = 0 ; i < room.length ; i++) {//Número de habitaciones
            for(int j = 0 ; j < room[i].length ; j++) {// Número de habitación en cada piso
                Room rooms = new Room();// Crear objeto de habitación
                room[i][j] = rooms;// Asignar el objeto habitación a la matriz de habitaciones
                rooms.roomnum = (i + 1) * 100 + (j + 1); // Asignar el roomnum del objeto room
                rooms.statu = false;// Asignar el estado de la vivienda de cada habitación como vacía
                rooms.type = " " + (i + 1) + "Suelo";
            }
        }


        // Comprueba si la información de la habitación es correcta
        //hotel.printroom();



        // Usa el sistema
        int num,num1;// num es el número de habitación num1 se usa para juzgar la función
        for(;;) {
            System.out.println("Recordatorio: (1 Reserve una habitación 2 Eche un vistazo 3 Imprima la información de la habitación 4 Salga)");
            System.out.print("Por favor ingrese el número:");
            // Clase de escáner. Debe importarse antes de su uso. En otras palabras, agregue import java.util.Scanner al frente del código; eso es todo.
            num1 = sc.nextInt();


            if(num1 == 1) {//Reservar una habitación
                System.out.print("Introduzca el número de habitación (por ejemplo: 205, 909, 1205, etc.):");
                num = sc.nextInt();
                if((num % 100) > number || (num / 100) > floor) {// Juzgando si el número de habitación ingresado es correcto, cuando el número de pisos excede o el número de habitaciones excede sí, se generará un error directamente
                    System.out.println("¡¡¡Ingresó el número de habitación equivocado, por favor vuelva a ingresar !!!");
                }else {
                    hotel.inroom(num);
                }
            }else if(num1 == 2) {//revisa
                System.out.print("Introduzca el número de habitación (por ejemplo: 205, 909, 1205, etc.):");
                num = sc.nextInt();
                if((num % 100) > number || (num / 100) > floor) {// Juzgando si el número de habitación ingresado es correcto, cuando el número de pisos excede o el número de habitaciones excede sí, se generará un error directamente
                    System.out.println("¡¡¡Ingresó el número de habitación equivocado, por favor vuelva a ingresar !!!");
                }else {
                    hotel.outroom(num);
                }
            }else if(num1 == 3) {// Imprimir información de la sala
                hotel.printroom();
            }else if(num1 == 4) {
                break;
            }else {
                System.out.println("Ha ingresado los datos incorrectos");
            }
        }


    }

}

}
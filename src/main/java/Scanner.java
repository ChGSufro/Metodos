public class Scanner {

    public static void main(String[] args) {
        menu();
        b_();
    }

    public static int lecturaInt(){
        java.util.Scanner leer = new java.util.Scanner(System.in);
        return leer.nextInt();
    }

    public static Double lecturaDouble(){
        java.util.Scanner leer = new java.util.Scanner(System.in);
        return leer.nextDouble();
    }

    public static String lecturaString(){
        java.util.Scanner leer = new java.util.Scanner(System.in);
        return leer.nextLine();
    }

    public static Boolean lecturaBolean(){
        java.util.Scanner leer = new java.util.Scanner(System.in);
        return leer.nextBoolean();
    }

    public static Long lecturaLong(){
        java.util.Scanner leer = new java.util.Scanner(System.in);
        return leer.nextLong();
    }

    //Menu
    public static void printMenu(){
        System.out.println("""
                \tMenu
                
                Seleccione una opcion:
                [0]Salir
                [1]Ejemplo""");
    }

    public static void menu(){
        String resp;

        do {
            printMenu();
            resp = lecturaString();

            switch (resp){
            }

        } while(!resp.equals("0"));
    }

    public static void b_(){
        try{
            int num = lecturaInt();//ejemplo, cambiar por metodo

        } catch (Exception error){
            System.out.println("Valor no valido");
        }
    }

}

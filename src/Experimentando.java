//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Experimentando {
    public static void main(String[] args) {
        String name = "procesos";
        String comparacion = "procesos";
        int l = 1;
        while ( name == comparacion){
            System.out.println("ok - es igual");
            l++;
            System.out.println(name +  l +"😀");
            if (l == 10) {
                break;
            }
        }
        System.out.println("FUERA ✅✅✅✅✅✅✅✅✅✅✅✅✅✅✅✅✅✅✅✅✅✅✅✅✅✅✅✅✅✅✅✅");
        String Jugadores [] = {"nada","Messi", "Vinicius", "Benzema", "Haland", "CR7"};
        for (int i = 1; i <Jugadores.length; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("---------------------------------------------------------Jugador :  " + i + " 😁" + Jugadores[i]);
            if ( i == 1) {
                System.out.println("Ganancias por dia");
                String semna [] = {"lunes", "martes", "miercoles", "jueves", "viernes", "sabado", "domingo"};
                for (int j = 0; j < semna.length; j++) {
                        int dia = j + 1;
                        int interes = 10;
                        double ok = dia * interes;
                        System.out.println(dia + "--"  + semna[j]);
                    System.out.println("💶💶: Euros obtenidos: " + ok +" €€€€€€€€€€€€€€€€€€€:");

                    }

            } else if (i == 2) {
                System.out.println("No money");
            } else if (i == 3) {
                System.out.println("el tercero--- Sin money");
            } else if (i == 4) {
                System.out.println("el cuarto----500k€");
            }
        }

    }
}
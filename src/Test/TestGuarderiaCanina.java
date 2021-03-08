package Test;

import Utiles.Validaciones;

public class TestGuarderiaCanina {

    private static String[] Raza;
    private static int codPerro;

    public static void main(String[] args) {
        int opcion, capPerro, codPerro = 0;
        Perro[] BaseDeDatosPerros;
        System.out.println("Ingrese la Capacidad de Perros que Posee la Guarderia");
        capPerro = TecladoIn.readLineInt();
        BaseDeDatosPerros = new Perro[capPerro];
        MenuPrincipal();
        opcion = TecladoIn.readLineInt();
        while (opcion != 6) {

            switch (opcion) {
                case 1:
                    if (codPerro < capPerro) {

                        BaseDeDatosPerros[codPerro] = CargarPerro(capPerro);
                        System.out.println("..........................................");
                      
                        System.out.println("El codigo del perro reciien ingresado es :"+codPerro);
                        System.out.println("..........................................");
                        codPerro++;
                    } else {
                        System.out.println("..........................................");
                        System.out.println("Capacidad Llena");
                        System.out.println("..........................................");
                    }

                    break;

                case 2: 
                    System.out.println("...............................................................................................");
                    System.out.println("La cantidad de perros de la raza y genero que usted selecciono es  :"+BuscarPerrox(BaseDeDatosPerros, Raza, codPerro));
                    System.out.println("...............................................................................................");
                    break;
                case 3:
                    MostrarPerrosSegunFecha(BaseDeDatosPerros, capPerro);
                    break;
                case 4:                    
                    MostrarPerroSegunEstadia(BaseDeDatosPerros, codPerro);
                    break;
                case 5:
                    MostrarPerroSegunCodigo(BaseDeDatosPerros);
                    break;
            }
            MenuPrincipal();
            opcion = TecladoIn.readLineInt();
        }
        System.out.println("Gracias Por utilizar el Sistema De Guarderia de Perros");

    }

    public static String TiposDeRaza(int razaPerro) {
        //Menu de tipos de Razas
        String tipoRaza;
        String[] razas = {"Bulldog", "Husky siberiano", "Labrador", "Golden retriever", "Beagle", "Bóxer", "Dogo", "Gran danés", "Scooby-Doo", "Bolt", "Ovejero", "Pitbull"};
        tipoRaza = razas[razaPerro];
        return tipoRaza;
    }

    public static void MenuPrincipal() {
        //Menu de Opciones de la Guarderia
        System.out.println("Ingrese Opcion deseada :.\n"
                + "1. Ingresar un perro a la guardería.\n"
                + "2. Contar cuántos Perros de la raza y el Genero deceado hay o pasaron por la guardería durante el verano.\n"
                + "3. Listar todos los perros (con su respectiva información) que ingresaron en una determinada fecha.\n"
                + "4. Listar todos los Perrros de la Raza que decea con estadía mayor a 20 días.\n"
                + "5. Dado el código de un perro, informar los datos de su dueño.\n"
                + "6. Terminar.\n"
                +"______________________________________________________________________________________________________________"
                
        );

    }

    public static void MenuRaza() {
        //Menu de razas
        System.out.println("_______________________________________________");
        System.out.println("Ingrese la raza del perro.\n"
                + "1. Bulldog.\n"
                + "2. Husky siberiano .\n"
                + "3. Labrador.\n"
                + "4. Golden retriever.\n"
                + "5. Beagle.\n"
                + "6. Bóxer.\n"
                + "7. Dogo.\n"
                + "8. Gran danés.\n"
                + "9. Scooby-Doo.\n"
                + "10.Bolt.\n"
                + "11. Ovejero.\n"
                + "12. Pitbull.\n");
           System.out.println("_______________________________________________");

    }

    public static boolean ValidacionDeGenero(char generoPerro) {
        //Este modulo verifica que el Genero del Animal Ingresado sea valido
        boolean validacionGenero = false;
        if ((generoPerro == 'H') || (generoPerro == 'h') || (generoPerro == 'M') || (generoPerro == 'm')) {
            validacionGenero = true;

        }
        return validacionGenero;
    }

    public static Perro CargarPerro(int capPerro) {
        //Este Modulo Permite Cargar un Perro nuevo ala guarderia pidiendole los datos necesarios 
        //los cuales luego son verificados para corroborar que sean validos
        boolean condicion = false;
        int razaPerro, diaIngreso, mesIngreso, anioIngreso, diasDeEstadia;
        char generoPerro;
        String nombrePerro, nombreCliente, numCliente;
        Perro nuevoPerro;
        Fecha fechaIngreso;
        nuevoPerro = new Perro(codPerro);
        System.out.println("Ingrese el nombre del perro");
        nombrePerro = TecladoIn.readLine();
        nuevoPerro.setNombre(nombrePerro);

        do {
            System.out.println("Ingrese el Genero de perro : Macho(M),Hembra (H)");
            generoPerro = TecladoIn.readLineNonwhiteChar();

            if (ValidacionDeGenero(generoPerro)) {
                nuevoPerro.setGenero(generoPerro);
                condicion = true;
            } else {
                System.out.println("Ingrese un Genero Correcto: Macho('M') o Hembra ('H')");
                System.out.println(".......................................................");
                condicion = false;
            }
        } while (condicion != true);

        condicion = false;

        do {
            MenuRaza();
            razaPerro = TecladoIn.readLineInt();
            if ((razaPerro > 0) && (razaPerro < 13)) {
                nuevoPerro.setRaza(TiposDeRaza(razaPerro - 1));
                condicion = true;
            } else {
                System.out.println("Ingrese una raza Correcta del 1 al 12.");
                System.out.println(".........................................");
                condicion = false;
            }

        } while (condicion != true);
        condicion = false;

        do {
            System.out.println("Ingrese una fecha.\n"
                    + "Ingrese Dia: ");
            diaIngreso = TecladoIn.readInt();
            System.out.println("Ingrese el Mes: ");
            mesIngreso = TecladoIn.readLineInt();
            System.out.println("Ingrese el año: ");
            anioIngreso = TecladoIn.readInt();
            if (Validaciones.esValidoDatosFecha(diaIngreso, mesIngreso, anioIngreso)) {
                fechaIngreso = new Fecha(diaIngreso, mesIngreso, anioIngreso);
                nuevoPerro.setFechaIngreso(fechaIngreso);
                condicion = true;
            } else {
                System.out.println("Ingrese Una Fecha Correcta:  Dia/Mes/Año");
                System.out.println("...........................................");
            }
        } while (condicion != true);
        condicion = false;

        do {
            System.out.println("Ingrese la Cantidad de estadia:");
            diasDeEstadia = TecladoIn.readLineInt();
            if (diasDeEstadia > 0) {
                nuevoPerro.setCantDias(diasDeEstadia);
                System.out.println("Ingrese el Nombre y Apellido del Cliente");
                nombreCliente = TecladoIn.readLine();
                nuevoPerro.setNombreDuenio(nombreCliente);
                System.out.println("Ingrese Numero de telefono");
                numCliente = TecladoIn.readLine();
                nuevoPerro.setTelefonoDuenio(numCliente);
                codPerro++;
                condicion = true;

            } else {
                System.out.println("Ingrese una cantidad de dias mayor a 0");
                System.out.println(".........................................");
                condicion = false;
            }

        } while (condicion != true);

        return nuevoPerro;
    }

    public static int BuscarPerrox(Perro BaseDeDatosPerros[], String razas[], int codPerro) {
        //Este modulo Busca en el Arreglo BaseDeDatosPerro, el Perro segun el Genero y la Raza deceada e ingresada por el usuario.
        int cont = 0;
        boolean condicion = false;
        char generoPerro, generoPerr, generPerro = 'd';
        String razaPerr, tipoRaza;
        do {
            System.out.println("Ingrese el Genero de perro : Macho(M),Hembra (H)");
            generoPerro = TecladoIn.readLineNonwhiteChar();

            if (ValidacionDeGenero(generoPerro)) {
                generPerro = generoPerro;
                condicion = true;
            } else {
                System.out.println(".......................................................");
                System.out.println("Ingrese un Genero Correcto: Macho('M') o Hembra ('H')");
                System.out.println(".......................................................");
                condicion = false;
            }
        } while (condicion != true);
        
        tipoRaza=IngresarRazaCorrecta();
        
        for (int i = 0; i < codPerro; i++) {
            razaPerr = BaseDeDatosPerros[i].getRaza();
            generoPerr = BaseDeDatosPerros[i].getGenero();

            if (tipoRaza.equals(razaPerr) && (generPerro == generoPerr)) {
                cont++;
            }

        }

    

    return cont;}

    public static void MostrarPerro(Perro BaseDeDatosPerros[], int codPerro) {
        //El modulo muestra la Informacion 

        for (int i = 0; i < codPerro; i++) {
            System.out.println(BaseDeDatosPerros[i].toString());
        }

    }
    
    public static Fecha IngresarFecha(){
        //El modulo crea una fecha segun los datos ingresados y verifica que sea una fecha Valida.
    int diaIngreso, mesIngreso,anioIngreso;
    Fecha fechaIngreso = null;
    boolean condicion=false;
    
     do {
            System.out.println("Ingrese una fecha.\n"
                    + "Ingrese Dia: ");
            diaIngreso = TecladoIn.readInt();
            System.out.println("Ingrese el Mes: ");
            mesIngreso = TecladoIn.readLineInt();
            System.out.println("Ingrese el año: ");
            anioIngreso = TecladoIn.readInt();
            if (Validaciones.esValidoDatosFecha(diaIngreso, mesIngreso, anioIngreso)) {
                fechaIngreso = new Fecha(diaIngreso, mesIngreso, anioIngreso);
                
                condicion = true;
            } else {
                System.out.println("...........................................");
                System.out.println("Ingrese Una Fecha Correcta:  Dia/Mes/Año");
                System.out.println("...........................................");
            }
        } while (condicion != true);
    
    return fechaIngreso;}
    
    public static void MostrarPerrosSegunFecha(Perro BaseDeDatosPerros[], int capPerro) {
        //El modulo muestra Toda la Informacion del Perro segun la Fecha ingresada por el usuario.
         Fecha fechaIngreso,fecha2;
         fechaIngreso=IngresarFecha();
         for (int i = 0; i < capPerro; i++) {
             fecha2=BaseDeDatosPerros[i].getFechaIngreso();
            if (fechaIngreso.equals(fecha2)) {
            System.out.println("____________________________________________");
            System.out.println(BaseDeDatosPerros[i].toString());
            System.out.println("____________________________________________");
            } 
        }
    }
     
    public static void MostrarPerroSegunCodigo( Perro BaseDeDatosPerros[]){
              //El modulo muestra Toda la Informacion del Perro segun el codigo ingresado por el usuario.
     int codigo;
         System.out.println("Ingrese el codigo del perro del cual decea saber la informacion");
            codigo=TecladoIn.readLineInt();
            System.out.println("____________________________________________");
            System.out.println("El nombre del Dueño es: "+BaseDeDatosPerros[codigo].getNombreDuenio());
            System.out.println("El telefono del Dueño es :"+BaseDeDatosPerros[codigo].getTelefonoDuenio());
            System.out.println("____________________________________________");
     
     }
    
    public static String IngresarRazaCorrecta (){
        //El modulo verifica que el usuario ingrese una raza correcta.
        boolean condicion;
        int razaPerro;
        String razaElegida="";
        do {
            MenuRaza();
            razaPerro = TecladoIn.readLineInt();
            if ((razaPerro > 0) && (razaPerro < 13)) {
                razaElegida=TiposDeRaza(razaPerro - 1);
                condicion = true;
            } else {
                System.out.println("Ingrese una raza Correcta del 1 al 12.");
                System.out.println(".........................................");
                condicion = false;
            }
        } while (condicion != true);
    return razaElegida;}
    
    public static void MostrarPerroSegunEstadia(Perro BaseDeDatosPerros[], int codPerro){
        //El modulo nos muestra el o los perros que coincidan con la raza deceada e ingresada por el usuario 
        //y cumplan con la condicion de que su estadia sea mayor a 20
     String razaDeceada, razaPerro;
     int diasDeEstadia;   
        razaDeceada=IngresarRazaCorrecta();
            
        for (int i = 0; i < codPerro; i++) {
            razaPerro=BaseDeDatosPerros[i].getRaza();
            diasDeEstadia=BaseDeDatosPerros[i].getCantDias();
            if (razaDeceada.equalsIgnoreCase(razaPerro)&&(diasDeEstadia>20)) {
            System.out.println("____________________________________________");
            System.out.println(BaseDeDatosPerros[i].toString());
            System.out.println("____________________________________________");
                
            }
        }
    
    }
}

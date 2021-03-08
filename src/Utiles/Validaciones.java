package Utiles;

public class Validaciones {

public static boolean esPrimo (int numero) {
// Un número primo es un número natural mayor que 1,
// que tiene únicamente dos divisores distintos: él mismo y el 1.
	//Precondicion n >1

  int contador = 2;
  boolean primo=true;
  int limite = (int)Math.sqrt(numero);
  while ((primo) && (contador<=limite)){
    if (numero % contador == 0)
      primo = false;
    else
      contador++;
  }
  return primo;

}

public static boolean esNumeroEntero(String cadena){
        // Verifica que cadena contenga un numero entero
 
        boolean band = false;
        int i = 0;
        if (cadena.length() >0) //cadena no vacia
            band = true;
            while ((i < cadena.length())&& band){
                if((cadena.charAt(i)>='0')&&(cadena.charAt(i)<='9'))
                        i++;
                else
                        band = false;
            }
        return band;
}

public static boolean esFraccion (String cadena){
// verifica que cadena tiene la forma xx/xx donde xx es un entero
boolean band=false;

if (cadena.indexOf("/")>0)  // es fraccion

     if (esNumeroEntero(cadena.substring(0,cadena.indexOf("/")))
         && esNumeroEntero(cadena.substring(cadena.indexOf("/")+1)))
         band = true;

return band;
}
/* Verifica si el anio ingresado por paramero es bisiesto.
 * Para ello debe considerar que el anio tiene que ser:
 *  anio multiplo  400 or (anio multiplo de 4 && no multiplo de 100)
 */
public static boolean esAnioBisiesto(int aa){
	return (((aa%400) == 0)|| ((aa%4) == 0 && (aa%100)!=0));
}

/* verifica si los dias son validos para el mes dado,
 * considerando el caso de los anios bisiestos.
 */
public static boolean esValidoDatosFecha(int dd, int mm, int aa){

	int[] diasPorMes= {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

	boolean resultado = false;

                if (dd < 1 || mm < 1 || mm > 12 || aa < 1900)
                    resultado = false;
                else
                    if (mm!= 2)
                        resultado =(dd<= diasPorMes[mm-1]);
                    else
                        if (esAnioBisiesto(aa))
                             resultado= ((dd<= diasPorMes[mm-1]+1));
			else
                             resultado=((dd<= diasPorMes[mm-1]));

    return resultado;
			}

public static void main (String [] arg){
    String c = "12";
    System.out.println("valido "+c+" "+esNumeroEntero(c));
}

}

package co.com.sofka.exercise_3;

import java.util.function.BiFunction;
import java.util.logging.Logger;

/**
 * Clase principal para calcular derivadas e integrales
 *
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @version 1.0.0 2022-07-13
 * @since 1.0.0
 */
public class Exercise3 {

    private static final Logger log = Logger.getLogger("MyLogger");

    private Double coeficiente;
    private Double potencia;
    private Double x;
    private Double xc;
    private Double xp;
    private Double numero;

    public void OperacionesCalculo(Double coeficiente, Double potencia) {
        this.coeficiente = coeficiente;
        this.potencia = potencia;
        this.x = 0.0;
        this.xc = 0.0;
        this.xp = 0.0;
        this.numero = 1.0;
    }

    /**
     * Método para calcular derivada
     * @return Resultado
     */
    public String calcularDerivada() {
        BiFunction<Double, Double, Double> xc = (coeficiente, potencia) -> coeficiente * potencia;
        BiFunction<Double, Double, Double> xp = (numero, potencia) -> potencia - numero;
        return "La derivada es: " + xc.apply(coeficiente, potencia) + "x^" + xp.apply(numero, potencia) + "\n";
    }

    /**
     * Método para calcular integral
     * @return Resultado
     */
    public String calcularIntegral() {
        BiFunction<Double, Double, Double> xp = Double::sum;
        BiFunction<Double, Double, Double> xc = (coeficiente, potencia) -> coeficiente / xp.apply(numero, potencia);
        return "La Integral es: " + xc.apply(coeficiente, potencia) + "x^" + xp.apply(numero, potencia) + "\n";
    }

    public static void main(String[] args) {
        Exercise3 exercise3 = new Exercise3();
        exercise3.OperacionesCalculo(5.0, 2.0);
        log.info(exercise3.calcularDerivada());
        log.info(exercise3.calcularIntegral());
    }
}

package co.com.sofka.exercise_1;

import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Clase principal con los métodos para los correos
 *
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @version 1.0.0 2022-07-13
 * @since 1.0.0
 */
public class Exercise1 {

    private static final Logger log = Logger.getLogger("MyLogger");

    /**
     * Método para diferenciar correos repetidos
     * @param list Lista de correos
     */
    private static void emailDistinct(List<Email> list) {
        Flux.fromIterable(list)
                .distinct(Email::getDomain)
                .subscribe(email -> log.info(email.toString()));
    }

    /**
     * Método para filtrar correos por dominio
     * @param list Lista de correos
     * @param dominio Dominio a filtar
     */
    private static void emailFilteredByDominio(List<Email> list, String dominio) {
        Flux<Email> emailDominio = Flux.fromIterable(list)
                .filter(email -> email.getDomain().contains(dominio));
        emailDominio.count().subscribe(element -> log.info("Cantidad de correos " + dominio + ": " + element));
        emailDominio.subscribe(element -> log.info(element.toString()));
    }

    /**
     * Método para validar el dominio del correo
     * @param list Lista de correos
     */
    private static void emailDomainCorrect(List<Email> list) {
        Flux.fromIterable(list)
                .map(email -> email.getDomain().matches("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b")
                        ? "Correo valido: " + email : "Correo invalido: " + email)
                .subscribe(log::info);
    }

    /**
     * Método para contar los correos validos
     * @param list Lista de correos
     */
    private static void emailCount(List<Email> list) {
        Flux<Email> emailCount = Flux.fromIterable(list)
                .filter(email -> email.getDomain().matches("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b"));
        emailCount.count().subscribe(element -> log.info("Cantidad de correos: " + element));
    }

    /**
     * Método para evaluar el estado del correo
     * @param list Lista de correos
     */
    private static void emailStatus(List<Email> list) {
        Flux.fromIterable(list)
                .filter(Email::getStatus)
                .subscribe(ele -> log.info(ele.toString()));
    }

    public static void main(String[] args) {

        List<Email> listEmails = new ArrayList<>();
        listEmails.add(new Email(1, "raul@gmail.com", true));
        listEmails.add(new Email(2, "edgar@hotmail.com", false));
        listEmails.add(new Email(3, "ricardo@gmail.com", false));
        listEmails.add(new Email(4, "lis@outlook.com", true));
        listEmails.add(new Email(5, "raul@gmail.com", true));
        listEmails.add(new Email(6, "dicson@outlook.com", false));
        listEmails.add(new Email(7, "dimar@hotcom", true));
        listEmails.add(new Email(8, "laurahotmail.com", true));
        listEmails.add(new Email(9, "dicson@outlook.com", true));
        listEmails.add(new Email(10, "edgar@gmail.com", false));
        listEmails.add(new Email(11, "luisa@gmailcom", true));
        listEmails.add(new Email(12, "daniel@hotmail.com", false));
        listEmails.add(new Email(13, "felipe@hotmail.com", true));
        listEmails.add(new Email(14, "juan@gmailom", true));
        listEmails.add(new Email(15, "esteban@.com", true));
        listEmails.add(new Email(16, "jhon@gmail.com", false));
        listEmails.add(new Email(17, "laura@hotmail.com", false));
        listEmails.add(new Email(18, "lorena@gmail.com", true));
        listEmails.add(new Email(19, "jhony@outlook.com", true));
        listEmails.add(new Email(20, "santiago@gmail.com", false));
        listEmails.add(new Email(21, "danilo@gmail.com", true));
        listEmails.add(new Email(22, "peter@hotmail.com", false));
        listEmails.add(new Email(23, "felipe@hotmail.com", true));
        listEmails.add(new Email(24, "hernan@outlook.com", true));
        listEmails.add(new Email(25, "edward@outlook.com", false));
        listEmails.add(new Email(26, "manuel@outlook.com", true));
        listEmails.add(new Email(27, "mauriciogmail..com", false));
        listEmails.add(new Email(28, "sara@gmail.com", true));
        listEmails.add(new Email(29, "laura@hotmail.com", true));
        listEmails.add(new Email(30, "doris@gmail.com", true));

        log.info("Correos sin repetir");
        emailDistinct(listEmails);
        emailFilteredByDominio(listEmails, "@gmail.com");
        emailFilteredByDominio(listEmails, "@hotmail.com");
        emailFilteredByDominio(listEmails, "@outlook.com");
        emailDomainCorrect(listEmails);
        emailCount(listEmails);
        log.info("Correos enviados");
        emailStatus(listEmails);
    }
}

package co.com.sofka.exercise_2;

import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class Exercise2 {

    private static final Logger log = Logger.getLogger("MyLogger");


    public static void main(String[] args) {

        List<String> badWords = List.of("hijueputa", "marica", "malparido", "guevon", "mierda", "gonorrea", "pirobo");
        String messageInput;

        do {
            log.info("Ingrese un mensaje, de lo contrario escriba salir");
            Scanner scanner = new Scanner(System.in);
            messageInput = scanner.nextLine();
            List<String> listMessage = List.of(messageInput.split(" "));
            Flux<String> wordsMessage = Flux.fromIterable(listMessage)
                    .map(word -> {
                                if (badWords.contains(word)) return "****";
                                return word;
                            }
                    );
            wordsMessage.subscribe(words -> System.out.print(" " + words));
        } while (!messageInput.contains("salir"));
    }
}

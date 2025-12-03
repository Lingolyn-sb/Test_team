import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
public class FF {
    static Scanner sc = new Scanner(System.in);
    static String usuario;
    static String nnombre;
    static String allnombre;
    static String nivel;
    static int nivelSpellingBee;

    static int aciertos = 0;
    static int errores = 0;
    static int[] palabrasFalladas = new int[10];
    static int contadorFallos = 0;
    static int[] pistaUsada = new int[10];
    static Random random = new Random();

    static final String[] PALABRAS_BASE = {};
    static String[] PALABRAS_JUEGO = PALABRAS_BASE;
    static String[][] PALABRAS_VOCABULARIO;
    static String[][] PALABRAS_RELACIONADAS;
    static String[][] COMPLETAR_ORACIONES;
    static String[][] ADIVINAR_PALABRAS;
    static String palabraSecreta;
    static char[] palabraAdivinada;
    static char[] letrasIncorrectas = new char[6];
    static int contadorIncorrectas = 0;
    static final int INTENTOS_MAXIMOS = 6;

     /*DECLARACION DE NIVELES SPELLING BEE PARA MODALIDAD TRACIONAL*/
    static String [][] nsbBasico = { {"          add", "          Complete the sentence with the correct English word:\n          Please ___ the numbers to get the result.", "          Read the definition and write the correct English word:\n          To combine two or more numbers.", "          Write the English word for this Spanish meaning:\n          Agregar"}, {"          eye", "          Complete the sentence with the correct English word:\n          She closed one ___.", "          Read the definition and write the correct English word:\n          The organ you use to see.", "          Write the English word for this Spanish meaning:\n          Ojo"}, {"          ear", "          Complete the sentence with the correct English word:\n          He whispered the secret into my ___.", "          Read the definition and write the correct English word:\n          The organ you use to hear sounds.", "          Write the English word for this Spanish meaning: \n          Oreja"}, {"          boat", "          Complete the sentence with the correct English word:\n          We crossed the lake in a small ___.", "          Read the definition and write the correct English word:\n          A vehicle used to travel on water.", "          Write the English word for this Spanish meaning: \nBarco"}, {"happy", "          Complete the sentence with the correct English word:\n          She felt very ___ on her birthday.", "           the definition and write the correct English word:\n          Feeling joy or pleasure.", "          Write the English word for this Spanish meaning: \n          Feliz"}, {"          lion", "          Complete the sentence with the correct English word:\n          The ___ is known as the king of the jungle.", "Read the definition and write the correct English word:\n          A large wild cat with a mane.", "          Write the English word for this Spanish meaning: \n          León"}, {"          night", "          Complete the sentence with the correct English word:\nI like to read at ___.", "Read the definition and write the correct English word:\n          The time of day when it is dark.", "          Write the English word for this Spanish meaning: \nNoche"}, {"milk", "Complete the sentence with the correct English word:\n          Could you buy some ___ at the store?", "Read the definition and write the correct English word:\n          A white liquid produced by cows.", "          Write the English word for this Spanish meaning: \n          Leche"}, {"          uncle", "          Complete the sentence with the correct English word:\nMy ___ visits us every Sunday.", "Read the definition and write the correct English word:\nYour parents’ brother.", "          Write the English word for this Spanish meaning: \nTío"}, {"thank", "Complete the sentence with the correct English word:\n          Don’t forget to ___ your teacher.", "          Read the definition and write the correct English word:\n          To express gratitude.", "Write the English word for this Spanish meaning: \nAgradecer"} };
    static String [][] nsbMedio = { {"          chef", "          Complete the sentence with the correct English word:\n          The ___ prepared a delicious meal.", "          Read the definition and write the correct English word:\nA professional cook.\n"          , "          Write the English word for this Spanish meaning:\n          Chef / cocinero profesional"}, {"          brush", "          Complete the sentence with the correct English word:\n          Remember to ___ your teeth before bed.", "          Read the definition and write the correct English word:\n          To clean using a brush.", "          Write the English word for this Spanish meaning:\n          Cepillar"}, {"          sister", "          Complete the sentence with the correct English word:\n          My ___ is younger than me.", "Read the definition and write the correct English word:\n          A girl who has the same parents as you.", "          Write the English word for this Spanish meaning:\n          Hermana"}, {"          desert", "          Complete the sentence with the correct English word:\n          Camels can live in the ___.", "          Read the definition and write the correct English word:\n          A dry place with little water.", "          Write the English word for this Spanish meaning:\nDesierto"}, {"          kitchen", "          Complete the sentence with the correct English word:\n          Dinner is ready in the ___.", "          Read the definition and write the correct English word:\n          The room where you cook food.", "          Write the English word for this Spanish meaning:\n          Cocina"}, {"          Monday", "          Complete the sentence with the correct English word:\n          School starts again on ___.", "Read the definition and write the correct English word:\n          The first day of the week for many people.", "          Write the English word for this Spanish meaning:\n          Lunes"}, {"          breakfast", "          Complete the sentence with the correct English word:\nI eat eggs and fruit for ___.", "Read the definition and write the correct English word:\n          The first meal of the day.", "          Write the English word for this Spanish meaning:\nDesayuno"}, {"horse", "          Complete the sentence with the correct English word:\n          She rides a ___ every weekend.", "Read the definition and write the correct English word:\n          A large animal people can ride.", "          Write the English word for this Spanish meaning:\n          Caballo"}, {"quite", "C          omplete the sentence with the correct English word:\nThe movie was ___ interesting.", "Read the definition and write the correct English word:\n          To a certain or large degree; fairly.", "          Write the English word for this Spanish meaning:\nBastante"}, {"listen", "Complete the sentence with the correct English word:\n          Please ___ carefully to the instructions.", "          Read the definition and write the correct English word:\nTo pay attention to sound.", "Write the English word for this Spanish meaning:\nEscuchar"} };
    static String [][] nsbNormal = { {"          intelligent", "          Complete the sentence with the correct English word:\n          She is very ___ and learns fast.", "          Read the definition and write the correct English word:\n          Able to learn and understand things easily.", "          Write the English word for this Spanish meaning:\n          Inteligente"}, {"          incredible", "          Complete the sentence with the correct English word:\n          The view from the mountain was ___.", "          Read the definition and write the correct English word:\n          Very surprising or hard to believe.", "          Write the English word for this Spanish meaning:\nIncreíble"}, {"          classmate", "          Complete the sentence with the correct English word:\n          My ___ helped me with the homework.", "          Read the definition and write the correct English word:\n          Another student in your class.", "          Write the English word for this Spanish meaning:\n          Compañero de clase"}, {"          celebration", "          Complete the sentence with the correct English word:\n          We had a big ___ for her birthday.", "          Read the definition and write the correct English word:\n          A joyful event or party.", "Write the English word for this Spanish meaning:\nCelebración"}, {"          scissors", "          Complete the sentence with the correct English word:\n          Don’t run with ___.", "          Read the definition and write the correct English word:\n          A tool used for cutting paper or fabric.", "          Write the English word for this Spanish meaning:\n          Tijeras"}, {"          television", "          Complete the sentence with the correct English word:\nTurn on the ___ to watch the news.", "          Read the definition and write the correct English word:\n          A device that shows moving images and sound.", "          Write the English word for this Spanish meaning:\nTelevisión"}, {"kilometer", "Complete the sentence with the correct English word:\n          The school is one ___ away.", "          Read the definition and write the correct English word:\nA unit of distance equal to 1,000 meters.", "          Write the English word for this Spanish meaning:\n          Kilómetro"}, {"          diagram", "          Complete the sentence with the correct English word:\n          The teacher drew a ___ on the board.", "          Read the definition and write the correct English word:\n          A simple drawing that explains how something works.", "Write the English word for this Spanish meaning:\nDiagrama"}, {"January", "Complete the sentence with the correct English word:\n          The year begins in ___.", "          Read the definition and write the correct English word:\nThe first month of the year.", "Write the English word for this Spanish meaning:\n          Enero"}, {"          Mexican", "          Complete the sentence with the correct English word:\nShe is very proud to be ___.", "Read the definition and write the correct English word:\nA person from Mexico.", "          Write the English word for this Spanish meaning:\n          Mexicano / Mexicana"} };
    static String [][] nsbDificil = { {"          disappear", "          Complete the sentence with the correct English word:\n          The cat seemed to ___ in the dark.", "          Read the definition and write the correct English word:\n          To stop being visible.", "          Write the English word for this Spanish meaning:\n          Desaparecer"}, {"          apologize", "          Complete the sentence with the correct English word:\n          You should ___ for being late.", "          Read the definition and write the correct English word:\n          To say you are sorry.", "          Write the English word for this Spanish meaning:\n          Disculparse"}, {"          appreciate", "          Complete the sentence with the correct English word:\n          I really ___ your help.", "          Read the definition and write the correct English word:\n          To be thankful for something.", "          Write the English word for this Spanish meaning:\n          Apreciar / agradecer"}, {"          immediately", "          Complete the sentence with the correct English word:\n          Come here ___.", "          Read the definition and write the correct English word:\n          Without waiting; right away.", "          Write the English word for this Spanish meaning:\nInmediatamente"}, {"          knock", "          Complete the sentence with the correct English word:\n          Please ___ before entering the room.", "          Read the definition and write the correct English word:\n          To hit a door to get someone’s attention.", "          Write the English word for this Spanish meaning:\n          Tocar (la puerta)"}, {"          license", "          Complete the sentence with the correct English word:\nYou need a ___ to drive a car.", "          Read the definition and write the correct English word:\n          An official document that gives permission.", "Write the English word for this Spanish meaning:\nLicencia"}, {"weigh", "Complete the sentence with the correct English word:\nHow much do you ___?", "          Read the definition and write the correct English word:\n          To measure how heavy something is.", "Write the English word for this Spanish meaning:\n          Pesar"}, {"          rhyme", "          Complete the sentence with the correct English word:\n          'Cat' and 'hat' ___ with each other.", "          Read the definition and write the correct English word:\n          Words that end with the same sound.", "          Write the English word for this Spanish meaning:\nRima / rimar"}, {"multimedia", "Complete the sentence with the correct English word:\nThe project included a ___ presentation.", "          Read the definition and write the correct English word:\n          Using many forms of communication (audio, video, text).", "Write the English word for this Spanish meaning:\n          Multimedia"}, {"          mysterious", "          Complete the sentence with the correct English word:\nThere was a ___ noise outside.", "Read the definition and write the correct English word:\nDifficult to explain or understand.", "          Write the English word for this Spanish meaning:\n          Misterioso"} };
    static String [][] nsbExpert = { {"          embarrass", "          Complete the sentence with the correct English word:\n          Don’t say things that might ___ him.", "          Read the definition and write the correct English word:\n          To make someone feel ashamed or uncomfortable.", "          Write the English word for this Spanish meaning:\n          Avergonzar"}, {"          puncture", "          Complete the sentence with the correct English word:\n          Be careful not to ___ the tire.", "          Read the definition and write the correct English word:\n          A small hole made by a sharp object.", "          Write the English word for this Spanish meaning:\n          Pinchar / perforar"}, {"          sustainable", "          Complete the sentence with the correct English word:\n          We need ___ energy solutions.", "          Read the definition and write the correct English word:\n          Able to be maintained without harming the environment.", "          Write the English word for this Spanish meaning:\n          Sostenible"}, {"          acknowledge", "          Complete the sentence with the correct English word:\n          Please ___ that you received the email.", "          Read the definition and write the correct English word:\nTo admit or accept that something is true.", "          Write the English word for this Spanish meaning:\n          Reconocer"}, {"          wriggle", "          Complete the sentence with the correct English word:\n          The worm began to ___ on the ground.", "          Read the definition and write the correct English word:\n          To twist and turn with small movements.", "          Write the English word for this Spanish meaning:\nRetorcerse"}, {"grease", "Complete the sentence with the correct English word:\n          The pan is covered in ___.", "          Read the definition and write the correct English word:\n          A fatty or oily substance.", "Write the English word for this Spanish meaning:\nGrasa"}, {"harass", "Complete the sentence with the correct English word:\n          It is illegal to ___ someone at work.", "          Read the definition and write the correct English word:\nTo repeatedly bother or disturb someone.", "          Write the English word for this Spanish meaning:\n          Acosar"}, {"          deceive", "          Complete the sentence with the correct English word:\n          He tried to ___ his friends with a lie.", "          Read the definition and write the correct English word:\nTo make someone believe something that is not true.", "Write the English word for this Spanish meaning:\nEngañar"}, {"guarantee", "          Complete the sentence with the correct English word:\n          The product comes with a one-year ___.", "Read the definition and write the correct English word:\n          A promise that something will work or last.", "          Write the English word for this Spanish meaning:\nGarantía"}, {"resilient", "Complete the sentence with the correct English word:\nChildren are often very ___ after facing challenges.", "          Read the definition and write the correct English word:\n          Able to recover quickly from difficulties; strong and adaptable.", "Write the English word for this Spanish meaning:\nResiliente"} };


    public static void main(String[] args) {
        /*Bienvenida*/
        char simbolo = (char) 42;
        System.out.println("\n");
        System.out.println("              ////////////////////////////////////////////////////////////////////");
        System.out.println("              //██╗     ██╗███╗   ██╗ ██████╗  ██████╗ ██╗  ██╗   ██╗███╗   ██╗ //");
        System.out.println("              //██║     ██║████╗  ██║██╔════╝ ██╔═══██╗██║  ╚██╗ ██╔╝████╗  ██║ //");
        System.out.println("              //██║     ██║██╔██╗ ██║██║  ███╗██║   ██║██║   ╚████╔╝ ██╔██╗ ██║ //");
        System.out.println("              //██║     ██║██║╚██╗██║██║   ██║██║   ██║██║    ╚██╔╝  ██║╚██╗██║ //");
        System.out.println("              //███████╗██║██║ ╚████║╚██████╔╝╚██████╔╝███████╗██║   ██║ ╚████║ //");
        System.out.println("              //╚══════╝╚═╝╚═╝  ╚═══╝ ╚═════╝  ╚═════╝ ╚══════╝╚═╝   ╚═╝  ╚═══╝ //");
        System.out.println("              ////////////////////////////////////////////////////////////////////");
        System.out.println("                =::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n" +
                "                =::::::::::::::::+@#+:::::::::::::::::::::::+@-=:::::::::::::::::\n" +
                "                =:::::::::::::::::+%-::::::::::::::::::::::::@=::::::::::::::::::\n" +
                "                =:::::::::::::::::::+-::::::::::::::::::::::*::::::::::::::::::::\n" +
                "                =::::::::::::::::::::+:::::::::::::::::::::+-::::::::::::::::::::\n" +
                "                =:::::::::::::::::::::#-::::::::::::::::::#-:::::::::::::::::::::\n" +
                "                =::::::::::::::::::::::+-::::::::::::::::#:::::::::::::::::::::::\n" +
                "                =:::::::::::::::::::::::+-::::::::::::::+-:::::::::::::::::::::::\n" +
                "                =::::::::::::::::::::::::*--=#%%%%%#+-:#:::::::::::::::::::::::::\n" +
                "                =:::::::::::::::::::::::+#=......::....-*+:::::::::::::::::::::::\n" +
                "                =:::::::::::::::::::::*@-::::::::::::::::.=#:::::::::::::::::::::\n" +
                "                =:::::::::::::::::::-#-:::::::::::::::::...:#-:::::::::::::::::::\n" +
                "                =:::::::::-+  :#=::=%-:::::::::::::::::::. ..%=::-#+-+=::::::::::\n" +
                "                =:::::::::*     -%%-:::=+-::::::::::::=-:. .:%#=     +-::::::::::\n" +
                "                =:::::::::=.    .=.#=:::*@#+*:::::::::-@@+%:..:-+ .   +-:::::::::\n" +
                "                =:::::::::-=    +%+::::+@@@+::=-::=::-@@@@:::::#.*.   #::::::::::\n" +
                "                =::::::::::+. :=+%=::::::::::::===:::::--::::::*+:+. :=::::::::::\n" +
                "                =:::::::::::#    #-::::::::::::::::::::::::::::+-    *:::::::::::\n" +
                "                =::::::::::::+:  #-::::::::::::::::::::::::::::+-   #::::::::::::\n" +
                "                =:::::::::::::+ -#-::::::::::::::::::::::::::::#: .*:::::::::::::\n" +
                "                =:::::::::::::::@@@#+-::::::::::::::::::::::-=%@ -+::::::::::::::\n" +
                "                =::::::::::::::::#@@@@@@@%*=----------=+#@@@@@@@#::::::::::::::::\n" +
                "                =::::::::::::::::=%%@@@@@@@@@@@@@@@@@@@@@@@@@@@#:::::::::::::::::\n" +
                "                =:::::::::::::::=%@+---+*%@@@@@@@@@@@@@@@#*===@@*::::::::::::::::\n" +
                "                =:::::::::::::::%:-@@@@=-------------------=%@#:@%-::::::::::::::\n" +
                "                =::::::::::::::::::-@@@@@@@@@@@@@@@@@@@@@@@@@@:::::::::::::::::::\n" +
                "                =:::::::::::::::::::-@*@@@@@@@@@@@@@@@@@@@@@@::::::::::::::::::::\n" +
                "                =:::::::::::::::::::::@#+==----====------=#%:::::::::::::::::::::\n" +
                "                =::::::::::::::::::::::-@@@@@@@@@@@@@@@@@@=::::::::::::::::::::::\n" +
                "                =:::::::::::::::::::::::::@@@@@@@@@@@@@@=::::::::::::::::::::::::\n" +
                "                =:::::::::::::::::::::::::::-*@@@@@@*=:::::::::::::::::::::::::::\n" +
                "                =:::::::::::::::::::::::::::::#+:-@-:::::::::::::::::::::::::::::\n" +
                "                =:::::::::::::::::::::::::::::#+:-@-:::::::::::::::::::::::::::::\n" +
                "                =::::::::::::::::::::::::::#@@@=:-@@@@-::::::::::::::::::::::::::\n");
        System.out.println("       ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                "       ~░█▀▄░▀█▀░█▀▀░█▀█░█░█░█▀▀░█▀█░▀█▀░█▀▄░█▀█░░░█▀█░░░█░░░▀█▀░█▀█░█▀▀░█▀█░█░░░█░█░█▀█~\n" +
                "       ~░█▀▄░░█░░█▀▀░█░█░▀▄▀░█▀▀░█░█░░█░░█░█░█░█░░░█▀█░░░█░░░░█░░█░█░█░█░█░█░█░░░░█░░█░█~\n" +
                "       ~░▀▀░░▀▀▀░▀▀▀░▀░▀░░▀░░▀▀▀░▀░▀░▀▀▀░▀▀░░▀▀▀░░░▀░▀░░░▀▀▀░▀▀▀░▀░▀░▀▀▀░▀▀▀░▀▀▀░░▀░░▀░▀~\n" +
                "       ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("\n");
        registro();
        moduloGeneral();
    }

    public static void registro() {
        System.out.println("                  Por favor, ingresa tu nombre (como quieres que te llamemos)");
        System.out.print("                  ");
        usuario = sc.nextLine();
    }

    public static void moduloGeneral() {
        /*Preguntar que desea practicar*/
        int opcionprincipal;
        System.out.println("            +======================================================================+");
        System.out.println("            ||       Hola " + usuario + ", ¿Qué modo deseas practicar?                      ||");
        System.out.println("            ||       1.Spelling Bee (deletreo)                                    ||");
        System.out.println("            ||       2.Vocabulario (ampliar palabras)                             ||");
        System.out.println("            +======================================================================+");
        System.out.println("\n\n                  Elige 1 o 2:");
        System.out.print("                  ");
        /*leer que desea practicar*/
        do {
            opcionprincipal = sc.nextInt();
            switch (opcionprincipal) {
                case 1:
                    nivel="el nivel";
                    String art =
                            "        ················································································\n" + "        : #####                                                  ######                :\n" +
                                    "        : #     # #####  ###### #      #      # #    #  ####     #     # ###### ###### :\n" +
                                    "        : #       #    # #      #      #      # ##   # #    #    #     # #      #      :\n" +
                                    "        :  #####  #    # #####  #      #      # # #  # #         ######  #####  #####  :\n" +
                                    "        :      #  #####  #      #      #      # #  # # #  ###    #     # #      #      :\n" +
                                    "        : #     # #      #      #      #      # #   ## #    #    #     # #      #      :\n" +
                                    "        :  #####  #      ###### ###### ###### # #    #  ####     ######  ###### ###### :\n" +
                                    "        ················································································";
                    System.out.println(art);
                    System.out.println("\n");

                    /*DECLARACION DE NIVELES SPELLING BEE (CONVERTIDOS A MAYÚSCULAS)*/
                    String[] nsbBasico = {"          ADD", "          EYE", "          EAR", "          BOAT", "          HAPPY", "          LION", "          NIGHT", "          MILK", "          UNCLE", "          THANK"};
                    String[] nsbMedio = {"          CHEF", "          BRUSH", "          SISTER", "DESERT", "          KITCHEN", "          MONDAY", "          BREAKFAST", "HORSE", "QUITE", "          LISTEN"};
                    String[] nsbNormal = {"          INTELLIGENT", "          INCREDIBLE", "          CLASSMATE", "          CELEBRATION", "SCISSORS", "          TELEVISION", "KILOMETER", "          DIAGRAM", "          JANUARY", "          MEXICAN"};
                    String[] nsbDificil = {"          DISAPPEAR", "          APOLOGIZE", "          APPRECIATE", "IMMEDIATELY", "          KNOCK", "          LICENSE", "          WEIGH", "          RHYME", "          MULTIMEDIA", "          MYSTERIOUS"};
                    String[] nsbExpert = {"          EMBARRASS", "          PUNCTURE", "          SUSTAINABLE", "ACKNOWLEDGE", "          WRIGGLE", "          GREASE", "          HARASS", "          DECEIVE", "          GUARANTEE"};


                    System.out.println("          Ingresa el nivel que deseas cursar (recuerda que se dara por hecho que ya has\n          cursado los niveles anteriores a el):\n");
                    System.out.println("          1- Básico\n          2- Medio\n          3- Normal\n          4- Difícil\n          5- Experto");

                    do {
                        System.out.print("          ");
                        nivelSpellingBee = sc.nextInt();
                        switch (nivelSpellingBee) {
                            case 1:
                                nnombre = "Básico";
                                PALABRAS_JUEGO = nsbBasico;
                                break;
                            case 2:
                                nnombre = "Medio";
                                PALABRAS_JUEGO = nsbMedio;
                                break;
                            case 3:
                                nnombre = "Normal";
                                PALABRAS_JUEGO = nsbNormal;
                                break;
                            case 4:
                                nnombre = "Difícil";
                                PALABRAS_JUEGO = nsbDificil;
                                break;
                            case 5:
                                nnombre = "Experto";
                                PALABRAS_JUEGO = nsbExpert;
                                break;
                            default:
                                System.out.print("              Opción invalida. Ese número no corresponde a ningún nivel. Intenta de nuevo: ");
                                break;
                        }
                    }
                    while (nivelSpellingBee < 1 || nivelSpellingBee > 5);

                    /*Preguntar modalidad Spelling Bee */
                    System.out.println("                         +=============================================+");
                    System.out.println("                         ||       Ahora elige la modalidad            ||");
                    System.out.println("                         ||       1. Modalidad Tradicional            ||");
                    System.out.println("                         ||       2. Modalidad Retos y Juegos         ||");
                    System.out.println("                         +=============================================+");
                    System.out.println("\n\n                  Ingresa 1 o 2: ");
                    System.out.print("                  ");
                    int modalidadSpellingBee;
                    /*leer modalidad Spelling Bee*/
                    do {
                        modalidadSpellingBee = sc.nextInt();
                        switch (modalidadSpellingBee) {
                            case 1:
                                allnombre = "Spelling Bee Modalidad Tradicional";
                                modalidadTradicionalSpellingBee();
                                break;
                            case 2:
                                modalidadRetosyJuegosSpellingBee();
                                break;
                            default:
                                System.out.print("           Opción invalida, debes ingresar 1 o 2. Intenta de nuevo: ");
                                break;
                        }
                    }
                    while (modalidadSpellingBee != 1 && modalidadSpellingBee != 2);
                    break;

                case 2:
                    nivel = "la categoría gramatical";
                    /*Preguntar modalidad Vocabulario*/
                    System.out.println("                  "+ usuario + ", elegiste:\n ");
                    String art2 =
                            "               /============================================================\\\n" +
                                    "               || __     __              _           _            _        ||\n" +
                                    "               || \\ \\   / /__   ___ __ _| |__  _   _| | __ _ _ __(_) ___   ||\n" +
                                    "               ||  \\ \\ / / _ \\ / __/ _` | '_ \\| | | | |/ _` | '__| |/ _ \\  ||\n" +
                                    "               ||   \\ V / (_) | (_| (_| | |_) | |_| | | (_| | |  | | (_) | ||\n" +
                                    "               ||    \\_/ \\___/ \\___\\__,_|_.__/ \\__,_|_|\\__,_|_|  |_|\\___/  ||\n" +
                                    "               \\============================================================/\n";
                    System.out.println(art2);
                    System.out.println("\n");
                    /*DECLARACION DE NIVELES VOCABULARIO*/
                    String [][] nvVerboregulares = {
                            {"          play","          Complete the sentence with the correct English word:\n          Would you ____ chess with me after the soccer training","          Read the definition and write the correct English word:\n          To engage in a game or sport for fun or competition","          Write the English word for this Spanish meaning:\n          Jugar"},
                            {"          work","          Complete the sentence with the correct English word:\n          How can you ____ for long hours without coffee","          Read the definition and write the correct English word:\n          To perform tasks or duties, usually for money or effort","          Write the English word for this Spanish meaning:\n          Trabajar"},
                            {"          talk","          Complete the sentence with the correct English word:\n          Now that we don´t ____ on instagram, i feel better","          Read the definition and write the correct English word:\n          To communicate with someone using words","          Write the English word for this Spanish meaning:\n          Hablar"},
                            {"          watch","           Complete the sentence with the correct English word:\n          If i was you, i will don´t want to _____ that movie, it´s so sad","          Read the definition and write the correct English word:\n          To look at something attentively, especially a movie or TV show.","          Write the English word for this Spanish meaning:\nMirar"},
                            {"          clean","          Complete the sentence with the correct English word:\n          Oh wow, you have to _____ really well, this place is so spotless","          Read the definition and write the correct English word:\n          To make a place free from dirt or mess.","          Write the English word for this Spanish meaning:\n          Limpiar"},
                            {"          open","          Complete the sentence with the correct English word:\n          Can you ____ the windows, i´ts getting hot in here","          Read the definition and write the correct English word:\n          To move something so that it is no longer closed.","          Write the English word for this Spanish meaning:\n          Abrir"},
                            {"          help","          Complete the sentence with the correct English word:\n          I need some ____, this shopping bags are too heavy","          Read the definition and write the correct English word:\n          To give assistance to someone in need.","          Write the English word for this Spanish meaning:\n          Ayudar"},
                            {"          start","          Complete the sentence with the correct English word:\n          Are you ready to _____, the time is ending","          Read the definition and write the correct English word:\n          To begin an activity or action.","          Write the English word for this Spanish meaning:\n          Empezar"},
                            {"          call","          Complete the sentence with the correct English word:\n          My party has been updated. ____ me to know the new information","          Read the definition and write the correct English word:\n          To contact someone by phone.","          Write the English word for this Spanish meaning:\n          Llamar"},
                            {"          live","          Complete the sentence with the correct English word:\n          I don´t wanna ____ forever, because I know I´ll be living in vain","          Read the definition and write the correct English word:\n          To exist in a particular place or time.","          Write the English word for this Spanish meaning:\n          Vivir"}
                    };
                    String[][] nvVerbosirregulares = {
                            {"          go","          Complete the sentence with the correct English word:\n          I want to ____ to the park this afternoon.","          Read the definition and write the correct English word:\n          To move from one place to another.","          Write the English word for this Spanish meaning:\n          Ir"},
                            {"          eat","          Complete the sentence with the correct English word:\n          Let’s ____ pizza for dinner tonight.","          Read the definition and write the correct English word:\n          To put food into the mouth, chew, and swallow.","          Write the English word for this Spanish meaning:\n          Comer"},
                            {"          see","          Complete the sentence with the correct English word:\n          Did you ____ that amazing rainbow yesterday?","          Read the definition and write the correct English word:\n          To notice or perceive with the eyes.","          Write the English word for this Spanish meaning:\n          Ver"},
                            {"          take","          Complete the sentence with the correct English word:\n          Can you ____ this book back to the library?","          Read the definition and write the correct English word:\n          To get into one’s possession; to carry or bring.","          Write the English word for this Spanish meaning:\n          Tomar"},
                            {"          come","          Complete the sentence with the correct English word:\n          Please ____ to my house tomorrow for lunch.","          Read the definition and write the correct English word:\n          To move toward or arrive at a place.","          Write the English word for this Spanish meaning:\n          Come"},
                            {"          drink","          Complete the sentence with the correct English word:\n          I need to ____ some water after running.","          Read the definition and write the correct English word:\n          To swallow liquid.","Write the English word for this Spanish meaning:\n          Beber"},
                            {"          write","          Complete the sentence with the correct English word:\n          She wants to ____ a letter to her friend.","          Read the definition and write the correct English word:\n          To form words on paper or screen with a pen or keyboard.","          Write the English word for this Spanish meaning:\nEscribir"},
                            {"          begin","          Complete the sentence with the correct English word:\n          The class will ____ at nine o’clock sharp.","          Read the definition and write the correct English word:\n          To start or commence something.","          Write the English word for this Spanish meaning:\n          Comenzar"},
                            {"          run","          Complete the sentence with the correct English word:\n          He likes to ____ every morning before breakfast.","          Read the definition and write the correct English word:\n          To move quickly with your legs.","          Write the English word for this Spanish meaning:\n          Correr"},
                            {"          break","          Complete the sentence with the correct English word:\n          Be careful not to ____ that glass, it’s fragile.","          Read the definition and write the correct English word:\n          To separate into pieces by force.","          Write the English word for this Spanish meaning:\n          Romper"},
                    };
                    String[][] nvSustantivo = {
                            {"          career","          Complete the sentence with the correct English word:\nShe built a successful ____ in medicine.","Read the definition and write the correct English word:\nA profession or occupation pursued for a significant period of life.","Write the English word for this Spanish meaning:\nCarrera"},
                            {"          skill","          Complete the sentence with the correct English word:\nGood communication is an important ____.","Read the definition and write the correct English word:\nThe ability to do something well, usually gained through training or practice.","Write the English word for this Spanish meaning:\nHabilidad"},
                            {"          knowledge","          Complete the sentence with the correct English word:\nHis ____ of history is impressive.","Read the definition and write the correct English word:\nInformation, understanding, or awareness gained through learning or experience.","Write the English word for this Spanish meaning:\nConocimiento"},
                            {"          solution","          Complete the sentence with the correct English word:\nWe need a ____ to fix this problem.","Read the definition and write the correct English word:\nAn answer or way to resolve a difficulty.","Write the English word for this Spanish meaning:\nSolución"},
                            {"          environment","          Complete the sentence with the correct English word:\nProtecting the ____ is everyone’s responsibility.","Read the definition and write the correct English word:\nThe surroundings or conditions in which people, animals, or plants live.","Write the English word for this Spanish meaning:\nAmbiente"},
                            {"          experience","          Complete the sentence with the correct English word:\nShe has five years of ____ in teaching.","Read the definition and write the correct English word:\nPractical contact with and observation of facts or events.","Write the English word for this Spanish meaning:\nExperencia"},
                            {"          luggage","          Complete the sentence with the correct English word:\nDon’t forget your ____ at the airport.","Read the definition and write the correct English word:\nBags and suitcases used for traveling.","Write the English word for this Spanish meaning:\nEquipaje"},
                            {"          customer","          Complete the sentence with the correct English word:\nThe shop assistant helped the ____.","Read the definition and write the correct English word:\nA person who buys goods or services.","Write the English word for this Spanish meaning:\nCliente"},
                            {"          opinion","          Complete the sentence with the correct English word:\nIn my ____, this book is excellent.","Read the definition and write the correct English word:\nA personal view, belief, or judgment.","Write the English word for this Spanish meaning:\nOpinión"},
                            {"          traffic","          Complete the sentence with the correct English word:\nWe were late because of heavy ____.","Read the definition and write the correct English word:\nThe movement of vehicles on roads.","Write the English word for this Spanish meaning:\nTráfico"},
                    };
                    String[][] nvPreposiciones = {
                            {"          above","          Complete the sentence with the correct English word:\n          The picture is hanging ____ the fireplace.","          Read the definition and write the correct English word:\n          At a higher level or position.","          Write the English word for this Spanish meaning:\n          Encima de"},
                            {"          below","          Complete the sentence with the correct English word:\n          The valley lies ____ the mountains.","          Read the definition and write the correct English word:\n          At a lower level or position.","          Write the English word for this Spanish meaning:\n          Debajo de"},
                            {"          between","          Complete the sentence with the correct English word:\n          The ball is ____ the two chairs.","          Read the definition and write the correct English word:\n          In the middle of two things.","          Write the English word for this Spanish meaning:\n          Entre"},
                            {"          among","          Complete the sentence with the correct English word:\n          She was happy to be ____ friends.","          Read the definition and write the correct English word:\n          Surrounded by, in the company of.","          Write the English word for this Spanish meaning:\n          Entre"},
                            {"          inside","          Complete the sentence with the correct English word:\n          The cat is hiding ____ the box.","          Read the definition and write the correct English word:\n          Within the interior of something.","          Write the English word for this Spanish meaning:\n          Dentro de"},
                            {"          outside","          Complete the sentence with the correct English word:\n          Let’s wait ____ the house until they arrive.","          Read the definition and write the correct English word:\n          Not inside; in the open air.","          Write the English word for this Spanish meaning:\n          Fuera de"},
                            {"          onto","          Complete the sentence with the correct English word:\n          He climbed ____ the roof to fix it.","          Read the definition and write the correct English word:\n          Moving to a position on top of something.","          Write the English word for this Spanish meaning:\n          Sobre"},
                            {"          off","          Complete the sentence with the correct English word:\n          Please take your shoes ____ the table.","          Read the definition and write the correct English word:\n          Away from a place or position.","          Write the English word for this Spanish meaning:\n          Fuera de"},
                            {"          around","          Complete the sentence with the correct English word:\n          They walked ____ the park together.","          Read the definition and write the correct English word:\n          In a circular direction or surrounding.","          Write the English word for this Spanish meaning:\n          Alrededor de"},
                            {"          near","          Complete the sentence with the correct English word:\n          The school is ____ the library.","          Read the definition and write the correct English word:\n          Close to something.","          Write the English word for this Spanish meaning:\n          Cerca de"}
                    };
                    String[][] nvAdjetivos = {
                            {"          happy","          Complete the sentence with the correct English word:\n          She feels ____ because she passed the exam.","          Read the definition and write the correct English word:\n          Feeling or showing pleasure.","          Write the English word for this Spanish meaning:\n          Feliz"},
                            {"          sad","          Complete the sentence with the correct English word:\n          He looked ____ after hearing the bad news.","          Read the definition and write the correct English word:\n          Feeling sorrow or unhappiness.","          Write the English word for this Spanish meaning:\n          Triste"},
                            {"          big","          Complete the sentence with the correct English word:\n          That is a very ____ house.","          Read the definition and write the correct English word:\n          Of large size.","          Write the English word for this Spanish meaning:\n          Grande"},
                            {"          small","          Complete the sentence with the correct English word:\n          The puppy is so ____.","          Read the definition and write the correct English word:\n          Of little size.","          Write the English word for this Spanish meaning:\n          Pequeño"},
                            {"          fast","          Complete the sentence with the correct English word:\n          The car is really ____.","          Read the definition and write the correct English word:\n          Moving quickly.","          Write the English word for this Spanish meaning:\n          Rápido"},
                            {"          slow","          Complete the sentence with the correct English word:\n          The turtle is ____.","          Read the definition and write the correct English word:\n          Not fast.","          Write the English word for this Spanish meaning:\n          Lento"},
                            {"          beautiful","          Complete the sentence with the correct English word:\n          The garden looks ____.","          Read the definition and write the correct English word:\n          Pleasing to the senses.","          Write the English word for this Spanish meaning:\n          Hermoso"},
                            {"          ugly","          Complete the sentence with the correct English word:\n          The painting is ____.","          Read the definition and write the correct English word:\n          Not attractive.","          Write the English word for this Spanish meaning:\n          Feo"},
                            {"          strong","          Complete the sentence with the correct English word:\n          She is ____ enough to lift heavy boxes.","          Read the definition and write the correct English word:\n          Having power or force.","          Write the English word for this Spanish meaning:\n          Fuerte"},
                            {"          weak","          Complete the sentence with the correct English word:\n          He felt ____ after the long illness.","          Read the definition and write the correct English word:\n          Lacking strength.","          Write the English word for this Spanish meaning:\n          Débil"}
                    };
                    String[][] nvExpresionescomunes = {
                            {"          How are you?", "          Complete the sentence with the correct English expression:\n          ____, I’m fine thanks.","          Read the definition and write the correct English expression:\n          A common greeting asking about someone’s well-being.","          Write the English expression for this Spanish meaning:\n          ¿Cómo estás?"},
                            {"          What’s up?", "          Complete the sentence with the correct English expression:\n          ____, nothing much.","          Read the definition and write the correct English expression:\n          An informal way to ask what is happening.","          Write the English expression for this Spanish meaning:\n          ¿Qué tal?"},
                            {"          Long time no see", "          Complete the sentence with the correct English expression:\n          ____, I missed you!","          Read the definition and write the correct English expression:\n          Used when you meet someone after a long period.","          Write the English expression for this Spanish meaning:\n          ¡Cuánto tiempo sin verte!"},
                            {"          Take care", "          Complete the sentence with the correct English expression:\n          Goodbye and ____.","          Read the definition and write the correct English expression:\n          A phrase used to wish safety and well-being.","          Write the English expression for this Spanish meaning:\n          Cuídate"},
                            {"          See you later", "          Complete the sentence with the correct English expression:\n          Bye, ____!","          Read the definition and write the correct English expression:\n          A casual way to say farewell until next time.","          Write the English expression for this Spanish meaning:\n          Nos vemos luego"},
                            {"          Nice to meet you", "          Complete the sentence with the correct English expression:\n          Hello, ____.","          Read the definition and write the correct English expression:\n          A polite phrase when meeting someone for the first time.","          Write the English expression for this Spanish meaning:\n          Encantado de conocerte"},
                            {"          Have a good day", "          Complete the sentence with the correct English expression:\n          Bye, ____!","          Read the definition and write the correct English expression:\n          A phrase wishing someone a pleasant day.","          Write the English expression for this Spanish meaning:\n          Que tengas un buen día"},
                            {"          Don’t worry", "          Complete the sentence with the correct English expression:\n          ____, everything will be fine.", "          Read the definition and write the correct English expression:\n          Used to reassure someone not to be concerned.","          Write the English expression for this Spanish meaning:\n          No te preocupes"},
                            {"          It’s up to you", "          Complete the sentence with the correct English expression:\n          Choose the movie, ____.", "          Read the definition and write the correct English expression:\n          Means the decision depends on the person.","          Write the English expression for this Spanish meaning:\n          Depende de ti"},
                            {"          By the way", "          Complete the sentence with the correct English expression:\n          ____, did you finish your homework?", "          Read the definition and write the correct English expression:\n          Used to introduce a new topic or reminder.","          Write the English expression for this Spanish meaning:\n          Por cierto"}
                    };
                    // PALABRAS VOCABULARIO JUEGO PALABRAS RELACIONADAS
                    String[][] sinyantVerbosRegulares = {
                            {"          participate",
                                    "          Complete the sentence with the correct English synonym:\n          She likes to ____ soccer every weekend. (play)",
                                    "          Choose the synonym of 'play':\n          (a) participate, (b) rest, (c) ignore",
                                    "          Write the synonym of the following word: play"},

                            {"          rest",
                                    "          Complete the sentence with the correct English antonym:\n          He decided to ____ instead of working all day. (work)",
                                    "          Choose the antonym of 'work':\n          (a) rest, (b) labor, (c) job",
                                    "          Write the antonym of the following word: work"},

                            {"          speak",
                                    "          Complete the sentence with the correct English synonym:\n          Let’s ____ about the new movie tonight. (talk)",
                                    "          Choose the synonym of 'talk':\n          (a) speak, (b) run, (c) watch",
                                    "          Write the synonym of the following word: talk"},

                            {"          ignore",
                                    "          Complete the sentence with the correct English antonym:\n          Don’t just watch, try not to ____ what’s happening. (watch)",
                                    "          Choose the antonym of 'watch':\n          (a) ignore, (b) observe, (c) look",
                                    "          Write the antonym of the following word: watch"},

                            {"          tidy",
                                    "          Complete the sentence with the correct English synonym:\n          She will ____ the kitchen before guests arrive. (clean)",
                                    "          Choose the synonym of 'clean':\n          (a) tidy, (b) dirty, (c) mess",
                                    "          Write the synonym of the following word: clean"},

                            {"          close",
                                    "          Complete the sentence with the correct English antonym:\n          Can you open the window? Don’t ____ it now. (open)",
                                    "          Choose the antonym of 'open':\n          (a) close, (b) unlock, (c) unseal",
                                    "          Write the antonym of the following word: open"},

                            {"          assist",
                                    "          Complete the sentence with the correct English synonym:\n          Could you ____ me with my homework? (help)",
                                    "          Choose the synonym of 'help':\n          (a) assist, (b) ignore, (c) rest",
                                    "          Write the synonym of the following word: help"},

                            {"          finish",
                                    "          Complete the sentence with the correct English antonym:\n          We will start the meeting at 10 a.m. and ____ it at noon. (start)",
                                    "          Choose the antonym of 'start':\n          (a) finish, (b) begin, (c) commence",
                                    "          Write the antonym of the following word: start"},

                            {"          phone",
                                    "          Complete the sentence with the correct English synonym:\n          I will ____ my friend to invite her to the party. (call)",
                                    "          Choose the synonym of 'call':\n          (a) phone, (b) write, (c) run",
                                    "          Write the synonym of the following word: call"},

                            {"          die",
                                    "          Complete the sentence with the correct English antonym:\n          They live in a small town, but many people ____ in the city. (live)",
                                    "          Choose the antonym of 'live':\n          (a) die, (b) survive, (c) exist",
                                    "          Write the antonym of the following word: live"}
                    };
                    String[][] sinyantVerbosIrregulares = {
                            {"          travel",
                                    "          Complete the sentence with the correct English synonym:\n          They want to ____ on vacation next month. (go)",
                                    "          Choose the synonym of 'go':\n          (a) travel, (b) stop, (c) stay",
                                    "          Write the synonym of the following word: go"},

                            {"          fast",
                                    "          Complete the sentence with the correct English antonym:\n          Instead of eating, he decided to ____ for the day. (eat)",
                                    "          Choose the antonym of 'eat':\n          (a) fast, (b) consume, (c) devour",
                                    "          Write the antonym of the following word: eat"},

                            {"          notice",
                                    "          Complete the sentence with the correct English synonym:\n          Did you ____ the rainbow yesterday? (see)",
                                    "          Choose the synonym of 'see':\n          (a) notice, (b) hide, (c) ignore",
                                    "          Write the synonym of the following word: see"},

                            {"          give",
                                    "          Complete the sentence with the correct English antonym:\n          Don’t take the gift, try to ____ it. (take)",
                                    "          Choose the antonym of 'take':\n          (a) give, (b) grab, (c) seize",
                                    "          Write the antonym of the following word: take"},

                            {"          arrive",
                                    "          Complete the sentence with the correct English synonym:\n          She will ____ to the party later. (come)",
                                    "          Choose the synonym of 'come':\n          (a) arrive, (b) depart, (c) leave",
                                    "          Write the synonym of the following word: come"},

                            {"          abstain",
                                    "          Complete the sentence with the correct English antonym:\n          She drinks tea daily, but today she decided to ____. (drink)",
                                    "          Choose the antonym of 'drink':\n          (a) abstain, (b) sip, (c) gulp",
                                    "          Write the antonym of the following word: drink"},

                            {"          compose",
                                    "          Complete the sentence with the correct English synonym:\n          He likes to ____ letters to his friends. (write)",
                                    "          Choose the synonym of 'write':\n          (a) compose, (b) read, (c) erase",
                                    "          Write the synonym of the following word: write"},

                            {"          end",
                                    "          Complete the sentence with the correct English antonym:\n          We will begin the meeting at 10 a.m. and ____ it at noon. (begin)",
                                    "          Choose the antonym of 'begin':\n          (a) end, (b) start, (c) commence",
                                    "          Write the antonym of the following word: begin"},

                            {"          sprint",
                                    "          Complete the sentence with the correct English synonym:\n          He can ____ very fast in competitions. (run)",
                                    "          Choose the synonym of 'run':\n          (a) sprint, (b) walk, (c) stop",
                                    "          Write the synonym of the following word: run"},

                            {"          fix",
                                    "          Complete the sentence with the correct English antonym:\n          The vase broke, but she managed to ____ it. (break)",
                                    "          Choose the antonym of 'break':\n          (a) fix, (b) shatter, (c) crack",
                                    "          Write the antonym of the following word: break"}
                    };
                    String[][] sinyantSustantivos ={
                            {"          profession",
                                    "          Complete the sentence with the correct English synonym:\n          He chose a new ____ in medicine. (career)",
                                    "          Choose the synonym of 'career':\n          (a) profession, (b) unemployment, (c) hobby",
                                    "          Write the synonym of the following word: career"},

                            {"          incompetence",
                                    "          Complete the sentence with the correct English antonym:\n          That student shows skill, but the other shows ____. (skill)",
                                    "          Choose the antonym of 'skill':\n          (a) incompetence, (b) ability, (c) expertise",
                                    "          Write the antonym of the following word: skill"},

                            {"          understanding",
                                    "          Complete the sentence with the correct English synonym:\n          Reading gives us more ____. (knowledge)",
                                    "          Choose the synonym of 'knowledge':\n          (a) understanding, (b) ignorance, (c) doubt",
                                    "          Write the synonym of the following word: knowledge"},

                            {"          problem",
                                    "          Complete the sentence with the correct English antonym:\n          We found a solution, but another team found a ____. (solution)",
                                    "          Choose the antonym of 'solution':\n          (a) problem, (b) answer, (c) resolution",
                                    "          Write the antonym of the following word: solution"},

                            {"          surroundings",
                                    "          Complete the sentence with the correct English synonym:\n          We must protect our ____. (environment)",
                                    "          Choose the synonym of 'environment':\n          (a) surroundings, (b) pollution, (c) habitat",
                                    "          Write the synonym of the following word: environment"},

                            {"          inexperience",
                                    "          Complete the sentence with the correct English antonym:\n          He has a lot of experience, but she has ____. (experience)",
                                    "          Choose the antonym of 'experience':\n          (a) inexperience, (b) practice, (c) expertise",
                                    "          Write the antonym of the following word: experience"},

                            {"          baggage",
                                    "          Complete the sentence with the correct English synonym:\n          She packed her ____ before the trip. (luggage)",
                                    "          Choose the synonym of 'luggage':\n          (a) baggage, (b) vendor, (c) suitcase",
                                    "          Write the synonym of the following word: luggage"},

                            {"          vendor",
                                    "          Complete the sentence with the correct English antonym:\n          The customer bought fruit, but the ____ sold it. (customer)",
                                    "          Choose the antonym of 'customer':\n          (a) vendor, (b) client, (c) buyer",
                                    "          Write the antonym of the following word: customer"},

                            {"          view",
                                    "          Complete the sentence with the correct English synonym:\n          Everyone has a different ____. (opinion)",
                                    "          Choose the synonym of 'opinion':\n          (a) view, (b) fact, (c) truth",
                                    "          Write the synonym of the following word: opinion"},

                            {"          free flow",
                                    "          Complete the sentence with the correct English antonym:\n          The traffic was heavy yesterday, but today there is ____. (traffic)",
                                    "          Choose the antonym of 'traffic':\n          (a) free flow, (b) jam, (c) congestion",
                                    "          Write the antonym of the following word: traffic"}
                    };
                    String[][] sinyantPreposiciones ={
                            {"          over",
                                    "          Complete the sentence with the correct English synonym:\n          The lamp is ____ the table. (above)",
                                    "          Choose the synonym of 'above':\n          (a) over, (b) under, (c) below",
                                    "          Write the synonym of the following word: above"},

                            {"          above",
                                    "          Complete the sentence with the correct English antonym:\n          The shoes are below the bed, not ____ it. (below)",
                                    "          Choose the antonym of 'below':\n          (a) above, (b) under, (c) beneath",
                                    "          Write the antonym of the following word: below"},

                            {"          amid",
                                    "          Complete the sentence with the correct English synonym:\n          She was happy to be ____ friends. (among)",
                                    "          Choose the synonym of 'among':\n          (a) amid, (b) alone, (c) outside",
                                    "          Write the synonym of the following word: among"},

                            {"          alone",
                                    "          Complete the sentence with the correct English antonym:\n          He was among friends yesterday, but today he is ____. (among)",
                                    "          Choose the antonym of 'among':\n          (a) alone, (b) together, (c) amidst",
                                    "          Write the antonym of the following word: among"},

                            {"          within",
                                    "          Complete the sentence with the correct English synonym:\n          The cat is hiding ____ the box. (inside)",
                                    "          Choose the synonym of 'inside':\n          (a) within, (b) outside, (c) exterior",
                                    "          Write the synonym of the following word: inside"},

                            {"          exterior",
                                    "          Complete the sentence with the correct English antonym:\n          The cat is inside the box, not ____ it. (inside)",
                                    "          Choose the antonym of 'inside':\n          (a) exterior, (b) within, (c) inside",
                                    "          Write the antonym of the following word: inside"},

                            {"          onto",
                                    "          Complete the sentence with the correct English synonym:\n          He climbed ____ the roof quickly. (onto)",
                                    "          Choose the synonym of 'onto':\n          (a) onto, (b) off, (c) under",
                                    "          Write the synonym of the following word: onto"},

                            {"          off",
                                    "          Complete the sentence with the correct English antonym:\n          He jumped onto the roof, then got ____. (onto)",
                                    "          Choose the antonym of 'onto':\n          (a) off, (b) upon, (c) down",
                                    "          Write the antonym of the following word: onto"},

                            {"          around",
                                    "          Complete the sentence with the correct English synonym:\n          They walked ____ the park. (around)",
                                    "          Choose the synonym of 'around':\n          (a) around, (b) about, (c) near",
                                    "          Write the synonym of the following word: around"},

                            {"          far",
                                    "          Complete the sentence with the correct English antonym:\n          The school is near the library, not ____ it. (near)",
                                    "          Choose the antonym of 'near':\n          (a) far, (b) close, (c) nearby",
                                    "          Write the antonym of the following word: near"}
                    };
                    String[][] sinyantAdjetivos ={
                            {"          joyful",
                                    "          Complete the sentence with the correct English synonym:\n          She feels ____ because she passed the exam. (happy)",
                                    "          Choose the synonym of 'happy':\n          (a) joyful, (b) sad, (c) weak",
                                    "          Write the synonym of the following word: happy"},

                            {"          happy",
                                    "          Complete the sentence with the correct English antonym:\n          He looked sad, but later he was ____. (sad)",
                                    "          Choose the antonym of 'sad':\n          (a) happy, (b) joyful, (c) cheerful",
                                    "          Write the antonym of the following word: sad"},

                            {"          large",
                                    "          Complete the sentence with the correct English synonym:\n          That is a very ____ house. (big)",
                                    "          Choose the synonym of 'big':\n          (a) large, (b) tiny, (c) small",
                                    "          Write the synonym of the following word: big"},

                            {"          tiny",
                                    "          Complete the sentence with the correct English antonym:\n          The puppy is big, but the kitten is ____. (small)",
                                    "          Choose the antonym of 'small':\n          (a) tiny, (b) large, (c) huge",
                                    "          Write the antonym of the following word: small"},

                            {"          quick",
                                    "          Complete the sentence with the correct English synonym:\n          The car is ____ and very expensive. (fast)",
                                    "          Choose the synonym of 'fast':\n          (a) quick, (b) slow, (c) sluggish",
                                    "          Write the synonym of the following word: fast"},

                            {"          sluggish",
                                    "          Complete the sentence with the correct English antonym:\n          The cheetah is fast, but the turtle is ____. (fast)",
                                    "          Choose the antonym of 'fast':\n          (a) sluggish, (b) quick, (c) rapid",
                                    "          Write the antonym of the following word: fast"},

                            {"          lovely",
                                    "          Complete the sentence with the correct English synonym:\n          The painting is ____. (beautiful)",
                                    "          Choose the synonym of 'beautiful':\n          (a) lovely, (b) hideous, (c) ugly",
                                    "          Write the synonym of the following word: beautiful"},

                            {"          hideous",
                                    "          Complete the sentence with the correct English antonym:\n          The painting is beautiful, but the wall is ____. (beautiful)",
                                    "          Choose the antonym of 'beautiful':\n          (a) hideous, (b) lovely, (c) pretty",
                                    "          Write the antonym of the following word: beautiful"},

                            {"          powerful",
                                    "          Complete the sentence with the correct English synonym:\n          She is ____ enough to lift heavy boxes. (strong)",
                                    "          Choose the synonym of 'strong':\n          (a) powerful, (b) fragile, (c) weak",
                                    "          Write the synonym of the following word: strong"},

                            {"          fragile",
                                    "          Complete the sentence with the correct English antonym:\n          He is strong, but after the illness he became ____. (strong)",
                                    "          Choose the antonym of 'strong':\n          (a) fragile, (b) mighty, (c) powerful",
                                    "          Write the antonym of the following word: strong"}
                    };
                    String[][] sinyantExpresionesComunes ={
                            {"          how’s it going?",
                                    "          Complete the sentence with the correct English synonym:\n          “____, I’m fine thanks.” (how are you?)",
                                    "          Choose the synonym of 'how are you?':\n          (a) how’s it going?, (b) goodbye, (c) see you later",
                                    "          Write the synonym of the following expression: how are you?"},

                            {"          goodbye",
                                    "          Complete the sentence with the correct English antonym:\n          Instead of saying “how are you?”, he just said ____. (how are you?)",
                                    "          Choose the antonym of 'how are you?':\n          (a) goodbye, (b) hello, (c) hi",
                                    "          Write the antonym of the following expression: how are you?"},

                            {"          it’s been a while",
                                    "          Complete the sentence with the correct English synonym:\n          “____, I missed you!” (long time no see)",
                                    "          Choose the synonym of 'long time no see':\n          (a) it’s been a while, (b) see you often, (c) daily",
                                    "          Write the synonym of the following expression: long time no see"},

                            {"          see you often",
                                    "          Complete the sentence with the correct English antonym:\n          Instead of “long time no see”, they said “____, we meet every day.” (long time no see)",
                                    "          Choose the antonym of 'long time no see':\n          (a) see you often, (b) it’s been a while, (c) rarely",
                                    "          Write the antonym of the following expression: long time no see"},

                            {"          catch you later",
                                    "          Complete the sentence with the correct English synonym:\n          Bye, ____! (see you later)",
                                    "          Choose the synonym of 'see you later':\n          (a) catch you later, (b) goodbye forever, (c) bye now",
                                    "          Write the synonym of the following expression: see you later"},

                            {"          goodbye forever",
                                    "          Complete the sentence with the correct English antonym:\n          Instead of “see you later”, she said “____ forever.” (see you later)",
                                    "          Choose the antonym of 'see you later':\n          (a) goodbye forever, (b) catch you later, (c) bye now",
                                    "          Write the antonym of the following expression: see you later"}
                    };

                    //PALABRAS VOCABULARIO JUEGO COMPLETAR ORACIONES
                    String[][] coVerbosregulares = {
                            { "          play", "          Complete the sentence with the correct English word:\n          Every Saturday morning, the children ______ football in the park with their friends.", "          Complete the sentence with the correct English word:\n          When I feel stressed, I usually ______ the guitar for at least one hour.", "          Complete the sentence with the correct English word:\n          At the party last night, they ______ different games to entertain the guests."},
                            { "          work", "          Complete the sentence with the correct English word:\n          My father usually ______ in his office until late at night because he has many responsibilities.", "          Complete the sentence with the correct English word:\n          During the summer, many students ______ in restaurants to save money for school.", "          Complete the sentence with the correct English word:\n          She ______ very hard on her project because she wants to get a promotion."},
                            { "          talk", "          Complete the sentence with the correct English word:\n          After dinner, we always ______ about our plans for the future.", "          Complete the sentence with the correct English word:\n          The teacher ______ to the students about the importance of studying every day.", "          Complete the sentence with the correct English word:\n          Yesterday, my best friend ______ to me for hours about her new job."},
                            { "          watch", "          Complete the sentence with the correct English word:\n          On weekends, my family ______ movies together in the living room.", "          Complete the sentence with the correct English word:\n          At night, he usually ______ the news to know what is happening in the world.", "          Complete the sentence with the correct English word:\n          Last summer, we ______ the stars from the beach until midnight."},
                            { "          clean", "          Complete the sentence with the correct English word:\n          Every Sunday morning, my mother ______ the entire house before visitors arrive.", "          Complete the sentence with the correct English word:\n          The workers ______ the office carefully because the manager asked them to.", "          Complete the sentence with the correct English word:\n          Yesterday, I ______ my room and found many old photos."},
                            { "          open", "          Complete the sentence with the correct English word:\n          Please ______ the window because it is very hot in here.", "          Complete the sentence with the correct English word:\n          Every morning, the shopkeeper ______ his store at 9 o’clock sharp.", "          Complete the sentence with the correct English word:\n          When she ______ the box, she discovered a beautiful gift inside."},
                            { "          help", "          Complete the sentence with the correct English word:\n          The nurse always ______ the patients with kindness and patience.", "          Complete the sentence with the correct English word:\n          My brother ______ me with my homework when I don’t understand the exercises.", "          Complete the sentence with the correct English word:\n          Yesterday, the volunteers ______ the old man carry his heavy bags."},
                            { "          start", "          Complete the sentence with the correct English word:\n          The movie ______ at 8 p.m., so we need to arrive early.", "          Complete the sentence with the correct English word:\n          Every day, she ______ her work by checking her emails first.", "          Complete the sentence with the correct English word:\n          Last week, the company ______ a new project to improve customer service."},
                            { "          call", "          Complete the sentence with the correct English word:\n          Every evening, I ______ my grandmother to ask how she is.", "          Complete the sentence with the correct English word:\n          The teacher ______ the students one by one to answer the questions.", "          Complete the sentence with the correct English word:\n          Yesterday, my friend ______ me three times because she needed urgent help."},
                            { "          live", "          Complete the sentence with the correct English word:\n          Many people ______ in big cities because there are more job opportunities.", "          Complete the sentence with the correct English word:\n          My cousins ______ in a small village near the mountains.", "          Complete the sentence with the correct English word:\n          When I was a child, we ______ in a house with a large garden."}
                    };
                    String[][] coVerbosIrregulares = {
                            { "          go", "          Complete the sentence with the correct English word:\n          Every morning, I ______ to school by bus because it is faster than walking.", "          Complete the sentence with the correct English word:\n          Last summer, we ______ to the mountains to spend our holidays together.", "          Complete the sentence with the correct English word:\n          She usually ______ to the gym after work to stay healthy."},
                            { "          eat", "          Complete the sentence with the correct English word:\n          At lunchtime, the students ______ sandwiches and fruit in the cafeteria.", "          Complete the sentence with the correct English word:\n          Yesterday, we ______ pizza while watching a movie at home.", "          Complete the sentence with the correct English word:\n          He always ______ breakfast before leaving for the office."},
                            { "          see", "          Complete the sentence with the correct English word:\n          From the top of the tower, you can ______ the entire city and the river.", "          Complete the sentence with the correct English word:\n          Last night, I ______ a shooting star while walking in the garden.", "          Complete the sentence with the correct English word:\n          She usually ______ her friends at the park on weekends."},
                            { "          take", "          Complete the sentence with the correct English word:\n          Please ______ this book with you and return it next week.", "          Complete the sentence with the correct English word:\n          Yesterday, he ______ a photo of the sunset because it looked amazing.", "          Complete the sentence with the correct English word:\n          She always ______ notes during class to remember the important details."},
                            { "          come", "          Complete the sentence with the correct English word:\n          Can you ______ to my house tomorrow to study together?", "          Complete the sentence with the correct English word:\n          Last week, many visitors ______ to the museum to see the new exhibition.", "          Complete the sentence with the correct English word:\n          He usually ______ home late because of his busy schedule."},
                            { "          drink", "          Complete the sentence with the correct English word:\n          After running in the park, I always ______ a glass of cold water.", "          Complete the sentence with the correct English word:\n          Yesterday, she ______ tea with her grandmother in the afternoon.", "          Complete the sentence with the correct English word:\n          They usually ______ coffee before starting their work in the morning."},
                            { "          write", "          Complete the sentence with the correct English word:\n          Every day, the journalist ______ articles for the local newspaper.", "          Complete the sentence with the correct English word:\n          Last month, she ______ a letter to her best friend in Canada.", "          Complete the sentence with the correct English word:\n          He usually ______ notes in his notebook during meetings."},
                            { "          begin", "          Complete the sentence with the correct English word:\n          The class will ______ at 9 a.m., so please be on time.", "          Complete the sentence with the correct English word:\n          Yesterday, the concert ______ with a beautiful piano solo.", "          Complete the sentence with the correct English word:\n          She usually ______ her day by reading the news online."},
                            { "          run", "          Complete the sentence with the correct English word:\n          Every morning, he ______ five kilometers to stay in shape.", "          Complete the sentence with the correct English word:\n          Last year, she ______ in a marathon and finished in the top ten.", "          Complete the sentence with the correct English word:\n          The children usually ______ around the playground during recess."},
                            { "          break", "          Complete the sentence with the correct English word:\n          Be careful not to ______ the glass when you wash it.", "          Complete the sentence with the correct English word:\n          Yesterday, he accidentally ______ his phone while playing football.", "          Complete the sentence with the correct English word:\n          She usually ______ her pencil when she presses too hard while writing."}
                    };
                    String[][] coSustantivos = {
                            { "          career",
                                    "          Complete the sentence with the correct English word:\n          She decided to pursue a challenging ______ in medicine because she loves helping people.",
                                    "          Complete the sentence with the correct English word:\n          After many years of dedication, he finally built a successful ______ in engineering.",
                                    "          Complete the sentence with the correct English word:\n          Choosing the right ______ can influence your happiness and financial stability in the future."
                            },
                            { "          skill",
                                    "          Complete the sentence with the correct English word:\n          Learning a new ______ such as coding can open many opportunities in the future.",
                                    "          Complete the sentence with the correct English word:\n          Public speaking is an important ______ for leaders who want to inspire others.",
                                    "          Complete the sentence with the correct English word:\n          She practiced every day to improve her piano ______ and perform confidently."
                            },
                            { "          knowledge",
                                    "          Complete the sentence with the correct English word:\n          Teachers share their ______ with students to help them understand the world better.",
                                    "          Complete the sentence with the correct English word:\n          Reading books is one of the best ways to gain ______ about history and culture.",
                                    "          Complete the sentence with the correct English word:\n          His deep ______ of science helped him solve the complex problem quickly."
                            },
                            { "          solution",
                                    "          Complete the sentence with the correct English word:\n          The engineer found a creative ______ to fix the problem in the machine.",
                                    "          Complete the sentence with the correct English word:\n          We need to find a practical ______ to reduce pollution in the city.",
                                    "          Complete the sentence with the correct English word:\n          After hours of discussion, the team finally agreed on a ______ to the conflict."
                            },
                            { "          environment",
                                    "          Complete the sentence with the correct English word:\n          We must protect the natural ______ to ensure a healthy planet for future generations.",
                                    "          Complete the sentence with the correct English word:\n          The company created a safe working ______ for all its employees.",
                                    "          Complete the sentence with the correct English word:\n          Children grow better in a positive ______ where they feel supported and loved."
                            },
                            { "          experience",
                                    "          Complete the sentence with the correct English word:\n          Traveling abroad was an unforgettable ______ that taught me many lessons.",
                                    "          Complete the sentence with the correct English word:\n          She gained valuable ______ while working as an intern in the hospital.",
                                    "          Complete the sentence with the correct English word:\n          The concert was an amazing ______ that I will never forget."
                            },
                            { "          luggage",
                                    "          Complete the sentence with the correct English word:\n          The passengers carried heavy ______ through the airport before boarding the plane.",
                                    "          Complete the sentence with the correct English word:\n          Please check your ______ before leaving the hotel to avoid forgetting anything.",
                                    "          Complete the sentence with the correct English word:\n          Her ______ was lost during the flight, so the airline had to deliver it later."
                            },
                            { "          customer",
                                    "          Complete the sentence with the correct English word:\n          The shop assistant greeted the ______ politely and offered help with the products.",
                                    "          Complete the sentence with the correct English word:\n          Every ______ expects good service when they visit a restaurant or store.",
                                    "          Complete the sentence with the correct English word:\n          The company values each ______ and tries to meet their needs effectively."
                            },
                            { "          opinion",
                                    "          Complete the sentence with the correct English word:\n          Everyone has the right to express their ______ about important social issues.",
                                    "          Complete the sentence with the correct English word:\n          In my ______, teamwork is the key to success in any project.",
                                    "          Complete the sentence with the correct English word:\n          She shared her ______ on the book, and many classmates agreed with her."
                            },
                            { "          traffic",
                                    "          Complete the sentence with the correct English word:\n          We were late because the heavy ______ delayed us for more than an hour.",
                                    "          Complete the sentence with the correct English word:\n          The city is working on new plans to reduce ______ during rush hours.",
                                    "          Complete the sentence with the correct English word:\n          Accidents often happen when there is too much ______ on the highway."
                            }
                    };
                    String[][] coPreposiciones = {
                            { "          above",
                                    "          Complete the sentence with the correct English word:\n          The stars shine brightly ______ the mountains, creating a breathtaking view at night.",
                                    "          Complete the sentence with the correct English word:\n          The helicopter hovered ______ the city, giving the passengers a clear view of the streets.",
                                    "          Complete the sentence with the correct English word:\n          The picture was placed ______ the sofa to decorate the living room."
                            },
                            { "          below",
                                    "          Complete the sentence with the correct English word:\n          The valley lies ______ the snowy peaks, surrounded by forests and rivers.",
                                    "          Complete the sentence with the correct English word:\n          The answers are written ______ the questions on the exam paper.",
                                    "          Complete the sentence with the correct English word:\n          The basement is located ______ the main floor of the house."
                            },
                            { "          between",
                                    "          Complete the sentence with the correct English word:\n          The playground is located ______ the school and the library, making it easy to find.",
                                    "          Complete the sentence with the correct English word:\n          She sat ______ her two best friends during the ceremony.",
                                    "          Complete the sentence with the correct English word:\n          The negotiations took place ______ the government and the workers’ union."
                            },
                            { "          among",
                                    "          Complete the sentence with the correct English word:\n          She felt comfortable ______ her classmates because they welcomed her warmly.",
                                    "          Complete the sentence with the correct English word:\n          The treasure was hidden ______ the trees in the forest.",
                                    "          Complete the sentence with the correct English word:\n          There was a sense of excitement ______ the fans before the concert began."
                            },
                            { "          inside",
                                    "          Complete the sentence with the correct English word:\n          The documents are stored ______ the drawer to keep them safe.",
                                    "          Complete the sentence with the correct English word:\n          The children stayed ______ the house because it was raining heavily.",
                                    "          Complete the sentence with the correct English word:\n          The cat is hiding ______ the box, waiting to surprise its owner."
                            },
                            { "          outside",
                                    "          Complete the sentence with the correct English word:\n          The kids are playing ______ the house because the weather is sunny.",
                                    "          Complete the sentence with the correct English word:\n          There is a bench ______ the building where people can rest.",
                                    "          Complete the sentence with the correct English word:\n          The dog waited patiently ______ the store until its owner returned."
                            },
                            { "          onto",
                                    "          Complete the sentence with the correct English word:\n          The child climbed ______ the chair to reach the cookies on the table.",
                                    "          Complete the sentence with the correct English word:\n          The ball rolled ______ the roof after the strong wind blew it away.",
                                    "          Complete the sentence with the correct English word:\n          She stepped ______ the stage confidently to deliver her speech."
                            },
                            { "          off",
                                    "          Complete the sentence with the correct English word:\n          Please take your shoes ______ before entering the house.",
                                    "          Complete the sentence with the correct English word:\n          The bird suddenly flew ______ the branch and disappeared into the sky.",
                                    "          Complete the sentence with the correct English word:\n          He fell ______ the bike because the road was slippery."
                            },
                            { "          around",
                                    "          Complete the sentence with the correct English word:\n          The children ran ______ the playground laughing and shouting with joy.",
                                    "          Complete the sentence with the correct English word:\n          There are many shops ______ the central square of the town.",
                                    "          Complete the sentence with the correct English word:\n          She wrapped a scarf ______ her neck to stay warm."
                            },
                            { "          near",
                                    "          Complete the sentence with the correct English word:\n          There is a small café ______ the station where we can wait for the train.",
                                    "          Complete the sentence with the correct English word:\n          The school is located ______ the park, making it easy for children to play after class.",
                                    "          Complete the sentence with the correct English word:\n          He bought a house ______ the beach to enjoy the ocean view."
                            }
                    };
                    String[][] coAdjetivos = {
                            { "          happy",
                                    "          Complete the sentence with the correct English word:\n          She felt ______ when she received the news that she had passed all her exams.",
                                    "          Complete the sentence with the correct English word:\n          The children were ______ to see their grandparents after such a long time.",
                                    "          Complete the sentence with the correct English word:\n          He was truly ______ on his wedding day, surrounded by family and friends."
                            },
                            { "          sad",
                                    "          Complete the sentence with the correct English word:\n          She looked ______ after hearing that her best friend was moving to another country.",
                                    "          Complete the sentence with the correct English word:\n          The movie was so ______ that many people cried at the end.",
                                    "          Complete the sentence with the correct English word:\n          He felt ______ because he couldn’t attend the party with his friends."
                            },
                            { "          big",
                                    "          Complete the sentence with the correct English word:\n          They live in a ______ house with a large garden and swimming pool.",
                                    "          Complete the sentence with the correct English word:\n          The company made a ______ investment in new technology last year.",
                                    "          Complete the sentence with the correct English word:\n          She carried a ______ box that was too heavy for her alone."
                            },
                            { "          small",
                                    "          Complete the sentence with the correct English word:\n          He bought a ______ car because it was easier to park in the city.",
                                    "          Complete the sentence with the correct English word:\n          The child held a ______ toy in his hands and smiled.",
                                    "          Complete the sentence with the correct English word:\n          They live in a ______ apartment near the university."
                            },
                            { "          fast",
                                    "          Complete the sentence with the correct English word:\n          The cheetah is a ______ animal that can run at incredible speeds.",
                                    "          Complete the sentence with the correct English word:\n          She typed so ______ that she finished the report in half the time.",
                                    "          Complete the sentence with the correct English word:\n          The train was very ______ and arrived earlier than expected."
                            },
                            { "          slow",
                                    "          Complete the sentence with the correct English word:\n          The old man walked ______ along the path, enjoying the scenery.",
                                    "          Complete the sentence with the correct English word:\n          The internet connection was so ______ that it took hours to download the file.",
                                    "          Complete the sentence with the correct English word:\n          He spoke ______ so that everyone could understand his explanation clearly."
                            },
                            { "          beautiful",
                                    "          Complete the sentence with the correct English word:\n          The garden looked ______ in spring, full of colorful flowers and green trees.",
                                    "          Complete the sentence with the correct English word:\n          She wore a ______ dress that caught everyone’s attention at the party.",
                                    "          Complete the sentence with the correct English word:\n          The sunset over the ocean was truly ______ and unforgettable."
                            },
                            { "          ugly",
                                    "          Complete the sentence with the correct English word:\n          The building looked ______ because it hadn’t been painted in years.",
                                    "          Complete the sentence with the correct English word:\n          He thought the shoes were ______, but his sister liked them.",
                                    "          Complete the sentence with the correct English word:\n          The monster in the movie was so ______ that the children screamed."
                            },
                            { "          strong",
                                    "          Complete the sentence with the correct English word:\n          She is a ______ woman who never gives up, even in difficult times.",
                                    "          Complete the sentence with the correct English word:\n          The bridge is ______ enough to support thousands of cars every day.",
                                    "          Complete the sentence with the correct English word:\n          He became ______ after months of training at the gym."
                            },
                            { "          weak",
                                    "          Complete the sentence with the correct English word:\n          After being sick for a week, he felt too ______ to go back to work.",
                                    "          Complete the sentence with the correct English word:\n          The chair was so ______ that it broke when someone sat on it.",
                                    "          Complete the sentence with the correct English word:\n          She was ______ after the long race and needed to rest."
                            }
                    };
                    String[][] coExpresionesComunes = {
                            { "          How are you?",
                                    "          Complete the sentence with the correct English expression:\n          When I meet my friend after class, I usually greet her by saying ______.",
                                    "          Complete the sentence with the correct English expression:\n          At the beginning of the phone call, he asked politely ______ to show interest.",
                                    "          Complete the sentence with the correct English expression:\n          She smiled and said ______ when she saw her neighbor in the morning."
                            },
                            { "          What’s up?",
                                    "          Complete the sentence with the correct English expression:\n          When I saw my cousin at the party, I casually said ______ to start the conversation.",
                                    "          Complete the sentence with the correct English expression:\n          He walked into the room and greeted everyone with a cheerful ______.",
                                    "          Complete the sentence with the correct English expression:\n          Friends often say ______ when they want to know what’s happening."
                            },
                            { "          Long time no see",
                                    "          Complete the sentence with the correct English expression:\n          After meeting an old classmate at the mall, she exclaimed ______ with excitement.",
                                    "          Complete the sentence with the correct English expression:\n          He greeted his former teacher by saying ______ because they hadn’t met in years.",
                                    "          Complete the sentence with the correct English expression:\n          When I saw my neighbor after months, I said ______ with a big smile."
                            },
                            { "          Take care",
                                    "          Complete the sentence with the correct English expression:\n          Before leaving for her trip, her mother hugged her and said ______ warmly.",
                                    "          Complete the sentence with the correct English expression:\n          He ended the email with the words ______ to show kindness.",
                                    "          Complete the sentence with the correct English expression:\n          When saying goodbye to a friend, it’s common to say ______."
                            },
                            { "          See you later",
                                    "          Complete the sentence with the correct English expression:\n          After finishing lunch, he waved at his friend and said ______ before leaving.",
                                    "          Complete the sentence with the correct English expression:\n          She told her classmates ______ because they would meet again in the afternoon.",
                                    "          Complete the sentence with the correct English expression:\n          At the end of the meeting, the manager smiled and said ______ to everyone."
                            },
                            { "          Nice to meet you",
                                    "          Complete the sentence with the correct English expression:\n          When introduced to a new colleague, she said ______ politely.",
                                    "          Complete the sentence with the correct English expression:\n          He shook hands and said ______ during the interview.",
                                    "          Complete the sentence with the correct English expression:\n          At the party, she greeted the guest with a smile and said ______."
                            },
                            { "          Have a good day",
                                    "          Complete the sentence with the correct English expression:\n          The cashier smiled and said ______ after giving me the receipt.",
                                    "          Complete the sentence with the correct English expression:\n          She ended her message with ______ to wish her friend well.",
                                    "          Complete the sentence with the correct English expression:\n          Before leaving the office, he told his coworkers ______."
                            },
                            { "          Don’t worry",
                                    "          Complete the sentence with the correct English expression:\n          When she forgot her homework, the teacher said ______ and gave her another chance.",
                                    "          Complete the sentence with the correct English expression:\n          He told his friend ______ because the problem was already solved.",
                                    "          Complete the sentence with the correct English expression:\n          She comforted her brother by saying ______ after he made a mistake."
                            },
                            { "          It’s up to you",
                                    "          Complete the sentence with the correct English expression:\n          When deciding where to eat, he said ______ to let his friend choose.",
                                    "          Complete the sentence with the correct English expression:\n          She told her team ______ because they could decide the best strategy.",
                                    "          Complete the sentence with the correct English expression:\n          He shrugged and said ______ when asked about the movie choice."
                            },
                            { "          By the way",
                                    "          Complete the sentence with the correct English expression:\n          She added ______ at the end of the conversation to mention something important.",
                                    "          Complete the sentence with the correct English expression:\n          He said ______ before reminding his friend about the meeting tomorrow.",
                                    "          Complete the sentence with the correct English expression:\n          During the discussion, she used ______ to introduce a new topic."
                            }
                    };
                    //PALABRAS VOCABULARIO ADIVIDAR PALABRAS (ap)
                    String[][] apVerboregulares = {
                            {"          play", "          Try to guess the next word\n          P__y", "          Try to guess the next word\n          Pl__", "          Try to guess the next word\n          __ay" },
                            {"          work","          Try to guess the next word\n          W__k","          Try to guess the next word\n          Wo__","T          ry to guess the next word\n          __rk"},
                            {"          talk","          Try to guess the next word\n          T__k","          Try to guess the next word\n          Ta__","          Try to guess the next word\n          __lk"},
                            {"          watch","          Try to guess the next word\n          W___h","          Try to guess the next word\n          Wa___","          Try to guess the next word\n          ___hc"},
                            {"          clean","          Try to guess the next word\n          C___n","          Try to guess the next word\n          Cl___","          Try to guess the next word\n          ___an"},
                            {"          open","          Try to guess the next word\n          O__n","          Try to guess the next word\n          Op__","          Try to guess the next word\n          __en"},
                            {"          help","          Try to guess the next word\n          H__p","          Try to guess the next word\n          He__","          Try to guess the next word\n          __lp"},
                            {"          start","          Try to guess the next word\n          S___t","          Try to guess the next word\n          St___","          Try to guess the next word\n          ___rt"},
                            {"          call","          Try to guess the next word\n          C__l","          Try to guess the next word\n          Ca__","          Try to guess the next word\n          __ll"},
                            {"          live","          Try to guess the next word\n          L__e","          Try to guess the next word\n          Li__","          Try to guess the next word\n          __ve"}
                    };
                    String[][] apVerboIrregulares = {
                            {"          go", "          Try to guess the next word\n          G_", "          Try to guess the next word\n          _o", "          Try to guess the next word\n          _o"},
                            {"          eat", "          Try to guess the next word\n          E__", "          Try to guess the next word\n          _at", "          Try to guess the next word\n          Ea_"},
                            {"          see", "          Try to guess the next word\n          S_e", "          Try to guess the next word\n          _ee", "          Try to guess the next word\n          Se_"},
                            {"          take", "          Try to guess the next word\n          T_k_", "          Try to guess the next word\n          Ta__", "          Try to guess the next word\n          __ke"},
                            {"          come", "          Try to guess the next word\n          C_me", "          Try to guess the next word\n          Co__", "          Try to guess the next word\n          __me"},
                            {"          drink", "          Try to guess the next word\n          D__nk", "          Try to guess the next word\n          Dr___", "          Try to guess the next word\n          ___nk"},
                            {"          write", "          Try to guess the next word\n          Wr__e", "          Try to guess the next word\n          Wr___", "          Try to guess the next word\n          ___te"},
                            {"          begin", "          Try to guess the next word\n          B____", "          Try to guess the next word\n          Be___", "          Try to guess the next word\n          ___in"},
                            {"          run", "          Try to guess the next word\n          R__", "          Try to guess the next word\n          Ru_", "          Try to guess the next word\n          _un"},
                            {"          break", "          Try to guess the next word\n          B__ak", "          Try to guess the next word\n          Br___", "          Try to guess the next word\n          ___ak"}
                    };
                    String[][] apSustantivo = {
                            {"          career", "          Try to guess the next word\n          C____r", "          Try to guess the next word\n          Ca__er", "          Try to guess the next word\n          ___eer"},
                            {"          skill", "          Try to guess the next word\n          S___l", "          Try to guess the next word\n          Sk___", "          Try to guess the next word\n          ___ill"},
                            {"          knowledge", "          Try to guess the next word\n          Know____e", "          Try to guess the next word\n          Kn_____ge", "          Try to guess the next word\n          ___wledge"},
                            {"          solution", "          Try to guess the next word\n          S_____on", "          Try to guess the next word\n          Solu____", "          Try to guess the next word\n          ____tion"},
                            {"          environment", "          Try to guess the next word\n          E_____nment", "          Try to guess the next word\n          En____nment", "          Try to guess the next word\n          _______ment"},
                            {"          experience", "          Try to guess the next word\n          Ex____ence", "          Try to guess the next word\n          Ex______ce", "          Try to guess the next word\n          ______ence"},
                            {"          luggage", "          Try to guess the next word\n          L___age", "          Try to guess the next word\n          Lu___ge", "          Try to guess the next word\n          ___gage"},
                            {"          customer", "          Try to guess the next word\n          C____mer", "          Try to guess the next word\n          Cu____er", "          Try to guess the next word\n          ____omer"},
                            {"          opinion", "          Try to guess the next word\n          Opi____", "          Try to guess the next word\n          Op___on", "          Try to guess the next word\n          ___nion"},
                            {"          traffic", "          Try to guess the next word\n          T____ic", "          Try to guess the next word\n          Tr___ic", "          Try to guess the next word\n          ___ffic"}
                    };
                    String[][] apPreposiciones = {
                            {"          above", "          Try to guess the next word\n          Ab__e", "          Try to guess the next word\n          Ab___", "          Try to guess the next word\n          __ove"},
                            {"          below", "          Try to guess the next word\n          B_l_w", "          Try to guess the next word\n          Be___", "          Try to guess the next word\n          __low"},
                            {"          between", "          Try to guess the next word\n          B_tw__n", "          Try to guess the next word\n          Be_w___", "          Try to guess the next word\n          ___ween"},
                            {"          among", "          Try to guess the next word\n          A__ng", "          Try to guess the next word\n          Am___", "          Try to guess the next word\n          __ong"},
                            {"          inside", "          Try to guess the next word\n          In___e", "          Try to guess the next word\n          In____", "          Try to guess the next word\n          __side"},
                            {"          outside", "          Try to guess the next word\n          O_t___e", "          Try to guess the next word\n          Ou___de", "          Try to guess the next word\n          ___side"},
                            {"          onto", "          Try to guess the next word\n          O_to", "          Try to guess the next word\n          On__", "          Try to guess the next word\n          __to"},
                            {"          off", "          Try to guess the next word\n          O_f", "          Try to guess the next word\n          Of_", "          Try to guess the next word\n          _ff"},
                            {"          around", "          Try to guess the next word\n          Aro__d", "          Try to guess the next word\n          Ar____", "          Try to guess the next word\n          __ound"},
                            {"          near", "          Try to guess the next word\n          N_ar", "          Try to guess the next word\n          Ne__", "          Try to guess the next word\n          __ar"}
                    };
                    String[][] apAdjetivos = {
                            {"          happy", "          Try to guess the next word\n          H___y", "          Try to guess the next word\n          Ha___", "          Try to guess the next word\n          __ppy"},
                            {"          sad", "          Try to guess the next word\n          S__", "          Try to guess the next word\n          Sa_", "          Try to guess the next word\n          _ad"},
                            {"          big", "          Try to guess the next word\n          B__", "          Try to guess the next word\n          Bi_", "          Try to guess the next word\n          _ig"},
                            {"          small", "          Try to guess the next word\n          S____", "          Try to guess the next word\n          Sm___", "          Try to guess the next word\n          __all"},
                            {"          fast", "          Try to guess the next word\n          F___", "          Try to guess the next word\n          Fa__", "          Try to guess the next word\n          __st"},
                            {"          slow", "          Try to guess the next word\n          S___", "          Try to guess the next word\n          Sl__", "          Try to guess the next word\n          __ow"},
                            {"          beautiful", "          Try to guess the next word\n          Bea_____l", "          Try to guess the next word\n          Be_uti__l", "          Try to guess the next word\n          ___utiful"},
                            {"          ugly", "          Try to guess the next word\n          U___", "          Try to guess the next word\n          Ug__", "          Try to guess the next word\n          __ly"},
                            {"          strong", "          Try to guess the next word\n          Str__g", "          Try to guess the next word\n          St_on_", "          Try to guess the next word\n          __rong"},
                            {"          weak", "          Try to guess the next word\n          W___", "          Try to guess the next word\n          We__", "          Try to guess the next word\n          __ak"}
                    };
                    String[][] apExpresionescomunes = {
                            {"          How are you?", "          Try to guess the next word\n          H__ are you?", "          Try to guess the next word\n          Ho_ ___ you?", "          Try to guess the next word\n          __w are you?"},
                            {"          What’s up?", "          Try to guess the next word\n          W___’s up?", "          Try to guess the next word\n          Wh__’s __", "          Try to guess the next word\n          __at’s up?"},
                            {"          Long time no see", "          Try to guess the next word\n          L___ time no see", "          Try to guess the next word\n          Lo__ ____ no see", "          Try to guess the next word\n          ___g time no see"},
                            {"          Take care", "          Try to guess the next word\n          T___ care", "          Try to guess the next word\n          Ta__ ____", "          Try to guess the next word\n          ___e care"},
                            {"          See you later", "          Try to guess the next word\n          S__ you later", "          Try to guess the next word\n          Se_ ___ later", "          Try to guess the next word\n          __e you later"},
                            {"          Nice to meet you", "          Try to guess the next word\n          N___ to meet you", "          Try to guess the next word\n          Ni__ __ meet you", "          Try to guess the next word\n          ___e to meet you"},
                            {"          Have a good day", "          Try to guess the next word\n          H___ a good day", "          Try to guess the next word\n          Ha__ a go__ day", "          Try to guess the next word\n          ___e a good day"},
                            {"          Don’t worry", "          Try to guess the next word\n          D__'_ worry", "          Try to guess the next word\n          Do_'_ __rry", "          Try to guess the next word\n          __n’t worry"},
                            {"          It’s up to you", "          Try to guess the next word\n          I_'_ up to you", "          Try to guess the next word\n          It'_ __ to you", "          Try to guess the next word\n          __’s up to you"},
                            {"          By the way", "          Try to guess the next word\n          B_ the way", "          Try to guess the next word\n          By_ ___ way", "          Try to guess the next word\n          ___ the way"}
                    
                    };
                    int nivelVocabulario;
                    System.out.println("            Ingresa la categoría gramatical que deseas estudiar (recuerda que se dara por hecho que ya has cursado las categorías gramaticales anterirores a ella):");
                    System.out.println("            1.Verbo\n" + "            2.Sustantivo\n" + "            3.Preposiciones\n" + "            4.Adjetivos\n" + "            5.Expresiones comunes");

                    do {
                        System.out.print("            ");
                        nivelVocabulario = sc.nextInt();
                        switch (nivelVocabulario) {
                            case 1:
                                nnombre = "Verbo";
                                int formadeverbo;
                                System.out.println("\n          Selecciona la forma de verbo que deseas estudiar");
                                System.out.println("          1.Verbos Regulares\n" + "          2.Verbos Irregulares");
                                System.out.print("          ");
                                formadeverbo = sc.nextInt();
                                System.out.println("           ");
                                do {
                                    switch (formadeverbo) {
                                        case 1:
                                            System.out.println("          Has elegido verbos regulares");
                                            PALABRAS_VOCABULARIO = nvVerboregulares;
                                            PALABRAS_RELACIONADAS = sinyantVerbosRegulares;
                                            COMPLETAR_ORACIONES = coVerbosregulares;
                                            ADIVINAR_PALABRAS = apVerboregulares;
                                            break;
                                        case 2:
                                            System.out.println("          Has elegido verbos irregulares");
                                            PALABRAS_VOCABULARIO = nvVerbosirregulares;
                                            PALABRAS_RELACIONADAS = sinyantVerbosIrregulares;
                                            COMPLETAR_ORACIONES = coVerbosIrregulares;
                                            ADIVINAR_PALABRAS = apVerboIrregulares;
                                            break;
                                        default:
                                            System.out.print("          Opción invalida, debes ingresar 1 o 2. Intenta de nuevo: ");
                                            break;
                                    }
                                }
                                while (formadeverbo < 1 || formadeverbo > 2);
                                break;

                            case 2:
                                nnombre = "Sustantivo";
                                PALABRAS_VOCABULARIO = nvSustantivo;
                                PALABRAS_RELACIONADAS = sinyantSustantivos;
                                COMPLETAR_ORACIONES = coSustantivos;
                                ADIVINAR_PALABRAS = apSustantivo;
                                break;

                            case 3:
                                nnombre = "Preposiciones";
                                PALABRAS_VOCABULARIO = nvPreposiciones;
                                PALABRAS_RELACIONADAS = sinyantPreposiciones;
                                COMPLETAR_ORACIONES = coPreposiciones;
                                ADIVINAR_PALABRAS = apPreposiciones;
                                break;

                            case 4:
                                nnombre = "Adjetivos";
                                PALABRAS_VOCABULARIO = nvAdjetivos;
                                PALABRAS_RELACIONADAS = sinyantAdjetivos;
                                COMPLETAR_ORACIONES = coAdjetivos;
                                ADIVINAR_PALABRAS = apAdjetivos;
                                break;

                            case 5:
                                nnombre = "Expresiones comunes";
                                PALABRAS_VOCABULARIO = nvExpresionescomunes;
                                PALABRAS_RELACIONADAS = sinyantExpresionesComunes;
                                COMPLETAR_ORACIONES = coExpresionesComunes;
                                ADIVINAR_PALABRAS = apExpresionescomunes;
                                break;

                            default:
                                System.out.print("          Opción invalida. Ese número no corresponde a ninguna categoría gramatical. Intenta de nuevo: ");
                                break;

                        }
                    }
                    while (nivelVocabulario < 1 || nivelVocabulario > 5);

                    System.out.println("                  +=========================================================+");
                    System.out.println("                  ||       Ahora elige la modalidad                        ||");
                    System.out.println("                  ||       1. Modalidad Tradicional                        ||");
                    System.out.println("                  ||       2. Modalidad Juegos                             ||");
                    System.out.println("                  +=========================================================+");
                    System.out.print("\n\n                  Ingresa 1 o 2:\n ");
                    System.out.print("                 ");
                    int modalidadVocabulario;
                    do {
                        modalidadVocabulario = sc.nextInt();
                        switch (modalidadVocabulario) {
                            case 1:
                                allnombre = "Vocabulario Modalidad Tradicional";
                                modalidadTradicionalVocabulario();
                                break;
                            case 2:
                                modalidadJuegosVocabulario();
                                break;
                            default:
                                System.out.print("          Opción invalida, Esa opción no corresponde a ninguna modalidad. Intenta de nuevo: ");
                                break;
                        }
                    }
                    while (modalidadVocabulario != 1 && modalidadVocabulario != 2);
                    break;
                default:
                    System.out.print("          Opción invalida, debes ingresar 1 o 2. Intenta de nuevo: ");
            }
        }
        while (opcionprincipal != 1 && opcionprincipal != 2);
    }


    public static void pause(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
        }
    }

    public static void contador() {
        pause(4000);
        System.out.println("          ¿Estás list@?...\n");
        System.out.println("          Presiona ENTER para continuar...\n");
        sc.nextLine();
        sc.nextLine();
        System.out.println("          Mucha Suerte!!\n");
        pause(800);
        System.out.println("                            __    __    __    __    __    __    __  ");
        System.out.println("                           /  \\__/  \\__/  \\__/  \\__/  \\__/  \\__/  \\ ");
        System.out.println("                           \\__/  \\__/  \\__/  \\__/  \\__/  \\__/  \\__/  ");
        System.out.println("                           /  \\__/  \\__/  \\__/  \\__/  \\__/  \\__/  \\ ");
        System.out.println("                                       Ronda Inicia en...\n");

        pause(1200);
        for (int i = 3; i > 0; i--) {
            System.out.println("                                              "+i);
            pause(1200);
        }
        System.out.println("                                           "+"Inicia!!");
        System.out.println("                            __    __    __    __    __    __    __    ");
        System.out.println("                           /  \\__/  \\__/  \\__/  \\__/  \\__/  \\__/  \\ ");
        System.out.println("                           \\__/  \\__/  \\__/  \\__/  \\__/  \\__/  \\__/ ");

    }

    public static void bienvenida() {
        pause(800);
        System.out.println("\n          Cargando instrucciones...\n");
        pause(1500);
        System.out.println("          ¡Bienvenid@ " + usuario + " :D!\n\n          A continuación iniciará la ronda de " + allnombre + ", en " + nivel + " " + nnombre+"\n");
        System.out.println("          ---------------------8<-------------[Instrucciones:]-----------------------\n");

    }
    public static String[][] obtenerMatrizPorNivel() {
        switch (nivelSpellingBee) {
            case 1:
                return nsbBasico;
            case 2:
                return nsbMedio;
            case 3:
                return nsbNormal;
            case 4:
                return nsbDificil;
            case 5:
                return nsbExpert;
            default:
                return nsbBasico; // solo formalidad
        }
    }



    public static void modalidadTradicionalSpellingBee() {

        String[][] matriz = obtenerMatrizPorNivel();

        aciertos = 0;
        errores = 0;
        contadorFallos = 0;
        for (int i = 0; i < palabrasFalladas.length; i++) palabrasFalladas[i] = -1;
        String artTradicional=("          ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                "          ~ _________                      __   _           _                          __  ~\n" +
                "          ~|  _   _  |                    |  ] (_)         (_)                        [  | ~\n" +
                "          ~|_/ | | \\_|_ .--.  ,--.    .--.| |  __   .---.  __   .--.   _ .--.   ,--.   | | ~\n" +
                "          ~    | |   [ `/'`\\]`'_\\ : / /'`\\' | [  | / /'`\\][  |/ .'`\\ \\[ `.-. | `'_\\ :  | | ~\n" +
                "          ~   _| |_   | |    // | |,| \\__/  |  | | | \\__.  | || \\__. | | | | | // | |, | | ~\n" +
                "          ~  |_____| [___]   \\'-;__/ '.__.;__][___]'.___.'[___]'.__.' [___||__]\\'-;__/[___]~\n" +
                "          ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(artTradicional);
        bienvenida();
        System.out.println("          1- Se te mostrará la traducción, la definición en inglés de una palabra, o una oración con un espacio en blanco.\n          2- Escribe la palabra correcta.\n          3- Cada intento recibe retroalimentación inmediata.\n          4- Al final verás tu resumen.");
        contador();

        // PRIMERA RONDA
        for (int i = 0; i < 10; i++) {
            int pista = (int) (Math.random() * 3);
            pistaUsada[i] = pista;

            String prompt = matriz[i][pista + 1];
            System.out.println("Pregunta " + (i + 1) + ":");
            System.out.println(prompt);

            System.out.print("Tu respuesta: ");
            String respuesta = sc.nextLine().trim();

            String correcta = matriz[i][0].trim();

            if (respuesta.equalsIgnoreCase(correcta)) {
                System.out.println("\n✔ Correcto!");
                aciertos++;
            } else {
                System.out.println("\n✘ Incorrecto. La respuesta correcta era: " + correcta);
                errores++;
                palabrasFalladas[contadorFallos++] = i;
            }

            System.out.println("          Presiona ENTER para continuar...");
            sc.nextLine();
        }

        // SEGUNDA RONDA
        if (contadorFallos > 0) {
            System.out.println("\n          --- Ronda de repaso para palabras falladas ---");
            for (int f = 0; f < contadorFallos; f++) {

                int indicePalabra = palabrasFalladas[f];

                int pista2;
                do {
                    pista2 = (int) (Math.random() * 3);
                } while (pista2 == pistaUsada[indicePalabra]);

                String prompt2 = matriz[indicePalabra][pista2 + 1];
                System.out.println("\nRepetición palabra " + (f + 1) + ":");
                System.out.println(prompt2);

                System.out.print("Tu respuesta: ");
                String respuesta2 = sc.nextLine().trim().toLowerCase();

                String correcta2 = matriz[indicePalabra][0].toLowerCase();

                if (respuesta2.equals(correcta2)) {
                    System.out.println("✔ Correcto!");
                    aciertos++;
                } else {
                    System.out.println("✘ Incorrecto de nuevo. La correcta era: " + correcta2);
                    errores++;
                }

                System.out.println("          Presiona ENTER para continuar...");
                sc.nextLine();
            }
        }

        // RESUMEN FINAL
        System.out.println("\n--- RESULTADOS FINALES ---");
        System.out.println("Aciertos: " + aciertos);
        System.out.println("Errores: " + errores);

        if (contadorFallos > 0) {
            System.out.print("Palabras que preguntamos otra vez: ");
            for (int i = 0; i < contadorFallos; i++) {
                System.out.print(matriz[palabrasFalladas[i]][0] + (i < contadorFallos - 1 ? ", " : "\n"));
            }
        }
    }



    public static void modalidadRetosyJuegosSpellingBee() {
        System.out.println("          Has elegido la Modalidad Retos y Juegos, en el nivel " + nnombre);
        System.out.println("          ¿Deseas cursar 1- Retos o 2-Juegos?");
        int sbRetoJuego;
        do {
            System.out.print("          ");
            sbRetoJuego = sc.nextInt();
            switch (sbRetoJuego) {
                case 1:
                    String artRetoSpb=("          __________        __                \n" +
                            "          \\______   \\ _____/  |_  ____  ______\n" +
                            "           |       _// __ \\   __\\/  _ \\/  ___/\n" +
                            "           |    |   \\  ___/|  | (  <_> )___ \\ \n" +
                            "           |____|_  /\\___  >__|  \\____/____  >\n" +
                            "                  \\/     \\/                \\/ \n");
                    System.out.println(artRetoSpb);
                    System.out.println("          ");
                    System.out.println("          ¡Excelente decisión! Ahora porfavor ingresa el numero de reto que te gustaría jugar\n          1- Deletreo Rápido\n          2- Desafío de Precisión");
                    int sbReto;
                    do {
                        sbReto = sc.nextInt();
                        switch (sbReto) {
                            case 1:
                                allnombre = "reto Deletreo Rápido";
                                sbrDeletreoRapido();
                                break;
                            case 2:
                                allnombre = "reto Desafio de Precisión";
                                sbrDesafioPrecision();
                                break;
                            default:
                                System.out.print("          Opción invalida. Ese número no corresponde a ningun reto. Intenta de nuevo: ");
                                break;
                        }
                    }
                    while (sbReto < 1 || sbReto > 3);
                    break;
                case 2:
                    String artJuegoSpb=("               ___  __   __  _______  _______  _______  _______ \n" +
                            "              |   ||  | |  ||       ||       ||       ||       |\n" +
                            "              |   ||  | |  ||    ___||    ___||   _   ||  _____|\n" +
                            "              |   ||  |_|  ||   |___ |   | __ |  | |  || |_____ \n" +
                            "           ___|   ||       ||    ___||   ||  ||  |_|  ||_____  |\n" +
                            "          |       ||       ||   |___ |   |_| ||       | _____| |\n" +
                            "          |_______||_______||_______||_______||_______||_______|\n");
                    System.out.println(artJuegoSpb);
                    System.out.println("          ¡Excelente decisión! Ahora porfavor ingresa el numero de juego que te gustaría jugar\n          1- Ahorcado\n          2- Completar letras faltantes\n          3- Ordenar letras");
                    int sbJuego;
                    do {
                        System.out.print("          ");
                        sbJuego = sc.nextInt();
                        switch (sbJuego) {
                            case 1:
                                allnombre = "juego Ahorcado";
                                sbjAhorcado();
                                break;
                            case 2:
                                allnombre = "juego Completar Letras Faltantes";
                                sbjCompletarLetrasFaltantes();
                                break;
                            case 3:
                                allnombre = "juego Ordenar Letras";
                                sbjOrdenarLetras();
                                break;
                            default:
                                System.out.print("          Opción invalida. Ese número no corresponde a ningun juego. Intenta de nuevo: ");
                                break;
                        }
                    }
                    while (sbJuego < 1 || sbJuego > 3);
                    break;
                default:
                    System.out.print("          Opción invalida. Ese número no corresponde a ninguna opcion. Intenta de nuevo: ");
                    break;
            }
        }
        while (sbRetoJuego != 1 && sbRetoJuego != 2);
    }

    public static void sbrDeletreoRapido() {
        String artDeletreo = ("          ________     ______    _____                   \n" +
                "          ___  __ \\_______  /______  /__________________ \n" +
                "          __  / / /  _ \\_  /_  _ \\  __/_  ___/  _ \\  __ \\\n" +
                "          _  /_/ //  __/  / /  __/ /_ _  /   /  __/ /_/ /\n" +
                "          /_____/ \\___//_/  \\___/\\__/ /_/    \\___/\\____/ \n" +
                "                                               \n" +
                "          ________               ______________          \n" +
                "          ___  __ \\_____ ___________(_)_____  /_____     \n" +
                "          __  /_/ /  __ `/__  __ \\_  /_  __  /_  __ \\    \n" +
                "          _  _, _// /_/ /__  /_/ /  / / /_/ / / /_/ /    \n" +
                "          /_/ |_| \\__,_/ _  .___//_/  \\__,_/  \\____/     \n" +
                "                         /_/                             ");
        System.out.println(artDeletreo);
        String[][] matriz = obtenerMatrizPorNivel();
        aciertos = 0;
        errores = 0;

        bienvenida();
        System.out.println("En este reto deberás:\n-Escribir la mayor cantidad de palabras correctamente en 1 MINUTO (60 segundos).\n-La pista será siempre la traducción al español.\n-No hay límite de errores; solo el tiempo.");
        contador();


        long tiempoInicio = System.currentTimeMillis();
        long duracionLimite = 60000;


        int palabraActualIndex = 0;


        String[] palabrasFalladasRapido = new String[matriz.length * 2];
        int indiceFalladasRapido = 0;

        sc.nextLine();

        System.out.println("--- ¡INICIA EL RETO! Tienes 1 minuto. ---");


        while (System.currentTimeMillis() - tiempoInicio < duracionLimite) {


            int indice = palabraActualIndex % matriz.length;
            String palabraCorrecta = matriz[indice][0].trim();
            String pistaTraduccion = matriz[indice][3];


            long tiempoTranscurrido = System.currentTimeMillis() - tiempoInicio;
            long tiempoRestante = (duracionLimite - tiempoTranscurrido) / 1000;

            System.out.println("\n(Tiempo restante: " + tiempoRestante + "s) | Palabra #" + (palabraActualIndex + 1));
            System.out.println(pistaTraduccion);


            if (tiempoRestante <= 0) {
                break;
            }

            System.out.print("Tu respuesta: ");
            String respuesta = sc.nextLine().trim();


            if (System.currentTimeMillis() - tiempoInicio >= duracionLimite) {
                System.out.println("\n*** ¡TIEMPO TERMINADO! Su respuesta fue fuera de tiempo. ***");
                break;
            }


            if (respuesta.equalsIgnoreCase(palabraCorrecta)) {
                System.out.println("✔ ¡CORRECTO!");
                aciertos++;
            } else {
                System.out.println("✘ INCORRECTO. La respuesta correcta era: " + palabraCorrecta);
                errores++;
                if (indiceFalladasRapido < palabrasFalladasRapido.length) {
                    palabrasFalladasRapido[indiceFalladasRapido] = palabraCorrecta;
                    indiceFalladasRapido++;
                }
            }

            palabraActualIndex++;
        }


        System.out.println("\n--- ¡TIEMPO TERMINADO! ---");
        System.out.println("--- RESULTADOS RETO DELETREO RÁPIDO (" + nnombre + ") ---");
        System.out.println("Total de palabras intentadas: " + palabraActualIndex);
        System.out.println("✔ Aciertos: " + aciertos);
        System.out.println("✘ Errores: " + errores);

        if (indiceFalladasRapido > 0) {
            System.out.println("\nPalabras falladas (para repasar):");
            for (int i = 0; i < indiceFalladasRapido; i++) {
                System.out.print(palabrasFalladasRapido[i] + (i < indiceFalladasRapido - 1 ? ", " : ""));
            }
            System.out.println();
        }
    }

    public static void sbrDesafioPrecision() {
        String artPrecision=("          _____  _______________________________________     _____  _______\n" +
                "          7    \\ 7     77     77  _  77     77  77     7     7    \\ 7     7\n" +
                "          |  7  ||  ___!|  ___!|  _  ||  ___!|  ||  7  |     |  7  ||  ___!\n" +
                "          |  |  ||  __|_!__   7|  7  ||  __| |  ||  |  |     |  |  ||  __|_\n" +
                "          |  !  ||     77     ||  |  ||  7   |  ||  !  |     |  !  ||     7\n" +
                "          !_____!!_____!!_____!!__!__!!__!   !__!!_____!     !_____!!_____!\n" +
                "                                                                 \n" +
                "          _________________________________________________________        \n" +
                "          7     77  _  77     77     77  77     77  77     77     7        \n" +
                "          |  -  ||    _||  ___!|  ___!|  ||  ___!|  ||  7  ||  _  |        \n" +
                "          |  ___!|  _ \\ |  __|_|  7___|  |!__   7|  ||  |  ||  7  |        \n" +
                "          |  7   |  7  ||     7|     7|  |7     ||  ||  !  ||  |  |        \n" +
                "          !__!   !__!__!!_____!!_____!!__!!_____!!__!!_____!!__!__!        ");
        System.out.println(artPrecision);
        String[][] matriz = obtenerMatrizPorNivel();
        aciertos = 0;
        errores = 0;
        int contadorFallosFatal = 0;

        bienvenida();
        System.out.println("En este reto deberás:\n-Responder correctamente la mayor cantidad de palabras en 1 MINUTO (60 segundos).\n-El reto TERMINA inmediatamente si cometes TRES ERRORES o si el tiempo se agota.\n-Si completas 10 palabras correctamente, ganas el reto.\n-Se te dará una pista ALEATORIA por palabra.");
        contador();


        long tiempoInicio = System.currentTimeMillis();
        long duracionLimite = 60000;

        String[] palabrasFalladasReto = new String[matriz.length];
        int indiceFalladas = 0;


        int[] indicesAleatorios = new int[matriz.length];
        for (int i = 0; i < matriz.length; i++) {
            indicesAleatorios[i] = i;
        }
        for (int i = matriz.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            int temp = indicesAleatorios[i];
            indicesAleatorios[i] = indicesAleatorios[j];
            indicesAleatorios[j] = temp;
        }

        System.out.println("--- ¡INICIA EL DESAFÍO DE PRECISIÓN! Tienes 60 segundos. ---");


        for (int i = 0; i < matriz.length; i++) {


            long tiempoTranscurrido = System.currentTimeMillis() - tiempoInicio;
            long tiempoRestante = (duracionLimite - tiempoTranscurrido) / 1000;

            if (tiempoTranscurrido >= duracionLimite) {
                System.out.println("\n*** ¡TIEMPO TERMINADO! (0 segundos restantes) ***");
                break;
            }
            if (aciertos >= 10) {
                System.out.println("\n*** ¡FELICIDADES " + usuario + "! Has completado las 10 palabras con éxito. ***");
                break;
            }
            if (contadorFallosFatal >= 3) {
                System.out.println("\n*** ¡TERCER ERROR COMETIDO! El desafío TERMINA AHORA. ***");
                break;
            }


            int indicePalabra = indicesAleatorios[i];
            int pista = random.nextInt(3);

            String palabraCorrecta = matriz[indicePalabra][0].trim();
            String prompt = matriz[indicePalabra][pista + 1];

            System.out.println("\n(Tiempo restante: " + tiempoRestante + "s) | Palabra #" + (aciertos + errores + 1));
            System.out.println("Errores totales: " + contadorFallosFatal + "/3");
            System.out.println(prompt);

            System.out.print("Tu respuesta: ");
            String respuesta = sc.nextLine().trim();


            if (System.currentTimeMillis() - tiempoInicio >= duracionLimite) {
                System.out.println("\n*** ¡TIEMPO TERMINADO! Su respuesta fue fuera de tiempo. ***");
                break;
            }

            boolean falloTurno = false;

            if (respuesta.equalsIgnoreCase(palabraCorrecta)) {
                System.out.println("✔ ¡CORRECTO!");
                aciertos++;
            } else {
                System.out.println("✘ ¡ERROR! La respuesta correcta era: " + palabraCorrecta);
                falloTurno = true;
            }


            if (falloTurno) {
                errores++;
                contadorFallosFatal++;
                if (indiceFalladas < palabrasFalladasReto.length) {
                    palabrasFalladasReto[indiceFalladas] = palabraCorrecta;
                    indiceFalladas++;
                }
            }

        }


        System.out.println("\n--- RESULTADOS RETO DESAFÍO DE PRECISIÓN (" + nnombre + ") ---");
        System.out.println("Total de aciertos: " + aciertos + " / 10");
        System.out.println("Total de errores: " + errores + " (Límite fatal: 3)");

        if (indiceFalladas > 0) {
            System.out.print("\nPalabras falladas (para repasar): ");
            for (int i = 0; i < indiceFalladas; i++) {
                System.out.print(palabrasFalladasReto[i] + (i < indiceFalladas - 1 ? ", " : ""));
            }
            System.out.println();
        }
    }
    public static void sbjAhorcado()
    {
        if (PALABRAS_JUEGO == null || PALABRAS_JUEGO.length == 0) {
            PALABRAS_JUEGO = PALABRAS_BASE;
        }
        contadorIncorrectas = 0;
        letrasIncorrectas = new char[INTENTOS_MAXIMOS];
        String artAhorcado=("             _       _   _     U  ___ u   ____       ____     _      ____      U  ___ u\n" +
                "         U  /\"\\  u  |'| |'|     \\/\"_ \\/U |  _\"\\ u U /\"___|U  /\"\\  u |  _\"\\      \\/\"_ \\/\n" +
                "          \\/ _ \\/  /| |_| |\\    | | | | \\| |_) |/ \\| | u   \\/ _ \\/ /| | | |     | | | |\n" +
                "          / ___ \\  U|  _  |u.-,_| |_| |  |  _ <    | |/__  / ___ \\ U| |_| |\\.-,_| |_| |\n" +
                "         /_/   \\_\\  |_| |_|  \\_)-\\___/   |_| \\_\\    \\____|/_/   \\_\\ |____/ u \\_)-\\___/ \n" +
                "          \\\\    >>  //   \\\\       \\\\     //   \\\\_  _// \\\\  \\\\    >>  |||_         \\\\   \n" +
                "         (__)  (__)(_\") (\"_)     (__)   (__)  (__)(__)(__)(__)  (__)(__)_)       (__)  ");
        System.out.print(artAhorcado);
        System.out.println(" ");
        bienvenida();
        System.out.println("          En este juego deberás:\n"+ "          1. Adivinar la palabra letra por letra, completándola antes de que se terminen tus intentos.\n" + "          2. Cada letra correcta se mostrará en su posición correspondiente, mientras que los errores se contabilizan.\n" + "          3. Recibirás retroalimentación inmediata, y si no logras adivinar la palabra, al finalizar se mostrará la palabra completa.");
        contador();
        seleccionarPalabra();
        inicializarPalabraAdivinada();

        while (!juegoTerminado()) {
            mostrarEstadoDelJuego();
            mostrarMuñeco();
            Scanner sc = new Scanner(System.in);
            System.out.print("          Introduce una letra: ");
            String input = sc.nextLine().toUpperCase();

            if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
                System.out.println("          Entrada inválida. Por favor, introduce una sola letra.");
                continue;
            }
            char letra = input.charAt(0);

            if (yaSeIntento(letra)) {
                System.out.println("          Ya intentaste la letra '" + letra + "'. Intenta con otra.");
                continue;
            }

            if (!adivinarLetra(letra)) {
                System.out.println("          Letra incorrecta!");
                letrasIncorrectas[contadorIncorrectas] = letra;
                contadorIncorrectas++;
            } else {
                System.out.println("          Letra correcta!");
            }
        }

        mostrarEstadoDelJuego();
        mostrarMuñeco();
        if (palabraCompletada()) {
            System.out.println("          ¡Ganaste! La palabra era: " + palabraSecreta);
        } else {
            System.out.println("          ¡Perdiste! El ahorcado se completó. La palabra era: " + palabraSecreta); 
        }
    }
    private static void seleccionarPalabra() {
        int indiceAleatorio = (int) (Math.random() * PALABRAS_JUEGO.length);
        palabraSecreta = PALABRAS_JUEGO[indiceAleatorio];
    }

    private static void inicializarPalabraAdivinada() {
        palabraAdivinada = new char[palabraSecreta.length()];
        Arrays.fill(palabraAdivinada, '_');
    }

    private static boolean yaSeIntento(char letra) {
        for (char c : palabraAdivinada) {
            if (c == letra) return true;
        }
        for (int i = 0; i < contadorIncorrectas; i++) {
            if (letrasIncorrectas[i] == letra) return true;
        }
        return false;
    }

    private static void mostrarEstadoDelJuego() {
        System.out.println("\n          --- Estado Actual ---");
        System.out.println("          Palabra: " + String.valueOf(palabraAdivinada));
        System.out.println("          Intentos fallidos: " + contadorIncorrectas + "/" + INTENTOS_MAXIMOS);
        System.out.print("          Letras incorrectas: ");
        for (int i = 0; i < contadorIncorrectas; i++) {
            System.out.print(letrasIncorrectas[i]);
            if (i < contadorIncorrectas - 1) System.out.print(", ");
        }
        System.out.println();
    }

    private static boolean adivinarLetra(char letra) {
        boolean letraAdivinada = false;
        for (int i = 0; i < palabraSecreta.length(); i++) {
            if (palabraSecreta.charAt(i) == letra) {
                if (palabraAdivinada[i] == '_') {
                    palabraAdivinada[i] = letra;
                    letraAdivinada = true;
                }
            }
        }
        return letraAdivinada;
    }

    private static boolean juegoTerminado() {
        return palabraCompletada() || contadorIncorrectas >= INTENTOS_MAXIMOS;
    }

    private static boolean palabraCompletada() {
        for (char c : palabraAdivinada) {
            if (c == '_') {
                return false;
            }
        }
        return true;
    }

    private static void mostrarMuñeco() {
        String[] muñeco = {
                "           _______ \n           |/      |\n           |      \n           |      \n           |      \n           |      \n          _|___  ", // 0
                "           _______ \n           |/      |\n           |      O\n           |      \n           |      \n           |      \n          _|___  ", // 1
                "           _______ \n           |/      |\n           |      O\n           |      | \n           |      \n           |      \n          _|___  ", // 2
                "           _______ \n           |/      |\n           |      O\n           |     /|\\\n           |      \n           |      \n          _|___  ", // 3
                "           _______ \n           |/      |\n           |      O\n           |     /|\\\n           |     / \n           |      \n          _|___  ", // 4
                "           _______ \n           |/      |\n           |      O\n           |     /|\\\n           |     / \\\n           |      \n          _|___  ", // 5 (último error antes de perder)
                "           _______ \n           |/      |\n           |      O\n           |     /|\\\n           |     / \\\n           |      \n          _|___  ",
        };
        int indice = Math.min(contadorIncorrectas, INTENTOS_MAXIMOS);
        if (indice < muñeco.length) {
            System.out.println(muñeco[indice]);
        }
    }

    public static void sbjCompletarLetrasFaltantes(){
        String artCompletarletras=("           ┌──────────────────────────────────────────────────────────────────────────────────────────────┐\n" +
                "           │  ___  __   _  _  ____  __    ____  ____  __   ____        __    ____  ____  ____   __   ____ │\n" +
                "           │ / __)/  \\ ( \\/ )(  _ \\(  )  (  __)(_  _)/ _\\ (  _ \\      (  )  (  __)(_  _)(  _ \\ / _\\ / ___)│\n" +
                "           │( (__(  O )/ \\/ \\ ) __// (_/\\ ) _)   )( /    \\ )   /      / (_/\\ ) _)   )(   )   //    \\\\___ \\│\n" +
                "           │ \\___)\\__/ \\_)(_/(__)  \\____/(____) (__)\\_/\\_/(__\\_)      \\____/(____) (__) (__\\_)\\_/\\_/(____/│\n" +
                "           └──────────────────────────────────────────────────────────────────────────────────────────────┘\n");
        System.out.println(artCompletarletras);
        System.out.println("           ");
        bienvenida();
        System.out.println("           En este juego deberás:\n           1. Completar la palabra escribiendo las letras que faltan en los espacios correspondientes.\n           2. Cada intento recibirá retroalimentación inmediata, y se contabilizarán tus aciertos y errores.\n           3. Presta atención a la posición de cada letra, ya que solo contará si la colocas en el lugar correcto.");
        contador();
        String[] nsbBasicoA = {"ADD", "EYE", "EAR", "BOAT", "HAPPY", "LION", "NIGHT", "MILK", "UNCLE", "THANK"};
        String[] nsbMedioA = {"CHEF", "BRUSH", "SISTER", "DESERT", "KITCHEN", "MONDAY", "BREAKFAST", "HORSE", "QUITE", "LISTEN"};
        String[] nsbNormalA = {"INTELLIGENT", "INCREDIBLE", "CLASSMATE", "CELEBRATION", "SCISSORS", "TELEVISION", "KILOMETER", "DIAGRAM", "JANUARY", "MEXICAN"};
        String[] nsbDificilA = {"DISAPPEAR", "APOLOGIZE", "APPRECIATE", "IMMEDIATELY", "KNOCK", "LICENSE", "WEIGH", "RHYME", "MULTIMEDIA", "MYSTERIOUS"};
        String[] nsbExpertA = {"EMBARRASS", "PUNCTURE", "SUSTAINABLE", "ACKNOWLEDGE", "WRIGGLE", "GREASE", "HARASS", "DECEIVE", "GUARANTEE"};

        switch (nivelSpellingBee) {
            case 1:
                nnombre = "Básico";
                PALABRAS_JUEGO = nsbBasicoA;
                break;
            case 2:
                nnombre = "Medio";
                PALABRAS_JUEGO = nsbMedioA;
                break;
            case 3:
                nnombre = "Normal";
                PALABRAS_JUEGO = nsbNormalA;
                break;
            case 4:
                nnombre = "Difícil";
                PALABRAS_JUEGO = nsbDificilA;
                break;
            case 5:
                nnombre = "Experto";
                PALABRAS_JUEGO = nsbExpertA;
                break;
            default:
                System.out.print("              Opción invalida. Ese número no corresponde a ningún nivel. Intenta de nuevo: ");
                break;
        }
        contadorIncorrectas = 0;
        letrasIncorrectas = new char[INTENTOS_MAXIMOS];
        seleccionarPalabra();
        inicializarPalabraAdivinada();


        Scanner sc = new Scanner(System.in);

        while (!juegoTerminado()) {
            mostrarEstadoDelJuego();
            System.out.print("          Introduce letra y posición (ejemplo: A 0): ");
            String input = sc.next().toUpperCase();

            if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
                System.out.println("          Entrada inválida. Por favor, introduce una sola letra.");
                continue;
            }
            char letra = input.charAt(0);

            int posicion = sc.nextInt();

            if (posicion < 0 || posicion >= palabraSecreta.length()) {
                System.out.println("          Posición fuera de rango.");
                continue;
            }

            if (palabraSecreta.charAt(posicion) == letra) {
                if (palabraAdivinada[posicion] == '_') {
                    palabraAdivinada[posicion] = letra;
                    System.out.println("          ¡Correcto!");
                } else {
                    System.out.println("          Esa posición ya está completa.");
                }
            } else {
                System.out.println("          Error, esa letra no corresponde en esa posición.");
                letrasIncorrectas[contadorIncorrectas] = letra;
                contadorIncorrectas++;
            }
        }

        mostrarEstadoDelJuego();
        if (palabraCompletada()) {
            System.out.println("          ¡Ganaste! La palabra era: " + palabraSecreta);
        } else {
            System.out.println("          ¡Perdiste! La palabra era: " + palabraSecreta);
        }
    }

   public static void sbjOrdenarLetras() {
        String artOrdenarLetras = """
                      _______          _                            _                               
                     (_______)        | |                          | |         _                    
                      _     _  ____ __| |_____ ____  _____  ____   | | _____ _| |_  ____ _____  ___ 
                     | |   | |/ ___) _  | ___ |  _ \\(____ |/ ___)  | || ___ (_   _)/ ___|____ |/___)
                     | |___| | |  ( (_| | ____| | | / ___ | |      | || ____| | |_| |   / ___ |___ |
                      \\_____/|_|   \\____|_____)_| |_\\_____|_|       \\_)_____)  \\__)_|   \\_____(___/ 
            """;
        System.out.println(artOrdenarLetras);

        bienvenida();
        System.out.println("          En este juego deberás:\n          1. Recibirás una palabra con las letras desordenadas y deberás escribirla en su forma correcta.\n          2. Cada intento recibirá retroalimentación inmediata, y se contabilizarán tus aciertos y errores.");
        contador();

        // Arreglos de palabras
        String[] nsbBasicoB = {"ADD", "EYE", "EAR", "BOAT", "HAPPY", "LION", "NIGHT", "MILK", "UNCLE", "THANK"};
        String[] nsbMedioB = {"CHEF", "BRUSH", "SISTER", "DESERT", "KITCHEN", "MONDAY", "BREAKFAST", "HORSE", "QUITE", "LISTEN"};
        String[] nsbNormalB = {"INTELLIGENT", "INCREDIBLE", "CLASSMATE", "CELEBRATION", "SCISSORS", "TELEVISION", "KILOMETER", "DIAGRAM", "JANUARY", "MEXICAN"};
        String[] nsbDificilB = {"DISAPPEAR", "APOLOGIZE", "APPRECIATE", "IMMEDIATELY", "KNOCK", "LICENSE", "WEIGH", "RHYME", "MULTIMEDIA", "MYSTERIOUS"};
        String[] nsbExpertB = {"EMBARRASS", "PUNCTURE", "SUSTAINABLE", "ACKNOWLEDGE", "WRIGGLE", "GREASE", "HARASS", "DECEIVE", "GUARANTEE"};

        String[] nsbBasicoScrambled = {"DAD", "YEE", "RAE", "OATB", "PYHAP", "NILO", "HTGIN", "KLIM", "CELNU", "KNAHT"};
        String[] nsbMedioScrambled = {"FEHC", "HSBUR", "RTSESI", "RTDESE", "NTEHKCI", "ADNYOM", "TSABFREAK", "OSEHR", "ETQUI", "TINESL"};
        String[] nsbNormalScrambled = {"TNEGILLINET", "EDICRINBEL", "TAMCELASS", "TIONCELEBRA", "SORCSISS", "SIONTELEVI", "TERKILOME", "GRAMDIA", "UARYJAN", "CANMEXI"};
        String[] nsbDificilScrambled = {"PEARSDISA", "LOGAPOIZE", "IATEAPPRCE", "MEDIATELYIM", "CKKNO", "CENSELI", "GHWEI", "MYRHE", "TIMEDIAUL", "STERYMIOU"};
        String[] nsbExpertScrambled = {"RASSBEMAR", "TUREPUNC", "TAINABLESUS", "KNOWLEDGEACK", "GLEWRIG", "ASEGRE", "ASSHAR", "CEIVEDE", "RANTEEGUA"};

        int aciertos = 0;
        int errores = 0;
        Scanner sc = new Scanner(System.in);

        boolean continuar = true;
        while (continuar) {
            Random rand = new Random();
            int index = 0;
            String palabraCorrecta = "";
            String palabraDesordenada = "";

            switch (nivelSpellingBee) {
                case 1 -> {
                    index = rand.nextInt(nsbBasicoB.length);
                    palabraCorrecta = nsbBasicoB[index];
                    palabraDesordenada = nsbBasicoScrambled[index];
                }
                case 2 -> {
                    index = rand.nextInt(nsbMedioB.length);
                    palabraCorrecta = nsbMedioB[index];
                    palabraDesordenada = nsbMedioScrambled[index];
                }
                case 3 -> {
                    index = rand.nextInt(nsbNormalB.length);
                    palabraCorrecta = nsbNormalB[index];
                    palabraDesordenada = nsbNormalScrambled[index];
                }
                case 4 -> {
                    index = rand.nextInt(nsbDificilB.length);
                    palabraCorrecta = nsbDificilB[index];
                    palabraDesordenada = nsbDificilScrambled[index];
                }
                case 5 -> {
                    index = rand.nextInt(nsbExpertB.length);
                    palabraCorrecta = nsbExpertB[index];
                    palabraDesordenada = nsbExpertScrambled[index];
                }
            }

            System.out.println("\n          Ordena las letras: " + palabraDesordenada);
            String intento = sc.nextLine().toUpperCase();

            if (intento.equals(palabraCorrecta)) {
                System.out.println("          ¡Correcto!");
                aciertos++;
            } else {
                System.out.println("          Incorrecto. La palabra era: " + palabraCorrecta);
                errores++;
            }

            System.out.println("\n          ¿Quieres jugar otra ronda? (s/n)");
            String respuesta = sc.nextLine().toLowerCase();
            if (!respuesta.equals("si")) {
                continuar = false;
            }
        }

        System.out.println("\nJuego terminado. Aciertos: " + aciertos + "  Errores: " + errores);
    }
    public static void modalidadTradicionalVocabulario(){
        String artTraVocabulario=("             _____                      _      _               _                               _                     \n" +
                "            |_   _|    _ _   __ _    __| |    (_)     __      (_)     ___    _ _     __ _     | |      o O O    o O O\n" +
                "              | |     | '_| / _` |  / _` |    | |    / _|     | |    / _ \\  | ' \\   / _` |    | |     o        o     \n" +
                "             _|_|_   _|_|_  \\__,_|  \\__,_|   _|_|_   \\__|_   _|_|_   \\___/  |_||_|  \\__,_|   _|_|_   TS__[O]  TS__[O]\n" +
                "           _|\"\"\"\"\"|_|\"\"\"\"\"|_|\"\"\"\"\"|_|\"\"\"\"\"|_|\"\"\"\"\"|_|\"\"\"\"\"|_|\"\"\"\"\"|_|\"\"\"\"\"|_|\"\"\"\"\"|_|\"\"\"\"\"|_|\"\"\"\"\"| {======| {======|\n" +
                "           \"`-0-0-'\"`-0-0-'\"`-0-0-'\"`-0-0-'\"`-0-0-'\"`-0-0-'\"`-0-0-'\"`-0-0-'\"`-0-0-'\"`-0-0-'\"`-0-0-'./o--000'./o--000'");
        System.out.println("           ");
        System.out.println(artTraVocabulario);
        aciertos = 0;
        errores = 0;
        contadorFallos = 0;
        for (int i = 0; i < palabrasFalladas.length; i++) palabrasFalladas[i] = -1;
        bienvenida();
        System.out.println("En cada ronda, usted deberá:\n1- Escribir el significado en español de una palabra que se muestre en inglés,\n2- Escribir la palabra en inglés a partir de su significado en español, o\n3- Seleccionar la traducción correcta entre varias opciones.\nAdemás:\nCada palabra incluirá ejemplos contextualizados, como frases o fragmentos de conversación, para ayudarle a comprender y usar correctamente el vocabulario.\nRecibirá retroalimentación inmediata en cada intento, y al finalizar un nivel o categoría, podrá revisar un resumen con sus aciertos y errores.\nLas palabras que no domine serán retomadas automáticamente por el sistema en repaso.");
        contador();

        // PRIMERA RONDA
        for (int i = 0; i < 10; i++) {
            int pista = (int)(Math.random() * 3);
            pistaUsada[i] = pista;

            String prompt = PALABRAS_VOCABULARIO[i][pista + 1];
            System.out.println("Pregunta " + (i+1) + ":");
            System.out.println(PALABRAS_VOCABULARIO[i][pista+1]);
            System.out.print("Tu respuesta: ");
            String respuesta = sc.nextLine().trim();

            String correcta = PALABRAS_VOCABULARIO[i][0].trim();

            if (respuesta.equalsIgnoreCase(correcta)) {
                System.out.println("\n✔ Correcto!");
                aciertos++;
            } else {
                System.out.println("\n✘ Incorrecto. La respuesta correcta era: " + correcta);
                errores++;
                palabrasFalladas[contadorFallos++] = i;
            }

            System.out.println("Presiona ENTER para continuar...");
            sc.nextLine();// pausa hasta que el usuario presione Enter
        }

        // SEGUNDA RONDA
        if (contadorFallos > 0) {
            System.out.println("\n--- Ronda de repaso para palabras falladas ---");
            for (int f = 0; f < contadorFallos; f++) {
                int indicePalabra = palabrasFalladas[f];


                int pista2;
                do {
                    pista2 = (int)(Math.random() * 3);
                } while (pista2 == pistaUsada[indicePalabra]);

                String prompt2 = PALABRAS_VOCABULARIO[indicePalabra][pista2 + 1];
                System.out.println("\nRepetición palabra " + (f + 1) + ":");
                System.out.println(prompt2);

                System.out.print("Tu respuesta: ");
                String respuesta2 = sc.nextLine().trim().toLowerCase();

                String correcta2 =PALABRAS_VOCABULARIO[indicePalabra][0].toLowerCase();

                if (respuesta2.equals(correcta2)) {
                    System.out.println("✔ Correcto!");
                    aciertos++;
                } else {
                    System.out.println("✘ Incorrecto de nuevo. La correcta era: " + correcta2);
                    errores++;
                }

                System.out.println("Presiona ENTER para continuar...");
                sc.nextLine();
            }
        }

        // RESUMEN FINAL
        System.out.println("\n--- RESULTADOS FINALES ---");
        System.out.println("Aciertos: " + aciertos);
        System.out.println("Errores: " + errores);
        if (contadorFallos > 0) {
            System.out.print("Palabras que preguntamos otra vez: ");
            for (int i = 0; i < contadorFallos; i++) {
                System.out.print(COMPLETAR_ORACIONES[palabrasFalladas[i]][0] + (i < contadorFallos - 1 ? ", " : "\n"));
            }
        }

    }
    public static void modalidadJuegosVocabulario() {
        String artJuegosVocabulario=("");
        System.out.println("Has elegido la Modalidad Juegos, en el nivel " + nnombre);
        int vjuego;
        System.out.println("Ingresa el juego que te gustaría jugar\n1- Palabras relacionadas\n2- Completar oraciones\n3- Adivinar la palabra");
        do{
            if (sc.hasNextInt()) {
                vjuego = sc.nextInt();
            } else {
                sc.next();
                vjuego = 0;
            }
            switch (vjuego){
                case 1:
                    allnombre = "juego Palabras Relacionadas";
                    vjPalabrasRelacionadas();
                    break;
                case 2:
                    allnombre = "juego Completar Oraciones";
                    vjCompletarOraciones();
                    break;
                case 3:
                    allnombre = "juego Adivinar Palabras";
                    vjAdiviniarPalabras();
                    break;
                default:
                    System.out.print("Opción invalida. Ese número no corresponde a ningun juego. Intenta de nuevo: ");
                    break;
            }
        }
        while(vjuego<1 || vjuego>3);
    }

    public static void vjPalabrasRelacionadas() {
        String artPalabrasRelacionadas=("            ______         __         __                                            \n" +
                "           |   __ \\.---.-.|  |.---.-.|  |--.----.---.-.-----.                       \n" +
                "           |    __/|  _  ||  ||  _  ||  _  |   _|  _  |__ --|                       \n" +
                "           |___|   |___._||__||___._||_____|__| |___._|_____|                       \n" +
                "                                                                                    \n" +
                "            ______         __              __                       __              \n" +
                "           |   __ \\.-----.|  |.---.-.----.|__|.-----.-----.---.-.--|  |.---.-.-----.\n" +
                "           |      <|  -__||  ||  _  |  __||  ||  _  |     |  _  |  _  ||  _  |__ --|\n" +
                "           |___|__||_____||__||___._|____||__||_____|__|__|___._|_____||___._|_____|\n");
        System.out.println(artPalabrasRelacionadas);
        System.out.println("      ");
        aciertos = 0;
        errores = 0;
        contadorFallos = 0;
        for (int i = 0; i < palabrasFalladas.length; i++) palabrasFalladas[i] = -1;
        bienvenida();
        System.out.println("En cada ronda, usted deberá:\n1- Escribir el significado en español de una palabra que se muestre en inglés,\n2- Escribir la palabra en inglés a partir de su significado en español, o\n3- Seleccionar la traducción correcta entre varias opciones.\nAdemás:\nCada palabra incluirá ejemplos contextualizados, como frases o fragmentos de conversación, para ayudarle a comprender y usar correctamente el vocabulario.\nRecibirá retroalimentación inmediata en cada intento, y al finalizar un nivel o categoría, podrá revisar un resumen con sus aciertos y errores.\nLas palabras que no domine serán retomadas automáticamente por el sistema en repaso.");
        contador();

        // PRIMERA RONDA
        for (int i = 0; i < 10; i++) {
            int pista = (int) (Math.random() * 3);
            pistaUsada[i] = pista;

            String prompt = PALABRAS_RELACIONADAS[i][pista + 1];
            System.out.println("Pregunta " + (i + 1) + ":");
            System.out.println(PALABRAS_RELACIONADAS[i][pista + 1]);
            System.out.print("Tu respuesta: ");
            String respuesta = sc.nextLine().trim();

            String correcta = PALABRAS_RELACIONADAS[i][0].trim();

            if (respuesta.equalsIgnoreCase(correcta)) {
                System.out.println("\n✔ Correcto!");
                aciertos++;
            } else {
                System.out.println("\n✘ Incorrecto. La respuesta correcta era: " + correcta);
                errores++;
                palabrasFalladas[contadorFallos++] = i;
            }

            System.out.println("Presiona ENTER para continuar...");
            sc.nextLine();// pausa hasta que el usuario presione Enter
        }

        // SEGUNDA RONDA
        if (contadorFallos > 0) {
            System.out.println("\n--- Ronda de repaso para palabras falladas ---");
            for (int f = 0; f < contadorFallos; f++) {
                int indicePalabra = palabrasFalladas[f];


                int pista2;
                do {
                    pista2 = (int) (Math.random() * 3);
                } while (pista2 == pistaUsada[indicePalabra]);

                String prompt2 = PALABRAS_RELACIONADAS[indicePalabra][pista2 + 1];
                System.out.println("\nRepetición palabra " + (f + 1) + ":");
                System.out.println(prompt2);

                System.out.print("Tu respuesta: ");
                String respuesta2 = sc.nextLine().trim().toLowerCase();

                String correcta2 = PALABRAS_RELACIONADAS[indicePalabra][0].toLowerCase();

                if (respuesta2.equals(correcta2)) {
                    System.out.println("✔ Correcto!");
                    aciertos++;
                } else {
                    System.out.println("✘ Incorrecto de nuevo. La correcta era: " + correcta2);
                    errores++;
                }

                System.out.println("Presiona ENTER para continuar...");
                sc.nextLine();
            }
        }

        // RESUMEN FINAL
        System.out.println("\n--- RESULTADOS FINALES ---");
        System.out.println("Aciertos: " + aciertos);
        System.out.println("Errores: " + errores);
        if (contadorFallos > 0) {
            System.out.print("Palabras que preguntamos otra vez: ");
            for (int i = 0; i < contadorFallos; i++) {
                System.out.print(COMPLETAR_ORACIONES[palabrasFalladas[i]][0] + (i < contadorFallos - 1 ? ", " : "\n"));
            }
        }

    }

    public static void vjCompletarOraciones() {
        String artCompletarOraciones=("               __   ___   ___ ___  ____  _        ___  ______   ____  ____   \n" +
                "              /  ] /   \\ |   T   T|    \\| T      /  _]|      T /    T|    \\  \n" +
                "             /  / Y     Y| _   _ ||  o  ) |     /  [_ |      |Y  o  ||  D  ) \n" +
                "            /  /  |  O  ||  \\_/  ||   _/| l___ Y    _]l_j  l_j|     ||    /  \n" +
                "           /   \\_ |     ||   |   ||  |  |     T|   [_   |  |  |  _  ||    \\  \n" +
                "           \\     |l     !|   |   ||  |  |     ||     T  |  |  |  |  ||  .  Y \n" +
                "            \\____j \\___/ l___j___jl__j  l_____jl_____j  l__j  l__j__jl__j\\_j \n" +
                "                                                                  \n" +
                "             ___   ____    ____    __  ____  ___   ____     ___  _____       \n" +
                "            /   \\ |    \\  /    T  /  ]l    j/   \\ |    \\   /  _]/ ___/       \n" +
                "           Y     Y|  D  )Y  o  | /  /  |  TY     Y|  _  Y /  [_(   \\_        \n" +
                "           |  O  ||    / |     |/  /   |  ||  O  ||  |  |Y    _]\\__  T       \n" +
                "           |     ||    \\ |  _  /   \\_  |  ||     ||  |  ||   [_ /  \\ |       \n" +
                "           l     !|  .  Y|  |  \\     | j  ll     !|  |  ||     T\\    |       \n" +
                "            \\___/ l__j\\_jl__j__j\\____j|____j\\___/ l__j__jl_____j \\___j       \n");
        System.out.println(artCompletarOraciones);
        System.out.println("   ");
        aciertos = 0;
        errores = 0;
        contadorFallos = 0;
        for (int i = 0; i < palabrasFalladas.length; i++) palabrasFalladas[i] = -1;
        bienvenida();
        System.out.println("En este juego deberás:\n1. Completar oraciones incompletas en inglés escribiendo la palabra correcta en los espacios, usando el vocabulario que ya has aprendido.\n2. El sistema validará tu respuesta en tiempo real, indicándote si es correcta o incorrecta.\n3. Al finalizar cada ronda, verás un resumen de resultados con tus aciertos y errores, para reforzar las palabras que aún no dominas.");
        contador();

        // PRIMERA RONDA
        for (int i = 0; i < 10; i++) {
            int pista = (int) (Math.random() * 3);
            pistaUsada[i] = pista;

            String prompt = COMPLETAR_ORACIONES[i][pista + 1];
            System.out.println("Pregunta " + (i + 1) + ":");
            System.out.println(COMPLETAR_ORACIONES[i][pista + 1]);
            System.out.print("Tu respuesta: ");
            String respuesta = sc.nextLine().trim();

            String correcta = COMPLETAR_ORACIONES[i][0].trim();

            if (respuesta.equalsIgnoreCase(correcta)) {
                System.out.println("\n✔ Correcto!");
                aciertos++;
            } else {
                System.out.println("\n✘ Incorrecto. La respuesta correcta era: " + correcta);
                errores++;
                palabrasFalladas[contadorFallos++] = i;
            }

            System.out.println("Presiona ENTER para continuar...");
            sc.nextLine();// pausa hasta que el usuario presione Enter
        }

        // SEGUNDA RONDA
        if (contadorFallos > 0) {
            System.out.println("\n--- Ronda de repaso para palabras falladas ---");
            for (int f = 0; f < contadorFallos; f++) {
                int indicePalabra = palabrasFalladas[f];


                int pista2;
                do {
                    pista2 = (int) (Math.random() * 3);
                } while (pista2 == pistaUsada[indicePalabra]);

                String prompt2 = COMPLETAR_ORACIONES[indicePalabra][pista2 + 1];
                System.out.println("\nRepetición palabra " + (f + 1) + ":");
                System.out.println(prompt2);

                System.out.print("Tu respuesta: ");
                String respuesta2 = sc.nextLine().trim().toLowerCase();

                String correcta2 = COMPLETAR_ORACIONES[indicePalabra][0].toLowerCase();

                if (respuesta2.equals(correcta2)) {
                    System.out.println("✔ Correcto!");
                    aciertos++;
                } else {
                    System.out.println("✘ Incorrecto de nuevo. La correcta era: " + correcta2);
                    errores++;
                }

                System.out.println("Presiona ENTER para continuar...");
                sc.nextLine();
            }
        }

        // RESUMEN FINAL
        System.out.println("\n--- RESULTADOS FINALES ---");
        System.out.println("Aciertos: " + aciertos);
        System.out.println("Errores: " + errores);
        if (contadorFallos > 0) {
            System.out.print("Palabras que preguntamos otra vez: ");
            for (int i = 0; i < contadorFallos; i++) {
                System.out.print(COMPLETAR_ORACIONES[palabrasFalladas[i]][0] + (i < contadorFallos - 1 ? ", " : "\n"));
            }
        }

    }

    public static void vjAdiviniarPalabras() {
        String artAdovoinarpalabras=("           .---------------------------------------------------------------------------------------------------.\n" +
                "           | _______    __ __       __                      _______       __       __                          |\n" +
                "           ||   _   .--|  |__.--.--|__.-----.---.-.----.   |   _   .---.-|  .---.-|  |--.----.---.-.-----.     |\n" +
                "           ||.  1   |  _  |  |  |  |  |     |  _  |   _|   |.  1   |  _  |  |  _  |  _  |   _|  _  |__ --|     |\n" +
                "           ||.  _   |_____|__|\\___/|__|__|__|___._|__|     |.  ____|___._|__|___._|_____|__| |___._|_____|     |\n" +
                "           ||:  |   |                                      |:  |                                               |\n" +
                "           ||::.|:. |                                      |::.|                                               |\n" +
                "           |`--- ---'                                      `---'                                               |\n" +
                "           '---------------------------------------------------------------------------------------------------'\n");
        System.out.println(artAdovoinarpalabras);
        System.out.println("           ");
        aciertos = 0;
        errores = 0;
        contadorFallos = 0;
        for (int i = 0; i < palabrasFalladas.length; i++) palabrasFalladas[i] = -1;
        bienvenida();
        System.out.println("En este juego deberás:\n1. Adivinar la palabra en inglés que se te presenta escribiéndola correctamente, usando las pistas que recibas.\n2. Cada intento recibirá retroalimentación inmediata, y si fallas, el sistema mostrará la palabra correcta.\n3. Al finalizar la ronda, verás un resumen de resultados con tus aciertos y errores.");
        contador();

        // PRIMERA RONDA
        for (int i = 0; i < 10; i++) {
            int pista = (int) (Math.random() * 3);
            pistaUsada[i] = pista;

            String prompt = ADIVINAR_PALABRAS[i][pista + 1];
            System.out.println("Pregunta " + (i + 1) + ":");
            System.out.println(ADIVINAR_PALABRAS[i][pista + 1]);
            System.out.print("Tu respuesta: ");
            String respuesta = sc.nextLine().trim();

            String correcta = ADIVINAR_PALABRAS[i][0].trim();

            if (respuesta.equalsIgnoreCase(correcta)) {
                System.out.println("\n✔ Correcto!");
                aciertos++;
            } else {
                System.out.println("\n✘ Incorrecto. La respuesta correcta era: " + correcta);
                errores++;
                palabrasFalladas[contadorFallos++] = i;
            }

            System.out.println("Presiona ENTER para continuar...");
            sc.nextLine();// pausa hasta que el usuario presione Enter
        }

        // SEGUNDA RONDA
        if (contadorFallos > 0) {
            System.out.println("\n--- Ronda de repaso para palabras falladas ---");
            for (int f = 0; f < contadorFallos; f++) {
                int indicePalabra = palabrasFalladas[f];


                int pista2;
                do {
                    pista2 = (int) (Math.random() * 3);
                } while (pista2 == pistaUsada[indicePalabra]);

                String prompt2 = ADIVINAR_PALABRAS[indicePalabra][pista2 + 1];
                System.out.println("\nRepetición palabra " + (f + 1) + ":");
                System.out.println(prompt2);

                System.out.print("Tu respuesta: ");
                String respuesta2 = sc.nextLine().trim().toLowerCase();

                String correcta2 = ADIVINAR_PALABRAS[indicePalabra][0].toLowerCase();

                if (respuesta2.equals(correcta2)) {
                    System.out.println("✔ Correcto!");
                    aciertos++;
                } else {
                    System.out.println("✘ Incorrecto de nuevo. La correcta era: " + correcta2);
                    errores++;
                }

                System.out.println("Presiona ENTER para continuar...");
                sc.nextLine();
            }
        }

        // RESUMEN FINAL
        System.out.println("\n--- RESULTADOS FINALES ---");
        System.out.println("Aciertos: " + aciertos);
        System.out.println("Errores: " + errores);
        if (contadorFallos > 0) {
            System.out.print("Palabras que preguntamos otra vez: ");
            for (int i = 0; i < contadorFallos; i++) {
                System.out.print(ADIVINAR_PALABRAS[palabrasFalladas[i]][0] + (i < contadorFallos - 1 ? ", " : "\n"));
            }
        }

    }

}

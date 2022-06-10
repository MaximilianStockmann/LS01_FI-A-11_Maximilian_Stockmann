package AutosV1;

public class Fabrik {
    public static void main(String[] args) {
        //Es wird ein neues Objekt der Klasse Audi instanziiert und in der Variable audi1 gespeichert.
        Audi audi1 = new Audi(500, 2017, "A7", 50000, "Ledersitze, Sitzheizung");
        Audi audi2 = new Audi(290, 2015, "A5", 34000,
                "Standheizung, Elektronische Fensterheben");

        Auto auto1 = new Auto();
        auto1.baujahr = 2011;
        auto1.psZahl = 150;

        //Nun wollen wir die Austattung unseres Audis noch einmal ändern. Da die Attribute der Klasse Audi allesamt
        //öffentlich (public) sind

        audi1.druckeStatus();
        audi2.druckeStatus();
    }

}

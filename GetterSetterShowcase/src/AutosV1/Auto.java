package AutosV1;

public class Auto {

    //Das sind die Attribute der Klasse. Diese Variablen gehören spezifisch zur Auto Klasse.
    //Wir können sie mit dem Schlüsselwort "this" gefolgt von einem Punkt aufrufen.
    //Beispiel: this.psZahl gibt den aktuellen Wert zurück, der in der Variable psZahl steht.
    public int psZahl;
    public int baujahr;

    //Das ist der Standard-Konstruktor der Klasse. Er wird aufgerufen, wenn wir beim instanziieren eines Objekts
    //keine Parameter übergeben bekommen. Wir wollen, dass in diesem Fall unser Auto bestimmte Standardwerte annimmt.
    Auto() {

        //Wir legen 100 als Standardwert für die psZahl fest.
        this.psZahl = 100;

        //Wir legen 2000 als Standardwert für das baujahr fest.
        this.baujahr = 2000;
    }

    //Das ist ein Konstruktor, der nur das baujahr als Parameter nimmt. Wir möchten, dass die psZahl trotzdem
    //nicht leer bleibt. Wir rufen beim Aufruf dieses Konstruktors also zuerst den Standard-Konstruktor auf.
    Auto(int baujahr){

        //Durch den Aufruf von "this()" wird der Standardkonstruktor aufgerufen. Dadurch werden für das zu
        //instanziierte Objekt dieser Klasse das Attribut "psZahl" auf 100 und das Attribut "baujahr" auf 2000 gesetzt.
        //(Siehe obere Definition des Standardskonstruktors).
        this();

        //In diesem Aufruf setzen wir das Attribut "baujahr" des zu instanziierten Objekts auf die variable baujahr, die
        //als Parameter in diesem Konstruktor übergeben wurden. Somit wird auch der wert 2000 für das baujahr, der
        //im Aufruf von this() für das Attribut gesetzt wurde überschrieben.
        this.baujahr = baujahr;
    }

    //Das ist der vollparameterisierte Konstruktor. In ihm initialisieren wir alle Attribute unserer Klasse.
    //Die Anzahl an Parametern die wir in diesem Konstruktor übergeben bekommen ist in unserem Fall gleich der Anzahl
    //der Attribute, da wir alle Attribute mit variablen Werten beschreiben wollen.
    Auto(int psZahl, int baujahr) {

        //Durch den Aufruf this(baujahr) rufen wir den oberen Konstruktor auf und übergeben als Argument
        //die Variable baujahr, die wir als Parameter in diesem vollparameterisierten Konstruktor übergeben
        //bekommen haben. Damit werden die psZahl auf 100 und das baujahr auf den wert der baujahr Variable gesetzt,
        //die wir als Parameter in diesem Konstruktor übergeben bekommen haben.
        this(baujahr);

        //In der nächsten Zeile wird dem Klassenattribut psZahl der Wert zugewiesen der diesem Konstruktor
        //als parameter psZahl übergeben wurde. Damit wird das Attribut psZahl, das vorher auf 100 gesetzt wurde,
        //überschrieben.
        this.psZahl = psZahl;
    }

    //Das ist eine öffentliche Methode, die auf der Konsole ausgibt, dass das Auto fährt.
    public void fahre() {
        System.out.println("Das Auto bewegt sich vorwärts!");
    }

    //Diese öffentliche Methode gibt den Status des Autos auf, indem sie Attribute in einem print statement benutzt.
    public void druckeStatus() {
        System.out.println("PS: " + this.psZahl + "\nBaujahr: " + this.baujahr);
    }

}

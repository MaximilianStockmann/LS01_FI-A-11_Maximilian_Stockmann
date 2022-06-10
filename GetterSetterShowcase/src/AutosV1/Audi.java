package AutosV1;

//Deklaration der Audi Klasse. Das Schlüsselwort extends sagt aus, dass die Klasse von der KLasse Auto erbt.
//Sie hat somit alle Attribute und Methoden, die die Klasse Auto hat und kann zusätzlich noch Erweiterungen
//für ihren Zustand und ihr Verhalten hinzufügen.
public class Audi extends Auto{

    //Die Attribute der Audi Klasse. Zusätzlich zu den drei Attributen modell, preis und ausstattung hat
    //die Audi Klasse auch noch die Attribute psZahl und baujahr, die sie von ihrer Elternklasse, also in diesem
    //Fall der Auto Klasse erbt.
    public String modell;
    public int preis;
    public String ausstattung;

    //Der Standardkonstruktor der Audi Klasse. Wie auch der Standardkonstruktor der Auto Klasse bekommt er keine
    //Argumente übergeben.
    Audi() {

        //Das Schlüsselword super ruft den Konstruktor der Elternklasse auf, also in diesem Fall den Konstruktor
        //der Klasse Auto. Wir möchten, dass unser Audi standardmäßig andere Werte für psZahl und baujahr annimmt
        //als ein normales Auto. Diese Werte übergeben wir als Argumente im Aufruf des Konstruktors und rufen somit
        //den vollparameterisierten Konstruktor der Auto Klasse auf. Wir könnten genauso einen der anderen beiden
        //Konstruktoren aufrufen, die weniger Argumente nehmen.
        super(300, 2010);
    }

    //Der vollparameterisierte Konstruktor der Audi Klasse. Zusätzlich zu den Attributen die wir für die Audi
    //Klasse spezifisch deklariert haben wollen wir auch den geerbten Attributen Werte zuweisen indem wir den
    //Konstruktor der Auto Klasse aufrufen.
    Audi(int psZahl, int baujahr, String modell, int preis, String ausstattung) {
        super(psZahl, baujahr);
        this.modell = modell;
        this.preis = preis;
        this.ausstattung = ausstattung;
    }

}

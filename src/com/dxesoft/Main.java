package com.dxesoft;


import com.dxesoft.cracking.ArrayRotation;
import com.dxesoft.cracking.KidnapNote;
import com.dxesoft.cracking.Note;

public class Main {

    public static void main(String[] args) {

//        precio();

//        rotation();

//        kidnapnote();

        Note note = new Note();
//        String magazine = "give me one grand today night Night grand";
//        String notes = "give one grand today";
        String magazine = "two times three is not four";
        String notes = "two times two is four";

        String[] noteWords = notes.split(" ");
        String[] magazineWords = magazine.split(" ");

        note.note(magazineWords, noteWords);
    }

    private static void kidnapnote() {
        KidnapNote kidnapNote = new KidnapNote();

        String magazine = "give me one grand today night";
        String note = "give one grand today";
//        String magazine = "two times three is not four";
//        String note = "two times two is four";

        boolean answer = kidnapNote.isDuplicable(magazine, note);
        if(answer)
            System.out.println("Yes");
        else System.out.println("No");
    }

    private static void rotation() {
        ArrayRotation arrayRotation = new ArrayRotation();

        arrayRotation.arrayLeftRotation();
    }

    private static void precio() {
        Precio precio = new Precio();
        precio.calculaPrecio();
    }


}

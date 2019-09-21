package com.example.accelerator.config;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;

public class TextConfig {

//    double cordinatOfIonX;
//    double cordinatOfIonY;
//    double cordinatOfIonZ;
//    double distance;
    double coordinatOfProteinX;
    double coordinatOfProteinY;
    double coordinatOfProteinZ;

    ArrayList<Double> distance000 = new ArrayList<>();
    ArrayList<Double> coordinats = new ArrayList<>();

    ArrayList<String> atom = new ArrayList<>();
    ArrayList<String> aminoAcid = new ArrayList<>();
    ArrayList<String> numberOfPDB = new ArrayList<>();

   /* public String refactoring(String fullPDB){
        String [] arrayFullPDB =fullPDB.trim().split("\\s");
        ArrayList<String> arrayWithoutProbel = new ArrayList<>();
        //making array clear
        for (String elementFromFullPDB: arrayFullPDB){
            if (!Objects.equals(elementFromFullPDB, "")){
                arrayWithoutProbel.add(elementFromFullPDB);
            }
        }
        //seeing Xe atom

        for (int i = 0; i < arrayWithoutProbel.size()-1; i++){
            if ((Objects.equals(arrayWithoutProbel.get(i), "XE")) && (Objects.equals(arrayWithoutProbel.get(i-2), "HETATM"))){
                coordinats.add(Double.parseDouble(arrayWithoutProbel.get(i+4)));
                coordinats.add(Double.parseDouble(arrayWithoutProbel.get(i+5)));
                coordinats.add(Double.parseDouble(arrayWithoutProbel.get(i+6)));

//                cordinatOfIonX = Double.parseDouble(arrayWithoutProbel.get(i+4));
//                cordinatOfIonY = Double.parseDouble(arrayWithoutProbel.get(i+5));
//                cordinatOfIonZ = Double.parseDouble(arrayWithoutProbel.get(i+6));
            }
        }



        for (int i = 0; i < arrayWithoutProbel.size()-1; i++){
            try {
                if ((Objects.equals(arrayWithoutProbel.get(i), "ATOM")) && (Double.parseDouble(arrayWithoutProbel.get(i + 1)) > 0)) {
                    coordinatOfProteinX = Double.parseDouble(arrayWithoutProbel.get(i + 6));
                    coordinatOfProteinY = Double.parseDouble(arrayWithoutProbel.get(i + 7));
                    coordinatOfProteinZ = Double.parseDouble(arrayWithoutProbel.get(i + 8));

                    for (int xe = 0; xe <=coordinats.size() - 3; xe = xe + 3) {
                        double newDistance000 = Math.sqrt(Math.pow(coordinatOfProteinX - coordinats.get(xe), 2) +
                                Math.pow(coordinatOfProteinY - coordinats.get(xe + 1), 2) +
                                Math.pow(coordinatOfProteinZ - coordinats.get(xe + 2), 2));


                        for (int ok = 0; ok<coordinats.size()/3; ok++ ) {
                            if (!distance000.contains(ok) && distance000.size()<coordinats.size()/3) {
                                distance000.add(newDistance000);
                                numberOfPDB.add(arrayWithoutProbel.get(i+1));
                                atom.add(arrayWithoutProbel.get(i+11));
                                aminoAcid.add(arrayWithoutProbel.get(i+3));
                            }
                            if(distance000.get(xe/3) > newDistance000) {
                                distance000.set(xe/3, newDistance000);
                                numberOfPDB.set(xe/3, arrayWithoutProbel.get(i+1));
                                atom.set(xe/3, arrayWithoutProbel.get(i+11));
                                aminoAcid.set(xe/3, arrayWithoutProbel.get(i+3));
                                }
                            }



//                    double newDistance = Math.sqrt(Math.pow(coordinatOfProteinX-cordinatOfIonX, 2)+
//                            Math.pow(coordinatOfProteinY -cordinatOfIonY, 2)+
//                            Math.pow(coordinatOfProteinZ-cordinatOfIonZ, 2));
//                    if (distance > newDistance || distance == 0){
//                        distance = newDistance;
//                        numberOfPDB = arrayWithoutProbel.get(i+1);
//                        atom = arrayWithoutProbel.get(i+11);
//                        aminoAcid = arrayWithoutProbel.get(i+3);
//
                    }
                }
            }catch (Exception ignored){}
        }
        String s = null;
        for(int numberOfIon=0; numberOfIon< distance000.size(); numberOfIon++ ) {
            s = s +("Номер: " + numberOfPDB.get(numberOfIon))+
            ("Атом: " + atom.get(numberOfIon))+
            ("Аминокислота: " + aminoAcid.get(numberOfIon))+
            ("Расстояие: " + distance000.get(numberOfIon));
        }
        return s;
    }*/
    public String refactoringNew(String fullPDB, String element){
        String [] arrayFullPDB =fullPDB.trim().split("\\s");
        ArrayList<String> arrayWithoutProbel = new ArrayList<>();
        for (String elementFromFullPDB: arrayFullPDB){
            if (!Objects.equals(elementFromFullPDB, "")){
                arrayWithoutProbel.add(elementFromFullPDB);
            }
        }

        for (int i = 0; i < arrayWithoutProbel.size()-1; i++){
            if ((Objects.equals(arrayWithoutProbel.get(i), element)) && (Objects.equals(arrayWithoutProbel.get(i-2), "HETATM"))){
                coordinats.add(Double.parseDouble(arrayWithoutProbel.get(i+4)));
                coordinats.add(Double.parseDouble(arrayWithoutProbel.get(i+5)));
                coordinats.add(Double.parseDouble(arrayWithoutProbel.get(i+6)));
            }
        }



        for (int i = 0; i < arrayWithoutProbel.size()-1; i++){
            try {
                if ((Objects.equals(arrayWithoutProbel.get(i), "ATOM")) && (Double.parseDouble(arrayWithoutProbel.get(i + 1)) > 0)) {
                    coordinatOfProteinX = Double.parseDouble(arrayWithoutProbel.get(i + 6));
                    coordinatOfProteinY = Double.parseDouble(arrayWithoutProbel.get(i + 7));
                    coordinatOfProteinZ = Double.parseDouble(arrayWithoutProbel.get(i + 8));

                    for (int xe = 0; xe <=coordinats.size() - 3; xe = xe + 3) {
                        double newDistance000 = Math.sqrt(Math.pow(coordinatOfProteinX - coordinats.get(xe), 2) +
                                Math.pow(coordinatOfProteinY - coordinats.get(xe + 1), 2) +
                                Math.pow(coordinatOfProteinZ - coordinats.get(xe + 2), 2));


                        for (int ok = 0; ok<coordinats.size()/3; ok++ ) {
                            if (!distance000.contains(ok) && distance000.size() < coordinats.size() / 3) {
                                distance000.add(newDistance000);
                                numberOfPDB.add(arrayWithoutProbel.get(i + 1));
                                atom.add(arrayWithoutProbel.get(i + 11));
                                aminoAcid.add(arrayWithoutProbel.get(i + 3));
                            }
                            if (distance000.get(xe / 3) > newDistance000) {
                                distance000.set(xe / 3, newDistance000);
                                numberOfPDB.set(xe / 3, arrayWithoutProbel.get(i + 1));
                                atom.set(xe / 3, arrayWithoutProbel.get(i + 11));
                                aminoAcid.set(xe / 3, arrayWithoutProbel.get(i + 3));
                            }
                        }
//
                    }
                }
            }catch (Exception ignored){}
        }
        String s = "";
        for(int numberOfIon=0; numberOfIon< distance000.size(); numberOfIon++ ) {
            s = s+  (" " + numberOfPDB.get(numberOfIon))+
                    (" " + atom.get(numberOfIon))+
                    (" " + aminoAcid.get(numberOfIon))+
                    (" " + Float.parseFloat(String.valueOf(distance000.get(numberOfIon))));
        }
        if(s=="")
            s="No information about the selected element!";
        return s;
    }

}

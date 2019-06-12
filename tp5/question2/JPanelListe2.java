package question2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import question2.Memento;
import question2.Originator;
import question2.Caretaker;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;

public class JPanelListe2 extends JPanel implements ActionListener, ItemListener 
{
    Caretaker caretaker = new Caretaker();
    Originator originator = new Originator();
    int saveFiles=0, currentArticle=0;
    private JPanel cmd = new JPanel();
    private JLabel afficheur = new JLabel();
    private JTextField saisie = new JTextField();

    private JPanel panelBoutons = new JPanel();
    private JButton boutonRechercher = new JButton("rechercher");
    private JButton boutonRetirer = new JButton("retirer");

    private CheckboxGroup mode = new CheckboxGroup();
    private Checkbox ordreCroissant = new Checkbox("croissant", mode, false);
    private Checkbox ordreDecroissant = new Checkbox("décroissant", mode, false);

    private JButton boutonOccurrences = new JButton("occurrence");

    private JButton boutonAnnuler = new JButton("annuler");

    private TextArea texte = new TextArea();

    private List<String> liste;
    private Map<String, Integer> occurrences;

    public JPanelListe2(List<String> liste, Map<String, Integer> occurrences) 
    {
          
        
        if(currentArticle==0){
        }
        this.liste = liste;
        this.occurrences = occurrences;

        cmd.setLayout(new GridLayout(3, 1));

        cmd.add(afficheur);
        cmd.add(saisie);

        panelBoutons.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelBoutons.add(boutonRechercher);
        panelBoutons.add(boutonRetirer);
        panelBoutons.add(new JLabel("tri du texte :"));
        panelBoutons.add(ordreCroissant);
        panelBoutons.add(ordreDecroissant);
        panelBoutons.add(boutonOccurrences);
        panelBoutons.add(boutonAnnuler);
        cmd.add(panelBoutons);


        if(liste!=null && occurrences!=null){
            afficheur.setText(liste.getClass().getName() + 
            " et "+ occurrences.getClass().getName());
            texte.setText(liste.toString());
        }else{
            texte.setText("la classe Chapitre2CoreJava semble incomplète");
        }

        setLayout(new BorderLayout());

        add(cmd, "North");
        add(texte, "Center");

        boutonRechercher.addActionListener(this);
        boutonAnnuler.addActionListener(this);
        boutonRetirer.addActionListener(this);
        boutonOccurrences.addActionListener(this);
        ordreCroissant.addItemListener(this);
        ordreDecroissant.addItemListener(this);

    }

    public void actionPerformed(ActionEvent ae) {
        try {
            // Caretaker caretaker = new Caretaker();
            // Originator originator = new Originator();
            // int saveFiles=0, currentArticle=0;
            boolean res = false;
            if (ae.getSource() == boutonRechercher || ae.getSource() == saisie) {
                res = liste.contains(saisie.getText());
                Integer occur = occurrences.get(
                    saisie.getText());
                afficheur.setText("résultat de la recherche de : "
                    + saisie.getText() + " -->  " + res);
            } else if (ae.getSource() == boutonRetirer) {
                
                String ab = String.join(", ", liste);
                originator.set(ab);
                caretaker.addMemento(
                    originator.storeInMemento());
                saveFiles++;
                currentArticle++;
                
                res = retirerDeLaListeTousLesElementsCommencantPar(
                    saisie.getText());
                afficheur.setText("résultat du retrait de tous les éléments commençant par -->  "
                    + saisie.getText() + " : " + res);
            } else if (ae.getSource() == boutonOccurrences) {
                Integer occur = occurrences.get(saisie.getText());
                if (occur != null)
                    afficheur.setText(" -->  " + occur + " occurrence(s)");
                else
                    afficheur.setText(" -->  ??? ");
            } 
            

        } catch (Exception e) {
            afficheur.setText(e.toString());
        }texte.setText(liste.toString());
        
        if (ae.getSource() == boutonAnnuler) {
               if(currentArticle>=1){
               currentArticle--;
               System.out.println("working");
               //texte.setText("");
               texte.setText(originator.restoreFromMemento(
                   caretaker.getMemento(currentArticle)));
               }
               
            }
    }

    public void itemStateChanged(ItemEvent ie) {
        
        // Caretaker caretaker = new Caretaker();
        // Originator originator = new Originator();
        // int saveFiles=0, currentArticle=0;
        
         if (ie.getSource() == ordreCroissant)
        {
            String ab = String.join(", ", liste);

                originator.set(ab);

                caretaker.addMemento(originator.storeInMemento());

                saveFiles++;

                currentArticle++;
            
            
            
            Collections.sort(liste);

        texte.setText(liste.toString()) ;
        }
        else if (ie.getSource() == ordreDecroissant)
        {
            
            String ab = String.join(", ", liste);

                originator.set(ab);

                caretaker.addMemento(originator.storeInMemento());

                saveFiles++;


                currentArticle++;

           Collections.sort(liste, new ReverseStringComparator());

        texte.setText(liste.toString());
    }
    }

    private boolean retirerDeLaListeTousLesElementsCommencantPar(String prefixe) {
        boolean resultat = false;
        if(liste.contains(prefixe)){
            liste.removeAll(Collections.singleton(prefixe));
            Integer oldValue = occurrences.put(saisie.getText(), 0);
            
            return true;
        }
        
        return resultat;
    }

}
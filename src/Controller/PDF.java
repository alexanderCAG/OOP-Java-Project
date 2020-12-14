
package Controller;

/*Nos imports*/
import Vue.Employeur;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.logging.*;
import javax.swing.*;
/* Cette classe implemente un action listener. Elle se lance quand le bouton AJOUTER de la jframe EMPLOYEUR est selectionne. Elle permet d'ajouter un job*/

public class PDF implements ActionListener{
    private Employeur e;

    /*Constructeur*/
    public PDF(Employeur e) {
        this.e = e;
    }
    
    /*Defini l'action que nous voulons faire*/
    public void actionPerformed(ActionEvent ae){
        try {
            creationpdf();
        } catch (DocumentException ex) {
            Logger.getLogger(PDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*Permet l'enregistrement d'un fichier PDF*/
    public void creationpdf() throws DocumentException{
        String value = JOptionPane.showInputDialog(e , " 'choisir' : choisir l'emplacement du fichier PDF\n 'automatique' : fichier PDF enregistré dans le dossier Projet");
        
        if("choisir".equals(value))     //Ici, le PDF est enregistré dans le fichier que l'utilisateur veut
        {
            String path = "";
        JFileChooser file = new JFileChooser();
        file.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int x = file.showSaveDialog(e);
        
        if(x==JFileChooser.APPROVE_OPTION)
        {
            path = file.getSelectedFile().getPath();
        }
        
        Document doc = new Document(PageSize.A4.rotate());      //change la position de la page (horizontal)
        
        try {
            PdfWriter.getInstance(doc, new FileOutputStream(path + "Table.pdf"));   //Nom de base du fichier au cas où l'utilisateur ne met rien
            doc.open();
            
            
            /*Mettre le camembert mais avant il faut "l'imprimer"*/
//            com.itextpdf.text.Image image1 = com.itextpdf.text.Image.getInstance("chart.png");
//            image1.scaleAbsolute(480, 300);
//            doc.add(image1);
            
            Paragraph titredoc = new Paragraph("CONFIDENTIEL",FontFactory.getFont(FontFactory.TIMES_BOLD,30, BaseColor.RED));
            titredoc.setAlignment(Element.ALIGN_CENTER);
            doc.add(titredoc);
            
            com.itextpdf.text.Image image = com.itextpdf.text.Image.getInstance("src/Image/playmobil.png");
            image.scaleToFit(200,200);      //definir la taille de l'image
            image.setAlignment(Element.ALIGN_LEFT);
            doc.add(image);
            
            Paragraph date = new Paragraph(new Date().toString());
            date.setAlignment(Element.ALIGN_RIGHT);
            doc.add(date);
            
            doc.add(new Paragraph("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"));
            doc.add(new Paragraph("\n"));
            
            PdfPTable table = new PdfPTable(3);
            PdfPCell cell = new PdfPCell(new Paragraph("Liste des candidtas"));
            
            cell.setColspan(5); //mettre nombre colonne
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.ORANGE);
            table.addCell(cell);
            
            table.addCell("Nom");
            table.addCell("Prenom");
            table.addCell("Date de début");
            
            for(int i=0; i<e.jTable1.getRowCount();i++)     
            {
                //recupere les valeurs du tableau
                String Nom = e.jTable1.getValueAt(i, 2).toString();
                String Prenom = e.jTable1.getValueAt(i, 3).toString();
                String Date = e.jTable1.getValueAt(i, 4).toString();
                
                //Les met dans le PDF
                table.addCell(Nom);
                table.addCell(Prenom);
                table.addCell(Date);
                
            }
            
            doc.add(table);
            
            
        } catch (FileNotFoundException ex) {
        Logger.getLogger(Employeur.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(Employeur.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Employeur.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        doc.close();
        
        }else if("automatique".equals(value))       //Ici, l'utilisateur enregistre le PDF dans le dossier du Projet
                {
                    e.tour++;
        
        Document docu = new Document(PageSize.A4.rotate());     //Change la position de la feuille A4 en horizontal
        
        try {
            PdfWriter.getInstance(docu, new FileOutputStream("Table" + e.tour + ".pdf"));       //Nom du PDF a chaque tout un nouveau PDF est enregistré
            docu.open();
            
            
            /*Mettre le camembert mais avant il faut "l'imprimer"*/
//            com.itextpdf.text.Image image1 = com.itextpdf.text.Image.getInstance("chart.png");
//            image1.scaleAbsolute(480, 300);
//            doc.add(image1);
            
            Paragraph titredoc = new Paragraph("CONFIDENTIEL",FontFactory.getFont(FontFactory.TIMES_BOLD,30, BaseColor.RED));
            titredoc.setAlignment(Element.ALIGN_CENTER);
            docu.add(titredoc);
            
            com.itextpdf.text.Image image = com.itextpdf.text.Image.getInstance("src/Image/playmobil.png");
            image.scaleToFit(200,200);      //definir la taille de l'image
            image.setAlignment(Element.ALIGN_LEFT);
            docu.add(image);
            
            Paragraph date = new Paragraph(new Date().toString());
            date.setAlignment(Element.ALIGN_RIGHT);
            docu.add(date);
            
            docu.add(new Paragraph("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"));
            docu.add(new Paragraph("\n"));
            
            PdfPTable table = new PdfPTable(3);
            PdfPCell cell = new PdfPCell(new Paragraph("Liste des candidtas"));
            
            cell.setColspan(3); //mettre nombre colonne
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.ORANGE);
            table.addCell(cell);
            
            table.addCell("Nom");
            table.addCell("Prenom");
            table.addCell("Date de début");
            
            for(int i=0; i<e.jTable1.getRowCount();i++)
            {
                //recupere les donnees du tableau
                String Nom = e.jTable1.getValueAt(i, 2).toString();
                String Prenom = e.jTable1.getValueAt(i, 3).toString();
                String Date = e.jTable1.getValueAt(i, 4).toString();
                
                //les met dans le PDF
                table.addCell(Nom);
                table.addCell(Prenom);
                table.addCell(Date);
                
            }
            
            docu.add(table);
            
            JOptionPane.showMessageDialog(null, "Votre liste a été enregistré au format PDF dans le dossier du projet");
            
            
        } catch (FileNotFoundException ex) {
        Logger.getLogger(Employeur.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Employeur.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        docu.close();
                }
        else
        {
            JOptionPane.showMessageDialog(null, "Fait un choix");
        }
    } 
}

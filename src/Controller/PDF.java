/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.logging.*;
import javax.swing.*;
import oop.java.project.GUI.*;

/**
 *
 * @author Geoffroy
 */
public class PDF implements ActionListener{
    private Employeur e;

    public PDF(Employeur e) {
        this.e = e;
    }
    public void actionPerformed(ActionEvent ae){
        try {
            creationpdf();
        } catch (DocumentException ex) {
            Logger.getLogger(PDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void creationpdf() throws DocumentException{
        String value = JOptionPane.showInputDialog(e , " 'choisir' : choisir l'emplacement du fichier PDF\n 'automatique' : fichier PDF enregistré dans le dossier Projet");
        
        if("choisir".equals(value))
        {
            String path = "";
        JFileChooser file = new JFileChooser();
        file.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int x = file.showSaveDialog(e);
        
        if(x==JFileChooser.APPROVE_OPTION)
        {
            path = file.getSelectedFile().getPath();
        }
        
        Document doc = new Document(PageSize.A4.rotate());
        
        try {
            PdfWriter.getInstance(doc, new FileOutputStream(path + "Table.pdf"));
            //PdfWriter.getInstance(doc, new FileOutputStream("Table.pdf"));
            doc.open();
            
            
            /*Mettre le camembert mais avant il faut "l'imprimer"*/
//            com.itextpdf.text.Image image1 = com.itextpdf.text.Image.getInstance("chart.png");
//            image1.scaleAbsolute(480, 300);
//            doc.add(image1);
            
            Paragraph titredoc = new Paragraph("CONFIDENTIEL",FontFactory.getFont(FontFactory.TIMES_BOLD,30, BaseColor.RED));
            titredoc.setAlignment(Element.ALIGN_CENTER);
            doc.add(titredoc);
            
            com.itextpdf.text.Image image = com.itextpdf.text.Image.getInstance("src/oop/java/project/GUI/Image/playmobil.png");
            //doc.add(new Paragraph("Image"));
            image.scaleToFit(200,200);      /*definir la taille de l'image*/
            image.setAlignment(Element.ALIGN_LEFT);
            doc.add(image);
            
            Paragraph date = new Paragraph(new Date().toString());
            date.setAlignment(Element.ALIGN_RIGHT);
            doc.add(date);
            
            //doc.add(new Paragraph("CONFIDENTIEL",FontFactory.getFont(FontFactory.TIMES_BOLD,18, BaseColor.RED)));
            //doc.add(new Paragraph(new Date().toString()));
            doc.add(new Paragraph("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"));
            doc.add(new Paragraph("\n"));
            
            PdfPTable table = new PdfPTable(3);
            PdfPCell cell = new PdfPCell(new Paragraph("Liste des candidtas"));
            
            cell.setColspan(3); //mettre nombre colonne
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.ORANGE);
            table.addCell(cell);
            
            table.addCell("Nom");
            table.addCell("Prenom");
            table.addCell("Age");
            
            for(int i=0; i<e.jTable1.getRowCount();i++)
            {
                String Nom = e.jTable1.getValueAt(i, 0).toString();
                String Prenom = e.jTable1.getValueAt(i, 1).toString();
                String Age = e.jTable1.getValueAt(i, 2).toString();
                
                table.addCell(Nom);
                table.addCell(Prenom);
                table.addCell(Age);
                
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
        }else if("automatique".equals(value))
                {
                    e.tour++;
        
        Document docu = new Document(PageSize.A4.rotate());
        
        try {
            PdfWriter.getInstance(docu, new FileOutputStream("Table" + e.tour + ".pdf"));
            docu.open();
            
            
            /*Mettre le camembert mais avant il faut "l'imprimer"*/
//            com.itextpdf.text.Image image1 = com.itextpdf.text.Image.getInstance("chart.png");
//            image1.scaleAbsolute(480, 300);
//            doc.add(image1);
            
            Paragraph titredoc = new Paragraph("CONFIDENTIEL",FontFactory.getFont(FontFactory.TIMES_BOLD,30, BaseColor.RED));
            titredoc.setAlignment(Element.ALIGN_CENTER);
            docu.add(titredoc);
            
            com.itextpdf.text.Image image = com.itextpdf.text.Image.getInstance("src/oop/java/project/GUI/Image/playmobil.png");
            //doc.add(new Paragraph("Image"));
            image.scaleToFit(200,200);      /*definir la taille de l'image*/
            image.setAlignment(Element.ALIGN_LEFT);
            docu.add(image);
            
            Paragraph date = new Paragraph(new Date().toString());
            date.setAlignment(Element.ALIGN_RIGHT);
            docu.add(date);
            
            //doc.add(new Paragraph("CONFIDENTIEL",FontFactory.getFont(FontFactory.TIMES_BOLD,18, BaseColor.RED)));
            //doc.add(new Paragraph(new Date().toString()));
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
            table.addCell("Age");
            
            for(int i=0; i<e.jTable1.getRowCount();i++)
            {
                String Nom = e.jTable1.getValueAt(i, 0).toString();
                String Prenom = e.jTable1.getValueAt(i, 1).toString();
                String Age = e.jTable1.getValueAt(i, 2).toString();
                
                table.addCell(Nom);
                table.addCell(Prenom);
                table.addCell(Age);
                
            }
            
            docu.add(table);
            
            JOptionPane.showMessageDialog(null, "Votre liste a été enregistré au format PDF dans vos documents");
            
            
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

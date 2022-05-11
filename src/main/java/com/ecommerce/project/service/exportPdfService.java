package com.ecommerce.project.service;

import com.ecommerce.project.models.Commande;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.stream.Stream;

@Service
public class exportPdfService {
    public static ByteArrayInputStream commandeExportPdf(List<Commande> commandes) {

        Document document = new com.itextpdf.text.Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            PdfWriter.getInstance(document, out);
            document.open();

            Font font = FontFactory.getFont(FontFactory.COURIER, 14, BaseColor.BLACK);
            Paragraph para = new Paragraph("LIST COMMANDE", font);
            para.setAlignment(Element.ALIGN_CENTER);
            document.add(Chunk.NEWLINE);
            PdfPTable table = new PdfPTable(2);

            Stream.of("Nom Client", "Products").forEach(headrerTitle -> {
                    PdfPCell header = new PdfPCell();
                    Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
                            header.setBackgroundColor(BaseColor.GRAY);
                            header.setHorizontalAlignment(Element.ALIGN_CENTER);
                            header.setBorderWidth(1);
                            header.setPhrase(new Phrase(headrerTitle, headFont));
                            table.addCell(header);
            });
            for (Commande c : commandes){
                PdfPCell nameCell = new PdfPCell(new Phrase(c.getUser().getFirst_name()));
                nameCell.setPaddingLeft(1);
                nameCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                nameCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(nameCell);

                PdfPCell idCell = new PdfPCell(new Phrase(c.getProducts().toString()));
                idCell.setPaddingLeft(1);
                idCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                idCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(idCell);
            }
            document.add(table);
            document.close();

        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }


        return new ByteArrayInputStream(out.toByteArray()) ;
    }}

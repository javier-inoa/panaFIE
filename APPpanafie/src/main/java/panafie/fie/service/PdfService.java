//package panafie.fie.service;
//
//import com.github.librepdf.openpdf.text.Document;
//import com.github.librepdf.openpdf.text.Paragraph;
//import com.github.librepdf.openpdf.text.pdf.PdfWriter;
//import org.springframework.stereotype.Service;
//import panafie.fie.model.pasanaku.Pasanaku;
//import panafie.fie.repository.PasanakuRepository;
//
//import javax.servlet.http.HttpServletResponse;
//import java.util.List;
//
//@Service
//public class PdfService {
//
//    private final PasanakuRepository pasanakuRepository;
//
//    public PdfService(PasanakuRepository pasanakuRepository) {
//        this.pasanakuRepository = pasanakuRepository;
//    }
//
//    public void generatePasanakuReport(HttpServletResponse response) {
//        try {
//            response.setContentType("application/pdf");
//            response.setHeader("Content-Disposition", "attachment; filename=reporte-pasanakus.pdf");
//
//            Document document = new Document();
//            PdfWriter.getInstance(document, response.getOutputStream());
//
//            document.open();
//
//            List<Pasanaku> pasanakus = pasanakuRepository.findAll();
//
//            if (pasanakus.isEmpty()) {
//                document.add(new Paragraph("No hay Pasanakus registrados."));
//            } else {
//                document.add(new Paragraph("Reporte de Pasanakus"));
//
//                for (Pasanaku pasanaku : pasanakus) {
//                    document.add(new Paragraph("ID: " + pasanaku.getId()));
//                    document.add(new Paragraph("Nombre: " + pasanaku.getName()));
//                    document.add(new Paragraph("Descripción: " + pasanaku.getDescription()));
//                    document.add(new Paragraph("Estado: " + pasanaku.getState()));
//                    document.add(new Paragraph("Fecha de Inicio: " + pasanaku.getDateId().getStartDate()));
//                    document.add(new Paragraph("Fecha de Finalización: " + pasanaku.getDateId().getFinishDate()));
//
//                    document.add(new Paragraph("---------------------------------------"));
//                }
//            }
//
//            document.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new RuntimeException("Error al generar el reporte de Pasanakus.", e);
//        }
//    }
//}


package tema.pkg4_protocol;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Tema4_Protocol {

    public static void main(String[] args) throws AddressException, MessagingException {
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        
        Session sesio = Session.getDefaultInstance(prop);
        
        String correuEnvia = "smtppcoll@gmail.com";
        String pwd = "CalaPilar";
        String destinatari = "francesccoll@paucasesnovescifp.cat";
        String porque = "Do a flip";
        String msg = "Hello there\nGeneral Kenobi";
        
        try{
            MimeMessage mail = new MimeMessage(sesio);
        
            mail.setFrom(new InternetAddress(correuEnvia));
            mail.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatari));
            mail.setSubject(porque);
            mail.setText(msg);

            Transport trs = sesio.getTransport("smtp");

            trs.connect(correuEnvia,pwd);
            trs.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));
            trs.close();
            
            System.out.println("Correu enviat");
            
        } catch (Exception ex){
            System.out.println(ex);
        }        
    }
}

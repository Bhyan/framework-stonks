package br.ufrn.imd.stonks.framework.framework.service;

import br.ufrn.imd.stonks.framework.framework.model.DespesaAtivo;
import br.ufrn.imd.stonks.framework.framework.model.UsuarioAbstract;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.List;

public abstract class EmailServiceAbstract extends AbstractService {

    public Boolean enviarEmail(String mensagemEmail, UsuarioAbstract usuario, String destinatario, String assunto) {
        JavaMailSenderImpl mailSender = configurarHost();

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");

        try {
            helper.setFrom(destinatario);
            helper.setTo(usuario.getEmail());
            helper.setSubject(assunto);
            helper.setText(mensagemEmail, true);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        try {
            mailSender.send(mimeMessage);
            return true;
        } catch (MailException e) {
            System.out.print(e.getMessage());
        }

        return false;
    }

    public abstract String montarCorpoEmail(List<DespesaAtivo> entities);

    public abstract JavaMailSenderImpl configurarHost();
}

package NA;


public class NotificadorAlerta {

    private final EmailService emailService;
    private final SmsService smsService;
    private final Logger logger;

    public NotificadorAlerta(EmailService emailService, SmsService smsService, Logger logger) {
        this.emailService = emailService;
        this.smsService = smsService;
        this.logger = logger;
    }

    public void enviarAlerta(Usuario usuario, String mensaje, boolean esCritica) {
        if (!esCritica) {
            logger.registrar("Alerta ignorada: no crítica");
            return;
        }

        if (usuario.getCanal() == CanalPreferido.EMAIL && usuario.getEmail() != null) {
            emailService.enviarEmail(usuario.getEmail(), "ALERTA", mensaje);
            logger.registrar("Alerta enviada por email");
        } else if (usuario.getCanal() == CanalPreferido.SMS && usuario.getTelefono() != null) {
            smsService.enviarSms(usuario.getTelefono(), mensaje);
            logger.registrar("Alerta enviada por SMS");
        } else {
            logger.registrar("No se pudo enviar la alerta");
        }
    }
}

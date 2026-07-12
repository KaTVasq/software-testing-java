package test;

import NA.*;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;


class NotificadorAlertaTest {

    @Test
    void enviarAlerta_noCritica_registraIgnorada() {
        Logger logger = mock(Logger.class);
        EmailService emailService = mock(EmailService.class);
        SmsService smsService = mock(SmsService.class);

        NotificadorAlerta notificador = new NotificadorAlerta(emailService, smsService, logger);

        Usuario usuario = new Usuario("juan@mail.com", "123456789", CanalPreferido.EMAIL);

        notificador.enviarAlerta(usuario, "Mensaje de prueba", false);

        verify(logger).registrar("Alerta ignorada: no crítica");
        verifyNoMoreInteractions(logger, emailService, smsService);
    }

    @Test
    void enviarAlerta_criticaPrefiereEmail_enviaEmailYRegistra() {
        Logger logger = mock(Logger.class);
        EmailService emailService = mock(EmailService.class);
        SmsService smsService = mock(SmsService.class);

        NotificadorAlerta notificador = new NotificadorAlerta(emailService, smsService, logger);

        Usuario usuario = new Usuario("juan@mail.com", "123456789", CanalPreferido.EMAIL);

        notificador.enviarAlerta(usuario, "Mensaje crítico", true);

        verify(emailService).enviarEmail("juan@mail.com", "ALERTA", "Mensaje crítico");
        verify(logger).registrar("Alerta enviada por email");
        verifyNoMoreInteractions(logger, emailService, smsService);
    }

    @Test
    void enviarAlerta_criticaPrefiereSms_enviaSmsYRegistra() {
        Logger logger = mock(Logger.class);
        EmailService emailService = mock(EmailService.class);
        SmsService smsService = mock(SmsService.class);

        NotificadorAlerta notificador = new NotificadorAlerta(emailService, smsService, logger);

        Usuario usuario = new Usuario(null, "123456789", CanalPreferido.SMS);

        notificador.enviarAlerta(usuario, "Mensaje crítico", true);

        verify(smsService).enviarSms("123456789", "Mensaje crítico");
        verify(logger).registrar("Alerta enviada por SMS");
        verifyNoMoreInteractions(logger, emailService, smsService);
    }

    @Test
    void enviarAlerta_criticaSinDatosContacto_registraNoSePudoEnviar() {
        Logger logger = mock(Logger.class);
        EmailService emailService = mock(EmailService.class);
        SmsService smsService = mock(SmsService.class);

        NotificadorAlerta notificador = new NotificadorAlerta(emailService, smsService, logger);

        Usuario usuario = new Usuario(null, null, CanalPreferido.EMAIL);

        notificador.enviarAlerta(usuario, "Mensaje crítico", true);

        verify(logger).registrar("No se pudo enviar la alerta");
        verifyNoMoreInteractions(logger, emailService, smsService);
    }
}

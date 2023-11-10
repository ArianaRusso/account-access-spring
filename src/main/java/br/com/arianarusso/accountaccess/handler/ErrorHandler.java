package br.com.arianarusso.accountaccess.handler;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ErrorHandler {
//    @ExceptionHandler(RequisicaoInvalidaExcecao.class)
//    public ResponseEntity<StandardError> tratarErro400(RequisicaoInvalidaExcecao e, HttpServletRequest requisicao ){
//        String corpoDaResposta = "A requisição não pôde ser atendida.";
//        StandardError apiError = new StandardError(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), corpoDaResposta, e.getMessage(), requisicao.getRequestURI());
//        return new ResponseEntity<StandardError>(apiError, new HttpHeaders(), apiError.getStatus());
//    }
//
//    @ExceptionHandler({ RecursoNaoEncontradoExcecao.class })
//    public ResponseEntity<ApiErroDto> recursoNaoEncontradoExcecaoErro404(RecursoNaoEncontradoExcecao ex) {
//        return verificarRetornoComOuSemCausa(ex.getCausa(), ex.getMensagem(), HttpStatus.NOT_FOUND);
//    }


}

package com.nossaclinica.api.exceptionHandler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@ControllerAdvice
public class ExceptionHandlerApi extends ResponseEntityExceptionHandler{
	
	private MessageSource messageSource;
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		List<Problema.Field> campos = ex.getBindingResult().getAllErrors()
				.stream().map(o -> carregarField(o)).collect(Collectors.toList());
		
		Problema apiException = new Problema();
		apiException.setStatus(status.value());
		apiException.setDataHora(LocalDateTime.now());
		apiException.setTitulo("Error");
		apiException.setCampos(campos);		
		
		return handleExceptionInternal(ex, apiException, headers, status, request);
	}
	
	
	@ExceptionHandler(NegocioExcepiton.class)
	private ResponseEntity<Object> handleNegocioException(NegocioExcepiton ex, WebRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		Problema excecao = new Problema();
		excecao.setDataHora(LocalDateTime.now());
		excecao.setStatus(status.value());
		excecao.setTitulo(ex.getMessage());
		
		return handleExceptionInternal(ex, excecao, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}
	
	
	private Problema.Field carregarField(ObjectError objectError) {
		return new Problema.Field(((FieldError) objectError).getField(), 
				this.messageSource.getMessage(objectError, LocaleContextHolder.getLocale()));
		
	}
	
}


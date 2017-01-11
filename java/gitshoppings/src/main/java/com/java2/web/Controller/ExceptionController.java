package com.java2.web.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.java2.web.Dto.ErrorDto;
import com.java2.web.Exception.BadRequestException;
import com.java2.web.Exception.InternalServerErrorException;
import com.java2.web.Exception.MethodNotAllowedException;
import com.java2.web.Exception.NoContentException;
import com.java2.web.Exception.NotFoundException;
import com.java2.web.Exception.OkException;
import com.java2.web.Exception.UnauthorizedException;

public class ExceptionController {
	
	@ExceptionHandler(NotFoundException.class)
	@ResponseStatus(code=HttpStatus.NOT_FOUND)
	public @ResponseBody ErrorDto notFound() {
		ErrorDto dto = new ErrorDto();
		dto.setErrorMessage("Resource not found!");
		return dto;
	}
	
	@ExceptionHandler(BadRequestException.class)
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	public @ResponseBody ErrorDto badRequest() {
		ErrorDto dto = new ErrorDto();
		dto.setErrorMessage("Request is bad!");
		return dto;
	}
	
	@ExceptionHandler(NoContentException.class)
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public @ResponseBody ErrorDto noContent() {
		ErrorDto dto = new ErrorDto();
		dto.setErrorMessage("Request is OK, but response'content is null!");
		return dto;
	}
	
	@ExceptionHandler(OkException.class)
	@ResponseStatus(code=HttpStatus.OK)
	public @ResponseBody ErrorDto ok() {
		ErrorDto dto = new ErrorDto();
		dto.setErrorMessage("Request is Ok, and content already responsed!");
		return dto;
	}
	
	@ExceptionHandler(UnauthorizedException.class)
	@ResponseStatus(code=HttpStatus.UNAUTHORIZED)
	public @ResponseBody ErrorDto unauthorized() {
		ErrorDto dto = new ErrorDto();
		dto.setErrorMessage("user'Id or user'password is bad!");
		return dto;
	}
	
	@ExceptionHandler(MethodNotAllowedException.class)
	@ResponseStatus(code=HttpStatus.METHOD_NOT_ALLOWED)
	public @ResponseBody ErrorDto methodNotAllowed() {
		ErrorDto dto = new ErrorDto();
		dto.setErrorMessage("Request is bad!");
		return dto;
	}
	
	@ExceptionHandler(InternalServerErrorException.class)
	@ResponseStatus(code=HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody ErrorDto internalServerError() {
		ErrorDto dto = new ErrorDto();
		dto.setErrorMessage("Server is bad!");
		return dto;
	}
}

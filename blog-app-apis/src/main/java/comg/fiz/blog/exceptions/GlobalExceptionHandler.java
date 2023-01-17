package comg.fiz.blog.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import comg.fiz.blog.payloads.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler({ResourceNotFoundException.class,StringResourceNotFoundException.class})
	public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(Exception ex)
	{
		
		String messString= ex.getMessage();
		ApiResponse apiResponse = new  ApiResponse(messString,false);
		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> handleMethodArgNotValidException(MethodArgumentNotValidException ex)
	{
		
		HashMap<String, String> response = new HashMap<>();
		ex.getAllErrors().forEach(error->{
			
		 String fieldName = ((FieldError)error).getField();
		 String message =  error.getDefaultMessage();
		 response.put(fieldName, message);
		});
		return  new ResponseEntity<Map<String,String>>(response,HttpStatus.BAD_REQUEST);
	}
}

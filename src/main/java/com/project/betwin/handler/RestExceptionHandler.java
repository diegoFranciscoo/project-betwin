package com.project.betwin.handler;

import com.project.betwin.exception.BetException.*;
import com.project.betwin.exception.UserException.UserNotFoundDetails;
import com.project.betwin.exception.UserException.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    private ResponseEntity<UserNotFoundDetails> handlerUserNotFound(UserNotFoundException userNotFoundException){
        return new ResponseEntity<>(UserNotFoundDetails.builder()
                .title("User not found")
                .details(userNotFoundException.getMessage())
                .httpStatus(HttpStatus.NOT_FOUND)
                .timestamp(LocalDateTime.now())
                .build(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MinimalAmountException.class)
    private ResponseEntity<MinimalAmountDetails> handlerMinimalAmountDetails(MinimalAmountException minimalAmountException) {
        return new ResponseEntity<>(MinimalAmountDetails.builder()
                .title("The minimum amount to bet is R$20")
                .details(minimalAmountException.getMessage())
                .httpStatus(HttpStatus.BAD_REQUEST)
                .timestamp(LocalDateTime.now())
                .build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InsufficientAmountException.class)
    private ResponseEntity<InsufficientAmountDetails> handlerInsufficientAmount(InsufficientAmountException insufficientAmountException) {
        return new ResponseEntity<>(InsufficientAmountDetails.builder()
                .title("Insufficient amount to complete the bet")
                .details(insufficientAmountException.getMessage())
                .httpStatus(HttpStatus.BAD_REQUEST)
                .timestamp(LocalDateTime.now())
                .build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ErrorProcessingBetException.class)
    private ResponseEntity<ErrorProcessingBetDetails> handlerErrorProcessingBet(ErrorProcessingBetException errorProcessingBetException) {
        return new ResponseEntity<>(ErrorProcessingBetDetails.builder()
                .title("Error processing bet")
                .details(errorProcessingBetException.getMessage())
                .httpStatus(HttpStatus.BAD_REQUEST)
                .timestamp(LocalDateTime.now())
                .build(), HttpStatus.BAD_REQUEST);
    }
}

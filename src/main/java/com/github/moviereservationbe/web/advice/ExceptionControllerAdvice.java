package com.github.moviereservationbe.web.advice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.github.moviereservationbe.service.exceptions.*;

import java.lang.NullPointerException;

@RestControllerAdvice
@Slf4j
public class ExceptionControllerAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadRequestException.class)
    public String handleBadRequestException(BadRequestException bre){
        log.error("Bad Request Exception: "+ bre.getMessage());
        return bre.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NotFoundException.class)
    public String handleNotFoundException(NotFoundException nfe){
        log.error("Not Found Exception:" + nfe.getMessage());
        return  nfe.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NullPointerException.class)
    public String handleNullPointerException(NullPointerException npe){
        log.error("Null pointer Exception: "+ npe.getMessage());
        return npe.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(SoldOutException.class)
    public String handleSoldOutException(SoldOutException soe){
        log.error("Sold Out Exception: "+ soe.getMessage());
        return soe.getMessage();
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ExpiredException.class)
    public String handlerExpiredException(ExpiredException ee){
        log.error("Expired Exception : "+ ee.getMessage());
        return ee.getMessage();
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(AgeRestrictionException.class)
    public String handlerAgeRestrictionException(AgeRestrictionException are){
        log.error("Expired Exception : "+ are.getMessage());
        return are.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ReviewAlreadyExistsException.class)
    public String handlerReviewAlreadyExistsException(ReviewAlreadyExistsException raee){
        log.error("Expired Exception : "+ raee.getMessage());
        return raee.getMessage();
    }
}
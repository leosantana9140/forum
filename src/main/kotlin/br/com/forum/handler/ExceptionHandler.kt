package br.com.forum.handler

import br.com.forum.dto.ErrorViewDTO
import br.com.forum.exception.NotFoundException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.servlet.http.HttpServletRequest

@RestControllerAdvice
class ExceptionHandler {
    @ExceptionHandler(NotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleNotFoundException(notFoundException: NotFoundException, httpServletRequest: HttpServletRequest): ErrorViewDTO {
        return ErrorViewDTO(
            status = HttpStatus.NOT_FOUND.value(),
            error = HttpStatus.NOT_FOUND.name,
            message = notFoundException.message,
            path = httpServletRequest.servletPath
        )
    }

    @ExceptionHandler(Exception::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleException(exception: Exception, httpServletRequest: HttpServletRequest): ErrorViewDTO {
        return ErrorViewDTO(
            status = HttpStatus.INTERNAL_SERVER_ERROR.value(),
            error = HttpStatus.INTERNAL_SERVER_ERROR.name,
            message = exception.message,
            path = httpServletRequest.servletPath
        )
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleValidationException(methodArgumentNotValidException: MethodArgumentNotValidException, httpServletRequest: HttpServletRequest): ErrorViewDTO {
        val errorMessage = HashMap<String, String?>()

        methodArgumentNotValidException.bindingResult.fieldErrors.forEach{
                error -> errorMessage.put(error.field, error.defaultMessage)
        }

        return ErrorViewDTO(
            status = HttpStatus.BAD_REQUEST.value(),
            error = HttpStatus.BAD_REQUEST.name,
            message = errorMessage.toString(),
            path = httpServletRequest.servletPath
        )
    }
}

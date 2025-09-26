package br.com.agi.demo.dto.response;

import org.springframework.http.HttpStatus;

public record BaseResponse(String mensagem, HttpStatus status, Object data) {
}

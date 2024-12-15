package org.samid.infrastructure.rest.advice;

public record ResponseError<T>(int status, String message, T payload) {
}

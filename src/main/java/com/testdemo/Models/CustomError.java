package com.testdemo.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomError {

    private String title;
    private String message;
    private String datetime;
    private HttpStatus httpStatus;

    public static class Builder {

        private String title;
        private String message;
        private String datetime;
        private HttpStatus httpStatus;

        public Builder titleOfException(String title) {
            this.title = title;
            return this;
        }

        public Builder fullMessageOfException(String message) {
            this.message = message;
            return this;
        }

        public Builder datetimeOfException(String datetime) {
            this.datetime = datetime;
            return this;
        }

        public Builder httpStatusOfException(HttpStatus httpStatus) {
            this.httpStatus = httpStatus;
            return this;
        }

        public CustomError build() {
            CustomError customError = new CustomError();
            customError.title = this.title;
            customError.message = this.message;
            customError.datetime = this.datetime;
            customError.httpStatus = this.httpStatus;

            return customError;
        }
    }
}
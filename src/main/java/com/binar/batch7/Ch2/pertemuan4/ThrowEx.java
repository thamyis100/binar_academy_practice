package com.binar.batch7.Ch2.pertemuan4;

public class ThrowEx {
        public void processPayment(double amount) throws PaymentException {
            if (amount <= 0) {
                throw new PaymentException("Jumlah pembayaran tidak valid", new PaymentResponse(false, "Jumlah pembayaran tidak boleh negatif"));
            }
            // Proses pembayaran...
        }

        public class PaymentException extends Exception {
            private PaymentResponse response;

            public PaymentException(String message, PaymentResponse response) {
                super(message);
                this.response = response;
            }

            public PaymentResponse getResponse() {
                return response;
            }
        }

        public class PaymentResponse {
            private boolean success;
            private String errorMessage;

            public PaymentResponse(boolean success, String errorMessage) {
                this.success = success;
                this.errorMessage = errorMessage;
            }

            public boolean isSuccess() {
                return success;
            }

            public String getErrorMessage() {
                return errorMessage;
            }
        }


}

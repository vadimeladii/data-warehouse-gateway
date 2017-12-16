package md.utm.fcim.gateway.error;

import feign.Util;
import feign.codec.ErrorDecoder;

import java.io.IOException;

public class MyErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder defaultErrorDecoder = new ErrorDecoder.Default();

    @Override
    public Exception decode(String methodKey, feign.Response response) {
        if (response.status() >= 400 && response.status() <= 599) {
            String body = null;
            if (response.body() != null) {
                try {
                    body = Util.toString(response.body().asReader());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return new IllegalArgumentException(body, response.status());
        }
        return defaultErrorDecoder.decode(methodKey, response);
    }
}

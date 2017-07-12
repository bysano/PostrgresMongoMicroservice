package by.user.application;

import by.user.domain.FilterDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.context.request.WebRequest;

import java.beans.PropertyEditorSupport;
import java.io.IOException;

@ControllerAdvice
public class StringToObjectConfiguration {
    @InitBinder
    public void registerCustomEditors(WebDataBinder binder, WebRequest request) {


        binder.registerCustomEditor(FilterDTO[].class, new PropertyEditorSupport() {
            Object value;
            @Override
            public Object getValue() {
                return value;
            }

            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                ObjectMapper mapper = new ObjectMapper();
                try {
                    value = mapper.readValue(text, FilterDTO[].class);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

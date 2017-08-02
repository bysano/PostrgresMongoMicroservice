package by.user.domain;
import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;

import java.util.List;

@Data
public class FilterDTO implements Serializable{

    @JsonEnumDefaultValue
    private FilterOperator operator;

    private String property;

    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private List<String> value;

}

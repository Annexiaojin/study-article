package com.article.validation;

import com.article.anno.State;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class StateValidation implements ConstraintValidator<State,String> {
    /**
     *
     * @param value  将来要校验的数据
     * @param context
     * @return
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        //校验信息
        if (value == null){
            return false;
        }
        if (value .equals("已发布") || value.equals("草稿")){
            return true;
        }
        return false;
    }
}

package com.klicws.util;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.klicws.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class UnitTest<T> {

	private Validator validator;
	private Set<ConstraintViolation<T>> errors;
	private ValidatorFactory vf;

	public Set<ConstraintViolation<T>> getErrors() {
		return errors;
	}

	public void check(T model) {

		if (vf == null) {
			vf = Validation.buildDefaultValidatorFactory();
			this.validator = vf.getValidator();
		}

		errors = this.validator.validate(model);

	}

}

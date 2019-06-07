package com.waa.abdu.waaspringboot.validator;


import com.waa.abdu.waaspringboot.domain.Member;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class MemberValidator implements Validator {
	@Override
	public boolean supports(Class<?> c) {
		return Member.class.isAssignableFrom(c);
	}

	@Override
	public void validate(Object command, Errors errors) {
		String[] errorArgs = { "First Name" };
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "NotEmpty", errorArgs);
		errorArgs = new String[] { "Last Name" };
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "NotEmpty", errorArgs);
		Member member = (Member) command;

		if (member.getMemberNumber() == null || member.getMemberNumber() <= 0)
			errors.rejectValue("memberNumber", "Member.Number.lessthan");
		if (member.getMemberNumber() == null || member.getAge() < 18)
			errors.rejectValue("age", "Member.age");
		
	}

}

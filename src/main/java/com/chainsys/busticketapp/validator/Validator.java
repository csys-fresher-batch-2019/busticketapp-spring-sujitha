package com.chainsys.busticketapp.validator;

import org.springframework.stereotype.Component;

import com.chainsys.busticketapp.domain.Admin;
import com.chainsys.busticketapp.domain.Booking;
import com.chainsys.busticketapp.domain.BusRoutes;
import com.chainsys.busticketapp.domain.OperatorsDetails;
import com.chainsys.busticketapp.domain.UserDetails;
import com.chainsys.busticketapp.exception.ValidatorException;

@Component
public class Validator {

	public void validateUserRegisterForm(UserDetails u) throws ValidatorException {
		if (u.getUserName() == null || "".equals(u.getUserName().trim())) {
			throw new ValidatorException("Name cannot be blank/empty");
		}
		if (u.getUserGender() == null || "".equals(u.getUserGender().trim())) {
			throw new ValidatorException("Gender cannot be blank/empty");
		}
		if (u.getUserPhnNum() == 0 || Long.toString(u.getUserPhnNum()).length() < 10
				|| Long.toString(u.getUserPhnNum()).length() > 10) {

			throw new ValidatorException("Mobile-number is invalid");
		}
		if (u.getPassword() == null || "".equals(u.getPassword().trim())) {
			throw new ValidatorException("Password cannot be blank/empty");
		}

	}

	public void validateUserLoginForm(long phoneNum, String password) throws ValidatorException {
		UserDetails u = new UserDetails();
		if (phoneNum == 0 || Long.toString(u.getUserPhnNum()).length() < 10
				|| Long.toString(u.getUserPhnNum()).length() > 10) {
			throw new ValidatorException("Mobile-number is invalid");
		}
		if (password == null || "".equals(password.trim())) {
			throw new ValidatorException("Password cannot be blank/empty");
		}
	}

	public static void validateAdminLoginForm(Admin a) throws ValidatorException {
		if (a.getAdminMailId() == null || "".equals(a.getAdminMailId().trim())) {
			throw new ValidatorException("Mail Id cannot be blank/empty");
		}
		if (a.getAdminPassword() == null || "".equals(a.getAdminPassword().trim())) {
			throw new ValidatorException("Password cannot be blank/empty");
		}
	}

	public static void validateOperatorsRegisterForm(OperatorsDetails o) throws ValidatorException {
		if (o.getOperatorName() == null || "".equals(o.getOperatorName().trim())) {
			throw new ValidatorException("Name cannot be blank/empty");
		}
		if (o.getOperatorEmailId() == null || "".equals(o.getOperatorEmailId().trim())) {
			throw new ValidatorException("Mail Id cannot be blank/empty");
		}
		if (o.getOperatorPhoneNumber() == null) {
			throw new ValidatorException("Mobile-number is invalid");
		}
		if (o.getOperatorEmailId() == null || "".equals(o.getOperatorEmailId().trim())) {
			throw new ValidatorException("Mail Id cannot be blank/empty");
		}
	}

	public static void validateOperatorsLoginForm(OperatorsDetails o) throws ValidatorException {
		if (o.getOperatorEmailId() == null || "".equals(o.getOperatorEmailId().trim())) {
			throw new ValidatorException("Mail Id cannot be blank/empty");
		}
		if (o.getOperatorEmailId() == null || "".equals(o.getOperatorEmailId().trim())) {
			throw new ValidatorException("Mail Id cannot be blank/empty");
		}
	}

	public static void validateFindLocationForm(BusRoutes b) throws ValidatorException {
		if (b.getFromLocation() == null || "".equals(b.getFromLocation().trim())) {
			throw new ValidatorException("From Location cannot be empty/blank");
		}
		if (b.getToLocation() == null || "".equals(b.getToLocation().trim())) {
			throw new ValidatorException("To Location cannot be empty/blank");
		}
	}

	public static void validateTicketBookingForm(Booking b) throws ValidatorException {
		if (b.getBusNum() == 0) {
			throw new ValidatorException("Bus Number cannot be empty/blank");
		}
		if (b.getSeatNo() == 0) {
			throw new ValidatorException("Seats cannot be empty/blank");
		}
		if (b.getBookedDate() == null) {
			throw new ValidatorException("Bus Number cannot be empty/blank");
		}
		if (b.getUserGender() == null || "".equals(b.getUserGender().trim())) {
			throw new ValidatorException("Gender cannot be empty/blank");
		}
		if (b.getGenderPreference() == null || "".equals(b.getGenderPreference().trim())) {
			throw new ValidatorException("Gender Preference cannot be empty/blank");
		}

	}
}

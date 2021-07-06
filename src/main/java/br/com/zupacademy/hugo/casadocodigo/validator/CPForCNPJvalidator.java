package br.com.zupacademy.hugo.casadocodigo.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CPForCNPJvalidator implements ConstraintValidator<CPForCNPJ, String> {


    @Override
    public void initialize(CPForCNPJ constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String document, ConstraintValidatorContext constraintValidatorContext) {

        String s = document.replaceAll("([\\.])|([\\-])|([\\/])", "");

        return isCNPJ(s) || isCPF(s);
    }

    private boolean isCPF(String document) {

        if (document.equals("00000000000") || document.length() != 11) {
            return false;
        }

        int i;
        int j;
        int digit;
        int coeficient;
        int sum;
        int[] foundDv = { 0, 0 };

        int dv1 = Integer.parseInt(String.valueOf(document.charAt(document.length() - 2)));
        int dv2 = Integer.parseInt(String.valueOf(document.charAt(document.length() - 1)));

        for (j = 0; j < 2; j++) {
            sum = 0;
            coeficient = 2;

            for (i = document.length() - 3 + j; i >= 0; i--) {
                digit = Integer.parseInt(String.valueOf(document.charAt(i)));
                sum += digit * coeficient;
                coeficient++;
            }

            foundDv[j] = 11 - sum % 11;

            if (foundDv[j] >= 10) {
                foundDv[j] = 0;
            }
        }

        return dv1 == foundDv[0] && dv2 == foundDv[1];
    }

    public boolean isCNPJ(String document){

        if (document.equals("00000000000000") || document.length() != 14) {
            return false;
        }

        int i;
        int j;
        int digit;
        int coeficient;
        int sum;
        int[] foundDv = { 0, 0 };

        int dv1 = Integer.parseInt(String.valueOf(document.charAt(document.length() - 2)));
        int dv2 = Integer.parseInt(String.valueOf(document.charAt(document.length() - 1)));

        for (j = 0; j < 2; j++) {
            sum = 0;
            coeficient = 2;

            for (i = document.length() - 3 + j; i >= 0; i--) {
                digit = Integer.parseInt(String.valueOf(document.charAt(i)));
                sum += digit * coeficient;
                coeficient++;

                if (coeficient > 9) {
                    coeficient = 2;
                }
            }

            foundDv[j] = 11 - sum % 11;

            if (foundDv[j] >= 10) {
                foundDv[j] = 0;
            }
        }

        return dv1 == foundDv[0] && dv2 == foundDv[1];

    }

}

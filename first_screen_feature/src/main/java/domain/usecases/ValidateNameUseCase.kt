package domain.usecases

import android.util.Patterns
import domain.models.ValidationResult

class ValidateNameUseCase {

    fun isNameValid(name:String): ValidationResult {
        val containsDigits = name.any {
            it.isDigit()
        }
        val firstChar = name.firstOrNull()

        if(name.isEmpty()){
            return ValidationResult(
                successful = false,
                errorMessage = "Your name must not be empty"
            )
        }else if(containsDigits || name.length == 1){
            return ValidationResult(
                successful = false,
                errorMessage = "Invalid name"
            )
        } else if(firstChar == null || !firstChar.isUpperCase()){
            return ValidationResult(
                successful = false,
                errorMessage = "Why your name does not starting with capital letter?:)"
            )
        } else if(Patterns.EMAIL_ADDRESS.matcher(name).matches()){
            return ValidationResult(
                successful = false,
                errorMessage = "Invalid name"
            )
        }

        return ValidationResult(
            successful = true,
            errorMessage = null
        )
    }

}
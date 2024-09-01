package domain.usecases

import domain.models.ValidationResult

class ValidateDetailsUseCase {
    fun isDetailsValid(details:String): ValidationResult {
        if(details.isEmpty()){
            return ValidationResult(
                successful = false,
                errorMessage = "Your details must not be empty"
            )
        }

        return ValidationResult(
            successful = true,
        )
    }
}
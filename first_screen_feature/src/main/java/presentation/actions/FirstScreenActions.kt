package presentation.actions

sealed class FirstScreenActions {
    data class Submit(val dataId: Int?) : FirstScreenActions()
    data class OnNameChanged(
        val name:String
    ):FirstScreenActions()
    data class OnDetailsChanged(
        val details:String
    ):FirstScreenActions()
}
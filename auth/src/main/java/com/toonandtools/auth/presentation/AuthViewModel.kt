import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.toonandtools.auth.domain.GetLoginOptionsUseCase
import com.toonandtools.auth.domain.LoginOptions
import kotlinx.coroutines.launch

class AuthViewModel(
    private val getLoginOptionsUseCase: GetLoginOptionsUseCase
) : ViewModel() {

    private val _loginOptions = MutableLiveData<LoginOptions>()
    val loginOptions: LiveData<LoginOptions> = _loginOptions

    fun fetchLoginOptions(userId: String) {
        viewModelScope.launch {
            val options = getLoginOptionsUseCase(userId)
            _loginOptions.value = options
        }
    }
}

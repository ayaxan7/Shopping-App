package eu.testing.compui.auth.signup

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.auth.auth
import kotlinx.coroutines.tasks.await

sealed class SignUpState {
    object Idle : SignUpState()
    object Loading : SignUpState()
    data class Success(val message: String) : SignUpState()
    data class Error(val error: String) : SignUpState()
}

class SignUpViewModel : ViewModel() {
    private var _signUpState = mutableStateOf<SignUpState>(SignUpState.Idle)
    val signUpState: State<SignUpState> get() = _signUpState

    fun signUpWithEmailPassword(email: String, password: String) {
        val auth: FirebaseAuth = Firebase.auth
        _signUpState.value = SignUpState.Loading
        auth.createUserWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                _signUpState.value = SignUpState.Success("Account created successfully!")
            }
            .addOnFailureListener { exception ->
                _signUpState.value = SignUpState.Error(exception.message ?: "Signup failed.")
            }
    }
}


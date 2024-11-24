package pl.edu.uwr.loginapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import pl.edu.uwr.loginapp.databinding.FragmentRegisterBinding;

public class RegisterFragment extends Fragment {

    private FragmentRegisterBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRegisterBinding.inflate(inflater, container, false);

        binding.btnRegister.setOnClickListener(v -> {
            String username = binding.etUsername.getText().toString();
            String password = binding.etPassword.getText().toString();

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(getContext(), "Fields cannot be empty", Toast.LENGTH_SHORT).show();
            } else {
                UserManager.addUser(requireContext(), username, password);
                Toast.makeText(getContext(), "Registration successful", Toast.LENGTH_SHORT).show();
                NavDirections action = RegisterFragmentDirections.actionRegisterFragmentToLoginFragment();
                Navigation.findNavController(binding.getRoot()).navigate(action);
            }
        });

        binding.btnBackToMain.setOnClickListener(v -> {
            NavDirections action = RegisterFragmentDirections.actionRegisterFragmentToMainFragment();
            Navigation.findNavController(binding.getRoot()).navigate(action);
        });

        return binding.getRoot();
    }
}

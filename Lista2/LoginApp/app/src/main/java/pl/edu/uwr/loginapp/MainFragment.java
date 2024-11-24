package pl.edu.uwr.loginapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import pl.edu.uwr.loginapp.databinding.FragmentMainBinding;

public class MainFragment extends Fragment {

    private FragmentMainBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMainBinding.inflate(inflater, container, false);

        binding.btnLogin.setOnClickListener(v -> {
            NavDirections action = MainFragmentDirections.actionMainFragmentToLoginFragment();
            Navigation.findNavController(binding.getRoot()).navigate(action);
        });

        binding.btnRegister.setOnClickListener(v -> {
            NavDirections action = MainFragmentDirections.actionMainFragmentToRegisterFragment();
            Navigation.findNavController(binding.getRoot()).navigate(action);
        });

        return binding.getRoot();
    }
}

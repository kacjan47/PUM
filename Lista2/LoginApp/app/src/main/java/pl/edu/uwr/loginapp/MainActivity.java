package pl.edu.uwr.loginapp;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import pl.edu.uwr.loginapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UserManager.initialize(this);
        UserManager.initializeDefaultUsers(this);
        UserManager.initialize(this); // Inicjalizacja użytkowników
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Ustawienie NavController
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.nav_host_fragment);
        NavController navController = navHostFragment.getNavController();

        // Obsługa przycisku "Login"
        binding.mainLayout.findViewById(R.id.button_login).setOnClickListener(v -> {
            binding.mainLayout.setVisibility(View.GONE);
            binding.navHostFragment.setVisibility(View.VISIBLE);
            navController.navigate(R.id.loginFragment);
        });

        // Obsługa przycisku "Register"
        binding.mainLayout.findViewById(R.id.button_register).setOnClickListener(v -> {
            binding.mainLayout.setVisibility(View.GONE);
            binding.navHostFragment.setVisibility(View.VISIBLE);
            navController.navigate(R.id.registerFragment);
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        // Obsługa przycisku "Wstecz"
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.nav_host_fragment);
        NavController navController = navHostFragment.getNavController();

        if (!navController.popBackStack()) {
            binding.navHostFragment.setVisibility(View.GONE);
            binding.mainLayout.setVisibility(View.VISIBLE);
            return true;
        }

        return super.onSupportNavigateUp();
    }
}

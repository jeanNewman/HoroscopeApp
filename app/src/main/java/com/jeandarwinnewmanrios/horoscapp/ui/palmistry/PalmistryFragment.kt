package com.jeandarwinnewmanrios.horoscapp.ui.palmistry

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.PermissionChecker
import com.jeandarwinnewmanrios.horoscapp.R
import com.jeandarwinnewmanrios.horoscapp.databinding.FragmentLuckBinding
import com.jeandarwinnewmanrios.horoscapp.databinding.FragmentPalmistryBinding
import dagger.hilt.android.AndroidEntryPoint
import java.security.Permission

@AndroidEntryPoint
class PalmistryFragment : Fragment() {

    companion object {
        private const val CAMERA_PERMISSION = android.Manifest.permission.CAMERA
    }
    private var _binding: FragmentPalmistryBinding? = null //que siginifica _binding y binding en este caso?  //binding es una propiedad privada que devuelve el valor de _binding y _binding es una variable privada que es nula
    private val binding get() = _binding!!

    private val requestPermissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted: Boolean ->
        if (isGranted) {
            // Permission is granted. Continue the action or workflow in your app.
        } else {
            // Explain to the user that the feature is unavailable because the
            // features requires a permission that the user has denied. At the
            // same time, respect the user's decision. Don't link to system
            // settings in an effort to convince the user to change their
            // decision.
            Toast.makeText(
                requireContext(),
                "Access to the camera is required to take a picture of your palm. Please enable the camera permission in the app settings.",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (checkCameraPermission()) {

        }
        else{
            requestPermissionLauncher.launch(CAMERA_PERMISSION)
        }
    }

    private fun checkCameraPermission(): Boolean {
      return PermissionChecker.checkPermission(
            requireContext(),
            CAMERA_PERMISSION,
            android.os.Process.myPid(),
            android.os.Process.myUid(),
            requireActivity().packageName
      ) == PermissionChecker.PERMISSION_GRANTED
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentPalmistryBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

}